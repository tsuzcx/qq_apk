package com.tencent.component.network.module.report;

import android.os.Handler;
import android.os.HandlerThread;

public class CommonTaskThread
  extends HandlerThread
{
  private Handler a;
  
  public CommonTaskThread(String paramString)
  {
    super(paramString, 10);
    start();
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.CommonTaskThread
 * JD-Core Version:    0.7.0.1
 */