package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import java.util.concurrent.ExecutorService;

public class SingleFileThreadExecutor
  extends ThreadManagerExecutor
{
  SingleFileThreadExecutor(int paramInt)
  {
    super(paramInt);
  }
  
  public static ExecutorService a()
  {
    return new SingleFileThreadExecutor(64);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    ThreadManagerV2.executeOnFileThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SingleFileThreadExecutor
 * JD-Core Version:    0.7.0.1
 */