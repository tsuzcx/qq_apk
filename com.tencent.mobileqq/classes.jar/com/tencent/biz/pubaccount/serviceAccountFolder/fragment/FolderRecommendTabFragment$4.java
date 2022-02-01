package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class FolderRecommendTabFragment$4
  implements Runnable
{
  FolderRecommendTabFragment$4(FolderRecommendTabFragment paramFolderRecommendTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = ServiceAccountFolderManager.a();
    List localList = ((ServiceAccountFolderManager)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      if (FolderRecommendTabFragment.a(this.this$0, localServiceAccountFolderFeed.a))
      {
        localArrayList.add(localServiceAccountFolderFeed);
        localIterator.remove();
      }
    }
    ((ServiceAccountFolderManager)localObject).a(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.a;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderRecommendTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderRecommendTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.4
 * JD-Core Version:    0.7.0.1
 */