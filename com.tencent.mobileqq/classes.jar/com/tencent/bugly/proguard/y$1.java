package com.tencent.bugly.proguard;

import java.io.File;

final class y$1
  implements Runnable
{
  public final void run()
  {
    synchronized ()
    {
      label53:
      do
      {
        try
        {
          if (y.c() != null) {
            continue;
          }
          y.a(new y.a(y.d()));
          if (y.c().a(y.e().toString()))
          {
            y.e().setLength(0);
            y.b(false);
          }
        }
        catch (Throwable localThrowable)
        {
          break label53;
        }
        return;
      } while ((y.a.a(y.c()) != null) && (y.a.a(y.c()).length() + y.e().length() <= y.a.b(y.c())));
      y.a.c(y.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y.1
 * JD-Core Version:    0.7.0.1
 */