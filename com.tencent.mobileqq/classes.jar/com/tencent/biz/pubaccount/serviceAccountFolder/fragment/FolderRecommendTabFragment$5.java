package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import java.util.Iterator;
import java.util.List;

class FolderRecommendTabFragment$5
  implements Runnable
{
  FolderRecommendTabFragment$5(FolderRecommendTabFragment paramFolderRecommendTabFragment, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)((Iterator)localObject).next();
        if (localServiceAccountFolderFeed.d > 0) {
          ServiceAccountFolderManager.a().b(FolderRecommendTabFragment.e(this.this$0), localServiceAccountFolderFeed, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.5
 * JD-Core Version:    0.7.0.1
 */