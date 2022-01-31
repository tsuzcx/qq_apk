package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import bdbi;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$27
  implements JSContext.Callback
{
  TaskManager$27(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    return new String(bdbi.encode(((String)paramArrayOfObject[0]).getBytes(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.27
 * JD-Core Version:    0.7.0.1
 */