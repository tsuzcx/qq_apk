package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

class FolderRecommendTabFragment$2
  implements Runnable
{
  FolderRecommendTabFragment$2(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 476;
    localTianShuAdPosItemData.b = 6;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, FolderRecommendTabFragment.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.2
 * JD-Core Version:    0.7.0.1
 */