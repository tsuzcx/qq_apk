package com.tencent.mobileqq.apollo.store.webview;

import java.util.ArrayList;
import java.util.List;

class ApolloSSOConfig$ThunderConfig
{
  public int a;
  public String a;
  public List<ApolloSSOConfig.CmdConfig> a;
  public List<ApolloSSOConfig.CGIConfig> b = new ArrayList();
  
  public ApolloSSOConfig$ThunderConfig()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ThunderConfig{");
    localStringBuffer.append("mPageId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mMd5='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mCmdConfigs=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", mCGIConfigs=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.ThunderConfig
 * JD-Core Version:    0.7.0.1
 */