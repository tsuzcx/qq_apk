package com.tencent.ilive.floatwindowpermission;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionAdapter;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface.OnRequestResult;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.dialog.CustomizedDialog;
import com.tencent.ilive.dialog.DialogUtil;

public class FloatWindowPermission
  implements FloatWindowPermissionInterface
{
  private static final String TAG = "FloatWindowPermission";
  private FloatWindowPermissionAdapter adapter;
  private Context applicationContext;
  
  private void gotoFWPermissionSettingPage(Activity paramActivity)
  {
    FWPermission.requestPermission(paramActivity, new FloatWindowPermission.4(this));
  }
  
  private void reportPermissionDialogAction(String paramString1, String paramString2, int paramInt)
  {
    this.adapter.getDataReporter().newTask().setPage("room_page").setPageDesc("直播/视频房间").setModule("narrow_window_authority").setModuleDesc("小窗授权弹框").setActType(paramString1).setActTypeDesc(paramString2).addKeyValue("zt_int1", paramInt).send();
  }
  
  private void requestFWPermission(Activity paramActivity, FloatWindowPermissionInterface.OnRequestResult paramOnRequestResult)
  {
    DialogUtil.createDialog(paramActivity, paramActivity.getString(2131692564), paramActivity.getString(2131692565), paramActivity.getString(2131693288), paramActivity.getString(2131693289), new FloatWindowPermission.1(this, paramOnRequestResult), new FloatWindowPermission.2(this, paramActivity)).show(((FragmentActivity)paramActivity).getSupportFragmentManager(), "");
    reportPermissionDialogAction("view", "曝光", -1);
  }
  
  public void clearEventOutput() {}
  
  public boolean hasFWPermission()
  {
    return FWPermission.hasPermission(this.applicationContext);
  }
  
  public void init(FloatWindowPermissionAdapter paramFloatWindowPermissionAdapter)
  {
    this.adapter = paramFloatWindowPermissionAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.applicationContext = paramContext;
  }
  
  public void onDestroy() {}
  
  public void requestPermissionAndDoJump(Activity paramActivity, Runnable paramRunnable)
  {
    if (!this.adapter.getHostProxy().getSdkInfoInterface().isFloatWindowEnabled())
    {
      ThreadCenter.postDefaultUITask(paramRunnable);
      return;
    }
    if (FWPermission.hasPermission(this.applicationContext))
    {
      ThreadCenter.postDefaultUITask(paramRunnable);
      return;
    }
    requestFWPermission(paramActivity, new FloatWindowPermission.3(this, paramRunnable));
  }
  
  public void requestPermissionAndDoJump(Runnable paramRunnable)
  {
    Activity localActivity = this.adapter.getActivityLifeService().getTopActivity();
    if (localActivity == null)
    {
      this.adapter.getLog().e("FloatWindowPermission", "请求权限并跳转时，activity为空，直接跳转", new Object[0]);
      ThreadCenter.postDefaultUITask(paramRunnable);
      return;
    }
    requestPermissionAndDoJump(localActivity, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.floatwindowpermission.FloatWindowPermission
 * JD-Core Version:    0.7.0.1
 */