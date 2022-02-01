package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;

final class HostFaceUtils$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  HostFaceUtils$1(String paramString, QCircleFaceBitmapListener paramQCircleFaceBitmapListener) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(QCircleServiceImpl.getAppInterface(), 1, 4, String.valueOf(this.val$uin));
      this.val$listener.getFaceBitmap(localFaceDrawable.getLoadedBitmap());
      return;
    }
    this.val$listener.getFaceBitmap(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils.1
 * JD-Core Version:    0.7.0.1
 */