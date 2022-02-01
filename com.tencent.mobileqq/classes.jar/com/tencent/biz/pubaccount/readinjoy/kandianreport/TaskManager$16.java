package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class TaskManager$16
  implements JSContext.Callback
{
  TaskManager$16(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    paramJSContext = (String)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("version", TaskManager.scriptVersion + "");
    localJSONObject.put("info", paramArrayOfObject);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramJSContext, paramJSContext, 0, 0, "", "", "", localJSONObject.toString(), false);
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.16
 * JD-Core Version:    0.7.0.1
 */