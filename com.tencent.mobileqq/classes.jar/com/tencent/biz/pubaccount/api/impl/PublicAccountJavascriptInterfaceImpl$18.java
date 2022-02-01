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
    boolean bool = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("follow", bool);
      this.this$0.callJs(this.b, new String[] { "{ret:0, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.callJs(this.b, new String[] { "{ret:-2, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.18
 * JD-Core Version:    0.7.0.1
 */