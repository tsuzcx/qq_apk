package com.tencent.comic;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class BoodoPluginLoadingDialog
  extends Dialog
  implements DialogInterface.OnDismissListener
{
  private BoodoPluginLoadingDialog.HippyActivityLaunchReceiver jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver;
  private final VipComicJumpActivity.LoadingCondition jdField_a_of_type_ComTencentComicVipComicJumpActivity$LoadingCondition;
  
  public BoodoPluginLoadingDialog(Context paramContext, VipComicJumpActivity.LoadingCondition paramLoadingCondition)
  {
    super(paramContext, 2131756189);
    setContentView(2131558978);
    this.jdField_a_of_type_ComTencentComicVipComicJumpActivity$LoadingCondition = paramLoadingCondition;
    a();
  }
  
  private void a()
  {
    setOnDismissListener(this);
    setCanceledOnTouchOutside(false);
    setCancelable(true);
    Object localObject = getWindow();
    ((Window)localObject).setGravity(80);
    if (Build.VERSION.SDK_INT >= 14)
    {
      ((Window)localObject).setDimAmount(0.0F);
      ((Window)localObject).setGravity(17);
    }
    localObject = LayoutInflater.from(getContext()).inflate(1996816386, null);
    ((ImageView)((View)localObject).findViewById(1996750881)).setImageResource(2130851211);
    setContentView((View)localObject);
    if (this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver == null)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_hippy_activity_launch");
      this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver = new BoodoPluginLoadingDialog.HippyActivityLaunchReceiver(this, null);
      getContext().registerReceiver(this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver, (IntentFilter)localObject);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver);
      this.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver = null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentComicVipComicJumpActivity$LoadingCondition;
    if (paramDialogInterface != null) {
      paramDialogInterface.b = true;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.BoodoPluginLoadingDialog
 * JD-Core Version:    0.7.0.1
 */