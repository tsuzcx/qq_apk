package com.tencent.mm.plugin.appbrand.debugger;

import android.os.Debug;
import com.tencent.luggage.wxa.gl.j;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.jn;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qw.ju;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;
import org.json.JSONObject;

public class l
{
  public static e a;
  private static com.tencent.luggage.wxa.dx.a b;
  private static String c;
  private static Boolean d;
  
  public static jt a(int paramInt, com.tencent.luggage.wxa.qu.a parama)
  {
    jt localjt = new jt();
    localjt.a = paramInt;
    localjt.b = a();
    localjt.c = b(parama);
    return localjt;
  }
  
  public static f a(String paramString)
  {
    o.d("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    f localf = new f();
    if (!af.c(paramString)) {
      try
      {
        paramString = com.tencent.luggage.wxa.hv.h.a(paramString);
        localf.a = paramString.optBoolean("open_remote", false);
        localf.b = paramString.optString("room_id");
        localf.c = paramString.optString("wxpkg_info");
        localf.d = paramString.optString("qrcode_id");
        localf.e = paramString.optInt("remote_network_type", 1);
        localf.g = paramString.optBoolean("disable_url_check", true);
        localf.f = paramString.optInt("remote_proxy_port", 9976);
        localf.h = paramString.optInt("remote_support_compress_algo");
        return localf;
      }
      catch (Exception paramString)
      {
        o.b("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
    return localf;
  }
  
  public static h a(com.tencent.luggage.wxa.qu.a parama, e parame, String paramString)
  {
    ju localju = new ju();
    try
    {
      parama = parama.b();
      if ((parama.length > 256) && (parame != null) && (parame.H()))
      {
        byte[] arrayOfByte = j.a(parama);
        localju.d = b.a(arrayOfByte);
        localju.e = 1;
        o.f("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      else
      {
        localju.d = b.a(parama);
      }
    }
    catch (IOException parama)
    {
      o.b("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
    }
    if (parame == null)
    {
      Debug.waitForDebugger();
      o.b("MicroMsg.RemoteDebugUtil", "env = null ");
    }
    localju.a = parame.k();
    if (parame.n() == 0L) {
      localju.b = 0;
    } else {
      localju.b = ((int)(System.currentTimeMillis() - parame.n()));
    }
    parame.o();
    localju.c = paramString;
    o.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localju.a) });
    parama = new h();
    parama.a();
    parama.c = localju.d.a();
    parama.b = localju;
    return parama;
  }
  
  public static String a()
  {
    if (af.c(c))
    {
      localObject = new Random(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Random)localObject).nextInt());
      localStringBuilder.append("-");
      localStringBuilder.append(b);
      c = localStringBuilder.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    return ((StringBuilder)localObject).toString();
  }
  
  public static ByteBuffer a(com.tencent.luggage.wxa.qu.a parama)
  {
    try
    {
      parama = ByteBuffer.wrap(parama.b());
      return parama;
    }
    catch (IOException parama)
    {
      o.c("MicroMsg.RemoteDebugUtil", parama.getMessage());
    }
    return ByteBuffer.allocate(0);
  }
  
  public static void a(com.tencent.luggage.wxa.dx.a parama)
  {
    b = parama;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean a(e parame, jt paramjt, jn paramjn, m paramm, i parami)
  {
    if (paramjt == null)
    {
      o.c("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      return false;
    }
    int i = paramjt.a;
    if (paramjn == null)
    {
      o.c("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      return false;
    }
    if (i == 1006) {
      if (-50011 == paramjn.a)
      {
        parame.a(true);
      }
      else
      {
        boolean bool = parame.u();
        parame.a(false);
        if (bool) {
          parami.b();
        }
      }
    }
    if (paramjn.a == 0) {
      return true;
    }
    o.d("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramjt.b, Integer.valueOf(paramjn.a), paramjn.b });
    paramm.a(i, paramjn);
    return false;
  }
  
  public static b b(com.tencent.luggage.wxa.qu.a parama)
  {
    try
    {
      parama = b.a(parama.b());
      return parama;
    }
    catch (IOException parama)
    {
      o.c("MicroMsg.RemoteDebugUtil", parama.getMessage());
    }
    return b.a(new byte[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l
 * JD-Core Version:    0.7.0.1
 */