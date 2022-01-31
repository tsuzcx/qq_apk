package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$18
  implements JSContext.Callback
{
  TaskManager$18(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    paramJSContext = (String)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    paramJSContext = ReadInJoyMMapKvStorage.getInstance(TaskManager.access$900(this.this$0, paramJSContext));
    if ((paramJSContext.getExpiredTime() != 0) && (paramJSContext.getExpiredTime() < System.currentTimeMillis() / 1000L))
    {
      paramJSContext.invalidate();
      return null;
    }
    return paramJSContext.getValeForKey(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.18
 * JD-Core Version:    0.7.0.1
 */