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
  FolderRecommendTabFragment.FolderRecommendHeadItemView a;
  
  public FolderRecommendTabFragment$RecommendHeaderBlock(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new FolderRecommendTabFragment.FolderRecommendHeadItemView(paramViewGroup.getContext());
    if (FolderRecommendTabFragment.d(this.b) != null) {
      FolderRecommendTabFragment.d(this.b).a(this.a);
    }
    return this.a;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo)
  {
    paramLoadInfo = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 476;
    localTianShuAdPosItemData.b = 6;
    paramLoadInfo.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(paramLoadInfo, FolderRecommendTabFragment.b(this.b));
  }
  
  public void a(List<TogetherControlManager.EntryBannerInfo> paramList)
  {
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.a).a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TogetherControlManager.EntryBannerInfo)paramList.get(0)).d.iAdId);
      localStringBuilder.append("");
      FolderRecommendTabFragment.a("227", "227", localStringBuilder.toString(), 101, 1);
      this.a.a(true);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.RecommendHeaderBlock
 * JD-Core Version:    0.7.0.1
 */