package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import aysc;
import aysy;
import aysz;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class TaskManager$23$1
  implements aysc
{
  TaskManager$23$1(TaskManager.23 param23, String paramString, JSContext paramJSContext) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_ArrayOfByte != null) {}
    for (String str1 = new String(paramaysz.jdField_a_of_type_ArrayOfByte);; str1 = "")
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramaysz.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject1 = new JSONObject();
        Iterator localIterator = paramaysz.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str2 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          try
          {
            ((JSONObject)localObject1).put(str2, localObject2);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("kandianreport.taskmanager", 2, localJSONException.getMessage());
          }
        }
      }
      for (Object localObject1 = ((JSONObject)localObject1).toString();; localObject1 = "")
      {
        str1 = TaskManager.compress(str1);
        localObject1 = TaskManager.compress((String)localObject1);
        paramaysz = this.val$callbackMethod + "(" + paramaysz.c + ",'" + (String)localObject1 + "','" + str1 + "')";
        if (this.val$jsContext != null)
        {
          this.val$jsContext.evaluteStringWithException(paramaysz, localStringBuffer);
          if (!TextUtils.isEmpty(localStringBuffer))
          {
            this.this$1.this$0.markTaskFail(this.this$1.val$task);
            QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + paramaysz + " " + localStringBuffer);
            TaskException.reportException(this.this$1.val$task.id, "evaluate js exception: " + paramaysz + " " + localStringBuffer);
          }
        }
        return;
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.23.1
 * JD-Core Version:    0.7.0.1
 */