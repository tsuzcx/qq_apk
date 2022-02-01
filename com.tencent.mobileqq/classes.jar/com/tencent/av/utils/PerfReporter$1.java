package com.tencent.av.utils;

import android.os.Handler;
import java.util.Vector;

final class PerfReporter$1
  implements Runnable
{
  public void run()
  {
    if (PerfReporter.d().size() >= PerfReporter.d().capacity())
    {
      PerfReporter.CalResult localCalResult = PerfReporter.a(PerfReporter.d());
      PerfReporter.e().a(localCalResult);
      PerfReporter.d().clear();
    }
    int i = PerfReporter.c();
    PerfReporter.d().add(Integer.valueOf(i));
    PerfReporter.f().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.1
 * JD-Core Version:    0.7.0.1
 */