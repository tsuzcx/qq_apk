package com.tencent.luggage.wxa.kg;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class n$b
  extends TimerTask
{
  public n$b(Function1 paramFunction1) {}
  
  public void run()
  {
    TimerTask localTimerTask = (TimerTask)this;
    this.a.invoke(Boolean.valueOf(false));
    localTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.n.b
 * JD-Core Version:    0.7.0.1
 */