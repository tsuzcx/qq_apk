package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.data.RockDownloadInfo;

class WSRecommendAdapter$1
  extends RockDownloadListenerWrapper
{
  WSRecommendAdapter$1(WSRecommendAdapter paramWSRecommendAdapter) {}
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    super.onDownloadSuccess(paramRockDownloadInfo);
    WSRecommendAdapter.b += 1;
    paramRockDownloadInfo = new StringBuilder();
    paramRockDownloadInfo.append("RockDownloadSuccess openDownloadWSCount = ");
    paramRockDownloadInfo.append(WSRecommendAdapter.b);
    WSLog.d("WSRecommendAdapter", paramRockDownloadInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1
 * JD-Core Version:    0.7.0.1
 */