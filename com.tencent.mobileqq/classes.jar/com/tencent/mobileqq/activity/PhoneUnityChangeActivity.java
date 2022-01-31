package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import tfx;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public Button a;
  public PhoneContactManager a;
  public ContactBindObserver a;
  public QQCustomDialog a;
  public ActionSheet a;
  public String a;
  public ContactBindObserver b;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a("解绑", 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new tfx(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (PhoneContactManager)this.app.getManager(10);
    int i = ((PhoneContactManager)localObject1).c();
    localObject1 = ((PhoneContactManager)localObject1).a();
    if ((1 != i) && (5 != i)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = ("" + ((RespondQueryQQBindingStat)localObject1).mobileNo);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityChangeActivity", 2, "" + i, localException);
        }
      }
      super.setTitle("更换手机号码");
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", PhoneUnityManager.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131365489)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365491));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131363474);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.b) {
        ((ImageView)localObject2).setContentDescription(getString(2131436854));
      }
      ((ImageView)localObject2).setBackgroundResource(2130839147);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      super.setResult(paramInt2);
      super.finish();
      return;
    }
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() == null) {
      super.finish();
    }
    do
    {
      return true;
      super.setContentView(2130969170);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.app.getManager(10));
    } while (a());
    super.finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    this.app.removeHandler(PhoneUnityChangeActivity.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363474: 
      a();
      return;
    case 2131365491: 
      if (!NetworkUtil.d(this))
      {
        b(2131434613);
        return;
      }
      paramView = new Intent(this, BindNumberActivity.class);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kSrouce", 1);
      paramView.putExtra("kFPhoneChange", true);
      startActivityForResult(paramView, 1001);
      ReportController.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      ContactUtils.a(1);
      return;
    }
    paramView = new Intent(this, PhoneFrameActivity.class);
    paramView.putExtra("key_req_type", 5);
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */