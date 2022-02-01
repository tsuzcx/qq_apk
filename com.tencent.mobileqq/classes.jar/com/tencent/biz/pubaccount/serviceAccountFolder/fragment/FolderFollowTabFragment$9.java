package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class FolderFollowTabFragment$9
  implements Runnable
{
  FolderFollowTabFragment$9(FolderFollowTabFragment paramFolderFollowTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = ServiceAccountFolderManager.a();
    List localList = ((ServiceAccountFolderManager)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      if (FolderFollowTabFragment.a(this.this$0, localServiceAccountFolderFeed.a))
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
    FolderFollowTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderFollowTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.9
 * JD-Core Version:    0.7.0.1
 */