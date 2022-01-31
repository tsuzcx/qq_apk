package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TemplateFactory
{
  private static TemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory;
  private String jdField_a_of_type_JavaLangString = "0";
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public static TemplateFactory a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory = new TemplateFactory();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory;
    }
    finally {}
  }
  
  public static void a(TemplateFactory paramTemplateFactory)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryTemplateFactory = paramTemplateFactory;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public TemplateBean a(String paramString)
  {
    paramString = (TemplateBean)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public void a(int paramInt, String paramString, ViewBean paramViewBean)
  {
    TemplateBean localTemplateBean = new TemplateBean(paramInt);
    localTemplateBean.a(paramViewBean);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localTemplateBean);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public TemplateFactory b()
  {
    TemplateFactory localTemplateFactory = new TemplateFactory();
    localTemplateFactory.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(a());
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    localTemplateFactory.jdField_a_of_type_JavaUtilMap = localHashMap;
    return localTemplateFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory
 * JD-Core Version:    0.7.0.1
 */