package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;

public class StyleConfigHelper$TemplateFactoryWrapper
{
  public TemplateFactory a;
  public String a;
  public String b;
  
  public StyleConfigHelper$TemplateFactoryWrapper(String paramString, TemplateFactory paramTemplateFactory, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory = paramTemplateFactory;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    this.b = paramString;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return this.b;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper.TemplateFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */