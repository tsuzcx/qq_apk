package com.tencent.falco.base.floatwindow.permission.romutils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class OppoRomUtils
  extends BaseRomUtils
{
  private static final String TAG = "OppoRomUtils";
  
  public static void applyPermission(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setFlags(268435456);
      localIntent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.OppoRomUtils
 * JD-Core Version:    0.7.0.1
 */