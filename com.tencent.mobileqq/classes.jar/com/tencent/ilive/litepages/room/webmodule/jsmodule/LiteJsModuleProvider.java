package com.tencent.ilive.litepages.room.webmodule.jsmodule;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LiteJsModuleProvider
  implements ILiteModuleProvider
{
  private static final String TAG = "LiteJsModuleProvider";
  private final HashMap<String, ArrayList<BaseLiteJSModule>> mModuleInstances = new HashMap();
  
  public boolean callFunction(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    for (;;)
    {
      boolean bool1;
      try
      {
        Object localObject1 = (ArrayList)this.mModuleInstances.get(paramString1);
        if (localObject1 == null)
        {
          Log.e("LiteJsModuleProvider", "callFunction: jsModuleList is null, moduleName is " + paramString1 + ", methodName is " + paramString2);
          bool2 = false;
          return bool2;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        bool1 = false;
        if (((Iterator)localObject1).hasNext())
        {
          BaseLiteJSModule localBaseLiteJSModule = (BaseLiteJSModule)((Iterator)localObject1).next();
          if (!localBaseLiteJSModule.isInit())
          {
            localBaseLiteJSModule.onJsCreate();
            localBaseLiteJSModule.setInit(true);
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            Object localObject2 = localBaseLiteJSModule.getClass();
            try
            {
              localObject2 = ((Class)localObject2).getMethod(paramString2, new Class[] { Map.class });
              if (((Method)localObject2).isAnnotationPresent(NewJavascriptInterface.class)) {
                ((Method)localObject2).invoke(localBaseLiteJSModule, new Object[] { paramMap });
              }
              bool1 = true;
            }
            catch (Exception localException)
            {
              Log.e("LiteJsModuleProvider", "callFunction exception: moduleName is " + paramString1 + ", methodName is " + paramString2 + ", jsModule is " + localBaseLiteJSModule + ", e is " + localException.getMessage());
              bool1 = false;
              continue;
            }
            bool2 = bool1;
            if (bool1) {
              continue;
            }
            continue;
          }
          continue;
        }
      }
      finally {}
      boolean bool2 = bool1;
    }
  }
  
  public void registerJsModule(BaseLiteJSModule paramBaseLiteJSModule)
  {
    int j = 1;
    if (paramBaseLiteJSModule == null) {}
    Iterator localIterator;
    int i;
    try
    {
      Log.e("LiteJsModuleProvider", "registerJsModule: module is null");
      return;
    }
    finally {}
    ArrayList localArrayList = (ArrayList)this.mModuleInstances.get(paramBaseLiteJSModule.getName());
    if (localArrayList != null)
    {
      localIterator = localArrayList.iterator();
      i = 0;
    }
    label308:
    label310:
    for (;;)
    {
      BaseLiteJSModule localBaseLiteJSModule;
      Object localObject;
      if (localIterator.hasNext())
      {
        localBaseLiteJSModule = (BaseLiteJSModule)localIterator.next();
        if (localBaseLiteJSModule.getClass() == paramBaseLiteJSModule.getClass())
        {
          Log.i("LiteJsModuleProvider", "registerJsModule: module is exist in list");
          i = j;
          localObject = localArrayList;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label308;
        }
        ((ArrayList)localObject).add(paramBaseLiteJSModule);
        break;
        for (localObject = paramBaseLiteJSModule.getClass().getSuperclass(); (localObject != null) && (BaseLiteJSModule.class != localObject); localObject = ((Class)localObject).getSuperclass()) {
          if (localObject == localBaseLiteJSModule.getClass())
          {
            Log.i("LiteJsModuleProvider", "registerJsModule: remove module, because module is base class, jsModule is " + localBaseLiteJSModule);
            localBaseLiteJSModule.onJsDestroy();
            localBaseLiteJSModule.setInit(false);
            localIterator.remove();
          }
        }
        localObject = localBaseLiteJSModule.getClass().getSuperclass();
        for (;;)
        {
          if ((localObject != null) && (BaseLiteJSModule.class != localObject)) {
            if (localObject == paramBaseLiteJSModule.getClass())
            {
              Log.i("LiteJsModuleProvider", "registerJsModule: not add module, because module is base class, module is " + paramBaseLiteJSModule);
              i = 1;
            }
            else
            {
              localObject = ((Class)localObject).getSuperclass();
              continue;
              localObject = new ArrayList();
              this.mModuleInstances.put(paramBaseLiteJSModule.getName(), localObject);
              i = 0;
              break;
            }
          }
        }
        break label310;
        localObject = localArrayList;
      }
      break;
    }
  }
  
  public void removeAllJsModule()
  {
    if (this.mModuleInstances.size() > 0)
    {
      Iterator localIterator = this.mModuleInstances.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BaseLiteJSModule localBaseLiteJSModule = (BaseLiteJSModule)((Iterator)localObject).next();
            if (localBaseLiteJSModule != null)
            {
              localBaseLiteJSModule.onJsDestroy();
              localBaseLiteJSModule.setInit(false);
            }
          }
        }
      }
    }
    this.mModuleInstances.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.LiteJsModuleProvider
 * JD-Core Version:    0.7.0.1
 */