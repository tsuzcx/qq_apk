package com.tencent.ark.open;

import java.util.ArrayList;

class ArkAppMgr$7$1
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  ArkAppMgr$7$1(ArkAppMgr.7 param7) {}
  
  public void onQueryAppInfoByAppNameBatch(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    ArkAppMgr.access$1200(this.this$1.this$0, paramQueryAppInfoByAppNameBatchResult, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.7.1
 * JD-Core Version:    0.7.0.1
 */