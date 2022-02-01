package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetPersonalInfoReq;
import UserGrowth.stGetPersonalInfoRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/request/ProfileHomePageRequest;", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "LUserGrowth/stGetPersonalInfoRsp;", "pid", "", "(Ljava/lang/String;)V", "getRspClass", "Ljava/lang/Class;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileHomePageRequest
  extends WSRequest<stGetPersonalInfoRsp>
{
  private static final String CMD = "GetPersonalInfo";
  public static final ProfileHomePageRequest.Companion Companion = new ProfileHomePageRequest.Companion(null);
  
  public ProfileHomePageRequest(@NotNull String paramString)
  {
    super("GetPersonalInfo", 10015);
    this.req = ((JceStruct)new stGetPersonalInfoReq(paramString));
  }
  
  @NotNull
  public Class<stGetPersonalInfoRsp> getRspClass()
  {
    return stGetPersonalInfoRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.ProfileHomePageRequest
 * JD-Core Version:    0.7.0.1
 */