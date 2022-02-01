package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import mqq.os.MqqHandler;
import tue;

class FolderRecommendTabFragment$5
  implements Runnable
{
  FolderRecommendTabFragment$5(FolderRecommendTabFragment paramFolderRecommendTabFragment, tue paramtue) {}
  
  public void run()
  {
    if ((this.a != null) && (FolderRecommendTabFragment.a(this.this$0) != null))
    {
      this.a.a(FolderRecommendTabFragment.a(this.this$0));
      Message localMessage = Message.obtain();
      localMessage.what = 100;
      localMessage.arg1 = FolderFollowTabFragment.c;
      FolderRecommendTabFragment.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.5
 * JD-Core Version:    0.7.0.1
 */