package com.tencent.mobileqq.activity.framebusiness;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.lang.ref.WeakReference;

final class QCircleInjectImpl$3
  implements QzoneConfig.QzoneConfigChangeListener
{
  QCircleInjectImpl$3(FrameFragment paramFrameFragment) {}
  
  public void onConfigChange()
  {
    if (this.a.getActivity() == null) {
      return;
    }
    QCircleInjectImpl.a(new WeakReference(this.a));
    this.a.getActivity().runOnUiThread(new QCircleInjectImpl.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.3
 * JD-Core Version:    0.7.0.1
 */