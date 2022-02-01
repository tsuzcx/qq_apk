package com.tencent.ark.open.appmanage;

import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import java.util.ArrayList;

public class AppUpdateTask$UpdateTask
{
  public AppUpdateTask.UpdateApp app;
  public ArkAppMgr.AppPathInfo appPathInfo;
  final ArrayList<AppUpdateTask.IUpdateAppByNameCallback> callback = new ArrayList();
  ArkAppInfo.AppDownloadInfo downloadInfo;
  public String errMsg;
  ArkAppMgr.AppPathInfo localAppPathInfo;
  public int result = 0;
  public int retCode = -1;
  long startTime = System.currentTimeMillis();
  
  public String getAppVersion()
  {
    ArkAppMgr.AppPathInfo localAppPathInfo1 = this.localAppPathInfo;
    if ((localAppPathInfo1 != null) && (localAppPathInfo1.desc != null)) {
      return this.localAppPathInfo.desc.version;
    }
    return "0.0.0.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.UpdateTask
 * JD-Core Version:    0.7.0.1
 */