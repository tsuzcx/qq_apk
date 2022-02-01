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
    boolean bool1;
    if (System.currentTimeMillis() < this.expireTime) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      String str;
      if (NetworkManager.isMobile()) {
        str = NetworkManager.getApnValue();
      } else {
        str = NetworkManager.getBSSID();
      }
      if (str == null) {
        return false;
      }
      bool2 = str.equalsIgnoreCase(this.networkType);
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager.HostEntity
 * JD-Core Version:    0.7.0.1
 */