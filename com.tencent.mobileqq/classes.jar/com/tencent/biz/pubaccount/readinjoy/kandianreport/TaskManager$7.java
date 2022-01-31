package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import bbdj;
import bhvh;
import com.tencent.qphone.base.util.QLog;

class TaskManager$7
  implements Runnable
{
  TaskManager$7(TaskManager paramTaskManager) {}
  
  public void run()
  {
    QLog.d("kandianreport.taskmanager", 1, "reset");
    this.this$0.stopAllTasks();
    bbdj.a(TaskManager.access$700());
    bbdj.a(KandianReportSoLoader.getSoLoadDir());
    bhvh.a("kandianreport_ON", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.7
 * JD-Core Version:    0.7.0.1
 */