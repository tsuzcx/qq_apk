package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadController;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.List;

class WSFollowAdapter$1
  implements WSVideoPreDownloadManager.PreDownloadController
{
  WSFollowAdapter$1(WSFollowAdapter paramWSFollowAdapter) {}
  
  public List<WSVideoPreDownloadManager.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    return WSFeedUtils.a(this.a.getDataList(), paramInt, paramBoolean);
  }
  
  public boolean a()
  {
    return AppNetConnInfo.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter.1
 * JD-Core Version:    0.7.0.1
 */