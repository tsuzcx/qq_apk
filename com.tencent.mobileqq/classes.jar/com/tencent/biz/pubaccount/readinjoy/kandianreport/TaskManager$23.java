package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import java.util.Map;
import java.util.Timer;

class TaskManager$23
  implements JSContext.Callback
{
  TaskManager$23(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    double d = ((Double)paramArrayOfObject[0]).doubleValue();
    paramJSContext = (Timer)paramJSContext.timerTasks.get(Integer.valueOf((int)d));
    if (paramJSContext != null) {
      paramJSContext.cancel();
    }
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.23
 * JD-Core Version:    0.7.0.1
 */