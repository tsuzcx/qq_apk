package com.tencent.hippy.qq.inject;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyComponentFactory;
import com.tencent.mobileqq.kandian.biz.hippy.inject.TKDHippyComponentFactoryImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

public class ComponentInjectFactory
{
  private static final String TAG = "ComponentInjectFactory";
  private static ArrayList<IHippyComponentFactory> sHippyComponentFactory = new ArrayList();
  @ConfigInject(configPath="Business/hippy-api/src/main/resources/Inject_TKDHippyComponentFactoryImpl.yml", version=1)
  private static ArrayList<Class<? extends IHippyComponentFactory>> sHippyComponentFactoryClass = new ArrayList();
  
  static
  {
    sHippyComponentFactoryClass.add(TKDHippyComponentFactoryImpl.class);
  }
  
  public static void addMockHippyComponentFactoryClass(Class<? extends IHippyComponentFactory> paramClass)
  {
    sHippyComponentFactoryClass.add(paramClass);
  }
  
  public static IHippyComponentFactory getHippyComponentFactory(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      IHippyComponentFactory localIHippyComponentFactory2 = getiHippyComponentFactoryByCache(paramString);
      IHippyComponentFactory localIHippyComponentFactory1 = localIHippyComponentFactory2;
      if (localIHippyComponentFactory2 == null) {
        localIHippyComponentFactory1 = getiHippyComponentFactoryByReflect(paramString);
      }
      return localIHippyComponentFactory1;
    }
    finally {}
  }
  
  @Nullable
  private static IHippyComponentFactory getiHippyComponentFactoryByCache(String paramString)
  {
    int i = 0;
    while (i < sHippyComponentFactory.size())
    {
      IHippyComponentFactory localIHippyComponentFactory = (IHippyComponentFactory)sHippyComponentFactory.get(i);
      if (localIHippyComponentFactory.matchName(paramString)) {
        return localIHippyComponentFactory;
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  private static IHippyComponentFactory getiHippyComponentFactoryByReflect(String paramString)
  {
    int i = 0;
    try
    {
      while (i < sHippyComponentFactoryClass.size())
      {
        IHippyComponentFactory localIHippyComponentFactory = (IHippyComponentFactory)((Class)sHippyComponentFactoryClass.get(i)).newInstance();
        sHippyComponentFactory.add(localIHippyComponentFactory);
        boolean bool = localIHippyComponentFactory.matchName(paramString);
        if (bool) {
          return localIHippyComponentFactory;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.d("ComponentInjectFactory", 1, "getHippyComponentFactory", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.inject.ComponentInjectFactory
 * JD-Core Version:    0.7.0.1
 */