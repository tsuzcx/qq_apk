package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stFollowFeedsReq;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class FollowRequest
  extends WeishiRequest<stFollowFeedsRsp>
{
  public FollowRequest(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    super("FollowFeeds", paramInt);
    stFollowFeedsReq localstFollowFeedsReq = new stFollowFeedsReq();
    localstFollowFeedsReq.attatch_info = paramString1;
    localstFollowFeedsReq.is_refresh = paramBoolean2;
    localstFollowFeedsReq.is_first = paramBoolean1;
    localstFollowFeedsReq.push_info = paramString2;
    localstFollowFeedsReq.scene = paramInt;
    this.c = localstFollowFeedsReq;
    WSLog.d("FollowRequest", localstFollowFeedsReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.FollowRequest
 * JD-Core Version:    0.7.0.1
 */