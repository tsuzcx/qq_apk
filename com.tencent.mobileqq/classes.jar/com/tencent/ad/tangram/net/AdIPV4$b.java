package com.tencent.ad.tangram.net;

import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.ipc.AdIPCManager.a;
import com.tencent.ad.tangram.process.AdProcessManager;

final class AdIPV4$b
  implements AdIPCManager.a
{
  static final String ACTION = "GET_IPV4";
  static final String KEY_IPV4_ADDRESS = "IPV4_ADDRESS";
  
  public AdIPV4$b()
  {
    AdIPCManager.INSTANCE.register("GET_IPV4", this);
  }
  
  public AdIPV4.a getCacheByIPC()
  {
    Object localObject = send(null);
    if (localObject == null) {}
    do
    {
      do
      {
        return null;
      } while ((!((AdIPCManager.Result)localObject).success) || (((AdIPCManager.Result)localObject).bundle == null) || (!((AdIPCManager.Result)localObject).bundle.containsKey("IPV4_ADDRESS")));
      localObject = ((AdIPCManager.Result)localObject).bundle.getSerializable("IPV4_ADDRESS");
    } while ((localObject == null) || (!(localObject instanceof AdIPV4.a)));
    return (AdIPV4.a)AdIPV4.a.class.cast(localObject);
  }
  
  public AdIPCManager.Result receive(AdIPCManager.Params paramParams)
  {
    if (!AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) {
      return null;
    }
    paramParams = new Bundle();
    paramParams.putSerializable("IPV4_ADDRESS", AdIPV4.INSTANCE.getCache());
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    localResult.success = true;
    localResult.bundle = paramParams;
    return localResult;
  }
  
  public AdIPCManager.Result send(AdIPCManager.Params paramParams)
  {
    return AdIPCManager.INSTANCE.send("GET_IPV4", paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4.b
 * JD-Core Version:    0.7.0.1
 */