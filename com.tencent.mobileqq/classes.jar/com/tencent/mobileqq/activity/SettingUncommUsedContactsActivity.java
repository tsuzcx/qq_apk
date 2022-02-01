package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SettingUncommUsedContactsActivity
  extends IphoneTitleBarActivity
{
  FormSwitchItem a;
  FormSwitchItem b;
  final String c = "SettingUnommUsedContacts";
  FriendListObserver d = new SettingUncommUsedContactsActivity.1(this);
  CompoundButton.OnCheckedChangeListener e = new SettingUncommUsedContactsActivity.2(this);
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.e);
  }
  
  void a()
  {
    setContentViewB(2131627829);
    setTitle(2131916391);
    this.leftView.setText(2131887625);
    this.rightViewText.setVisibility(8);
    this.a = ((FormSwitchItem)findViewById(2131439116));
    this.a.setOnCheckedChangeListener(this.e);
    a(this.a.getSwitch(), this.app.getNotAllowedSeeMyDongtai(false));
    this.b = ((FormSwitchItem)findViewById(2131445839));
    this.b.setOnCheckedChangeListener(this.e);
    a(this.b.getSwitch(), this.app.getShieldHisDongtai(false));
    if (AppSetting.e)
    {
      this.centerView.setContentDescription(getString(2131916391));
      this.a.setContentDescription(getString(2131892171));
      this.a.setFocusable(true);
      this.b.setContentDescription(getString(2131916585));
      this.b.setFocusable(true);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
    a();
    addObserver(this.d);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.d);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(this.app.getCurrentAccountUin(), 3);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */