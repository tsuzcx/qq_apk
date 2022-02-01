package com.tencent.ark.open;

import com.tencent.ark.open.appmanage.AppUpdateTask.IUpdateAppByNameCallback;
import com.tencent.ark.open.appmanage.AppUpdateTask.UpdateApp;
import com.tencent.ark.open.appmanage.AppUpdateTask.UpdateTask;
import java.util.HashMap;

class ArkAppMgr$4
  implements AppUpdateTask.IUpdateAppByNameCallback
{
  ArkAppMgr$4(ArkAppMgr paramArkAppMgr) {}
  
  public void onUpdateAppByName(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    synchronized (ArkAppMgr.access$100(this.this$0))
    {
      if (paramUpdateTask.appPathInfo != null) {
        ArkAppMgr.access$100(this.this$0).put(paramUpdateTask.app.appName, paramUpdateTask.appPathInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.4
 * JD-Core Version:    0.7.0.1
 */