package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import ylj;
import ylk;
import yll;
import ylm;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private int jdField_a_of_type_Int;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yll(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new ylm(this);
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  
  public QQSpecialCareSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ylk(this);
  }
  
  private void a()
  {
    boolean bool2 = true;
    int j = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.g())
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 0)
    {
      bool1 = false;
      a((FormSwitchItem)localObject, bool1);
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool3) {
        break label414;
      }
      i = 0;
      label251:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.c;
      if (!bool3) {
        break label420;
      }
      i = 0;
      label270:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (!bool3) {
        break label426;
      }
      i = 0;
      label289:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch != 0) {
        break label432;
      }
      bool1 = false;
      label313:
      a((FormSwitchItem)localObject, bool1);
      localObject = this.c;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
        bool1 = false;
      }
      a((FormSwitchItem)localObject, bool1);
      if (!this.jdField_a_of_type_Boolean) {
        break label437;
      }
      localObject = getResources().getDrawable(2130846136);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
      label375:
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if ((!bool3) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        break label448;
      }
    }
    label414:
    label420:
    label426:
    label432:
    label437:
    label448:
    for (int i = j;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      d();
      return;
      bool1 = true;
      break;
      i = 8;
      break label251;
      i = 8;
      break label270;
      i = 8;
      break label289;
      bool1 = true;
      break label313;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      break label375;
    }
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    String str = "special_care_voice_red_dot" + this.app.getCurrentAccountUin();
    Object localObject2 = SharedPreferencesHandler.a(localSharedPreferences, str, null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashSet();
    }
    if (((Set)localObject1).add(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject2 = localSharedPreferences.edit();
      SharedPreferencesHandler.a((SharedPreferences.Editor)localObject2, str, ((Set)localObject1).toArray());
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new ylj(this));
  }
  
  private void d()
  {
    if (QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        c();
      }
      int i = QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + str2);
      }
      FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131434693);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131434693));
  }
  
  public void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970645);
    setTitle(2131436904);
    setLeftViewName(2131433712);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371503));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371504);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371505));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)findViewById(2131371507));
    this.c.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371508);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371506));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_start_from", 5);
    if (this.app != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131436881));
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
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
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
    }
    Object localObject;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      if (NetworkUtil.g(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        localObject = this.app.getCurrentAccountUin();
        if (!paramBoolean) {
          break label215;
        }
        paramCompoundButton = "SwitchOn";
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "Care", paramCompoundButton, Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
      }
    }
    label215:
    while ((paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (paramCompoundButton != this.c.a())) {
      for (;;)
      {
        return;
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        paramCompoundButton.arg1 = 0;
        paramCompoundButton.arg2 = 2131433023;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
        for (bool = true;; bool = false)
        {
          a(paramCompoundButton, bool);
          break;
        }
        paramCompoundButton = "SwitchOff";
      }
    }
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      label260:
      if (!NetworkUtil.g(this)) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label398;
      }
    }
    label398:
    for (i = j;; i = 8)
    {
      paramCompoundButton.setVisibility(i);
      return;
      if (paramCompoundButton != this.c.a()) {
        break;
      }
      i = 3;
      paramCompoundButton = this.c;
      break label260;
      label338:
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131433023;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if (!paramCompoundButton.a()) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        a(paramCompoundButton, paramBoolean);
        break;
      }
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
    String str = IndividuationUrlHelper.a("specialCareRingUrl");
    paramView.putExtra("url", str + "&suin=" + this.jdField_a_of_type_JavaLangString + "&uin=" + this.app.getCurrentAccountUin() + "&_bid=279");
    paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramView);
    str = this.app.getCurrentAccountUin();
    if (this.jdField_a_of_type_Boolean) {}
    for (paramView = "1";; paramView = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "Care", "CareRingClick", paramView, 1, 0, 0, null, null, null);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */