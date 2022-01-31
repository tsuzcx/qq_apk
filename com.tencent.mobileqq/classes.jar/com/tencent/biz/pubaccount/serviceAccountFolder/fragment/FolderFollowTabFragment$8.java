package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import ssj;
import ssp;

class FolderFollowTabFragment$8
  implements Runnable
{
  FolderFollowTabFragment$8(FolderFollowTabFragment paramFolderFollowTabFragment, List paramList) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ssj localssj = (ssj)localIterator.next();
        if (localssj.b > 0) {
          ssp.a().b(FolderFollowTabFragment.a(this.this$0), localssj, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.8
 * JD-Core Version:    0.7.0.1
 */