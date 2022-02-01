package com.tencent.mobileqq.activity.phone;

import Override;
import ajcr;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import anvx;
import azis;
import bdla;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public class GuideBindPhoneActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected azis a;
  protected int b = 0;
  
  public GuideBindPhoneActivity()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    if (((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true))
    {
      ContactBindedActivity.a(this.app, -1, 2, null);
      setResult(-1);
      finish();
    }
  }
  
  public void b()
  {
    if ((VersionUtils.isM()) && (ajcr.a("android.permission.WRITE_CONTACTS")))
    {
      String str1 = getIntent().getStringExtra("key_contact_name");
      String str2 = getIntent().getStringExtra("key_contact_phone");
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (localPhoneContactManagerImp.b(str1, str2))) {
        QQToast.a(getApplicationContext(), 2, anvx.a(2131704900), 0).a();
      }
      finish();
    }
  }
  
  public void c()
  {
    if (((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).k())
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
    if (paramInt1 == 99999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if ((this.b == 2) || (this.b == 1)) {
        a();
      }
    }
    else
    {
      return;
    }
    if (this.b == 5)
    {
      b();
      return;
    }
    if (this.b == 6)
    {
      c();
      return;
    }
    c();
  }
  
  public void doOnBackPressed()
  {
    setResult(0);
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.b = getIntent().getIntExtra("fromKeyForContactBind", 0);
    if (getIntent().getBooleanExtra("key_runtime_req_permission", false))
    {
      paramBundle = new GuideBindPhoneActivity.1(this);
      GuideBindPhoneActivity.2 local2 = new GuideBindPhoneActivity.2(this);
      ajcr.a(this, this.app, paramBundle, local2);
    }
    setContentView(2131559298);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131365097));
    paramBundle = findViewById(2131369788);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839458);
    }
    for (;;)
    {
      setTitle(null, getString(2131694594));
      setLeftViewName(2131690499);
      this.jdField_a_of_type_Azis = new azis(this, getPackageName());
      findViewById(2131365096).setOnClickListener(this);
      bdla.b(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
      }
      return true;
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(2130838911);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365096)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
      }
      if (!VersionUtils.isM()) {
        break label123;
      }
      if ((this.b == 2) || (this.b == 1)) {
        ((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).b(true);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Azis.a();
        bdla.b(this.app, "dc00898", "", "", "0X8009F1C", "0X8009F1C", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.jdField_a_of_type_Azis.b();
        continue;
      }
      label123:
      this.jdField_a_of_type_Azis.b();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */