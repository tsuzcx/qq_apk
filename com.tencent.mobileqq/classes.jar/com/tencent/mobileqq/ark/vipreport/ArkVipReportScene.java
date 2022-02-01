package com.tencent.mobileqq.ark.vipreport;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkVipReportScene
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public long h;
  public long i;
  public long j;
  public ArrayList<ArkVipReportItem> k;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(this.a);
        String str2 = "";
        if (!bool)
        {
          Object localObject = this.a;
          localJSONObject.put("uin", localObject);
          if (TextUtils.isEmpty(this.b)) {
            break label326;
          }
          localObject = this.b;
          localJSONObject.put("phone", localObject);
          if (TextUtils.isEmpty(this.c)) {
            break label332;
          }
          localObject = this.c;
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
          localJSONObject.put("startTime", this.h);
          localJSONObject.put("endTime", this.i);
          localJSONObject.put("costTime", this.j);
          localObject = new JSONArray();
          if (this.k != null)
          {
            int m = 0;
            if (m < this.k.size())
            {
              ((JSONArray)localObject).put(m, ((ArkVipReportItem)this.k.get(m)).a());
              m += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReportScene
 * JD-Core Version:    0.7.0.1
 */