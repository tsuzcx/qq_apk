package com.tencent.mm.plugin.appbrand.page;

import androidx.annotation.NonNull;
import java.util.LinkedList;

final class bm$a
  implements Runnable
{
  @NonNull
  private final Runnable b;
  
  private bm$a(bm parambm, @NonNull Runnable paramRunnable)
  {
    this.b = paramRunnable;
    bm.b(parambm).add(this);
  }
  
  public void run()
  {
    bm.b(this.a).remove(this);
    this.b.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.a
 * JD-Core Version:    0.7.0.1
 */