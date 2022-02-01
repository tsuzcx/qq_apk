package com.tencent.biz.troop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopMemberApiService$5
  extends TroopObserver
{
  TroopMemberApiService$5(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
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
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    TroopMemberApiService.a(this.a, TYPE_GET_TROOP_INFO, paramBoolean, paramString, getClass().getSuperclass().getName(), "com.tencent.mobileqq:troopmanage");
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 2, String.format("onGetTroopInfoResult [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
  }
  
  public void onGetUinByOpenId(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TYPE_GET_UIN_BY_OPEN_ID);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("appid", paramInt1);
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putInt("seq", paramInt2);
    localBundle.putInt("retCode", paramInt3);
    localBundle.putString("uin", paramString3);
    if ((paramObject instanceof AllInOne))
    {
      paramString3 = (AllInOne)paramObject;
      if ((paramString3 != null) && ((!TextUtils.isEmpty(paramString3.nickname)) || (!TextUtils.isEmpty(paramString3.remark)))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localBundle.putBoolean("isFriend", paramBoolean);
      paramString2 = "";
      if (paramString3 == null) {
        paramString1 = "";
      } else {
        paramString1 = paramString3.nickname;
      }
      localBundle.putString("nickName", paramString1);
      if (paramString3 == null) {
        paramString1 = paramString2;
      } else {
        paramString1 = paramString3.remark;
      }
      localBundle.putString("remark", paramString1);
    }
    this.a.a(60, localBundle);
  }
  
  public void onTroopOpenApiVerifyed(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5)
  {
    paramString3 = new Bundle();
    paramString3.putInt("type", TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY);
    paramString3.putBoolean("isSuccess", paramBoolean);
    paramString3.putInt("appid", paramInt1);
    paramString3.putString("openGroupId", paramString1);
    paramString3.putString("token", paramString2);
    paramString3.putInt("freq", paramInt2);
    paramString3.putInt("expireTime", paramInt3);
    paramString3.putStringArrayList("apilist", paramArrayList);
    paramString3.putInt("seq", paramInt4);
    paramString3.putInt("retCode", paramInt5);
    this.a.a(28, paramString3);
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    paramList = this.a;
    paramInt1 = TYPR_GET_TROOP_GETMEMBERLIST;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(paramList, paramInt1, paramBoolean, new Object[] { paramString, null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(paramInt2) }, str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.5
 * JD-Core Version:    0.7.0.1
 */