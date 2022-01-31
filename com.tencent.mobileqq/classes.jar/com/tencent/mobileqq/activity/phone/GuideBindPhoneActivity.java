package com.tencent.mobileqq.activity.phone;

import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import aneh;
import aumj;
import axqy;
import bcql;
import bfnz;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class GuideBindPhoneActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected aumj a;
  protected int b = 0;
  
  public GuideBindPhoneActivity()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    if (((PhoneContactManagerImp)this.app.getManager(11)).a(true))
    {
      ContactBindedActivity.a(this.app, -1, 2, null);
      setResult(-1);
      finish();
    }
  }
  
  public void b()
  {
    if ((bfnz.l()) && (aneh.a("android.permission.WRITE_CONTACTS")))
    {
      String str1 = getIntent().getStringExtra("key_contact_name");
      String str2 = getIntent().getStringExtra("key_contact_phone");
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (localPhoneContactManagerImp.b(str1, str2))) {
        bcql.a(getApplicationContext(), 2, ajya.a(2131705427), 0).a();
      }
      finish();
    }
  }
  
  public void c()
  {
    if (((PhoneContactManagerImp)this.app.getManager(11)).i())
    {
      setResult(-1);
      finish();
    }
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
      aneh.a(this, this.app, paramBundle, local2);
    }
    setContentView(2131559131);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131364633));
    paramBundle = findViewById(2131368899);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839132);
    }
    for (;;)
    {
      setTitle(null, getString(2131695047));
      setLeftViewName(2131690331);
      this.jdField_a_of_type_Aumj = new aumj(this, getPackageName());
      findViewById(2131364632).setOnClickListener(this);
      axqy.b(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
      }
      return true;
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(2130838514);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364632)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
      }
      if (!bfnz.l()) {
        break label114;
      }
      if ((this.b == 2) || (this.b == 1)) {
        ((PhoneContactManagerImp)this.app.getManager(11)).b(true);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Aumj.a();
        axqy.b(this.app, "dc00898", "", "", "0X8009F1C", "0X8009F1C", 0, 0, "", "", "", "");
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        this.jdField_a_of_type_Aumj.b();
        continue;
      }
      label114:
      this.jdField_a_of_type_Aumj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */