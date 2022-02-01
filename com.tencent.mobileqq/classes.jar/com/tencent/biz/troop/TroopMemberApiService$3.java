package com.tencent.biz.troop;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopMemberApiService$3
  extends TroopObserver
{
  TroopMemberApiService$3(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (!"TroopMemberApiService.create_troop".equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = AIOUtils.a(new Intent(BaseApplication.getContext(), SplashActivity.class), new int[] { 2 });
      paramString.putExtra("uin", paramTroopInfo.troopuin);
      paramString.putExtra("uintype", 1);
      paramString.putExtra("uinname", paramTroopInfo.getTroopDisplayName());
      this.a.startActivity(paramString);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", this.a.g);
    paramTroopInfo.putString("callback", this.a.c);
    this.a.a(112, paramTroopInfo);
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.i);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", paramString);
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.a.a(3, localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 2, String.format("onGetTroopInfoResult [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
  }
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    paramList = new Bundle();
    paramList.putInt("type", TroopNotificationConstants.e);
    paramList.putBoolean("isSuccess", paramBoolean);
    paramList.putSerializable("data", new Object[] { paramString, null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(paramInt2) });
    paramList.putSerializable("observer_type", Integer.valueOf(3));
    this.a.a(3, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.3
 * JD-Core Version:    0.7.0.1
 */