package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.ArkAIKeyWordSDKShareConfig;

public class ArkAIKeyWordSDKShareConfBean
  extends ArkConfBean
{
  private final ArkAIKeyWordSDKShareConfig a;
  
  public ArkAIKeyWordSDKShareConfBean()
  {
    this("", new ArkAIKeyWordSDKShareConfig());
  }
  
  public ArkAIKeyWordSDKShareConfBean(String paramString, ArkAIKeyWordSDKShareConfig paramArkAIKeyWordSDKShareConfig)
  {
    super(paramString);
    this.a = paramArkAIKeyWordSDKShareConfig;
  }
  
  public int a()
  {
    return 250;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordSDKShareConfBean
 * JD-Core Version:    0.7.0.1
 */