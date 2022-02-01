package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopChatPie$10
  implements Runnable
{
  TroopChatPie$10(TroopChatPie paramTroopChatPie, List paramList) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localTroopInfo == null) {
      break label40;
    }
    label40:
    while (StringUtil.a(localTroopInfo.troopowneruin)) {
      return;
    }
    int i = 0;
    int j = 0;
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    int k;
    label86:
    int m;
    label89:
    oidb_0x899.memberlist localmemberlist;
    int n;
    if (this.a == null)
    {
      k = 0;
      m = 0;
      if (m >= k) {
        break label279;
      }
      localmemberlist = (oidb_0x899.memberlist)this.a.get(m);
      if (localmemberlist == null) {
        break label534;
      }
      if (localmemberlist.uint64_member_uin.has()) {
        break label169;
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
      break label89;
      k = this.a.size();
      break label86;
      label169:
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
            label279:
            localTroopInfo.Administrator = localStringBuilder.toString();
            if (!TextUtils.isEmpty(str))
            {
              if (i == 0) {
                break label500;
              }
              localTroopInfo.dwCmdUinUinFlag |= 1L;
              label313:
              if (j == 0) {
                break label517;
              }
            }
            label517:
            for (localTroopInfo.dwAdditionalFlag |= 1L;; localTroopInfo.dwAdditionalFlag &= 0xFFFFFFFE)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.this$0.jdField_b_of_type_JavaLangString, 2, "onOIDB0X899_0_Ret: toopUin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + ", admin=" + localTroopInfo.Administrator + ", owner=" + localTroopInfo.troopowneruin);
              }
              localTroopManager.b(localTroopInfo);
              if (QLog.isColorLevel()) {
                QLog.i(this.this$0.jdField_b_of_type_JavaLangString, 2, localTroopInfo.Administrator);
              }
              if (QLog.isColorLevel()) {
                QLog.d("troop_gag", 2, "onOIDB0X899_0_Ret, sendEmptyMessage-TIMER_ID, hasDestory=" + this.this$0.I);
              }
              if (this.this$0.I) {
                break;
              }
              this.this$0.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
              this.this$0.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
              return;
              label500:
              localTroopInfo.dwCmdUinUinFlag &= 0xFFFFFFFE;
              break label313;
            }
          }
        }
      }
      label534:
      n = i;
      i = j;
      j = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.10
 * JD-Core Version:    0.7.0.1
 */