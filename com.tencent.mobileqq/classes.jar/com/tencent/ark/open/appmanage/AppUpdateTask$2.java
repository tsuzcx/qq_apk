package com.tencent.ark.open.appmanage;

import com.tencent.ark.open.internal.ArkAppCGIMgr.ArkAppCGICallback;
import com.tencent.ark.open.internal.ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult;
import java.util.ArrayList;

class AppUpdateTask$2
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  AppUpdateTask$2(AppUpdateTask paramAppUpdateTask, ArrayList paramArrayList) {}
  
  public void onQueryAppInfoByAppName(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult)
  {
    AppUpdateTask.access$300(this.this$0, paramQueryAppInfoByAppNameBatchResult, this.val$taskList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.2
 * JD-Core Version:    0.7.0.1
 */