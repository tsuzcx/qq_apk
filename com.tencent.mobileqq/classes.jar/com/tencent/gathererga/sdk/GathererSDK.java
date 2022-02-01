package com.tencent.gathererga.sdk;

import com.tencent.gathererga.ad.AdDeviceInfoService;
import com.tencent.gathererga.ad.internal.AdDeviceInfoServiceImpl;
import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManager;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl;
import com.tencent.gathererga.core.internal.provider.impl.MockTuringProviderImpl;
import java.util.HashMap;
import java.util.Map;

public class GathererSDK
{
  public static final ProviderMethodPriority a;
  private static final Map<Integer, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Integer.valueOf(105498));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Integer.valueOf(108298));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), Integer.valueOf(108308));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Integer.valueOf(105548));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Integer.valueOf(108388));
    jdField_a_of_type_ComTencentGatherergaCoreProviderMethodPriority = ProviderMethodPriorityImpl.a();
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    return GathererSDKContext.a(paramClass);
  }
  
  public static void a(GathererConfig paramGathererConfig)
  {
    GathererCoreContext.a(TuringProvider.class, MockTuringProviderImpl.class);
    GathererCoreContext.a(paramGathererConfig);
    GathererSDKContext.a(AdDeviceInfoService.class, AdDeviceInfoServiceImpl.class);
    IDConfigManagerImpl.a().a(paramGathererConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererSDK
 * JD-Core Version:    0.7.0.1
 */