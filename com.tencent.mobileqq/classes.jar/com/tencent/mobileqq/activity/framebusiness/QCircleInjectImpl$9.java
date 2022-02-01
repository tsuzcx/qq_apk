package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.app.FrameFragment;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.lang.ref.WeakReference;

final class QCircleInjectImpl$9
  implements QzoneConfig.QzoneConfigChangeListener
{
  QCircleInjectImpl$9(FrameFragment paramFrameFragment) {}
  
  public void onConfigChange()
  {
    if (this.a.C() == null) {
      return;
    }
    QCircleInjectImpl.a(new WeakReference(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.9
 * JD-Core Version:    0.7.0.1
 */