package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;

class FolderRecommendTabFragment$1
  implements TianShuGetAdvCallback
{
  FolderRecommendTabFragment$1(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (paramBoolean) {
      paramGetAdsRsp = TogetherControlManager.EntryBannerInfo.a(paramBoolean, paramGetAdsRsp, 476);
    } else {
      paramGetAdsRsp = null;
    }
    if (FolderRecommendTabFragment.a(this.a) != null) {
      FolderRecommendTabFragment.a(this.a).a(paramGetAdsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.1
 * JD-Core Version:    0.7.0.1
 */