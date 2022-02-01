package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.config.ApiFrequencyConfig;
import com.tencent.mobileqq.ark.util.SysUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ArkAppModuleBase
  implements ark.ModuleCallbackWrapper
{
  public static boolean j = true;
  private long a = 1L;
  private final HashMap<Long, ark.VariantWrapper> b = new HashMap();
  private final Map<String, Set<TokenBucket>> c = new HashMap();
  private final HashMap<String, ArkModuleMethod> d = new HashMap();
  protected int e = 0;
  protected String f = null;
  protected String g = null;
  protected String h = null;
  protected ark.Application i = null;
  
  protected ArkAppModuleBase(ark.Application paramApplication, int paramInt)
  {
    this.i = paramApplication;
    this.f = paramApplication.GetSpecific("appName");
    this.h = paramApplication.GetSpecific("appPath");
    this.g = paramApplication.GetID();
    this.e = paramInt;
    d();
  }
  
  private void d()
  {
    ArkModuleMethod[] arrayOfArkModuleMethod = a();
    if (arrayOfArkModuleMethod != null)
    {
      int m = arrayOfArkModuleMethod.length;
      int k = 0;
      while (k < m)
      {
        ArkModuleMethod localArkModuleMethod = arrayOfArkModuleMethod[k];
        this.d.put(localArkModuleMethod.a(), localArkModuleMethod);
        k += 1;
      }
    }
  }
  
  public static Activity h()
  {
    if (QBaseActivity.sTopActivity != null) {
      return QBaseActivity.sTopActivity;
    }
    return null;
  }
  
  public void Destruct()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
    }
    this.b.clear();
  }
  
  public String GetTypeName()
  {
    return null;
  }
  
  public boolean HasMethod(String paramString)
  {
    paramString = (ArkModuleMethod)this.d.get(paramString);
    if (paramString == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (!a(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HasMethod, method not support app type, method=");
      localStringBuilder.append(paramString);
      QLog.i("ArkApp.ArkAppModuleBase", 1, localStringBuilder.toString());
      return false;
    }
    if (!b(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HasMethod, method not support multi process, method=");
      localStringBuilder.append(paramString);
      QLog.i("ArkApp.ArkAppModuleBase", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    ArkModuleMethod localArkModuleMethod = (ArkModuleMethod)this.d.get(paramString);
    if (localArkModuleMethod == null) {
      return false;
    }
    if (!a(paramString))
    {
      paramArrayOfVariantWrapper = new StringBuilder();
      paramArrayOfVariantWrapper.append("Invoke, check frequency fail, method=");
      paramArrayOfVariantWrapper.append(paramString);
      QLog.i("ArkApp.ArkAppModuleBase", 1, paramArrayOfVariantWrapper.toString());
      return false;
    }
    if (!c(localArkModuleMethod))
    {
      paramArrayOfVariantWrapper = new StringBuilder();
      paramArrayOfVariantWrapper.append("Invoke, no permission, method=");
      paramArrayOfVariantWrapper.append(paramString);
      QLog.i("ArkApp.ArkAppModuleBase", 1, paramArrayOfVariantWrapper.toString());
      return false;
    }
    if ((!g()) && (!localArkModuleMethod.b()))
    {
      paramString = new StringBuilder();
      paramString.append("Invoke, method not support multiprocess, method=");
      paramString.append(localArkModuleMethod);
      QLog.i("ArkApp.ArkAppModuleBase", 1, paramString.toString());
      return false;
    }
    localArkModuleMethod.a(this, paramArrayOfVariantWrapper, paramVariantWrapper);
    return true;
  }
  
  protected long a(ark.VariantWrapper paramVariantWrapper)
  {
    long l = 0L;
    if (paramVariantWrapper != null)
    {
      if (!paramVariantWrapper.IsFunction()) {
        return 0L;
      }
      this.a += 1L;
      if (this.a == 0L) {
        this.a = 1L;
      }
      this.b.put(Long.valueOf(this.a), paramVariantWrapper);
      l = this.a;
    }
    return l;
  }
  
  protected ark.VariantWrapper a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.b.get(Long.valueOf(paramLong));
    this.b.remove(Long.valueOf(paramLong));
    return localVariantWrapper;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      Set localSet = (Set)this.c.get(paramString);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.c.put(paramString, localObject);
      }
      ((Set)localObject).add(new TokenBucket(paramLong1, paramLong2));
    }
  }
  
  public void a(List<ApiFrequencyConfig> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApiFrequencyConfig localApiFrequencyConfig = (ApiFrequencyConfig)paramList.next();
        a(localApiFrequencyConfig.a, localApiFrequencyConfig.b, localApiFrequencyConfig.c);
      }
    }
  }
  
  boolean a(ArkModuleMethod paramArkModuleMethod)
  {
    if (paramArkModuleMethod.d()) {
      return true;
    }
    return this.e == 0;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (!bool1)
    {
      Object localObject = (Set)this.c.get(paramString);
      if (localObject == null) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      TokenBucket localTokenBucket;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localTokenBucket = (TokenBucket)((Iterator)localObject).next();
      } while (localTokenBucket.a());
      QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", new Object[] { paramString, localTokenBucket.toString() }));
    }
    bool1 = false;
    return bool1;
  }
  
  protected abstract ArkModuleMethod[] a();
  
  protected ark.VariantWrapper b(long paramLong)
  {
    return (ark.VariantWrapper)this.b.get(Long.valueOf(paramLong));
  }
  
  public abstract boolean b();
  
  boolean b(ArkModuleMethod paramArkModuleMethod)
  {
    if (g()) {
      return true;
    }
    return paramArkModuleMethod.b();
  }
  
  public abstract boolean c();
  
  boolean c(ArkModuleMethod paramArkModuleMethod)
  {
    return ArkAPIPermission.a(this.f, this.e, this.i, paramArkModuleMethod.c());
  }
  
  boolean g()
  {
    return SysUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppModuleBase
 * JD-Core Version:    0.7.0.1
 */