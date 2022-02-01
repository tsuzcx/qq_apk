package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountJavascriptInterfaceImpl$18
  implements Runnable
{
  PublicAccountJavascriptInterfaceImpl$18(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, AppInterface paramAppInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    boolean bool = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin(this.a, this.b);
    try
    {
      this.c.put("follow", bool);
      localPublicAccountJavascriptInterfaceImpl = this.this$0;
      str = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{ret:0, response:");
      localStringBuilder.append(this.c.toString());
      localStringBuilder.append("}");
      localPublicAccountJavascriptInterfaceImpl.callJs(str, new String[] { localStringBuilder.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      PublicAccountJavascriptInterfaceImpl localPublicAccountJavascriptInterfaceImpl;
      String str;
      StringBuilder localStringBuilder;
      label99:
      break label99;
    }
    localPublicAccountJavascriptInterfaceImpl = this.this$0;
    str = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ret:-2, response:");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("}");
    localPublicAccountJavascriptInterfaceImpl.callJs(str, new String[] { localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.18
 * JD-Core Version:    0.7.0.1
 */