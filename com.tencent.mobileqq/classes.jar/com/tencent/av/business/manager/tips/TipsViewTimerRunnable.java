package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.data.AvTipsItemBase;

public class TipsViewTimerRunnable
  implements Runnable
{
  VideoAppInterface a;
  Object b = new Object();
  volatile long c = 0L;
  volatile AvTipsItemBase d = null;
  volatile long e = 0L;
  volatile AvTipsItemBase f = null;
  volatile boolean g = false;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  private boolean a(AvTipsItemBase paramAvTipsItemBase, long paramLong)
  {
    int i = 0;
    if (paramAvTipsItemBase == null) {
      return false;
    }
    if (paramAvTipsItemBase.g()) {
      return true;
    }
    if (SystemClock.elapsedRealtime() - paramLong >= paramAvTipsItemBase.c() * 1000) {
      i = 1;
    }
    return i ^ 0x1;
  }
  
  private void e()
  {
    VideoAppInterface localVideoAppInterface = this.a;
    if (localVideoAppInterface == null) {
      return;
    }
    localVideoAppInterface.a().removeCallbacks(this);
    if (!this.g) {
      return;
    }
    this.a.a().postDelayed(this, 1000L);
  }
  
  public void a()
  {
    AvTipsItemBase localAvTipsItemBase = this.d;
    this.d = null;
    this.c = 0L;
    TipsManager localTipsManager = (TipsManager)this.a.c(11);
    if (localTipsManager != null) {
      localTipsManager.b(localAvTipsItemBase);
    }
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return false;
    }
    this.d = paramAvTipsItemBase;
    if (!paramAvTipsItemBase.g())
    {
      this.c = SystemClock.elapsedRealtime();
      this.g = true;
      e();
      return true;
    }
    this.c = 0L;
    return true;
  }
  
  public void b()
  {
    AvTipsItemBase localAvTipsItemBase = this.f;
    this.f = null;
    this.e = 0L;
    TipsManager localTipsManager = (TipsManager)this.a.c(11);
    if (localTipsManager != null) {
      localTipsManager.c(localAvTipsItemBase);
    }
  }
  
  public boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return false;
    }
    this.f = paramAvTipsItemBase;
    if (!paramAvTipsItemBase.g())
    {
      this.e = SystemClock.elapsedRealtime();
      this.g = true;
      e();
      return true;
    }
    this.e = 0L;
    return true;
  }
  
  public AvTipsItemBase c()
  {
    return this.d;
  }
  
  public AvTipsItemBase d()
  {
    return this.f;
  }
  
  public void run()
  {
    boolean bool;
    if (a(this.d, this.c))
    {
      bool = true;
    }
    else
    {
      a();
      bool = false;
    }
    if (a(this.f, this.e)) {
      bool = true;
    } else {
      b();
    }
    this.g = bool;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */