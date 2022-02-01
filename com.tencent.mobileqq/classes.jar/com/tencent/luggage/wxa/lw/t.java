package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.ipc.b;

class t
  extends b
{
  public static final Parcelable.Creator<t> CREATOR = new t.1();
  public String a;
  public int b;
  public Runnable c;
  public String d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  private void a(String paramString)
  {
    int m = paramString.length();
    int n = this.f;
    if (m != this.g + n + this.h) {
      return;
    }
    this.i = paramString.substring(0, n);
    m = this.f;
    this.j = paramString.substring(m, this.g + m);
    m = this.f;
    n = this.g;
    this.k = paramString.substring(m + n, m + n + this.h);
  }
  
  private void c()
  {
    this.i = null;
    this.j = null;
    this.k = null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/tencent/luggage/wxa/lw/t:e	Z
    //   4: ifeq +50 -> 54
    //   7: aload_0
    //   8: aload_0
    //   9: invokevirtual 63	com/tencent/luggage/wxa/lw/t:d	()Ljava/lang/String;
    //   12: invokestatic 68	com/tencent/luggage/wxa/lw/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 70	com/tencent/luggage/wxa/lw/t:a	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 63	com/tencent/luggage/wxa/lw/t:d	()Ljava/lang/String;
    //   22: invokestatic 72	com/tencent/luggage/wxa/lw/u:b	(Ljava/lang/String;)V
    //   25: goto +29 -> 54
    //   28: astore_1
    //   29: goto +16 -> 45
    //   32: astore_1
    //   33: ldc 74
    //   35: aload_1
    //   36: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   39: invokestatic 82	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: goto -24 -> 18
    //   45: aload_0
    //   46: invokevirtual 63	com/tencent/luggage/wxa/lw/t:d	()Ljava/lang/String;
    //   49: invokestatic 72	com/tencent/luggage/wxa/lw/u:b	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: athrow
    //   54: ldc 84
    //   56: invokestatic 89	com/tencent/luggage/wxa/ba/e:a	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/b;
    //   59: ifnonnull +8 -> 67
    //   62: aconst_null
    //   63: astore_1
    //   64: goto +17 -> 81
    //   67: ldc 84
    //   69: invokestatic 89	com/tencent/luggage/wxa/ba/e:a	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/b;
    //   72: checkcast 84	com/tencent/luggage/wxa/dp/a
    //   75: invokeinterface 92 1 0
    //   80: astore_1
    //   81: aload_1
    //   82: ifnonnull +19 -> 101
    //   85: aload_0
    //   86: ldc 94
    //   88: putfield 96	com/tencent/luggage/wxa/lw/t:d	Ljava/lang/String;
    //   91: aload_0
    //   92: invokespecial 98	com/tencent/luggage/wxa/lw/t:c	()V
    //   95: aload_0
    //   96: invokevirtual 101	com/tencent/luggage/wxa/lw/t:e	()Z
    //   99: pop
    //   100: return
    //   101: ldc 103
    //   103: monitorenter
    //   104: aload_1
    //   105: aload_0
    //   106: getfield 105	com/tencent/luggage/wxa/lw/t:b	I
    //   109: aload_0
    //   110: getfield 107	com/tencent/luggage/wxa/lw/t:a	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 52	com/tencent/luggage/wxa/lw/t:i	Ljava/lang/String;
    //   117: aload_0
    //   118: getfield 54	com/tencent/luggage/wxa/lw/t:j	Ljava/lang/String;
    //   121: aload_0
    //   122: getfield 56	com/tencent/luggage/wxa/lw/t:k	Ljava/lang/String;
    //   125: invokevirtual 110	com/tencent/mm/plugin/appbrand/appstorage/c:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appstorage/m$a;
    //   128: astore_1
    //   129: ldc 103
    //   131: monitorexit
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 113	com/tencent/luggage/wxa/lw/u:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/m$a;)Ljava/lang/String;
    //   137: putfield 96	com/tencent/luggage/wxa/lw/t:d	Ljava/lang/String;
    //   140: aload_0
    //   141: invokespecial 98	com/tencent/luggage/wxa/lw/t:c	()V
    //   144: aload_0
    //   145: invokevirtual 101	com/tencent/luggage/wxa/lw/t:e	()Z
    //   148: pop
    //   149: return
    //   150: astore_1
    //   151: ldc 103
    //   153: monitorexit
    //   154: goto +5 -> 159
    //   157: aload_1
    //   158: athrow
    //   159: goto -2 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	t
    //   28	1	1	localObject1	java.lang.Object
    //   32	21	1	localException	Exception
    //   63	71	1	localObject2	java.lang.Object
    //   150	8	1	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   7	18	28	finally
    //   33	42	28	finally
    //   7	18	32	java/lang/Exception
    //   104	132	150	finally
    //   151	154	150	finally
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
    this.e = bool;
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (u.a(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.f = u.a(new String[] { paramString1 });
      this.g = u.a(new String[] { paramString2 });
      this.h = u.a(new String[] { paramString3 });
      try
      {
        u.a(d(), new String[] { paramString1, paramString2, paramString3 });
      }
      catch (Exception paramString1)
      {
        o.b("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
      }
      this.e = true;
      return;
    }
    this.e = false;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramString3;
  }
  
  public void b()
  {
    Runnable localRunnable = this.c;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.t
 * JD-Core Version:    0.7.0.1
 */