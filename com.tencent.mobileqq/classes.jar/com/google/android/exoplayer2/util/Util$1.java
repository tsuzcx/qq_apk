package com.google.android.exoplayer2.util;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class Util$1
  implements ThreadFactory
{
  Util$1(String paramString) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.val$threadName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.Util.1
 * JD-Core Version:    0.7.0.1
 */