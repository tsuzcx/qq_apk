package com.tencent.mobileqq.app.identity.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.identity.AccountLifeCycleClient;
import com.tencent.mobileqq.app.identity.IAccountApi;

public class AccountApiImpl
  implements IAccountApi
{
  public boolean isIdentityFirstInit()
  {
    return AccountLifeCycleClient.a().a();
  }
  
  public void onAccountLoginOrSwitch()
  {
    AccountLifeCycleClient.a().a();
  }
  
  public void onActivityDestroy(Activity paramActivity)
  {
    AccountLifeCycleClient.a().a(paramActivity);
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    AccountLifeCycleClient.a().b(paramActivity);
  }
  
  public void onBackgroundSwitch()
  {
    AccountLifeCycleClient.a().af_();
  }
  
  public void onConversationResume()
  {
    AccountLifeCycleClient.a().d();
  }
  
  public void onForegroundSwitch()
  {
    AccountLifeCycleClient.a().b();
  }
  
  public void release()
  {
    AccountLifeCycleClient.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.impl.AccountApiImpl
 * JD-Core Version:    0.7.0.1
 */