package com.tencent.ark.open.appmanage;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.internal.ArkAppCGIMgr.ArkAppCGICallback;

class AppUpdateTask$3
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  AppUpdateTask$3(AppUpdateTask paramAppUpdateTask) {}
  
  public void onDownloadAppPackage(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ArkDispatchTask.getInstance().postToArkThread(new AppUpdateTask.3.1(this, paramBoolean, paramArrayOfByte, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.3
 * JD-Core Version:    0.7.0.1
 */