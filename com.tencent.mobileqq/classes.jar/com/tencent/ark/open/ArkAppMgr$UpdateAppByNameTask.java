package com.tencent.ark.open;

import java.util.ArrayList;

class ArkAppMgr$UpdateAppByNameTask
{
  public String appName;
  public ArkAppMgr.AppPathInfo appPathInfo;
  public String appView;
  public final ArrayList<ArkAppMgr.IUpdateAppByNameCallback> callback = new ArrayList();
  public ArkAppInfo.AppDownloadInfo downloadInfo;
  public String errMsg;
  public ArkAppMgr.AppPathInfo localAppPathInfo;
  public int result = 0;
  public int retCode = -1;
  public long startTime = System.currentTimeMillis();
  public final ArrayList<Object> userdata = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.UpdateAppByNameTask
 * JD-Core Version:    0.7.0.1
 */