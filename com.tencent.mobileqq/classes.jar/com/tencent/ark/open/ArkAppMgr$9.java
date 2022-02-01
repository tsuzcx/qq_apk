package com.tencent.ark.open;

import com.tencent.ark.ArkDispatchTask;

class ArkAppMgr$9
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  ArkAppMgr$9(ArkAppMgr paramArkAppMgr) {}
  
  public void onDownloadAppPackage(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.9.1(this, paramBoolean, paramArrayOfByte, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.9
 * JD-Core Version:    0.7.0.1
 */