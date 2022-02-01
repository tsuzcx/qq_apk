package com.tencent.mobileqq.activity;

import aeom;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopMemberListActivity$40$4
  implements Runnable
{
  public TroopMemberListActivity$40$4(aeom paramaeom, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_Aeom.a.app.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(this.jdField_a_of_type_Aeom.a.b);
    if (localTroopInfo == null) {}
    label68:
    label124:
    do
    {
      do
      {
        return;
      } while (StringUtil.isEmpty(localTroopInfo.troopowneruin));
      localTroopInfo.Administrator = "";
      int i;
      int j;
      Object localObject2;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 0;
        j = 0;
        if (j >= i) {
          break label204;
        }
        localObject2 = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break label124;
        }
      }
      for (;;)
      {
        j += 1;
        break label68;
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject2).trim()))) {
          localTroopInfo.Administrator = (localTroopInfo.Administrator + (String)localObject2 + "|");
        }
      }
      ((TroopManager)localObject1).b(localTroopInfo);
      localObject1 = this.jdField_a_of_type_Aeom.a.a.obtainMessage();
      ((Message)localObject1).what = 11;
      ((Message)localObject1).obj = localTroopInfo;
      this.jdField_a_of_type_Aeom.a.a.sendMessage((Message)localObject1);
    } while (!QLog.isColorLevel());
    label204:
    QLog.i("TroopMemberListActivityget_troop_member", 2, localTroopInfo.Administrator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.4
 * JD-Core Version:    0.7.0.1
 */