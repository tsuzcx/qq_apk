package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloSSOConfig$CmdParameter
{
  public String a;
  public String b;
  public int c = 0;
  
  public void a(String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
  {
    if (paramJSONObject != null) {
      try
      {
        if (!TextUtils.isEmpty(this.a))
        {
          if (this.c == 0)
          {
            paramJSONObject.put(this.a, this.b);
            return;
          }
          if (this.c == 1)
          {
            paramJSONObject.put(this.a, Integer.parseInt(this.b));
            return;
          }
          if (this.c == 2)
          {
            paramJSONObject.put(this.a, Long.parseLong(this.b));
            return;
          }
          if (this.c == 3)
          {
            paramJSONObject.put(this.a, Float.parseFloat(this.b));
            return;
          }
          if (this.c == 4)
          {
            paramJSONObject.put(this.a, Long.parseLong(paramAppInterface.getCurrentAccountUin()));
            return;
          }
          if (this.c == 5)
          {
            paramJSONObject.put(this.a, paramAppInterface.getCurrentAccountUin());
            return;
          }
          if (this.c == 8)
          {
            paramJSONObject.put(this.a, System.currentTimeMillis());
            return;
          }
          if (this.c == 6)
          {
            if (!TextUtils.isEmpty(paramString))
            {
              paramString = Uri.parse(paramString).getQueryParameter(this.b);
              if (!TextUtils.isEmpty(paramString)) {
                paramJSONObject.put(this.a, Long.parseLong(paramString));
              }
            }
          }
          else if ((this.c == 7) && (!TextUtils.isEmpty(paramString)))
          {
            paramString = Uri.parse(paramString).getQueryParameter(this.b);
            if (!TextUtils.isEmpty(paramString))
            {
              paramJSONObject.put(this.a, paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]apollo_client_ApolloSSOConfig", 1, paramString, new Object[0]);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mKey:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mValue:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mType:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CmdParameter
 * JD-Core Version:    0.7.0.1
 */