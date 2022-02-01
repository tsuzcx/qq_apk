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
  private static volatile TangramServiceImpl d;
  private TangramGlobalSetting a;
  private Map<Integer, TangramIDSetting> b;
  private TangramStorage c;
  
  private TangramServiceImpl(Context paramContext, TangramGlobalSetting paramTangramGlobalSetting)
  {
    if (!a(paramTangramGlobalSetting)) {
      return;
    }
    this.a = paramTangramGlobalSetting;
    this.b = paramTangramGlobalSetting.d();
    HashMap localHashMap = new HashMap();
    Object localObject = this.b;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = this.b.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        localHashMap.put(Integer.valueOf(i), Boolean.valueOf(((TangramIDSetting)this.b.get(Integer.valueOf(i))).a()));
      }
    }
    this.c = new TangramStorage();
    GathererSDK.a(GathererConfig.a(paramContext, 1).a(paramTangramGlobalSetting.a()).b(paramTangramGlobalSetting.b()).a(localHashMap).c(paramTangramGlobalSetting.e()).a(paramTangramGlobalSetting.f()).a(paramTangramGlobalSetting.c()).a(this.c).a(paramTangramGlobalSetting.g()).a(paramTangramGlobalSetting.h()).a());
  }
  
  private TangramResult a(int paramInt, TangramIDSetting paramTangramIDSetting, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      localObject = paramTangramIDSetting.b();
    } else if (paramBoolean2) {
      localObject = ProviderMethodPriorityImpl.g().a().c().g();
    } else {
      localObject = paramTangramIDSetting.c();
    }
    if (paramInt == 402) {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject, paramTangramIDSetting.d().b() });
    } else if (paramInt == 305) {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject, Boolean.valueOf(paramTangramIDSetting.d().a()) });
    } else {
      paramTangramIDSetting = (ProviderResult)GathererCoreContext.a(paramInt, new Object[] { localObject });
    }
    Object localObject = (AdDeviceInfoService)GathererSDK.a(AdDeviceInfoService.class);
    if ((paramTangramIDSetting != null) && (paramTangramIDSetting.b() != null)) {
      localObject = ((AdDeviceInfoService)localObject).a(Integer.valueOf(paramInt), String.valueOf(paramTangramIDSetting.b()));
    } else {
      localObject = null;
    }
    return new TangramResultImpl(paramTangramIDSetting, (String)localObject);
  }
  
  public static TangramServiceImpl a(Context paramContext, TangramGlobalSetting paramTangramGlobalSetting)
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new TangramServiceImpl(paramContext, paramTangramGlobalSetting);
        }
      }
      finally {}
    }
    return d;
  }
  
  private Map<Integer, TangramResult> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return localHashMap;
      }
      localObject = this.b.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        TangramIDSetting localTangramIDSetting = (TangramIDSetting)this.b.get(Integer.valueOf(i));
        if ((localTangramIDSetting != null) && ((!paramBoolean1) || (localTangramIDSetting.b() != null))) {
          if ((!paramBoolean1) && ((i == 1) || (i == 2))) {
            localHashMap.put(Integer.valueOf(i), a(i, localTangramIDSetting, false, true));
          } else {
            localHashMap.put(Integer.valueOf(i), a(i, localTangramIDSetting, paramBoolean1, paramBoolean2));
          }
        }
      }
      GathererExecutor.a().a(new TangramServiceImpl.2(this));
    }
    return localHashMap;
  }
  
  private void a()
  {
    GathererExecutor.a().a(new TangramServiceImpl.1(this));
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
  
  public void a(Map<Integer, TangramIDSetting> paramMap)
  {
    this.b = paramMap;
    paramMap = new HashMap();
    Object localObject = this.b;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = this.b.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        paramMap.put(Integer.valueOf(i), Boolean.valueOf(((TangramIDSetting)this.b.get(Integer.valueOf(i))).a()));
      }
    }
    GathererSDK.a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramServiceImpl
 * JD-Core Version:    0.7.0.1
 */