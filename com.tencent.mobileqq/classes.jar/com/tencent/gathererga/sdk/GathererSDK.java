package com.tencent.gathererga.sdk;

import com.tencent.gathererga.ad.AdDeviceInfoService;
import com.tencent.gathererga.ad.internal.AdDeviceInfoServiceImpl;
import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManager;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl;
import com.tencent.gathererga.taid.ga.TAIDGaSDK;
import java.util.HashMap;
import java.util.Map;

public class GathererSDK
{
  public static final ProviderMethodPriority a = ProviderMethodPriorityImpl.f();
  private static final Map<Integer, Integer> b = new HashMap();
  
  static
  {
    b.put(Integer.valueOf(3), Integer.valueOf(105498));
    b.put(Integer.valueOf(1), Integer.valueOf(108298));
    b.put(Integer.valueOf(2), Integer.valueOf(108308));
    b.put(Integer.valueOf(4), Integer.valueOf(105548));
    b.put(Integer.valueOf(5), Integer.valueOf(108388));
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    return GathererSDKContext.a(paramClass);
  }
  
  public static void a(GathererConfig paramGathererConfig)
  {
    if (b.get(Integer.valueOf(paramGathererConfig.d())) != null)
    {
      TAIDGaSDK.a(paramGathererConfig.a(), paramGathererConfig.b(), ((Integer)b.get(Integer.valueOf(paramGathererConfig.d()))).intValue(), paramGathererConfig.g());
      GathererCoreContext.a(paramGathererConfig);
      GathererSDKContext.a(AdDeviceInfoService.class, AdDeviceInfoServiceImpl.class);
      IDConfigManagerImpl.a().a(paramGathererConfig);
      return;
    }
    throw new IllegalArgumentException("please input valid type");
  }
  
  public static void a(Map<Integer, Boolean> paramMap)
  {
    IDConfigManagerImpl.a().a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererSDK
 * JD-Core Version:    0.7.0.1
 */