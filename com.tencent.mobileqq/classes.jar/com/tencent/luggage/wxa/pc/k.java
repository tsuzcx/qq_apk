package com.tencent.luggage.wxa.pc;

import androidx.annotation.NonNull;
import java.util.concurrent.FutureTask;

public class k
  implements Runnable
{
  private final FutureTask<?> a;
  
  public k(@NonNull Runnable paramRunnable)
  {
    this.a = new FutureTask(paramRunnable, Integer.valueOf(0));
  }
  
  public void run()
  {
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.k
 * JD-Core Version:    0.7.0.1
 */