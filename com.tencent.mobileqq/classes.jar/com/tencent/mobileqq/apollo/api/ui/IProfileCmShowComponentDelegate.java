package com.tencent.mobileqq.apollo.api.ui;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IProfileCmShowComponentDelegate
  extends QRouteApi
{
  public abstract boolean handleMessage(Message paramMessage);
  
  public abstract void onCreate(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView, Bundle paramBundle);
  
  public abstract boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStop();
  
  public abstract void onWindowFocusGained();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.IProfileCmShowComponentDelegate
 * JD-Core Version:    0.7.0.1
 */