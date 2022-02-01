package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class ProgressControler
{
  protected long a;
  protected long b;
  public long c;
  protected WeakReference<IVideoView> d;
  protected boolean e;
  protected Timer f;
  protected Handler g;
  private SplitedProgressBar h;
  private TimerTask i;
  
  private void a()
  {
    ProgressControler.2 local2 = new ProgressControler.2(this);
    this.g.post(local2);
  }
  
  private void a(long paramLong)
  {
    long l = this.b;
    int j;
    if (l > 0L)
    {
      int k = (int)paramLong * 100 / (int)l;
      j = k;
      if (k > 100) {
        j = 100;
      }
    }
    else
    {
      j = 0;
    }
    this.h.setProgress(0, j);
  }
  
  private void b()
  {
    Timer localTimer = new Timer();
    ProgressControler.3 local3 = new ProgressControler.3(this);
    localTimer.scheduleAtFixedRate(local3, 0L, 50L);
    this.f = localTimer;
    this.i = local3;
  }
  
  public void a(long paramLong1, long paramLong2, IVideoView paramIVideoView)
  {
    this.e = false;
    this.a = paramLong1;
    this.c = this.a;
    this.b = paramLong2;
    Object localObject = this.f;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.i;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.g;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.d = new WeakReference(paramIVideoView);
      a();
      this.g.sendEmptyMessage(0);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler
 * JD-Core Version:    0.7.0.1
 */