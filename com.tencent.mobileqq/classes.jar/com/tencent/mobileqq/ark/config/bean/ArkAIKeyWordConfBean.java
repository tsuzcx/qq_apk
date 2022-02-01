package com.tencent.mobileqq.ark.config.bean;

import com.tencent.mobileqq.ark.config.config.AiKeywordConfig;
import com.tencent.mobileqq.ark.config.config.DialogConfig;

public class ArkAIKeyWordConfBean
  extends ArkConfBean
{
  private final AiKeywordConfig jdField_a_of_type_ComTencentMobileqqArkConfigConfigAiKeywordConfig;
  private final DialogConfig jdField_a_of_type_ComTencentMobileqqArkConfigConfigDialogConfig;
  
  public ArkAIKeyWordConfBean()
  {
    this("", new AiKeywordConfig(), new DialogConfig());
  }
  
  public ArkAIKeyWordConfBean(String paramString, AiKeywordConfig paramAiKeywordConfig, DialogConfig paramDialogConfig)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqArkConfigConfigAiKeywordConfig = paramAiKeywordConfig;
    this.jdField_a_of_type_ComTencentMobileqqArkConfigConfigDialogConfig = paramDialogConfig;
  }
  
  public int a()
  {
    return 186;
  }
  
  public AiKeywordConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkConfigConfigAiKeywordConfig;
  }
  
  public DialogConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkConfigConfigDialogConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean
 * JD-Core Version:    0.7.0.1
 */