package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tua;
import tug;

class FolderFollowTabFragment$6
  implements Runnable
{
  FolderFollowTabFragment$6(FolderFollowTabFragment paramFolderFollowTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = tug.a();
    List localList = ((tug)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      tua localtua = (tua)localIterator.next();
      if (FolderFollowTabFragment.a(this.this$0, localtua.a))
      {
        localArrayList.add(localtua);
        localIterator.remove();
      }
    }
    ((tug)localObject).a(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.a;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderFollowTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderFollowTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.6
 * JD-Core Version:    0.7.0.1
 */