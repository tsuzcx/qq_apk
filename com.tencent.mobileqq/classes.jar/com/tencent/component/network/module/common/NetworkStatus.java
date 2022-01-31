package com.tencent.component.network.module.common;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.DNS;
import pip;

public class NetworkStatus
{
  private static volatile NetworkStatus jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus;
  private final Context jdField_a_of_type_AndroidContentContext;
  private NetworkUtils.DNS jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS;
  
  private NetworkStatus(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a();
  }
  
  public static NetworkStatus a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus != null) {
      return jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus;
    }
    try
    {
      if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus != null)
      {
        paramContext = jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus;
        return paramContext;
      }
    }
    finally {}
    paramContext = new NetworkStatus(paramContext);
    jdField_a_of_type_ComTencentComponentNetworkModuleCommonNetworkStatus = paramContext;
    return paramContext;
  }
  
  private void a()
  {
    b();
    pip localpip = new pip(this);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(localpip, localIntentFilter);
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS = NetworkUtils.getDNS(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public NetworkUtils.DNS a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsNetworkUtils$DNS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkStatus
 * JD-Core Version:    0.7.0.1
 */