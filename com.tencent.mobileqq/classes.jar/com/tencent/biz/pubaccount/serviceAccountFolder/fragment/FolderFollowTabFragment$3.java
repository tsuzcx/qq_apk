package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.part.block.MultiViewBlock.onLoadDataDelegate;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;

class FolderFollowTabFragment$3
  implements MultiViewBlock.onLoadDataDelegate<RelativeLiveFeedsAdapter>
{
  FolderFollowTabFragment$3(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void a(LoadInfo paramLoadInfo, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (paramLoadInfo.e())
    {
      FolderFollowTabFragment.a(this.a, paramRelativeLiveFeedsAdapter);
      FolderFollowTabFragment.b(this.a, paramRelativeLiveFeedsAdapter);
      return;
    }
    if ((paramLoadInfo.d()) || (paramLoadInfo.c()))
    {
      FolderFollowTabFragment.c(this.a, paramRelativeLiveFeedsAdapter);
      FolderFollowTabFragment.d(this.a, paramRelativeLiveFeedsAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.3
 * JD-Core Version:    0.7.0.1
 */