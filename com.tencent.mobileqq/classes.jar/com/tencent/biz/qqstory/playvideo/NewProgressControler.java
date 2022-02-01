package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.ProgressListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

public class NewProgressControler
  implements ProgressVideoViewWrapper.ProgressListener
{
  protected long a;
  protected long b;
  public long c;
  protected WeakReference<IVideoView> d = new WeakReference(null);
  protected boolean e = false;
  protected Timer f;
  protected Handler g = new NewProgressControler.1(this, Looper.getMainLooper());
  private SplitedProgressBar h;
  private TimerTask i;
  
  public NewProgressControler(SplitedProgressBar paramSplitedProgressBar)
  {
    if (paramSplitedProgressBar != null)
    {
      this.h = paramSplitedProgressBar;
      this.h.setTotalCount(1);
      return;
    }
    throw new InvalidParameterException("ProgressControler: progressBar is null");
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
  
  private void a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.c = this.a;
    this.b = paramLong2;
    a(paramLong1);
    SLog.a("Q.qqstory.player:NewProgressControler", "seek ft:%d , ed:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  private void c()
  {
    if (this.e)
    {
      SLog.d("Q.qqstory.player:NewProgressControler", "progress already canceled. can't start.");
      return;
    }
    this.e = false;
    f();
    if (this.b < 0L)
    {
      d();
      return;
    }
    e();
  }
  
  private void d()
  {
    NewProgressControler.2 local2 = new NewProgressControler.2(this);
    this.g.post(local2);
  }
  
  private void e()
  {
    try
    {
      Timer localTimer = new Timer();
      NewProgressControler.3 local3 = new NewProgressControler.3(this);
      localTimer.scheduleAtFixedRate(local3, 0L, 50L);
      this.f = localTimer;
      this.i = local3;
      SLog.b("Q.qqstory.player:NewProgressControler", "startTimer");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.g != null) {
        this.g.removeCallbacksAndMessages(null);
      }
      if (this.f != null) {
        this.f.cancel();
      }
      if (this.i != null) {
        this.i.cancel();
      }
      SLog.b("Q.qqstory.player:NewProgressControler", "cancelTimer");
      return;
    }
    finally {}
  }
  
  public void a()
  {
    this.e = true;
    b();
  }
  
  public void a(long paramLong1, long paramLong2, IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.d.get())
    {
      SLog.a("Q.qqstory.player:NewProgressControler", "progress callback :onSeek , ft:%d , et:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      a(paramLong1, paramLong2);
    }
  }
  
  public void a(IVideoView paramIVideoView)
  {
    boolean bool = paramIVideoView instanceof ProgressVideoViewWrapper;
    IVideoView localIVideoView;
    if (bool) {
      localIVideoView = ((ProgressVideoViewWrapper)paramIVideoView).m();
    } else {
      localIVideoView = paramIVideoView;
    }
    if (localIVideoView == this.d.get())
    {
      SLog.b("Q.qqstory.player:NewProgressControler", "cannot set the same video view");
      return;
    }
    this.d = new WeakReference(localIVideoView);
    if (bool) {
      ((ProgressVideoViewWrapper)paramIVideoView).a(this);
    } else {
      SLog.b("Yarkey", "cannot set the same video view");
    }
    f();
    a(0L, paramIVideoView.h());
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.player:NewProgressControler", "pauseProgressBar");
    f();
  }
  
  public void b(IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.d.get())
    {
      SLog.b("Q.qqstory.player:NewProgressControler", "progress callback :onStart");
      c();
      return;
    }
    SLog.b("Yarkey", "onStart ignore !!");
  }
  
  public void c(IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.d.get())
    {
      SLog.b("Q.qqstory.player:NewProgressControler", "progress callback :onPause");
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler
 * JD-Core Version:    0.7.0.1
 */