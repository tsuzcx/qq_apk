package com.tencent.mobileqq.activity.framebusiness;

import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;

final class QCircleInjectImpl$2
  implements Runnable
{
  QCircleInjectImpl$2(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    if ((QCircleInjectImpl.f() != null) && (QCircleInjectImpl.f().isShowing()))
    {
      FrameFragment localFrameFragment = this.a;
      if ((localFrameFragment != null) && (!localFrameFragment.getActivity().isFinishing())) {
        QCircleInjectImpl.f().dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */