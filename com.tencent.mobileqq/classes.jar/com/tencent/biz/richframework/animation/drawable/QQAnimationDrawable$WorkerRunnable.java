package com.tencent.biz.richframework.animation.drawable;

import android.os.Process;
import android.os.SystemClock;

class QQAnimationDrawable$WorkerRunnable
  implements Runnable
{
  private int a;
  private long b;
  
  public QQAnimationDrawable$WorkerRunnable(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    long l = SystemClock.uptimeMillis();
    QQAnimationDrawable localQQAnimationDrawable = this.this$0;
    localQQAnimationDrawable.c = localQQAnimationDrawable.b(false, this.a);
    QQAnimationDrawable.a(this.this$0, this.a);
    if ((this.this$0.b == null) && (this.a == 0))
    {
      localQQAnimationDrawable = this.this$0;
      localQQAnimationDrawable.b = localQQAnimationDrawable.c;
    }
    if (QQAnimationDrawable.a(this.this$0) != null) {
      QQAnimationDrawable.a(this.this$0).a(this.a);
    }
    localQQAnimationDrawable = this.this$0;
    localQQAnimationDrawable.scheduleSelf(localQQAnimationDrawable, SystemClock.uptimeMillis() + Math.max(this.b - l, 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.WorkerRunnable
 * JD-Core Version:    0.7.0.1
 */