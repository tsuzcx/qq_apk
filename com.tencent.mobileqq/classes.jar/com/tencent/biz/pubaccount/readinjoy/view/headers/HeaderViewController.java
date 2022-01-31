package com.tencent.biz.pubaccount.readinjoy.view.headers;

import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HeaderViewController
{
  protected abstract void a();
  
  public abstract void a(ListView paramListView);
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("folder_status", ReadInJoyUtils.d);
      paramJSONObject.put("kandian_mode", ReadInJoyUtils.e());
      paramJSONObject = paramJSONObject.toString();
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", paramJSONObject, false);
      QLog.d("HeaderViewController", 2, "report: T - " + paramString + " r5 - " + paramJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("HeaderViewController", 2, "report failed due to JSONException: " + paramString.getMessage());
      throw new IllegalArgumentException("fail to construct r5 json");
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    a();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.HeaderViewController
 * JD-Core Version:    0.7.0.1
 */