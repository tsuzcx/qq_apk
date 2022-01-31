package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import ppe;

public class HostCacheManager
{
  private static HostCacheManager jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager = null;
  private final int jdField_a_of_type_Int = 128;
  private HostCacheManager.Cache jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager$Cache = new HostCacheManager.Cache(this, 128);
  
  public static HostCacheManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager == null) {
        jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager = new HostCacheManager();
      }
      HostCacheManager localHostCacheManager = jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager;
      return localHostCacheManager;
    }
    finally {}
  }
  
  public void a(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (QDLog.a()) {
      QDLog.a("dnstest", "$$$addCache[" + paramString + "]");
    }
    ppe localppe = new ppe(this, null);
    localppe.jdField_a_of_type_Long = paramLong;
    localppe.jdField_a_of_type_ArrayOfJavaNetInetAddress = paramArrayOfInetAddress;
    if (NetworkManager.isMobile()) {}
    for (paramArrayOfInetAddress = NetworkManager.getApnValue();; paramArrayOfInetAddress = NetworkManager.getBSSID())
    {
      localppe.jdField_a_of_type_JavaLangString = paramArrayOfInetAddress;
      if (this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager$Cache.containsKey(paramString)) {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager$Cache.remove(paramString);
      }
      this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsHostCacheManager$Cache.put(paramString, localppe);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager
 * JD-Core Version:    0.7.0.1
 */