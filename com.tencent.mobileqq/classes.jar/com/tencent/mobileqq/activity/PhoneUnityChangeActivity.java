package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int a;
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131708010), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new PhoneUnityChangeActivity.1(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i = ((PhoneContactManager)localObject1).d();
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
      super.setTitle(HardCodeUtil.a(2131708021));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", PhoneUnityManager.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131380252)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363951));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131369501);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.d) {
        ((ImageView)localObject2).setContentDescription(getString(2131694780));
      }
      i = 2130843941;
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        i = 2130840478;
      }
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() == null) {
      super.finish();
    }
    do
    {
      return true;
      super.setContentView(2131559672);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    } while (a());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      if (NetworkUtil.d(this)) {
        break;
      }
      a(2131694510);
    }
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kNeedUnbind", true);
    localIntent.putExtra("cmd_param_is_from_uni", true);
    localIntent.putExtra("cmd_param_is_from_change_bind", true);
    if (this.jdField_a_of_type_Int != -1) {}
    for (int i = this.jdField_a_of_type_Int;; i = 1)
    {
      localIntent.putExtra("kSrouce", i);
      localIntent.putExtra("kFPhoneChange", true);
      startActivityForResult(localIntent, 1001);
      ReportController.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      ContactUtils.a(1);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */