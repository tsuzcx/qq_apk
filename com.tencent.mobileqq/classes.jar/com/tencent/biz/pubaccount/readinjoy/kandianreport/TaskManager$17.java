package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$17
  implements JSContext.Callback
{
  TaskManager$17(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    paramJSContext = (String)paramArrayOfObject[0];
    ReadInJoyMMapKvStorage.getInstance(TaskManager.access$900(this.this$0, paramJSContext)).invalidate();
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.17
 * JD-Core Version:    0.7.0.1
 */