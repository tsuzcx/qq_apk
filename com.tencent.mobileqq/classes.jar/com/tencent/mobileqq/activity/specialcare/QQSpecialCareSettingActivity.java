package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, MessageNotificationSettingManager.RingCallback
{
  private int jdField_a_of_type_Int;
  final Handler jdField_a_of_type_AndroidOsHandler = new QQSpecialCareSettingActivity.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSpecialCareSettingActivity.4(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new QQSpecialCareSettingActivity.5(this);
  private MessageNotificationSettingManager jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  
  private void a()
  {
    int j = 8;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e())
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
      localObject = getResources().getDrawable(2130850833);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719485));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131691390));
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new QQSpecialCareSettingActivity.1(this));
  }
  
  private void d()
  {
    Object localObject;
    if (QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        c();
      }
      i = QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + (String)localObject);
      }
      localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject != null) {
        break label223;
      }
      QLog.d("QQSpecialCareSettingActivity", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
    }
    label223:
    for (int i = 0;; i = ((ExtensionInfo)localObject).friendRingId)
    {
      this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i, this.jdField_a_of_type_JavaLangString, 0);
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
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt, this.jdField_a_of_type_JavaLangString, 0);
  }
  
  void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
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
    setContentView(2131561647);
    setTitle(2131699223);
    setLeftViewName(2131690778);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378357);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367586));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)findViewById(2131367601));
    this.c.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376075);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372899));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_start_from", 5);
    if (this.app != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131717232));
      this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.app);
      this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      MessageNotificationSettingManager.a(this.app).b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.b(this.jdField_a_of_type_JavaLangString, 0);
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
      if ((QQAppInterface.isNotificationEnabled() == 0) && (paramBoolean))
      {
        localObject1 = new MsgNotifyPushForSpecialCareDialog(this, this.app, this.jdField_a_of_type_JavaLangString);
        ((MsgNotifyPushForSpecialCareDialog)localObject1).setOnDismissListener(new QQSpecialCareSettingActivity.3(this, paramBoolean, (MsgNotifyPushForSpecialCareDialog)localObject1));
        ((MsgNotifyPushForSpecialCareDialog)localObject1).show();
        ReportController.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
      }
    }
    label332:
    while ((paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (paramCompoundButton != this.c.a()))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (NetworkUtil.g(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        a(bool);
        localObject2 = this.app.getCurrentAccountUin();
        if (!paramBoolean) {
          break label332;
        }
      }
      for (localObject1 = "SwitchOn";; localObject1 = "SwitchOff")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "Care", (String)localObject1, Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
        break;
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        ((Message)localObject1).arg1 = 0;
        ((Message)localObject1).arg2 = 2131692257;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
        for (bool = true;; bool = false)
        {
          a((FormSwitchItem)localObject1, bool);
          break;
        }
      }
    }
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
    for (Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;; localObject1 = this.c)
    {
      if (!NetworkUtil.g(this)) {
        break label460;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(bool);
      break;
      if (paramCompoundButton != this.c.a()) {
        break;
      }
      i = 3;
    }
    label460:
    Object localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
    ((Message)localObject2).arg1 = 0;
    ((Message)localObject2).arg2 = 2131692257;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    if (!((FormSwitchItem)localObject1).a()) {}
    for (;;)
    {
      a((FormSwitchItem)localObject1, bool);
      break;
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null)
    {
      i = 0;
      switch (i)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = paramView.getId();
      break;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", IndividuationUrlHelper.a("specialCareRingUrl").replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", "2"));
      startActivity(localIntent);
      this.jdField_a_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */