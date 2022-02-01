package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import cooperation.vip.tianshu.TianShuAdPosItemData;
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
    localTianShuAdPosItemData.mPosId = 476;
    localTianShuAdPosItemData.mNeedCnt = 6;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, FolderRecommendTabFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.2
 * JD-Core Version:    0.7.0.1
 */