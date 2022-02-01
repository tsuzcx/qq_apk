package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.qphone.base.util.QLog;

class TaskManager$24
  implements JSContext.Callback
{
  TaskManager$24(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    QLog.d("kandianreport.taskmanager", 1, "call reportToServer: " + str + " " + paramArrayOfObject[1]);
    TaskManager.access$1000(this.this$0, paramJSContext, (String)paramArrayOfObject[0], (String)paramArrayOfObject[1]);
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.24
 * JD-Core Version:    0.7.0.1
 */