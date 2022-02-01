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
  protected PermissionPageUtil a;
  protected int b = -1;
  protected int c = 0;
  
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
        QQToast.makeText(getApplicationContext(), 2, HardCodeUtil.a(2131903404), 0).show();
      }
      finish();
    }
  }
  
  public void c()
  {
    if (PermissionChecker.a().d())
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
      paramInt1 = this.c;
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
    this.b = getIntent().getIntExtra("kSrouce", -1);
    this.c = getIntent().getIntExtra("fromKeyForContactBind", 0);
    if (getIntent().getBooleanExtra("key_runtime_req_permission", false)) {
      PermissionChecker.a(this, new GuideBindPhoneActivity.1(this), new GuideBindPhoneActivity.2(this));
    }
    setContentView(2131624973);
    PhoneContactUtils.a(this.app, getResources(), (ImageView)findViewById(2131431257));
    paramBundle = findViewById(2131436854);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839577);
    } else if (paramBundle != null) {
      paramBundle.setBackgroundResource(2130838958);
    }
    setTitle(null, getString(2131892518));
    setLeftViewName(2131887440);
    this.a = new PermissionPageUtil(this, getPackageName());
    findViewById(2131431256).setOnClickListener(this);
    ReportController.b(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c) }));
    }
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431256)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
      }
      if (VersionUtils.k())
      {
        int i = this.c;
        if ((i == 2) || (i == 1)) {
          ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).markOrClearUserSettingFlag(true);
        }
        try
        {
          this.a.a();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.a.b();
        }
      }
      else
      {
        this.a.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */