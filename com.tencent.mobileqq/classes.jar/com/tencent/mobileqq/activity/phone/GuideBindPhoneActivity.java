package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public class GuideBindPhoneActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected PermissionPageUtil a;
  protected int b = 0;
  
  public GuideBindPhoneActivity()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    if (((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true))
    {
      ContactBindedActivity.a(this.app, -1, 2, null);
      setResult(-1);
      finish();
    }
  }
  
  public void b()
  {
    if ((VersionUtils.k()) && (PermissionChecker.a("android.permission.WRITE_CONTACTS")))
    {
      String str1 = getIntent().getStringExtra("key_contact_name");
      String str2 = getIntent().getStringExtra("key_contact_phone");
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (localIPhoneContactService.addContactAndUpload(str1, str2))) {
        QQToast.a(getApplicationContext(), 2, HardCodeUtil.a(2131705516), 0).a();
      }
      finish();
    }
  }
  
  public void c()
  {
    if (PermissionChecker.a().b())
    {
      setResult(-1);
      finish();
    }
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
    if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      paramInt1 = this.b;
      if ((paramInt1 != 2) && (paramInt1 != 1))
      {
        if (paramInt1 == 5)
        {
          b();
          return;
        }
        if (paramInt1 == 6)
        {
          c();
          return;
        }
        c();
        return;
      }
      a();
    }
  }
  
  public void doOnBackPressed()
  {
    setResult(0);
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.b = getIntent().getIntExtra("fromKeyForContactBind", 0);
    if (getIntent().getBooleanExtra("key_runtime_req_permission", false)) {
      PermissionChecker.a(this, new GuideBindPhoneActivity.1(this), new GuideBindPhoneActivity.2(this));
    }
    setContentView(2131559216);
    PhoneContactUtils.a(this.app, getResources(), (ImageView)findViewById(2131365110));
    paramBundle = findViewById(2131369736);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839393);
    } else if (paramBundle != null) {
      paramBundle.setBackgroundResource(2130838739);
    }
    setTitle(null, getString(2131694815));
    setLeftViewName(2131690529);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPageUtil = new PermissionPageUtil(this, getPackageName());
    findViewById(2131365109).setOnClickListener(this);
    ReportController.b(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
    }
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365109)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
      }
      if (VersionUtils.k())
      {
        int i = this.b;
        if ((i == 2) || (i == 1)) {
          ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).markOrClearUserSettingFlag(true);
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPageUtil.a();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPageUtil.b();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPageUtil.b();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8009F1C", "0X8009F1C", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */