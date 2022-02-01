package com.tencent.biz.pubaccount.util;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/FluencyOptUtils;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "urlStrToObjMap", "", "", "Ljava/net/URL;", "addUrlObjToCache", "", "url", "addUrlStrToCache", "getUrlObjFromCache", "isEnableCardCreateCostReport", "", "isEnableGestureDataReport", "isEnablePreloadProteusView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FluencyOptUtils
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  public static final FluencyOptUtils a;
  private static final Map<String, URL> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountUtilFluencyOptUtils = new FluencyOptUtils();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(330);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…ONFIG_FLUENCY_OPT_SWITCH)");
    jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = localAladdinConfig;
  }
  
  @Nullable
  public final URL a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (URL)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public final void a(@Nullable String paramString)
  {
    if ((paramString != null) && (!jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      ThreadManager.executeOnSubThread((Runnable)new FluencyOptUtils.addUrlStrToCache.1(paramString));
    }
  }
  
  public final void a(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "url");
    Map localMap = jdField_a_of_type_JavaUtilMap;
    String str = paramURL.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "url.toString()");
    localMap.put(str, paramURL);
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("card_create_cost_report_switch", 0) == 1;
  }
  
  public final boolean b()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("asynce_create_view_switch", 0) == 1;
  }
  
  public final boolean c()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("gesture_data_switch", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FluencyOptUtils
 * JD-Core Version:    0.7.0.1
 */