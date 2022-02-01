package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApolloSSOConfig$CGIConfig
{
  public String a;
  public String b;
  public final HashMap<String, String> c = new HashMap();
  public final List<ApolloSSOConfig.CmdParameter> d = new ArrayList();
  
  public String a(boolean paramBoolean)
  {
    if (!a()) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    try
    {
      int j = this.d.size();
      int i = 0;
      while (i < j)
      {
        ApolloSSOConfig.CmdParameter localCmdParameter = (ApolloSSOConfig.CmdParameter)this.d.get(i);
        if ((localCmdParameter != null) && (!TextUtils.isEmpty(localCmdParameter.a)))
        {
          int k = localCmdParameter.c;
          if ((k != 6) && (localCmdParameter.c != 7))
          {
            if (localCmdParameter.c == 8)
            {
              if (paramBoolean)
              {
                localStringBuilder.append(URLUtil.c(localCmdParameter.a));
                localStringBuilder.append("=");
                localStringBuilder.append(System.currentTimeMillis());
              }
              else
              {
                localStringBuilder.append(localCmdParameter.a);
                localStringBuilder.append("=");
                localStringBuilder.append(System.currentTimeMillis());
              }
              if (i != j - 1) {
                localStringBuilder.append("&");
              }
            }
            else
            {
              if (paramBoolean)
              {
                localStringBuilder.append(URLUtil.c(localCmdParameter.a));
                localStringBuilder.append("=");
                localStringBuilder.append(URLUtil.c(localCmdParameter.b));
              }
              else
              {
                localStringBuilder.append(localCmdParameter.a);
                localStringBuilder.append("=");
                localStringBuilder.append(localCmdParameter.b);
              }
              if (i != j - 1) {
                localStringBuilder.append("&");
              }
            }
          }
          else if (!TextUtils.isEmpty(Uri.parse(this.a).getQueryParameter(localCmdParameter.b)))
          {
            if (paramBoolean)
            {
              localStringBuilder.append(URLUtil.c(localCmdParameter.a));
              localStringBuilder.append("=");
              localStringBuilder.append(URLUtil.c(localCmdParameter.b));
            }
            else
            {
              localStringBuilder.append(localCmdParameter.a);
              localStringBuilder.append("=");
              localStringBuilder.append(localCmdParameter.b);
            }
            if (i != j - 1) {
              localStringBuilder.append("&");
            }
          }
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]apollo_client_ApolloSSOConfig", 1, localException, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, new Object[] { "getParameterStr parameterBuilder:", localStringBuilder.toString() });
      }
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CGIConfig{");
    localStringBuffer.append("mUrl='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mMethod='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mHeaders=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", mParameters=");
    localStringBuffer.append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CGIConfig
 * JD-Core Version:    0.7.0.1
 */