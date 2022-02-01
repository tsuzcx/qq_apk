package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController;
import mqq.app.AppRuntime;

public class DoraemonBridge
{
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public DoraemonBridge(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  public static void a(int paramInt, Bundle paramBundle, DoraemonBridge.Callback paramCallback)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("key_sub_cmd", paramInt);
    if (paramCallback != null)
    {
      TroopMemberApiClient.a().a(118, localBundle, paramCallback);
      return;
    }
    TroopMemberApiClient.a().a(118, localBundle);
  }
  
  public void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    switch (paramBundle.getInt("key_sub_cmd"))
    {
    default: 
      return;
    case 1: 
      paramBundle.putBundle("key_result", UserInfoModule.a());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(paramInt1, paramBundle);
      return;
    case 2: 
      str1 = paramBundle.getString("key");
      paramInt1 = paramBundle.getInt("type");
      paramBundle = paramBundle.getString("appid");
      DoraemonFrequenceController.a().b(str1, paramInt1, paramBundle);
      return;
    }
    String str1 = paramBundle.getString("key");
    paramInt1 = paramBundle.getInt("type");
    String str2 = paramBundle.getString("appid");
    paramBundle = paramBundle.getString("api");
    DoraemonFrequenceController.a().b(str1, paramInt1, str2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonBridge
 * JD-Core Version:    0.7.0.1
 */