package com.tencent.mobileqq.apollo.profilecard.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController;
import com.tencent.mobileqq.apollo.profilecard.api.ICmShowProfileComponent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public class CmShowProfileComponentImpl
  implements Handler.Callback, ICmShowProfileComponent
{
  private static final int MSG_REFRESH_APOLLO = 1;
  private static final String TAG = "[cmshow]CmShowProfileComponentImpl";
  private FriendCardApolloViewController mApolloViewController;
  protected boolean mFirstInit;
  private Handler mUIHandler;
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowProfileComponentImpl", 0, "handleMessage MSG_REFRESH_APOLLO");
    }
    paramMessage = this.mApolloViewController;
    if (paramMessage != null) {
      paramMessage.b();
    }
    return false;
  }
  
  public void onCreate(Activity paramActivity, View paramView, Bundle paramBundle, ProfileCardInfo paramProfileCardInfo, IProfileConfig paramIProfileConfig)
  {
    if (!(paramActivity instanceof QBaseActivity))
    {
      QLog.e("[cmshow]CmShowProfileComponentImpl", 1, "[OnCreate] friendProfileCardActivityObj is not instance of QBaseActivity");
      return;
    }
    this.mApolloViewController = new FriendCardApolloViewController((QBaseActivity)paramActivity, paramView, paramProfileCardInfo, paramIProfileConfig);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean onDataUpdate(Object paramObject)
  {
    paramObject = this.mUIHandler;
    if (paramObject != null)
    {
      paramObject.removeMessages(1);
      this.mUIHandler.sendEmptyMessageDelayed(1, 100L);
    }
    return false;
  }
  
  public void onDestroy()
  {
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    localObject = this.mApolloViewController;
    if (localObject != null) {
      ((FriendCardApolloViewController)localObject).g();
    }
  }
  
  public void onPause()
  {
    FriendCardApolloViewController localFriendCardApolloViewController = this.mApolloViewController;
    if (localFriendCardApolloViewController != null) {
      localFriendCardApolloViewController.e();
    }
  }
  
  public void onResume()
  {
    FriendCardApolloViewController localFriendCardApolloViewController = this.mApolloViewController;
    if (localFriendCardApolloViewController != null) {
      localFriendCardApolloViewController.d();
    }
  }
  
  public void onStop()
  {
    FriendCardApolloViewController localFriendCardApolloViewController = this.mApolloViewController;
    if (localFriendCardApolloViewController != null) {
      localFriendCardApolloViewController.f();
    }
  }
  
  public void onWindowFocusGained()
  {
    FriendCardApolloViewController localFriendCardApolloViewController;
    if (this.mFirstInit)
    {
      localFriendCardApolloViewController = this.mApolloViewController;
      if ((localFriendCardApolloViewController == null) || (!localFriendCardApolloViewController.a())) {}
    }
    else
    {
      this.mUIHandler.removeMessages(1);
      this.mUIHandler.sendEmptyMessageDelayed(1, 100L);
      localFriendCardApolloViewController = this.mApolloViewController;
      if (localFriendCardApolloViewController != null) {
        localFriendCardApolloViewController.a(false);
      }
      this.mFirstInit = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.api.impl.CmShowProfileComponentImpl
 * JD-Core Version:    0.7.0.1
 */