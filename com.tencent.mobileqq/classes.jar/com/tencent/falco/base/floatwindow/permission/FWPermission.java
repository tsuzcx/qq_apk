package com.tencent.falco.base.floatwindow.permission;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import com.tencent.falco.base.floatwindow.permission.romutils.BaseRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.HuaweiRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.MeizuRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.MiuiRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.OppoRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.PhoneRomUtils;
import com.tencent.falco.base.floatwindow.permission.romutils.QikuRomUtils;
import com.tencent.falco.base.floatwindow.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/permission/FWPermission;", "", "()V", "TAG", "", "requestCode", "", "commonPermissionApply", "", "fragment", "Landroid/app/Fragment;", "commonPermissionApplyInternal", "commonPermissionCheck", "", "context", "Landroid/content/Context;", "hasPermission", "isResult", "huaweiPermissionCheck", "meizuPermissionCheck", "miuiPermissionCheck", "oppoPermissionCheck", "qikuPermissionCheck", "requestPermission", "activity", "Landroid/app/Activity;", "onPermissionResult", "Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowPermissionListener;", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWPermission
{
  public static final FWPermission INSTANCE = new FWPermission();
  private static final String TAG = "PermissionUtils";
  public static final int requestCode = 100;
  
  private final void commonPermissionApply(Fragment paramFragment)
  {
    if (PhoneRomUtils.INSTANCE.checkIsMeizuRom())
    {
      MeizuRomUtils.applyPermission(paramFragment);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        commonPermissionApplyInternal(paramFragment);
        return;
      }
      catch (Exception paramFragment)
      {
        Logger.e("PermissionUtils", Log.getStackTraceString((Throwable)paramFragment));
        return;
      }
    }
    Logger.d("PermissionUtils", "user manually refuse OVERLAY_PERMISSION");
  }
  
  @JvmStatic
  public static final void commonPermissionApplyInternal(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    try
    {
      Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
      StringBuilder localStringBuilder = new StringBuilder().append("package:");
      Activity localActivity = paramFragment.getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "fragment.activity");
      localIntent.setData(Uri.parse(localActivity.getPackageName()));
      paramFragment.startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception paramFragment)
    {
      Logger.e("PermissionUtils", String.valueOf(paramFragment));
    }
  }
  
  @RequiresApi(api=23)
  private final boolean commonPermissionCheck(Context paramContext)
  {
    if (PhoneRomUtils.INSTANCE.checkIsMeizuRom()) {
      return meizuPermissionCheck(paramContext);
    }
    return Settings.canDrawOverlays(paramContext);
  }
  
  @JvmStatic
  public static final boolean hasPermission(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (Build.VERSION.SDK_INT < 23)
    {
      if (PhoneRomUtils.INSTANCE.checkIsHuaweiRom()) {
        return INSTANCE.huaweiPermissionCheck(paramContext);
      }
      if (PhoneRomUtils.INSTANCE.checkIsMiuiRom()) {
        return INSTANCE.miuiPermissionCheck(paramContext);
      }
      if (PhoneRomUtils.INSTANCE.checkIsOppoRom()) {
        return INSTANCE.oppoPermissionCheck(paramContext);
      }
      if (PhoneRomUtils.INSTANCE.checkIsMeizuRom()) {
        return INSTANCE.meizuPermissionCheck(paramContext);
      }
      if (PhoneRomUtils.INSTANCE.checkIs360Rom()) {
        return INSTANCE.qikuPermissionCheck(paramContext);
      }
      return true;
    }
    return INSTANCE.commonPermissionCheck(paramContext);
  }
  
  @JvmStatic
  public static final boolean hasPermission(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramBoolean) && (Build.VERSION.SDK_INT == 26))
    {
      Logger.d("PermissionUtils", "hasPermission rom is 8.0");
      return BaseRomUtils.hasPermissionForO(paramContext);
    }
    return hasPermission(paramContext);
  }
  
  private final boolean huaweiPermissionCheck(Context paramContext)
  {
    return HuaweiRomUtils.hasPermissionBelowMarshmallow(paramContext);
  }
  
  private final boolean meizuPermissionCheck(Context paramContext)
  {
    return MeizuRomUtils.hasPermissionBelowMarshmallow(paramContext);
  }
  
  private final boolean miuiPermissionCheck(Context paramContext)
  {
    return MiuiRomUtils.hasPermissionBelowMarshmallow(paramContext);
  }
  
  private final boolean oppoPermissionCheck(Context paramContext)
  {
    return OppoRomUtils.hasPermissionBelowMarshmallow(paramContext);
  }
  
  private final boolean qikuPermissionCheck(Context paramContext)
  {
    return QikuRomUtils.hasPermissionBelowMarshmallow(paramContext);
  }
  
  @JvmStatic
  public static final void requestPermission(@NotNull Activity paramActivity, @NotNull OnFloatWindowPermissionListener paramOnFloatWindowPermissionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramOnFloatWindowPermissionListener, "onPermissionResult");
    FWPermissionFragment.Companion.requestPermission(paramActivity, paramOnFloatWindowPermissionListener);
  }
  
  @JvmStatic
  public static final void requestPermission(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    if (Build.VERSION.SDK_INT < 23)
    {
      if (PhoneRomUtils.INSTANCE.checkIsHuaweiRom())
      {
        HuaweiRomUtils.applyPermission((Context)paramFragment.getActivity());
        return;
      }
      if (PhoneRomUtils.INSTANCE.checkIsMiuiRom())
      {
        MiuiRomUtils.applyPermission((Context)paramFragment.getActivity());
        return;
      }
      if (PhoneRomUtils.INSTANCE.checkIsOppoRom())
      {
        OppoRomUtils.applyPermission((Context)paramFragment.getActivity());
        return;
      }
      if (PhoneRomUtils.INSTANCE.checkIsMeizuRom())
      {
        MeizuRomUtils.applyPermission(paramFragment);
        return;
      }
      if (PhoneRomUtils.INSTANCE.checkIs360Rom())
      {
        QikuRomUtils.applyPermission((Context)paramFragment.getActivity());
        return;
      }
      Logger.i("PermissionUtils", "原生 Android 6.0 以下无需权限申请");
      return;
    }
    INSTANCE.commonPermissionApply(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.FWPermission
 * JD-Core Version:    0.7.0.1
 */