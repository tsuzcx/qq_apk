package com.tencent.biz.pubaccount;

import org.json.JSONObject;

class PublicAccountJavascriptInterface$16
  implements Runnable
{
  PublicAccountJavascriptInterface$16(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      if (PublicAccountJavascriptInterface.b() > 52428800L)
      {
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{ret:-12, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        return;
      }
    }
    finally {}
    this.this$0.a(this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.16
 * JD-Core Version:    0.7.0.1
 */