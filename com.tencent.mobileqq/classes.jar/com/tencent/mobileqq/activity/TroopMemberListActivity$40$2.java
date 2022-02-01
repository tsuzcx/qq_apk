package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberListActivity$40$2
  implements Runnable
{
  TroopMemberListActivity$40$2(TroopMemberListActivity.40 param40, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$40.a.app.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject1).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$40.a.mTroopUin);
    if (localTroopInfo == null) {
      return;
    }
    if (StringUtil.a(localTroopInfo.troopowneruin)) {
      return;
    }
    localTroopInfo.Administrator = "";
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((List)localObject2).size();
    }
    while (j < i)
    {
      localObject2 = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
      if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()))
      {
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject2).trim())))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localTroopInfo.Administrator);
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("|");
          localTroopInfo.Administrator = localStringBuilder.toString();
        }
      }
      j += 1;
    }
    ((ITroopInfoService)localObject1).saveTroopInfo(localTroopInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$40.a.mHandler.obtainMessage();
    ((Message)localObject1).what = 11;
    ((Message)localObject1).obj = localTroopInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$40.a.mHandler.sendMessage((Message)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberListActivityget_troop_member", 2, localTroopInfo.Administrator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */