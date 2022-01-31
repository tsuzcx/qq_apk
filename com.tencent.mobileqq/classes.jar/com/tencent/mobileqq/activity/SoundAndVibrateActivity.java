package com.tencent.mobileqq.activity;

import absh;
import absi;
import absj;
import absk;
import absl;
import absm;
import absn;
import abso;
import absp;
import absq;
import absr;
import abss;
import abst;
import absu;
import absv;
import absw;
import ajfq;
import alrm;
import alrp;
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
import awqx;
import bahr;
import bajq;
import bajr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
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
  implements alrp
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  alrm jdField_a_of_type_Alrm;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private HashMap<Integer, absw> jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
    String str1 = getResources().getString(2131653573);
    int i = paramTextView.getCurrentTextColor();
    String str2 = paramTextView.getText() + str1;
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new absn(this), str2.length() - str1.length(), str2.length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bahr.a(this.app, 1);
      if (AppSetting.c) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131653840));
      }
      bajr.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    bahr.a(this.app, 2);
    if (AppSetting.c) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131653839));
    }
    bajr.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (bahr.a(this.app) == 0)
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.app.c() != 0) {}
      for (;;)
      {
        localFormSwitchItem.setChecked(bool1);
        if (AppSetting.c)
        {
          if (!this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break;
          }
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131653840));
        }
        return;
        bool1 = false;
      }
    }
    FormSwitchItem localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bahr.a(this.app) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      break;
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131653839));
  }
  
  private void c(int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      bajq.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      return;
    }
    bajq.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
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
      absw localabsw = (absw)localIterator.next();
      if (localabsw.jdField_a_of_type_Int == paramInt)
      {
        localabsw.jdField_a_of_type_Boolean = true;
        int i = this.jdField_a_of_type_Alrm.a();
        this.jdField_a_of_type_Alrm.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localabsw.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void e()
  {
    absw localabsw1 = new absw(this, 0, getResources().getString(2131653810), false);
    absw localabsw2 = new absw(this, 1, getResources().getString(2131653811), false);
    absw localabsw3 = new absw(this, 2, getResources().getString(2131653812), false);
    absw localabsw4 = new absw(this, 3, getResources().getString(2131653813), false);
    absw localabsw5 = new absw(this, 2131305475, getResources().getString(2131625012), false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), localabsw1);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localabsw2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localabsw3);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), localabsw4);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localabsw5);
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310534));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131313056));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131301566));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131301567));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301234));
    label191:
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 28)
    {
      bajq.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      bajq.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      bajq.b(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310565));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131310535));
      Object localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1339;
      }
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310302));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131303885));
      localObject = this.app.c();
      bool1 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131653032), "qqsetting_notify_showcontent_key", true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      FormSwitchItem localFormSwitchItem = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label1345;
      }
      i = 0;
      label280:
      localFormSwitchItem.setVisibility(i);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absh(this, (String)localObject));
      boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131628378), "qqsetting_lock_screen_whenexit_key", true);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      if (!NotifyPushSettingActivity.a()) {
        break label1351;
      }
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label354:
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abso(this, (String)localObject));
      if (AppSetting.c) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("锁屏显示消息弹框");
      }
      if (AppSetting.c) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      }
      if (AppSetting.c)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131654821));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131627580));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131653808));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131627575));
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131310543);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131312723));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131312722));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131312724));
      e();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131312725));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310533));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
      d(0);
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653810) + getString(2131625238));
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new absp(this));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new absq(this));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new absr(this));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abss(this));
          if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1706;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839160);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abst(this));
          if (!this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1719;
          }
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839160);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absu(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absv(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absi(this));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new absj(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absk(this, localSharedPreferences));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310565));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310566));
        a(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new absl(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new absm(this));
        if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
        }
        c();
        return;
        bajq.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        bajq.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
        bajq.b(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
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
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
          d(1);
          if (!AppSetting.c) {
            break label861;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653811) + getString(2131625238));
          break label861;
        }
        if (i == jdField_a_of_type_Int)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
          d(2);
          if (!AppSetting.c) {
            break label861;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653812) + getString(2131625238));
          break label861;
        }
        if (i == jdField_b_of_type_Int)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
          d(3);
          SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
          break label861;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
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
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839144);
        break label1086;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839144);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Alrm.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653810) + getString(2131625238));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653811) + getString(2131654739));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653812) + getString(2131654739));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653813) + getString(2131654739));
      }
      awqx.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653810) + getString(2131654739));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653811) + getString(2131625238));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653812) + getString(2131654739));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653813) + getString(2131654739));
      }
      awqx.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653810) + getString(2131654739));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653811) + getString(2131654739));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653812) + getString(2131625238));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653813) + getString(2131654739));
      }
      awqx.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130849327));
    if (AppSetting.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653810) + getString(2131654739));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653811) + getString(2131654739));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653812) + getString(2131654739));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653813) + getString(2131625238));
    }
    awqx.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131496833);
    setTitle(getString(2131629062));
    this.jdField_a_of_type_Alrm = alrm.a(this.app);
    this.jdField_a_of_type_Alrm.a(this);
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
    this.jdField_a_of_type_Alrm.b(this);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_a_of_type_Alrm.a();
    this.jdField_a_of_type_Alrm.a(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */