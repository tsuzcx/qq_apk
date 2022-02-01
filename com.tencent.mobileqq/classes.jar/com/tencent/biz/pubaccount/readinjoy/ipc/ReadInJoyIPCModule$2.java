package com.tencent.biz.pubaccount.readinjoy.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

class ReadInJoyIPCModule$2
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInJoyIPCModule$2(ReadInJoyIPCModule paramReadInJoyIPCModule, int paramInt) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    paramString1 = new Bundle();
    paramString1.putString("action_get_user_info", ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramString2));
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyIpcReadInJoyIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString1);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = new Bundle();
    paramString.putString("action_get_user_info", ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoJson(paramReadInJoyUserInfo));
    paramString = EIPCResult.createResult(0, paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyIpcReadInJoyIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ipc.ReadInJoyIPCModule.2
 * JD-Core Version:    0.7.0.1
 */