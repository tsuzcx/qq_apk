package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQSpecialFriendSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int;
  final Handler jdField_a_of_type_AndroidOsHandler = new QQSpecialFriendSettingActivity.3(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSpecialFriendSettingActivity.4(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new QQSpecialFriendSettingActivity.5(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372899));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367586));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367601));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376075);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364359);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366575));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372288));
    if (this.jdField_a_of_type_Boolean)
    {
      setLeftViewName(2131689557);
      setRightButton(2131692534, new QQSpecialFriendSettingActivity.1(this));
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699218));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699219));
      }
      return;
      setLeftViewName(2131693924);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, this.jdField_a_of_type_JavaLangString, 0);
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_JavaLangString, 1, true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.d());
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject).getFriendNickWithAlias());
  }
  
  private void c()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch == 0)
    {
      bool1 = false;
      a((FormSwitchItem)localObject, bool1);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
        bool1 = false;
      }
      a((FormSwitchItem)localObject, bool1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label260;
      }
    }
    label260:
    for (int i = 0;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      e();
      return;
      bool1 = true;
      break;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new QQSpecialFriendSettingActivity.2(this));
  }
  
  private void e()
  {
    String str2;
    FormSimpleItem localFormSimpleItem;
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").getInt("special_care_id_cache" + this.jdField_a_of_type_JavaLangString, 1);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Int);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = getString(2131694520);; str1 = str2)
      {
        localFormSimpleItem.setRightText(str1);
        if (QLog.isColorLevel()) {
          QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice FromForwardFriendActivity mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + this.jdField_a_of_type_Int + ", soundName: " + str2);
        }
        return;
      }
    }
    if (QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        d();
      }
      int i = QvipSpecialCareManager.a(this.jdField_a_of_type_JavaLangString, this.app);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + str2);
      }
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131694520);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131694520));
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
    setContentView(2131561648);
    setTitle(2131699223);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("key_is_from_friendsforward_activity", false);
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    b();
    ReportController.b(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "doOnCreate mFriUin: " + this.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_Boolean) {
      ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").edit().remove("special_care_id_cache" + this.jdField_a_of_type_JavaLangString).commit();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
    this.jdField_b_of_type_Boolean = true;
    if (this.c)
    {
      this.c = false;
      Intent localIntent = new Intent();
      localIntent.setClass(this, SpecailCareListActivity.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("selfSet_leftViewText", getString(2131695187));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 2;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label90;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 8;
      break;
      label90:
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        i = j;
      }
      for (;;)
      {
        if (!NetworkUtil.g(this)) {
          break label168;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
        break;
        if (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break;
        }
        i = 3;
        localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      }
      label168:
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      localMessage.arg1 = 0;
      localMessage.arg2 = 2131692257;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (!((FormSwitchItem)localObject).a()) {
        bool = true;
      }
      a((FormSwitchItem)localObject, bool);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null) {
      i = 0;
    }
    Object localObject;
    switch (i)
    {
    default: 
    case 2131372899: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = paramView.getId();
        break;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", IndividuationUrlHelper.a("specialCareRingUrl") + "&suin=" + this.jdField_a_of_type_JavaLangString + "&uin=" + this.app.getCurrentAccountUin() + "&_bid=279&lazy=" + this.jdField_a_of_type_Boolean);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject);
      }
    }
    if (NetworkUtil.g(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { false });
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
      ((Message)localObject).obj = getString(2131699209);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
      break;
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131692257;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */