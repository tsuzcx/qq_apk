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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getService:");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      ((StringBuilder)localObject).append(" in ");
      ((StringBuilder)localObject).append(this.mEnginServiceConfig.getOwnerEngine());
      ((StringBuilder)localObject).append(" is own service, self create");
      Log.i("ServiceManager", ((StringBuilder)localObject).toString());
      localObject = ServiceFactory.createService(this.context, paramClass, this);
      if (localObject != null)
      {
        this.allAccessableServices.put(paramClass, localObject);
        return localObject;
      }
      return null;
    }
    if (this.mParentServiceAccessor != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getService:");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      ((StringBuilder)localObject).append(" in ");
      ((StringBuilder)localObject).append(this.mEnginServiceConfig.getOwnerEngine());
      ((StringBuilder)localObject).append(" not own service, parent get or create");
      Log.i("ServiceManager", ((StringBuilder)localObject).toString());
      return this.mParentServiceAccessor.getService(paramClass);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getService:");
    ((StringBuilder)localObject).append(paramClass.getSimpleName());
    ((StringBuilder)localObject).append(" in ");
    ((StringBuilder)localObject).append(this.mEnginServiceConfig.getOwnerEngine());
    ((StringBuilder)localObject).append(" ERROR: service not belong to any engine");
    Log.e("ServiceManager", ((StringBuilder)localObject).toString());
    throw new RuntimeException("Error Service Creator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceManager
 * JD-Core Version:    0.7.0.1
 */