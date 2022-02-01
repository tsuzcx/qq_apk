package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.mobileqq.utils.Base64Util;

class TaskManager$11
  implements JSContext.Callback
{
  TaskManager$11(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    return new String(Base64Util.decode((String)paramArrayOfObject[0], 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.11
 * JD-Core Version:    0.7.0.1
 */