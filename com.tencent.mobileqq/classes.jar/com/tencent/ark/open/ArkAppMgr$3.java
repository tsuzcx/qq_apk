package com.tencent.ark.open;

class ArkAppMgr$3
  implements ArkAppMgr.IUpdateAppByNameCallback
{
  ArkAppMgr$3(ArkAppMgr paramArkAppMgr) {}
  
  public void onUpdateAppByName(ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, Object paramObject)
  {
    paramObject = (ArkAppMgr.GetAppPathByNameTask)paramObject;
    paramObject.handler.post(new ArkAppMgr.3.1(this, paramUpdateAppByNameTask, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.3
 * JD-Core Version:    0.7.0.1
 */