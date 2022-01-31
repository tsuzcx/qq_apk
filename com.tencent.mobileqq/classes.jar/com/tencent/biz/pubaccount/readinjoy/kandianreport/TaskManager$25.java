package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$25
  implements JSContext.Callback
{
  TaskManager$25(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    double d = ((Double)paramArrayOfObject[0]).doubleValue();
    paramJSContext = (String)paramArrayOfObject[1];
    paramArrayOfObject = paramArrayOfObject[2];
    AladdinConfig localAladdinConfig = Aladdin.getConfig((int)d);
    if ((paramArrayOfObject instanceof Double)) {
      return Float.valueOf(localAladdinConfig.getFloatFromString(paramJSContext, (float)((Double)paramArrayOfObject).doubleValue()));
    }
    if ((paramArrayOfObject instanceof String)) {
      return localAladdinConfig.getString(paramJSContext, (String)paramArrayOfObject);
    }
    if ((paramArrayOfObject instanceof Boolean)) {
      return Boolean.valueOf(localAladdinConfig.getBooleanFromString(paramJSContext, ((Boolean)paramArrayOfObject).booleanValue()));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.25
 * JD-Core Version:    0.7.0.1
 */