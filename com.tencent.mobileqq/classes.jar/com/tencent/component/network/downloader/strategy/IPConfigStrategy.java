package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class IPConfigStrategy
  implements IPStrategy
{
  private int jdField_a_of_type_Int = -1;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Map b = new HashMap();
  private Map c = new ConcurrentHashMap();
  private Map d = new HashMap();
  private Map e = new HashMap();
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = a(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        IPConfigStrategy.IPConfig localIPConfig = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(paramInt1));
        paramString = localIPConfig;
        if (localIPConfig == null)
        {
          paramString = localIPConfig;
          if (paramInt2 != -1) {
            paramString = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(paramInt2));
          }
        }
        if ((paramString == null) || (paramString.a == null) || (paramString.a.size() <= 0)) {
          break label200;
        }
        paramInt1 = paramString.b();
        paramInt2 = paramString.a.size();
        paramString = (IPInfo)paramString.a.get(paramInt1 % paramInt2);
        if (paramString == null) {
          break label200;
        }
        paramString = paramString.a;
      }
      catch (Throwable paramString)
      {
        QDLog.c("IPConfigStrategy", "resolveIP", paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
        paramString = null;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
      }
      return paramString;
      label200:
      paramString = null;
    }
  }
  
  private List a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = a(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        IPConfigStrategy.IPConfig localIPConfig = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(paramInt1));
        paramString = localIPConfig;
        if (localIPConfig == null)
        {
          paramString = localIPConfig;
          if (paramInt2 != -1) {
            paramString = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(paramInt2));
          }
        }
        if (paramString == null) {
          break label152;
        }
        paramString = paramString.a;
      }
      catch (Throwable paramString)
      {
        QDLog.c("IPConfigStrategy", "resolveIP", paramString);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
        paramString = null;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
      }
      return paramString;
      label152:
      paramString = null;
    }
  }
  
  private Map a(String paramString)
  {
    Object localObject3;
    if (TextUtils.isEmpty(paramString))
    {
      localObject3 = null;
      return localObject3;
    }
    int k = 1;
    int j = 1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
    int i = k;
    for (;;)
    {
      try
      {
        if (!this.b.containsKey(paramString)) {
          continue;
        }
        i = k;
        localObject1 = (Map)this.b.get(paramString);
        i = j;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        QDLog.c("IPConfigStrategy", "findIPConfigs", localThrowable);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
        localObject2 = null;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
      }
      localObject3 = localObject1;
      if (i != 0) {
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
        this.b.put(paramString, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
      }
      k = 0;
      j = 0;
      i = k;
      localObject1 = b(paramString);
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = k;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
        {
          i = k;
          localObject1 = (Map)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
          i = j;
          continue;
        }
      }
      Object localObject2 = null;
      i = j;
    }
  }
  
  private final void a(String paramString, Map paramMap1, Map paramMap2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap1 == null) || (paramMap2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          continue;
        }
        JSONArray localJSONArray1 = localJSONObject.names();
        if (localJSONArray1 == null) {
          continue;
        }
        int i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        String str = localJSONArray1.getString(i);
        HashMap localHashMap = new HashMap();
        JSONArray localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
        if (localJSONArray2 != null)
        {
          int j = 0;
          while (j < localJSONArray2.length())
          {
            Object localObject2 = localJSONArray2.getJSONObject(j);
            localObject1 = ((JSONObject)localObject2).getString("ip");
            int k = ((JSONObject)localObject2).getInt("port");
            Integer localInteger = Integer.valueOf(((JSONObject)localObject2).getInt("apn"));
            IPInfo localIPInfo = new IPInfo((String)localObject1, Integer.valueOf(k).intValue());
            localObject2 = (IPConfigStrategy.IPConfig)localHashMap.get(localInteger);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new IPConfigStrategy.IPConfig();
              localHashMap.put(localInteger, localObject1);
            }
            ((IPConfigStrategy.IPConfig)localObject1).a(localIPInfo);
            j += 1;
          }
        }
        Object localObject1 = (Map)paramMap1.get(str);
        if (localObject1 == null) {
          paramMap1.put(str, localHashMap);
        }
        for (;;)
        {
          paramMap2.put(str, Pattern.compile(str, 2));
          i += 1;
          break;
          ((Map)localObject1).putAll(localHashMap);
        }
        return;
      }
      catch (Throwable paramMap1)
      {
        QDLog.d("IPConfigStrategy", "exception when add ip config: " + paramString, paramMap1);
      }
    }
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      str = (String)((Map.Entry)localIterator.next()).getKey();
    } while (!Utils.match((Pattern)this.d.get(str), paramString));
    for (paramString = str;; paramString = null) {
      return paramString;
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
  }
  
  protected String a()
  {
    return "IPConfigStrategy";
  }
  
  public String a(String paramString)
  {
    return a(paramString, NetworkManager.getIspType(), this.jdField_a_of_type_Int);
  }
  
  public String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1);
  }
  
  public List a(String paramString)
  {
    return a(paramString, NetworkManager.getIspType(), this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBoolean) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int i = NetworkManager.getIspType();
    paramString1 = a(paramString1);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
    if (paramString1 != null) {}
    try
    {
      paramString1 = (IPConfigStrategy.IPConfig)paramString1.get(Integer.valueOf(i));
      if ((paramString1 != null) && (paramString1.a != null))
      {
        if (paramString1.a() < 0) {
          paramString1.a(paramString2);
        }
        if (paramString2.equals(((IPInfo)paramString1.a.get(paramString1.b() % paramString1.a.size())).a)) {
          paramString1.a(paramString1.b() + 1);
        }
      }
      paramString1 = this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock();
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QDLog.c("IPConfigStrategy", "onIPAccessResult", paramString1);
        paramString1 = this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock();
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
    }
    paramString1.unlock();
  }
  
  public final void a(Map paramMap)
  {
    if (paramMap == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (paramMap.size() != this.e.size())
        {
          i = 1;
          if (i != 0)
          {
            this.e.clear();
            this.e.putAll(paramMap);
          }
          if (i == 0) {
            break;
          }
          ??? = new HashMap();
          localObject2 = new HashMap();
          paramMap = paramMap.entrySet().iterator();
          if (!paramMap.hasNext()) {
            break label274;
          }
          localObject4 = (Map.Entry)paramMap.next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          QDLog.b(a(), "IP Config -- " + (String)localObject3 + ":" + (String)localObject4, null);
          a((String)localObject4, (Map)???, (Map)localObject2);
          continue;
        }
        localObject2 = paramMap.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label377;
        }
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        if (b((String)((Map.Entry)localObject3).getValue(), (String)this.e.get(localObject4))) {
          continue;
        }
        i = 1;
      }
      try
      {
        label274:
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.putAll((Map)???);
        this.d.clear();
        this.d.putAll((Map)localObject2);
        this.b.clear();
        this.c.clear();
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
      }
      label377:
      int i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool2 = false;
    }
    String str;
    do
    {
      return bool2;
      int i = NetworkManager.getIspType();
      str = paramString1 + "_" + i;
      if (paramString2.equals((String)this.c.get(str))) {
        return true;
      }
      Map localMap = a(paramString1);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
      bool1 = bool2;
      if (localMap != null) {}
      try
      {
        IPConfigStrategy.IPConfig localIPConfig = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(i));
        paramString1 = localIPConfig;
        if (localIPConfig == null)
        {
          paramString1 = localIPConfig;
          if (this.jdField_a_of_type_Int != -1) {
            paramString1 = (IPConfigStrategy.IPConfig)localMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
          }
        }
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (paramString1.a != null)
          {
            paramString1 = paramString1.a.iterator();
            do
            {
              bool1 = bool2;
              if (!paramString1.hasNext()) {
                break;
              }
              bool1 = paramString2.equals(((IPInfo)paramString1.next()).a);
            } while (!bool1);
            bool1 = true;
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          QDLog.c("IPConfigStrategy", "isIPValid", paramString1);
          this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
          bool1 = false;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
      }
      bool2 = bool1;
    } while (!bool1);
    this.c.put(str, paramString2);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy
 * JD-Core Version:    0.7.0.1
 */