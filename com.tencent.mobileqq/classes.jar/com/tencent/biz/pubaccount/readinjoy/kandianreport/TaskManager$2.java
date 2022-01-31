package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.qphone.base.util.QLog;

class TaskManager$2
  implements Runnable
{
  TaskManager$2(TaskManager paramTaskManager) {}
  
  public void run()
  {
    try
    {
      TaskManager.isConfigureOn = TaskManager.getConfigOn();
      if (TaskManager.isConfigureOn)
      {
        QLog.d("kandianreport.taskmanager", 1, "configure is on");
        KandianReportSoLoader.downLoadSoFiles();
        this.this$0.downloadScripts(false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.taskmanager", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.2
 * JD-Core Version:    0.7.0.1
 */