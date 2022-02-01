package com.tencent.ilinkservice;

import android.os.RemoteCallbackList;
import com.tencent.ilink.tdi.y;
import com.tencent.mars.ilink.xlog.Log;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class IlinkService$b
  extends RemoteCallbackList<IIlinkServiceCallback>
{
  private IlinkService$b(IlinkService paramIlinkService) {}
  
  public void a(IIlinkServiceCallback arg1, Object paramObject)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("client process died:");
    ((StringBuilder)???).append(paramObject);
    Log.e("IlinkService", ((StringBuilder)???).toString());
    synchronized (IlinkService.access$100(this.a))
    {
      IlinkService.access$200(this.a).unregister(???);
      IlinkService.access$300(this.a).remove(paramObject);
      ??? = new HashSet();
      Object localObject2 = IlinkService.access$100(this.a).elements();
      Object localObject3;
      while (((Enumeration)localObject2).hasMoreElements())
      {
        localObject3 = (IlinkService.f)((Enumeration)localObject2).nextElement();
        if (((IlinkService.f)localObject3).a.equals(paramObject)) {
          ???.add(localObject3);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Going to delete tdi sessions num:");
      ((StringBuilder)localObject2).append(???.size());
      Log.w("IlinkService", ((StringBuilder)localObject2).toString());
      ??? = ???.iterator();
      while (???.hasNext())
      {
        localObject2 = (IlinkService.f)???.next();
        if (IlinkService.access$400(this.a).containsKey(((IlinkService.f)localObject2).b))
        {
          IlinkService.access$400(this.a).remove(((IlinkService.f)localObject2).b);
          if (IlinkService.access$500(this.a).containsKey(((IlinkService.f)localObject2).b))
          {
            localObject3 = ((Vector)IlinkService.access$500(this.a).get(((IlinkService.f)localObject2).b)).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              String str1 = (String)((Iterator)localObject3).next();
              IlinkService localIlinkService = this.a;
              String str2 = ((IlinkService.f)localObject2).b;
              localIlinkService.addDeviceCallbackTask(str1, "onDestroyMultiProcessTdiSession", new Class[] { String.class }, new Object[] { str2 });
            }
            IlinkService.access$500(this.a).remove(((IlinkService.f)localObject2).b);
          }
        }
        IlinkService.access$100(this.a).remove(((IlinkService.f)localObject2).b);
        y.a(((IlinkService.f)localObject2).c);
      }
      synchronized (IlinkService.access$500(this.a))
      {
        new HashSet();
        ??? = IlinkService.access$500(this.a).keys();
        while (((Enumeration)???).hasMoreElements())
        {
          localObject2 = (String)((Enumeration)???).nextElement();
          if (((Vector)IlinkService.access$500(this.a).get(localObject2)).contains(paramObject)) {
            ((Vector)IlinkService.access$500(this.a).get(localObject2)).remove(paramObject);
          }
        }
        ??? = IlinkService.access$600(this.a).keys();
        while (((Enumeration)???).hasMoreElements())
        {
          localObject2 = (Integer)((Enumeration)???).nextElement();
          if (((String)IlinkService.access$600(this.a).get(localObject2)).equals(paramObject)) {
            IlinkService.access$600(this.a).remove(localObject2);
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkService.b
 * JD-Core Version:    0.7.0.1
 */