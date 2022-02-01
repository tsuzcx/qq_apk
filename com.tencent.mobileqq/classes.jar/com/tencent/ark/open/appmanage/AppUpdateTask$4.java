package com.tencent.ark.open.appmanage;

import java.util.ArrayList;

class AppUpdateTask$4
  implements Runnable
{
  AppUpdateTask$4(AppUpdateTask paramAppUpdateTask, AppUpdateTask.UpdateTask paramUpdateTask) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$task.callback.size())
    {
      AppUpdateTask.IUpdateAppByNameCallback localIUpdateAppByNameCallback = (AppUpdateTask.IUpdateAppByNameCallback)this.val$task.callback.get(i);
      if (localIUpdateAppByNameCallback != null) {
        localIUpdateAppByNameCallback.onUpdateAppByName(this.val$task);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.4
 * JD-Core Version:    0.7.0.1
 */