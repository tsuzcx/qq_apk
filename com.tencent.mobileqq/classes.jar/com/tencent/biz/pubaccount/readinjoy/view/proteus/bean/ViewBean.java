package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ViewBean
{
  public ValueBean a;
  public String a;
  public ViewBean[] a;
  public String b;
  
  public ViewBean()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean = new ValueBean();
  }
  
  private static Map a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if (localObject != null) {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  public ViewBean a()
  {
    ViewBean localViewBean = new ViewBean();
    localViewBean.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localViewBean.b = this.b;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean != null) {
      localViewBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.a();
    }
    if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean != null)
    {
      localViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean = new ViewBean[this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean.length];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean.length)
      {
        localViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean[i] = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean[i].a();
        i += 1;
      }
    }
    return localViewBean;
  }
  
  public ViewBean a(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return this;
    }
    return b(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.a.put(paramString, paramObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.b("visibility", "VISIBLE");
      localObject = a((JSONObject)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.b((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.b("visibility", "GONE");
    }
    if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean != null)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].a(paramJSONObject);
        i += 1;
      }
    }
  }
  
  public ViewBean b(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean != null)
    {
      ViewBean[] arrayOfViewBean = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
      int j = arrayOfViewBean.length;
      int i = 0;
      while (i < j)
      {
        ViewBean localViewBean = arrayOfViewBean[i];
        if (localViewBean != null)
        {
          localViewBean = localViewBean.a(paramString);
          if (localViewBean != null) {
            return localViewBean;
          }
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean
 * JD-Core Version:    0.7.0.1
 */