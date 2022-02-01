package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import mqq.os.MqqHandler;

class FolderRecommendTabFragment$6
  implements Runnable
{
  FolderRecommendTabFragment$6(FolderRecommendTabFragment paramFolderRecommendTabFragment, ServiceAccountFolderManager paramServiceAccountFolderManager) {}
  
  public void run()
  {
    if ((this.a != null) && (FolderRecommendTabFragment.e(this.this$0) != null))
    {
      this.a.c(FolderRecommendTabFragment.e(this.this$0));
      Message localMessage = Message.obtain();
      localMessage.what = 100;
      localMessage.arg1 = FolderFollowTabFragment.g;
      FolderRecommendTabFragment.c(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.6
 * JD-Core Version:    0.7.0.1
 */