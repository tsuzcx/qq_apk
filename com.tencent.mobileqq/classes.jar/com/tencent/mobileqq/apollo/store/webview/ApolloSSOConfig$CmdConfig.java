package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ApolloSSOConfig$CmdConfig
{
  public int a;
  public String a;
  public final List<ApolloSSOConfig.CmdParameter> a;
  
  public ApolloSSOConfig$CmdConfig()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public JSONObject a(String paramString, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramAppInterface != null))
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mCmdSSOName:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mParameters:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CmdConfig
 * JD-Core Version:    0.7.0.1
 */