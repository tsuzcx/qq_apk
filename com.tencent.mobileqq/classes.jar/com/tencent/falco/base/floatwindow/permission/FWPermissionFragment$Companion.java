package com.tencent.falco.base.floatwindow.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/permission/FWPermissionFragment$Companion;", "", "()V", "onPermissionResult", "Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowPermissionListener;", "requestPermission", "", "activity", "Landroid/app/Activity;", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWPermissionFragment$Companion
{
  public final void requestPermission(@NotNull Activity paramActivity, @NotNull OnFloatWindowPermissionListener paramOnFloatWindowPermissionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramOnFloatWindowPermissionListener, "onPermissionResult");
    FWPermissionFragment.access$setOnPermissionResult$cp(paramOnFloatWindowPermissionListener);
    paramActivity.getFragmentManager().beginTransaction().add((Fragment)new FWPermissionFragment(), paramActivity.getLocalClassName()).commitAllowingStateLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.FWPermissionFragment.Companion
 * JD-Core Version:    0.7.0.1
 */