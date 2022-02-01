package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.ArrayList;

class ArkAppCGIMgr$3
  implements ArkAppCGIMgr.ITaskHttpResult
{
  ArkAppCGIMgr$3(ArkAppCGIMgr paramArkAppCGIMgr) {}
  
  public void onTaskHttpResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((!paramBoolean) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCGIMgr.access$100().logI("ArkApp.ArkAppCGIMgr", String.format("getPredownloadAppList: fail, url=%s", new Object[] { paramQueryTask.url }));
    }
    for (;;)
    {
      int i = 0;
      while (i < paramQueryTask.callback.size())
      {
        paramArrayOfByte = paramQueryTask.userdata.get(i);
        ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGIMgr.ArkAppCGICallback)paramQueryTask.callback.get(i);
        if (localArkAppCGICallback != null) {
          localArkAppCGICallback.onGetPredownloadAppList(paramBoolean, localArrayList1, localArrayList2, paramArrayOfByte);
        }
        i += 1;
      }
      ArkAppCGIMgr.access$400(this.this$0, paramArrayOfByte, localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.3
 * JD-Core Version:    0.7.0.1
 */