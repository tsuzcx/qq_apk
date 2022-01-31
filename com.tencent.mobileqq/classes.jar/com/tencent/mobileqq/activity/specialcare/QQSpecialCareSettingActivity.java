package com.tencent.mobileqq.activity.specialcare;

import aiiq;
import aiir;
import aiis;
import aiit;
import aiiu;
import aijb;
import ajxl;
import ajxn;
import akfb;
import aksl;
import amgc;
import amgf;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import axqw;
import bbev;
import bbjo;
import bbpp;
import bcpq;
import bcpw;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements amgf, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private int jdField_a_of_type_Int;
  private ajxl jdField_a_of_type_Ajxl = new aiit(this);
  private ajxn jdField_a_of_type_Ajxn;
  private akfb jdField_a_of_type_Akfb = new aiiu(this);
  private amgc jdField_a_of_type_Amgc;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private bcpq jdField_a_of_type_Bcpq;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  
  public QQSpecialCareSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new aiir(this);
  }
  
  private void a()
  {
    int j = 8;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_Ajxn.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.c.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 0)
    {
      bool1 = false;
      a((FormSwitchItem)localObject, bool1);
      bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool2) {
        break label431;
      }
      i = 0;
      label240:
      ((FormSwitchItem)localObject).setVisibility(i);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      localObject = this.c;
      if (!bool2) {
        break label437;
      }
      i = 0;
      label268:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_AndroidViewView;
      i = j;
      if (bool2) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch != 0) {
        break label443;
      }
      bool1 = false;
      label313:
      a((FormSwitchItem)localObject, bool1);
      localObject = this.c;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch != 0) {
        break label448;
      }
      bool1 = false;
      label338:
      a((FormSwitchItem)localObject, bool1);
      if (!this.jdField_a_of_type_Boolean) {
        break label453;
      }
      localObject = getResources().getDrawable(2130849291);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(bool2);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "care_show", "", 1, 0, 0, "", "", "");
      }
      d();
      return;
      bool1 = true;
      break;
      label431:
      i = 8;
      break label240;
      label437:
      i = 8;
      break label268;
      label443:
      bool1 = true;
      break label313;
      label448:
      bool1 = true;
      break label338;
      label453:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719721));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131691327));
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    String str = "special_care_voice_red_dot" + this.app.getCurrentAccountUin();
    Object localObject2 = bbjo.a(localSharedPreferences, str, null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashSet();
    }
    if (((Set)localObject1).add(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject2 = localSharedPreferences.edit();
      bbjo.a((SharedPreferences.Editor)localObject2, str, ((Set)localObject1).toArray());
      ((SharedPreferences.Editor)localObject2).commit();
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new aiiq(this));
  }
  
  private void d()
  {
    Object localObject;
    if (aijb.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        c();
      }
      i = aijb.a(this.jdField_a_of_type_JavaLangString, this.app);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + (String)localObject);
      }
      localObject = ((ajxn)this.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject != null) {
        break label222;
      }
      QLog.d("QQSpecialCareSettingActivity", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
    }
    label222:
    for (int i = 0;; i = ((ExtensionInfo)localObject).friendRingId)
    {
      this.jdField_a_of_type_Amgc.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i, this.jdField_a_of_type_JavaLangString, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Amgc.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt, this.jdField_a_of_type_JavaLangString, 0);
  }
  
  public void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561117);
    setTitle(2131699499);
    setLeftViewName(2131690572);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376383));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376384);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131366804));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)findViewById(2131366819));
    this.c.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374308);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371401));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_start_from", 5);
    if (this.app != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
      this.jdField_a_of_type_Ajxn = ((ajxn)this.app.getManager(51));
      this.app.addObserver(this.jdField_a_of_type_Ajxl);
      this.app.addObserver(this.jdField_a_of_type_Akfb);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "doOnCreate mFriUin: " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.app == null) {}
    for (paramBundle = "";; paramBundle = this.app.getCurrentAccountUin())
    {
      VasWebviewUtil.reportCommercialDrainage(paramBundle, "Care", "PageView", Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
      b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131717474));
      this.jdField_a_of_type_Amgc = amgc.a(this.app);
      this.jdField_a_of_type_Amgc.a(this);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Akfb);
      this.app.removeObserver(this.jdField_a_of_type_Ajxl);
      amgc.a(this.app).b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Amgc.b(this.jdField_a_of_type_JavaLangString, 0);
    a();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a());
    d();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
      setResult(-1);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 2;
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
    }
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      if ((bcpw.a() == 0) && (paramBoolean))
      {
        paramCompoundButton = new aksl(this, this.app, this.jdField_a_of_type_JavaLangString);
        paramCompoundButton.setOnDismissListener(new aiis(this, paramBoolean, paramCompoundButton));
        paramCompoundButton.show();
        axqw.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
      }
    }
    label308:
    while ((paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (paramCompoundButton != this.c.a()))
    {
      return;
      if (bbev.g(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        a(bool);
        localObject = this.app.getCurrentAccountUin();
        if (!paramBoolean) {
          break label308;
        }
      }
      for (paramCompoundButton = "SwitchOn";; paramCompoundButton = "SwitchOff")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "Care", paramCompoundButton, Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
        return;
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        paramCompoundButton.arg1 = 0;
        paramCompoundButton.arg2 = 2131692321;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
        for (bool = true;; bool = false)
        {
          a(paramCompoundButton, bool);
          break;
        }
      }
    }
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
    for (paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;; paramCompoundButton = this.c)
    {
      if (!bbev.g(this)) {
        break label429;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(paramBoolean);
      return;
      if (paramCompoundButton != this.c.a()) {
        break;
      }
      i = 3;
    }
    label429:
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
    ((Message)localObject).arg1 = 0;
    ((Message)localObject).arg2 = 2131692321;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if (!paramCompoundButton.a()) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(paramCompoundButton, paramBoolean);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getId()) {
      switch (i)
      {
      default: 
        return;
      }
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", bbpp.a("specialCareRingUrl").replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", "2"));
    startActivity(paramView);
    this.jdField_a_of_type_Boolean = false;
    axqw.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */