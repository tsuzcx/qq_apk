package com.tencent.luggage.wxa.hd;

import com.tencent.luggage.wxa.qz.o;
import java.util.Locale;
import java.util.Map;

public final class f$b
{
  public static void a(int paramInt)
  {
    d locald = f.b();
    if (locald != null) {
      locald.a(1132L, paramInt, 1L, false);
    }
  }
  
  public static void a(int paramInt, f.a parama)
  {
    f.a locala = parama;
    if (parama == null) {
      locala = new f.a();
    }
    if (locala.f != null) {
      parama = locala.f.replace(",", ";");
    } else {
      parama = "";
    }
    b(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(f.c().size()), Integer.valueOf(f.d().size()), Integer.valueOf(f.e().size()), Integer.valueOf(f.f().size()), Boolean.valueOf(locala.b), locala.d, locala.e, parama, locala.c }));
  }
  
  public static void a(int paramInt, String paramString)
  {
    b(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(f.c().size()), Integer.valueOf(f.d().size()), Integer.valueOf(f.e().size()), Integer.valueOf(f.f().size()), Boolean.valueOf(false), "", "", "", paramString }));
  }
  
  private static void b(int paramInt, String paramString)
  {
    d locald = f.b();
    boolean bool;
    if ((locald != null) && (locald.a())) {
      bool = true;
    } else {
      bool = false;
    }
    o.d("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
    if (!bool) {
      return;
    }
    locald.a(17952, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.f.b
 * JD-Core Version:    0.7.0.1
 */