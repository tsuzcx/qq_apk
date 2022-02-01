package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.extendsblock.SingleViewBlock;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

class FolderRecommendTabFragment$RecommendHeaderBlock
  extends SingleViewBlock
{
  FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  
  public FolderRecommendTabFragment$RecommendHeaderBlock(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(paramViewGroup.getContext());
    if (FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment) != null) {
      FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo)
  {
    paramLoadInfo = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 476;
    localTianShuAdPosItemData.b = 6;
    paramLoadInfo.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(paramLoadInfo, FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment));
  }
  
  public void a(List<TogetherControlManager.EntryBannerInfo> paramList)
  {
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView).a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      FolderRecommendTabFragment.a("227", "227", ((TogetherControlManager.EntryBannerInfo)paramList.get(0)).a.iAdId + "", 101, 1);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.RecommendHeaderBlock
 * JD-Core Version:    0.7.0.1
 */