package com.tencent.falco.base.floatwindow.permission;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import com.tencent.falco.base.floatwindow.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class FWPermissionFragment$onActivityResult$1
  implements Runnable
{
  FWPermissionFragment$onActivityResult$1(FWPermissionFragment paramFWPermissionFragment) {}
  
  public final void run()
  {
    Object localObject = this.this$0.getActivity();
    if (localObject != null)
    {
      boolean bool = FWPermission.hasPermission((Context)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PermissionFragment onActivityResult: ");
      ((StringBuilder)localObject).append(bool);
      Logger.i(((StringBuilder)localObject).toString());
      localObject = FWPermissionFragment.access$getOnPermissionResult$cp();
      if (localObject != null) {
        ((OnFloatWindowPermissionListener)localObject).permissionFinish(bool);
      }
      this.this$0.getFragmentManager().beginTransaction().remove((Fragment)this.this$0).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.FWPermissionFragment.onActivityResult.1
 * JD-Core Version:    0.7.0.1
 */