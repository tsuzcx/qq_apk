package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;

public class ArkPlatformConfigBean
  extends ArkConfBean
{
  private final ArkPlatformConfig a;
  
  public ArkPlatformConfigBean()
  {
    this("", new ArkPlatformConfig());
  }
  
  public ArkPlatformConfigBean(String paramString, ArkPlatformConfig paramArkPlatformConfig)
  {
    super(paramString);
    this.a = paramArkPlatformConfig;
  }
  
  public int a()
  {
    return 380;
  }
  
  public ArkPlatformConfig a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean
 * JD-Core Version:    0.7.0.1
 */