package com.tencent.mobileqq.activity.photopreview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CountDownTimer
  extends Handler
{
  public CopyOnWriteArrayList<CountDownTimer.CountDownTimerListener> a = new CopyOnWriteArrayList();
  private long b = 1000L;
  private long c;
  private boolean d = false;
  private boolean e = false;
  
  public CountDownTimer() {}
  
  public CountDownTimer(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    this.e = false;
    b();
    c();
  }
  
  public void a(long paramLong)
  {
    this.c = Math.max(SystemClock.elapsedRealtime() + paramLong * 1000L, this.c);
    f();
  }
  
  public void a(CountDownTimer.CountDownTimerListener paramCountDownTimerListener)
  {
    long l = SystemClock.elapsedRealtime();
    if (CountDownTimer.CountDownTimerListener.a(paramCountDownTimerListener) > l)
    {
      this.a.add(paramCountDownTimerListener);
      a(CountDownTimer.CountDownTimerListener.a(paramCountDownTimerListener) - l);
      return;
    }
    paramCountDownTimerListener.b();
  }
  
  public void b()
  {
    if (this.a.isEmpty()) {
      g();
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((CountDownTimer.CountDownTimerListener)localIterator.next()).a();
    }
  }
  
  public void b(CountDownTimer.CountDownTimerListener paramCountDownTimerListener)
  {
    this.a.remove(paramCountDownTimerListener);
  }
  
  public void c()
  {
    if (this.a.size() < 2) {
      g();
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((CountDownTimer.CountDownTimerListener)localIterator.next()).b();
    }
  }
  
  public void d()
  {
    removeMessages(1);
    this.d = true;
  }
  
  public void e()
  {
    this.d = false;
    if (this.c >= SystemClock.elapsedRealtime()) {
      sendMessage(obtainMessage(1));
    }
  }
  
  public void f()
  {
    try
    {
      boolean bool = this.e;
      if (bool) {
        return;
      }
      if (this.c <= SystemClock.elapsedRealtime())
      {
        a();
        return;
      }
      this.e = true;
      sendMessage(obtainMessage(1));
      return;
    }
    finally {}
  }
  
  public void g()
  {
    this.e = false;
    removeMessages(1);
    this.a.clear();
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      long l = this.c - SystemClock.elapsedRealtime();
      if (l <= 0L)
      {
        a();
      }
      else if (l < this.b)
      {
        sendMessageDelayed(obtainMessage(1), l);
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        b();
        for (l = l + this.b - SystemClock.elapsedRealtime(); l < 0L; l += this.b) {}
        sendMessageDelayed(obtainMessage(1), l);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramMessage;
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (!this.d) {
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photopreview.CountDownTimer
 * JD-Core Version:    0.7.0.1
 */