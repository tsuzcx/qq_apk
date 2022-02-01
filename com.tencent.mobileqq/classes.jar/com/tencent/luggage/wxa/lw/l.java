package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.ipc.b;

class l
  extends b
{
  public static final Parcelable.Creator<l> CREATOR = new l.1();
  public String a;
  public int b;
  public Runnable c;
  public String d;
  public String e;
  public String f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  
  private void a(String paramString)
  {
    int k = paramString.length();
    int m = this.i;
    if (k != this.j + m) {
      return;
    }
    this.e = paramString.substring(0, m);
    k = this.i;
    this.f = paramString.substring(k, this.j + k);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (u.a(new String[] { paramString1, paramString2 }) > 102400)
    {
      this.i = u.a(new String[] { paramString1 });
      this.j = u.a(new String[] { paramString2 });
      try
      {
        u.a(d(), new String[] { paramString1, paramString2 });
      }
      catch (Exception paramString1)
      {
        o.b("MicroMsg.JsApiGetStorageTask", paramString1.getMessage());
      }
      this.g = true;
      return;
    }
    this.g = false;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public void a()
  {
    if ((a)e.a(a.class) == null)
    {
      e();
      return;
    }
    Object localObject = ((a)e.a(a.class)).a();
    if (localObject == null)
    {
      e();
      return;
    }
    localObject = ((c)localObject).a(this.b, this.a, this.d);
    if ((m.a)localObject[0] == m.a.a) {
      a((String)localObject[1], (String)localObject[2]);
    }
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/tencent/luggage/wxa/lw/l:g	Z
    //   4: ifeq +50 -> 54
    //   7: aload_0
    //   8: aload_0
    //   9: invokevirtual 63	com/tencent/luggage/wxa/lw/l:d	()Ljava/lang/String;
    //   12: invokestatic 126	com/tencent/luggage/wxa/lw/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 128	com/tencent/luggage/wxa/lw/l:a	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 63	com/tencent/luggage/wxa/lw/l:d	()Ljava/lang/String;
    //   22: invokestatic 130	com/tencent/luggage/wxa/lw/u:b	(Ljava/lang/String;)V
    //   25: goto +29 -> 54
    //   28: astore_1
    //   29: goto +16 -> 45
    //   32: astore_1
    //   33: ldc 68
    //   35: aload_1
    //   36: invokevirtual 71	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   39: invokestatic 75	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: goto -24 -> 18
    //   45: aload_0
    //   46: invokevirtual 63	com/tencent/luggage/wxa/lw/l:d	()Ljava/lang/String;
    //   49: invokestatic 130	com/tencent/luggage/wxa/lw/u:b	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: athrow
    //   54: aload_0
    //   55: getfield 132	com/tencent/luggage/wxa/lw/l:c	Ljava/lang/Runnable;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +9 -> 69
    //   63: aload_1
    //   64: invokeinterface 137 1 0
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	l
    //   28	1	1	localObject	Object
    //   32	21	1	localException	Exception
    //   58	6	1	localRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   7	18	28	finally
    //   33	42	28	finally
    //   7	18	32	java/lang/Exception
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.l
 * JD-Core Version:    0.7.0.1
 */