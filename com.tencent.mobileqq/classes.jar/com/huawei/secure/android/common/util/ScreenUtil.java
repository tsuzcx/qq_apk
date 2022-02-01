package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;

public class ScreenUtil
{
  private static final String TAG = "ScreenUtil";
  private static final int t = 524288;
  
  private static void a(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity.getWindow().addFlags(paramInt);
      return;
    }
    LogsUtil.e("", "activity is null");
  }
  
  private static void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity.getWindow().clearFlags(paramInt);
      return;
    }
    LogsUtil.e("", "activity is null");
  }
  
  public static void disableScreenshots(Activity paramActivity)
  {
    a(paramActivity, 8192);
  }
  
  public static void enableScreenshots(Activity paramActivity)
  {
    b(paramActivity, 8192);
  }
  
  public static void hideOverlayWindows(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      paramActivity = paramActivity.getWindow();
      Method localMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", new Class[] { Integer.TYPE });
      AccessController.doPrivileged(new ScreenUtil.a(localMethod));
      localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(524288) });
      return;
    }
    catch (ClassNotFoundException paramActivity)
    {
      break label92;
    }
    catch (NoSuchMethodException paramActivity)
    {
      break label84;
    }
    catch (InvocationTargetException paramActivity)
    {
      break label76;
    }
    catch (IllegalAccessException paramActivity)
    {
      label68:
      break label68;
    }
    LogsUtil.e("ScreenUtil", "hideOverlayWindows IllegalAccessException");
    return;
    label76:
    LogsUtil.e("ScreenUtil", "hideOverlayWindows InvocationTargetException");
    return;
    label84:
    LogsUtil.e("ScreenUtil", "hideOverlayWindows NoSuchMethodException");
    return;
    label92:
    LogsUtil.e("ScreenUtil", "hideOverlayWindows ClassNotFoundException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */