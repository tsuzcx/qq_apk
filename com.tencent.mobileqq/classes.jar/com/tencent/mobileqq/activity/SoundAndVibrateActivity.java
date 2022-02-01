package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  implements MessageNotificationSettingManager.RingCallback
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  MessageNotificationSettingManager jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private HashMap<Integer, SoundAndVibrateActivity.MenuItemInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
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
    String str = getResources().getString(2131718859);
    int i = paramTextView.getCurrentTextColor();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTextView.getText());
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    localSpannableString.setSpan(new SoundAndVibrateActivity.16(this), ((String)localObject).length() - str.length(), ((String)localObject).length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        Object localObject = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        ((Intent)localObject).putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        ((Intent)localObject).putExtra("android.provider.extra.CHANNEL_ID", paramString);
        startActivity((Intent)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("go to channel setting  notificationChannelId: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception paramString)
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
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 1);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719205));
      }
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 2);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719204));
    }
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void c()
  {
    int i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app);
    boolean bool2 = false;
    boolean bool1 = false;
    FormSwitchItem localFormSwitchItem;
    if (i == 0)
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.app.getALLGeneralSettingRing() != 0) {
        bool1 = true;
      }
      localFormSwitchItem.setChecked(bool1);
    }
    else
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      bool1 = bool2;
      if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) == 1) {
        bool1 = true;
      }
      localFormSwitchItem.setChecked(bool1);
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719205));
        return;
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131719204));
    }
  }
  
  private void c(int paramInt)
  {
    FormSwitchItem localFormSwitchItem;
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      ViewUtils.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      localFormSwitchItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (localFormSwitchItem != null) {
        localFormSwitchItem.setBgType(1);
      }
    }
    else
    {
      ViewUtils.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
      localFormSwitchItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (localFormSwitchItem != null) {
        localFormSwitchItem.setBgType(3);
      }
    }
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
      SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo = (SoundAndVibrateActivity.MenuItemInfo)localIterator.next();
      if (localMenuItemInfo.jdField_a_of_type_Int == paramInt)
      {
        localMenuItemInfo.jdField_a_of_type_Boolean = true;
        int i = this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a();
        this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localMenuItemInfo.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void e()
  {
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo1 = new SoundAndVibrateActivity.MenuItemInfo(this, 0, getResources().getString(2131719179), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo2 = new SoundAndVibrateActivity.MenuItemInfo(this, 1, getResources().getString(2131719180), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo3 = new SoundAndVibrateActivity.MenuItemInfo(this, 2, getResources().getString(2131719181), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo4 = new SoundAndVibrateActivity.MenuItemInfo(this, 3, getResources().getString(2131719182), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo5 = new SoundAndVibrateActivity.MenuItemInfo(this, 2131372230, getResources().getString(2131690707), false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), localMenuItemInfo1);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localMenuItemInfo2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localMenuItemInfo3);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), localMenuItemInfo4);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localMenuItemInfo5);
  }
  
  Boolean a()
  {
    if ((!this.app.isRingerVibrate()) && (!this.app.isRingEqualsZero()) && (this.app.isCallIdle()) && ((this.app.getCheckPttListener() == null) || (!this.app.getCheckPttListener().f()))) {
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377713));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131380484));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367821));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367822));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367385));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367386));
    if (Build.VERSION.SDK_INT <= 28)
    {
      ViewUtils.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      ViewUtils.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 0);
      ViewUtils.b(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 8);
    }
    else
    {
      ViewUtils.b(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
      ViewUtils.b(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem, 8);
      ViewUtils.b(this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377748));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131377714));
    Object localObject1 = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSimpleItem)localObject1).setVisibility(i);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377485));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370446));
    localObject1 = this.app.getCurrentUin();
    boolean bool1 = SettingCloneUtil.readValue(this, (String)localObject1, getString(2131718400), "qqsetting_notify_showcontent_key", true);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
    Object localObject2 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSwitchItem)localObject2).setVisibility(i);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.1(this, (String)localObject1));
    boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject1, getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
    if (NotifyPushSettingActivity.a())
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else if (bool1)
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    else
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.2(this, (String)localObject1));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("锁屏显示消息弹框");
    }
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720193));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693086));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719178));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693081));
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377722);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380100));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380099));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380101));
    e();
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131380102));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377712));
    if (k != 0)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      c(0);
      i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this.app);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canVibratorGroup :");
        ((StringBuilder)localObject1).append(i);
        QLog.d("SoundSetting", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 0) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      } else {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
    }
    else
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      c(8);
    }
    if (j != 0)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      i = SettingCloneUtil.readValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
      if ((!localSharedPreferences.getBoolean(((StringBuilder)localObject1).toString(), false)) && (i == jdField_b_of_type_Int))
      {
        localObject1 = localSharedPreferences.edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true);
        ((SharedPreferences.Editor)localObject1).commit();
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (i == 2131230720)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        d(0);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131719179));
          ((StringBuilder)localObject2).append(getString(2131690858));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i == 2131230721)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        d(1);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131719180));
          ((StringBuilder)localObject2).append(getString(2131690858));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i == jdField_a_of_type_Int)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        d(2);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131719181));
          ((StringBuilder)localObject2).append(getString(2131690858));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i == jdField_b_of_type_Int)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        d(3);
        SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
      }
      else
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        d(1);
      }
      i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.app);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canPlayGroupSound :");
        ((StringBuilder)localObject1).append(i);
        QLog.d("SoundSetting", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
      localObject1 = ThemeUtil.getUserCurrentThemeId(this.app);
      if (!((String)localObject1).equals("1000"))
      {
        localObject1 = ThemeUtil.getThemeInfo(this, (String)localObject1);
        if ((localObject1 != null) && (((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme))
        {
          i = 1;
          break label1422;
        }
      }
      i = 0;
      label1422:
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("theme_voice_setting_");
        ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
        if (localSharedPreferences.getBoolean(((StringBuilder)localObject1).toString(), true)) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        } else {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        }
      }
      else
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.3(this));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.4(this));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.5(this));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.6(this));
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839449);
    } else {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839433);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.7(this));
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839449);
    } else {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839433);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.8(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.9(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.10(this));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.11(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.12(this));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.13(this, localSharedPreferences));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377748));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377749));
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new SoundAndVibrateActivity.14(this));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new SoundAndVibrateActivity.15(this));
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
    }
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt);
  }
  
  /* Error */
  void a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 658	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   11: dup
    //   12: invokespecial 659	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   15: putfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 4
    //   27: aload 5
    //   29: astore_2
    //   30: aload 6
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   37: ifnonnull +4 -> 41
    //   40: return
    //   41: aload 5
    //   43: astore_2
    //   44: aload 6
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: invokevirtual 664	android/media/MediaPlayer:reset	()V
    //   54: aload 5
    //   56: astore_2
    //   57: aload 6
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 667	android/net/Uri:getScheme	()Ljava/lang/String;
    //   64: ldc_w 669
    //   67: invokevirtual 569	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +72 -> 142
    //   73: aload 5
    //   75: astore_2
    //   76: aload 6
    //   78: astore_3
    //   79: new 671	java/io/FileInputStream
    //   82: dup
    //   83: new 673	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 676	android/net/Uri:getPath	()Ljava/lang/String;
    //   91: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 680	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   102: aload_1
    //   103: invokevirtual 684	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   106: invokevirtual 688	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   109: aload_0
    //   110: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   113: iconst_3
    //   114: invokevirtual 691	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   117: aload_0
    //   118: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: invokevirtual 694	android/media/MediaPlayer:prepare	()V
    //   124: aload_1
    //   125: invokevirtual 697	java/io/FileInputStream:close	()V
    //   128: goto +59 -> 187
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: goto +86 -> 222
    //   139: goto +101 -> 240
    //   142: aload 5
    //   144: astore_2
    //   145: aload 6
    //   147: astore_3
    //   148: aload_0
    //   149: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 700	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   157: aload 5
    //   159: astore_2
    //   160: aload 6
    //   162: astore_3
    //   163: aload_0
    //   164: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   167: iconst_3
    //   168: invokevirtual 691	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   171: aload 5
    //   173: astore_2
    //   174: aload 6
    //   176: astore_3
    //   177: aload_0
    //   178: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   181: invokevirtual 694	android/media/MediaPlayer:prepare	()V
    //   184: aload 4
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: aload_1
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   195: invokevirtual 703	android/media/MediaPlayer:start	()V
    //   198: aload_1
    //   199: astore_2
    //   200: aload_1
    //   201: astore_3
    //   202: aload_0
    //   203: getfield 656	com/tencent/mobileqq/activity/SoundAndVibrateActivity:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   206: iconst_0
    //   207: invokevirtual 706	android/media/MediaPlayer:setLooping	(Z)V
    //   210: aload_1
    //   211: ifnull +43 -> 254
    //   214: aload_1
    //   215: invokevirtual 697	java/io/FileInputStream:close	()V
    //   218: return
    //   219: astore_1
    //   220: aload_2
    //   221: astore_3
    //   222: aload_3
    //   223: ifnull +15 -> 238
    //   226: aload_3
    //   227: invokevirtual 697	java/io/FileInputStream:close	()V
    //   230: goto +8 -> 238
    //   233: astore_2
    //   234: aload_2
    //   235: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   238: aload_1
    //   239: athrow
    //   240: aload_1
    //   241: ifnull +13 -> 254
    //   244: aload_1
    //   245: invokevirtual 697	java/io/FileInputStream:close	()V
    //   248: return
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   254: return
    //   255: astore_1
    //   256: aload_3
    //   257: astore_1
    //   258: goto -18 -> 240
    //   261: astore_2
    //   262: goto -123 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	SoundAndVibrateActivity
    //   0	265	1	paramUri	Uri
    //   29	47	2	localObject1	Object
    //   131	4	2	localObject2	Object
    //   144	77	2	localObject3	Object
    //   233	2	2	localIOException	java.io.IOException
    //   261	1	2	localException	Exception
    //   32	225	3	localObject4	Object
    //   25	160	4	localObject5	Object
    //   19	153	5	localObject6	Object
    //   22	153	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   98	128	131	finally
    //   33	40	219	finally
    //   47	54	219	finally
    //   60	73	219	finally
    //   79	98	219	finally
    //   148	157	219	finally
    //   163	171	219	finally
    //   177	184	219	finally
    //   191	198	219	finally
    //   202	210	219	finally
    //   226	230	233	java/io/IOException
    //   214	218	249	java/io/IOException
    //   244	248	249	java/io/IOException
    //   33	40	255	java/lang/Exception
    //   47	54	255	java/lang/Exception
    //   60	73	255	java/lang/Exception
    //   79	98	255	java/lang/Exception
    //   148	157	255	java/lang/Exception
    //   163	171	255	java/lang/Exception
    //   177	184	255	java/lang/Exception
    //   191	198	255	java/lang/Exception
    //   202	210	255	java/lang/Exception
    //   98	128	261	java/lang/Exception
  }
  
  void b()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  void b(int paramInt)
  {
    FormSimpleItem localFormSimpleItem;
    StringBuilder localStringBuilder;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131719179));
            localStringBuilder.append(getString(2131720100));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131719180));
            localStringBuilder.append(getString(2131720100));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131719181));
            localStringBuilder.append(getString(2131720100));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131719182));
            localStringBuilder.append(getString(2131690858));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
          return;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719179));
          localStringBuilder.append(getString(2131720100));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719180));
          localStringBuilder.append(getString(2131720100));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719181));
          localStringBuilder.append(getString(2131690858));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719182));
          localStringBuilder.append(getString(2131720100));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        }
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131719179));
        localStringBuilder.append(getString(2131720100));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131719180));
        localStringBuilder.append(getString(2131690858));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131719181));
        localStringBuilder.append(getString(2131720100));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131719182));
        localStringBuilder.append(getString(2131720100));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851096));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131719179));
      localStringBuilder.append(getString(2131690858));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131719180));
      localStringBuilder.append(getString(2131720100));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131719181));
      localStringBuilder.append(getString(2131720100));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131719182));
      localStringBuilder.append(getString(2131720100));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
    }
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
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
    super.setContentView(2131562846);
    setTitle(getString(2131694518));
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.app);
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this);
    a();
    return false;
  }
  
  protected void doOnDestroy()
  {
    b();
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.b(this);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a();
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */