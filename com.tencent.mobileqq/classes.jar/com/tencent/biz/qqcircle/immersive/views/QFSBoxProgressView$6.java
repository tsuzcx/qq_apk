package com.tencent.biz.qqcircle.immersive.views;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QFSBoxProgressView$6
  extends QCirclePicStateListener
{
  QFSBoxProgressView$6(QFSBoxProgressView paramQFSBoxProgressView) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSBoxProgressView", 1, new Object[] { "[setLocalCover] loadImage state: ", Integer.valueOf(paramInt) });
    }
    if (paramInt != 6)
    {
      QLog.e("QFSBoxProgressView", 1, "[setLocalCover] loadImage failed.");
      return;
    }
    paramOption = new BitmapDrawable(QFSBoxProgressView.c(this.a).getResources(), paramOption.getResultBitMap());
    RFThreadManager.getUIHandler().post(new QFSBoxProgressView.6.1(this, paramOption));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSBoxProgressView.6
 * JD-Core Version:    0.7.0.1
 */