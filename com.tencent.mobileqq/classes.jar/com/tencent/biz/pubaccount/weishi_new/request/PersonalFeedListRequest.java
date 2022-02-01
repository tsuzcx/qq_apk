package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetPersonalFeedListReq;
import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

public class PersonalFeedListRequest
  extends WeishiRequest<stGetPersonalFeedListRsp>
{
  public PersonalFeedListRequest(String paramString1, String paramString2, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    super("GetPersonalFeedList", paramInt);
    stGetPersonalFeedListReq localstGetPersonalFeedListReq = new stGetPersonalFeedListReq();
    localstGetPersonalFeedListReq.personId = paramString1;
    localstGetPersonalFeedListReq.attach_info = paramString2;
    localstGetPersonalFeedListReq.isFirst = paramBoolean;
    localstGetPersonalFeedListReq.context_feedids = paramArrayList;
    localstGetPersonalFeedListReq.scene = paramInt;
    this.a = localstGetPersonalFeedListReq;
    WSLog.d("PersonalFeedListRequest", "stSimpleGetFeedListReq  = " + localstGetPersonalFeedListReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PersonalFeedListRequest
 * JD-Core Version:    0.7.0.1
 */