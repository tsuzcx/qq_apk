package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import mqq.os.MqqHandler;
import sbc;

public class FolderFollowTabFragment$1
  implements Runnable
{
  FolderFollowTabFragment$1(FolderFollowTabFragment paramFolderFollowTabFragment, sbc paramsbc) {}
  
  public void run()
  {
    this.a.a(FolderFollowTabFragment.a(this.this$0));
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.arg1 = FolderFollowTabFragment.c;
    FolderFollowTabFragment.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.1
 * JD-Core Version:    0.7.0.1
 */