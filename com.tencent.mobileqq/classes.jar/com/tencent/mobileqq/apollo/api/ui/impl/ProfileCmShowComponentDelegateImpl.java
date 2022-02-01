package com.tencent.mobileqq.apollo.api.ui.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.apollo.api.ui.IProfileCmShowComponentDelegate;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class ProfileCmShowComponentDelegateImpl
  implements Handler.Callback, IProfileCmShowComponentDelegate
{
  private static final int MSG_REFRESH_APOLLO = 1;
  private static final String TAG = "ProfileCmShowComponentDelegateImpl";
  private FriendCardApolloViewController mApolloViewController;
  protected boolean mFirstInit;
  private Handler mUIHandler;
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCmShowComponentDelegateImpl", 0, "handleMessage MSG_REFRESH_APOLLO");
      }
    } while (this.mApolloViewController == null);
    this.mApolloViewController.a();
    return false;
  }
  
  public void onCreate(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView, Bundle paramBundle)
  {
    this.mApolloViewController = new FriendCardApolloViewController(paramFriendProfileCardActivity, paramView);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeMessages(1);
      this.mUIHandler.sendEmptyMessageDelayed(1, 100L);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    if (this.mApolloViewController != null) {
      this.mApolloViewController.e();
    }
  }
  
  public void onPause()
  {
    if (this.mApolloViewController != null) {
      this.mApolloViewController.c();
    }
  }
  
  public void onResume()
  {
    if (this.mApolloViewController != null) {
      this.mApolloViewController.b();
    }
  }
  
  public void onStop()
  {
    if (this.mApolloViewController != null) {
      this.mApolloViewController.d();
    }
  }
  
  public void onWindowFocusGained()
  {
    if ((!this.mFirstInit) || ((this.mApolloViewController != null) && (this.mApolloViewController.a())))
    {
      this.mUIHandler.removeMessages(1);
      this.mUIHandler.sendEmptyMessageDelayed(1, 100L);
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(false);
      }
      this.mFirstInit = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.ProfileCmShowComponentDelegateImpl
 * JD-Core Version:    0.7.0.1
 */