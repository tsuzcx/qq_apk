package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.mobileqq.data.RockDownloadInfo;
import tby;
import tlo;

public class WSRecommendAdapter$1
  extends RockDownloadListenerWrapper
{
  public WSRecommendAdapter$1(tby paramtby) {}
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    super.onDownloadSuccess(paramRockDownloadInfo);
    tby.b += 1;
    tlo.d("WSRecommendAdapter", "RockDownloadSuccess openDownloadWSCount = " + tby.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1
 * JD-Core Version:    0.7.0.1
 */