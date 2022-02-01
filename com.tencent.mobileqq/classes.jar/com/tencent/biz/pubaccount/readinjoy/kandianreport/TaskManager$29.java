package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$29
  implements JSContext.Callback
{
  TaskManager$29(TaskManager paramTaskManager, Task paramTask) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    Task.ConfigItem[] arrayOfConfigItem = this.this$0.getNextScript(paramJSContext, (String)paramArrayOfObject[0]);
    TaskManager.access$1200(this.this$0, paramJSContext, paramArrayOfObject, arrayOfConfigItem, this.val$task);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.29
 * JD-Core Version:    0.7.0.1
 */