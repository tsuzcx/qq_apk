package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$8
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppMgr$8(ArkAppMgr paramArkAppMgr, String[] paramArrayOfString, ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, ArkAppCGIMgr.QueryAppInfoResult paramQueryAppInfoResult, ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    paramObject = ArkAppMgr.access$100();
    String str1 = this.val$templateAndView[0];
    String str2 = this.val$templateAndView[1];
    if (paramAppPathInfo != null) {}
    for (paramString = paramAppPathInfo.path;; paramString = "")
    {
      paramObject.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.find template app after get appPath, template=%s, templateView=%s, ret=%d, path=%s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramString }));
      if ((paramAppPathInfo != null) && (paramInt == 0))
      {
        this.val$task.downloadInfo = this.val$appResult.info;
        this.val$task.appPathInfo = new ArkAppMgr.AppPathInfo();
        this.val$task.appPathInfo.desc = paramAppPathInfo.desc;
        this.val$task.appPathInfo.appTempInfo = new ArkAppInfo.AppTemplateView();
        this.val$task.appPathInfo.path = paramAppPathInfo.path;
        this.val$task.appPathInfo.from = paramAppPathInfo.from;
        this.val$task.appPathInfo.appTempInfo.view = this.val$item.appView;
        this.val$task.appPathInfo.appTempInfo.template = this.val$templateAndView[0];
        this.val$task.appPathInfo.appTempInfo.templateView = this.val$templateAndView[1];
        ArkAppMgr.access$1300(this.this$0, 1, 0, null, this.val$task);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.8
 * JD-Core Version:    0.7.0.1
 */