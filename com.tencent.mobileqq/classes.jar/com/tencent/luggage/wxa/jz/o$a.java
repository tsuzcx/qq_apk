package com.tencent.luggage.wxa.jz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.gz.e;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class o$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new o.a.1();
  c.c a;
  public com.tencent.luggage.wxa.jx.c b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  private m j;
  private boolean k = false;
  private final com.tencent.luggage.wxa.qy.c l = new o.a.2(this);
  
  public o$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public o$a(com.tencent.luggage.wxa.jx.a parama, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    this.j = parama;
    this.b = paramc;
    this.c = paramInt;
  }
  
  public void a()
  {
    o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
    if (this.k)
    {
      o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
      this.k = false;
      localObject = new e();
      ((e)localObject).a.a = 10;
      ((e)localObject).a.e = "preempted";
      ((e)localObject).a.h = this.g;
      ((e)localObject).a.f = true;
      com.tencent.luggage.wxa.qy.a.a.a((com.tencent.luggage.wxa.qy.b)localObject);
    }
    Object localObject = com.tencent.luggage.wxa.nr.b.b().c();
    if (!af.c((String)localObject))
    {
      o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.g });
      com.tencent.luggage.wxa.nr.b.b().c((String)localObject);
    }
    com.tencent.luggage.wxa.nr.b.b().a(this.l, this.g);
    com.tencent.luggage.wxa.nr.b.b().a(this.g, this.d, this.e, this.f);
  }
  
  protected void a(int paramInt) {}
  
  public void a(Parcel paramParcel)
  {
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    int m = paramParcel.readInt();
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    this.k = bool;
  }
  
  public void b()
  {
    if (this.b == null)
    {
      o.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
      return;
    }
    a(this.i);
    switch (this.i)
    {
    case 5: 
    case 6: 
    case 9: 
    default: 
      break;
    case 14: 
      l.a.a(this.b);
      return;
    case 13: 
      l.b.a(this.b);
      return;
    case 2: 
    case 3: 
    case 4: 
    case 7: 
      com.tencent.luggage.wxa.iu.c.b(this.g, this.a);
      break;
    case 0: 
    case 1: 
      com.tencent.luggage.wxa.iu.c.a(this.g, this.a);
      com.tencent.luggage.wxa.nr.a.b.a(this.g);
    }
    o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.i), this.h });
    new l.c().b(this.b).b(this.h).a();
    com.tencent.luggage.wxa.nr.a.b.a(this.i);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.o.a
 * JD-Core Version:    0.7.0.1
 */