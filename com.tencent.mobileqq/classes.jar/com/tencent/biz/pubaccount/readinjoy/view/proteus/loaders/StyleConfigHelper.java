package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StyleConfigHelper
{
  private static StyleConfigHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleConfigHelper = new StyleConfigHelper();
  private final Map<String, StyleConfigHelper.Config> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public StyleConfigHelper()
  {
    c();
  }
  
  public static StyleConfigHelper a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleConfigHelper;
  }
  
  public static String a(String paramString)
  {
    return (String)ReadInJoyHelper.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ReadInJoyHelper.a(b(paramString1), paramString2);
  }
  
  private static StyleConfigHelper.Config b(String paramString)
  {
    StyleConfigHelper.Config localConfig = new StyleConfigHelper.Config(paramString);
    localConfig.a("default_feeds");
    localConfig.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localConfig.c = paramString;
      }
    }
    else {
      return localConfig;
    }
    localConfig.b = paramString;
    return localConfig;
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  public static void b(String paramString)
  {
    StyleConfigHelper.Config localConfig = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localConfig.b, ", config.localPath = ", localConfig.c });
    new StyleLoaderHelper(localConfig.b, localConfig.c).a();
  }
  
  private void c()
  {
    StyleConfigHelper.Config localConfig = new StyleConfigHelper.Config("default_feeds");
    localConfig.b = ReadInJoyHelper.a("default_feeds_proteus_offline_bid");
    localConfig.c = ("proteus/" + localConfig.a + "");
    a(localConfig);
    localConfig = new StyleConfigHelper.Config("comment_feeds");
    localConfig.b = ReadInJoyHelper.a("comment_proteus_offline_bid");
    localConfig.c = ("proteus/" + localConfig.a);
    a(localConfig);
    localConfig = new StyleConfigHelper.Config("native_article");
    localConfig.a("default_feeds");
    localConfig.c = ("proteus/" + localConfig.a + "");
    localConfig.b = ReadInJoyHelper.a("native_proteus_offline_bid");
    a(localConfig);
    d();
    localConfig = new StyleConfigHelper.Config("daily_dynamic_header");
    localConfig.b = ReadInJoyHelper.a("daily_header_proteus_bid");
    localConfig.c = ("proteus/" + localConfig.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localConfig.b);
    a(localConfig);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  private void d() {}
  
  public StyleConfigHelper.Config a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (StyleConfigHelper.Config)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    StyleConfigHelper.Config localConfig = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localConfig);
    return localConfig;
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper a(Context paramContext, String paramString)
  {
    StyleConfigHelper.Config localConfig = a(paramString);
    StyleLoaderHelper localStyleLoaderHelper = new StyleLoaderHelper(localConfig.b, localConfig.c);
    StyleLoaderHelper.a(paramString);
    paramString = localStyleLoaderHelper.a(paramContext);
    if (paramString == null)
    {
      paramContext = localStyleLoaderHelper.b(paramContext);
      return new StyleConfigHelper.TemplateFactoryWrapper(localConfig.c, paramContext, true);
    }
    return new StyleConfigHelper.TemplateFactoryWrapper(localConfig.b, paramString, false);
  }
  
  public Map<String, StyleConfigHelper.Config> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      StyleConfigHelper.Config localConfig = (StyleConfigHelper.Config)((Map.Entry)localIterator.next()).getValue();
      new StyleLoaderHelper(localConfig.b, localConfig.c).a();
    }
  }
  
  public void a(StyleConfigHelper.Config paramConfig)
  {
    if (paramConfig.a == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramConfig.a, paramConfig);
  }
  
  public void a(String paramString)
  {
    paramString = (StyleConfigHelper.Config)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new StyleLoaderHelper(paramString.b, paramString.c).a();
    }
  }
  
  public void b()
  {
    if ((!RIJPushNotification.c()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)ReadInJoyHelper.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      TemplateFactory.c("default_feeds");
      ReadInJoyHelper.a("kandian_pts_style_update", Boolean.valueOf(false));
      ProteusPreloadManager.a.a();
      List localList = ProteusPreloadManager.a.a();
      ProteusPreloadManager.a.a(localList);
      QLog.d("StyleConfigHelper", 1, "preload pts card, rules : " + localList);
      ReadInJoyLogicEngineEventDispatcher.a().n();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((StyleConfigHelper.Config)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper
 * JD-Core Version:    0.7.0.1
 */