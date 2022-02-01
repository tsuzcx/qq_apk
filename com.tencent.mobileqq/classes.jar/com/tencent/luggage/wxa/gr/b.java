package com.tencent.luggage.wxa.gr;

import android.text.TextUtils;

public class b
  implements g
{
  private boolean a = false;
  private volatile boolean b = true;
  private e c;
  private com.tencent.luggage.wxa.if.b d;
  
  public b(e parame)
  {
    this.c = parame;
  }
  
  public void a(c paramc)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "download process end, download finish:%b", new Object[] { Boolean.valueOf(this.a) });
    d.b(paramc);
    e locale;
    if (this.a)
    {
      locale = this.c;
      if (locale != null) {
        locale.a(this.d);
      }
    }
    else
    {
      locale = this.c;
      if (locale != null) {
        locale.b(this.d);
      }
    }
    this.b = true;
    paramc.a();
    this.c = null;
  }
  
  public void a(com.tencent.luggage.wxa.gv.c paramc)
  {
    this.b = false;
    if (paramc == null)
    {
      paramc = this.c;
      if (paramc != null) {
        paramc.b(null);
      }
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDownloadProcess", "process source is null");
      this.b = true;
      return;
    }
    this.a = false;
    Object localObject1 = paramc.a();
    if (localObject1 != null) {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "audio:%s, url:%s", new Object[] { ((com.tencent.luggage.wxa.if.b)localObject1).a, ((com.tencent.luggage.wxa.if.b)localObject1).b });
    }
    this.d = ((com.tencent.luggage.wxa.if.b)localObject1);
    paramc.b();
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "source connect, stop:%b", new Object[] { Boolean.valueOf(this.b) });
    long l2 = -1L;
    localObject1 = "";
    int i = 0;
    while ((i < 3) && (!this.b))
    {
      int j = i + 1;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = paramc.d();
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramc.e();
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "fileSize:%d, mimetype:%s, tryCount:%d", new Object[] { Long.valueOf(l1), localObject2, Integer.valueOf(j) });
      i = j;
      l2 = l1;
      localObject1 = localObject2;
      if (l1 > 0L) {
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          i = j;
          l2 = l1;
          localObject1 = localObject2;
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("text/")))
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDownloadProcess", "mimetype not support");
        }
        else
        {
          localObject1 = new byte[8192];
          i = 0;
          for (;;)
          {
            l2 = i;
            if ((l2 >= l1) || (this.b)) {
              break;
            }
            j = paramc.a(l2, (byte[])localObject1, 0, 8192);
            if (j < 0)
            {
              com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDownloadProcess", "readSize:%d, terminal process or read end", new Object[] { Integer.valueOf(j) });
              break;
            }
            i += j;
          }
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "offSize:%d", new Object[] { Integer.valueOf(i) });
          this.a = true;
        }
      }
    }
    paramc.c();
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDownloadProcess", "source disconnect");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gr.b
 * JD-Core Version:    0.7.0.1
 */