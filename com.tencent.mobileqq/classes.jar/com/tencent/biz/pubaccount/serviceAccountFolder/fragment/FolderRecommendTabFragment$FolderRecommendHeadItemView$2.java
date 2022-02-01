package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class FolderRecommendTabFragment$FolderRecommendHeadItemView$2
  implements ViewPager.OnPageChangeListener
{
  FolderRecommendTabFragment$FolderRecommendHeadItemView$2(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    TogetherControlManager.EntryBannerInfo localEntryBannerInfo = (TogetherControlManager.EntryBannerInfo)FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.a).a().get(paramInt);
    if (localEntryBannerInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localEntryBannerInfo.a.iAdId);
      localStringBuilder.append("");
      FolderRecommendTabFragment.a("227", "227", localStringBuilder.toString(), 101, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView.2
 * JD-Core Version:    0.7.0.1
 */