package com.tencent.ark.open.appmanage;

class AppUpdateManager$3
  implements AppUpdateTask.IUpdateAppByNameCallback
{
  AppUpdateManager$3(AppUpdateManager paramAppUpdateManager, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback) {}
  
  public void onUpdateAppByName(AppUpdateTask.UpdateTask paramUpdateTask)
  {
    AppUpdateManager.access$100(this.this$0, paramUpdateTask);
    AppUpdateTask.IUpdateAppByNameCallback localIUpdateAppByNameCallback = this.val$callback;
    if (localIUpdateAppByNameCallback != null) {
      localIUpdateAppByNameCallback.onUpdateAppByName(paramUpdateTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateManager.3
 * JD-Core Version:    0.7.0.1
 */