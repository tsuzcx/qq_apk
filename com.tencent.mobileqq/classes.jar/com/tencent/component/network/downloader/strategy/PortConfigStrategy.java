package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PortConfigStrategy
{
  private static final String TAG = "PortConfigStrategy";
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private String mJsonConfig = null;
  private Map<String, List<Integer>> mapAvailablePorts = new HashMap();
  private Map<String, List<Integer>> mapCacheAvailablePorts = new HashMap();
  
  private List<Integer> findPortConfig(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    int j = 1;
    this.RW_LOCK.readLock().lock();
    int i = j;
    for (;;)
    {
      try
      {
        if (!this.mapCacheAvailablePorts.containsKey(paramString)) {
          continue;
        }
        i = j;
        localObject2 = (List)this.mapCacheAvailablePorts.get(paramString);
        localObject1 = localObject2;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QDLog.w("PortConfigStrategy", "findPortConfig", localThrowable);
        this.RW_LOCK.readLock().unlock();
        continue;
      }
      finally
      {
        this.RW_LOCK.readLock().unlock();
      }
      localObject2 = localObject1;
      if (i != 0) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        this.RW_LOCK.writeLock().lock();
        this.mapCacheAvailablePorts.put(paramString, localObject1);
        this.RW_LOCK.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        this.RW_LOCK.writeLock().unlock();
      }
      j = 0;
      i = j;
      localObject2 = getDominKey(paramString);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = j;
        if (this.mapAvailablePorts.containsKey(localObject2))
        {
          i = j;
          localObject2 = (List)this.mapAvailablePorts.get(localObject2);
          localObject1 = localObject2;
          i = 0;
          continue;
        }
      }
      i = 0;
      localObject1 = null;
    }
  }
  
  private String getDominKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.mDominPatterns.entrySet().iterator();
    Map.Entry localEntry;
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
      str = (String)localEntry.getKey();
    } while (!Utils.match((Pattern)localEntry.getValue(), paramString));
    for (paramString = str;; paramString = null) {
      return paramString;
    }
  }
  
  public final int changePort(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (TextUtils.isEmpty(paramString))) {
      return 80;
    }
    paramString = findPortConfig(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {}
    try
    {
      this.RW_LOCK.readLock().lock();
      int i = paramString.indexOf(new Integer(paramInt));
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      paramInt = ((Integer)paramString.get((paramInt + 1) % paramString.size())).intValue();
      return paramInt;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    finally
    {
      this.RW_LOCK.readLock().unlock();
    }
  }
  
  public final void setConfig(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.mJsonConfig))) {
      return;
    }
    if (QDLog.isInfoEnable()) {
      QDLog.i("PortConfigStrategy", "Downloader port config:" + paramString);
    }
    localHashMap1 = new HashMap();
    localHashMap2 = new HashMap();
    for (;;)
    {
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
        i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        str = localJSONArray1.getString(i);
        localArrayList = new ArrayList();
        localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
        if (localJSONArray2 == null) {
          continue;
        }
        j = 0;
      }
      catch (Exception localException)
      {
        int i;
        String str;
        ArrayList localArrayList;
        JSONArray localJSONArray2;
        int j;
        Integer localInteger;
        localException.printStackTrace();
        try
        {
          this.RW_LOCK.writeLock().lock();
          this.mJsonConfig = paramString;
          this.mapAvailablePorts.clear();
          this.mapAvailablePorts.putAll(localHashMap1);
          this.mapCacheAvailablePorts.clear();
          this.mDominPatterns.clear();
          this.mDominPatterns.putAll(localHashMap2);
          return;
        }
        finally
        {
          this.RW_LOCK.writeLock().unlock();
        }
        j += 1;
        continue;
      }
      if (j < localJSONArray2.length())
      {
        localInteger = Integer.valueOf(localJSONArray2.getJSONObject(j).getInt("port"));
        localArrayList.add(localInteger);
        if (!QDLog.isInfoEnable()) {
          continue;
        }
        QDLog.i("PortConfigStrategy", "downloader port: domain:" + str + " port:" + localInteger);
        continue;
      }
      localHashMap1.put(str, localArrayList);
      localHashMap2.put(str, Pattern.compile(str, 2));
      i += 1;
    }
  }
  
  public final boolean supportExtraPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (findPortConfig(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.PortConfigStrategy
 * JD-Core Version:    0.7.0.1
 */