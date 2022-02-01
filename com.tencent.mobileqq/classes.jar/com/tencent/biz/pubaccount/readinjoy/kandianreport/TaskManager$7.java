package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class TaskManager$7
  implements Runnable
{
  TaskManager$7(TaskManager paramTaskManager) {}
  
  public void run()
  {
    QLog.d("kandianreport.taskmanager", 1, "reset");
    this.this$0.stopAllTasks();
    FileUtils.a(TaskManager.access$700());
    FileUtils.a(KandianReportSoLoader.getSoLoadDir());
    ReadInJoyHelper.a("kandianreport_ON", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.7
 * JD-Core Version:    0.7.0.1
 */