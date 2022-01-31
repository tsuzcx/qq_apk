package com.tencent.mobileqq.activity.specialcare;

import akes;
import akeu;
import akev;
import akew;
import akex;
import akey;
import altm;
import alto;
import ambf;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import azqs;
import bdbb;
import bdbc;
import bdhj;
import bdin;
import bdmm;
import bdtg;
import bety;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class QQSpecialFriendSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, bdbc
{
  private int jdField_a_of_type_Int;
  private altm jdField_a_of_type_Altm = new akew(this);
  private alto jdField_a_of_type_Alto;
  private ambf jdField_a_of_type_Ambf = new akex(this);
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdbb jdField_a_of_type_Bdbb;
  private bety jdField_a_of_type_Bety;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public QQSpecialFriendSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new akev(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371737));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131366933));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131366948));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374819);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363911);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365969));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371161));
    if (this.jdField_a_of_type_Boolean)
    {
      setLeftViewName(2131689628);
      setRightButton(2131692682, new akes(this));
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699870));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699871));
      }
      return;
      setLeftViewName(2131694193);
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
    this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
    this.jdField_a_of_type_Bdbb.a(this);
    Object localObject = this.jdField_a_of_type_Bdbb.a(1, this.jdField_a_of_type_JavaLangString, 0);
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_Bdbb.a()) {
        this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_JavaLangString, 1, true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)bdhj.a());
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Alto.b(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_JavaLangString);
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
        break label259;
      }
    }
    label259:
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new akeu(this));
  }
  
  private void e()
  {
    String str2;
    FormSimpleItem localFormSimpleItem;
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = bdmm.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").getInt("special_care_id_cache" + this.jdField_a_of_type_JavaLangString, 1);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.jdField_a_of_type_Int);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = getString(2131694851);; str1 = str2)
      {
        localFormSimpleItem.setRightText(str1);
        if (QLog.isColorLevel()) {
          QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice FromForwardFriendActivity mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + this.jdField_a_of_type_Int + ", soundName: " + str2);
        }
        return;
      }
    }
    if (akey.a(this.jdField_a_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        d();
      }
      int i = akey.a(this.jdField_a_of_type_JavaLangString, this.app);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_a_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + str2);
      }
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131694851);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131694851));
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
    setContentView(2131561322);
    setTitle(2131699875);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("key_is_from_friendsforward_activity", false);
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Alto = ((alto)this.app.getManager(51));
    this.app.addObserver(this.jdField_a_of_type_Altm);
    this.app.addObserver(this.jdField_a_of_type_Ambf);
    b();
    azqs.b(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "doOnCreate mFriUin: " + this.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ambf);
      this.app.removeObserver(this.jdField_a_of_type_Altm);
    }
    if (this.jdField_a_of_type_Boolean) {
      bdmm.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").edit().remove("special_care_id_cache" + this.jdField_a_of_type_JavaLangString).commit();
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
      localIntent.putExtra("selfSet_leftViewText", getString(2131695693));
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
    }
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      i = j;
    }
    for (;;)
    {
      if (!bdin.g(this)) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(i, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { paramBoolean });
      return;
      if (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break;
      }
      i = 3;
      paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    }
    label156:
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
    ((Message)localObject).arg1 = 0;
    ((Message)localObject).arg2 = 2131692398;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    paramBoolean = bool;
    if (!paramCompoundButton.a()) {
      paramBoolean = true;
    }
    a(paramCompoundButton, paramBoolean);
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
    paramView.putExtra("url", bdtg.a("specialCareRingUrl") + "&suin=" + this.jdField_a_of_type_JavaLangString + "&uin=" + this.app.getCurrentAccountUin() + "&_bid=279&lazy=" + this.jdField_a_of_type_Boolean);
    paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramView);
    return;
    if (bdin.g(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(1, new String[] { this.jdField_a_of_type_JavaLangString }, new boolean[] { false });
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
      paramView.obj = getString(2131699860);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramView);
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
      return;
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      paramView.arg1 = 0;
      paramView.arg2 = 2131692398;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramView);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Bdbb.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */