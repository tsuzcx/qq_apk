package com.tencent.luggage.wxa.gq;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class j
  implements ThreadFactory
{
  private final ThreadGroup a;
  private final AtomicInteger b = new AtomicInteger(1);
  private final String c = "audio_mix_thread#";
  private String d = "";
  
  public j()
  {
    this.a = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
  }
  
  public j(String paramString1, String paramString2)
  {
    this.a = new ThreadGroup(paramString1);
    this.d = paramString2;
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    if (TextUtils.isEmpty(this.d)) {
      this.d = "audio_mix_thread#";
    }
    ThreadGroup localThreadGroup = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.b.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.j
 * JD-Core Version:    0.7.0.1
 */