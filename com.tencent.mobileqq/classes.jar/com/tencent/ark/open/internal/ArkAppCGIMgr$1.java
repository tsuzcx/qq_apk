package com.tencent.ark.open.internal;

class ArkAppCGIMgr$1
  implements ArkAppCGIMgr.IQueryAppInfoRequestCallback
{
  ArkAppCGIMgr$1(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback) {}
  
  public void onResult(String paramString)
  {
    paramString = ArkAppCGIMgr.access$100(this.this$0, paramString);
    ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback = this.val$callback;
    if (localArkAppCGICallback != null) {
      localArkAppCGICallback.onQueryAppInfoByAppName(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.1
 * JD-Core Version:    0.7.0.1
 */