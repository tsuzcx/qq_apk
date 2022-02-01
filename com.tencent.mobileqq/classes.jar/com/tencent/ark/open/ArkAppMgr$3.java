package com.tencent.ark.open;

import com.tencent.ark.open.appmanage.AppUpdateTask.IUpdateAppByNameCallback;
import com.tencent.ark.open.appmanage.AppUpdateTask.UpdateTask;
import com.tencent.ark.open.internal.WeakReferenceHandler;

class ArkAppMgr$3
  implements AppUpdateTask.IUpdateAppByNameCallback
{
  ArkAppMgr$3(ArkAppMgr paramArkAppMgr, ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask) {}
  
  public void onUpdateAppByName(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    this.val$getPathTask.handler.post(new ArkAppMgr.3.1(this, paramUpdateTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.3
 * JD-Core Version:    0.7.0.1
 */