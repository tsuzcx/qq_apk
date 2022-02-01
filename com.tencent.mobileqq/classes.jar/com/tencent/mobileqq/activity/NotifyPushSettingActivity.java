package com.tencent.mobileqq.activity;

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
import com.tencent.av.utils.AVUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.MultiImageTextView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  public BroadcastReceiver a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NotifyPushSettingActivity.TimePickDialog jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity$TimePickDialog;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new NotifyPushSettingActivity.24(this);
  private ForegroundNotifyManager jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
  private NewMsgNotificationManager jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(new NotifyPushSettingActivity.25(this));
  String jdField_a_of_type_JavaLangString = "";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingActivity.1(this);
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
  private boolean jdField_e_of_type_Boolean = false;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new NotifyPushSettingActivity.26(this);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368066);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378985));
    this.l = ((FormSwitchItem)findViewById(2131372217));
    this.m = ((FormSwitchItem)findViewById(2131379676));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372419));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379412));
    this.k = ((FormSwitchItem)findViewById(2131363157));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364207));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378058));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131372307));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372308));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.3(this));
    int i1 = SharedPreUtils.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    label611:
    boolean bool3;
    int i2;
    if ((i1 != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131365959).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + i1);
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131378308);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378059));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378055));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378061));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378068));
      this.j = ((FormSwitchItem)findViewById(2131378080));
      this.g = ((FormSwitchItem)findViewById(2131376657));
      this.h = ((FormSwitchItem)findViewById(2131370815));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367626));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367627));
      this.i = ((FormSwitchItem)findViewById(2131372821));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.4(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.5(this));
      this.n = ((FormSwitchItem)findViewById(2131378342));
      Object localObject = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.n.setOnCheckedChangeListener(new NotifyPushSettingActivity.6(this, (CardHandler)localObject));
      bool1 = NotifyIdManager.a();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.n.setChecked(bool1);
      ((CardHandler)localObject).c(bool1);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378344));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.7(this));
      if (this.app == null) {
        break label1991;
      }
      this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (PushMsgBtnConfProcessor.a(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1986;
      }
      i1 = 1;
      bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718682), "qqsetting_notify_showcontent_key", true);
      this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718680), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131718678) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718470), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131693883), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).a.b();
        if (bool8)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a.a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.8(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!bool8) {
          break label2005;
        }
        i2 = 0;
        label896:
        ((FormSwitchItem)localObject).setVisibility(i2);
      }
      boolean bool8 = AVUtil.a(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label2011;
      }
      i2 = 0;
      label921:
      ThreadManager.excute(new NotifyPushSettingActivity.9(this, i2), 16, null, false);
      this.k.setVisibility(0);
      this.k.setChecked(bool8);
      bool8 = this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.b();
      this.l.setChecked(bool8);
      this.l.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this, this.l, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.m));
      localObject = this.m;
      if ((!this.l.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
        break label2016;
      }
      i2 = 0;
      label1027:
      ((FormSwitchItem)localObject).setVisibility(i2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager != null)
      {
        this.m.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.b());
        this.m.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a(this, this.m));
        if (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.h()) {
          this.m.setVisibility(8);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this, this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingActivity.10(this);
      this.k.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.11(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707632));
      }
      a(this.jdField_e_of_type_Boolean);
      if (Build.VERSION.SDK_INT < 26) {
        break label2022;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1194:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.13(this));
      if (!BadgeUtils.a(this.app.getApplication())) {
        break label2057;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label1239:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.14(this));
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new NotifyPushSettingActivity.15(this));
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      localObject = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.i.setChecked(bool7);
      this.i.setOnCheckedChangeListener(new NotifyPushSettingActivity.16(this, (CardHandler)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_hello_live_message", true);
      localObject = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719410));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.17(this, (CardHandler)localObject));
      if (i1 == 0) {
        break label2069;
      }
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131719417));
      this.j.setOnCheckedChangeListener(new NotifyPushSettingActivity.18(this, (CardHandler)localObject));
      label1477:
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
      if (localObject != null)
      {
        ((TempGetProfileDetailProcessor)localObject).getPCActiveState();
        ((TempGetProfileDetailProcessor)localObject).getHelloLiveMessageState();
        ((TempGetProfileDetailProcessor)localObject).getCareBarEnable();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label2081;
      }
      this.i.setVisibility(0);
      label1545:
      this.h.setChecked(bool2);
      if (!a()) {
        break label2093;
      }
      this.h.setChecked(false);
      this.h.setVisibility(8);
    }
    for (;;)
    {
      this.h.setOnCheckedChangeListener(new NotifyPushSettingActivity.19(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.h.setContentDescription(HardCodeUtil.a(2131707640));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingActivity.20(this));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.21(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingActivity.22(this));
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707637));
        this.l.setContentDescription(getString(2131694481));
        this.m.setContentDescription(getString(2131719990));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694553) + getString(2131719085));
        this.k.setContentDescription(HardCodeUtil.a(2131707636));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707628));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131718680));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707626));
        this.g.setContentDescription(HardCodeUtil.a(2131707638));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694993));
        this.i.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717232));
        this.n.setContentDescription(getString(2131717233));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707634));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719860));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694993));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694994));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691419));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694708));
      }
      ((ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131365959).setVisibility(0);
      break;
      label1986:
      i1 = 0;
      break label611;
      label1991:
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      i1 = 0;
      break label611;
      label2005:
      i2 = 8;
      break label896;
      label2011:
      i2 = 1;
      break label921;
      label2016:
      i2 = 8;
      break label1027;
      label2022:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.12(this));
      break label1194;
      label2057:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label1239;
      label2069:
      this.j.setVisibility(8);
      break label1477;
      label2081:
      this.i.setVisibility(8);
      break label1545;
      label2093:
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
      if ((this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.h())) {
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
    super.setContentView(2131559636);
    setTitle(2131719119);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager = NewMsgNotificationManager.a(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager = ForegroundNotifyManager.a(this.app);
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
      if (BadgeUtils.a(this.app.getApplication())) {
        BadgeUtils.c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a();
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().setText(HardCodeUtil.a(2131707627) + NotifyPushSettingActivity.TimePickDialog.a((i2 - i1) * 1000));
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k, this.m);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public String setLastActivityName()
  {
    return getString(2131719090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */