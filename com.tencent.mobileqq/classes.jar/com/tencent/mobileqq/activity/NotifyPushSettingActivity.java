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
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367818);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378362));
    this.l = ((FormSwitchItem)findViewById(2131371801));
    this.m = ((FormSwitchItem)findViewById(2131379018));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372001));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378763));
    this.k = ((FormSwitchItem)findViewById(2131363097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364124));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377485));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131371892));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371893));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.3(this));
    int i1 = SharedPreUtils.a(this, "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    if ((i1 != 1) && (!FriendsStatusUtil.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      findViewById(2131365796).setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      findViewById(2131365796).setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showOpen DISTURB=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("IphoneTitleBarActivity", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377716);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377486));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377480));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377488));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377496));
    this.j = ((FormSwitchItem)findViewById(2131377506));
    this.g = ((FormSwitchItem)findViewById(2131376161));
    this.h = ((FormSwitchItem)findViewById(2131370446));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367383));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367384));
    this.i = ((FormSwitchItem)findViewById(2131372400));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.4(this));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.5(this));
    this.n = ((FormSwitchItem)findViewById(2131377751));
    Object localObject = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    this.n.setOnCheckedChangeListener(new NotifyPushSettingActivity.6(this, (CardHandler)localObject));
    boolean bool1 = NotifyIdManager.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI: invoked. special bar enable: ");
      localStringBuilder.append(bool1);
      QLog.i("IphoneTitleBarActivity", 2, localStringBuilder.toString());
    }
    this.n.setChecked(bool1);
    ((CardHandler)localObject).c(bool1);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377753));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.7(this));
    if (this.app != null)
    {
      this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (PushMsgBtnConfProcessor.a(this.app.getApp(), this.app.getAccount()) == 1)
      {
        i1 = 1;
        break label674;
      }
    }
    else
    {
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
    }
    i1 = 0;
    label674:
    bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718400), "qqsetting_notify_showcontent_key", true);
    this.jdField_e_of_type_Boolean = FriendsStatusUtil.a(this);
    boolean bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718398), "qqsetting_notify_blncontrol_key", true);
    boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131718396));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    boolean bool5 = LocalMultiProcConfig.getBool(((StringBuilder)localObject).toString(), true);
    boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131718135), "qqsetting_receivemsg_whenexit_key", true);
    boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
    boolean bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
    SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
    localObject = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    int i2;
    if (localObject != null)
    {
      bool8 = ((BubbleManager)localObject).a.b();
      if (bool8)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a.a());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.8(this, (BubbleManager)localObject));
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool8) {
        i2 = 0;
      } else {
        i2 = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(i2);
    }
    boolean bool8 = AVUtil.a(this.app.getCurrentAccountUin());
    ThreadManager.excute(new NotifyPushSettingActivity.9(this, bool8 ^ true), 16, null, false);
    this.k.setVisibility(0);
    this.k.setChecked(bool8);
    bool8 = this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.b();
    this.l.setChecked(bool8);
    localObject = this.l;
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this, (FormSwitchItem)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.m));
    localObject = this.m;
    if ((this.l.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
    if (localObject != null)
    {
      this.m.setChecked(((ForegroundNotifyManager)localObject).b());
      localObject = this.m;
      ((FormSwitchItem)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a(this, (FormSwitchItem)localObject));
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707657));
    }
    a(this.jdField_e_of_type_Boolean);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.12(this));
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.13(this));
    if (BadgeUtils.a(this.app.getApplication())) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    } else {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719128));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingActivity.17(this, (CardHandler)localObject));
    if (i1 != 0)
    {
      this.j.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.j.setChecked(bool3);
      this.j.setContentDescription(getString(2131719135));
      this.j.setOnCheckedChangeListener(new NotifyPushSettingActivity.18(this, (CardHandler)localObject));
    }
    else
    {
      this.j.setVisibility(8);
    }
    localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (localObject != null)
    {
      ((TempGetProfileDetailProcessor)localObject).getPCActiveState();
      ((TempGetProfileDetailProcessor)localObject).getHelloLiveMessageState();
      ((TempGetProfileDetailProcessor)localObject).getCareBarEnable();
    }
    if (SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
      this.i.setVisibility(0);
    } else {
      this.i.setVisibility(8);
    }
    this.h.setChecked(bool2);
    if (a())
    {
      this.h.setChecked(false);
      this.h.setVisibility(8);
    }
    else if (bool1)
    {
      this.h.setVisibility(0);
      this.h.setVisibility(8);
    }
    else
    {
      this.h.setVisibility(8);
    }
    this.h.setOnCheckedChangeListener(new NotifyPushSettingActivity.19(this));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.h.setContentDescription(HardCodeUtil.a(2131707665));
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingActivity.20(this));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingActivity.21(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingActivity.22(this));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707662));
      this.l.setContentDescription(getString(2131694446));
      this.m.setContentDescription(getString(2131719722));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131694518));
      localStringBuilder.append(getString(2131718802));
      ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
      this.k.setContentDescription(HardCodeUtil.a(2131707661));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707653));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131718398));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707651));
      this.g.setContentDescription(HardCodeUtil.a(2131707663));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694983));
      this.i.setContentDescription("PC离线时自动启动QQ手机版");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716891));
      this.n.setContentDescription(getString(2131716892));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707659));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719592));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694983));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694984));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691341));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694684));
    }
    ((ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    int i2 = 0;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject = this.l;
    int i1;
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
    localObject = this.m;
    if ((this.l.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
    if ((localObject != null) && (((ForegroundNotifyManager)localObject).h())) {
      this.m.setVisibility(8);
    }
    localObject = this.k;
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getRootDirectory());
    localStringBuilder.append("/etc/permissions");
    return new File(localStringBuilder.toString(), "com.lenovo.keyguard.xml").exists();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559513);
    setTitle(2131718837);
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
  
  protected void doOnDestroy()
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
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_e_of_type_Boolean)
    {
      int i1 = (int)NetConnInfoCenter.getServerTime();
      int i2 = SettingCloneUtil.readValueForInt(getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      MultiImageTextView localMultiImageTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707652));
      localStringBuilder.append(NotifyPushSettingActivity.TimePickDialog.a((i2 - i1) * 1000));
      localMultiImageTextView.setText(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this.l, this.jdField_a_of_type_AndroidWidgetTextView, this.k, this.m);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected String setLastActivityName()
  {
    return getString(2131718807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */