package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import beum;
import beuo;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class TaskManager$23
  implements JSContext.Callback
{
  TaskManager$23(TaskManager paramTaskManager, Task paramTask) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    Object localObject = (String)paramArrayOfObject[0];
    double d = ((Double)paramArrayOfObject[1]).doubleValue();
    String str2 = (String)paramArrayOfObject[2];
    String str1 = (String)paramArrayOfObject[3];
    String str3 = (String)paramArrayOfObject[4];
    paramArrayOfObject = new beum();
    paramArrayOfObject.jdField_a_of_type_Beuq = new TaskManager.23.1(this, str3, paramJSContext);
    paramArrayOfObject.jdField_a_of_type_JavaLangString = ((String)localObject);
    paramArrayOfObject.jdField_a_of_type_Int = ((int)d);
    if (!TextUtils.isEmpty(str2)) {
      try
      {
        paramJSContext = new JSONObject(str2);
        paramArrayOfObject.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        localObject = paramJSContext.keys();
        while (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          str3 = paramJSContext.optString(str2);
          paramArrayOfObject.jdField_a_of_type_JavaUtilHashMap.put(str2, str3);
        }
        if (TextUtils.isEmpty(str1)) {
          break label187;
        }
      }
      catch (JSONException paramJSContext)
      {
        QLog.e("kandianreport.taskmanager", 2, paramJSContext.getMessage());
      }
    } else {
      paramArrayOfObject.jdField_a_of_type_ArrayOfByte = str1.getBytes();
    }
    label187:
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getNetEngine(0).a(paramArrayOfObject);
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.23
 * JD-Core Version:    0.7.0.1
 */