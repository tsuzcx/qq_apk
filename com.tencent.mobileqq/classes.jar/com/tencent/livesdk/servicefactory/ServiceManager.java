package com.tencent.livesdk.servicefactory;

import android.content.Context;
import android.util.Log;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServiceManager
  implements ServiceAccessor
{
  private final String TAG = "ServiceManager";
  private Map<Class<? extends ServiceBaseInterface>, ServiceBaseInterface> allAccessableServices = new HashMap();
  private Context context;
  private EnginServiceConfig mEnginServiceConfig;
  private ServiceAccessor mParentServiceAccessor;
  private Set<Class<? extends ServiceBaseInterface>> supportedServiceSet;
  
  public ServiceManager(Context paramContext, ServiceAccessor paramServiceAccessor, EnginServiceConfig paramEnginServiceConfig)
  {
    this.context = paramContext;
    this.mParentServiceAccessor = paramServiceAccessor;
    this.mEnginServiceConfig = paramEnginServiceConfig;
  }
  
  public void destroyService(Class<? extends ServiceBaseInterface> paramClass)
  {
    this.allAccessableServices.remove(paramClass);
  }
  
  public Map<Class<? extends ServiceBaseInterface>, ServiceBaseInterface> getAllAvailableService()
  {
    return this.allAccessableServices;
  }
  
  public <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass)
  {
    if (this.allAccessableServices.containsKey(paramClass)) {
      return (ServiceBaseInterface)this.allAccessableServices.get(paramClass);
    }
    if (this.mEnginServiceConfig.getScopeServices().contains(paramClass))
    {
      Log.i("ServiceManager", "getService:" + paramClass.getSimpleName() + " in " + this.mEnginServiceConfig.getOwnerEngine() + " is own service, self create");
      ServiceBaseInterface localServiceBaseInterface = ServiceFactory.createService(this.context, paramClass, this);
      if (localServiceBaseInterface != null)
      {
        this.allAccessableServices.put(paramClass, localServiceBaseInterface);
        return localServiceBaseInterface;
      }
    }
    else
    {
      if (this.mParentServiceAccessor != null)
      {
        Log.i("ServiceManager", "getService:" + paramClass.getSimpleName() + " in " + this.mEnginServiceConfig.getOwnerEngine() + " not own service, parent get or create");
        return this.mParentServiceAccessor.getService(paramClass);
      }
      Log.e("ServiceManager", "getService:" + paramClass.getSimpleName() + " in " + this.mEnginServiceConfig.getOwnerEngine() + " ERROR: service not belong to any engine");
      throw new RuntimeException("Error Service Creator");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceManager
 * JD-Core Version:    0.7.0.1
 */