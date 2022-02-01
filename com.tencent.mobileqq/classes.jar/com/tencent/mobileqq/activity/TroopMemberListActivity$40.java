package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopMemberListActivity$40
  extends TroopObserver
{
  TroopMemberListActivity$40(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.b.equals(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:" + this.a.b + "|troopUin:" + paramString);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = TroopMemberListActivity.d(this.a);
        if (paramInt2 == paramInt1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,realReqType != reqType, realReqType:" + paramInt2 + "|reqType:" + paramInt1);
      return;
      if (this.a.jdField_a_of_type_Long == paramLong) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:" + this.a.jdField_a_of_type_Long + "|reqTimestamp:" + paramLong);
    return;
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("Thread id:").append(Thread.currentThread().getId()).append(",threadName:").append(Thread.currentThread().getName()).append("|onUpdateTroopGetMemberList:").append(paramBoolean).append("|troopMemberInfoList size:");
      if (paramList == null)
      {
        paramString = "";
        label254:
        localStringBuilder2.append(paramString).append("|time:").append((paramLong - this.a.jdField_a_of_type_Long) / 1000L).append("s");
        QLog.d("TroopMemberListActivityget_troop_member", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label557;
      }
    }
    for (;;)
    {
      try
      {
        this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.a.b, System.currentTimeMillis()).commit();
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if ((this.a.d == 13) || (this.a.d == 21)) {
          break label509;
        }
        this.a.a(this.a.b, paramList);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList:" + paramString.toString());
      return;
      paramString = Integer.valueOf(paramList.size());
      break label254;
      label509:
      paramString = this.a.a(this.a.b, this.a.e);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
    label557:
    if ((this.a.d != 13) && (this.a.d != 21)) {
      this.a.a(this.a.b, null);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.a.a(this.a.b, this.a.e);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40
 * JD-Core Version:    0.7.0.1
 */