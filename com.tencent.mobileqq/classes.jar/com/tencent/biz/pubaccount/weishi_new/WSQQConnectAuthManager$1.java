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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOpenIdAndAccessToken onPermission: ");
    localStringBuilder.append(paramInt);
    WSLog.g("WSQQConnectAuthManager", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOpenIdAndAccessToken onFailure: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramString);
    WSLog.g("WSQQConnectAuthManager", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getOpenIdAndAccessToken onSuccess: ");
      localStringBuilder.append(paramJSONObject.toString());
      WSLog.f("WSQQConnectAuthManager", localStringBuilder.toString());
      WSQQConnectAuthManager.a(this.a, paramJSONObject);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager.1
 * JD-Core Version:    0.7.0.1
 */