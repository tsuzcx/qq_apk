package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import uaq;
import uaw;

class FolderRecommendTabFragment$4
  implements Runnable
{
  FolderRecommendTabFragment$4(FolderRecommendTabFragment paramFolderRecommendTabFragment, List paramList) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        uaq localuaq = (uaq)localIterator.next();
        if (localuaq.b > 0) {
          uaw.a().b(FolderRecommendTabFragment.a(this.this$0), localuaq, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.4
 * JD-Core Version:    0.7.0.1
 */