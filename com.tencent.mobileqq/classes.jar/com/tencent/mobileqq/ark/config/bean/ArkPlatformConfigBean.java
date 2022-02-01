package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;

public class ArkPlatformConfigBean
  extends ArkConfBean
{
  private final ArkPlatformConfig b;
  
  public ArkPlatformConfigBean()
  {
    this("", new ArkPlatformConfig());
  }
  
  public ArkPlatformConfigBean(String paramString, ArkPlatformConfig paramArkPlatformConfig)
  {
    super(paramString);
    this.b = paramArkPlatformConfig;
  }
  
  public int a()
  {
    return 380;
  }
  
  public ArkPlatformConfig b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean
 * JD-Core Version:    0.7.0.1
 */