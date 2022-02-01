package com.tencent.comic.data;

import java.io.Serializable;
import java.util.HashMap;

public class IPExpressionConfig
  implements Serializable
{
  public HashMap<String, String> mExpressionMap = new HashMap();
  public String mPrefixUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPExpressionConfig{mPrefixUrl='");
    localStringBuilder.append(this.mPrefixUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExpressionMap=");
    localStringBuilder.append(this.mExpressionMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.data.IPExpressionConfig
 * JD-Core Version:    0.7.0.1
 */