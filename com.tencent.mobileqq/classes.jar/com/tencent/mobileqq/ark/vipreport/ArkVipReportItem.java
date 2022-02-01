package com.tencent.mobileqq.ark.vipreport;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkVipReportItem
{
  public int a;
  public long a;
  public String a;
  public HashMap<String, String> a;
  public boolean a;
  public long b;
  public long c;
  public long d;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          Object localObject = this.jdField_a_of_type_JavaLangString;
          localJSONObject.put("evt", localObject);
          localJSONObject.put("index", this.jdField_a_of_type_Int);
          localJSONObject.put("result", this.jdField_a_of_type_Boolean);
          localJSONObject.put("startTime", this.jdField_a_of_type_Long);
          localJSONObject.put("endTime", this.b);
          localJSONObject.put("costTime", this.c);
          localJSONObject.put("net", this.d);
          localObject = new JSONObject();
          if (this.jdField_a_of_type_JavaUtilHashMap != null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
              continue;
            }
          }
          localJSONObject.put("param", localObject);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ArkVipReportItem", 1, "getJsonObject()", localJSONException);
        return localJSONObject;
      }
      String str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReportItem
 * JD-Core Version:    0.7.0.1
 */