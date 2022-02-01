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
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
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
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
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
  private IQvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372486));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367344));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131367359));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375588);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364261);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366451));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371877));
    if (this.jdField_a_of_type_Boolean)
    {
      setLeftViewName(2131689589);
      setRightButton(2131692486, new QQSpecialFriendSettingActivity.1(this));
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      setLeftViewName(2131693880);
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699322));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699323));
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager = VasUtil.a().getSpecialSoundManager();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.isCacheData())
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
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.f());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject).getFriendNickWithAlias());
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showItems mSpecInfo: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
      QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
    int i = 8;
    if (localObject == null)
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch;
    boolean bool2 = true;
    if (j == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
      bool1 = false;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      i = 0;
    }
    ((FormSimpleItem)localObject).setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    e();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.loadSpecialSoundConfig(new QQSpecialFriendSettingActivity.2(this));
  }
  
  private void e()
  {
    Object localObject1;
    Object localObject2;
    FormSimpleItem localFormSimpleItem;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("special_care_id_cache");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.getSoundName(this.jdField_a_of_type_Int);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getString(2131694485);
      } else {
        localObject1 = localObject2;
      }
      localFormSimpleItem.setRightText((CharSequence)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updatePersonalVoice FromForwardFriendActivity mFriUin: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", soundId: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", soundName: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (QvipSpecialCareUtil.a(this.jdField_a_of_type_JavaLangString, this.app))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.isCacheData()) {
          d();
        }
        int i = QvipSpecialCareUtil.a(this.jdField_a_of_type_JavaLangString, this.app);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager.getSoundName(i);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updatePersonalVoice mFriUin: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(", soundId: ");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(", soundName: ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
        }
        localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = getString(2131694485);
        }
        localFormSimpleItem.setRightText((CharSequence)localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updatePersonalVoice not contain friend: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131694485));
    }
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
    setContentView(2131561498);
    setTitle(2131699327);
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
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate mFriUin: ");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("QQSpecialFriendSettingActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences");
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_care_id_cache");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).commit();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void doOnResume()
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
      localIntent.putExtra("selfSet_leftViewText", getString(2131695179));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged isCheck: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", switched by user.");
      QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(i);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        i = j;
      }
      else
      {
        if (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label225;
        }
        i = 3;
        localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      }
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      }
      else
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        localMessage.arg1 = 0;
        localMessage.arg2 = 2131692183;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        a((FormSwitchItem)localObject, ((FormSwitchItem)localObject).a() ^ true);
      }
    }
    label225:
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
    Object localObject;
    if (i != 2131364261)
    {
      if (i == 2131372486)
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(IndividuationUrlHelper.a("specialCareRingUrl"));
        localStringBuilder.append("&suin=");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("&uin=");
        localStringBuilder.append(this.app.getCurrentAccountUin());
        localStringBuilder.append("&_bid=279&lazy=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        ((Intent)localObject).putExtra("url", localStringBuilder.toString().replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", "2"));
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject);
      }
    }
    else
    {
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { false });
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
        ((Message)localObject).obj = getString(2131699313);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).arg2 = 2131692183;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      ReportController.b(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",avatar= ");
      localStringBuilder.append(paramBitmap);
      QLog.d("QQSpecialFriendSettingActivity", 2, localStringBuilder.toString());
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */