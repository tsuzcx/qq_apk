package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.ArkAiAppCenter.ApiFrequencyConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ArkAppModuleReg$ModuleBase
  implements ArkAppModuleReg.TypeCheckModuleCallbackWrapper
{
  public long a;
  public String a;
  HashMap a;
  protected Map a;
  protected long b = 1L;
  
  public ArkAppModuleReg$ModuleBase()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void Destruct()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public long a(ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
      return 0L;
    }
    this.b += 1L;
    if (this.b == 0L) {
      this.b = 1L;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.b), paramVariantWrapper);
    return this.b;
  }
  
  public ark.VariantWrapper a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    return localVariantWrapper;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject != null) {
        break label118;
      }
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    label118:
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      paramString.add(new ArkAppModuleReg.ModuleBase.TokenBucket(this, paramLong1, paramLong2));
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ArkAiAppCenter.ApiFrequencyConfig localApiFrequencyConfig = (ArkAiAppCenter.ApiFrequencyConfig)paramList.next();
        a(localApiFrequencyConfig.jdField_a_of_type_JavaLangString, localApiFrequencyConfig.jdField_a_of_type_Long, localApiFrequencyConfig.b);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArkAppModuleReg.ModuleBase.TokenBucket localTokenBucket = (ArkAppModuleReg.ModuleBase.TokenBucket)((Iterator)localObject).next();
        if (!localTokenBucket.a())
        {
          QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", new Object[] { paramString, localTokenBucket.toString() }));
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  ark.VariantWrapper b(long paramLong)
  {
    return (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleBase
 * JD-Core Version:    0.7.0.1
 */