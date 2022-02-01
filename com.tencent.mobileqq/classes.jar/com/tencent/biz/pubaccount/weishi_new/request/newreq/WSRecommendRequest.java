package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

public class WSRecommendRequest
  extends WSRequest<stSimpleGetFeedListRsp>
{
  private static final String CMD_STRING = "SimpleGetFeedList";
  private static final String TAG = "RecommendRequest";
  
  public WSRecommendRequest(String paramString1, byte paramByte1, byte paramByte2, ArrayList<String> paramArrayList, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
    localstSimpleGetFeedListReq.subTabID = paramString6;
    this.req = localstSimpleGetFeedListReq;
    if (paramByte2 == 1)
    {
      bool1 = true;
      this.mIsFirst = bool1;
      if (paramByte1 != 1) {
        break label186;
      }
    }
    label186:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsRefresh = bool1;
      this.mRequestSubId = paramString6;
      WSLog.d("RecommendRequest", "stSimpleGetFeedListReq  = " + localstSimpleGetFeedListReq.toString());
      return;
      bool1 = false;
      break;
    }
  }
  
  public String getExpABTestDataStr()
  {
    if (this.mReqScene == 8) {
      return WSExpPreloadABTestManager.a().a();
    }
    return super.getExpABTestDataStr();
  }
  
  public Class<stSimpleGetFeedListRsp> getRspClass()
  {
    return stSimpleGetFeedListRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRecommendRequest
 * JD-Core Version:    0.7.0.1
 */