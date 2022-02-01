package com.tencent.common.app;

import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class IScreenShotShareHandler
  implements IActivityDispatchCallback
{
  public static IScreenShotShareHandler a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (IScreenShotShareHandler)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context paramContext)
  {
    IScreenShotShareHandler localIScreenShotShareHandler = a;
    if (localIScreenShotShareHandler != null) {
      localIScreenShotShareHandler.c(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    IScreenShotShareHandler localIScreenShotShareHandler = a;
    if (localIScreenShotShareHandler != null) {
      localIScreenShotShareHandler.d(paramContext);
    }
  }
  
  public abstract void c(Context paramContext);
  
  public abstract void d(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.IScreenShotShareHandler
 * JD-Core Version:    0.7.0.1
 */