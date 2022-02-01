package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ilink.interfaces.Profile;
import com.tencent.ilink.tdi.b.c;
import com.tencent.ilink.tdi.b.e;
import com.tencent.ilink.tdi.b.f;
import com.tencent.ilink.tdi.b.i;
import com.tencent.ilink.tdi.b.k;
import com.tencent.ilink.tdi.b.m;
import com.tencent.ilink.tdi.b.o;
import com.tencent.ilink.tdi.b.q;
import com.tencent.ilink.tdi.b.u;
import com.tencent.ilink.tdi.b.v;
import com.tencent.ilink.tdi.b.v.a;
import com.tencent.ilink.tdi.b.z;
import com.tencent.ilink.tdi.y;
import com.tencent.luggage.wxa.aq.a.a;
import com.tencent.mars.ilink.xlog.Log;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class IlinkService$2
  extends u.a
{
  IlinkService$2(IlinkService paramIlinkService) {}
  
  public String a(String paramString, IIlinkServiceCallback paramIIlinkServiceCallback)
  {
    if (IlinkService.access$300(this.a).containsKey(paramString))
    {
      paramIIlinkServiceCallback = new StringBuilder();
      paramIIlinkServiceCallback.append("caller:");
      paramIIlinkServiceCallback.append(paramString);
      paramIIlinkServiceCallback.append("already exit in map there are a hack app exit just ignore it!");
      Log.e("IlinkService", paramIIlinkServiceCallback.toString());
      return null;
    }
    String str = IlinkService.access$900(paramString);
    IlinkService.access$200(this.a).register(paramIIlinkServiceCallback, paramString);
    IlinkService.access$300(this.a).put(paramString, str);
    return str;
  }
  
  public String a(String paramString, IIlinkServiceCallback paramIIlinkServiceCallback, byte[] paramArrayOfByte)
  {
    if (IlinkService.access$300(this.a).containsKey(paramString))
    {
      paramIIlinkServiceCallback = new StringBuilder();
      paramIIlinkServiceCallback.append("caller:");
      paramIIlinkServiceCallback.append(paramString);
      paramIIlinkServiceCallback.append("already exit in map there are a hack app exit just ignore it!");
      Log.e("IlinkService", paramIIlinkServiceCallback.toString());
      return null;
    }
    paramArrayOfByte = IlinkService.access$900(paramString);
    IlinkService.access$200(this.a).register(paramIIlinkServiceCallback, paramString);
    IlinkService.access$300(this.a).put(paramString, paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return null;
    }
    return IlinkService.access$1400(this.a).a(paramString1, paramString3, paramString4, paramString5, "");
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return null;
    }
    return IlinkService.access$1400(this.a).a(paramString1, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              Log.e(paramString1, paramString2);
              return;
            }
            Log.e(paramString1, paramString2);
            return;
          }
          Log.w(paramString1, paramString2);
          return;
        }
        Log.i(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    Class localClass;
    IlinkService localIlinkService;
    byte[] arrayOfByte;
    String str;
    if (IlinkService.access$1500(this.a).u() == 1)
    {
      paramString2 = Integer.TYPE;
      localClass = Integer.TYPE;
      localIlinkService = this.a;
      arrayOfByte = IlinkService.access$1700(this.a);
      str = IlinkService.access$1800(this.a);
      localIlinkService.addDeviceCallbackTask(paramString1, "onNewLoginComplete", new Class[] { paramString2, localClass, [B.class, String.class }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), arrayOfByte, str });
    }
    if (IlinkService.access$1900(this.a))
    {
      paramString2 = Integer.TYPE;
      localClass = Integer.TYPE;
      localIlinkService = this.a;
      arrayOfByte = IlinkService.access$1700(this.a);
      str = IlinkService.access$1800(this.a);
      localIlinkService.addDeviceCallbackTask(paramString1, "onNewLoginComplete", new Class[] { paramString2, localClass, [B.class, String.class }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), arrayOfByte, str });
      return;
    }
    if (IlinkService.access$2000(this.a))
    {
      Log.d("IlinkService", "auto login is running just do nothing!");
      return;
    }
    Log.d("IlinkService", "Start auto login!");
    IlinkService.access$1400(this.a).h();
    IlinkService.access$2002(this.a, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    IlinkService.access$1400(this.a).d(paramInt);
  }
  
  public void a(String paramString1, String arg2, IIlinkServiceCallback paramIIlinkServiceCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("client unregisterCallback:");
    ((StringBuilder)localObject).append(paramString1);
    Log.e("IlinkService", ((StringBuilder)localObject).toString());
    if (!IlinkService.access$1000(this.a, paramString1, ???))
    {
      ??? = new StringBuilder();
      ???.append("caller:");
      ???.append(paramString1);
      ???.append(" is illegal");
      Log.e("IlinkService", ???.toString());
      return;
    }
    IlinkService.access$200(this.a).unregister(paramIIlinkServiceCallback);
    IlinkService.access$300(this.a).remove(paramString1);
    synchronized (IlinkService.access$100(this.a))
    {
      paramIIlinkServiceCallback = new HashSet();
      localObject = IlinkService.access$100(this.a).elements();
      IlinkService.f localf;
      while (((Enumeration)localObject).hasMoreElements())
      {
        localf = (IlinkService.f)((Enumeration)localObject).nextElement();
        if (localf.a.equals(paramString1)) {
          paramIIlinkServiceCallback.add(localf);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Going to delete tdi sessions num:");
      ((StringBuilder)localObject).append(paramIIlinkServiceCallback.size());
      Log.w("IlinkService", ((StringBuilder)localObject).toString());
      localObject = paramIIlinkServiceCallback.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (IlinkService.f)((Iterator)localObject).next();
        if (IlinkService.access$400(this.a).containsKey(localf.b))
        {
          IlinkService.access$400(this.a).remove(localf.b);
          if (IlinkService.access$500(this.a).containsKey(localf.b))
          {
            Iterator localIterator = ((Vector)IlinkService.access$500(this.a).get(localf.b)).iterator();
            while (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              IlinkService localIlinkService = this.a;
              String str2 = localf.b;
              localIlinkService.addDeviceCallbackTask(str1, "onDestroyMultiProcessTdiSession", new Class[] { String.class }, new Object[] { str2 });
            }
            IlinkService.access$500(this.a).remove(localf.b);
          }
        }
        IlinkService.access$100(this.a).remove(localf.b);
        y.a(localf.c);
      }
      paramIIlinkServiceCallback.clear();
      synchronized (IlinkService.access$500(this.a))
      {
        paramIIlinkServiceCallback = IlinkService.access$500(this.a).keys();
        while (paramIIlinkServiceCallback.hasMoreElements())
        {
          localObject = (String)paramIIlinkServiceCallback.nextElement();
          if (((Vector)IlinkService.access$500(this.a).get(localObject)).contains(paramString1)) {
            ((Vector)IlinkService.access$500(this.a).get(localObject)).remove(paramString1);
          }
        }
        paramIIlinkServiceCallback = IlinkService.access$600(this.a).keys();
        while (paramIIlinkServiceCallback.hasMoreElements())
        {
          localObject = (Integer)paramIIlinkServiceCallback.nextElement();
          if (((String)IlinkService.access$600(this.a).get(localObject)).equals(paramString1)) {
            IlinkService.access$600(this.a).remove(localObject);
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = IlinkService.access$1000(this.a, paramString1, paramString2);
    paramString2 = Integer.valueOf(0);
    if (!bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      paramString1 = Integer.TYPE;
      this.a.addServiceCallbackTask(paramString3, "onReceiveMultiProcessCloneTicket", new Class[] { paramString1, String.class, String.class }, new Object[] { Integer.valueOf(-1), paramString3, "" });
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("appid:");
      ((StringBuilder)localObject1).append(paramString3);
      ((StringBuilder)localObject1).append(" exit in map !");
      Log.d("IlinkService", ((StringBuilder)localObject1).toString());
      if (((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).a.equals(paramString1))
      {
        if (IlinkService.access$400(this.a).containsKey(paramString3))
        {
          Log.d("IlinkService", "clone ticket exit just callback");
          paramString1 = Integer.TYPE;
          localObject1 = this.a;
          localObject2 = IlinkService.access$400(this.a).get(paramString3);
          ((IlinkService)localObject1).addServiceCallbackTask(paramString3, "onReceiveMultiProcessCloneTicket", new Class[] { paramString1, String.class, String.class }, new Object[] { paramString2, paramString3, localObject2 });
          return;
        }
        Log.d("IlinkService", "clone ticket not exit try to create one!");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(paramString3);
        paramString1 = IlinkService.access$900(((StringBuilder)localObject1).toString());
        IlinkService.access$400(this.a).put(paramString3, paramString1);
        paramString1 = Integer.TYPE;
        localObject1 = this.a;
        Object localObject2 = IlinkService.access$400(this.a).get(paramString3);
        ((IlinkService)localObject1).addServiceCallbackTask(paramString3, "onReceiveMultiProcessCloneTicket", new Class[] { paramString1, String.class, String.class }, new Object[] { paramString2, paramString3, localObject2 });
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("the request appid is not for this caller:");
      paramString2.append(paramString1);
      paramString2.append(", owner:");
      paramString2.append(((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).a);
      paramString2.append(", appid:");
      paramString2.append(paramString3);
      Log.e("IlinkService", paramString2.toString());
      paramString1 = Integer.TYPE;
      this.a.addServiceCallbackTask(paramString3, "onReceiveMultiProcessCloneTicket", new Class[] { paramString1, String.class, String.class }, new Object[] { Integer.valueOf(-2), paramString3, "" });
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session for appid not exit:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
    paramString1 = Integer.TYPE;
    this.a.addServiceCallbackTask(paramString3, "onReceiveMultiProcessCloneTicket", new Class[] { paramString1, String.class, String.class }, new Object[] { Integer.valueOf(-3), paramString3, "" });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call cancel from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.f.a(paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = IlinkService.access$1000(this.a, paramString1, paramString2);
    paramString2 = Integer.valueOf(0);
    if (!bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      paramString2 = Integer.TYPE;
      this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString2, String.class }, new Object[] { Integer.valueOf(-1), paramString3 });
      return;
    }
    if (IlinkService.access$400(this.a).containsKey(paramString3))
    {
      if (((String)IlinkService.access$400(this.a).get(paramString3)).equals(paramString4))
      {
        if (IlinkService.access$500(this.a).containsKey(paramString3))
        {
          if (((Vector)IlinkService.access$500(this.a).get(paramString3)).contains(paramString1))
          {
            Log.e("IlinkService", "clone tdi sesssion already in vector!!!");
            paramString2 = Integer.TYPE;
            this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString2, String.class }, new Object[] { Integer.valueOf(-2), paramString3 });
            return;
          }
          ((Vector)IlinkService.access$500(this.a).get(paramString3)).add(paramString1);
          paramString4 = Integer.TYPE;
          this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString4, String.class }, new Object[] { paramString2, paramString3 });
          return;
        }
        Log.d("IlinkService", "add new item to map!");
        IlinkService.access$500(this.a).put(paramString3, new Vector());
        ((Vector)IlinkService.access$500(this.a).get(paramString3)).add(paramString1);
        paramString4 = Integer.TYPE;
        this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString4, String.class }, new Object[] { paramString2, paramString3 });
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("cloneticket not match for appid:");
      paramString2.append(paramString3);
      Log.e("IlinkService", paramString2.toString());
      paramString2 = Integer.TYPE;
      this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString2, String.class }, new Object[] { Integer.valueOf(-3), paramString3 });
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("cloneticket for appid not exit:");
    paramString2.append(paramString3);
    Log.e("IlinkService", paramString2.toString());
    paramString2 = Integer.TYPE;
    this.a.addDeviceCallbackTask(paramString1, "onCloneMultiProcessTdiSession", new Class[] { paramString2, String.class }, new Object[] { Integer.valueOf(-4), paramString3 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    IlinkService.access$1400(this.a).a(paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    IlinkService.access$1400(this.a).b(paramArrayOfByte);
  }
  
  public String b(String paramString, IIlinkServiceCallback paramIIlinkServiceCallback, byte[] paramArrayOfByte)
  {
    if (IlinkService.access$300(this.a).containsKey(paramString))
    {
      paramIIlinkServiceCallback = new StringBuilder();
      paramIIlinkServiceCallback.append("caller:");
      paramIIlinkServiceCallback.append(paramString);
      paramIIlinkServiceCallback.append("already exit in map there are a hack app exit just ignore it!");
      Log.e("IlinkService", paramIIlinkServiceCallback.toString());
      return null;
    }
    try
    {
      paramArrayOfByte = ag.f.a(paramArrayOfByte);
      if ((IlinkService.access$1500(this.a).e().equals(paramArrayOfByte.e())) && (IlinkService.access$1500(this.a).c() == paramArrayOfByte.c()))
      {
        paramArrayOfByte = IlinkService.access$900(paramString);
        IlinkService.access$200(this.a).register(paramIIlinkServiceCallback, paramString);
        IlinkService.access$300(this.a).put(paramString, paramArrayOfByte);
        return paramArrayOfByte;
      }
      Log.e("IlinkService", "registCallbackWithDeviceInfo not match");
      return null;
    }
    catch (InvalidProtocolBufferException paramIIlinkServiceCallback)
    {
      paramIIlinkServiceCallback.printStackTrace();
      paramIIlinkServiceCallback = new StringBuilder();
      paramIIlinkServiceCallback.append("newRegisterCallback caller:");
      paramIIlinkServiceCallback.append(paramString);
      paramIIlinkServiceCallback.append(" para error!");
      Log.e("IlinkService", paramIIlinkServiceCallback.toString());
    }
    return null;
  }
  
  public void b(String paramString1, String arg2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, ???))
    {
      ??? = new StringBuilder();
      ???.append("caller:");
      ???.append(paramString1);
      ???.append(" is illegal");
      Log.e("IlinkService", ???.toString());
      return;
    }
    synchronized (IlinkService.access$100(this.a))
    {
      if (IlinkService.access$100(this.a).containsKey(paramString3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("appid:");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append("already exit in map we should recreate the tdisession for safe!");
        Log.e("IlinkService", ((StringBuilder)localObject).toString());
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a();
        y.a(((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c);
        IlinkService.access$100(this.a).remove(paramString3);
      }
      if (IlinkService.access$1100(this.a) == null)
      {
        Log.e("IlinkService", "device not login yet wait login complete then call createTdiSession!");
        return;
      }
      Object localObject = y.a(paramString3);
      ((com.tencent.ilink.tdi.z)localObject).a(IlinkService.access$1100(this.a));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Success create tdi session for: ");
      localStringBuilder.append(paramString3);
      Log.d("IlinkService", localStringBuilder.toString());
      paramString1 = new IlinkService.f(this.a, paramString1, paramString3, (com.tencent.ilink.tdi.z)localObject);
      paramString1.d = new IlinkServiceTdiCallback(paramString3, IlinkService.access$1200(this.a));
      ((com.tencent.ilink.tdi.z)localObject).a(paramString1.d);
      IlinkService.access$100(this.a).put(paramString3, paramString1);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call cancelAppRequest from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(paramInt);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call faceRecognize from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.i("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.m.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    paramString1 = null;
    try
    {
      paramString2 = a.a.a(paramArrayOfByte);
      paramString1 = paramString2;
    }
    catch (InvalidProtocolBufferException paramString2)
    {
      paramString2.printStackTrace();
    }
    paramString2 = ag.f.a(IlinkService.access$1500(this.a));
    paramString2.a(paramString1.c());
    if (paramString1.e().length() != 0)
    {
      paramString2.b(paramString1.e());
      paramString2.d(paramString1.g());
    }
    IlinkService.access$1502(this.a, paramString2.c());
    paramString1 = new StringBuilder();
    paramString1.append("Update new productid:");
    paramString1.append(IlinkService.access$1500(this.a).c());
    Log.i("IlinkService", paramString1.toString());
    IlinkService.access$1400(this.a).c(paramArrayOfByte);
  }
  
  public byte[] b(String paramString1, String paramString2)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return null;
    }
    paramString1 = new Profile();
    paramString1.setIlinkid(IlinkService.access$1400(this.a).i());
    IlinkService.access$1702(this.a, paramString1.serialize());
    return IlinkService.access$1700(this.a);
  }
  
  public String c(String paramString1, String paramString2)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return null;
    }
    return IlinkService.access$1400(this.a).j();
  }
  
  public void c(String arg1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, ???, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(???);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    synchronized (IlinkService.access$100(this.a))
    {
      if (IlinkService.access$100(this.a).containsKey(paramString3))
      {
        paramString2 = new StringBuilder();
        paramString2.append("appid:");
        paramString2.append(paramString3);
        paramString2.append("exit in map try to destroy it!");
        Log.d("IlinkService", paramString2.toString());
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a();
        y.a(((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c);
        IlinkService.access$100(this.a).remove(paramString3);
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append("appid:");
        paramString2.append(paramString3);
        paramString2.append(" not exit in map maybe you already destroy it!");
        Log.w("IlinkService", paramString2.toString());
      }
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call SetSmcUin from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.c(paramInt);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
  }
  
  public void c(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call faceExtVerify from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.i.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void d(String paramString1, String paramString2, String paramString3) {}
  
  public void d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call cancelRequest from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.b(paramInt);
    }
  }
  
  public void d(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call faceLogin from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.i("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.u.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return false;
    }
    return IlinkService.access$1400(this.a).k();
  }
  
  public void e(String paramString1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3)) {
      Log.e("IlinkService", "api not longer used use new on!");
    }
  }
  
  public void e(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call qrCodeLogin from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.b(b.u.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public int f(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return 0;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call sendAppRequest from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.i("IlinkService", paramString2.toString());
      try
      {
        int i = ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.c.a(paramArrayOfByte));
        if (i != 0) {
          IlinkService.access$600(this.a).put(new Integer(i), paramString1);
        }
        return i;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return 0;
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append("tdi session not exit any more appid:");
    paramString2.append(paramString3);
    paramString2.append(", caller:");
    paramString2.append(paramString1);
    Log.e("IlinkService", paramString2.toString());
    return 0;
  }
  
  public void f(String paramString1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call checkLoginQrCode from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.e();
    }
  }
  
  public void g(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call faceRecognizeConfig from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.i("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.k.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public byte[] g(String paramString1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return null;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call getUserInfo from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      return ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.c().toByteArray();
    }
    return null;
  }
  
  public void h(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = IlinkService.access$1000(this.a, paramString1, paramString2);
    paramString2 = Integer.valueOf(-1);
    Integer localInteger = Integer.valueOf(0);
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("caller:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" is illegal");
      Log.e("IlinkService", ((StringBuilder)localObject1).toString());
      paramString1 = Integer.TYPE;
      localObject2 = b.v.i().c();
      localObject1 = this.a;
      localObject2 = ((b.v)localObject2).toByteArray();
      ((IlinkService)localObject1).addServiceCallbackTask(paramString3, "onTdiLoginComplete", new Class[] { String.class, paramString1, [B.class }, new Object[] { localInteger, paramString3, paramString2, localObject2 });
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call tdiAutoLogin from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.d();
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("caller:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" appid is illegal not exit:");
    ((StringBuilder)localObject1).append(paramString3);
    Log.e("IlinkService", ((StringBuilder)localObject1).toString());
    paramString1 = Integer.TYPE;
    Object localObject2 = b.v.i().c();
    localObject1 = this.a;
    localObject2 = ((b.v)localObject2).toByteArray();
    ((IlinkService)localObject1).addServiceCallbackTask(paramString3, "onTdiLoginComplete", new Class[] { String.class, paramString1, [B.class }, new Object[] { localInteger, paramString3, paramString2, localObject2 });
  }
  
  public void h(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call getAppPushToken from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(paramArrayOfByte);
    }
  }
  
  public void i(String paramString1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call tdiLogOut from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.b();
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("caller:");
    paramString2.append(paramString1);
    paramString2.append(" appid is illegal not exit:");
    paramString2.append(paramString3);
    Log.e("IlinkService", paramString2.toString());
  }
  
  public void i(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call getLoginQrCode from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.o.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public int j(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return 0;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return 0;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call newgetAppPushToken from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      return ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(paramArrayOfByte);
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
    return 0;
  }
  
  public void j(String paramString1, String paramString2, String paramString3)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$500(this.a).containsKey(paramString3))
    {
      if (((Vector)IlinkService.access$500(this.a).get(paramString3)).contains(paramString1))
      {
        ((Vector)IlinkService.access$500(this.a).get(paramString3)).remove(paramString1);
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append("call not in clonemap:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("appid in clonemap:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
  }
  
  public void k(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call WriteKvData from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.b(paramArrayOfByte);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
  }
  
  public void l(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call OAuthLogin from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.c(b.u.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
  }
  
  public int m(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return 0;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return 0;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call getOAuthCode from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        int i = ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.q.a(paramArrayOfByte));
        return i;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return 0;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
    return 0;
  }
  
  public int n(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return 0;
    }
    if (!IlinkService.access$1300(this.a, paramString3, paramString1)) {
      return 0;
    }
    if (IlinkService.access$100(this.a).containsKey(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append("call cancelOAuth from:");
      paramString2.append(paramString1);
      paramString2.append(", for appid:");
      paramString2.append(paramString3);
      Log.d("IlinkService", paramString2.toString());
      try
      {
        int i = ((IlinkService.f)IlinkService.access$100(this.a).get(paramString3)).c.a(b.e.a(paramArrayOfByte));
        return i;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return 0;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("tdi session map not contain appid:");
    paramString1.append(paramString3);
    Log.e("IlinkService", paramString1.toString());
    return 0;
  }
  
  public void o(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return;
    }
    int i = -1;
    switch (paramString3.hashCode())
    {
    default: 
      break;
    case 1240306118: 
      if (paramString3.equals("setSmcBaseInfo")) {
        i = 4;
      }
      break;
    case 1093616719: 
      if (paramString3.equals("thirdAppLogin")) {
        i = 2;
      }
      break;
    case 884734785: 
      if (paramString3.equals("startUploadLog")) {
        i = 5;
      }
      break;
    case 841167721: 
      if (paramString3.equals("loginImSession")) {
        i = 8;
      }
      break;
    case -209297509: 
      if (paramString3.equals("visitorLogin")) {
        i = 3;
      }
      break;
    case -378235400: 
      if (paramString3.equals("destroyImSession")) {
        i = 7;
      }
      break;
    case -1035986083: 
      if (paramString3.equals("setLonglinkIplist")) {
        i = 0;
      }
      break;
    case -1419276391: 
      if (paramString3.equals("setShortlinkIplist")) {
        i = 1;
      }
      break;
    case -1716520125: 
      if (paramString3.equals("requestUploadLogfiles")) {
        i = 10;
      }
      break;
    case -1926850762: 
      if (paramString3.equals("createImSession")) {
        i = 6;
      }
      break;
    case -2077369985: 
      if (paramString3.equals("updateIlinkToken")) {
        i = 9;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramString1 = new StringBuilder();
      paramString1.append("not supported function: ");
      paramString1.append(paramString3);
      Log.e("IlinkService", paramString1.toString());
      return;
    case 10: 
      try
      {
        paramString2 = a.j.a(paramArrayOfByte);
        if (IlinkService.access$100(this.a).containsKey(paramString2.c()))
        {
          paramString3 = new StringBuilder();
          paramString3.append("call requestUploadLogfiles from:");
          paramString3.append(paramString1);
          paramString3.append(", for appid:");
          paramString3.append(paramString2.c());
          Log.d("IlinkService", paramString3.toString());
          ((IlinkService.f)IlinkService.access$100(this.a).get(paramString2.c())).c.a(paramString2.e(), paramString2.g());
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("tdi session map not contain appid:");
        paramString1.append(paramString2.c());
        Log.e("IlinkService", paramString1.toString());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 9: 
      try
      {
        paramString2 = a.r.a(paramArrayOfByte);
        if (IlinkService.access$100(this.a).containsKey(paramString2.c()))
        {
          paramString3 = new StringBuilder();
          paramString3.append("call updateIlinkToken from:");
          paramString3.append(paramString1);
          paramString3.append(", for appid:");
          paramString3.append(paramString2.c());
          Log.d("IlinkService", paramString3.toString());
          ((IlinkService.f)IlinkService.access$100(this.a).get(paramString2.c())).c.d(paramString2.e().getBytes());
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("tdi session map not contain appid:");
        paramString1.append(paramString2.c());
        Log.e("IlinkService", paramString1.toString());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 8: 
      IlinkService.access$1600(this.a).c();
      return;
    case 7: 
      IlinkService.access$1600(this.a).b();
      return;
    case 6: 
      IlinkService.access$1600(this.a).a(paramString1, paramArrayOfByte);
      return;
    case 5: 
      try
      {
        paramString1 = a.n.a(paramArrayOfByte);
        IlinkService.access$1400(this.a).f(paramString1.c().toByteArray());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 4: 
      try
      {
        paramString2 = a.m.a(paramArrayOfByte);
        if (IlinkService.access$100(this.a).containsKey(paramString2.c()))
        {
          paramString3 = new StringBuilder();
          paramString3.append("call setSmcBaseInfo from:");
          paramString3.append(paramString1);
          paramString3.append(", for appid:");
          paramString3.append(paramString2.c());
          Log.d("IlinkService", paramString3.toString());
          ((IlinkService.f)IlinkService.access$100(this.a).get(paramString2.c())).c.c(paramString2.e().toByteArray());
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("tdi session map not contain appid:");
        paramString1.append(paramString2.c());
        Log.e("IlinkService", paramString1.toString());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 3: 
      try
      {
        paramString2 = a.s.a(paramArrayOfByte);
        if (!IlinkService.access$1300(this.a, paramString2.c(), paramString1)) {
          return;
        }
        if (IlinkService.access$100(this.a).containsKey(paramString2.c()))
        {
          paramString3 = new StringBuilder();
          paramString3.append("call visitorLogin from:");
          paramString3.append(paramString1);
          paramString3.append(", for appid:");
          paramString3.append(paramString2.c());
          Log.d("IlinkService", paramString3.toString());
          try
          {
            ((IlinkService.f)IlinkService.access$100(this.a).get(paramString2.c())).c.e(b.u.a(paramString2.e()));
            return;
          }
          catch (InvalidProtocolBufferException paramString1)
          {
            paramString1.printStackTrace();
            return;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("tdi session map not contain appid:");
        paramString1.append(paramString2.c());
        Log.e("IlinkService", paramString1.toString());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 2: 
      try
      {
        paramString2 = a.o.a(paramArrayOfByte);
        if (!IlinkService.access$1300(this.a, paramString2.c(), paramString1)) {
          return;
        }
        if (IlinkService.access$100(this.a).containsKey(paramString2.c()))
        {
          paramString3 = new StringBuilder();
          paramString3.append("call thirdAppLogin from:");
          paramString3.append(paramString1);
          paramString3.append(", for appid:");
          paramString3.append(paramString2.c());
          Log.d("IlinkService", paramString3.toString());
          try
          {
            ((IlinkService.f)IlinkService.access$100(this.a).get(paramString2.c())).c.d(b.u.a(paramString2.e()));
            return;
          }
          catch (InvalidProtocolBufferException paramString1)
          {
            paramString1.printStackTrace();
            return;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("tdi session map not contain appid:");
        paramString1.append(paramString2.c());
        Log.e("IlinkService", paramString1.toString());
        return;
      }
      catch (InvalidProtocolBufferException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    case 1: 
      IlinkService.access$1400(this.a).e(paramArrayOfByte);
      return;
    }
    IlinkService.access$1400(this.a).d(paramArrayOfByte);
  }
  
  public byte[] p(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (!IlinkService.access$1000(this.a, paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("caller:");
      paramString2.append(paramString1);
      paramString2.append(" is illegal");
      Log.e("IlinkService", paramString2.toString());
      return new byte[0];
    }
    int i = -1;
    int j = paramString3.hashCode();
    if (j != -1911188865)
    {
      if (j != -1855530000)
      {
        if ((j == 686849420) && (paramString3.equals("getDeviceShadow"))) {
          i = 1;
        }
      }
      else if (paramString3.equals("getIlinkServiceVersion")) {
        i = 0;
      }
    }
    else if (paramString3.equals("updateDeviceShadow")) {
      i = 2;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          paramString1 = new StringBuilder();
          paramString1.append("not supported function: ");
          paramString1.append(paramString3);
          Log.e("IlinkService", paramString1.toString());
          return new byte[0];
        }
        try
        {
          paramString1 = a.p.a(paramArrayOfByte);
          i = IlinkService.access$1600(this.a).a(paramString1.e().toByteArray());
          paramString1 = a.q.e().a(i).c().toByteArray();
          return paramString1;
        }
        catch (InvalidProtocolBufferException paramString1)
        {
          paramString1.printStackTrace();
          return a.q.e().a(0).c().toByteArray();
        }
      }
      i = IlinkService.access$1600(this.a).d();
      return a.c.e().a(i).c().toByteArray();
    }
    IlinkService.access$1400(this.a).d(paramArrayOfByte);
    return a.d.e().a("0.2.15.edc6d5d").c().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkService.2
 * JD-Core Version:    0.7.0.1
 */