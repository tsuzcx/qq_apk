package com.tencent.biz.pubaccount.readinjoy;

import olh;
import org.json.JSONException;
import org.json.JSONObject;
import orn;
import pnn;

public class ReadInJoyDropFrameHelper$2
  implements Runnable
{
  public ReadInJoyDropFrameHelper$2(orn paramorn, String paramString, double paramDouble) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = orn.a(this.this$0);
      localJSONObject.put("channelId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("fluency", this.jdField_a_of_type_Double);
      olh.a(pnn.a(), "", "0X8009EFE", "0X8009EFE", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2
 * JD-Core Version:    0.7.0.1
 */