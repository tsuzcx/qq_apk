package com.tencent.mobileqq.activity;

import Override;
import aegt;
import aegu;
import aegv;
import aegw;
import aegx;
import aegy;
import aegz;
import aeha;
import aehb;
import aehc;
import aehd;
import aehe;
import aehf;
import aehg;
import aehh;
import aehi;
import aehj;
import ampg;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import apka;
import apkd;
import bcef;
import bfyq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
  implements apkd
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  apka jdField_a_of_type_Apka;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private HashMap<Integer, aehj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private FormSimpleItem b;
  public FormSwitchItem b;
  private final int jdField_c_of_type_Int = 1;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_d_of_type_Int = 0;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_e_of_type_Int = 1;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_f_of_type_Int = 2;
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_g_of_type_Int = 3;
  private FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_h_of_type_Int = 4;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  static
  {
    jdField_a_of_type_Int = AppSetting.jdField_d_of_type_Int;
    jdField_b_of_type_Int = AppSetting.jdField_e_of_type_Int;
    jdField_a_of_type_JavaLangString = "user_choose_";
  }
  
  private void a(TextView paramTextView)
  {
    String str1 = getResources().getString(2131718231);
    int i = paramTextView.getCurrentTextColor();
    String str2 = paramTextView.getText() + str1;
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new aeha(this), str2.length() - str1.length(), str2.length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      Intent localIntent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
      localIntent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
      localIntent.putExtra("android.provider.extra.CHANNEL_ID", paramString);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "go to channel setting  notificationChannelId: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        try
        {
          paramString = new Intent();
          paramString.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          paramString.setData(Uri.fromParts("package", getPackageName(), null));
          startActivity(paramString);
          if (QLog.isColorLevel())
          {
            QLog.d("IphoneTitleBarActivity", 2, "go to system setting");
            return;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          QLog.e("IphoneTitleBarActivity", 2, "go to setting fail");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bfyq.a(this.app, 1);
      if (AppSetting.c) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131718571));
      }
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    bfyq.a(this.app, 2);
    if (AppSetting.c) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131718570));
    }
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (bfyq.a(this.app) == 0)
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.app.getALLGeneralSettingRing() != 0) {}
      for (;;)
      {
        localFormSwitchItem.setChecked(bool1);
        if (AppSetting.c)
        {
          if (!this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break;
          }
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131718571));
        }
        return;
        bool1 = false;
      }
    }
    FormSwitchItem localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bfyq.a(this.app) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      break;
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131718570));
  }
  
  private void c(int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      ViewUtils.setVisible(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      return;
    }
    ViewUtils.setVisible(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
  }
  
  private void d()
  {
    startActivity(new Intent(getActivity(), SpecailCareListActivity.class));
  }
  
  private void d(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aehj localaehj = (aehj)localIterator.next();
      if (localaehj.jdField_a_of_type_Int == paramInt)
      {
        localaehj.jdField_a_of_type_Boolean = true;
        int i = this.jdField_a_of_type_Apka.a();
        this.jdField_a_of_type_Apka.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localaehj.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void e()
  {
    aehj localaehj1 = new aehj(this, 0, getResources().getString(2131718548), false);
    aehj localaehj2 = new aehj(this, 1, getResources().getString(2131718549), false);
    aehj localaehj3 = new aehj(this, 2, getResources().getString(2131718550), false);
    aehj localaehj4 = new aehj(this, 3, getResources().getString(2131718551), false);
    aehj localaehj5 = new aehj(this, 2131372150, getResources().getString(2131690600), false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), localaehj1);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localaehj2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localaehj3);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), localaehj4);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localaehj5);
  }
  
  public Boolean a()
  {
    if ((!this.app.isRingerVibrate()) && (!this.app.isRingEqualsZero()) && (this.app.isCallIdle()) && ((this.app.getCheckPttListener() == null) || (!this.app.getCheckPttListener().isRecordingOrPlaying()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    int j = this.app.getALLGeneralSettingRing();
    int k = this.app.getALLGeneralSettingVibrate();
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377618));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131380441));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367725));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367726));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367319));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367320));
    label214:
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 28)
    {
      ViewUtils.setVisible(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      ViewUtils.setVisible(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      ViewUtils.setVisible(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
      ViewUtils.setVisible(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377650));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377619));
      Object localObject = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1377;
      }
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377374));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370349));
      localObject = this.app.getCurrentUin();
      bool1 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131717796), "qqsetting_notify_showcontent_key", true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      FormSwitchItem localFormSwitchItem = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1383;
      }
      i = 0;
      label303:
      localFormSwitchItem.setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aegt(this, (String)localObject));
      boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131693533), "qqsetting_lock_screen_whenexit_key", true);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      if (!NotifyPushSettingActivity.a()) {
        break label1389;
      }
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label377:
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aehb(this, (String)localObject));
      if (AppSetting.c) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("锁屏显示消息弹框");
      }
      if (AppSetting.c) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      }
      if (AppSetting.c)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719453));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131692875));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718547));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131692870));
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131377627);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380058));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380057));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380059));
      e();
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380060));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377617));
      if (k == 0) {
        break label1428;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      c(0);
      i = this.app.getTroopGeneralSettingVibrate();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canVibratorGroup :" + i);
      }
      if (i != 0) {
        break label1417;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label643:
      if (j == 0) {
        break label1706;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      i = SettingCloneUtil.readValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
      if ((!localSharedPreferences.getBoolean(jdField_a_of_type_JavaLangString + this.app.getCurrentAccountUin(), false)) && (i == jdField_b_of_type_Int))
      {
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putBoolean(jdField_a_of_type_JavaLangString + this.app.getCurrentAccountUin(), true);
        ((SharedPreferences.Editor)localObject).commit();
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (i != 2131230720) {
        break label1445;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
      d(0);
      if (AppSetting.c) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718548) + getString(2131690748));
      }
      label884:
      i = this.app.getTroopGeneralSettingRing();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canPlayGroupSound :" + i);
      }
      if (i != 0) {
        break label1672;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label937:
      localObject = ThemeUtil.getUserCurrentThemeId(this.app);
      if (((String)localObject).equals("1000")) {
        break label1770;
      }
      localObject = ThemeUtil.getThemeInfo(this, (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
        break label1770;
      }
    }
    label1029:
    label1109:
    label1377:
    label1383:
    label1770:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (localSharedPreferences.getBoolean("theme_voice_setting_" + this.app.getCurrentAccountUin(), true))
        {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aehc(this));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aehd(this));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aehe(this));
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aehf(this));
          if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1744;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839491);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aehg(this));
          if (!this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1757;
          }
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839491);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aehh(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aehi(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aegu(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aegv(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aegw(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aegx(this, localSharedPreferences));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377650));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377651));
        a(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aegy(this));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aegz(this));
        if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
        }
        c();
        return;
        ViewUtils.setVisible(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        ViewUtils.setVisible(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        ViewUtils.setVisible(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
        break;
        i = 8;
        break label214;
        i = 8;
        break label303;
        label1389:
        if (bool1)
        {
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          break label377;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label377;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label643;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        c(8);
        break label643;
        if (i == 2131230721)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
          d(1);
          if (!AppSetting.c) {
            break label884;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718549) + getString(2131690748));
          break label884;
        }
        if (i == jdField_a_of_type_Int)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
          d(2);
          if (!AppSetting.c) {
            break label884;
          }
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718550) + getString(2131690748));
          break label884;
        }
        if (i == jdField_b_of_type_Int)
        {
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
          d(3);
          SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
          break label884;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
        d(1);
        break label884;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label937;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break label1029;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label1029;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label1029;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839475);
        break label1109;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839475);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Apka.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt);
  }
  
  /* Error */
  public void a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 650	android/media/MediaPlayer
    //   11: dup
    //   12: invokespecial 651	android/media/MediaPlayer:<init>	()V
    //   15: putfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnonnull +22 -> 48
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 653	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 654	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: return
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 655	java/io/IOException:printStackTrace	()V
    //   47: return
    //   48: aload_0
    //   49: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   52: invokevirtual 658	android/media/MediaPlayer:reset	()V
    //   55: aload_1
    //   56: invokevirtual 661	android/net/Uri:getScheme	()Ljava/lang/String;
    //   59: ldc_w 663
    //   62: invokevirtual 555	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +106 -> 171
    //   68: new 665	java/io/FileInputStream
    //   71: dup
    //   72: new 667	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokevirtual 670	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: invokespecial 671	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: aload_1
    //   88: astore_3
    //   89: aload_1
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   95: aload_1
    //   96: invokevirtual 678	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   99: invokevirtual 682	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   102: aload_1
    //   103: astore_3
    //   104: aload_1
    //   105: astore_2
    //   106: aload_0
    //   107: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   110: iconst_3
    //   111: invokevirtual 685	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   114: aload_1
    //   115: astore_3
    //   116: aload_1
    //   117: astore_2
    //   118: aload_0
    //   119: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   122: invokevirtual 688	android/media/MediaPlayer:prepare	()V
    //   125: aload_1
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 691	java/io/FileInputStream:close	()V
    //   133: aload_1
    //   134: astore_3
    //   135: aload_1
    //   136: astore_2
    //   137: aload_0
    //   138: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   141: invokevirtual 694	android/media/MediaPlayer:start	()V
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: astore_2
    //   148: aload_0
    //   149: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: iconst_0
    //   153: invokevirtual 697	android/media/MediaPlayer:setLooping	(Z)V
    //   156: aload_1
    //   157: ifnull -116 -> 41
    //   160: aload_1
    //   161: invokevirtual 691	java/io/FileInputStream:close	()V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 655	java/io/IOException:printStackTrace	()V
    //   170: return
    //   171: aload_0
    //   172: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual 700	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   180: aload_0
    //   181: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   184: iconst_3
    //   185: invokevirtual 685	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   188: aload_0
    //   189: getfield 648	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   192: invokevirtual 688	android/media/MediaPlayer:prepare	()V
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -64 -> 133
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -163 -> 41
    //   207: aload_2
    //   208: invokevirtual 691	java/io/FileInputStream:close	()V
    //   211: return
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 655	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_1
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 691	java/io/FileInputStream:close	()V
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 655	java/io/IOException:printStackTrace	()V
    //   234: goto -7 -> 227
    //   237: astore_1
    //   238: goto -19 -> 219
    //   241: astore_1
    //   242: goto -39 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SoundAndVibrateActivity
    //   0	245	1	paramUri	Uri
    //   24	184	2	localObject	Object
    //   229	2	2	localIOException	java.io.IOException
    //   19	205	3	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   33	41	42	java/io/IOException
    //   160	164	165	java/io/IOException
    //   20	25	200	java/lang/Exception
    //   48	87	200	java/lang/Exception
    //   171	195	200	java/lang/Exception
    //   207	211	212	java/io/IOException
    //   20	25	218	finally
    //   48	87	218	finally
    //   171	195	218	finally
    //   223	227	229	java/io/IOException
    //   91	102	237	finally
    //   106	114	237	finally
    //   118	125	237	finally
    //   129	133	237	finally
    //   137	144	237	finally
    //   148	156	237	finally
    //   91	102	241	java/lang/Exception
    //   106	114	241	java/lang/Exception
    //   118	125	241	java/lang/Exception
    //   129	133	241	java/lang/Exception
    //   137	144	241	java/lang/Exception
    //   148	156	241	java/lang/Exception
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718548) + getString(2131690748));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718549) + getString(2131719368));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718550) + getString(2131719368));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718551) + getString(2131719368));
      }
      bcef.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718548) + getString(2131719368));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718549) + getString(2131690748));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718550) + getString(2131719368));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718551) + getString(2131719368));
      }
      bcef.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718548) + getString(2131719368));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718549) + getString(2131719368));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718550) + getString(2131690748));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718551) + getString(2131719368));
      }
      bcef.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130850620));
    if (AppSetting.c)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718548) + getString(2131719368));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718549) + getString(2131719368));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718550) + getString(2131719368));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718551) + getString(2131690748));
    }
    bcef.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
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
    super.setContentView(2131562806);
    setTitle(getString(2131694147));
    this.jdField_a_of_type_Apka = apka.a(this.app);
    this.jdField_a_of_type_Apka.a(this);
    a();
    return false;
  }
  
  public void doOnDestroy()
  {
    b();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_Apka.b(this);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_a_of_type_Apka.a();
    this.jdField_a_of_type_Apka.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */