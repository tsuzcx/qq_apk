package com.tencent.mobileqq.ark.dict;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class ArkRecommendLogic$ArkWordSegmentThread
{
  private HandlerThread a;
  private Handler b;
  
  public Handler a()
  {
    try
    {
      if (this.a == null)
      {
        this.a = ThreadManager.newFreeHandlerThread("ArkAnalyseThread", -1);
        this.a.start();
        this.b = new Handler(this.a.getLooper());
      }
      Handler localHandler = this.b;
      return localHandler;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (b())
    {
      paramRunnable.run();
      return;
    }
    new ArkRecommendLogic.ArkWordSegmentThread.BlockingRunnable(this, paramRunnable).a();
  }
  
  public boolean b()
  {
    return Looper.myLooper() == a().getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkRecommendLogic.ArkWordSegmentThread
 * JD-Core Version:    0.7.0.1
 */