package com.tencent.mobileqq.activity;

import abfl;
import abfm;
import abfn;
import abfo;
import abfp;
import abfq;
import abfr;
import abfs;
import abft;
import abfu;
import abfv;
import abfw;
import abfx;
import abfy;
import abfz;
import abga;
import abgb;
import abgc;
import abgd;
import abge;
import abgf;
import abgg;
import abgh;
import ajfi;
import ajfo;
import ajgd;
import ajjy;
import amee;
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
import armh;
import baig;
import beeq;
import beez;
import befx;
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
import mfs;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private abgh jdField_a_of_type_Abgh;
  private ajfo jdField_a_of_type_Ajfo = new abfy(this);
  public BroadcastReceiver a;
  private View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private armh jdField_a_of_type_Armh;
  private beez jdField_a_of_type_Beez = new beez(new abfz(this));
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abfl(this);
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new abga(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301563);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131311118));
    this.l = ((FormSwitchItem)findViewById(2131305092));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131305282));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abfw(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311519));
    this.k = ((FormSwitchItem)findViewById(2131297369));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298161));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310302));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131305173));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131305174));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abgb(this));
    int n = baig.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    label567:
    boolean bool3;
    int i1;
    if ((n != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131299737).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + n);
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131310537);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310303));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310299));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310305));
      this.f = ((FormSwitchItem)findViewById(2131310312));
      this.j = ((FormSwitchItem)findViewById(2131310321));
      this.g = ((FormSwitchItem)findViewById(2131309116));
      this.h = ((FormSwitchItem)findViewById(2131303885));
      this.i = ((FormSwitchItem)findViewById(2131305634));
      this.m = ((FormSwitchItem)findViewById(2131310570));
      Object localObject = (ajfi)this.app.a(2);
      this.m.setOnCheckedChangeListener(new abgc(this, (ajfi)localObject));
      bool1 = befx.a();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.m.setChecked(bool1);
      ((ajfi)localObject).c(bool1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131310572));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abgd(this));
      if (this.app == null) {
        break label1780;
      }
      if (this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849056));
      }
      if (amee.a(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1775;
      }
      n = 1;
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131653032), "qqsetting_notify_showcontent_key", true);
      this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131653024), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131653020) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131652800), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131628378), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(44);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).b();
        if (bool8)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abge(this, (BubbleManager)localObject));
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
      boolean bool8 = mfs.a(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label1800;
      }
      i1 = 0;
      label870:
      ThreadManager.excute(new NotifyPushSettingActivity.7(this, i1), 16, null, false);
      this.k.setVisibility(0);
      this.k.setChecked(bool8);
      bool8 = this.jdField_a_of_type_Armh.a();
      this.l.setChecked(bool8);
      this.l.setOnCheckedChangeListener(this.jdField_a_of_type_Armh.a(this, this.l, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem));
      this.jdField_a_of_type_Armh.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abgf(this);
      this.k.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abgg(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131641863));
      }
      a(this.jdField_e_of_type_Boolean);
      if (Build.VERSION.SDK_INT < 26) {
        break label1805;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1046:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abfn(this));
      if (!beeq.a(this.app.getApplication())) {
        break label1840;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label1091:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abfo(this));
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new abfp(this));
      this.app.addObserver(this.jdField_a_of_type_Ajfo, true);
      localObject = (ajfi)this.app.a(2);
      this.i.setChecked(bool7);
      this.i.setOnCheckedChangeListener(new abfq(this, (ajfi)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      ajfi localajfi = (ajfi)this.app.a(2);
      this.f.setChecked(bool3);
      this.f.setContentDescription(getString(2131653726));
      this.f.setOnCheckedChangeListener(new abfr(this, localajfi));
      if (n == 0) {
        break label1852;
      }
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131653732));
      this.j.setOnCheckedChangeListener(new abfs(this, localajfi));
      label1325:
      if (localObject != null)
      {
        ((ajfi)localObject).i();
        localajfi.k();
        localajfi.j();
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
      this.h.setOnCheckedChangeListener(new abft(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.h.setContentDescription(ajjy.a(2131641872));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new abfu(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abfv(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new abfx(this));
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(ajjy.a(2131641869));
        this.l.setContentDescription(getString(2131628972));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131629062) + getString(2131653497));
        this.k.setContentDescription(ajjy.a(2131641868));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131641859));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131653024));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131641856));
        this.g.setContentDescription(ajjy.a(2131641870));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131629616));
        this.i.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131651682));
        this.m.setContentDescription(getString(2131651683));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajjy.a(2131641866));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131654281));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131629616));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131629617));
      }
      ((ajgd)this.app.a(4)).d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131299737).setVisibility(0);
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
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abfm(this));
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
    super.setContentView(2131493779);
    setTitle(2131653549);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_Armh = armh.a(this.app);
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
      this.app.removeObserver(this.jdField_a_of_type_Ajfo);
      if (beeq.a(this.app.getApplication())) {
        beeq.c();
      }
    }
    this.jdField_a_of_type_Armh.a();
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().setText(ajjy.a(2131641858) + abgh.a((i1 - n) * 1000));
    }
    this.jdField_a_of_type_Armh.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k);
  }
  
  public String setLastActivityName()
  {
    return getString(2131653506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */