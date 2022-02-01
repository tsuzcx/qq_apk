package com.tencent.luggage.wxa.re;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.wxa.hg.g;
import java.lang.reflect.Method;

public class d
{
  private static int a(Context paramContext)
  {
    return g.a(paramContext);
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    if (!a()) {
      return;
    }
    if (paramActivity.getResources().getConfiguration().orientation == 2) {
      return;
    }
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().addFlags(2048);
    paramView.setPadding(0, a(paramActivity), 0, 0);
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    if (Build.DEVICE.equals("mx2")) {
      return true;
    }
    if ((!Build.DEVICE.equals("mx")) && (Build.DEVICE.equals("m9"))) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.d
 * JD-Core Version:    0.7.0.1
 */