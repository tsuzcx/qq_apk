package com.tencent.luggage.ui;

import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WmpfPresentationActivityHelper$d
  implements Runnable
{
  public static final d a = new d();
  
  public final void run()
  {
    for (;;)
    {
      ((Function0)WmpfPresentationActivityHelper.b(WmpfPresentationActivityHelper.a).take()).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.d
 * JD-Core Version:    0.7.0.1
 */