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
    try
    {
      Object localObject1 = (ArrayList)this.mModuleInstances.get(paramString1);
      if (localObject1 == null)
      {
        paramMap = new StringBuilder();
        paramMap.append("callFunction: jsModuleList is null, moduleName is ");
        paramMap.append(paramString1);
        paramMap.append(", methodName is ");
        paramMap.append(paramString2);
        Log.e("LiteJsModuleProvider", paramMap.toString());
        return false;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      boolean bool2 = false;
      boolean bool1;
      do
      {
        BaseLiteJSModule localBaseLiteJSModule;
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localBaseLiteJSModule = (BaseLiteJSModule)((Iterator)localObject1).next();
          if (!localBaseLiteJSModule.isInit())
          {
            localBaseLiteJSModule.onJsCreate();
            localBaseLiteJSModule.setInit(true);
          }
        } while (TextUtils.isEmpty(paramString2));
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("callFunction exception: moduleName is ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", methodName is ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", jsModule is ");
          localStringBuilder.append(localBaseLiteJSModule);
          localStringBuilder.append(", e is ");
          localStringBuilder.append(localException.getMessage());
          Log.e("LiteJsModuleProvider", localStringBuilder.toString());
          bool1 = false;
        }
        bool2 = bool1;
      } while (!bool1);
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void registerJsModule(BaseLiteJSModule paramBaseLiteJSModule)
  {
    if (paramBaseLiteJSModule == null) {}
    try
    {
      Log.e("LiteJsModuleProvider", "registerJsModule: module is null");
      return;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        int i;
        Iterator localIterator;
        for (;;)
        {
          throw paramBaseLiteJSModule;
        }
        Object localObject = localArrayList;
      }
    }
    localArrayList = (ArrayList)this.mModuleInstances.get(paramBaseLiteJSModule.getName());
    i = 0;
    if (localArrayList != null)
    {
      localIterator = localArrayList.iterator();
      i = 0;
      label257:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label304;
        }
        BaseLiteJSModule localBaseLiteJSModule = (BaseLiteJSModule)localIterator.next();
        if (localBaseLiteJSModule.getClass() == paramBaseLiteJSModule.getClass())
        {
          Log.i("LiteJsModuleProvider", "registerJsModule: module is exist in list");
          i = 1;
          localObject = localArrayList;
          break;
        }
        for (localObject = paramBaseLiteJSModule.getClass().getSuperclass(); (localObject != null) && (BaseLiteJSModule.class != localObject); localObject = ((Class)localObject).getSuperclass()) {
          if (localObject == localBaseLiteJSModule.getClass())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("registerJsModule: remove module, because module is base class, jsModule is ");
            localStringBuilder.append(localBaseLiteJSModule);
            Log.i("LiteJsModuleProvider", localStringBuilder.toString());
            localBaseLiteJSModule.onJsDestroy();
            localBaseLiteJSModule.setInit(false);
            localIterator.remove();
          }
        }
        for (localObject = localBaseLiteJSModule.getClass().getSuperclass();; localObject = ((Class)localObject).getSuperclass())
        {
          if ((localObject == null) || (BaseLiteJSModule.class == localObject)) {
            break label257;
          }
          if (localObject == paramBaseLiteJSModule.getClass())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("registerJsModule: not add module, because module is base class, module is ");
            ((StringBuilder)localObject).append(paramBaseLiteJSModule);
            Log.i("LiteJsModuleProvider", ((StringBuilder)localObject).toString());
            i = 1;
            break;
          }
        }
      }
    }
    localObject = new ArrayList();
    this.mModuleInstances.put(paramBaseLiteJSModule.getName(), localObject);
    if (i == 0) {
      ((ArrayList)localObject).add(paramBaseLiteJSModule);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.LiteJsModuleProvider
 * JD-Core Version:    0.7.0.1
 */