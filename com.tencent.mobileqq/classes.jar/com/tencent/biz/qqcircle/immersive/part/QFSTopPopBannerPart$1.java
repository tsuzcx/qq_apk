package com.tencent.biz.qqcircle.immersive.part;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QFSTopPopBannerPart$1
  extends QCirclePicStateListener
{
  QFSTopPopBannerPart$1(QFSTopPopBannerPart paramQFSTopPopBannerPart) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSTopPopBannerPart", 1, new Object[] { "[setLocalCover] loadImage state: ", Integer.valueOf(paramInt) });
    }
    if (paramInt != 6)
    {
      QLog.e("QFSTopPopBannerPart", 1, "[setLocalCover] loadImage failed.");
      return;
    }
    paramOption = new BitmapDrawable(QFSTopPopBannerPart.a(this.a).getResources(), paramOption.getResultBitMap());
    RFThreadManager.getUIHandler().post(new QFSTopPopBannerPart.1.1(this, paramOption));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.1
 * JD-Core Version:    0.7.0.1
 */