package com.tencent.biz.pubaccount.weishi_new.profile;

import UserGrowth.stGetPersonalInfoRsp;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/IWSProfileHomePageRspListener;", "", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "rsp", "LUserGrowth/stGetPersonalInfoRsp;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IWSProfileHomePageRspListener
{
  public abstract void a(int paramInt, @Nullable String paramString);
  
  public abstract void a(@Nullable stGetPersonalInfoRsp paramstGetPersonalInfoRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.IWSProfileHomePageRspListener
 * JD-Core Version:    0.7.0.1
 */