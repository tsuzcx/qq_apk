package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler$getUserInfo$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountNewBridgeInvokeHandler$getUserInfo$$inlined$also$lambda$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  PublicAccountNewBridgeInvokeHandler$getUserInfo$$inlined$also$lambda$1(String paramString1, PublicAccountNewBridgeInvokeHandler paramPublicAccountNewBridgeInvokeHandler, String paramString2) {}
  
  public void onLoadUserInfoFailed(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errMsg");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgePublicAccountNewBridgeInvokeHandler.a(this.jdField_a_of_type_JavaLangString, ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramString2));
  }
  
  public void onLoadUserInfoSucceed(@NotNull String paramString, @NotNull ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyUserInfo, "userInfo");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgePublicAccountNewBridgeInvokeHandler.a(this.jdField_a_of_type_JavaLangString, ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoJson(paramReadInJoyUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler.getUserInfo..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */