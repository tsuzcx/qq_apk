package com.tencent.ark.open;

import java.util.ArrayList;

class ArkAppMgr$10
  implements Runnable
{
  ArkAppMgr$10(ArkAppMgr paramArkAppMgr, ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$task.callback.size())
    {
      Object localObject = this.val$task.userdata.get(i);
      ArkAppMgr.IUpdateAppByNameCallback localIUpdateAppByNameCallback = (ArkAppMgr.IUpdateAppByNameCallback)this.val$task.callback.get(i);
      if (localIUpdateAppByNameCallback != null) {
        localIUpdateAppByNameCallback.onUpdateAppByName(this.val$task, localObject);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.10
 * JD-Core Version:    0.7.0.1
 */