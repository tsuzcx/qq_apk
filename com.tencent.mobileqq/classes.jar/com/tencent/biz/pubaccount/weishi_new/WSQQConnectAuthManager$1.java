package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.Doraemon.APICallback;
import org.json.JSONObject;

class WSQQConnectAuthManager$1
  implements APICallback
{
  WSQQConnectAuthManager$1(WSQQConnectAuthManager paramWSQQConnectAuthManager) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    WSLog.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + paramInt);
    WSQQConnectAuthManager.a(this.a, false);
    switch (paramInt)
    {
    default: 
      return;
    }
    WSQQConnectAuthManager.a(this.a);
  }
  
  public void a(int paramInt, String paramString)
  {
    WSLog.g("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + paramInt + " , " + paramString);
    WSQQConnectAuthManager.a(this.a, false);
    if (paramInt == 1) {
      WSQQConnectAuthManager.a(this.a);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    WSQQConnectAuthManager.a(this.a, false);
    if (paramJSONObject != null)
    {
      WSLog.f("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + paramJSONObject.toString());
      WSQQConnectAuthManager.a(this.a, paramJSONObject);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager.1
 * JD-Core Version:    0.7.0.1
 */