package com.tencent.mobileqq.ark.vipreport;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkVipReportScene
{
  public long a;
  public String a;
  public ArrayList<ArkVipReportItem> a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
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
          localJSONObject.put("uin", localObject);
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            break label285;
          }
          localObject = this.jdField_b_of_type_JavaLangString;
          localJSONObject.put("phone", localObject);
          if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            break label291;
          }
          localObject = this.jdField_c_of_type_JavaLangString;
          localJSONObject.put("os", localObject);
          if (TextUtils.isEmpty(this.d)) {
            break label297;
          }
          localObject = this.d;
          localJSONObject.put("qqver", localObject);
          if (TextUtils.isEmpty(this.e)) {
            break label303;
          }
          localObject = this.e;
          localJSONObject.put("scene", localObject);
          if (TextUtils.isEmpty(this.f)) {
            break label309;
          }
          localObject = this.f;
          localJSONObject.put("startEvt", localObject);
          if (TextUtils.isEmpty(this.g)) {
            break label315;
          }
          localObject = this.g;
          localJSONObject.put("endEvt", localObject);
          localJSONObject.put("startTime", this.jdField_a_of_type_Long);
          localJSONObject.put("endTime", this.jdField_b_of_type_Long);
          localJSONObject.put("costTime", this.jdField_c_of_type_Long);
          localObject = new JSONArray();
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            int i = 0;
            if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              ((JSONArray)localObject).put(i, ((ArkVipReportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
              i += 1;
              continue;
            }
          }
          localJSONObject.put("evtlist", localObject);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ArkVipReportScene", 1, "getJsonObject()", localJSONException);
        return localJSONObject;
      }
      String str = "";
      continue;
      label285:
      str = "";
      continue;
      label291:
      str = "";
      continue;
      label297:
      str = "";
      continue;
      label303:
      str = "";
      continue;
      label309:
      str = "";
      continue;
      label315:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReportScene
 * JD-Core Version:    0.7.0.1
 */