package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class IlinkServiceImpl$1
  extends IIlinkServiceCallback.a
{
  IlinkServiceImpl$1(IlinkServiceImpl paramIlinkServiceImpl) {}
  
  public void OnCommonFunctionCallback(String paramString, byte[] arg2)
  {
    int i = -1;
    try
    {
      int k = paramString.hashCode();
      int j = 0;
      switch (k)
      {
      case -68026435: 
        if (paramString.equals("onUploadLogComplete")) {
          i = 4;
        }
        break;
      case -740831827: 
        if (paramString.equals("onGetDeviceShadow")) {
          i = 0;
        }
        break;
      case -839542850: 
        if (paramString.equals("onDeviceShadowUpdate")) {
          i = 2;
        }
        break;
      case -902085954: 
        if (paramString.equals("onUpdateDeviceShadow")) {
          i = 1;
        }
        break;
      case -2048132833: 
        if (paramString.equals("onImLoginComplete")) {
          i = 3;
        }
        break;
      }
      for (;;)
      {
        Object localObject;
        Integer localInteger;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  ??? = af.a();
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("not supported callback function:");
                  ((StringBuilder)localObject).append(paramString);
                  ???.d("IlinkServiceImpl", ((StringBuilder)localObject).toString(), new Object[0]);
                  return;
                }
                ??? = a.i.a(???);
                paramString = IlinkServiceImpl.access$500(this.a);
                i = j;
                try
                {
                  while (i < IlinkServiceImpl.access$500(this.a).size())
                  {
                    ((x)IlinkServiceImpl.access$500(this.a).get(i)).b(???.c());
                    i += 1;
                  }
                  return;
                }
                finally {}
              }
              paramString = a.g.a(???);
              if (!IlinkServiceImpl.access$900(this.a).containsKey(paramString.c()))
              {
                ??? = af.a();
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("im session not exit call create first appid:");
                ((StringBuilder)localObject).append(paramString.c());
                ???.d("IlinkServiceImpl", ((StringBuilder)localObject).toString(), new Object[0]);
                return;
              }
              ((ab)IlinkServiceImpl.access$900(this.a).get(paramString.c())).a(paramString.e());
              return;
            }
            paramString = a.e.a(???);
            if (!IlinkServiceImpl.access$900(this.a).containsKey(paramString.c()))
            {
              ??? = af.a();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("im session not exit call create first appid:");
              ((StringBuilder)localObject).append(paramString.c());
              ???.d("IlinkServiceImpl", ((StringBuilder)localObject).toString(), new Object[0]);
              return;
            }
            ((ab)IlinkServiceImpl.access$900(this.a).get(paramString.c())).a(paramString.e().toByteArray());
            return;
          }
          paramString = a.h.a(???);
          if (!IlinkServiceImpl.access$900(this.a).containsKey(paramString.c()))
          {
            ??? = af.a();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("im session not exit call create first appid:");
            ((StringBuilder)localObject).append(paramString.c());
            ???.d("IlinkServiceImpl", ((StringBuilder)localObject).toString(), new Object[0]);
            return;
          }
          synchronized (IlinkServiceImpl.access$400(this.a))
          {
            localObject = IlinkServiceImpl.access$400(this.a).keySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              localInteger = (Integer)((Iterator)localObject).next();
              if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramString.e())
              {
                IlinkServiceImpl.access$400(this.a).remove(localInteger);
                ((ab)IlinkServiceImpl.access$900(this.a).get(paramString.c())).b(localInteger.intValue(), paramString.g(), paramString.i().toByteArray());
                return;
              }
            }
            return;
          }
        }
        paramString = a.f.a(???);
        if (!IlinkServiceImpl.access$900(this.a).containsKey(paramString.c()))
        {
          ??? = af.a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("im session not exit call create first appid:");
          ((StringBuilder)localObject).append(paramString.c());
          ???.d("IlinkServiceImpl", ((StringBuilder)localObject).toString(), new Object[0]);
          return;
        }
        synchronized (IlinkServiceImpl.access$400(this.a))
        {
          localObject = IlinkServiceImpl.access$400(this.a).keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localInteger = (Integer)((Iterator)localObject).next();
            if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramString.e())
            {
              IlinkServiceImpl.access$400(this.a).remove(localInteger);
              ((ab)IlinkServiceImpl.access$900(this.a).get(paramString.c())).a(localInteger.intValue(), paramString.g(), paramString.i().toByteArray());
              return;
            }
          }
          return;
        }
      }
    }
    catch (InvalidProtocolBufferException paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
  
  public void OnRequestUploadLogfiles(String paramString, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).b(paramArrayOfByte);
  }
  
  public void onAppSessionTimeout(String paramString)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      af localaf = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      localaf.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).j();
  }
  
  public void onCancelOAuthComplete(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      ??? = af.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Tdi session not exit call create first appid:");
      ((StringBuilder)localObject2).append(paramString);
      ((af)???).d("IlinkServiceImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
      return;
    }
    synchronized (IlinkServiceImpl.access$400(this.a))
    {
      localObject2 = IlinkServiceImpl.access$400(this.a).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramInt1)
        {
          IlinkServiceImpl.access$400(this.a).remove(localInteger);
          ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).b(localInteger.intValue(), paramInt2);
          return;
        }
      }
      paramString = af.a();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("task map not has svr task:");
      ((StringBuilder)???).append(paramInt1);
      ((StringBuilder)???).append(" maybe already canceled!");
      paramString.c("IlinkServiceImpl", ((StringBuilder)???).toString(), new Object[0]);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onCheckLoginQrCode(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).e(paramInt, paramArrayOfByte);
  }
  
  public void onCloneMultiProcessTdiSession(int paramInt, String paramString)
  {
    ap localap = null;
    int i = 0;
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      if (IlinkServiceImpl.access$200(this.a).containsKey(paramString))
      {
        ??? = af.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Tdi session map already has session for appid:");
        localStringBuilder.append(paramString);
        ((af)???).d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
        af.a().d("IlinkServiceImpl", "There must be something wrong", new Object[0]);
      }
      else
      {
        localap = new ap(paramString, true);
        IlinkServiceImpl.access$200(this.a).put(paramString, localap);
      }
    }
    else
    {
      ??? = af.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to create clone tdi session:");
      localStringBuilder.append(paramInt);
      ((af)???).d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
    }
    synchronized (IlinkServiceImpl.access$300(this.a))
    {
      while (i < IlinkServiceImpl.access$300(this.a).size())
      {
        ((ac)IlinkServiceImpl.access$300(this.a).get(i)).a(paramInt, paramString, localap);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onDestroyMultiProcessTdiSession(String paramString)
  {
    af.a().a("IlinkServiceImpl", "There is something wrong for the master tdi session and this clone session has been destroy!", new Object[0]);
    if (IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      if (((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).f())
      {
        ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).k();
        IlinkServiceImpl.access$200(this.a).remove(paramString);
        return;
      }
      localaf = af.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("it is not a clone session error:");
      localStringBuilder.append(paramString);
      localaf.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    af localaf = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("it is not in tdi session map:");
    localStringBuilder.append(paramString);
    localaf.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onFaceExtVerifyComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).b(paramInt, paramArrayOfByte);
  }
  
  public void onFaceRecognizeComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).a(paramInt, paramArrayOfByte);
  }
  
  public void onFaceRecognizeConfigComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).f(paramInt, paramArrayOfByte);
  }
  
  public void onFinishGetStrategy()
  {
    Vector localVector = IlinkServiceImpl.access$500(this.a);
    int i = 0;
    try
    {
      while (i < IlinkServiceImpl.access$500(this.a).size())
      {
        ((x)IlinkServiceImpl.access$500(this.a).get(i)).c();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onGetAppPushTokenComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    af.a().d("IlinkServiceImpl", "aidl api not longger used!", new Object[0]);
  }
  
  public void onGetLoginQrCodeComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).d(paramInt, paramArrayOfByte);
  }
  
  public void onGetOAuthCodeComplete(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Tdi session not exit call create first appid:");
      ((StringBuilder)???).append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", ((StringBuilder)???).toString(), new Object[0]);
      return;
    }
    synchronized (IlinkServiceImpl.access$400(this.a))
    {
      Iterator localIterator = IlinkServiceImpl.access$400(this.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramInt1)
        {
          IlinkServiceImpl.access$400(this.a).remove(localInteger);
          ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).c(localInteger.intValue(), paramInt2, paramArrayOfByte);
          return;
        }
      }
      paramString = af.a();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("task map not has svr task:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" maybe already canceled!");
      paramString.c("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onLoginComplete(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = af.a();
    paramString = new StringBuilder();
    paramString.append("old api Receive onlogin complete:");
    paramString.append(paramInt);
    paramArrayOfByte.a("IlinkServiceImpl", paramString.toString(), new Object[0]);
  }
  
  public void onLogoutComplete(String paramString, int paramInt)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      af localaf = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      localaf.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).a(paramInt);
  }
  
  public void onNetStatusChanged(int paramInt)
  {
    Vector localVector = IlinkServiceImpl.access$500(this.a);
    int i = 0;
    try
    {
      while (i < IlinkServiceImpl.access$500(this.a).size())
      {
        ((x)IlinkServiceImpl.access$500(this.a).get(i)).a(paramInt);
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onNewGetAppPushTokenComplete(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Tdi session not exit call create first appid:");
      ((StringBuilder)???).append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", ((StringBuilder)???).toString(), new Object[0]);
      return;
    }
    synchronized (IlinkServiceImpl.access$400(this.a))
    {
      Iterator localIterator = IlinkServiceImpl.access$400(this.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramInt1)
        {
          IlinkServiceImpl.access$400(this.a).remove(localInteger);
          ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).b(localInteger.intValue(), paramInt2, paramArrayOfByte);
          return;
        }
      }
      paramString = af.a();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("task map not has svr task:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" maybe already canceled!");
      paramString.c("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onNewLoginComplete(int paramInt1, int paramInt2, byte[] arg3, String paramString)
  {
    int i = 0;
    if (paramInt1 == 0)
    {
      IlinkServiceImpl.access$602(this.a, ???);
      IlinkServiceImpl.access$702(this.a, paramString);
    }
    else
    {
      IlinkServiceImpl.access$602(this.a, new byte[0]);
      IlinkServiceImpl.access$702(this.a, "");
    }
    ??? = af.a();
    paramString = new StringBuilder();
    paramString.append("Receive onnewlogin complete:");
    paramString.append(paramInt1);
    ???.a("IlinkServiceImpl", paramString.toString(), new Object[0]);
    ??? = v.a();
    paramString = new StringBuilder();
    paramString.append(IlinkServiceImpl.access$800(this.a));
    paramString.append(" Receive onnewlogin complete:");
    paramString.append(paramInt1);
    ???.a(0, "IlinkServiceImpl", paramString.toString());
    synchronized (IlinkServiceImpl.access$500(this.a))
    {
      while (i < IlinkServiceImpl.access$500(this.a).size())
      {
        ((x)IlinkServiceImpl.access$500(this.a).get(i)).a(paramInt1, paramInt2, IlinkServiceImpl.access$600(this.a), IlinkServiceImpl.access$700(this.a));
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onReceiveAppMessage(String paramString, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).a(paramArrayOfByte);
  }
  
  public void onReceiveAppResponse(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Tdi session not exit call create first appid:");
      ((StringBuilder)???).append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", ((StringBuilder)???).toString(), new Object[0]);
      return;
    }
    synchronized (IlinkServiceImpl.access$400(this.a))
    {
      Iterator localIterator = IlinkServiceImpl.access$400(this.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (((Integer)IlinkServiceImpl.access$400(this.a).get(localInteger)).intValue() == paramInt1)
        {
          IlinkServiceImpl.access$400(this.a).remove(localInteger);
          ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).a(localInteger.intValue(), paramInt2, paramArrayOfByte);
          return;
        }
      }
      paramString = af.a();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("task map not has svr task:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" maybe already canceled!");
      paramString.c("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onReceiveMessage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ??? = af.a();
    int i = 0;
    ((af)???).a("IlinkServiceImpl", "onReceiveMessage!", new Object[0]);
    synchronized (IlinkServiceImpl.access$500(this.a))
    {
      while (i < IlinkServiceImpl.access$500(this.a).size())
      {
        ((x)IlinkServiceImpl.access$500(this.a).get(i)).a(paramString1, paramString2, paramString3, paramString4, paramInt);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void onReceiveMultiProcessCloneTicket(int paramInt, String paramString1, String paramString2)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString1))
    {
      paramString2 = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString1);
      paramString2.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString1)).a(paramInt, paramString2);
  }
  
  public void onSendMsgResult(int paramInt, String arg2)
  {
    int i;
    synchronized (IlinkServiceImpl.access$1000(this.a))
    {
      Iterator localIterator = IlinkServiceImpl.access$1000(this.a).keySet().iterator();
      int j;
      Integer localInteger;
      do
      {
        boolean bool = localIterator.hasNext();
        j = 0;
        if (!bool) {
          break;
        }
        localInteger = (Integer)localIterator.next();
      } while (!((String)IlinkServiceImpl.access$1000(this.a).get(localInteger)).equals(???));
      i = localInteger.intValue();
      IlinkServiceImpl.access$1000(this.a).remove(localInteger);
      if (i == 0) {
        return;
      }
      synchronized (IlinkServiceImpl.access$500(this.a))
      {
        while (j < IlinkServiceImpl.access$500(this.a).size())
        {
          ((x)IlinkServiceImpl.access$500(this.a).get(j)).a(paramInt, i);
          j += 1;
        }
        return;
      }
    }
  }
  
  public void onTdiLoginComplete(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!IlinkServiceImpl.access$200(this.a).containsKey(paramString))
    {
      paramArrayOfByte = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session not exit call create first appid:");
      localStringBuilder.append(paramString);
      paramArrayOfByte.d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      return;
    }
    ((ap)IlinkServiceImpl.access$200(this.a).get(paramString)).c(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */