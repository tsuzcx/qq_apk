package com.tencent.mobileqq.apollo.profilecard.api;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ICmShowProfileComponent
  extends QRouteApi
{
  public abstract boolean handleMessage(Message paramMessage);
  
  public abstract void onCreate(Activity paramActivity, View paramView, Bundle paramBundle, ProfileCardInfo paramProfileCardInfo, IProfileConfig paramIProfileConfig);
  
  public abstract boolean onDataUpdate(Object paramObject);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStop();
  
  public abstract void onWindowFocusGained();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.api.ICmShowProfileComponent
 * JD-Core Version:    0.7.0.1
 */