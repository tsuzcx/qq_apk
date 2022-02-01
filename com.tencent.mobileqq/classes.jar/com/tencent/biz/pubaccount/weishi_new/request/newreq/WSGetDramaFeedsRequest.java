package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetDramaFeedsReq;
import UserGrowth.stGetDramaFeedsRsp;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSGetDramaFeedsRequest
  extends WSRequest<stGetDramaFeedsRsp>
{
  private static final String CMD_STRING = "GetDramaFeeds";
  private static final int IS_LOAD_DOWN = 0;
  private static final int IS_LOAD_UP = 1;
  
  public WSGetDramaFeedsRequest(WSDramaEpisodeParams paramWSDramaEpisodeParams, @Nullable String paramString)
  {
    super("GetDramaFeeds");
    stGetDramaFeedsReq localstGetDramaFeedsReq = new stGetDramaFeedsReq();
    String str;
    if (paramWSDramaEpisodeParams.c() == null) {
      str = "";
    } else {
      str = paramWSDramaEpisodeParams.c();
    }
    localstGetDramaFeedsReq.dramaID = str;
    if (paramWSDramaEpisodeParams.d() == null) {
      str = "";
    } else {
      str = paramWSDramaEpisodeParams.d();
    }
    localstGetDramaFeedsReq.curFeedID = str;
    localstGetDramaFeedsReq.refresh = (paramWSDramaEpisodeParams.e() ^ true);
    paramWSDramaEpisodeParams = paramString;
    if (paramString == null) {
      paramWSDramaEpisodeParams = "";
    }
    localstGetDramaFeedsReq.attachInfo = paramWSDramaEpisodeParams;
    this.req = localstGetDramaFeedsReq;
  }
  
  public Class<stGetDramaFeedsRsp> getRspClass()
  {
    return stGetDramaFeedsRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetDramaFeedsRequest
 * JD-Core Version:    0.7.0.1
 */