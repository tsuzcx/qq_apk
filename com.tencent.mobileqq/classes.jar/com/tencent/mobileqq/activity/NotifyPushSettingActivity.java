package com.tencent.mobileqq.activity;

import Override;
import afaw;
import afax;
import afay;
import afaz;
import afba;
import afbb;
import afbc;
import afbd;
import afbe;
import afbf;
import afbg;
import afbh;
import afbi;
import afbj;
import afbk;
import afbl;
import afbm;
import afbn;
import afbo;
import afbp;
import afbq;
import afbr;
import afbs;
import afbt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anum;
import anuw;
import anvl;
import anxm;
import anzj;
import argx;
import axdx;
import bhsi;
import blgq;
import blha;
import blhw;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mrl;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private afbt jdField_a_of_type_Afbt;
  public BroadcastReceiver a;
  private View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new afbk(this);
  private anxm jdField_a_of_type_Anxm;
  private axdx jdField_a_of_type_Axdx;
  private blha jdField_a_of_type_Blha = new blha(new afbl(this));
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afaw(this);
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_c_of_type_Boolean = true;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_d_of_type_Boolean = true;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
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
  private FormSwitchItem n;
  
  public NotifyPushSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new afbm(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367690);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378498));
    this.l = ((FormSwitchItem)findViewById(2131371758));
    this.m = ((FormSwitchItem)findViewById(2131379178));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371962));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afbh(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378916));
    this.k = ((FormSwitchItem)findViewById(2131363077));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364005));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377606));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131371843));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371844));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afbn(this));
    int i1 = bhsi.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    label608:
    boolean bool3;
    int i2;
    if ((i1 != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131365669).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + i1);
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131377851);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377607));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377603));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377609));
      this.f = ((FormSwitchItem)findViewById(2131377616));
      this.j = ((FormSwitchItem)findViewById(2131377628));
      this.g = ((FormSwitchItem)findViewById(2131376249));
      this.h = ((FormSwitchItem)findViewById(2131370381));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367292));
      this.i = ((FormSwitchItem)findViewById(2131372354));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afbo(this));
      this.n = ((FormSwitchItem)findViewById(2131377883));
      Object localObject = (anum)this.app.a(2);
      this.n.setOnCheckedChangeListener(new afbp(this, (anum)localObject));
      bool1 = blhw.a();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.n.setChecked(bool1);
      ((anum)localObject).c(bool1);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377885));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afbq(this));
      if (this.app == null) {
        break label1946;
      }
      if (this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850403));
      }
      if (argx.a(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1941;
      }
      i1 = 1;
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131717560), "qqsetting_notify_showcontent_key", true);
      this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131717558), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131717556) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131717380), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131693438), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(44);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).b();
        if (bool8)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new afbr(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!bool8) {
          break label1960;
        }
        i2 = 0;
        label886:
        ((FormSwitchItem)localObject).setVisibility(i2);
      }
      boolean bool8 = mrl.a(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label1966;
      }
      i2 = 0;
      label911:
      ThreadManager.excute(new NotifyPushSettingActivity.8(this, i2), 16, null, false);
      this.k.setVisibility(0);
      this.k.setChecked(bool8);
      bool8 = this.jdField_a_of_type_Axdx.b();
      this.l.setChecked(bool8);
      this.l.setOnCheckedChangeListener(this.jdField_a_of_type_Axdx.a(this, this.l, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.m));
      localObject = this.m;
      if ((!this.l.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
        break label1971;
      }
      i2 = 0;
      label1017:
      ((FormSwitchItem)localObject).setVisibility(i2);
      if (this.jdField_a_of_type_Anxm != null)
      {
        this.m.setChecked(this.jdField_a_of_type_Anxm.b());
        this.m.setOnCheckedChangeListener(this.jdField_a_of_type_Anxm.a(this, this.m));
        if (this.jdField_a_of_type_Anxm.h()) {
          this.m.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Axdx.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afbs(this);
      this.k.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new afax(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706527));
      }
      a(this.jdField_e_of_type_Boolean);
      if (Build.VERSION.SDK_INT < 26) {
        break label1977;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1184:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new afaz(this));
      if (!blgq.a(this.app.getApplication())) {
        break label2012;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label1229:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new afba(this));
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new afbb(this));
      this.app.addObserver(this.jdField_a_of_type_Anuw, true);
      localObject = (anum)this.app.a(2);
      this.i.setChecked(bool7);
      this.i.setOnCheckedChangeListener(new afbc(this, (anum)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      anum localanum = (anum)this.app.a(2);
      this.f.setChecked(bool3);
      this.f.setContentDescription(getString(2131718258));
      this.f.setOnCheckedChangeListener(new afbd(this, localanum));
      if (i1 == 0) {
        break label2024;
      }
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131718263));
      this.j.setOnCheckedChangeListener(new afbe(this, localanum));
      label1463:
      if (localObject != null)
      {
        ((anum)localObject).g();
        localanum.i();
        localanum.h();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label2036;
      }
      this.i.setVisibility(0);
      label1516:
      this.h.setChecked(bool2);
      if (!a()) {
        break label2048;
      }
      this.h.setChecked(false);
      this.h.setVisibility(8);
    }
    for (;;)
    {
      this.h.setOnCheckedChangeListener(new afbf(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.h.setContentDescription(anzj.a(2131706536));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new afbg(this));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afbi(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new afbj(this));
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(anzj.a(2131706533));
        this.l.setContentDescription(getString(2131693987));
        this.m.setContentDescription(getString(2131718773));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694045) + getString(2131717935));
        this.k.setContentDescription(anzj.a(2131706532));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706523));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131717558));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706520));
        this.g.setContentDescription(anzj.a(2131706534));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694440));
        this.i.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716142));
        this.n.setContentDescription(getString(2131716143));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131706530));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718663));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694440));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694441));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691185));
      }
      ((anvl)this.app.a(4)).e();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131365669).setVisibility(0);
      break;
      label1941:
      i1 = 0;
      break label608;
      label1946:
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      i1 = 0;
      break label608;
      label1960:
      i2 = 8;
      break label886;
      label1966:
      i2 = 1;
      break label911;
      label1971:
      i2 = 8;
      break label1017;
      label1977:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new afay(this));
      break label1184;
      label2012:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label1229;
      label2024:
      this.j.setVisibility(8);
      break label1463;
      label2036:
      this.i.setVisibility(8);
      break label1516;
      label2048:
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
    paramQQAppInterface.a(new NotifyPushSettingActivity.22(paramQQAppInterface, paramString));
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
    int i2 = 0;
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
        break label183;
      }
      i1 = 0;
      label72:
      localFormSwitchItem.setVisibility(i1);
      localFormSwitchItem = this.m;
      if ((!this.l.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
        break label189;
      }
      i1 = 0;
      label106:
      localFormSwitchItem.setVisibility(i1);
      if ((this.jdField_a_of_type_Anxm != null) && (this.jdField_a_of_type_Anxm.h())) {
        this.m.setVisibility(8);
      }
      localFormSwitchItem = this.k;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
        break label195;
      }
    }
    label183:
    label189:
    label195:
    for (int i1 = i2;; i1 = 8)
    {
      localFormSwitchItem.setVisibility(i1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      i1 = 8;
      break label72;
      i1 = 8;
      break label106;
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559528);
    setTitle(2131717969);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_Axdx = axdx.a(this.app);
    this.jdField_a_of_type_Anxm = anxm.a(this.app);
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
      this.app.removeObserver(this.jdField_a_of_type_Anuw);
      if (blgq.a(this.app.getApplication())) {
        blgq.c();
      }
    }
    this.jdField_a_of_type_Axdx.a();
    this.jdField_a_of_type_Anxm.a();
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
      int i1 = (int)NetConnInfoCenter.getServerTime();
      int i2 = SettingCloneUtil.readValueForInt(getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().setText(anzj.a(2131706522) + afbt.a((i2 - i1) * 1000));
    }
    this.jdField_a_of_type_Axdx.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k, this.m);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public String setLastActivityName()
  {
    return getString(2131717940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */