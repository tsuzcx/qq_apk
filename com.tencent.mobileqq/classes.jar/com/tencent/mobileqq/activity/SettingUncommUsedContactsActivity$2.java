package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingUncommUsedContactsActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  SettingUncommUsedContactsActivity$2(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((paramCompoundButton == this.a.a.a()) || (paramCompoundButton == this.a.b.a())) && (!NetworkUtil.isNetSupport(this.a.getActivity())))
    {
      this.a.a(2131694476, 0);
      SettingUncommUsedContactsActivity.a(this.a, paramCompoundButton, paramBoolean ^ true);
    }
    else if (paramCompoundButton == this.a.a.a())
    {
      this.a.app.setNotAllowedSeeMyDongtai(paramBoolean, true);
    }
    else if (paramCompoundButton == this.a.b.a())
    {
      this.a.app.setShieldHisDongtai(paramBoolean, true);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */