package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

class FolderRecommendTabFragment$BannerPagerAdapter$1
  implements View.OnClickListener
{
  FolderRecommendTabFragment$BannerPagerAdapter$1(FolderRecommendTabFragment.BannerPagerAdapter paramBannerPagerAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    try
    {
      TogetherControlManager.EntryBannerInfo localEntryBannerInfo = (TogetherControlManager.EntryBannerInfo)FolderRecommendTabFragment.BannerPagerAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter).get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter.a((TogetherControlManager.EntryBannerInfo)FolderRecommendTabFragment.BannerPagerAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter).get(this.jdField_a_of_type_Int), paramView.getContext());
      if (localEntryBannerInfo != null) {
        FolderRecommendTabFragment.a("227", "227", localEntryBannerInfo.a.iAdId + "", 102, 1);
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        localIndexOutOfBoundsException.printStackTrace();
        QLog.e("FolderRecommendTabFragment", 1, "on click IndexOutOfBoundsException", localIndexOutOfBoundsException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.BannerPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */