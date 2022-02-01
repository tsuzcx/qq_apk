package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetPersonalFeedListReq;
import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

public class ProfileFeedListRequest
  extends WSRequest<stGetPersonalFeedListRsp>
{
  private static final String CMD_STRING = "GetPersonalFeedList";
  private static final String TAG = "PersonalFeedListRequest";
  
  public ProfileFeedListRequest(String paramString1, String paramString2, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
  {
    super("GetPersonalFeedList", paramInt1);
    stGetPersonalFeedListReq localstGetPersonalFeedListReq = new stGetPersonalFeedListReq();
    localstGetPersonalFeedListReq.personId = paramString1;
    localstGetPersonalFeedListReq.attach_info = paramString2;
    localstGetPersonalFeedListReq.isFirst = paramBoolean;
    localstGetPersonalFeedListReq.context_feedids = paramArrayList;
    localstGetPersonalFeedListReq.scene = paramInt1;
    localstGetPersonalFeedListReq.reqType = paramInt2;
    this.req = localstGetPersonalFeedListReq;
    paramString1 = new StringBuilder();
    paramString1.append("stSimpleGetFeedListReq  = ");
    paramString1.append(localstGetPersonalFeedListReq.toString());
    WSLog.d("PersonalFeedListRequest", paramString1.toString());
  }
  
  public Class<stGetPersonalFeedListRsp> getRspClass()
  {
    return stGetPersonalFeedListRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.ProfileFeedListRequest
 * JD-Core Version:    0.7.0.1
 */