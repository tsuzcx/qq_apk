package com.tencent.biz.pubaccount.api.impl;

import org.json.JSONObject;

class PublicAccountJavascriptInterfaceImpl$16
  implements Runnable
{
  PublicAccountJavascriptInterfaceImpl$16(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterfaceImpl.access$000();
    try
    {
      PublicAccountJavascriptInterfaceImpl.access$102(l);
      if (PublicAccountJavascriptInterfaceImpl.access$100() > 52428800L)
      {
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{ret:-12, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        return;
      }
    }
    finally {}
    this.this$0.writeData(this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.16
 * JD-Core Version:    0.7.0.1
 */