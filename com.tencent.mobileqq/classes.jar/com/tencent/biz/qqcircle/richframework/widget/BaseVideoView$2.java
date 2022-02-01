package com.tencent.biz.qqcircle.richframework.widget;

import android.widget.SeekBar;

class BaseVideoView$2
  implements Runnable
{
  BaseVideoView$2(BaseVideoView paramBaseVideoView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.getProgressBar() != null) {
      this.this$0.getProgressBar().setProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */