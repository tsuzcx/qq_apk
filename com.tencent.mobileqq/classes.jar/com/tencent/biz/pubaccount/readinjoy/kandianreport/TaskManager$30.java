package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.qphone.base.util.QLog;

class TaskManager$30
  implements TaskOfflineUtils.OfflineCallBack
{
  TaskManager$30(TaskManager paramTaskManager, boolean paramBoolean) {}
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      TaskManager.scriptVersion = paramInt2;
      QLog.d("kandianreport.taskmanager", 1, "download scripts success: a new version: " + TaskManager.scriptVersion);
      if (this.val$startAfterDownload)
      {
        QLog.d("kandianreport.taskmanager", 1, "startAfterDownload");
        TaskManager.getInstance().restartAllTasks();
      }
      return;
    }
    QLog.d("kandianreport.taskmanager", 1, "download scripts fail or not update" + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.30
 * JD-Core Version:    0.7.0.1
 */