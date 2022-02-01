package com.tencent.biz.troop;

import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import android.os.Bundle;
import com.tencent.mobileqq.app.LBSObserver;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

class TroopMemberApiService$11
  extends LBSObserver
{
  TroopMemberApiService$11(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 8);
    localBundle.putInt("iFilterId", paramInt);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), paramRspGetNearbyGroup });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean, int paramInt, cmd0x7f5.GroupInfo paramGroupInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 28);
    localBundle.putBoolean("isSuccess", paramBoolean);
    if (paramGroupInfo != null) {
      localBundle.putByteArray("groupInfo", paramGroupInfo.toByteArray());
    }
    localBundle.putInt("count", paramInt);
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 12);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { Boolean.valueOf(paramBoolean2), paramRspGetAreaList });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
    localBundle.putSerializable("", paramRspGetAreaList);
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 13);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramRspGetGroupInArea });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.11
 * JD-Core Version:    0.7.0.1
 */