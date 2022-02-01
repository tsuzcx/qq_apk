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
  public final HashMap<String, String> a;
  public final List<ApolloSSOConfig.CmdParameter> a;
  public String b;
  
  public ApolloSSOConfig$CGIConfig()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a(boolean paramBoolean)
  {
    if (!a()) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    try
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ApolloSSOConfig.CmdParameter localCmdParameter = (ApolloSSOConfig.CmdParameter)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localCmdParameter != null) && (!TextUtils.isEmpty(localCmdParameter.jdField_a_of_type_JavaLangString)))
        {
          int k = localCmdParameter.jdField_a_of_type_Int;
          if ((k != 6) && (localCmdParameter.jdField_a_of_type_Int != 7))
          {
            if (localCmdParameter.jdField_a_of_type_Int == 8)
            {
              if (paramBoolean)
              {
                localStringBuilder.append(URLUtil.a(localCmdParameter.jdField_a_of_type_JavaLangString));
                localStringBuilder.append("=");
                localStringBuilder.append(System.currentTimeMillis());
              }
              else
              {
                localStringBuilder.append(localCmdParameter.jdField_a_of_type_JavaLangString);
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
                localStringBuilder.append(URLUtil.a(localCmdParameter.jdField_a_of_type_JavaLangString));
                localStringBuilder.append("=");
                localStringBuilder.append(URLUtil.a(localCmdParameter.b));
              }
              else
              {
                localStringBuilder.append(localCmdParameter.jdField_a_of_type_JavaLangString);
                localStringBuilder.append("=");
                localStringBuilder.append(localCmdParameter.b);
              }
              if (i != j - 1) {
                localStringBuilder.append("&");
              }
            }
          }
          else if (!TextUtils.isEmpty(Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter(localCmdParameter.b)))
          {
            if (paramBoolean)
            {
              localStringBuilder.append(URLUtil.a(localCmdParameter.jdField_a_of_type_JavaLangString));
              localStringBuilder.append("=");
              localStringBuilder.append(URLUtil.a(localCmdParameter.b));
            }
            else
            {
              localStringBuilder.append(localCmdParameter.jdField_a_of_type_JavaLangString);
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
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CGIConfig{");
    localStringBuffer.append("mUrl='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mMethod='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mHeaders=");
    localStringBuffer.append(this.jdField_a_of_type_JavaUtilHashMap);
    localStringBuffer.append(", mParameters=");
    localStringBuffer.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CGIConfig
 * JD-Core Version:    0.7.0.1
 */