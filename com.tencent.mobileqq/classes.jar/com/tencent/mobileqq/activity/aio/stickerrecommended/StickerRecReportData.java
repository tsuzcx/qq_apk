package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StickerRecReportData
  extends StickerRecReportDataBase
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.a);
      localJSONObject2.put("keyword", this.b);
      localJSONObject2.put("appid", this.e);
      localJSONObject2.put("expose_md5s", this.f);
      localJSONObject2.put("expose_urls", this.g);
      localJSONObject2.put("click_md5", this.h);
      localJSONObject2.put("click_url", this.i);
      localJSONObject2.put("aio_type", this.c);
      localJSONObject2.put("mobile_type", this.j);
      localJSONObject2.put("to_user_id", this.d);
      localJSONObject2.put("passthough", this.k);
      localJSONObject2.put("session_id", this.l);
      localJSONObject1.put("dcId", this.m);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convert error:");
        localStringBuilder.append(localException);
        QLog.e("StickerRecReportData", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReportData
 * JD-Core Version:    0.7.0.1
 */