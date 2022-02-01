package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
{
  private Context a;
  
  f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private <T extends ServiceRegistrar> T a(String paramString)
  {
    try
    {
      try
      {
        Class localClass = Class.forName(paramString);
        if (!ServiceRegistrar.class.isAssignableFrom(localClass))
        {
          paramString = new StringBuilder();
          paramString.append(localClass);
          paramString.append(" must extends from ServiceRegistrar.");
          Log.e("ServiceRegistrarParser", paramString.toString());
          return null;
        }
        paramString = (ServiceRegistrar)Class.forName(paramString).newInstance();
        return paramString;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramString = new StringBuilder();
        paramString.append("instantiate service class exception ");
        String str = localIllegalAccessException.getLocalizedMessage();
      }
      catch (InstantiationException localInstantiationException)
      {
        paramString = new StringBuilder();
        paramString.append("instantiate service class exception ");
        localObject = localInstantiationException.getLocalizedMessage();
      }
      paramString.append((String)localObject);
      paramString = paramString.toString();
    }
    catch (ClassNotFoundException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can not found service class, ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      paramString = ((StringBuilder)localObject).toString();
    }
    Log.e("ServiceRegistrarParser", paramString);
    return null;
  }
  
  private Bundle b()
  {
    Object localObject = this.a.getPackageManager();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((PackageManager)localObject).getServiceInfo(new ComponentName(this.a, ServiceDiscovery.class), 128);
      if (localObject == null)
      {
        Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
        return null;
      }
      localObject = ((ServiceInfo)localObject).metaData;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ServiceDiscovery exception.");
      localStringBuilder.append(localNameNotFoundException.getLocalizedMessage());
      Log.e("ServiceRegistrarParser", localStringBuilder.toString());
    }
    return null;
  }
  
  private List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = b();
    if (localBundle == null) {
      return localArrayList;
    }
    HashMap localHashMap = new HashMap(10);
    Iterator localIterator = localBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("com.huawei.agconnect.core.ServiceRegistrar".equals(localBundle.getString(str)))
      {
        Object localObject2 = str.split(":");
        if (localObject2.length == 2)
        {
          try
          {
            localHashMap.put(localObject2[0], Integer.valueOf(localObject2[1]));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("registrar configuration format error:");
            localObject1 = localNumberFormatException.getMessage();
            break label177;
          }
        }
        else if (localObject2.length == 1)
        {
          localHashMap.put(localObject2[0], Integer.valueOf(1000));
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("registrar configuration error, ");
          label177:
          ((StringBuilder)localObject2).append((String)localObject1);
          Log.e("ServiceRegistrarParser", ((StringBuilder)localObject2).toString());
        }
      }
    }
    Object localObject1 = new ArrayList(localHashMap.entrySet());
    Collections.sort((List)localObject1, new f.a(null));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getKey());
    }
    return localArrayList;
  }
  
  public List<Service> a()
  {
    Log.i("ServiceRegistrarParser", "getServices");
    Object localObject1 = c();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = a((String)((Iterator)localObject1).next());
      if (localObject2 != null)
      {
        ((ServiceRegistrar)localObject2).initialize(this.a);
        localObject2 = ((ServiceRegistrar)localObject2).getServices(this.a);
        if (localObject2 != null) {
          localArrayList.addAll((Collection)localObject2);
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("services:");
    ((StringBuilder)localObject1).append(Integer.valueOf(localArrayList.size()));
    Log.i("ServiceRegistrarParser", ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.a.f
 * JD-Core Version:    0.7.0.1
 */