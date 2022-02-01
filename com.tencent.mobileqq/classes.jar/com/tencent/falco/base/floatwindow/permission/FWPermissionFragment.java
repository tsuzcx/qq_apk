package com.tencent.falco.base.floatwindow.permission;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import com.tencent.falco.base.floatwindow.utils.Logger;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/permission/FWPermissionFragment;", "Landroid/app/Fragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWPermissionFragment
  extends ReportFragment
{
  public static final FWPermissionFragment.Companion Companion = new FWPermissionFragment.Companion(null);
  private static OnFloatWindowPermissionListener onPermissionResult;
  private HashMap _$_findViewCache;
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    FWPermission.requestPermission((Fragment)this);
    Logger.i("PermissionFragment：requestPermission");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if (paramInt1 == 100) {
      new Handler(Looper.getMainLooper()).postDelayed((Runnable)new FWPermissionFragment.onActivityResult.1(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.FWPermissionFragment
 * JD-Core Version:    0.7.0.1
 */