package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpReq;
import UserGrowth.stGetFeedIconOpRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import java.util.ArrayList;

public class GetRichOpInfoRequest
  extends WeishiRequest<stGetFeedIconOpRsp>
{
  public GetRichOpInfoRequest(stFeedOpInfo paramstFeedOpInfo, ArrayList<stFeedOpInfo> paramArrayList1, ArrayList<stFeedOpInfo> paramArrayList2)
  {
    super("GetFeedIconOp", 10011);
    stGetFeedIconOpReq localstGetFeedIconOpReq = new stGetFeedIconOpReq();
    localstGetFeedIconOpReq.opInfo = paramstFeedOpInfo;
    localstGetFeedIconOpReq.preOpInfos = paramArrayList1;
    localstGetFeedIconOpReq.postOpInfos = paramArrayList2;
    this.a = localstGetFeedIconOpReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetRichOpInfoRequest
 * JD-Core Version:    0.7.0.1
 */