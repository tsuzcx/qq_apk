package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReportDataBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ScenesRecReportData
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
      localJSONObject2.put("uin", this.a);
      localJSONObject2.put("touin", this.b);
      localJSONObject2.put("appid", this.e);
      localJSONObject2.put("scene", this.c);
      localJSONObject2.put("expose_md5s", this.f);
      localJSONObject2.put("expose_urls", this.g);
      localJSONObject2.put("click_md5", this.h);
      localJSONObject2.put("click_url", this.i);
      localJSONObject2.put("aio_type", this.d);
      localJSONObject2.put("mobile_type", this.j);
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
        QLog.e("ScenesRecReportData", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecReportData
 * JD-Core Version:    0.7.0.1
 */