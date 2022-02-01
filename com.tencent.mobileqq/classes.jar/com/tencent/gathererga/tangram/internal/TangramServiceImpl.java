package com.tencent.gathererga.tangram.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gathererga.ad.AdDeviceInfoService;
import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl.Builder;
import com.tencent.gathererga.core.internal.util.GathererExecutor;
import com.tencent.gathererga.sdk.GathererConfig;
import com.tencent.gathererga.sdk.GathererConfig.Builder;
import com.tencent.gathererga.sdk.GathererSDK;
import com.tencent.gathererga.tangram.TangramGlobalSetting;
import com.tencent.gathererga.tangram.TangramIDSetting;
import com.tencent.gathererga.tangram.TangramIDSetting.Params;
import com.tencent.gathererga.tangram.TangramResult;
import com.tencent.gathererga.tangram.TangramService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TangramServiceImpl
  implements TangramService
{
  private static volatile TangramServiceImpl jdField_a_of_type_ComTencentGatherergaTangramInternalTangramServiceImpl;
  private TangramGlobalSetting jdField_a_of_type_ComTencentGatherergaTangramTangramGlobalSetting;
  private TangramStorage jdField_a_of_type_ComTencentGatherergaTangramInternalTangramStorage;
  private Map<Integer, TangramIDSetting> jdField_a_of_type_JavaUtilMap;
  
  private TangramServiceImpl(Context paramContext, TangramGlobalSetting paramTangramGlobalSetting)
  {
    if (!a(paramTangramGlobalSetting)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGatherergaTangramTangramGlobalSetting = paramTangramGlobalSetting;
    this.jdField_a_of_type_JavaUtilMap = paramTangramGlobalSetting.a();
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        localHashMap.put(Integer.valueOf(i), Boolean.valueOf(((TangramIDSetting)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i))).a()));
      }
    }
    this.jdField_a_of_type_ComTencentGatherergaTangramInternalTangramStorage = new TangramStorage();
    GathererSDK.a(GathererConfig.a(paramContext, 1).a(paramTangramGlobalSetting.a()).b(paramTangramGlobalSetting.b()).a(localHashMap).c(paramTangramGlobalSetting.c()).a(paramTangramGlobalSetting.a()).a(paramTangramGlobalSetting.a()).a(this.jdField_a_of_type_ComTencentGatherergaTangramInternalTangramStorage).a(paramTangramGlobalSetting.a()).a(paramTangramGlobalSetting.a()).a());
  }
  
  private TangramResult a(int paramInt, TangramIDSetting paramTangramIDSetting, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      localObject = paramTangramIDSetting.a();
    } else if (paramBoolean2) {
      localObject = ProviderMethodPriorityImpl.a().a().c().a();
    } else {
      localObject = paramTangramIDSetting.b();
    }
    if (paramInt == 402) {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject, paramTangramIDSetting.a().a() });
    } else if (paramInt == 305) {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject, Boolean.valueOf(paramTangramIDSetting.a().a()) });
    } else {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject });
    }
    Object localObject = (AdDeviceInfoService)GathererSDK.a(AdDeviceInfoService.class);
    if ((paramTangramIDSetting != null) && (paramTangramIDSetting.a() != null)) {
      localObject = ((AdDeviceInfoService)localObject).a(Integer.valueOf(paramInt), String.valueOf(paramTangramIDSetting.a()));
    } else {
      localObject = null;
    }
    return new TangramResultImpl(paramTangramIDSetting, (String)localObject);
  }
  
  public static TangramServiceImpl a(Context paramContext, TangramGlobalSetting paramTangramGlobalSetting)
  {
    if (jdField_a_of_type_ComTencentGatherergaTangramInternalTangramServiceImpl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentGatherergaTangramInternalTangramServiceImpl == null) {
          jdField_a_of_type_ComTencentGatherergaTangramInternalTangramServiceImpl = new TangramServiceImpl(paramContext, paramTangramGlobalSetting);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentGatherergaTangramInternalTangramServiceImpl;
  }
  
  private Map<Integer, TangramResult> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentGatherergaTangramTangramGlobalSetting.a();
    HashMap localHashMap2 = new HashMap();
    if (localHashMap1 != null)
    {
      if (localHashMap1.size() == 0) {
        return localHashMap2;
      }
      Iterator localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        TangramIDSetting localTangramIDSetting = (TangramIDSetting)localHashMap1.get(Integer.valueOf(i));
        if ((localTangramIDSetting != null) && ((!paramBoolean1) || (localTangramIDSetting.a() != null))) {
          if ((!paramBoolean1) && ((i == 1) || (i == 2))) {
            localHashMap2.put(Integer.valueOf(i), a(i, localTangramIDSetting, false, true));
          } else {
            localHashMap2.put(Integer.valueOf(i), a(i, localTangramIDSetting, paramBoolean1, paramBoolean2));
          }
        }
      }
      GathererExecutor.a().execute(new TangramServiceImpl.2(this));
    }
    return localHashMap2;
  }
  
  private void a()
  {
    GathererExecutor.a().execute(new TangramServiceImpl.1(this));
  }
  
  private boolean a(TangramGlobalSetting paramTangramGlobalSetting)
  {
    return (!TextUtils.isEmpty(paramTangramGlobalSetting.a())) && (!TextUtils.isEmpty(paramTangramGlobalSetting.b()));
  }
  
  public Map<Integer, TangramResult> a(boolean paramBoolean)
  {
    Map localMap = a(false, paramBoolean);
    a();
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramServiceImpl
 * JD-Core Version:    0.7.0.1
 */