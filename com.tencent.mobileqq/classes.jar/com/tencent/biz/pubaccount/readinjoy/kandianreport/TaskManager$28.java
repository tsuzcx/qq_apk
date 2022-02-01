package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import java.util.Map;
import java.util.Timer;

class TaskManager$28
  implements JSContext.Callback
{
  TaskManager$28(TaskManager paramTaskManager, Task paramTask) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    double d = ((Double)paramArrayOfObject[1]).doubleValue();
    paramArrayOfObject = new Timer();
    paramArrayOfObject.schedule(new TaskManager.28.1(this, paramJSContext, str), d);
    try
    {
      paramInt = paramJSContext.timerTasks.size();
      paramJSContext.timerTasks.put(Integer.valueOf(paramInt), paramArrayOfObject);
      return Integer.valueOf(paramInt);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.28
 * JD-Core Version:    0.7.0.1
 */