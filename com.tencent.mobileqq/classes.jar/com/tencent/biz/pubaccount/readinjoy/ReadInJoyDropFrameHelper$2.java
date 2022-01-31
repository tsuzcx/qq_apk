package com.tencent.biz.pubaccount.readinjoy;

import nol;
import ntv;
import onh;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDropFrameHelper$2
  implements Runnable
{
  public ReadInJoyDropFrameHelper$2(ntv paramntv, String paramString, double paramDouble) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ntv.a(this.this$0);
      localJSONObject.put("channelId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("fluency", this.jdField_a_of_type_Double);
      nol.a(onh.a(), "", "0X8009EFE", "0X8009EFE", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2
 * JD-Core Version:    0.7.0.1
 */