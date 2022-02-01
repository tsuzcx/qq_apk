package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$26
  implements JSContext.Callback
{
  TaskManager$26(TaskManager paramTaskManager, Task paramTask) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    if (this.val$task != null) {
      return this.val$task.id;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.26
 * JD-Core Version:    0.7.0.1
 */