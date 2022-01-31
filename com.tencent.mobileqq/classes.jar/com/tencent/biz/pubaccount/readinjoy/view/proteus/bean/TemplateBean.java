package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import java.util.HashMap;

public class TemplateBean
{
  private final int jdField_a_of_type_Int;
  private ViewBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public TemplateBean(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public TemplateBean a()
  {
    TemplateBean localTemplateBean = new TemplateBean(this.jdField_a_of_type_Int);
    localTemplateBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean.a();
    return localTemplateBean;
  }
  
  public ViewBean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
  }
  
  public ViewBean a(String paramString)
  {
    ViewBean localViewBean2 = (ViewBean)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    ViewBean localViewBean1 = localViewBean2;
    if (localViewBean2 == null)
    {
      localViewBean1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localViewBean1);
    }
    return localViewBean1;
  }
  
  public void a(ViewBean paramViewBean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean = paramViewBean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != TemplateFactory.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */