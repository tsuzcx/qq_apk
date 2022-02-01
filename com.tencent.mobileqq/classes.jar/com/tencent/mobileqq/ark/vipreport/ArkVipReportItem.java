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
  public String a;
  public int b;
  public boolean c;
  public long d;
  public long e;
  public long f;
  public long g;
  public HashMap<String, String> h;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.a))
        {
          Object localObject = this.a;
          localJSONObject.put("evt", localObject);
          localJSONObject.put("index", this.b);
          localJSONObject.put("result", this.c);
          localJSONObject.put("startTime", this.d);
          localJSONObject.put("endTime", this.e);
          localJSONObject.put("costTime", this.f);
          localJSONObject.put("net", this.g);
          localObject = new JSONObject();
          if (this.h != null)
          {
            Iterator localIterator = this.h.entrySet().iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReportItem
 * JD-Core Version:    0.7.0.1
 */