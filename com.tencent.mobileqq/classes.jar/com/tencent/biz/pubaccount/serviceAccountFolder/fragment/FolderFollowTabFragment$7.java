package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import rof;
import rol;

class FolderFollowTabFragment$7
  implements Runnable
{
  FolderFollowTabFragment$7(FolderFollowTabFragment paramFolderFollowTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = rol.a();
    List localList = ((rol)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      rof localrof = (rof)localIterator.next();
      if (FolderFollowTabFragment.a(this.this$0, localrof.a))
      {
        localArrayList.add(localrof);
        localIterator.remove();
      }
    }
    ((rol)localObject).a(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.a;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderFollowTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderFollowTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.7
 * JD-Core Version:    0.7.0.1
 */