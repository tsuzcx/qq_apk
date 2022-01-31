package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.view.ViewGroup;

class ViolaVideoView$7
  implements Runnable
{
  ViolaVideoView$7(ViolaVideoView paramViolaVideoView) {}
  
  public void run()
  {
    if (ViolaVideoView.a(this.this$0).c())
    {
      ViolaVideoView.a(this.this$0, 2, null);
      return;
    }
    if (ViolaVideoView.a(this.this$0).getVisibility() == 0)
    {
      ViolaVideoView.a(this.this$0, 5, null);
      return;
    }
    ViolaVideoView.a(this.this$0, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView.7
 * JD-Core Version:    0.7.0.1
 */