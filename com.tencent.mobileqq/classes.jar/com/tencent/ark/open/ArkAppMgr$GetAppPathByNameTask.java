package com.tencent.ark.open;

import com.tencent.ark.open.internal.WeakReferenceHandler;

class ArkAppMgr$GetAppPathByNameTask
{
  public String appName;
  public ArkAppMgr.AppPathInfo appPathInfo;
  ArkAppMgr.IGetAppPathByNameCallback callback;
  public String errMsg;
  WeakReferenceHandler handler;
  public String minAppVersion;
  public int retCode = -1;
  
  ArkAppMgr$GetAppPathByNameTask(String paramString1, String paramString2)
  {
    this.appName = paramString1;
    this.minAppVersion = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.GetAppPathByNameTask
 * JD-Core Version:    0.7.0.1
 */