package com.tencent.ark.open.internal;

class ArkAppCGIMgr$4
  implements ArkAppCGIMgr.ITaskHttpResult
{
  ArkAppCGIMgr$4(ArkAppCGIMgr paramArkAppCGIMgr) {}
  
  public void onTaskHttpResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArkAppCGIMgr.onDownloadAppPackage((ArkAppCGIMgr.QueryTask_DownloadAppPackage)paramQueryTask, paramBoolean, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.4
 * JD-Core Version:    0.7.0.1
 */