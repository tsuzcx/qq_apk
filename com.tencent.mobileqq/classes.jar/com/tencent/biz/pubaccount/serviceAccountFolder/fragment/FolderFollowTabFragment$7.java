package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ssj;
import ssp;

class FolderFollowTabFragment$7
  implements Runnable
{
  FolderFollowTabFragment$7(FolderFollowTabFragment paramFolderFollowTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = ssp.a();
    List localList = ((ssp)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ssj localssj = (ssj)localIterator.next();
      if (FolderFollowTabFragment.a(this.this$0, localssj.a))
      {
        localArrayList.add(localssj);
        localIterator.remove();
      }
    }
    ((ssp)localObject).a(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.a;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderFollowTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderFollowTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.7
 * JD-Core Version:    0.7.0.1
 */