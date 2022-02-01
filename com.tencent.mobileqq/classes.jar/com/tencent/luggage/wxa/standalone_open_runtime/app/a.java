package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class a
{
  private static Object a(Context paramContext)
  {
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null) {
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    return ((Field)localObject).get(paramContext);
  }
  
  private static void a(Application paramApplication)
  {
    paramApplication = a(paramApplication);
    a.a.a = paramApplication;
    Field localField = paramApplication.getClass().getDeclaredField("mH");
    localField.setAccessible(true);
    a.a.b = (Handler)localField.get(paramApplication);
  }
  
  static boolean a()
  {
    Object localObject = a.a.a;
    boolean bool2 = true;
    if ((localObject == null) || (a.a.b == null)) {
      try
      {
        a((Application)r.a().getApplicationContext());
      }
      catch (Throwable localThrowable)
      {
        o.b("MicroMsg.AppBrandProcessSuicideLogic.ActivityThreadHackDetector", "hack ActivityThread failed %s", new Object[] { localThrowable });
      }
    }
    Handler localHandler = a.a.b;
    if (localHandler != null)
    {
      boolean bool1 = bool2;
      if (!localHandler.hasMessages(100))
      {
        bool1 = bool2;
        if (!localHandler.hasMessages(126)) {
          if (Build.VERSION.SDK_INT == 28)
          {
            bool1 = bool2;
            if (localHandler.hasMessages(160)) {}
          }
          else
          {
            if (localHandler.hasMessages(159)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.a
 * JD-Core Version:    0.7.0.1
 */