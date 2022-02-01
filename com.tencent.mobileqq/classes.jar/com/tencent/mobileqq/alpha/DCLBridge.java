package com.tencent.mobileqq.alpha;

import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class DCLBridge
{
  public static void a()
  {
    if (c())
    {
      if (b()) {
        return;
      }
      try
      {
        QLog.i("DCLBridge", 1, "Initializer.auth start");
        Class.forName("com.tencent.module_dcl.Initializer").getMethod("auth", new Class[0]).invoke(null, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Initializer.auth failed: ");
        localStringBuilder.append(localException);
        QLog.e("DCLBridge", 1, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (!c()) {
      return;
    }
    try
    {
      QLog.i("DCLBridge", 1, "Initializer.init start");
      Class.forName("com.tencent.module_dcl.Initializer").getMethod("init", new Class[] { Application.class, String.class }).invoke(null, new Object[] { paramBaseApplicationImpl, "" });
      return;
    }
    catch (Exception paramBaseApplicationImpl)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Initializer.init failed: ");
      localStringBuilder.append(paramBaseApplicationImpl);
      QLog.e("DCLBridge", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean b()
  {
    try
    {
      QLog.i("DCLBridge", 1, "Initializer.isAuthSuccess");
      Object localObject = Class.forName("com.tencent.module_dcl.Initializer").getMethod("isAuthSuccess", new Class[0]).invoke(null, new Object[0]);
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Initializer.auth failed: ");
      localStringBuilder.append(localException);
      QLog.e("DCLBridge", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.alpha.DCLBridge
 * JD-Core Version:    0.7.0.1
 */