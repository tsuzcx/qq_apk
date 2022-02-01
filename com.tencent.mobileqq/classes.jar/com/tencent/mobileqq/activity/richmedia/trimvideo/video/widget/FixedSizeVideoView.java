package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FixedSizeVideoView
  extends VideoView
  implements Handler.Callback
{
  FixedSizeVideoView.OnTrimVDPlayCompelteListener a;
  private int b = -1;
  private Handler c = new Handler(Looper.getMainLooper(), this);
  private int d;
  private int e;
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener(new FixedSizeVideoView.1(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener(new FixedSizeVideoView.2(this));
  }
  
  public int getPlayDuration()
  {
    return this.b;
  }
  
  public int getStartMillisec()
  {
    return this.e;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = this.a;
      if (paramMessage != null) {
        paramMessage.a(this, this.e, this.b);
      }
    }
    return true;
  }
  
  public void pause()
  {
    super.pause();
    this.c.removeMessages(0);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFixVDPlayCompelteListener(FixedSizeVideoView.OnTrimVDPlayCompelteListener paramOnTrimVDPlayCompelteListener)
  {
    if (paramOnTrimVDPlayCompelteListener != null) {
      this.a = paramOnTrimVDPlayCompelteListener;
    }
  }
  
  public void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      int j = paramInt2 + paramInt1;
      this.d = j;
      if (j > i) {
        this.d = i;
      }
      this.e = paramInt1;
      this.b = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.d - i;
    if (i >= 0)
    {
      super.start();
      this.c.removeMessages(0);
      this.c.sendEmptyMessageDelayed(0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */