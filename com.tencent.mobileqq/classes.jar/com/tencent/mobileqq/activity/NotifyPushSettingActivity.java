package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import tdr;
import tds;
import tdt;
import tdu;
import tdv;
import tdw;
import tdx;
import tdy;
import tdz;
import tea;
import teb;
import tec;
import ted;
import tee;
import tef;
import teg;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  public BroadcastReceiver a;
  private Handler jdField_a_of_type_AndroidOsHandler = new tdx(this);
  private View jdField_a_of_type_AndroidViewView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tdw(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_c_of_type_Boolean = true;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  
  public NotifyPushSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new tdy(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365355);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131365345));
    this.i = ((FormSwitchItem)findViewById(2131365352));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365344);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131365347));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131365348));
    this.d = ((FormSwitchItem)findViewById(2131365349));
    this.e = ((FormSwitchItem)findViewById(2131365350));
    this.f = ((FormSwitchItem)findViewById(2131365351));
    this.g = ((FormSwitchItem)findViewById(2131365346));
    this.h = ((FormSwitchItem)findViewById(2131365353));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365354));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new tdr(this));
    boolean bool1;
    if (this.app != null)
    {
      if (this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130846054));
      }
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131434202), "qqsetting_notify_showcontent_key", true);
      boolean bool3 = SettingCloneUtil.readValue(this, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      boolean bool4 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131434203), "qqsetting_notify_blncontrol_key", true);
      boolean bool5 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool6 = LocalMultiProcConfig.getBool(getString(2131434207) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131435403), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131435404), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool8 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new tdz(this));
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      }
      this.i.setChecked(bool3);
      this.i.setOnCheckedChangeListener(new tea(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new teb(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new tec(this));
      if (!BadgeUtils.a(this.app.getApplication())) {
        break label929;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label497:
      this.d.setChecked(bool6);
      this.d.setOnCheckedChangeListener(new ted(this));
      this.f.setChecked(bool7);
      this.f.setOnCheckedChangeListener(new tee(this));
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      CardHandler localCardHandler1 = (CardHandler)this.app.a(2);
      this.h.setChecked(bool8);
      this.h.setOnCheckedChangeListener(new tef(this, localCardHandler1));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      CardHandler localCardHandler2 = (CardHandler)this.app.a(2);
      this.e.setChecked(bool3);
      this.e.setContentDescription(getString(2131435402));
      this.e.setOnCheckedChangeListener(new teg(this, localCardHandler2));
      if (localCardHandler1 != null)
      {
        localCardHandler1.k();
        localCardHandler2.l();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label941;
      }
      this.h.setVisibility(0);
      label710:
      this.g.setChecked(bool2);
      if (!a()) {
        break label953;
      }
      this.g.setChecked(false);
      this.g.setVisibility(8);
    }
    for (;;)
    {
      this.g.setOnCheckedChangeListener(new tds(this));
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.g.setContentDescription("锁屏显示消息弹框");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new tdt(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new tdu(this));
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("声音");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知时指示灯闪烁");
        this.d.setContentDescription("与我相关的通知");
        this.f.setContentDescription("退出后仍接收消息通知");
        this.i.setContentDescription("夜间防骚扰模式");
        this.h.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131436861));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("群消息设置");
      }
      ((ConfigHandler)this.app.a(4)).e();
      return;
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      break;
      label929:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label497;
      label941:
      this.h.setVisibility(8);
      break label710;
      label953:
      if (bool1) {
        this.g.setVisibility(0);
      } else {
        this.g.setVisibility(8);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new tdv(paramQQAppInterface, paramString));
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_Boolean = true;
      this.h.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a()
  {
    return new File(Environment.getRootDirectory() + "/etc/permissions", "com.lenovo.keyguard.xml").exists();
  }
  
  private void b(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_hello_live_message", true);
      this.jdField_c_of_type_Boolean = false;
      this.e.setChecked(bool);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969142);
    setTitle(2131434058);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (BadgeUtils.a(this.app.getApplication())) {
        BadgeUtils.c();
      }
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.getApp().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  protected String setLastActivityName()
  {
    return getString(2131434058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */