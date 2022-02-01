package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.util.ArrayList;
import java.util.Collection;
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
import org.apache.http.HttpRequest;

public class ConfigKeepAliveStrategy
  implements KeepAliveStrategy
{
  private static final String CONFIG_SPLIT = ",";
  private static final String DEFAULT_KP_DOMAIN_CONFIG = "m.qpic.cn,a[0-9].qpic.cn";
  private static final String TAG = "ConfigKeepAliveStrategy";
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private List<String> mKpDomainCacheList = new ArrayList();
  private List<String> mKpDomainRegularList = new ArrayList();
  private String mStrCurrConfig;
  
  public final KeepAliveStrategy.KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (TextUtils.isEmpty(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    if (!supportKeepAlive(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    boolean bool = HttpUtil.containsProxy(paramHttpRequest, paramRequestOptions);
    int i = Config.photoDownloadKeepAliveConfig();
    if (bool)
    {
      int j = Config.photoDownloadKeepAliveProxyConfig();
      if (j != -1) {
        i = j;
      }
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return KeepAliveStrategy.KeepAlive.IGNORE;
      }
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    return KeepAliveStrategy.KeepAlive.ENABLE;
  }
  
  public void setConfig(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals(this.mStrCurrConfig)) {
        return;
      }
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("keep alive domain:");
        ((StringBuilder)localObject).append(paramString);
        QDLog.i("ConfigKeepAliveStrategy", ((StringBuilder)localObject).toString());
      }
      Object localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      try
      {
        String[] arrayOfString = paramString.split(",");
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            if (!TextUtils.isEmpty(str))
            {
              ((List)localObject).add(str);
              localHashMap.put(str, Pattern.compile(str, 2));
            }
            i += 1;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        try
        {
          this.RW_LOCK.writeLock().lock();
          this.mStrCurrConfig = paramString;
          this.mKpDomainRegularList.clear();
          this.mKpDomainRegularList.addAll((Collection)localObject);
          this.mKpDomainCacheList.clear();
          this.mDominPatterns.clear();
          this.mDominPatterns.putAll(localHashMap);
          return;
        }
        finally
        {
          this.RW_LOCK.writeLock().unlock();
        }
      }
    }
  }
  
  public final boolean supportKeepAlive(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    try
    {
      this.RW_LOCK.readLock().lock();
      bool1 = this.mKpDomainCacheList.contains(paramString);
      if (bool1)
      {
        this.RW_LOCK.readLock().unlock();
        return true;
      }
      Iterator localIterator = this.mDominPatterns.entrySet().iterator();
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        bool1 = Utils.match((Pattern)this.mDominPatterns.get(str), paramString);
      } while (!bool1);
      bool1 = true;
      this.RW_LOCK.readLock().unlock();
      if (bool1) {
        try
        {
          this.RW_LOCK.writeLock().lock();
          this.mKpDomainCacheList.add(paramString);
          return bool1;
        }
        finally
        {
          this.RW_LOCK.writeLock().unlock();
        }
      }
      return bool1;
    }
    finally
    {
      this.RW_LOCK.readLock().unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */