package com.tencent.mobileqq.app.identity.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.identity.AccountLifeCycleClient;
import com.tencent.mobileqq.app.identity.IAccountApi;

public class AccountApiImpl
  implements IAccountApi
{
  public boolean isIdentityFirstInit()
  {
    return AccountLifeCycleClient.a().g();
  }
  
  public void onAccountLoginOrSwitch()
  {
    AccountLifeCycleClient.a().b();
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
    AccountLifeCycleClient.a().bX_();
  }
  
  public void onConversationResume()
  {
    AccountLifeCycleClient.a().e();
  }
  
  public void onForegroundSwitch()
  {
    AccountLifeCycleClient.a().c();
  }
  
  public void release()
  {
    AccountLifeCycleClient.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.impl.AccountApiImpl
 * JD-Core Version:    0.7.0.1
 */