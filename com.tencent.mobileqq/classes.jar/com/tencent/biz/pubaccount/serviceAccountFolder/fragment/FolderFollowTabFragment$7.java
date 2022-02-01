package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import uon;
import uot;

class FolderFollowTabFragment$7
  implements Runnable
{
  FolderFollowTabFragment$7(FolderFollowTabFragment paramFolderFollowTabFragment, List paramList) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        uon localuon = (uon)localIterator.next();
        if (localuon.b > 0) {
          uot.a().b(FolderFollowTabFragment.a(this.this$0), localuon, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.7
 * JD-Core Version:    0.7.0.1
 */