package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig;

public class ArkMsgAIDisableConfBean
  extends ArkConfBean
{
  private final ArkMsgAIDisableConfig a;
  
  public ArkMsgAIDisableConfBean()
  {
    this("", new ArkMsgAIDisableConfig());
  }
  
  public ArkMsgAIDisableConfBean(String paramString, ArkMsgAIDisableConfig paramArkMsgAIDisableConfig)
  {
    super(paramString);
    this.a = paramArkMsgAIDisableConfig;
  }
  
  public int a()
  {
    return 159;
  }
  
  public ArkMsgAIDisableConfig a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkMsgAIDisableConfBean
 * JD-Core Version:    0.7.0.1
 */