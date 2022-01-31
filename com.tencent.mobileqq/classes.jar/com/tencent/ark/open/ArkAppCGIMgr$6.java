package com.tencent.ark.open;

import java.util.ArrayList;

class ArkAppCGIMgr$6
  implements ArkAppCGIMgr.ITaskHttpResult
{
  ArkAppCGIMgr$6(ArkAppCGIMgr paramArkAppCGIMgr) {}
  
  public void onTaskHttpResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramQueryTask.callback.size())
    {
      ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGIMgr.ArkAppCGICallback)paramQueryTask.callback.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.onDownloadAppIcon(paramBoolean, paramArrayOfByte, paramQueryTask.userdata.get(0));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.6
 * JD-Core Version:    0.7.0.1
 */