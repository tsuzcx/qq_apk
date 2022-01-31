package com.tencent.mobileqq.activity;

import abpm;
import abpn;
import abpo;
import abpp;
import abpq;
import abpr;
import abps;
import abpt;
import abpu;
import abpv;
import abpw;
import abpx;
import abpy;
import abpz;
import abqa;
import abqb;
import abqc;
import abqd;
import abqe;
import abqf;
import abqg;
import abqh;
import abqi;
import ajtk;
import ajtq;
import ajuf;
import ajyc;
import amuk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import asik;
import bbjn;
import bfmk;
import bfmt;
import bfnr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqr;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private abqi jdField_a_of_type_Abqi;
  private ajtq jdField_a_of_type_Ajtq = new abpz(this);
  public BroadcastReceiver a;
  private View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asik jdField_a_of_type_Asik;
  private bfmt jdField_a_of_type_Bfmt = new bfmt(new abqa(this));
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abpm(this);
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_c_of_type_Boolean = true;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_d_of_type_Boolean = true;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_e_of_type_Boolean;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  private FormSwitchItem m;
  
  public NotifyPushSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new abqb(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367175);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376928));
    this.l = ((FormSwitchItem)findViewById(2131370759));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370957));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abpx(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377332));
    this.k = ((FormSwitchItem)findViewById(2131362909));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363716));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376094));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131370846));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370847));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abqc(this));
    int n = bbjn.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    label567:
    boolean bool3;
    int i1;
    if ((n != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131365305).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + n);
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376329);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376095));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376091));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376097));
      this.f = ((FormSwitchItem)findViewById(2131376104));
      this.j = ((FormSwitchItem)findViewById(2131376113));
      this.g = ((FormSwitchItem)findViewById(2131374860));
      this.h = ((FormSwitchItem)findViewById(2131369560));
      this.i = ((FormSwitchItem)findViewById(2131371330));
      this.m = ((FormSwitchItem)findViewById(2131376363));
      Object localObject = (ajtk)this.app.a(2);
      this.m.setOnCheckedChangeListener(new abqd(this, (ajtk)localObject));
      bool1 = bfnr.a();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.m.setChecked(bool1);
      ((ajtk)localObject).c(bool1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376365));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abqe(this));
      if (this.app == null) {
        break label1780;
      }
      if (this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849291));
      }
      if (amuk.a(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1775;
      }
      n = 1;
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718859), "qqsetting_notify_showcontent_key", true);
      this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718851), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131718847) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718625), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131694019), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(44);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).b();
        if (bool8)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abqf(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!bool8) {
          break label1794;
        }
        i1 = 0;
        label845:
        ((FormSwitchItem)localObject).setVisibility(i1);
      }
      boolean bool8 = mqr.a(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label1800;
      }
      i1 = 0;
      label870:
      ThreadManager.excute(new NotifyPushSettingActivity.7(this, i1), 16, null, false);
      this.k.setVisibility(0);
      this.k.setChecked(bool8);
      bool8 = this.jdField_a_of_type_Asik.a();
      this.l.setChecked(bool8);
      this.l.setOnCheckedChangeListener(this.jdField_a_of_type_Asik.a(this, this.l, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem));
      this.jdField_a_of_type_Asik.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abqg(this);
      this.k.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abqh(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajyc.a(2131707648));
      }
      a(this.jdField_e_of_type_Boolean);
      if (Build.VERSION.SDK_INT < 26) {
        break label1805;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1046:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abpo(this));
      if (!bfmk.a(this.app.getApplication())) {
        break label1840;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label1091:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abpp(this));
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new abpq(this));
      this.app.addObserver(this.jdField_a_of_type_Ajtq, true);
      localObject = (ajtk)this.app.a(2);
      this.i.setChecked(bool7);
      this.i.setOnCheckedChangeListener(new abpr(this, (ajtk)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      ajtk localajtk = (ajtk)this.app.a(2);
      this.f.setChecked(bool3);
      this.f.setContentDescription(getString(2131719610));
      this.f.setOnCheckedChangeListener(new abps(this, localajtk));
      if (n == 0) {
        break label1852;
      }
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131719616));
      this.j.setOnCheckedChangeListener(new abpt(this, localajtk));
      label1325:
      if (localObject != null)
      {
        ((ajtk)localObject).i();
        localajtk.k();
        localajtk.j();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label1864;
      }
      this.i.setVisibility(0);
      label1378:
      this.h.setChecked(bool2);
      if (!a()) {
        break label1876;
      }
      this.h.setChecked(false);
      this.h.setVisibility(8);
    }
    for (;;)
    {
      this.h.setOnCheckedChangeListener(new abpu(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.h.setContentDescription(ajyc.a(2131707657));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new abpv(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abpw(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new abpy(this));
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(ajyc.a(2131707654));
        this.l.setContentDescription(getString(2131694636));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694727) + getString(2131719326));
        this.k.setContentDescription(ajyc.a(2131707653));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajyc.a(2131707644));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajyc.a(2131718851));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajyc.a(2131707641));
        this.g.setContentDescription(ajyc.a(2131707655));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131695297));
        this.i.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717474));
        this.m.setContentDescription(getString(2131717475));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajyc.a(2131707651));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131720175));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131695297));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131695298));
      }
      ((ajuf)this.app.a(4)).d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131365305).setVisibility(0);
      break;
      label1775:
      n = 0;
      break label567;
      label1780:
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      n = 0;
      break label567;
      label1794:
      i1 = 8;
      break label845;
      label1800:
      i1 = 1;
      break label870;
      label1805:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abpn(this));
      break label1046;
      label1840:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label1091;
      label1852:
      this.j.setVisibility(8);
      break label1325;
      label1864:
      this.i.setVisibility(8);
      break label1378;
      label1876:
      if (bool1)
      {
        this.h.setVisibility(0);
        this.h.setVisibility(8);
      }
      else
      {
        this.h.setVisibility(8);
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
    paramQQAppInterface.a(new NotifyPushSettingActivity.21(paramQQAppInterface, paramString));
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_Boolean = true;
      this.i.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    FormSwitchItem localFormSwitchItem;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_e_of_type_Boolean = paramBoolean;
      localFormSwitchItem = this.l;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
        break label123;
      }
      n = 0;
      label72:
      localFormSwitchItem.setVisibility(n);
      localFormSwitchItem = this.k;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
        break label129;
      }
    }
    label129:
    for (int n = i1;; n = 8)
    {
      localFormSwitchItem.setVisibility(n);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label123:
      n = 8;
      break label72;
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
      this.f.setChecked(bool);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559350);
    setTitle(2131719378);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_Asik = asik.a(this.app);
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ajtq);
      if (bfmk.a(this.app.getApplication())) {
        bfmk.c();
      }
    }
    this.jdField_a_of_type_Asik.a();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.getApp().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_e_of_type_Boolean)
    {
      int n = (int)NetConnInfoCenter.getServerTime();
      int i1 = SettingCloneUtil.readValueForInt(getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().setText(ajyc.a(2131707643) + abqi.a((i1 - n) * 1000));
    }
    this.jdField_a_of_type_Asik.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k);
  }
  
  public String setLastActivityName()
  {
    return getString(2131719335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */