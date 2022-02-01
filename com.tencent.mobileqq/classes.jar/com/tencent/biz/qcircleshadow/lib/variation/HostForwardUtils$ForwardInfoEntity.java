package com.tencent.biz.qcircleshadow.lib.variation;

import java.io.Serializable;

public class HostForwardUtils$ForwardInfoEntity
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  private String mForwardName;
  private String mForwardUin;
  private int mForwardUinType;
  
  public String getForwardName()
  {
    return this.mForwardName;
  }
  
  public String getForwardUin()
  {
    return this.mForwardUin;
  }
  
  public int getForwardUinType()
  {
    return this.mForwardUinType;
  }
  
  public void setForwardName(String paramString)
  {
    this.mForwardName = paramString;
  }
  
  public void setForwardUin(String paramString)
  {
    this.mForwardUin = paramString;
  }
  
  public void setForwardUinType(int paramInt)
  {
    this.mForwardUinType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ForwardInfoEntity{mForwardUin='");
    localStringBuilder.append(this.mForwardUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mForwardUinType='");
    localStringBuilder.append(this.mForwardUinType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mForwardName='");
    localStringBuilder.append(this.mForwardName);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils.ForwardInfoEntity
 * JD-Core Version:    0.7.0.1
 */