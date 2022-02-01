package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.dict.DictConfig;

public class ArkAIDictConfBean
  extends ArkConfBean
{
  private final DictConfig a;
  
  public ArkAIDictConfBean()
  {
    this("", new DictConfig());
  }
  
  public ArkAIDictConfBean(String paramString, DictConfig paramDictConfig)
  {
    super(paramString);
    this.a = paramDictConfig;
  }
  
  public int a()
  {
    return 170;
  }
  
  public DictConfig a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkAIDictConfBean
 * JD-Core Version:    0.7.0.1
 */