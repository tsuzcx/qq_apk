package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stUpdateWatchDramaReq;
import UserGrowth.stUpdateWatchDramaRsp;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSUpdateWatchDramaRequest
  extends WSRequest<stUpdateWatchDramaRsp>
{
  private static final String CMD_STRING = "UpdateWatchDrama";
  
  public WSUpdateWatchDramaRequest(@NonNull String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2)
  {
    super("UpdateWatchDrama");
    stUpdateWatchDramaReq localstUpdateWatchDramaReq = new stUpdateWatchDramaReq();
    localstUpdateWatchDramaReq.dramaID = paramString1;
    localstUpdateWatchDramaReq.feedNum = paramInt1;
    localstUpdateWatchDramaReq.feedSecond = paramInt2;
    localstUpdateWatchDramaReq.feedID = paramString2;
    this.req = localstUpdateWatchDramaReq;
  }
  
  public Class<stUpdateWatchDramaRsp> getRspClass()
  {
    return stUpdateWatchDramaRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSUpdateWatchDramaRequest
 * JD-Core Version:    0.7.0.1
 */