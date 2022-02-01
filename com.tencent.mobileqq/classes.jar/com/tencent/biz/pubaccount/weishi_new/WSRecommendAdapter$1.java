package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.mobileqq.data.RockDownloadInfo;
import uyd;
import vmp;

public class WSRecommendAdapter$1
  extends RockDownloadListenerWrapper
{
  public WSRecommendAdapter$1(uyd paramuyd) {}
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    super.onDownloadSuccess(paramRockDownloadInfo);
    uyd.b += 1;
    vmp.d("WSRecommendAdapter", "RockDownloadSuccess openDownloadWSCount = " + uyd.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1
 * JD-Core Version:    0.7.0.1
 */