package com.tencent.mobileqq.activity.framebusiness;

import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;

class QCircleInjectImpl$2
  implements Runnable
{
  QCircleInjectImpl$2(QCircleInjectImpl paramQCircleInjectImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    if ((QCircleInjectImpl.a(this.this$0) != null) && (QCircleInjectImpl.a(this.this$0).isShowing()) && (!this.a.getActivity().isFinishing())) {
      QCircleInjectImpl.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */