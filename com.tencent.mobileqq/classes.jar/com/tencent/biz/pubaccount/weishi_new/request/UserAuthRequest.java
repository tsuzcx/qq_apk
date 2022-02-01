package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.eConfigBit;
import UserGrowth.stUserConfigReq;
import UserGrowth.stUserConfigRsp;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class UserAuthRequest
  extends WeishiRequest<stUserConfigRsp>
{
  public UserAuthRequest(@NonNull eConfigBit parameConfigBit)
  {
    super("UserConfig", 10005);
    stUserConfigReq localstUserConfigReq = new stUserConfigReq();
    localstUserConfigReq.config_set = parameConfigBit.value();
    this.a = localstUserConfigReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.UserAuthRequest
 * JD-Core Version:    0.7.0.1
 */