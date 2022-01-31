package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.mobileqq.data.RockDownloadInfo;
import rwm;
import sai;

public class WSRecommendAdapter$1
  extends RockDownloadListenerWrapper
{
  public WSRecommendAdapter$1(rwm paramrwm) {}
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    super.onDownloadSuccess(paramRockDownloadInfo);
    rwm.b += 1;
    sai.d("WSRecommendAdapter", "RockDownloadSuccess openDownloadWSCount = " + rwm.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1
 * JD-Core Version:    0.7.0.1
 */