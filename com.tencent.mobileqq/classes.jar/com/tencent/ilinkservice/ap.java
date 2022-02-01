package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.tdi.b.a;
import com.tencent.ilink.tdi.b.b;
import com.tencent.ilink.tdi.b.c;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.f;
import com.tencent.ilink.tdi.b.g;
import com.tencent.ilink.tdi.b.j;
import com.tencent.ilink.tdi.b.l;
import com.tencent.ilink.tdi.b.n;
import com.tencent.ilink.tdi.b.p;
import com.tencent.ilink.tdi.b.r;
import com.tencent.ilink.tdi.b.u;
import com.tencent.ilink.tdi.b.v;
import com.tencent.ilink.tdi.b.z;
import com.tencent.ilink.tdi.b.z.a;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class ap
  implements ao, aq
{
  private static AtomicInteger i = new AtomicInteger(0);
  private final String a = "IlinkServiceTdiImpl";
  private String b;
  private at c;
  private as d;
  private boolean e;
  private Vector<Integer> f = new Vector();
  private ConcurrentHashMap<Integer, Integer> g = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, an> h = new ConcurrentHashMap();
  
  public ap(String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.e = paramBoolean;
  }
  
  private boolean l()
  {
    if (this.e) {
      return true;
    }
    if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this))
    {
      af.a().d("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
      return true;
    }
    return false;
  }
  
  private boolean m()
  {
    if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this))
    {
      af.a().d("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
      return true;
    }
    return false;
  }
  
  int a(int paramInt, b.c paramc)
  {
    if (this.e) {
      return 0;
    }
    if (!this.h.containsKey(Integer.valueOf(paramInt)))
    {
      af.a().d("IlinkServiceTdiImpl", "clone session already been destroyed!!", new Object[0]);
      return 0;
    }
    if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this))
    {
      af.a().d("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
      return 0;
    }
    int j = IlinkServiceImpl.getInstance().addAppRequestTask();
    this.g.put(new Integer(j), new Integer(paramInt));
    Object localObject = Integer.TYPE;
    paramc = paramc.toByteArray();
    v localv = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    localv.a(localIlinkServiceImpl, IlinkServiceImpl.class, "sendAppRequest", new Class[] { String.class, [B.class, localObject }, new Object[] { str, paramc, Integer.valueOf(j) });
    paramc = af.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send clone app request taskid:");
    ((StringBuilder)localObject).append(j);
    paramc.a("IlinkServiceTdiImpl", ((StringBuilder)localObject).toString(), new Object[0]);
    return j;
  }
  
  public int a(b.c paramc)
  {
    if (!IlinkServiceImpl.getInstance().isTdiSessionValid(this))
    {
      af.a().d("IlinkServiceTdiImpl", "tdi session already been destroyed!!", new Object[0]);
      return 0;
    }
    int j = IlinkServiceImpl.getInstance().addAppRequestTask();
    this.f.addElement(new Integer(j));
    Object localObject = Integer.TYPE;
    paramc = paramc.toByteArray();
    v localv = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    localv.a(localIlinkServiceImpl, IlinkServiceImpl.class, "sendAppRequest", new Class[] { String.class, [B.class, localObject }, new Object[] { str, paramc, Integer.valueOf(j) });
    paramc = af.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send app request taskid:");
    ((StringBuilder)localObject).append(j);
    paramc.a("IlinkServiceTdiImpl", ((StringBuilder)localObject).toString(), new Object[0]);
    return j;
  }
  
  public ao a()
  {
    if (this.e) {
      return null;
    }
    int k = i.incrementAndGet();
    int j = k;
    if (k == 0) {
      j = i.incrementAndGet();
    }
    an localan = new an(j, this);
    this.h.put(new Integer(j), localan);
    return localan;
  }
  
  public void a(int paramInt)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnLoginComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      ((at)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (l()) {
      return;
    }
    byte[] arrayOfByte = a.j.i().a(this.b).a(paramInt1).b(paramInt2).c().toByteArray();
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[] { String.class, [B.class }, new Object[] { "requestUploadLogfiles", arrayOfByte });
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveAppResponse error:");
    localStringBuilder.append(paramInt2);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = new Integer(paramInt1);
    if (this.f.contains(localObject))
    {
      this.f.remove(localObject);
      if (this.e)
      {
        localObject = this.d;
        if (localObject == null) {
          break label145;
        }
        try
        {
          ((as)localObject).a(paramInt1, paramInt2, b.d.a(paramArrayOfByte));
          return;
        }
        catch (InvalidProtocolBufferException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return;
        }
      }
      localObject = this.c;
      if (localObject != null) {
        try
        {
          ((at)localObject).a(paramInt1, paramInt2, b.d.a(paramArrayOfByte));
          return;
        }
        catch (InvalidProtocolBufferException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      label145:
      return;
    }
    if (this.e)
    {
      paramArrayOfByte = af.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("it is not a local task and i am a clone just return and ignore this taskid:");
      ((StringBuilder)localObject).append(paramInt1);
      paramArrayOfByte.c("IlinkServiceTdiImpl", ((StringBuilder)localObject).toString(), new Object[0]);
      return;
    }
    af.a().c("IlinkServiceTdiImpl", "Local task not exit check if it is clone task!", new Object[0]);
    if ((this.g.containsKey(localObject)) && (this.h.containsKey(this.g.get(localObject))))
    {
      ((an)this.h.get(this.g.get(localObject))).a(paramInt1, paramInt2, paramArrayOfByte);
      return;
    }
    af.a().c("IlinkServiceTdiImpl", "it is not a local task or clone task maybe cancel already or cloneobj not exit!", new Object[0]);
  }
  
  void a(int paramInt, String paramString)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onReceiveMultiProcessCloneTicket", new Object[0]);
    at localat = this.c;
    if (localat != null) {
      localat.a(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFaceRecognizeComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt, b.n.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    if (m()) {
      return;
    }
    Object localObject = ag.b.o();
    ((ag.b.a)localObject).a(paramInt1);
    ((ag.b.a)localObject).a(ByteString.copyFrom(paramArrayOfByte));
    ((ag.b.a)localObject).a(paramBoolean1);
    ((ag.b.a)localObject).b(paramInt2);
    ((ag.b.a)localObject).b(paramBoolean2);
    ((ag.b.a)localObject).c(paramInt3);
    paramArrayOfByte = ((ag.b.a)localObject).c().toByteArray();
    localObject = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    ((v)localObject).a(localIlinkServiceImpl, IlinkServiceImpl.class, "WriteKvData", new Class[] { String.class, [B.class }, new Object[] { str, paramArrayOfByte });
  }
  
  public void a(b.f paramf)
  {
    if (l()) {
      return;
    }
    Class localClass = Integer.TYPE;
    int j = paramf.getNumber();
    paramf = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    paramf.a(localIlinkServiceImpl, IlinkServiceImpl.class, "cancel", new Class[] { String.class, localClass }, new Object[] { str, Integer.valueOf(j) });
  }
  
  public void a(b.u paramu)
  {
    if (l()) {
      return;
    }
    paramu = a.o.g().a(this.b).a(paramu.toByteString()).c().toByteArray();
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[] { String.class, [B.class }, new Object[] { "thirdAppLogin", paramu });
  }
  
  public void a(ag.d paramd)
  {
    if (m()) {
      return;
    }
    paramd = a.m.g().a(this.b).a(paramd.toByteString()).c().toByteArray();
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[] { String.class, [B.class }, new Object[] { "setSmcBaseInfo", paramd });
  }
  
  public void a(as paramas)
  {
    this.d = paramas;
  }
  
  public void a(at paramat)
  {
    if (this.e) {
      return;
    }
    this.c = paramat;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    af.a().a("IlinkServiceTdiImpl", "onReceiveAppMessage", new Object[0]);
    if (this.e)
    {
      localObject = this.d;
      if (localObject != null) {
        try
        {
          ((as)localObject).a(b.a.a(paramArrayOfByte));
          return;
        }
        catch (InvalidProtocolBufferException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      return;
    }
    Object localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(b.a.a(paramArrayOfByte));
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        localInvalidProtocolBufferException.printStackTrace();
      }
    }
    Enumeration localEnumeration = this.h.elements();
    while (localEnumeration.hasMoreElements()) {
      ((an)localEnumeration.nextElement()).a(paramArrayOfByte);
    }
  }
  
  public b.z b()
  {
    Object localObject = IlinkServiceImpl.getInstance().getUserInfo(this.b);
    b.z localz = b.z.m().c();
    if (localObject == null) {
      return localz;
    }
    try
    {
      localObject = b.z.a((byte[])localObject);
      return localObject;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      localInvalidProtocolBufferException.printStackTrace();
    }
    return localz;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onCancelOAuthComplete", new Object[0]);
    Object localObject = new Integer(paramInt1);
    if (this.f.contains(localObject)) {
      this.f.remove(localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      ((at)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onGetAppPushTokenComplete", new Object[0]);
    Object localObject = new Integer(paramInt1);
    if (this.f.contains(localObject)) {
      this.f.remove(localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt1, paramInt2, b.b.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFaceExtVerifyComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt, b.j.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "OnRequestUploadLogfiles", new Object[0]);
    at localat = this.c;
    if (localat != null) {
      try
      {
        localat.a(ag.c.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    if (l()) {
      return;
    }
    v localv = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    localv.a(localIlinkServiceImpl, IlinkServiceImpl.class, "autoLogin", new Class[] { String.class }, new Object[] { str });
  }
  
  public void c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onGetOAuthCodeComplete", new Object[0]);
    Object localObject = new Integer(paramInt1);
    if (this.f.contains(localObject)) {
      this.f.remove(localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt1, paramInt2, b.r.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void c(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnLoginComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt, b.v.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    if (l()) {
      return;
    }
    v localv = v.a();
    IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
    String str = this.b;
    localv.a(localIlinkServiceImpl, IlinkServiceImpl.class, "logOut", new Class[] { String.class }, new Object[] { str });
  }
  
  public void d(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnGetLoginQrCodeComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt, b.p.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  String e()
  {
    return this.b;
  }
  
  public void e(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCheckLoginQrCodeComplete error:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceTdiImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.c;
    if (localObject != null) {
      try
      {
        ((at)localObject).a(paramInt, b.g.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void f(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onFaceRecognizeConfigComplete", new Object[0]);
    at localat = this.c;
    if (localat != null) {
      try
      {
        localat.a(paramInt, b.l.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  void g()
  {
    af.a().a("IlinkServiceTdiImpl", "cancel all app request", new Object[0]);
    ??? = this.f;
    int j = 0;
    try
    {
      for (;;)
      {
        Object localObject2;
        Object localObject5;
        Object localObject6;
        Object localObject7;
        if (j < this.f.size())
        {
          int k = IlinkServiceImpl.getInstance().removeAppRequestTask(((Integer)this.f.get(j)).intValue());
          if (k != 0)
          {
            localObject2 = Integer.TYPE;
            localObject5 = v.a();
            localObject6 = IlinkServiceImpl.getInstance();
            localObject7 = this.b;
            ((v)localObject5).a(localObject6, IlinkServiceImpl.class, "cancelAppRequest", new Class[] { String.class, localObject2 }, new Object[] { localObject7, Integer.valueOf(k) });
          }
        }
        else
        {
          this.f.clear();
          synchronized (this.g)
          {
            localObject2 = this.g.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject5 = (Integer)((Iterator)localObject2).next();
              j = IlinkServiceImpl.getInstance().removeAppRequestTask(((Integer)localObject5).intValue());
              if (j != 0)
              {
                localObject5 = Integer.TYPE;
                localObject6 = v.a();
                localObject7 = IlinkServiceImpl.getInstance();
                String str = this.b;
                ((v)localObject6).a(localObject7, IlinkServiceImpl.class, "cancelAppRequest", new Class[] { String.class, localObject5 }, new Object[] { str, Integer.valueOf(j) });
              }
            }
            this.g.clear();
            return;
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        throw localObject4;
      }
      j += 1;
    }
  }
  
  void h()
  {
    if (this.e) {
      return;
    }
    Enumeration localEnumeration = this.h.elements();
    while (localEnumeration.hasMoreElements()) {
      ((an)localEnumeration.nextElement()).a();
    }
    this.h.clear();
  }
  
  b.z i()
  {
    return b();
  }
  
  public void j()
  {
    if (this.e) {
      return;
    }
    af.a().a("IlinkServiceTdiImpl", "onAppSessionTimeout", new Object[0]);
    at localat = this.c;
    if (localat != null) {
      localat.a();
    }
  }
  
  public void k()
  {
    af.a().a("IlinkServiceTdiImpl", "onCloneDestroyed", new Object[0]);
    if (this.e)
    {
      as localas = this.d;
      if (localas != null) {
        localas.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ap
 * JD-Core Version:    0.7.0.1
 */