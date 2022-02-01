package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.if.b;
import com.tencent.luggage.wxa.if.e;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.nq.f;
import com.tencent.luggage.wxa.nq.g;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.io.Closeable;
import java.nio.ByteBuffer;
import org.apache.commons.io.IOUtils;

class m$c
  extends a
{
  public com.tencent.luggage.wxa.jx.c a;
  public int b;
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public boolean g = false;
  public boolean h = false;
  public v.a i;
  public String j = "";
  public double k;
  public double l;
  public long m;
  public long n;
  public String o = null;
  public String p = null;
  public boolean q = false;
  public String r;
  private m s;
  
  public m$c(m paramm, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    this.s = paramm;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public void c()
  {
    super.c();
    com.tencent.luggage.wxa.jx.c localc = this.a;
    if (localc == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiSetAudioState", "server is null");
      return;
    }
    if (this.q)
    {
      int i1 = this.b;
      m localm = this.s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(this.r);
      localc.a(i1, localm.b(localStringBuilder.toString()));
      return;
    }
    localc.a(this.b, this.s.b("ok"));
  }
  
  public void d()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
    this.q = false;
    this.r = "";
    Object localObject1 = com.tencent.luggage.wxa.if.c.k(this.d);
    b localb = new b();
    localb.a = this.d;
    Object localObject2 = this.e;
    localb.b = ((String)localObject2);
    int i1 = this.f;
    localb.d = i1;
    localb.e = i1;
    localb.g = this.g;
    localb.h = this.h;
    localb.k = this.j;
    localb.l = this.k;
    localb.n = this.c;
    localb.i = 0;
    localb.m = this.l;
    localb.r = this.m;
    localb.s = this.n;
    localb.v = this.o;
    localb.w = this.p;
    if ((localObject1 != null) && (((String)localObject2).equalsIgnoreCase(((b)localObject1).b)) && (com.tencent.luggage.wxa.if.c.d(this.d)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
      if (!com.tencent.luggage.wxa.if.c.a(localb))
      {
        this.q = true;
        this.r = "not to set audio param, the audioId is err";
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
      }
      c();
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.c, this.d, this.e, Integer.valueOf(this.f) });
    if (this.e.startsWith("file://"))
    {
      localb.c = this.e.substring(7);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.c });
    }
    else if ((this.e.contains("base64")) && (this.e.startsWith("data:audio")))
    {
      localObject1 = this.e;
      localb.c = g.a(((String)localObject1).substring(((String)localObject1).indexOf("base64,") + 7).trim());
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", new Object[] { localb.c });
    }
    else if (this.e.startsWith("wxblob://"))
    {
      localObject1 = new com.tencent.luggage.wxa.pc.i();
      if (this.a.getFileSystem().b(this.e, (com.tencent.luggage.wxa.pc.i)localObject1) == j.a)
      {
        localb.C = ((ByteBuffer)((com.tencent.luggage.wxa.pc.i)localObject1).a);
        localb.c = this.e;
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
        localObject1 = this.a.getFileSystem().d(this.e);
        if ((localObject1 != null) && (((com.tencent.luggage.wxa.rt.i)localObject1).j()))
        {
          localb.c = ((com.tencent.luggage.wxa.rt.i)localObject1).l();
        }
        else
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
          this.q = true;
          this.r = "wxblob localFile is null";
        }
      }
    }
    else if ((!this.e.startsWith("http://")) && (!this.e.startsWith("https://")))
    {
      localObject2 = f.a(this.i);
      if ((localObject2 != null) && (((e)localObject2).a()))
      {
        if ((localObject1 != null) && (this.e.equalsIgnoreCase(((b)localObject1).b)) && (!TextUtils.isEmpty(((b)localObject1).c))) {
          localb.c = ((b)localObject1).c;
        } else {
          localb.c = g.b(this.a, this.e);
        }
        localb.y = ((e)localObject2);
      }
      else
      {
        IOUtils.closeQuietly((Closeable)localObject2);
        this.q = true;
        this.r = "the file not exist for src";
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.e });
        c();
        return;
      }
    }
    if (!this.q) {
      com.tencent.luggage.wxa.if.c.b(localb);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.m.c
 * JD-Core Version:    0.7.0.1
 */