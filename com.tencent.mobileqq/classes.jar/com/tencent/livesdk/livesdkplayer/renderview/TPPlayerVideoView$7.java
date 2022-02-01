package com.tencent.livesdk.livesdkplayer.renderview;

import android.view.View;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPlayerVideoView$7
  implements Runnable
{
  TPPlayerVideoView$7(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void run()
  {
    try
    {
      ((View)TPPlayerVideoView.access$1100(this.this$0)).requestLayout();
      return;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", "setDegree not in main looper ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView.7
 * JD-Core Version:    0.7.0.1
 */