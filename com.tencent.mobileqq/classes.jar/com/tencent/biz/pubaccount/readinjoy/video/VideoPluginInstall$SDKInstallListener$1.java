package com.tencent.biz.pubaccount.readinjoy.video;

import odq;
import org.json.JSONObject;
import rug;
import sdo;

public class VideoPluginInstall$SDKInstallListener$1
  implements Runnable
{
  public VideoPluginInstall$SDKInstallListener$1(sdo paramsdo, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.4.8");
      if (!this.jdField_a_of_type_Boolean) {
        localJSONObject.put("error_code", this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        String str1 = "";
        if (!this.jdField_a_of_type_Boolean) {
          break label124;
        }
        str3 = "1";
        odq.a(null, null, "0X8009753", "0X8009753", 0, 0, str3, rug.a(), str1, localJSONObject.toString(), false);
        if (!this.jdField_a_of_type_Boolean) {
          odq.a(null, null, "0X8009752", "0X8009752", 0, 0, str3, rug.a(), str1, localJSONObject.toString(), false);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        String str2 = String.valueOf(this.jdField_a_of_type_Int);
        continue;
        label124:
        String str3 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.SDKInstallListener.1
 * JD-Core Version:    0.7.0.1
 */