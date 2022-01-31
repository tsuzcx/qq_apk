package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.NetworkManager;
import java.net.InetAddress;

class HostCacheManager$HostEntity
{
  public InetAddress[] address = null;
  public long expireTime = 0L;
  public String networkType = null;
  
  private HostCacheManager$HostEntity(HostCacheManager paramHostCacheManager) {}
  
  public boolean isValid()
  {
    boolean bool;
    if (System.currentTimeMillis() < this.expireTime)
    {
      bool = true;
      if (!bool) {
        return bool;
      }
      if (!NetworkManager.isMobile()) {
        break label38;
      }
    }
    label38:
    for (String str = NetworkManager.getApnValue();; str = NetworkManager.getBSSID())
    {
      if (str != null) {
        break label45;
      }
      return false;
      bool = false;
      break;
    }
    label45:
    return str.equalsIgnoreCase(this.networkType);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager.HostEntity
 * JD-Core Version:    0.7.0.1
 */