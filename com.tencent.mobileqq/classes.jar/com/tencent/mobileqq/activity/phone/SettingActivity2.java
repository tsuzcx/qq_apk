package com.tencent.mobileqq.activity.phone;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import ajnj;
import akos;
import akpn;
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
import anzj;
import arfk;
import arfl;
import arfm;
import azov;
import bdll;
import bhnv;
import blir;
import blji;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public Button a;
  public TextView a;
  public azov a;
  public Boolean a;
  public int b;
  public Button b;
  public TextView b;
  public azov b;
  public azov c;
  
  public SettingActivity2()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.k();
    String str = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    Object localObject1 = str;
    if (1 != i)
    {
      localObject1 = str;
      if (5 != i)
      {
        localObject1 = str;
        if (localObject2 != null) {
          localObject1 = ((RespondQueryQQBindingStat)localObject2).nationCode + " " + ((RespondQueryQQBindingStat)localObject2).mobileNo;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SettingActivity2", 2, "updateUIByState state[" + i + "], number[" + (String)localObject1 + "], hasPermission[" + this.jdField_a_of_type_JavaLangBoolean + "]");
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (i <= 5)) {
      finish();
    }
    while ((i == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue() == bool)) {
      return;
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
    setTitle(anzj.a(2131712735));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364988));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364987));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370650));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131381056));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((i == 7) || (i == 6))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = arfm.a();
      if (bool)
      {
        localObject1 = ((arfk)localObject2).b.a;
        str = ((arfk)localObject2).b.b;
        localObject2 = ((arfk)localObject2).b.c;
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
        label383:
        localObject1 = (ImageView)findViewById(2131369056);
        if (i != 7) {
          break label503;
        }
        ((ImageView)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        ((ImageView)localObject1).setContentDescription(getString(2131694245));
      }
      ((ImageView)localObject1).setBackgroundResource(2130840291);
      ((ImageView)localObject1).setOnClickListener(this);
      return;
      localObject1 = ((arfk)localObject2).a.a;
      str = ((arfk)localObject2).a.b;
      localObject2 = ((arfk)localObject2).a.c;
      break;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label383;
      label503:
      ((ImageView)localObject1).setVisibility(0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    bdll.b(this.app, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void b()
  {
    blir localblir = (blir)blji.a(this, null);
    localblir.setCanceledOnTouchOutside(true);
    localblir.a(anzj.a(2131712736), 3);
    localblir.c(2131690580);
    localblir.a(new akpn(this, localblir));
    localblir.c(2131690580);
    localblir.show();
  }
  
  public void c()
  {
    if (!bhnv.d(this))
    {
      a(2131694008);
      return;
    }
    SettingActivity2.3 local3 = new SettingActivity2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new akos(this.app));
    ajnj.a(this, this.app, local3, localDenyRunnable);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      if (((PhoneContactManagerImp)this.app.getManager(11)).a(true))
      {
        ContactBindedActivity.a(this.app, 222, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a());
        return;
      }
      a();
      return;
    }
    a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return true;
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("kSrouce", -1);
    super.setContentView(2131559564);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131364986));
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azov);
      this.jdField_a_of_type_Azov = null;
    }
    if (this.jdField_b_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Azov);
      this.jdField_b_of_type_Azov = null;
    }
    this.app.removeHandler(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.excute(new SettingActivity2.1(this), 16, null, true);
    a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131369056: 
      b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a("0X8005B89", 0);
      c();
      continue;
      SettingActivity2.4 local4 = new SettingActivity2.4(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new akos(this.app));
      ajnj.a(this, this.app, local4, localDenyRunnable);
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
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */