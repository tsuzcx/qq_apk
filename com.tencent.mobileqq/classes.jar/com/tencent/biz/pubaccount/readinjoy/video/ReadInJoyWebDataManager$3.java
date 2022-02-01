package com.tencent.biz.pubaccount.readinjoy.video;

import java.net.URL;
import org.json.JSONObject;

class ReadInJoyWebDataManager$3
  implements Runnable
{
  ReadInJoyWebDataManager$3(ReadInJoyWebDataManager paramReadInJoyWebDataManager, URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = ReadInJoyWebDataManager.a();
    try
    {
      ReadInJoyWebDataManager.a(l);
      if (ReadInJoyWebDataManager.b() > 52428800L) {
        return;
      }
    }
    finally {}
    this.this$0.a(this.jdField_a_of_type_JavaNetURL.toString(), this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.3
 * JD-Core Version:    0.7.0.1
 */