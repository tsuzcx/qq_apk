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
  private static final String TAG = "AVBizPriorityManager";
  private static volatile AVBizPriorityManager sInstance;
  private final HashMap<String, AVBusiness> mBusinessMap = new HashMap();
  private final HashMap<Long, AVBusiness> mFocusBusinessMap = new HashMap();
  private final HashMap<Long, TreeSet<AVBusiness>> mPriorityPQMap = new HashMap();
  
  private AVBizPriorityManager()
  {
    AVBizPriorityManager.1 local1 = new AVBizPriorityManager.1(this);
    this.mPriorityPQMap.put(Long.valueOf(1L), new TreeSet(local1));
    this.mPriorityPQMap.put(Long.valueOf(2L), new TreeSet(local1));
  }
  
  private HashMap<Long, AVBusiness> competeFocus(Set<AVBusiness> paramSet)
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
        Iterator localIterator2 = AVBizUtils.convertToList(localAVBusiness1.getRequestType()).iterator();
        int j;
        long l;
        do
        {
          j = i;
          if (!localIterator2.hasNext()) {
            break;
          }
          l = ((Long)localIterator2.next()).longValue();
          Iterator localIterator3 = ((TreeSet)this.mPriorityPQMap.get(Long.valueOf(l))).iterator();
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
        localIterator1 = AVBizUtils.convertToList(localAVBusiness1.getRequestType()).iterator();
        while (localIterator1.hasNext())
        {
          l = ((Long)localIterator1.next()).longValue();
          localHashMap.put(Long.valueOf(l), localAVBusiness1);
          paramSet.removeAll(new HashSet((Collection)this.mPriorityPQMap.get(Long.valueOf(l))));
        }
      }
    }
    label256:
    return localHashMap;
  }
  
  private void dequeue(AVBusiness paramAVBusiness)
  {
    Iterator localIterator = AVBizUtils.convertToList(paramAVBusiness.getRequestType()).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      ((TreeSet)this.mPriorityPQMap.get(Long.valueOf(l))).remove(paramAVBusiness);
    }
  }
  
  private void enqueue(AVBusiness paramAVBusiness)
  {
    Iterator localIterator = AVBizUtils.convertToList(paramAVBusiness.getRequestType()).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      ((TreeSet)this.mPriorityPQMap.get(Long.valueOf(l))).add(paramAVBusiness);
    }
  }
  
  public static AVBizPriorityManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new AVBizPriorityManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void onFocusChange(AVBusiness paramAVBusiness, boolean paramBoolean)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet(this.mBusinessMap.values());
    Iterator localIterator = AVBizUtils.convertToList(paramAVBusiness.getRequestType()).iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      if (paramBoolean)
      {
        this.mFocusBusinessMap.remove(Long.valueOf(l));
      }
      else
      {
        if (this.mFocusBusinessMap.containsKey(Long.valueOf(l))) {
          localHashSet1.add(this.mFocusBusinessMap.get(Long.valueOf(l)));
        }
        this.mFocusBusinessMap.put(Long.valueOf(l), paramAVBusiness);
        localHashSet2.removeAll(new HashSet((Collection)this.mPriorityPQMap.get(Long.valueOf(l))));
      }
    }
    long l = 3L;
    if (!paramBoolean) {
      l = 0x3 ^ paramAVBusiness.getRequestType();
    }
    updateFocusMap(l, localHashSet2, localHashSet1);
  }
  
  private void updateFocusMap(long paramLong, Set<AVBusiness> paramSet1, Set<AVBusiness> paramSet2)
  {
    Object localObject1 = competeFocus(paramSet1);
    paramSet1 = new HashSet();
    Object localObject2 = AVBizUtils.convertToList(paramLong).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramLong = ((Long)((Iterator)localObject2).next()).longValue();
      AVBusiness localAVBusiness1 = (AVBusiness)((HashMap)localObject1).get(Long.valueOf(paramLong));
      AVBusiness localAVBusiness2 = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(paramLong));
      if (localAVBusiness1 == null)
      {
        if (localAVBusiness2 != null)
        {
          paramSet2.add(localAVBusiness2);
          this.mFocusBusinessMap.remove(Long.valueOf(paramLong));
        }
      }
      else
      {
        if (localAVBusiness2 != null) {
          paramSet2.add(localAVBusiness2);
        }
        paramSet1.add(localAVBusiness1);
        this.mFocusBusinessMap.put(Long.valueOf(paramLong), localAVBusiness1);
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
        ((StringBuilder)localObject2).append(((AVBusiness)localObject1).getName());
        ((StringBuilder)localObject2).append("]");
        QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject2).toString());
      }
      ((AVBusiness)localObject1).lossFocus();
    }
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext())
    {
      paramSet2 = (AVBusiness)paramSet1.next();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gain focus[");
        ((StringBuilder)localObject1).append(paramSet2.getName());
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject1).toString());
      }
      paramSet2.gainFocus();
    }
  }
  
  public void abandonAVFocus(String paramString)
  {
    try
    {
      Object localObject;
      if (!AVBizUtils.isValid(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("abandonAVFocus invalid business name[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.e("AVBizPriorityManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (!this.mBusinessMap.containsKey(paramString))
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
      AVBusiness localAVBusiness1 = (AVBusiness)this.mBusinessMap.get(paramString);
      this.mBusinessMap.remove(paramString);
      dequeue(localAVBusiness1);
      Iterator localIterator = AVBizUtils.convertToList(localAVBusiness1.getRequestType()).iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        AVBusiness localAVBusiness2 = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("abandonAVFocus name[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], focusBusiness[");
          if (localAVBusiness2 == null) {
            localObject = "null";
          } else {
            localObject = localAVBusiness2.getName();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("], type[");
          localStringBuilder.append(l);
          localStringBuilder.append("]");
          QLog.i("AVBizPriorityManager", 2, localStringBuilder.toString());
        }
        if (localAVBusiness1.equals(localAVBusiness2)) {
          onFocusChange(localAVBusiness1, true);
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
  
  public String checkAVFocus(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!AVBizUtils.isValid(paramString))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkAVFocus invalid business name[");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("]");
          QLog.e("AVBizPriorityManager", 1, ((StringBuilder)localObject1).toString());
          return "未知的业务";
        }
        if (this.mBusinessMap.containsKey(paramString))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkAVFocus in queue, name[");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (AVBusiness)this.mBusinessMap.get(paramString);
          localObject2 = AVBizUtils.convertToList(((AVBusiness)localObject1).getRequestType()).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            l = ((Long)((Iterator)localObject2).next()).longValue();
            paramString = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l));
            if ((paramString != null) && (!paramString.equals(localObject1)))
            {
              paramString = paramString.getName();
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
        Iterator localIterator = AVBizUtils.convertToList(((AVBusiness)localObject2).getRequestType()).iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        l = ((Long)localIterator.next()).longValue();
        localObject1 = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l));
        if ((localObject1 != null) && (((AVBusiness)localObject1).comparePriority((AVBusiness)localObject2)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("name[");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append("], focusBusiness[");
            ((StringBuilder)localObject2).append(((AVBusiness)localObject1).getName());
            ((StringBuilder)localObject2).append("], checkAVFocus[");
            ((StringBuilder)localObject2).append(false);
            ((StringBuilder)localObject2).append("], type[");
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((AVBusiness)localObject1).getName();
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
        localObject1 = ((AVBusiness)localObject1).getName();
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
  
  public HashMap<Long, String> getFocusBusiness()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.mFocusBusinessMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        localHashMap.put(Long.valueOf(l), ((AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l))).getName());
      }
      return localHashMap;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public HashSet<String> getInQueueBusiness()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.mBusinessMap.keySet());
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String requestAVFocus(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (!AVBizUtils.isValid(paramString1))
        {
          paramString2 = new StringBuilder();
          paramString2.append("requestAVFocus invalid business name[");
          paramString2.append(paramString1);
          paramString2.append("]");
          QLog.e("AVBizPriorityManager", 1, paramString2.toString());
          return "未知的业务";
        }
        if (this.mBusinessMap.containsKey(paramString1))
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
          localObject = (AVBusiness)this.mBusinessMap.get(paramString1);
          localIterator = AVBizUtils.convertToList(((AVBusiness)localObject).getRequestType()).iterator();
          if (localIterator.hasNext())
          {
            l = ((Long)localIterator.next()).longValue();
            paramString1 = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l));
            if ((paramString1 != null) && (!paramString1.equals(localObject)))
            {
              paramString1 = paramString1.getName();
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
        this.mBusinessMap.put(paramString1, localObject);
        enqueue((AVBusiness)localObject);
        Iterator localIterator = AVBizUtils.convertToList(((AVBusiness)localObject).getRequestType()).iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        l = ((Long)localIterator.next()).longValue();
        paramString2 = (AVBusiness)this.mFocusBusinessMap.get(Long.valueOf(l));
        if ((paramString2 != null) && (paramString2.comparePriority((AVBusiness)localObject)))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("name[");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append("], focusBusiness[");
            ((StringBuilder)localObject).append(paramString2.getName());
            ((StringBuilder)localObject).append("], requestAVFocus[");
            ((StringBuilder)localObject).append(false);
            ((StringBuilder)localObject).append("], type[");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("]");
            QLog.i("AVBizPriorityManager", 2, ((StringBuilder)localObject).toString());
          }
          paramString1 = paramString2.getName();
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
        paramString2 = paramString2.getName();
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
    onFocusChange((AVBusiness)localObject, false);
    return "true";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizPriorityManager
 * JD-Core Version:    0.7.0.1
 */