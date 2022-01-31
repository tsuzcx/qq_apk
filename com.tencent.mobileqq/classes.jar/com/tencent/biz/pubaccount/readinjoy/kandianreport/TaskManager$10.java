package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$10
  implements JSContext.Callback
{
  TaskManager$10(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    paramJSContext = (Double)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    if (paramJSContext.doubleValue() == 0.0D) {}
    for (paramInt = 1;; paramInt = 2)
    {
      this.this$0.qlog(paramInt, paramArrayOfObject);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.10
 * JD-Core Version:    0.7.0.1
 */