package com.tencent.avgame.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DisplayUtil
{
  public static int a(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        QLog.e("tag", 1, paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        QLog.e("tag", 1, paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        QLog.e("tag", 1, paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        QLog.e("tag", 1, paramContext.getMessage());
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */