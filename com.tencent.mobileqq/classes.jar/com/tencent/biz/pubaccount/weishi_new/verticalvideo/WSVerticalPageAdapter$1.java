package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadController;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.List;

class WSVerticalPageAdapter$1
  implements WSVideoPreDownloadManager.PreDownloadController
{
  WSVerticalPageAdapter$1(WSVerticalPageAdapter paramWSVerticalPageAdapter) {}
  
  public List<WSVideoPreDownloadManager.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    return WSVerticalUtils.a(this.a.b(), paramInt, paramBoolean);
  }
  
  public boolean a()
  {
    return AppNetConnInfo.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter.1
 * JD-Core Version:    0.7.0.1
 */