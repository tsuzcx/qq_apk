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
  private static final int MSG = 1;
  private boolean isRunning;
  private long mCountdownInterval = 1000L;
  public CopyOnWriteArrayList<CountDownTimer.CountDownTimerListener> mListeners = new CopyOnWriteArrayList();
  private boolean mPause;
  private long mStopTimeInFuture;
  
  public CountDownTimer() {}
  
  public CountDownTimer(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void addListener(CountDownTimer.CountDownTimerListener paramCountDownTimerListener)
  {
    long l = SystemClock.elapsedRealtime();
    if (CountDownTimer.CountDownTimerListener.access$000(paramCountDownTimerListener) > l)
    {
      this.mListeners.add(paramCountDownTimerListener);
      setTime(CountDownTimer.CountDownTimerListener.access$000(paramCountDownTimerListener) - l);
      return;
    }
    paramCountDownTimerListener.onFinish();
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        l = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
        if (l <= 0L)
        {
          onFinish();
          return;
        }
        if (l < this.mCountdownInterval)
        {
          sendMessageDelayed(obtainMessage(1), l);
          continue;
        }
        l = SystemClock.elapsedRealtime();
      }
      finally {}
      notifyTrick();
      for (long l = l + this.mCountdownInterval - SystemClock.elapsedRealtime(); l < 0L; l += this.mCountdownInterval) {}
      sendMessageDelayed(obtainMessage(1), l);
    }
  }
  
  public void notifyFinish()
  {
    if (this.mListeners.size() < 2) {
      stop();
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((CountDownTimer.CountDownTimerListener)localIterator.next()).onFinish();
    }
  }
  
  public void notifyTrick()
  {
    if (this.mListeners.isEmpty()) {
      stop();
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((CountDownTimer.CountDownTimerListener)localIterator.next()).tick();
    }
  }
  
  public void onFinish()
  {
    this.isRunning = false;
    notifyTrick();
    notifyFinish();
  }
  
  public void pause()
  {
    removeMessages(1);
    this.mPause = true;
  }
  
  public void removeListener(CountDownTimer.CountDownTimerListener paramCountDownTimerListener)
  {
    this.mListeners.remove(paramCountDownTimerListener);
  }
  
  public void resume()
  {
    this.mPause = false;
    if (this.mStopTimeInFuture >= SystemClock.elapsedRealtime()) {
      sendMessage(obtainMessage(1));
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (!this.mPause) {
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
  
  public void setTime(long paramLong)
  {
    this.mStopTimeInFuture = Math.max(SystemClock.elapsedRealtime() + 1000L * paramLong, this.mStopTimeInFuture);
    start();
  }
  
  public void start()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.isRunning;
        if (bool) {
          return;
        }
        if (this.mStopTimeInFuture <= SystemClock.elapsedRealtime())
        {
          onFinish();
          continue;
        }
        this.isRunning = true;
      }
      finally {}
      sendMessage(obtainMessage(1));
    }
  }
  
  public void stop()
  {
    this.isRunning = false;
    removeMessages(1);
    this.mListeners.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photopreview.CountDownTimer
 * JD-Core Version:    0.7.0.1
 */