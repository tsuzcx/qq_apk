package com.tencent.biz.subscribe.framework;

import android.widget.SeekBar;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;

class BaseVideoView$5
  implements Runnable
{
  BaseVideoView$5(BaseVideoView paramBaseVideoView) {}
  
  public void run()
  {
    if (BaseVideoView.d(this.this$0) != null) {
      BaseVideoView.d(this.this$0).setXYaxis(0);
    }
    if (this.this$0.getProgressBar() != null) {
      this.this$0.getProgressBar().setMax((int)this.this$0.getSuperPlayer().getDurationMs());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.5
 * JD-Core Version:    0.7.0.1
 */