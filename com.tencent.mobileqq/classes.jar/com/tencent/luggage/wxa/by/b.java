package com.tencent.luggage.wxa.by;

import android.os.Parcelable;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

public class b
{
  private static final HashMap<String, a> a = new HashMap();
  
  public static void a(a parama)
  {
    o.d("MicroMsg.WMPFToClientEventCenter", "register WMPFToClientEvent.appId:%s, WMPFToClientEvent.hash:%d", new Object[] { parama.b, Integer.valueOf(parama.hashCode()) });
    if (parama.b == null)
    {
      o.b("MicroMsg.WMPFToClientEventCenter", "register WMPFToClientEvent.appId is null!!!");
      return;
    }
    synchronized (a)
    {
      if (a.get(parama.b) == null)
      {
        a.put(parama.b, parama);
      }
      else
      {
        o.e("MicroMsg.WMPFToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
        a.remove(parama.b);
        a.put(parama.b, parama);
      }
      return;
    }
  }
  
  public static <T extends Parcelable> void a(String paramString, T paramT)
  {
    synchronized (a)
    {
      paramString = (a)a.get(paramString);
      if (paramString == null)
      {
        o.b("MicroMsg.WMPFToClientEventCenter", "notify failed, appId[%s] data[%s]");
        return;
      }
      if ((paramString != null) && (paramT != null)) {
        paramString.a(paramT);
      }
      return;
    }
  }
  
  public static void b(a parama)
  {
    o.d("MicroMsg.WMPFToClientEventCenter", "unregister WMPFToClientEvent.appId:%s", new Object[] { parama.b });
    synchronized (a)
    {
      a.remove(parama.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.by.b
 * JD-Core Version:    0.7.0.1
 */