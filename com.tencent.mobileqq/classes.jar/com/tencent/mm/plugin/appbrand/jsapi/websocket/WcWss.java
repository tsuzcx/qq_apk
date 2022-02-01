package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.util.Pair;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.ot.a;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.ot.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss
{
  private static HashMap<Pair<String, Integer>, WcWss.a> a = new HashMap();
  
  static
  {
    f.a("wcwss", WcWss.class.getClassLoader());
  }
  
  public static int a(WcWss.a parama, String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, Object paramObject, Object[] paramArrayOfObject4)
  {
    int i = connectSocket(paramString1, paramString2, paramArrayOfObject1, paramArrayOfObject2, paramArrayOfObject3, paramObject, paramArrayOfObject4);
    if (i > 0)
    {
      o.d("MicroMsg.WcWss", "connect wss pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
      paramString2 = new Pair(paramString1, Integer.valueOf(i));
      if (a.containsKey(paramString2))
      {
        o.b("MicroMsg.WcWss", "already exists pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
        return -1;
      }
      a.put(paramString2, parama);
    }
    return i;
  }
  
  public static void a()
  {
    o.d("MicroMsg.WcWss", "initWcWss");
    init();
  }
  
  public static int b()
  {
    try
    {
      int i = x.d(r.a());
      if (i == -1) {
        return -1;
      }
      if (x.f(r.a())) {
        return 3;
      }
      if (x.i(r.a())) {
        return 4;
      }
      if (x.g(r.a())) {
        return 5;
      }
      if (x.b(i)) {
        return 1;
      }
      boolean bool = x.a(i);
      if (bool) {
        return 2;
      }
      return 6;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.WcWss", localException, "getStatisticsNetType_", new Object[0]);
    }
    return -1;
  }
  
  public static native void closeSocket(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native int connectSocket(String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, Object paramObject, Object[] paramArrayOfObject4);
  
  @Keep
  public static int doCertificateVerify(String paramString1, int paramInt, String paramString2, byte[][] paramArrayOfByte)
  {
    o.d("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString1 = new Pair(paramString1, Integer.valueOf(paramInt));
    if (a.containsKey(paramString1)) {
      return ((WcWss.a)a.get(paramString1)).a(paramString2, paramArrayOfByte);
    }
    o.b("MicroMsg.WcWss", "onMessage callback is null");
    return -1;
  }
  
  @Keep
  public static int getNetworkType()
  {
    return b();
  }
  
  public static native void init();
  
  @Keep
  public static void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    o.d("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (a.containsKey(localPair))
    {
      ((WcWss.a)a.get(localPair)).a(paramString1, paramInt1, paramInt2, paramString2);
      a.remove(localPair);
      return;
    }
    o.b("MicroMsg.WcWss", "onClose callback is null");
  }
  
  @Keep
  public static void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    o.d("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (a.containsKey(localPair))
    {
      ((WcWss.a)a.get(localPair)).a(paramString, paramInt, paramArrayOfString1, paramArrayOfString2);
      return;
    }
    o.b("MicroMsg.WcWss", "onHandShake callback is null");
  }
  
  @Keep
  public static void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    o.f("MicroMsg.WcWss", "onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new a(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((c)e.b(c.class)).a(localArrayList, false);
  }
  
  @Keep
  public static void onKvStat(int paramInt, String paramString)
  {
    o.d("MicroMsg.WcWss", "onKvStat logId:%s", new Object[] { Integer.valueOf(paramInt) });
    ((d)e.b(d.class)).a(paramInt, paramString);
  }
  
  @Keep
  public static void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    o.e("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (a.containsKey(localPair))
    {
      ((WcWss.a)a.get(localPair)).a(paramString, paramInt, paramArrayOfByte, paramBoolean);
      return;
    }
    o.b("MicroMsg.WcWss", "onMessage callback is null");
  }
  
  @Keep
  public static void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    o.d("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (a.containsKey(localPair))
    {
      ((WcWss.a)a.get(localPair)).a(paramString1, paramInt1, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramInt2, paramString2, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8);
      if (!paramBoolean) {
        a.remove(localPair);
      }
    }
    else
    {
      o.b("MicroMsg.WcWss", "onOpen callback is null");
    }
  }
  
  public static native int sendBuffer(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss
 * JD-Core Version:    0.7.0.1
 */