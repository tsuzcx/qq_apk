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
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
        String str2 = "";
        if (!bool)
        {
          Object localObject = this.jdField_a_of_type_JavaLangString;
          localJSONObject.put("uin", localObject);
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            break label326;
          }
          localObject = this.jdField_b_of_type_JavaLangString;
          localJSONObject.put("phone", localObject);
          if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          localObject = this.jdField_c_of_type_JavaLangString;
          localJSONObject.put("os", localObject);
          if (TextUtils.isEmpty(this.d)) {
            break label338;
          }
          localObject = this.d;
          localJSONObject.put("qqver", localObject);
          if (TextUtils.isEmpty(this.e)) {
            break label344;
          }
          localObject = this.e;
          localJSONObject.put("scene", localObject);
          if (TextUtils.isEmpty(this.f)) {
            break label350;
          }
          localObject = this.f;
          localJSONObject.put("startEvt", localObject);
          localObject = str2;
          if (!TextUtils.isEmpty(this.g)) {
            localObject = this.g;
          }
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
      String str1 = "";
      continue;
      label326:
      str1 = "";
      continue;
      label332:
      str1 = "";
      continue;
      label338:
      str1 = "";
      continue;
      label344:
      str1 = "";
      continue;
      label350:
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReportScene
 * JD-Core Version:    0.7.0.1
 */