package com.tencent.luggage.wxa.g;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.wxa.f.e;
import java.lang.reflect.Method;

public class b
{
  private static WindowManager a;
  
  public static int a(int paramInt)
  {
    return (paramInt - b(e.a().e()) + 360) % 360;
  }
  
  public static Point a(Context paramContext)
  {
    Point localPoint = new Point();
    if (paramContext == null) {
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      return localPoint;
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    paramContext.getSize(localPoint);
    return localPoint;
    paramContext.getSize(localPoint);
    return localPoint;
  }
  
  public static int b(Context paramContext)
  {
    if (a == null) {
      a = (WindowManager)paramContext.getApplicationContext().getSystemService("window");
    }
    paramContext = a;
    if (paramContext == null) {
      return 0;
    }
    int i = paramContext.getDefaultDisplay().getRotation();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return 0;
          }
          return 270;
        }
        return 180;
      }
      return 90;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.g.b
 * JD-Core Version:    0.7.0.1
 */