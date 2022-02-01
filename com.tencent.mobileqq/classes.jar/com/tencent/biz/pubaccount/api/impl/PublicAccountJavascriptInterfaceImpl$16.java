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
        PublicAccountJavascriptInterfaceImpl localPublicAccountJavascriptInterfaceImpl = this.this$0;
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{ret:-12, response:");
        localStringBuilder.append(this.b.toString());
        localStringBuilder.append("}");
        localPublicAccountJavascriptInterfaceImpl.callJs(str, new String[] { localStringBuilder.toString() });
        return;
      }
      this.this$0.writeData(this.c, this.a, this.b);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.16
 * JD-Core Version:    0.7.0.1
 */