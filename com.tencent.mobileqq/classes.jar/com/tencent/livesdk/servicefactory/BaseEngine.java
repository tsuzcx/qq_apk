package com.tencent.livesdk.servicefactory;

import android.util.Log;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseEngine
{
  protected Set<Class> scopeServices = new HashSet();
  protected ServiceManager serviceManager;
  
  protected abstract <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass);
  
  public ServiceAccessor getServiceAccessor()
  {
    return this.serviceManager;
  }
  
  protected void initNewServiceScope(ServiceEnginScope paramServiceEnginScope)
  {
    if ((ServiceFactory.getScopeServiceListMap() != null) && (ServiceFactory.getScopeServiceListMap().size() > 0))
    {
      paramServiceEnginScope = (List)ServiceFactory.getScopeServiceListMap().get(paramServiceEnginScope);
      if ((paramServiceEnginScope != null) && (paramServiceEnginScope.size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("custom new service:");
        localStringBuilder.append(paramServiceEnginScope);
        Log.i("LiveEngine", localStringBuilder.toString());
        this.scopeServices.addAll(paramServiceEnginScope);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.BaseEngine
 * JD-Core Version:    0.7.0.1
 */