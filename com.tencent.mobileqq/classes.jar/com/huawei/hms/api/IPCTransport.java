package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import com.huawei.hms.support.log.HMSLog;

public class IPCTransport
  implements DatagramTransport
{
  private final String a;
  private final IMessageEntity b;
  private final Class<? extends IMessageEntity> c;
  private int d;
  
  public IPCTransport(String paramString, IMessageEntity paramIMessageEntity, Class<? extends IMessageEntity> paramClass)
  {
    this.a = paramString;
    this.b = paramIMessageEntity;
    this.c = paramClass;
  }
  
  public IPCTransport(String paramString, IMessageEntity paramIMessageEntity, Class<? extends IMessageEntity> paramClass, int paramInt)
  {
    this.a = paramString;
    this.b = paramIMessageEntity;
    this.c = paramClass;
    this.d = paramInt;
  }
  
  private int a(ApiClient paramApiClient, c paramc)
  {
    b localb;
    if ((paramApiClient instanceof HuaweiApiClientImpl))
    {
      localb = new b(this.a, ProtocolNegotiate.getInstance().getVersion());
      e locale = a.a(localb.c());
      localb.a(locale.a(this.b, new Bundle()));
      RequestHeader localRequestHeader = new RequestHeader();
      localRequestHeader.setAppID(paramApiClient.getAppID());
      localRequestHeader.setPackageName(paramApiClient.getPackageName());
      localRequestHeader.setSdkVersion(50000301);
      localRequestHeader.setApiNameList(((HuaweiApiClientImpl)paramApiClient).getApiNameList());
      localRequestHeader.setSessionId(paramApiClient.getSessionId());
      localRequestHeader.setApiLevel(this.d);
      localb.b = locale.a(localRequestHeader, new Bundle());
      try
      {
        paramApiClient = (HuaweiApiClientImpl)paramApiClient;
        if (paramApiClient.getService() == null)
        {
          HMSLog.e("IPCTransport", "HuaweiApiClient is not binded to service yet.");
          return 907135001;
        }
        paramApiClient.getService().a(localb, paramc);
        return 0;
      }
      catch (Exception paramApiClient)
      {
        HMSLog.e("IPCTransport", "sync call ex:" + paramApiClient);
        return 907135001;
      }
    }
    if ((paramApiClient instanceof AidlApiClient))
    {
      paramApiClient = (AidlApiClient)paramApiClient;
      int i = ProtocolNegotiate.getInstance().getVersion();
      localb = new b(this.a, i);
      localb.a(a.a(localb.c()).a(this.b, new Bundle()));
      try
      {
        paramApiClient.getService().a(localb, paramc);
        return 0;
      }
      catch (Exception paramApiClient)
      {
        HMSLog.e("IPCTransport", "sync call ex:" + paramApiClient);
        return 907135001;
      }
    }
    return 907135001;
  }
  
  public final void post(ApiClient paramApiClient, DatagramTransport.a parama)
  {
    send(paramApiClient, parama);
  }
  
  public final void send(ApiClient paramApiClient, DatagramTransport.a parama)
  {
    int i = a(paramApiClient, new IPCCallback(this.c, parama));
    if (i != 0) {
      parama.a(i, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.IPCTransport
 * JD-Core Version:    0.7.0.1
 */