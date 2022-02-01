package com.tencent.mobileqq.apollo.store.webview;

import java.util.ArrayList;
import java.util.List;

class ApolloSSOConfig$ThunderConfig
{
  public int a;
  public String b;
  public List<ApolloSSOConfig.CmdConfig> c = new ArrayList();
  public List<ApolloSSOConfig.CGIConfig> d = new ArrayList();
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ThunderConfig{");
    localStringBuffer.append("mPageId=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", mMd5='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mCmdConfigs=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", mCGIConfigs=");
    localStringBuffer.append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.ThunderConfig
 * JD-Core Version:    0.7.0.1
 */