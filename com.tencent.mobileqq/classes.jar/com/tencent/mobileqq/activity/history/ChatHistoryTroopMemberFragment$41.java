package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.TroopMemberUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatHistoryTroopMemberFragment$41
  extends TroopObserver
{
  ChatHistoryTroopMemberFragment$41(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteTroopMember, isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.jdField_o_of_type_Boolean = true;
        localObject = paramArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.a.a(str);
        }
        if (this.a.jdField_d_of_type_Int == 15) {
          ChatHistoryTroopMemberFragment.a(this.a, paramArrayList);
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(6));
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(15));
        return;
      }
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(7));
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.c)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret");
      localStringBuilder.append("| isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("| troopuin = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("| nFlag = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("| strErorMsg = ");
      localStringBuilder.append(paramString);
      QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 1) && (paramBoolean)) {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.41.1(this, paramList), 5, null, true);
    }
    if ((paramInt1 == 2) && (paramBoolean)) {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.41.2(this, paramList), 8, null, true);
    }
  }
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onOIDB0X899_1_Ret, isSuccess:");
      paramString.append(paramBoolean);
      paramString.append(" returnUin:");
      paramString.append(paramLong1);
      paramString.append(" mTroopUin:");
      paramString.append(this.a.c);
      paramString.append(" time:");
      paramString.append((System.currentTimeMillis() - this.a.jdField_b_of_type_Long) / 1000L);
      paramString.append("s");
      QLog.d("Q.history.BaseFragment", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (!this.a.c.equals(Long.toString(paramLong1))) {
        return;
      }
      paramString = this.a.getActivity();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_update_time");
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramString = paramString.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_troop_info_last_update");
      ((StringBuilder)localObject).append(this.a.c);
      paramString.putLong(((StringBuilder)localObject).toString(), System.currentTimeMillis()).commit();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        paramString = this.a;
        localObject = paramString.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        boolean bool = true;
        if ((localObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop())) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.jdField_e_of_type_Boolean = paramBoolean;
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null)
        {
          paramString = this.a;
          paramString.f = paramString.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
        }
        paramString = this.a;
        paramString.g = TroopMemberUtil.a(paramString.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList, false);
        paramList = this.a;
        paramBoolean = bool;
        if (!paramList.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin)) {
          if ((this.a.g != null) && (this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
        }
        paramList.jdField_d_of_type_Boolean = paramBoolean;
        if ((this.a.f != null) && (this.a.f.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.a.jdField_o_of_type_JavaLangString = "0";
        } else if ((this.a.g != null) && (this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.a.jdField_o_of_type_JavaLangString = "1";
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(9));
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.c.equals(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:");
        paramList.append(this.a.c);
        paramList.append("|troopUin:");
        paramList.append(paramString);
        QLog.e("Q.history.BaseFragment", 2, paramList.toString());
      }
      return;
    }
    paramInt2 = ChatHistoryTroopMemberFragment.d(this.a);
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,realReqType != reqType, realReqType:");
        paramString.append(paramInt2);
        paramString.append("|reqType:");
        paramString.append(paramInt1);
        QLog.e("Q.history.BaseFragment", 2, paramString.toString());
      }
      return;
    }
    if (this.a.jdField_a_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:");
        paramString.append(this.a.jdField_a_of_type_Long);
        paramString.append("|reqTimestamp:");
        paramString.append(paramLong);
        QLog.e("Q.history.BaseFragment", 2, paramString.toString());
      }
      return;
    }
    paramLong = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread id:");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(",threadName:");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append("|onUpdateTroopGetMemberList:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("|troopMemberInfoList size:");
      if (paramList == null) {
        paramString = "";
      } else {
        paramString = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("|time:");
      localStringBuilder.append((paramLong - this.a.jdField_a_of_type_Long) / 1000L);
      localStringBuilder.append("s");
      QLog.d("Q.history.BaseFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      try
      {
        paramString = this.a.getActivity();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last_update_time");
        localStringBuilder.append(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString = paramString.getSharedPreferences(localStringBuilder.toString(), 4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_last_update_time");
        localStringBuilder.append(this.a.c);
        paramString.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
        this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        if ((this.a.jdField_d_of_type_Int != 13) && (this.a.jdField_d_of_type_Int != 21))
        {
          this.a.a(this.a.c, paramList);
        }
        else
        {
          paramString = this.a.a(this.a.c, this.a.jdField_e_of_type_JavaUtilList);
          this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramList = new StringBuilder();
      paramList.append("onUpdateTroopGetMemberList:");
      paramList.append(paramString.toString());
      QLog.d("Q.history.BaseFragment", 2, paramList.toString());
    }
    else
    {
      if ((this.a.jdField_d_of_type_Int != 13) && (this.a.jdField_d_of_type_Int != 21))
      {
        paramString = this.a;
        paramString.a(paramString.c, null);
      }
      else
      {
        paramString = this.a;
        paramString = paramString.a(paramString.c, this.a.jdField_e_of_type_JavaUtilList);
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
      }
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41
 * JD-Core Version:    0.7.0.1
 */