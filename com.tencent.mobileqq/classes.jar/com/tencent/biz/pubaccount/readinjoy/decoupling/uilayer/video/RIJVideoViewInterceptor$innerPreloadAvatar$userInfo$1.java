package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onLoadUserInfoFailed(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errMsg");
    QLog.e("RIJVideoViewInterceptor", 2, "onLoadUserInfoFailed uin:" + paramString1 + " errMsg:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(@NotNull String paramString, @NotNull ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyUserInfo, "userInfo");
    RIJVideoViewInterceptor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoRIJVideoViewInterceptor, paramReadInJoyUserInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor.innerPreloadAvatar.userInfo.1
 * JD-Core Version:    0.7.0.1
 */