package com.tencent.mobileqq.app;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;

class FrameHelperActivity$8
  implements Runnable
{
  FrameHelperActivity$8(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().app == null)) {}
    do
    {
      return;
      this.this$0.t();
    } while (this.this$0.a == null);
    this.this$0.a.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.8
 * JD-Core Version:    0.7.0.1
 */