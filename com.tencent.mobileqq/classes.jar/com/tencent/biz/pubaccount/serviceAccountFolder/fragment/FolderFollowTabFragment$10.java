package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import java.util.Iterator;
import java.util.List;

class FolderFollowTabFragment$10
  implements Runnable
{
  FolderFollowTabFragment$10(FolderFollowTabFragment paramFolderFollowTabFragment, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)((Iterator)localObject).next();
        if (localServiceAccountFolderFeed.b > 0) {
          ServiceAccountFolderManager.a().b(FolderFollowTabFragment.a(this.this$0), localServiceAccountFolderFeed, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.10
 * JD-Core Version:    0.7.0.1
 */