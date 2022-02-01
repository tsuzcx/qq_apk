package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

public class RecommendRequest
  extends WeishiRequest<stSimpleGetFeedListRsp>
{
  public RecommendRequest(String paramString1, byte paramByte1, byte paramByte2, ArrayList<String> paramArrayList, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super("SimpleGetFeedList", paramInt);
    stSimpleGetFeedListReq localstSimpleGetFeedListReq = new stSimpleGetFeedListReq();
    localstSimpleGetFeedListReq.attach_info = paramString1;
    localstSimpleGetFeedListReq.isrefresh = paramByte1;
    localstSimpleGetFeedListReq.isfirst = paramByte2;
    localstSimpleGetFeedListReq.channel_info = "from_android_qq";
    localstSimpleGetFeedListReq.context_feedids = paramArrayList;
    localstSimpleGetFeedListReq.scene = paramInt;
    localstSimpleGetFeedListReq.gdt_args = paramString2;
    localstSimpleGetFeedListReq.rowkey = paramString3;
    localstSimpleGetFeedListReq.session = paramString4;
    localstSimpleGetFeedListReq.push_info = paramString5;
    localstSimpleGetFeedListReq.linkStragetyArgs = WeishiLinkUtil.a();
    localstSimpleGetFeedListReq.qqNum = WeishiUtils.a();
    this.jdField_a_of_type_ComQqTafJceJceStruct = localstSimpleGetFeedListReq;
    paramString1 = new StringBuilder();
    paramString1.append("stSimpleGetFeedListReq  = ");
    paramString1.append(localstSimpleGetFeedListReq.toString());
    WSLog.d("RecommendRequest", paramString1.toString());
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Int == 8) {
      return WSExpPreloadABTestManager.a().a();
    }
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.RecommendRequest
 * JD-Core Version:    0.7.0.1
 */