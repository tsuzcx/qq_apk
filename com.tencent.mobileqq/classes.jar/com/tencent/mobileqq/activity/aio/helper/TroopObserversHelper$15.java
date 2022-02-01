package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
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

class TroopObserversHelper$15
  implements Runnable
{
  TroopObserversHelper$15(TroopObserversHelper paramTroopObserversHelper, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)TroopObserversHelper.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).f(TroopObserversHelper.b(this.this$0).b);
    if (localTroopInfo == null) {
      return;
    }
    if (StringUtil.isEmpty(localTroopInfo.troopowneruin)) {
      return;
    }
    Object localObject2 = TroopObserversHelper.a(this.this$0).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = this.a;
    int k = 0;
    int i;
    if (localObject3 == null) {
      i = 0;
    } else {
      i = ((List)localObject3).size();
    }
    int m = 0;
    int i1;
    for (int j = 0; k < i; j = i1)
    {
      localObject3 = (oidb_0x899.memberlist)this.a.get(k);
      int n = m;
      i1 = j;
      if (localObject3 != null) {
        if (!((oidb_0x899.memberlist)localObject3).uint64_member_uin.has())
        {
          n = m;
          i1 = j;
        }
        else
        {
          long l = ((oidb_0x899.memberlist)localObject3).uint64_member_uin.get();
          int i2 = ((oidb_0x899.memberlist)localObject3).uint32_privilege.get();
          n = m;
          i1 = j;
          if (l != 0L) {
            if (i2 == 2)
            {
              localStringBuilder.append(l);
              localStringBuilder.append("|");
              n = m;
              i1 = j;
              if (String.valueOf(l).equals(localObject2))
              {
                n = 1;
                i1 = j;
              }
            }
            else
            {
              n = m;
              i1 = j;
              if (i2 == 1)
              {
                localTroopInfo.troopowneruin = String.valueOf(l);
                n = m;
                i1 = j;
                if (localTroopInfo.troopowneruin.equals(localObject2))
                {
                  i1 = 1;
                  n = m;
                }
              }
            }
          }
        }
      }
      k += 1;
      m = n;
    }
    localTroopInfo.Administrator = localStringBuilder.toString();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (m != 0) {
        localTroopInfo.dwCmdUinUinFlag |= 1L;
      } else {
        localTroopInfo.dwCmdUinUinFlag &= 0xFFFFFFFE;
      }
      if (j != 0) {
        localTroopInfo.dwAdditionalFlag = (1L | localTroopInfo.dwAdditionalFlag);
      } else {
        localTroopInfo.dwAdditionalFlag &= 0xFFFFFFFE;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onOIDB0X899_0_Ret: toopUin=");
      ((StringBuilder)localObject2).append(TroopObserversHelper.b(this.this$0).b);
      ((StringBuilder)localObject2).append(", admin=");
      ((StringBuilder)localObject2).append(localTroopInfo.Administrator);
      ((StringBuilder)localObject2).append(", owner=");
      ((StringBuilder)localObject2).append(localTroopInfo.troopowneruin);
      QLog.d("TroopObserversHelper", 2, ((StringBuilder)localObject2).toString());
    }
    ((TroopManager)localObject1).b(localTroopInfo);
    if (QLog.isColorLevel()) {
      QLog.i("TroopObserversHelper", 2, localTroopInfo.Administrator);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret, sendEmptyMessage-TIMER_ID, hasDestory=");
      ((StringBuilder)localObject1).append(TroopObserversHelper.d(this.this$0).aY);
      QLog.d("troop_gag", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TroopObserversHelper.d(this.this$0).aY) {
      TroopObserversHelper.d(this.this$0).cf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.15
 * JD-Core Version:    0.7.0.1
 */