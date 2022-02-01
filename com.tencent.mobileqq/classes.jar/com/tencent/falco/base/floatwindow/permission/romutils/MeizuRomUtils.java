package com.tencent.falco.base.floatwindow.permission.romutils;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.floatwindow.utils.Logger;
import org.jetbrains.annotations.NotNull;

public class MeizuRomUtils
  extends BaseRomUtils
{
  private static final String TAG = "MeizuRomUtils";
  
  public static void applyPermission(@NotNull Fragment paramFragment)
  {
    try
    {
      Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
      localIntent.putExtra("packageName", paramFragment.getActivity().getPackageName());
      paramFragment.startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception localException) {}
    try
    {
      Logger.e("MeizuRomUtils", "获取悬浮窗权限, 打开AppSecActivity失败");
      localException.printStackTrace();
      FWPermission.commonPermissionApplyInternal(paramFragment);
      return;
    }
    catch (Exception paramFragment)
    {
      label49:
      break label49;
    }
    Logger.e("MeizuRomUtils", "获取悬浮窗权限失败, 通用获取方法失败");
    localException.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.MeizuRomUtils
 * JD-Core Version:    0.7.0.1
 */