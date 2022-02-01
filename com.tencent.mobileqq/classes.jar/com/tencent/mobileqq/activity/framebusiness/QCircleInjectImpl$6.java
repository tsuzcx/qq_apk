package com.tencent.mobileqq.activity.framebusiness;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.lang.ref.WeakReference;

final class QCircleInjectImpl$6
  implements QzoneConfig.QzoneConfigChangeListener
{
  QCircleInjectImpl$6(FrameFragment paramFrameFragment) {}
  
  public void onConfigChange()
  {
    if (this.a.a() == null) {
      return;
    }
    QCircleInjectImpl.a(new WeakReference(this.a));
    this.a.getActivity().runOnUiThread(new QCircleInjectImpl.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.6
 * JD-Core Version:    0.7.0.1
 */