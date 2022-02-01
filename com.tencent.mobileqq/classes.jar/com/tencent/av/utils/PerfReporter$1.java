package com.tencent.av.utils;

import android.os.Handler;
import java.util.Vector;

final class PerfReporter$1
  implements Runnable
{
  public void run()
  {
    if (PerfReporter.a().size() >= PerfReporter.a().capacity())
    {
      PerfReporter.CalResult localCalResult = PerfReporter.a(PerfReporter.a());
      PerfReporter.a().a(localCalResult);
      PerfReporter.a().clear();
    }
    int i = PerfReporter.a();
    PerfReporter.a().add(Integer.valueOf(i));
    PerfReporter.a().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.1
 * JD-Core Version:    0.7.0.1
 */