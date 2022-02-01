package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class FolderFollowTabFragment$FollowTabBroadcastReceiver
  extends BroadcastReceiver
{
  private FolderFollowTabFragment$FollowTabBroadcastReceiver(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_refresh_return_page")) && (FolderFollowTabFragment.e(this.a) != null))
    {
      paramContext = this.a;
      FolderFollowTabFragment.c(paramContext, FolderFollowTabFragment.e(paramContext));
      paramContext = this.a;
      FolderFollowTabFragment.d(paramContext, FolderFollowTabFragment.e(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.FollowTabBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */