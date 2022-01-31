package com.tencent.mobileqq.activity.aio.rebuild;

import agvm;
import android.os.Handler;
import android.text.TextUtils;
import bdnn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopChatPie$12$1
  implements Runnable
{
  public TroopChatPie$12$1(agvm paramagvm, List paramList) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Agvm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_Agvm.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      break label45;
    }
    label45:
    while (bdnn.a(localTroopInfo.troopowneruin)) {
      return;
    }
    int i = 0;
    int j = 0;
    String str = this.jdField_a_of_type_Agvm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    int k;
    label94:
    int m;
    label97:
    oidb_0x899.memberlist localmemberlist;
    int n;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      k = 0;
      m = 0;
      if (m >= k) {
        break label287;
      }
      localmemberlist = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(m);
      if (localmemberlist == null) {
        break label563;
      }
      if (localmemberlist.uint64_member_uin.has()) {
        break label177;
      }
      n = j;
      j = i;
      i = n;
    }
    for (;;)
    {
      n = m + 1;
      m = j;
      j = i;
      i = m;
      m = n;
      break label97;
      k = this.jdField_a_of_type_JavaUtilList.size();
      break label94;
      label177:
      long l = localmemberlist.uint64_member_uin.get();
      n = localmemberlist.uint32_privilege.get();
      if (l != 0L) {
        if (n == 2)
        {
          localStringBuilder.append(l).append("|");
          if (String.valueOf(l).equals(str))
          {
            n = 1;
            i = j;
            j = n;
          }
        }
        else if (n == 1)
        {
          localTroopInfo.troopowneruin = String.valueOf(l);
          if (localTroopInfo.troopowneruin.equals(str))
          {
            n = 1;
            j = i;
            i = n;
            continue;
            label287:
            localTroopInfo.Administrator = localStringBuilder.toString();
            if (!TextUtils.isEmpty(str))
            {
              if (i == 0) {
                break label529;
              }
              localTroopInfo.dwCmdUinUinFlag |= 1L;
              label321:
              if (j == 0) {
                break label546;
              }
            }
            label529:
            label546:
            for (localTroopInfo.dwAdditionalFlag |= 1L;; localTroopInfo.dwAdditionalFlag &= 0xFFFFFFFE)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_Agvm.a.jdField_a_of_type_JavaLangString, 2, "onOIDB0X899_0_Ret: toopUin=" + this.jdField_a_of_type_Agvm.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ", admin=" + localTroopInfo.Administrator + ", owner=" + localTroopInfo.troopowneruin);
              }
              localTroopManager.b(localTroopInfo);
              if (QLog.isColorLevel()) {
                QLog.i(this.jdField_a_of_type_Agvm.a.jdField_a_of_type_JavaLangString, 2, localTroopInfo.Administrator);
              }
              if (QLog.isColorLevel()) {
                QLog.d("troop_gag", 2, "onOIDB0X899_0_Ret, sendEmptyMessage-TIMER_ID, hasDestory=" + this.jdField_a_of_type_Agvm.a.N);
              }
              if (this.jdField_a_of_type_Agvm.a.N) {
                break;
              }
              this.jdField_a_of_type_Agvm.a.b.removeMessages(1);
              this.jdField_a_of_type_Agvm.a.b.sendEmptyMessage(1);
              return;
              localTroopInfo.dwCmdUinUinFlag &= 0xFFFFFFFE;
              break label321;
            }
          }
        }
      }
      label563:
      n = i;
      i = j;
      j = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.1
 * JD-Core Version:    0.7.0.1
 */