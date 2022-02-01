package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQSpecialFriendSettingActivity$4
  extends FriendListObserver
{
  QQSpecialFriendSettingActivity$4(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwith_global isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      paramArrayOfObject.append(",isFromForwardFriendActivity=");
      paramArrayOfObject.append(QQSpecialFriendSettingActivity.a(this.a));
      QLog.d("QQSpecialFriendSettingActivity", 2, paramArrayOfObject.toString());
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    this.a.a.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.a.obtainMessage(8195);
    if (!paramBoolean) {
      i = 1;
    }
    paramArrayOfObject.arg1 = i;
    if (paramBoolean) {
      i = 2131692089;
    } else {
      i = 2131699312;
    }
    paramArrayOfObject.arg2 = i;
    this.a.a.sendMessage(paramArrayOfObject);
    if (paramBoolean) {
      this.a.finish();
    }
  }
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwith_qzone isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      QLog.d("QQSpecialFriendSettingActivity", 2, paramArrayOfObject.toString());
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    if (!paramBoolean)
    {
      paramArrayOfObject = this.a;
      paramArrayOfObject.a(QQSpecialFriendSettingActivity.b(paramArrayOfObject), QQSpecialFriendSettingActivity.b(this.a).a() ^ true);
    }
  }
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwith_specialRing isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      QLog.d("QQSpecialFriendSettingActivity", 2, paramArrayOfObject.toString());
    }
    if (QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int j = ((Integer)paramArrayOfObject[0]).intValue();
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("onSetSpecialCareSwitchesOfAPerson isSuccess: ");
      paramArrayOfObject.append(paramBoolean);
      paramArrayOfObject.append(",isFromForwardFriendActivity=");
      paramArrayOfObject.append(QQSpecialFriendSettingActivity.a(this.a));
      paramArrayOfObject.append(",result=");
      paramArrayOfObject.append(j);
      QLog.d("QQSpecialFriendSettingActivity", 2, paramArrayOfObject.toString());
    }
    if (!QQSpecialFriendSettingActivity.a(this.a)) {
      return;
    }
    this.a.a.sendEmptyMessage(8194);
    paramArrayOfObject = this.a.a.obtainMessage(8195);
    if ((!paramBoolean) || (j != 0)) {
      i = 1;
    }
    paramArrayOfObject.arg1 = i;
    if ((paramBoolean) && (j == 0)) {
      i = 2131692089;
    } else {
      i = 2131699309;
    }
    paramArrayOfObject.arg2 = i;
    this.a.a.sendMessage(paramArrayOfObject);
    if ((paramBoolean) && (j == 0))
    {
      if (QQSpecialFriendSettingActivity.b(this.a))
      {
        paramArrayOfObject = new Intent();
        paramArrayOfObject.setClass(this.a, SpecailCareListActivity.class);
        paramArrayOfObject.addFlags(67108864);
        paramArrayOfObject.putExtra("selfSet_leftViewText", this.a.getString(2131695179));
        this.a.startActivity(paramArrayOfObject);
        this.a.finish();
        return;
      }
      QQSpecialFriendSettingActivity.a(this.a, true);
    }
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
      QLog.d("QQSpecialFriendSettingActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (QQSpecialFriendSettingActivity.a(this.a).equals(String.valueOf(paramObject)))) {
      this.a.finish();
    }
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
      QLog.d("QQSpecialFriendSettingActivity", 2, paramList.toString());
    }
    QQSpecialFriendSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */