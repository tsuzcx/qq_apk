package com.tencent.luggage.wxa.ao;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class x$1
  implements ThreadFactory
{
  x$1(String paramString) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.x.1
 * JD-Core Version:    0.7.0.1
 */