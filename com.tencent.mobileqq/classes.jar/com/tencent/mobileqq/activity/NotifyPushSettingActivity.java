package com.tencent.mobileqq.activity;

import Override;
import aeks;
import aekt;
import aeku;
import aekv;
import aekw;
import aekx;
import aeky;
import aekz;
import aela;
import aelb;
import aelc;
import aeld;
import aele;
import aelf;
import aelg;
import aelh;
import aeli;
import aelj;
import aelk;
import aell;
import aelm;
import aeln;
import aelo;
import aelp;
import aelq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anri;
import ansg;
import anui;
import anvx;
import ardq;
import awxj;
import bhhr;
import bkxs;
import bkyc;
import bkyy;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import mrr;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private aelq jdField_a_of_type_Aelq;
  public BroadcastReceiver a;
  private View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anui jdField_a_of_type_Anui;
  private awxj jdField_a_of_type_Awxj;
  private bkyc jdField_a_of_type_Bkyc = new bkyc(new aeli(this));
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aelh(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aeks(this);
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
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aelj(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367858);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378554));
    this.l = ((FormSwitchItem)findViewById(2131371910));
    this.m = ((FormSwitchItem)findViewById(2131379242));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372118));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aeld(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378981));
    this.k = ((FormSwitchItem)findViewById(2131363111));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364104));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377647));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131371999));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372000));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aelk(this));
    int i1 = bhhr.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    label610:
    boolean bool3;
    int i2;
    if ((i1 != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131365796).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + i1);
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131377895);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377648));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377644));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377650));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377657));
      this.j = ((FormSwitchItem)findViewById(2131377669));
      this.g = ((FormSwitchItem)findViewById(2131376262));
      this.h = ((FormSwitchItem)findViewById(2131370532));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367439));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367440));
      this.i = ((FormSwitchItem)findViewById(2131372511));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aell(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aelm(this));
      this.n = ((FormSwitchItem)findViewById(2131377927));
      Object localObject = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.n.setOnCheckedChangeListener(new aeln(this, (anri)localObject));
      bool1 = bkyy.a();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.n.setChecked(bool1);
      ((anri)localObject).c(bool1);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377929));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aelo(this));
      if (this.app == null) {
        break label1969;
      }
      this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (ardq.a(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1964;
      }
      i1 = 1;
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718178), "qqsetting_notify_showcontent_key", true);
      this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718176), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131718174) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131717979), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131693714), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).b();
        if (bool8)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aelp(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!bool8) {
          break label1983;
        }
        i2 = 0;
        label889:
        ((FormSwitchItem)localObject).setVisibility(i2);
      }
      boolean bool8 = mrr.a(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label1989;
      }
      i2 = 0;
      label914:
      ThreadManager.excute(new NotifyPushSettingActivity.9(this, i2), 16, null, false);
      this.k.setVisibility(0);
      this.k.setChecked(bool8);
      bool8 = this.jdField_a_of_type_Awxj.b();
      this.l.setChecked(bool8);
      this.l.setOnCheckedChangeListener(this.jdField_a_of_type_Awxj.a(this, this.l, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.m));
      localObject = this.m;
      if ((!this.l.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
        break label1994;
      }
      i2 = 0;
      label1020:
      ((FormSwitchItem)localObject).setVisibility(i2);
      if (this.jdField_a_of_type_Anui != null)
      {
        this.m.setChecked(this.jdField_a_of_type_Anui.b());
        this.m.setOnCheckedChangeListener(this.jdField_a_of_type_Anui.a(this, this.m));
        if (this.jdField_a_of_type_Anui.h()) {
          this.m.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Awxj.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aekt(this);
      this.k.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aeku(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707107));
      }
      a(this.jdField_e_of_type_Boolean);
      if (Build.VERSION.SDK_INT < 26) {
        break label2000;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1187:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aekw(this));
      if (!bkxs.a(this.app.getApplication())) {
        break label2035;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label1232:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aekx(this));
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new aeky(this));
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      localObject = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.i.setChecked(bool7);
      this.i.setOnCheckedChangeListener(new aekz(this, (anri)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      anri localanri = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718885));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aela(this, localanri));
      if (i1 == 0) {
        break label2047;
      }
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131718890));
      this.j.setOnCheckedChangeListener(new aelb(this, localanri));
      label1470:
      if (localObject != null)
      {
        ((anri)localObject).g();
        localanri.i();
        localanri.h();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label2059;
      }
      this.i.setVisibility(0);
      label1523:
      this.h.setChecked(bool2);
      if (!a()) {
        break label2071;
      }
      this.h.setChecked(false);
      this.h.setVisibility(8);
    }
    for (;;)
    {
      this.h.setOnCheckedChangeListener(new aelc(this));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.h.setContentDescription(anvx.a(2131707115));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aele(this));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aelf(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aelg(this));
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(anvx.a(2131707112));
        this.l.setContentDescription(getString(2131694277));
        this.m.setContentDescription(getString(2131719427));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694344) + getString(2131718562));
        this.k.setContentDescription(anvx.a(2131707111));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707103));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131718176));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707101));
        this.g.setContentDescription(anvx.a(2131707113));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694755));
        this.i.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716737));
        this.n.setContentDescription(getString(2131716738));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131707109));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719305));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694755));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694756));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691309));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694491));
      }
      ((ansg)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131365796).setVisibility(0);
      break;
      label1964:
      i1 = 0;
      break label610;
      label1969:
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      i1 = 0;
      break label610;
      label1983:
      i2 = 8;
      break label889;
      label1989:
      i2 = 1;
      break label914;
      label1994:
      i2 = 8;
      break label1020;
      label2000:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aekv(this));
      break label1187;
      label2035:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label1232;
      label2047:
      this.j.setVisibility(8);
      break label1470;
      label2059:
      this.i.setVisibility(8);
      break label1523;
      label2071:
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
    paramQQAppInterface.execute(new NotifyPushSettingActivity.23(paramQQAppInterface, paramString));
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
      if ((this.jdField_a_of_type_Anui != null) && (this.jdField_a_of_type_Anui.h())) {
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
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559563);
    setTitle(2131718596);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_Awxj = awxj.a(this.app);
    this.jdField_a_of_type_Anui = anui.a(this.app);
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
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (bkxs.a(this.app.getApplication())) {
        bkxs.c();
      }
    }
    this.jdField_a_of_type_Awxj.a();
    this.jdField_a_of_type_Anui.a();
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().setText(anvx.a(2131707102) + aelq.a((i2 - i1) * 1000));
    }
    this.jdField_a_of_type_Awxj.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k, this.m);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public String setLastActivityName()
  {
    return getString(2131718567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */