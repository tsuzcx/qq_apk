package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class FolderFollowTabFragment$5
  implements BusinessObserver
{
  FolderFollowTabFragment$5(FolderFollowTabFragment paramFolderFollowTabFragment, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new FolderFollowTabFragment.5.1(this, paramBoolean, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.5
 * JD-Core Version:    0.7.0.1
 */