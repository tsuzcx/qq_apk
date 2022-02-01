package com.tencent.biz.subscribe.framework;

import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.videostory.EventControlUtils.OnDebounceListener;
import com.tencent.superplayer.api.ISuperPlayer;

class BaseVideoView$6
  implements EventControlUtils.OnDebounceListener
{
  BaseVideoView$6(BaseVideoView paramBaseVideoView, SeekBar paramSeekBar) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = this.a.getProgress();
    localMessage.arg2 = ((int)this.b.getSuperPlayer().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (this.b.o()) {
      this.b.a(this.a.getProgress());
    }
    this.b.getMainHandler().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.6
 * JD-Core Version:    0.7.0.1
 */