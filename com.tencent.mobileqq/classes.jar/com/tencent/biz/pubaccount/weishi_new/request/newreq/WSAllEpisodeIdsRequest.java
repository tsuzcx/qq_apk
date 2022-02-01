package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetAllFeedsByDramaIDReq;
import UserGrowth.stGetAllFeedsByDramaIDRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSAllEpisodeIdsRequest
  extends WSRequest<stGetAllFeedsByDramaIDRsp>
{
  private static final String CMD_STRING = "GetAllFeedsByDramaID";
  
  public WSAllEpisodeIdsRequest(String paramString)
  {
    super("GetAllFeedsByDramaID");
    stGetAllFeedsByDramaIDReq localstGetAllFeedsByDramaIDReq = new stGetAllFeedsByDramaIDReq();
    localstGetAllFeedsByDramaIDReq.dramaID = paramString;
    this.req = localstGetAllFeedsByDramaIDReq;
  }
  
  public Class<stGetAllFeedsByDramaIDRsp> getRspClass()
  {
    return stGetAllFeedsByDramaIDRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSAllEpisodeIdsRequest
 * JD-Core Version:    0.7.0.1
 */