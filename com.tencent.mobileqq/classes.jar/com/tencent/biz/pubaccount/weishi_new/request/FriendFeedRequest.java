package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stFriendFeedReq;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class FriendFeedRequest
  extends WeishiRequest<stFriendFeedRsp>
{
  public FriendFeedRequest(String paramString)
  {
    super("FriendFeed", 10006);
    stFriendFeedReq localstFriendFeedReq = new stFriendFeedReq();
    localstFriendFeedReq.attachInfo = paramString;
    this.a = localstFriendFeedReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.FriendFeedRequest
 * JD-Core Version:    0.7.0.1
 */