package com.tencent.falco.base.libapi.hostproxy;

import android.util.SparseArray;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface HostProxyInterface
  extends ServiceBaseInterface
{
  public abstract SparseArray<String> getBizCommitData(HostProxyInterface.BizCommitScene paramBizCommitScene);
  
  public abstract ClickEventInterface getClickEventInterface();
  
  public abstract HostAppResInterface getHostAppResInterface();
  
  public abstract HostLoginInterface getLoginInterface();
  
  public abstract HostReportInterface getReportInterface();
  
  public abstract SdkEventInterface getSdkEventInterface();
  
  public abstract SdkInfoInterface getSdkInfoInterface();
  
  public abstract String isUserHostBeacon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.HostProxyInterface
 * JD-Core Version:    0.7.0.1
 */