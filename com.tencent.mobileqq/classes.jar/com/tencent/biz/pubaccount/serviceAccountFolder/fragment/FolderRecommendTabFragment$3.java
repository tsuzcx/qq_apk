package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import uaq;
import uaw;

class FolderRecommendTabFragment$3
  implements Runnable
{
  FolderRecommendTabFragment$3(FolderRecommendTabFragment paramFolderRecommendTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = uaw.a();
    List localList = ((uaw)localObject).a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      uaq localuaq = (uaq)localIterator.next();
      if (FolderRecommendTabFragment.a(this.this$0, localuaq.a))
      {
        localArrayList.add(localuaq);
        localIterator.remove();
      }
    }
    ((uaw)localObject).a(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.a;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderRecommendTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderRecommendTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.3
 * JD-Core Version:    0.7.0.1
 */