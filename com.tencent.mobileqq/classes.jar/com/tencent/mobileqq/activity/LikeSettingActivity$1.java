package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LikeSettingActivity$1
  extends CardObserver
{
  LikeSettingActivity$1(LikeSettingActivity paramLikeSettingActivity) {}
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetCardSwitch.isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",voteAllowed=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",praiseStatusAllowed=");
      localStringBuilder.append(paramBoolean3);
      QLog.i("LikeSettingActivity", 2, localStringBuilder.toString());
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean1)
    {
      paramString = this.a;
      LikeSettingActivity.a(paramString, paramString.e.getSwitch(), paramBoolean2);
    }
  }
  
  protected void onGetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetNotifyOnLikeRankingList.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).d.getSwitch(), paramBoolean2);
      this.a.a.a(paramBoolean2);
    }
  }
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPartakeLikeRankingList.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).f.getSwitch(), paramBoolean2);
      this.a.a.b(paramBoolean2);
      if (!paramBoolean2)
      {
        this.a.d.setVisibility(8);
        return;
      }
      this.a.d.setVisibility(0);
    }
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetCardSwitch.isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",forNearPeople=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",allowed=");
      localStringBuilder.append(paramBoolean3);
      QLog.i("LikeSettingActivity", 2, localStringBuilder.toString());
    }
    if (this.a.app.getCurrentAccountUin().equals(paramString))
    {
      if (!paramBoolean2) {
        return;
      }
      if (!paramBoolean1)
      {
        QQToast.makeText(this.a, 1, 2131916364, 0).show(this.a.getTitleBarHeight());
        paramString = this.a;
        LikeSettingActivity.a(paramString, paramString.e.getSwitch(), paramBoolean3);
      }
    }
  }
  
  protected void onSetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetNotifyOnLikeRankingList.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1)
    {
      QQToast.makeText(this.a, 1, 2131916364, 0).show(this.a.getTitleBarHeight());
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).f.getSwitch(), this.a.a.c());
      return;
    }
    this.a.a.a(paramBoolean2);
  }
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetPartakeLikeRankingList.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1)
    {
      QQToast.makeText(this.a, 1, 2131916364, 0).show(this.a.getTitleBarHeight());
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).f.getSwitch(), this.a.a.e());
      return;
    }
    this.a.a.b(paramBoolean2);
    if (!paramBoolean2)
    {
      this.a.d.setVisibility(8);
      return;
    }
    this.a.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */