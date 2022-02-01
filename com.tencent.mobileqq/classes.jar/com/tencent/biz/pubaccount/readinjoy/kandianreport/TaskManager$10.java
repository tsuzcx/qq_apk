package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import bfuc;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$10
  implements JSContext.Callback
{
  TaskManager$10(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    return new String(bfuc.encode(((String)paramArrayOfObject[0]).getBytes(), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.10
 * JD-Core Version:    0.7.0.1
 */