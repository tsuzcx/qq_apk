package com.tencent.ark.open;

class ArkAppCGIMgr$2
  implements ArkAppCGIMgr.ITaskHttpResult
{
  ArkAppCGIMgr$2(ArkAppCGIMgr paramArkAppCGIMgr) {}
  
  public void onTaskHttpResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.this$0.onDownloadAppPackage((ArkAppCGIMgr.QueryTask_DownloadAppPackage)paramQueryTask, paramBoolean, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.2
 * JD-Core Version:    0.7.0.1
 */