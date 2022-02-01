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
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
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
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  private IQvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager;
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
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showItems mSpecInfo: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
      QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
    int j = 8;
    if (localObject == null)
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch;
    boolean bool2 = true;
    if (i == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bool3) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    localObject = this.c;
    if (bool3) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i);
    localObject = this.jdField_b_of_type_AndroidViewView;
    i = j;
    if (bool3) {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.c;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
      bool1 = false;
    }
    a((FormSwitchItem)localObject, bool1);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = getResources().getDrawable(2130850769);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    a(bool3);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", "care_show", "", 1, 0, 0, "", "", "");
    }
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719203));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131691312));
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("special_care_voice_red_dot");
    ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = SharedPreferencesHandler.a(localSharedPreferences, str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashSet();
    }
    if (((Set)localObject1).add(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject2 = localSharedPreferences.edit();
      SharedPreferencesHandler.a((SharedPreferences.Editor)localObject2, str, ((Set)localObject1).toArray());
      ((SharedPreferences.Editor)localObject2).commit();
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.loadSpecialSoundConfig(new QQSpecialCareSettingActivity.1(this));
  }
  
  private void d()
  {
    int i;
    if (QvipSpecialCareUtil.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.isCacheData()) {
        c();
      }
      i = QvipSpecialCareUtil.a(this.jdField_a_of_type_JavaLangString, this.app);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.getSoundName(i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updatePersonalVoice mFriUin: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", soundId: ");
        localStringBuilder.append(i);
        localStringBuilder.append(", soundName: ");
        localStringBuilder.append((String)localObject);
        QLog.d("QQSpecialCareSettingActivity", 2, localStringBuilder.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updatePersonalVoice not contain friend: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
    }
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString, false);
    if (localObject == null)
    {
      QLog.d("QQSpecialCareSettingActivity", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
      i = 0;
    }
    else
    {
      i = ((ExtensionInfo)localObject).friendRingId;
    }
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i, this.jdField_a_of_type_JavaLangString, 0);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561497);
    setTitle(2131699327);
    setLeftViewName(2131690706);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377765));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377766);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367344));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)findViewById(2131367359));
    this.c.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375588);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372486));
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager = VasUtil.a().getSpecialSoundManager();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.isCacheData())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      c();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate mFriUin: ");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("QQSpecialCareSettingActivity", 2, paramBundle.toString());
    }
    if (this.app == null) {
      paramBundle = "";
    } else {
      paramBundle = this.app.getCurrentAccountUin();
    }
    VasWebviewUtil.a(paramBundle, "Care", "PageView", Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131716891));
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.app);
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      MessageNotificationSettingManager.a(this.app).b(this);
    }
  }
  
  protected void doOnResume()
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
    boolean bool = QLog.isColorLevel();
    int i = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCheckedChanged isCheck: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", switched by user.");
      QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      if ((QQAppInterface.isNotificationEnabled() == 0) && (paramBoolean))
      {
        localObject1 = new MsgNotifyPushForSpecialCareDialog(this, this.app, this.jdField_a_of_type_JavaLangString);
        ((MsgNotifyPushForSpecialCareDialog)localObject1).setOnDismissListener(new QQSpecialCareSettingActivity.3(this, paramBoolean, (MsgNotifyPushForSpecialCareDialog)localObject1));
        ((MsgNotifyPushForSpecialCareDialog)localObject1).show();
        ReportController.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
      }
      else
      {
        if (NetworkUtil.isNetworkAvailable(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
          localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
          bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          a(bool);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
          ((Message)localObject1).arg1 = 0;
          ((Message)localObject1).arg2 = 2131692183;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          a((FormSwitchItem)localObject1, ((FormSwitchItem)localObject1).a() ^ true);
        }
        localObject2 = this.app.getCurrentAccountUin();
        if (paramBoolean) {
          localObject1 = "SwitchOn";
        } else {
          localObject1 = "SwitchOff";
        }
        VasWebviewUtil.a((String)localObject2, "Care", (String)localObject1, Integer.toString(this.jdField_a_of_type_Int), 1, 0, 0, null, null, null);
      }
    }
    else if ((paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.c.a()))
    {
      if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      }
      else
      {
        if (paramCompoundButton != this.c.a()) {
          break label503;
        }
        i = 3;
        localObject1 = this.c;
      }
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      }
      else
      {
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        ((Message)localObject2).arg1 = 0;
        ((Message)localObject2).arg2 = 2131692183;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        a((FormSwitchItem)localObject1, ((FormSwitchItem)localObject1).a() ^ true);
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(bool);
    }
    label503:
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null) {
      i = 0;
    } else {
      i = paramView.getId();
    }
    if (i == 2131372486)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", IndividuationUrlHelper.a("specialCareRingUrl").replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", "2"));
      startActivity(localIntent);
      this.jdField_a_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */