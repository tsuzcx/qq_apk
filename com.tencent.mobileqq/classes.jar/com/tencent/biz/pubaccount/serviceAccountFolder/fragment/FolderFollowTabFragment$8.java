package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import sat;
import saz;

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
        sat localsat = (sat)localIterator.next();
        if (localsat.b > 0) {
          saz.a().b(FolderFollowTabFragment.a(this.this$0), localsat, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.8
 * JD-Core Version:    0.7.0.1
 */