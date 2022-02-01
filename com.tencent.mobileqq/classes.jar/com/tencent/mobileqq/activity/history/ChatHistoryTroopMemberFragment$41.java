package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopMemberFragment$41
  extends TroopObserver
{
  ChatHistoryTroopMemberFragment$41(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.c.equals(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:" + this.a.c + "|troopUin:" + paramString);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = ChatHistoryTroopMemberFragment.d(this.a);
        if (paramInt2 == paramInt1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,realReqType != reqType, realReqType:" + paramInt2 + "|reqType:" + paramInt1);
      return;
      if (this.a.a == paramLong) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:" + this.a.a + "|reqTimestamp:" + paramLong);
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
        localStringBuilder2.append(paramString).append("|time:").append((paramLong - this.a.a) / 1000L).append("s");
        QLog.d("Q.history.BaseFragment", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label560;
      }
    }
    for (;;)
    {
      try
      {
        this.a.getActivity().getSharedPreferences("last_update_time" + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.a.c, System.currentTimeMillis()).commit();
        this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        if ((this.a.d == 13) || (this.a.d == 21)) {
          break label512;
        }
        this.a.a(this.a.c, paramList);
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList:" + paramString.toString());
      return;
      paramString = Integer.valueOf(paramList.size());
      break label254;
      label512:
      paramString = this.a.a(this.a.c, this.a.e);
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
    label560:
    if ((this.a.d != 13) && (this.a.d != 21)) {
      this.a.a(this.a.c, null);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.a.a(this.a.c, this.a.e);
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41
 * JD-Core Version:    0.7.0.1
 */