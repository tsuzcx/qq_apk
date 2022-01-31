package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$17
  implements JSContext.Callback
{
  TaskManager$17(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    Object localObject = (String)paramArrayOfObject[0];
    paramJSContext = (String)paramArrayOfObject[1];
    paramArrayOfObject = (String)paramArrayOfObject[2];
    localObject = ReadInJoyMMapKvStorage.getInstance(TaskManager.access$900(this.this$0, (String)localObject));
    if ((((ReadInJoyMMapKvStorage)localObject).getExpiredTime() != 0) && (((ReadInJoyMMapKvStorage)localObject).getExpiredTime() < System.currentTimeMillis() / 1000L))
    {
      ((ReadInJoyMMapKvStorage)localObject).invalidate();
      return Integer.valueOf(0);
    }
    ((ReadInJoyMMapKvStorage)localObject).update(paramArrayOfObject, paramJSContext);
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.17
 * JD-Core Version:    0.7.0.1
 */