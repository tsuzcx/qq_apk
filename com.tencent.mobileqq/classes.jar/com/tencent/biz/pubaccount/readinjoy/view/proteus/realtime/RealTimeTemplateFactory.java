package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RealTimeTemplateFactory
  extends TemplateFactory
{
  private static RealTimeTemplateFactoryCache jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeTemplateFactoryCache = new RealTimeTemplateFactoryCache();
  private Map<String, RealTimeTemplateFactory.Item> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public RealTimeTemplateFactory()
  {
    this.nameTemplateMap = new ConcurrentHashMap();
  }
  
  public static RealTimeTemplateFactory a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeTemplateFactoryCache.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeTemplateFactoryCache.get(paramString);
  }
  
  public static void b()
  {
    QLog.d("RealTimeTemplateFactory", 2, "reset: ");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeTemplateFactoryCache.clear();
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeTemplateFactory.Item localItem = (RealTimeTemplateFactory.Item)localIterator.next();
      localHashMap.put(localItem.a, localItem.b);
    }
    return localHashMap;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    paramString2 = new RealTimeTemplateFactory.Item(paramString1, paramString2, paramString3);
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {}
    while ((paramTemplateBean.getId() != getTemplateId()) || (!a().equals(paramTemplateBean.getStyleSource()))) {
      return true;
    }
    return false;
  }
  
  public void d(String paramString)
  {
    paramString = (RealTimeTemplateFactory.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (paramString != null)
    {
      paramString = (TemplateBean)this.nameTemplateMap.remove(paramString.c);
      QLog.d("RealTimeTemplateFactory", 1, "deleteStyle: " + paramString);
    }
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.nameTemplateMap);
    return localArrayMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (TemplateBean)this.nameTemplateMap.get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.clone()) {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactory
 * JD-Core Version:    0.7.0.1
 */