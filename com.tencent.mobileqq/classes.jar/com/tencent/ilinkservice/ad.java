package com.tencent.ilinkservice;

import android.content.Context;

public final class ad
{
  private static ad.a b = new ad.1();
  private final String a = "IlinkServiceInterface";
  
  private ad()
  {
    IlinkServiceImpl.getInstance();
    v.a();
  }
  
  public static ad a()
  {
    return ad.b.a();
  }
  
  public static void a(ad.a parama)
  {
    if (parama == null) {
      return;
    }
    b = parama;
  }
  
  public static ad.a b()
  {
    return b;
  }
  
  public aq a(String paramString)
  {
    if (paramString.isEmpty())
    {
      af.a().d("IlinkServiceInterface", "appid should not be empty!!!!", new Object[0]);
      return null;
    }
    if (!IlinkServiceImpl.getInstance().isDeviceLoginSuccess())
    {
      af.a().d("IlinkServiceInterface", "Device not login yet can not create tdi session!!!!", new Object[0]);
      return null;
    }
    if (IlinkServiceImpl.getInstance().isAppidTdiSessionExit(paramString)) {
      return IlinkServiceImpl.getInstance().addTdiSession(paramString);
    }
    ap localap = IlinkServiceImpl.getInstance().addTdiSession(paramString);
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "createTdiSession", new Class[] { String.class }, new Object[] { paramString });
    return localap;
  }
  
  public void a(Context paramContext, ag.f paramf)
  {
    IlinkServiceImpl.getInstance().start(paramContext, paramf.toByteArray());
    v.a().b();
  }
  
  public void a(ac paramac)
  {
    IlinkServiceImpl.getInstance().registCallback(paramac);
  }
  
  public void a(ae paramae)
  {
    af.a().a(paramae);
  }
  
  public void a(ao paramao)
  {
    if ((paramao != null) && ((paramao instanceof ap)))
    {
      IlinkServiceImpl localIlinkServiceImpl = IlinkServiceImpl.getInstance();
      paramao = (ap)paramao;
      if (localIlinkServiceImpl.isTdiSessionValid(paramao))
      {
        if (!paramao.f())
        {
          af.a().d("IlinkServiceInterface", "could not destroy session use destroyTdiSession instead!!!!", new Object[0]);
          return;
        }
        paramao = paramao.e();
        IlinkServiceImpl.getInstance().removeTdiSession(paramao);
        v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "destroyMultiProcessTdiSession", new Class[] { String.class }, new Object[] { paramao });
        return;
      }
      af.a().d("IlinkServiceInterface", "this tdi session has already been destroyed!!!!", new Object[0]);
      return;
    }
    af.a().d("IlinkServiceInterface", "tdi should not be null!!!!", new Object[0]);
  }
  
  public void b(ac paramac)
  {
    IlinkServiceImpl.getInstance().unregistCallback(paramac);
  }
  
  public y c()
  {
    return IlinkServiceImpl.getInstance().createDeviceInterface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ad
 * JD-Core Version:    0.7.0.1
 */