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
    if (BaseVideoView.a(this.this$0) != null) {
      BaseVideoView.a(this.this$0).setXYaxis(0);
    }
    if (this.this$0.a() != null) {
      this.this$0.a().setMax((int)this.this$0.a().getDurationMs());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.5
 * JD-Core Version:    0.7.0.1
 */