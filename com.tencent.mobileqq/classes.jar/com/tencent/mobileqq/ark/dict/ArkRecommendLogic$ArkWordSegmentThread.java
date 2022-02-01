package com.tencent.mobileqq.ark.dict;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class ArkRecommendLogic$ArkWordSegmentThread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  public Handler a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ArkAnalyseThread", -1);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a())
    {
      paramRunnable.run();
      return;
    }
    new ArkRecommendLogic.ArkWordSegmentThread.BlockingRunnable(this, paramRunnable).a();
  }
  
  public boolean a()
  {
    return Looper.myLooper() == a().getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkRecommendLogic.ArkWordSegmentThread
 * JD-Core Version:    0.7.0.1
 */