package com.tencent.biz.qqcircle.flutter;

import android.os.Handler;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleVistaImageImpl$1
  extends QCirclePicStateListener
{
  QCircleVistaImageImpl$1(QCircleVistaImageImpl paramQCircleVistaImageImpl, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback, String paramString) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    paramOption = paramOption.getResultBitMap();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadUrl] state=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", bitmap=");
      localStringBuilder.append(paramOption);
      QLog.d("QCircleVistaImageImpl", 2, localStringBuilder.toString());
    }
    if ((6 == paramInt) && (paramOption != null) && (this.a != null)) {
      RFThreadManager.getUIHandler().post(new QCircleVistaImageImpl.1.1(this, paramOption));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleVistaImageImpl.1
 * JD-Core Version:    0.7.0.1
 */