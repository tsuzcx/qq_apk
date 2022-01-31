package com.tencent.beacon.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.beacon.upload.a
{
  public static com.tencent.beacon.b.a.b a(int paramInt, List<k> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        com.tencent.beacon.d.a.b(" current size:" + paramList.size(), new Object[0]);
        paramList = a(paramList);
        if (paramList != null)
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            paramList = a(paramInt, paramList);
            return paramList;
          }
        }
      }
      catch (Throwable paramList)
      {
        com.tencent.beacon.d.a.a(paramList);
        com.tencent.beacon.d.a.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private static com.tencent.beacon.b.b.b a(List<k> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    com.tencent.beacon.b.b.b localb;
    try
    {
      localb = new com.tencent.beacon.b.b.b();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.beacon.b.b.a locala = b.e((k)paramList.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localb.a = localArrayList;
    }
    catch (Throwable paramList)
    {
      com.tencent.beacon.d.a.a(paramList);
      return null;
    }
    com.tencent.beacon.d.a.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
    return localb;
  }
  
  private void g() {}
  
  private List<k> h()
  {
    return null;
  }
  
  private void i() {}
  
  public final com.tencent.beacon.b.a.b a()
  {
    return null;
  }
  
  public final void b(boolean paramBoolean)
  {
    g();
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.m
 * JD-Core Version:    0.7.0.1
 */