package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;

final class QCircleInjectImpl$5
  implements IBackEventListener
{
  QCircleInjectImpl$5(FrameFragment paramFrameFragment) {}
  
  public void onBackEvent(boolean paramBoolean, String paramString)
  {
    if ("qcircle-app".equals(paramString)) {
      QCircleInjectImpl.a(this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.5
 * JD-Core Version:    0.7.0.1
 */