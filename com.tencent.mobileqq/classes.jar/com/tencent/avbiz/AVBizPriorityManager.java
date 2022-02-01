package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class AVBizPriorityManager
{
  private static volatile AVBizPriorityManager jdField_a_of_type_ComTencentAvbizAVBizPriorityManager;
  private final HashMap<Long, TreeSet<AVBusiness>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<Long, AVBusiness> b = new HashMap();
  private final HashMap<String, AVBusiness> c = new HashMap();
  
  private AVBizPriorityManager()
  {
    AVBizPriorityManager.1 local1 = new AVBizPriorityManager.1(this);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(1L), new TreeSet(local1));
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(2L), new TreeSet(local1));
  }
  
  public static AVBizPriorityManager a()
  {
    if (jdField_a_of_type_ComTencentAvbizAVBizPriorityManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvbizAVBizPriorityManager == null) {
          jdField_a_of_type_ComTencentAvbizAVBizPriorityManager = new AVBizPriorityManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvbizAVBizPriorityManager;
  }
  
  private HashMap<Long, AVBusiness> a(Set<AVBusiness> paramSet)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      if (paramSet.isEmpty()) {
        break label256;
      }
      Iterator localIterator1 = paramSet.iterator();
      if (localIterator1.hasNext())
      {
        AVBusiness localAVBusiness1 = (AVBusiness)localIterator1.next();
        int i = 1;
        Iterator localIterator2 = AVBizUtils.a(localAVBusiness1.a()).iterator();
        int j;
        long l;
        do
        {
          j = i;
          if (!localIterator2.hasNext()) {
            break;
          }
          l = ((Long)localIterator2.next()).longValue();
          Iterator localIterator3 = ((TreeSet)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).iterator();
          AVBusiness localAVBusiness2;
          do
          {
            j = i;
            if (!localIterator3.hasNext()) {
              break;
            }
            localAVBusiness2 = (AVBusiness)localIterator3.next();
          } while (!paramSet.contains(localAVBusiness2));
          j = i;
          if (!localAVBusiness2.equals(localAVBusiness1)) {
            j = 0;
          }
          i = j;
        } while (j != 0);
        if (j == 0) {
          break;
        }
        localIterator1 = AVBizUtils.a(localAVBusiness1.a()).iterator();
        while (localIterator1.hasNext())
        {
          l = ((Long)localIterator1.next()).longValue();
          localHashMap.put(Long.valueOf(l), localAVBusiness1);
          paramSet.removeAll(new HashSet((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))));
        }
      }
    }
    label256:
    return localHashMap;
  }
  
  private void a(long paramLong, Set<AVBusiness> paramSet1, Set<AVBusiness> paramSet2)
  {
    Object localObject1 = a(paramSet1);
    paramSet1 = new HashSet();
    Object localObject2 = AVBizUtils.a(paramLong).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramLong = ((Long)((Iterator)localObject2).next()).longValue();
      AVBusiness localAVBusiness1 = (AVBusiness)((HashMap)localObject1).get(Long.valueOf(paramLong));
      AVBusiness localAVBusiness2 = (AVBusiness)this.b.get(Long.valueOf(paramLong));
      if (localAVBusiness1 == null)
      {
        if (localAVBusiness2 != null)
        {
          paramSet2.add(localAVBusiness2);
          this.b.remove(Long.valueOf(paramLong));
        }
      }
      else
      {
        if (localAVBusiness2 != null) {
          paramSet2.add(localAVBusiness2);
        }
        paramSet1.add(localAVBusiness1);
        this.b.put(Long.valueOf(paramLong), localAVBusiness1);
      }
    }
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext())
    {
      localObject1 = (AVBusiness)paramSet2.next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loss focus[");
        ((StringBuilder)localObject2).append(((AVBusiness)localObject1).a());
        ((StringBuilder)localObject2).append("]");
        QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject2).toString());
      }
      ((AVBusiness)localObject1).a();
    }
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext())
    {
      paramSet2 = (AVBusiness)paramSet1.next();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gain focus[");
        ((StringBuilder)localObject1).append(paramSet2.a());
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject1).toString());
      }
      paramSet2.b();
    }
  }
  
  private void a(AVBusiness paramAVBusiness)
  {
    Iterator localIterator = AVBizUtils.a(paramAVBusiness.a()).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      ((TreeSet)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).add(paramAVBusiness);
    }
  }
  
  private void a(AVBusiness paramAVBusiness, boolean paramBoolean)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet(this.c.values());
    Iterator localIterator = AVBizUtils.a(paramAVBusiness.a()).iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      if (paramBoolean)
      {
        this.b.remove(Long.valueOf(l));
      }
      else
      {
        if (this.b.containsKey(Long.valueOf(l))) {
          localHashSet1.add(this.b.get(Long.valueOf(l)));
        }
        this.b.put(Long.valueOf(l), paramAVBusiness);
        localHashSet2.removeAll(new HashSet((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))));
      }
    }
    long l = 3L;
    if (!paramBoolean) {
      l = 0x3 ^ paramAVBusiness.a();
    }
    a(l, localHashSet2, localHashSet1);
  }
  
  private void b(AVBusiness paramAVBusiness)
  {
    Iterator localIterator = AVBizUtils.a(paramAVBusiness.a()).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      ((TreeSet)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l))).remove(paramAVBusiness);
    }
  }
  
  public String a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!AVBizUtils.a(paramString))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkAVFocus invalid business name[");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("]");
          QLog.e("AVBizPriorityManager", 1, ((StringBuilder)localObject1).toString());
          return "未知的业务";
        }
        if (this.c.containsKey(paramString))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkAVFocus in queue, name[");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (AVBusiness)this.c.get(paramString);
          localObject2 = AVBizUtils.a(((AVBusiness)localObject1).a()).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            l = ((Long)((Iterator)localObject2).next()).longValue();
            paramString = (AVBusiness)this.b.get(Long.valueOf(l));
            if ((paramString != null) && (!paramString.equals(localObject1)))
            {
              paramString = paramString.a();
              return paramString;
            }
            return "true";
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkAVFocus, name[");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("]");
          QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject2 = new AVBusiness(paramString, "");
        Iterator localIterator = AVBizUtils.a(((AVBusiness)localObject2).a()).iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        l = ((Long)localIterator.next()).longValue();
        localObject1 = (AVBusiness)this.b.get(Long.valueOf(l));
        if ((localObject1 != null) && (((AVBusiness)localObject1).a((AVBusiness)localObject2)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("name[");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append("], focusBusiness[");
            ((StringBuilder)localObject2).append(((AVBusiness)localObject1).a());
            ((StringBuilder)localObject2).append("], checkAVFocus[");
            ((StringBuilder)localObject2).append(false);
            ((StringBuilder)localObject2).append("], type[");
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((AVBusiness)localObject1).a();
          return paramString;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], focusBusiness[");
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((AVBusiness)localObject1).a();
      }
      finally
      {
        long l;
        StringBuilder localStringBuilder;
        continue;
        throw paramString;
        continue;
        Object localObject1 = "null";
        continue;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("], checkAVFocus[");
      localStringBuilder.append(true);
      localStringBuilder.append("], type[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("AVBizPriorityManager", 2, localStringBuilder.toString());
    }
    return "true";
  }
  
  public String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (!AVBizUtils.a(paramString1))
        {
          paramString2 = new StringBuilder();
          paramString2.append("requestAVFocus invalid business name[");
          paramString2.append(paramString1);
          paramString2.append("]");
          QLog.e("AVBizPriorityManager", 1, paramString2.toString());
          return "未知的业务";
        }
        if (this.c.containsKey(paramString1))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("requestAVFocus repeat, name[");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append("], processName[");
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
          }
          localObject = (AVBusiness)this.c.get(paramString1);
          localIterator = AVBizUtils.a(((AVBusiness)localObject).a()).iterator();
          if (localIterator.hasNext())
          {
            l = ((Long)localIterator.next()).longValue();
            paramString1 = (AVBusiness)this.b.get(Long.valueOf(l));
            if ((paramString1 != null) && (!paramString1.equals(localObject)))
            {
              paramString1 = paramString1.a();
              return paramString1;
            }
            return "true";
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestAVFocus, name[");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("], processName[");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("]");
          QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new AVBusiness(paramString1, paramString2);
        this.c.put(paramString1, localObject);
        a((AVBusiness)localObject);
        Iterator localIterator = AVBizUtils.a(((AVBusiness)localObject).a()).iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        l = ((Long)localIterator.next()).longValue();
        paramString2 = (AVBusiness)this.b.get(Long.valueOf(l));
        if ((paramString2 != null) && (paramString2.a((AVBusiness)localObject)))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("name[");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append("], focusBusiness[");
            ((StringBuilder)localObject).append(paramString2.a());
            ((StringBuilder)localObject).append("], requestAVFocus[");
            ((StringBuilder)localObject).append(false);
            ((StringBuilder)localObject).append("], type[");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
          }
          paramString1 = paramString2.a();
          return paramString1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("name[");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("], focusBusiness[");
        if (paramString2 == null) {
          continue;
        }
        paramString2 = paramString2.a();
      }
      finally
      {
        Object localObject;
        long l;
        StringBuilder localStringBuilder;
        continue;
        throw paramString1;
        continue;
        paramString2 = "null";
        continue;
      }
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], requestAVFocus[");
      localStringBuilder.append(true);
      localStringBuilder.append("], type[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("AVBizPriorityManager", 2, localStringBuilder.toString());
    }
    a((AVBusiness)localObject, false);
    return "true";
  }
  
  public HashMap<Long, String> a()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        localHashMap.put(Long.valueOf(l), ((AVBusiness)this.b.get(Long.valueOf(l))).a());
      }
      return localHashMap;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public HashSet<String> a()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.c.keySet());
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject;
      if (!AVBizUtils.a(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("abandonAVFocus invalid business name[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.e("AVBizPriorityManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (!this.c.containsKey(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("abandonAVFocus, business[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("] never request, no need to abandon");
          QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("abandonAVFocus, name[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
      }
      AVBusiness localAVBusiness1 = (AVBusiness)this.c.get(paramString);
      this.c.remove(paramString);
      b(localAVBusiness1);
      Iterator localIterator = AVBizUtils.a(localAVBusiness1.a()).iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        AVBusiness localAVBusiness2 = (AVBusiness)this.b.get(Long.valueOf(l));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("abandonAVFocus name[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], focusBusiness[");
          if (localAVBusiness2 == null) {
            localObject = "null";
          } else {
            localObject = localAVBusiness2.a();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("], type[");
          localStringBuilder.append(l);
          localStringBuilder.append("]");
          QLog.i("AVBizPriorityManager", 2, localStringBuilder.toString());
        }
        if (localAVBusiness1.equals(localAVBusiness2)) {
          a(localAVBusiness1, true);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizPriorityManager
 * JD-Core Version:    0.7.0.1
 */