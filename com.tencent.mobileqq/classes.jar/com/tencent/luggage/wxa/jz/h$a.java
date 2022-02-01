package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class h$a
  extends a
{
  public c a;
  public int b;
  public String c = "";
  public String d = "";
  public int e = 0;
  public int f;
  public int g;
  public int h;
  public String i;
  public int j;
  public double k;
  public String l = null;
  public boolean m = false;
  public String n;
  private m o;
  
  public h$a(m paramm, c paramc, int paramInt)
  {
    this.o = paramm;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public void c()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("duration", Integer.valueOf(this.e));
    ((Map)localObject).put("currentTime", Integer.valueOf(this.f));
    boolean bool;
    if (this.g == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((Map)localObject).put("paused", Boolean.valueOf(bool));
    ((Map)localObject).put("buffered", Integer.valueOf(this.h));
    ((Map)localObject).put("src", this.i);
    ((Map)localObject).put("startTime", Integer.valueOf(this.j));
    ((Map)localObject).put("playbackRate", Double.valueOf(this.k));
    ((Map)localObject).put("referrerPolicy", this.l);
    String str;
    if (TextUtils.isEmpty(this.n)) {
      str = "";
    } else {
      str = this.n;
    }
    if (this.m)
    {
      o.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      localObject = this.a;
      int i1 = this.b;
      m localm = this.o;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(str);
      ((c)localObject).a(i1, localm.b(localStringBuilder.toString()));
      return;
    }
    this.a.a(this.b, this.o.a("ok", (Map)localObject));
  }
  
  public void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.h.a
 * JD-Core Version:    0.7.0.1
 */