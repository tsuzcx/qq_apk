package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IAccountApi
  extends QRouteApi
{
  public abstract boolean isIdentityFirstInit();
  
  public abstract void onAccountLoginOrSwitch();
  
  public abstract void onActivityDestroy(Activity paramActivity);
  
  public abstract void onActivityResume(Activity paramActivity);
  
  public abstract void onBackgroundSwitch();
  
  public abstract void onConversationResume();
  
  public abstract void onForegroundSwitch();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.IAccountApi
 * JD-Core Version:    0.7.0.1
 */