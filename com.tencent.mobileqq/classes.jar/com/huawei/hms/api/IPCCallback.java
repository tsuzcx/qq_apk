package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c.a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import com.huawei.hms.support.log.HMSLog;

public class IPCCallback
  extends c.a
{
  private final Class<? extends IMessageEntity> a;
  private final DatagramTransport.a b;
  
  public IPCCallback(Class<? extends IMessageEntity> paramClass, DatagramTransport.a parama)
  {
    this.a = paramClass;
    this.b = parama;
  }
  
  public void call(b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.a)))
    {
      e locale = a.a(paramb.c());
      Object localObject1 = null;
      Object localObject2;
      if (paramb.b() > 0)
      {
        localObject2 = newResponseInstance();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          locale.a(paramb.a(), (IMessageEntity)localObject2);
          localObject1 = localObject2;
        }
      }
      if (paramb.b != null)
      {
        localObject2 = new ResponseHeader();
        locale.a(paramb.b, (IMessageEntity)localObject2);
        this.b.a(((ResponseHeader)localObject2).getStatusCode(), localObject1);
        return;
      }
      this.b.a(0, localObject1);
      return;
    }
    HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
    throw new RemoteException();
  }
  
  protected IMessageEntity newResponseInstance()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      try
      {
        localObject = (IMessageEntity)((Class)localObject).newInstance();
        return localObject;
      }
      catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("In newResponseInstance, instancing exception.");
      localStringBuilder.append(localIllegalAccessException.getMessage());
      HMSLog.e("IPCCallback", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.IPCCallback
 * JD-Core Version:    0.7.0.1
 */