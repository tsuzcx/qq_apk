package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class i
{
  public static int a(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        f.a("WeUIUtil", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public static Point a(Context paramContext)
  {
    Point localPoint = new Point();
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
      label108:
      break label108;
    }
    paramContext.getSize(localPoint);
    return localPoint;
    paramContext.getSize(localPoint);
    return localPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */