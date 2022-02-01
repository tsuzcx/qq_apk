package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetFollowedDramasReq;
import UserGrowth.stGetFollowedDramasRsp;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSGetFollowDramaRequest
  extends WSRequest<stGetFollowedDramasRsp>
{
  private static final String CMD_STRING = "GetFollowedDramas";
  
  public WSGetFollowDramaRequest(@Nullable String paramString)
  {
    super("GetFollowedDramas");
    stGetFollowedDramasReq localstGetFollowedDramasReq = new stGetFollowedDramasReq();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localstGetFollowedDramasReq.attachInfo = str;
    this.req = localstGetFollowedDramasReq;
  }
  
  public Class<stGetFollowedDramasRsp> getRspClass()
  {
    return stGetFollowedDramasRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetFollowDramaRequest
 * JD-Core Version:    0.7.0.1
 */