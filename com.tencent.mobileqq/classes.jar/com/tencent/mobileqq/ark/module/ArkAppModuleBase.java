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
  public static boolean a = true;
  protected int a;
  private long jdField_a_of_type_Long = 1L;
  protected ark.Application a;
  private final HashMap<Long, ark.VariantWrapper> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Map<String, Set<TokenBucket>> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected String b;
  private final HashMap<String, ArkModuleMethod> b;
  protected String c = null;
  protected String d = null;
  
  protected ArkAppModuleBase(ark.Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentArkArk$Application = null;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentArkArk$Application = paramApplication;
    this.jdField_b_of_type_JavaLangString = paramApplication.GetSpecific("appName");
    this.d = paramApplication.GetSpecific("appPath");
    this.c = paramApplication.GetID();
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  private void a()
  {
    ArkModuleMethod[] arrayOfArkModuleMethod = a();
    if (arrayOfArkModuleMethod != null)
    {
      int j = arrayOfArkModuleMethod.length;
      int i = 0;
      while (i < j)
      {
        ArkModuleMethod localArkModuleMethod = arrayOfArkModuleMethod[i];
        this.jdField_b_of_type_JavaUtilHashMap.put(localArkModuleMethod.a(), localArkModuleMethod);
        i += 1;
      }
    }
  }
  
  public static Activity b()
  {
    if (QBaseActivity.sTopActivity != null) {
      return QBaseActivity.sTopActivity;
    }
    return null;
  }
  
  public void Destruct()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public String GetTypeName()
  {
    return null;
  }
  
  public boolean HasMethod(String paramString)
  {
    paramString = (ArkModuleMethod)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
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
    ArkModuleMethod localArkModuleMethod = (ArkModuleMethod)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
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
    if ((!c()) && (!localArkModuleMethod.a()))
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
      this.jdField_a_of_type_Long += 1L;
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = 1L;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), paramVariantWrapper);
      l = this.jdField_a_of_type_Long;
    }
    return l;
  }
  
  protected ark.VariantWrapper a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    return localVariantWrapper;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
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
        a(localApiFrequencyConfig.jdField_a_of_type_JavaLangString, localApiFrequencyConfig.jdField_a_of_type_Long, localApiFrequencyConfig.b);
      }
    }
  }
  
  public abstract boolean a();
  
  boolean a(ArkModuleMethod paramArkModuleMethod)
  {
    if (paramArkModuleMethod.b()) {
      return true;
    }
    return this.jdField_a_of_type_Int == 0;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (!bool1)
    {
      Object localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    return (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public abstract boolean b();
  
  boolean b(ArkModuleMethod paramArkModuleMethod)
  {
    if (c()) {
      return true;
    }
    return paramArkModuleMethod.a();
  }
  
  boolean c()
  {
    return SysUtil.a();
  }
  
  boolean c(ArkModuleMethod paramArkModuleMethod)
  {
    return ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, paramArkModuleMethod.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppModuleBase
 * JD-Core Version:    0.7.0.1
 */