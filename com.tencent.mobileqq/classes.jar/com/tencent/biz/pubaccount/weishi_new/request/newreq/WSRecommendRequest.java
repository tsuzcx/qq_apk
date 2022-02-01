package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

public class WSRecommendRequest
  extends WSRequest<stSimpleGetFeedListRsp>
{
  private static final String CMD_STRING = "SimpleGetFeedList";
  private static final String TAG = "RecommendRequest";
  
  public WSRecommendRequest(String paramString1, byte paramByte1, byte paramByte2, ArrayList<String> paramArrayList, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<stExposureFeedInfo> paramArrayList1)
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
    localstSimpleGetFeedListReq.qqNum = WeishiUtils.c();
    localstSimpleGetFeedListReq.subTabID = paramString6;
    localstSimpleGetFeedListReq.exposureFeedList = paramArrayList1;
    this.req = localstSimpleGetFeedListReq;
    boolean bool2 = false;
    if (paramByte2 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsFirst = bool1;
    boolean bool1 = bool2;
    if (paramByte1 == 1) {
      bool1 = true;
    }
    this.mIsRefresh = bool1;
    this.mRequestSubId = paramString6;
  }
  
  public String getExpABTestDataStr()
  {
    if (this.mReqScene == 8) {
      return WSExpPreloadABTestManager.a().h();
    }
    return super.getExpABTestDataStr();
  }
  
  public Class<stSimpleGetFeedListRsp> getRspClass()
  {
    return stSimpleGetFeedListRsp.class;
  }
  
  public boolean isNeedLaunchCalculator()
  {
    int i = this.mReqScene;
    boolean bool = true;
    if ((i == 1) && (isFirst()))
    {
      if (TextUtils.equals(this.mRequestSubId, "1000")) {
        return bool;
      }
      if (TextUtils.isEmpty(this.mRequestSubId)) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRecommendRequest
 * JD-Core Version:    0.7.0.1
 */