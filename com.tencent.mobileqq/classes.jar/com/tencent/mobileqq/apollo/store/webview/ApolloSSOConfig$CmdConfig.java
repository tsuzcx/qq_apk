package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ApolloSSOConfig$CmdConfig
{
  public String a;
  public int b;
  public final List<ApolloSSOConfig.CmdParameter> c = new ArrayList();
  
  public JSONObject a(String paramString, AppInterface paramAppInterface)
  {
    if ((this.c != null) && (paramAppInterface != null))
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((ApolloSSOConfig.CmdParameter)localIterator.next()).a(paramString, localJSONObject, paramAppInterface);
      }
      return localJSONObject;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClientId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mCmdSSOName:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mParameters:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CmdConfig
 * JD-Core Version:    0.7.0.1
 */