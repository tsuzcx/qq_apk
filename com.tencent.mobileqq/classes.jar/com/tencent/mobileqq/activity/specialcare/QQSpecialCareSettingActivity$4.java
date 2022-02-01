package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQSpecialCareSettingActivity$4
  extends FriendListObserver
{
  QQSpecialCareSettingActivity$4(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetSpecialCareSwith_global isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i = 1;
    if (!paramBoolean)
    {
      localObject = this.a;
      ((QQSpecialCareSettingActivity)localObject).a(QQSpecialCareSettingActivity.a((QQSpecialCareSettingActivity)localObject), QQSpecialCareSettingActivity.a(this.a).a() ^ true);
    }
    this.a.a.sendEmptyMessage(8194);
    Object localObject = this.a.a.obtainMessage(8195);
    if (paramBoolean) {
      i = 2;
    }
    ((Message)localObject).arg1 = i;
    if (paramBoolean)
    {
      if (Boolean.valueOf(((boolean[])(boolean[])paramArrayOfObject[2])[0]).booleanValue()) {
        i = 2131699317;
      } else {
        i = 2131699316;
      }
    }
    else if (((boolean[])(boolean[])paramArrayOfObject[2])[0] != 0) {
      i = 2131699320;
    } else {
      i = 2131699312;
    }
    ((Message)localObject).arg2 = i;
    this.a.a.sendMessage((Message)localObject);
    QQSpecialCareSettingActivity.b(this.a);
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanReqSubAccountSpecialCareListSysTime(this.a.app);
  }
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwith_qzone isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      QLog.d("QQSpecialCareSettingActivity", 2, paramArrayOfObject.toString());
    }
    if (!paramBoolean)
    {
      paramArrayOfObject = this.a;
      paramArrayOfObject.a(QQSpecialCareSettingActivity.b(paramArrayOfObject), QQSpecialCareSettingActivity.b(this.a).a() ^ true);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwith_specialRing isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      QLog.d("QQSpecialCareSettingActivity", 2, paramArrayOfObject.toString());
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateDelFriend isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin: ");
      localStringBuilder.append(paramObject);
      QLog.d("QQSpecialCareSettingActivity", 2, localStringBuilder.toString());
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateSpecialCareList isSuccess: ");
      paramList.append(paramBoolean1);
      paramList.append(", isComplete: ");
      paramList.append(paramBoolean2);
      QLog.d("QQSpecialCareSettingActivity", 2, paramList.toString());
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */