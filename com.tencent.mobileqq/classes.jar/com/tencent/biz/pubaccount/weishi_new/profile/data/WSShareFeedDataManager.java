package com.tencent.biz.pubaccount.weishi_new.profile.data;

import java.util.HashMap;

public class WSShareFeedDataManager
{
  private final HashMap<String, WSIShareDataFetcher> a = new HashMap();
  
  public static WSShareFeedDataManager a()
  {
    return WSShareFeedDataManager.Holder.a();
  }
  
  public WSIShareDataFetcher a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    String str = ((StringBuilder)localObject).toString();
    localObject = (WSIShareDataFetcher)this.a.get(str);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      paramString2 = WSShareDataFetchFactory.a(paramString1);
      this.a.put(str, paramString2);
    }
    return paramString2;
  }
  
  public void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localHashMap.remove(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSShareFeedDataManager
 * JD-Core Version:    0.7.0.1
 */