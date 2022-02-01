package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.AiKeywordConfig;
import com.tencent.mobileqq.ark.config.config.DialogConfig;

public class ArkAIKeyWordConfBean
  extends ArkConfBean
{
  private final AiKeywordConfig b;
  private final DialogConfig c;
  
  public ArkAIKeyWordConfBean()
  {
    this("", new AiKeywordConfig(), new DialogConfig());
  }
  
  public ArkAIKeyWordConfBean(String paramString, AiKeywordConfig paramAiKeywordConfig, DialogConfig paramDialogConfig)
  {
    super(paramString);
    this.b = paramAiKeywordConfig;
    this.c = paramDialogConfig;
  }
  
  public int a()
  {
    return 186;
  }
  
  public AiKeywordConfig b()
  {
    return this.b;
  }
  
  public DialogConfig c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean
 * JD-Core Version:    0.7.0.1
 */