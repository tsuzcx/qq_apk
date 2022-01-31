package com.tencent.mobileqq.activity;

import accp;
import accq;
import accr;
import accs;
import acct;
import accu;
import accv;
import accw;
import accx;
import accy;
import accz;
import acda;
import acdb;
import acdc;
import acdd;
import acde;
import ajtq;
import amgb;
import amge;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import axqy;
import bbjl;
import bbll;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
  implements amge
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  amgb jdField_a_of_type_Amgb;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private HashMap<Integer, acde> jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
    String str1 = getResources().getString(2131719413);
    int i = paramTextView.getCurrentTextColor();
    String str2 = paramTextView.getText() + str1;
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new accv(this), str2.length() - str1.length(), str2.length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bbjl.a(this.app, 1);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719735));
      }
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    bbjl.a(this.app, 2);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719734));
    }
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (bbjl.a(this.app) == 0)
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.app.c() != 0) {}
      for (;;)
      {
        localFormSwitchItem.setChecked(bool1);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          if (!this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break;
          }
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719735));
        }
        return;
        bool1 = false;
      }
    }
    FormSwitchItem localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bbjl.a(this.app) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      break;
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719734));
  }
  
  private void c(int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      bbll.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      return;
    }
    bbll.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
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
      acde localacde = (acde)localIterator.next();
      if (localacde.jdField_a_of_type_Int == paramInt)
      {
        localacde.jdField_a_of_type_Boolean = true;
        int i = this.jdField_a_of_type_Amgb.a();
        this.jdField_a_of_type_Amgb.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localacde.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void e()
  {
    acde localacde1 = new acde(this, 0, getResources().getString(2131719705), false);
    acde localacde2 = new acde(this, 1, getResources().getString(2131719706), false);
    acde localacde3 = new acde(this, 2, getResources().getString(2131719707), false);
    acde localacde4 = new acde(this, 3, getResources().getString(2131719708), false);
    acde localacde5 = new acde(this, 2131371169, getResources().getString(2131690573), false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), localacde1);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localacde2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localacde3);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), localacde4);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localacde5);
  }
  
  public Boolean a()
  {
    if ((!this.app.k()) && (!this.app.l()) && (this.app.m()) && ((this.app.a() == null) || (!this.app.a().k()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    int j = this.app.c();
    int k = this.app.d();
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376328));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378885));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367178));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367179));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131366843));
    label191:
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 28)
    {
      bbll.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      bbll.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      bbll.b(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376360));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131376329));
      Object localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1339;
      }
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376096));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131369559));
      localObject = this.app.c();
      bool1 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131718870), "qqsetting_notify_showcontent_key", true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      FormSwitchItem localFormSwitchItem = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1345;
      }
      i = 0;
      label280:
      localFormSwitchItem.setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new accp(this, (String)localObject));
      boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131694020), "qqsetting_lock_screen_whenexit_key", true);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      if (!NotifyPushSettingActivity.a()) {
        break label1351;
      }
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label354:
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new accw(this, (String)localObject));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("锁屏显示消息弹框");
      }
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      }
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720730));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693221));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719703));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693216));
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376337);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378552));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378551));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378553));
      e();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378554));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376327));
      if (k == 0) {
        break label1390;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      c(0);
      i = this.app.b();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canVibratorGroup :" + i);
      }
      if (i != 0) {
        break label1379;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label620:
      if (j == 0) {
        break label1668;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (i != 2131230720) {
        break label1407;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
      d(0);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719705) + getString(2131690799));
      }
      label861:
      i = this.app.a();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canPlayGroupSound :" + i);
      }
      if (i != 0) {
        break label1634;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label914:
      localObject = ThemeUtil.getUserCurrentThemeId(this.app);
      if (((String)localObject).equals("1000")) {
        break label1732;
      }
      localObject = ThemeUtil.getThemeInfo(this, (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
        break label1732;
      }
    }
    label1086:
    label1345:
    label1732:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (localSharedPreferences.getBoolean("theme_voice_setting_" + this.app.getCurrentAccountUin(), true))
        {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          label1006:
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new accx(this));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new accy(this));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new accz(this));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new acda(this));
          if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1706;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839185);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acdb(this));
          if (!this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1719;
          }
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839185);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acdc(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acdd(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new accq(this));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new accr(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new accs(this, localSharedPreferences));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376360));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376361));
        a(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acct(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new accu(this));
        if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
        }
        c();
        return;
        bbll.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        bbll.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        bbll.b(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
        break;
        i = 8;
        break label191;
        i = 8;
        break label280;
        label1351:
        if (bool1)
        {
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          break label354;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label354;
        label1379:
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label620;
        label1390:
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        c(8);
        break label620;
        label1407:
        if (i == 2131230721)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
          d(1);
          if (!AppSetting.jdField_d_of_type_Boolean) {
            break label861;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719706) + getString(2131690799));
          break label861;
        }
        if (i == jdField_a_of_type_Int)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
          d(2);
          if (!AppSetting.jdField_d_of_type_Boolean) {
            break label861;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719707) + getString(2131690799));
          break label861;
        }
        if (i == jdField_b_of_type_Int)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
          d(3);
          SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
          break label861;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
        d(1);
        break label861;
        label1634:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label914;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break label1006;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label1006;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label1006;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839169);
        break label1086;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839169);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Amgb.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt);
  }
  
  public void a(Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      if (paramUri.getScheme().equals("file"))
      {
        paramUri = new FileInputStream(new File(paramUri.getPath()));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUri.getFD());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        paramUri.close();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        return;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      }
      return;
    }
    catch (Exception paramUri) {}
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719705) + getString(2131690799));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719706) + getString(2131720648));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719707) + getString(2131720648));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719708) + getString(2131720648));
      }
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719705) + getString(2131720648));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719706) + getString(2131690799));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719707) + getString(2131720648));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719708) + getString(2131720648));
      }
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719705) + getString(2131720648));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719706) + getString(2131720648));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719707) + getString(2131690799));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719708) + getString(2131720648));
      }
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849571));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719705) + getString(2131720648));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719706) + getString(2131720648));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719707) + getString(2131720648));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719708) + getString(2131690799));
    }
    axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562432);
    setTitle(getString(2131694728));
    this.jdField_a_of_type_Amgb = amgb.a(this.app);
    this.jdField_a_of_type_Amgb.a(this);
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
    this.jdField_a_of_type_Amgb.b(this);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_a_of_type_Amgb.a();
    this.jdField_a_of_type_Amgb.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */