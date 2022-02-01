package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.List;

class FolderRecommendTabFragment$1
  implements TianShuGetAdvCallback
{
  FolderRecommendTabFragment$1(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    List localList = null;
    if (paramBoolean) {
      localList = TogetherControlManager.EntryBannerInfo.a(paramBoolean, paramGetAdsRsp, 476);
    }
    if (FolderRecommendTabFragment.a(this.a) != null) {
      FolderRecommendTabFragment.a(this.a).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.1
 * JD-Core Version:    0.7.0.1
 */