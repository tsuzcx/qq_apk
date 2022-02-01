package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LikeSettingActivity$2
  extends NearbyRelevantObserver
{
  LikeSettingActivity$2(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetNotifyOnLikeSwitch.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).a.a(), paramBoolean2);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetNotifyOnLikeSwitch.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",open=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("LikeSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, 2131718834, 0).b(this.a.getTitleBarHeight());
      paramBoolean1 = ((INearByGeneralManager)this.a.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).a();
      localObject = this.a;
      LikeSettingActivity.a((LikeSettingActivity)localObject, ((LikeSettingActivity)localObject).a.a(), paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */