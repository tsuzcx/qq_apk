package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class AVBusiness
{
  private static long jdField_a_of_type_Long = 0L;
  private static final String jdField_a_of_type_JavaLangString = "AVBusiness";
  private final HashMap<Long, Integer> jdField_a_of_type_JavaUtilHashMap;
  private final long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private final long jdField_c_of_type_Long;
  private final String jdField_c_of_type_JavaLangString;
  
  AVBusiness(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = ((Long)Constants.jdField_a_of_type_JavaUtilHashMap.get(paramString1)).longValue();
    this.jdField_a_of_type_JavaUtilHashMap = a(paramString1, this.jdField_b_of_type_Long);
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    this.jdField_c_of_type_Long = l;
  }
  
  private static HashMap<Long, Integer> a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    long l2 = 1L;
    long l1 = paramLong;
    Object localObject;
    for (paramLong = l2; l1 != 0L; paramLong <<= 1)
    {
      if ((l1 & 1L) != 0L)
      {
        localObject = (List)Constants.Priority.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        int i = 0;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          if (((HashSet)((Iterator)localObject).next()).contains(paramString))
          {
            localHashMap.put(Long.valueOf(paramLong), Integer.valueOf(i));
            break;
          }
          i += 1;
        }
      }
      l1 >>= 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = localHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPriorityMap, type[");
        localStringBuilder.append(((Map.Entry)localObject).getKey());
        localStringBuilder.append("], priority[");
        localStringBuilder.append(((Map.Entry)localObject).getValue());
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    return localHashMap;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lossFocus, business[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], process[");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if ("com.tencent.mobileqq".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject = AVBizModuleFactory.a(this.jdField_b_of_type_JavaLangString);
      if ((localObject instanceof IModule.FocusChangeListener)) {
        ((IModule.FocusChangeListener)localObject).b();
      }
    }
    else
    {
      QIPCServerHelper.getInstance().getServer().callClient(this.jdField_c_of_type_JavaLangString, 1, this.jdField_b_of_type_JavaLangString, "notify_focus_loss", new Bundle(), null);
    }
  }
  
  public boolean a(AVBusiness paramAVBusiness)
  {
    long l2 = a() & paramAVBusiness.a();
    boolean bool2;
    for (long l1 = 1L;; l1 <<= 1)
    {
      bool2 = false;
      bool1 = false;
      if (l2 == 0L) {
        break;
      }
      if ((l2 & 1L) != 0L)
      {
        int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1))).intValue();
        int j = ((Integer)paramAVBusiness.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1))).intValue();
        if (i < j) {
          return true;
        }
        if (i > j) {
          return false;
        }
      }
      l2 >>= 1;
    }
    if ((Constants.jdField_a_of_type_JavaUtilHashSet.contains(a())) && (Constants.jdField_a_of_type_JavaUtilHashSet.contains(paramAVBusiness.a())))
    {
      if (this.jdField_c_of_type_Long > paramAVBusiness.jdField_c_of_type_Long) {
        bool1 = true;
      }
      return bool1;
    }
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Long < paramAVBusiness.jdField_c_of_type_Long) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gainFocus, business[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], process[");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if ("com.tencent.mobileqq".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject = AVBizModuleFactory.a(this.jdField_b_of_type_JavaLangString);
      if ((localObject instanceof IModule.FocusChangeListener)) {
        ((IModule.FocusChangeListener)localObject).c();
      }
    }
    else
    {
      QIPCServerHelper.getInstance().getServer().callClient(this.jdField_c_of_type_JavaLangString, 1, this.jdField_b_of_type_JavaLangString, "notify_focus_gain", new Bundle(), null);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AVBusiness))
    {
      String str = this.jdField_b_of_type_JavaLangString;
      if (str != null)
      {
        paramObject = (AVBusiness)paramObject;
        if (str.equals(paramObject.jdField_b_of_type_JavaLangString))
        {
          str = this.jdField_c_of_type_JavaLangString;
          if ((str != null) && (str.equals(paramObject.jdField_c_of_type_JavaLangString)) && (this.jdField_b_of_type_Long == paramObject.jdField_b_of_type_Long) && (this.jdField_c_of_type_Long == paramObject.jdField_c_of_type_Long)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBusiness
 * JD-Core Version:    0.7.0.1
 */