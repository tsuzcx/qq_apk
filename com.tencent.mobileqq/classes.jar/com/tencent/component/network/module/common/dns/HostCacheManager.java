package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;

public class HostCacheManager
{
  private static HostCacheManager manager;
  private final int MAX_CACHE_SIZE = 128;
  private HostCacheManager.Cache<String, HostCacheManager.HostEntity> data = new HostCacheManager.Cache(this, 128);
  
  public static HostCacheManager getInstance()
  {
    try
    {
      if (manager == null) {
        manager = new HostCacheManager();
      }
      HostCacheManager localHostCacheManager = manager;
      return localHostCacheManager;
    }
    finally {}
  }
  
  public void addCache(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (QDLog.isDebugEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("$$$addCache[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QDLog.d("dnstest", ((StringBuilder)localObject).toString());
    }
    Object localObject = new HostCacheManager.HostEntity(this, null);
    ((HostCacheManager.HostEntity)localObject).expireTime = paramLong;
    ((HostCacheManager.HostEntity)localObject).address = paramArrayOfInetAddress;
    if (NetworkManager.isMobile()) {
      paramArrayOfInetAddress = NetworkManager.getApnValue();
    } else {
      paramArrayOfInetAddress = NetworkManager.getBSSID();
    }
    ((HostCacheManager.HostEntity)localObject).networkType = paramArrayOfInetAddress;
    if (this.data.containsKey(paramString)) {
      this.data.remove(paramString);
    }
    this.data.put(paramString, localObject);
  }
  
  public InetAddress[] getCacheItemByHost(String paramString)
  {
    HostCacheManager.HostEntity localHostEntity = (HostCacheManager.HostEntity)this.data.get(paramString);
    if (localHostEntity != null) {
      if (!localHostEntity.isValid()) {
        this.data.remove(paramString);
      } else {
        return localHostEntity.address;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager
 * JD-Core Version:    0.7.0.1
 */