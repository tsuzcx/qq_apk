package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.avatar.api.IQQClassicAvatarService;
import mqq.app.AppRuntime;

public class QQClassicAvatarServiceImpl
  implements IQQClassicAvatarService
{
  protected AppRuntime mApp;
  
  public void handleGetHeadError(String paramString)
  {
    ((ClassicHeadActivityManager)this.mApp.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER)).a(paramString);
  }
  
  public boolean isClassicHeadActivityActivate()
  {
    return ((ClassicHeadActivityManager)this.mApp.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER)).a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQClassicAvatarServiceImpl
 * JD-Core Version:    0.7.0.1
 */