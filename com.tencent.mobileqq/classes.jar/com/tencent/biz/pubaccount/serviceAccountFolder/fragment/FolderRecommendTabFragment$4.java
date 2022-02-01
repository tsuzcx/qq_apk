package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import tua;
import tug;

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
        tua localtua = (tua)localIterator.next();
        if (localtua.b > 0) {
          tug.a().b(FolderRecommendTabFragment.a(this.this$0), localtua, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.4
 * JD-Core Version:    0.7.0.1
 */