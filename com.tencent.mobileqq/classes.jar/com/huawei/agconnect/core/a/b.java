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

public class b
{
  private Context a;
  
  b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private <T extends ServiceRegistrar> T a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      if (!ServiceRegistrar.class.isAssignableFrom(localClass))
      {
        Log.e("ServiceRegistrarParser", localClass + " must extends from ServiceRegistrar.");
        return null;
      }
      paramString = (ServiceRegistrar)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("ServiceRegistrarParser", "Can not found service class, " + paramString.getMessage());
      return null;
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        Log.e("ServiceRegistrarParser", "instantiate service class exception " + paramString.getLocalizedMessage());
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        Log.e("ServiceRegistrarParser", "instantiate service class exception " + paramString.getLocalizedMessage());
      }
    }
  }
  
  private List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = c();
    if (localObject == null) {
      return localArrayList;
    }
    HashMap localHashMap = new HashMap(10);
    Iterator localIterator = ((Bundle)localObject).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("com.huawei.agconnect.core.ServiceRegistrar".equals(((Bundle)localObject).getString(str)))
      {
        String[] arrayOfString = str.split(":");
        if (arrayOfString.length == 2) {
          try
          {
            localHashMap.put(arrayOfString[0], Integer.valueOf(arrayOfString[1]));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.e("ServiceRegistrarParser", "registrar configuration format error:" + localNumberFormatException.getMessage());
          }
        } else if (arrayOfString.length == 1) {
          localHashMap.put(arrayOfString[0], Integer.valueOf(1000));
        } else {
          Log.e("ServiceRegistrarParser", "registrar configuration error, " + localNumberFormatException);
        }
      }
    }
    localObject = new ArrayList(localHashMap.entrySet());
    Collections.sort((List)localObject, new b.a(null));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((Map.Entry)((Iterator)localObject).next()).getKey());
    }
    return localArrayList;
  }
  
  private Bundle c()
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
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + localNameNotFoundException.getLocalizedMessage());
      return null;
    }
    Bundle localBundle = localNameNotFoundException.metaData;
    return localBundle;
  }
  
  public List<Service> a()
  {
    Log.i("ServiceRegistrarParser", "getServices");
    Object localObject1 = b();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((String)((Iterator)localObject1).next());
      if (localObject2 != null)
      {
        ((ServiceRegistrar)localObject2).initialize(this.a);
        localObject2 = ((ServiceRegistrar)localObject2).getServices(this.a);
        if (localObject2 != null) {
          localArrayList.addAll((Collection)localObject2);
        }
      }
    }
    Object localObject2 = new StringBuilder().append("services:");
    if (localArrayList == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localArrayList.size()))
    {
      Log.i("ServiceRegistrarParser", localObject1);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.b
 * JD-Core Version:    0.7.0.1
 */