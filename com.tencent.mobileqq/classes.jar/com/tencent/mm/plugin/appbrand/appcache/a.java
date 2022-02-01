package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.io.InputStream;

public abstract class a
  implements n
{
  private volatile String a;
  private volatile String b;
  private volatile String c;
  private volatile i d;
  
  @NonNull
  private i e()
  {
    if (this.d == null) {
      try
      {
        if (this.d == null)
        {
          String str = a("WAVersion.json");
          if (TextUtils.isEmpty(str)) {
            o.b("MicroMsg.AppBrand.AbsReader", "getVersionMetaJson EMPTY WAVersion.json, info=%s", new Object[] { f() });
          }
          try
          {
            i locali1;
            if (TextUtils.isEmpty(str)) {
              locali1 = new i();
            } else {
              locali1 = new i(str);
            }
            this.d = locali1;
          }
          catch (g localg)
          {
            o.a("MicroMsg.AppBrand.AbsReader", localg, "parse WAVersion.json[%s] ", new Object[] { str });
            i locali2 = new i();
            return locali2;
          }
        }
      }
      finally {}
    }
    return this.d;
  }
  
  public final int a(n paramn)
  {
    if (paramn == null) {
      return -1;
    }
    if ((paramn.getClass() == getClass()) && (paramn.c() > 0) && (paramn.c() == c())) {
      return 0;
    }
    return a().compareTo(paramn.a());
  }
  
  /* Error */
  @NonNull
  public final String a()
  {
    // Byte code:
    //   0: ldc 83
    //   2: astore 4
    //   4: aload_0
    //   5: getfield 85	com/tencent/mm/plugin/appbrand/appcache/a:a	Ljava/lang/String;
    //   8: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +123 -> 134
    //   14: aload_0
    //   15: invokespecial 87	com/tencent/mm/plugin/appbrand/appcache/a:e	()Lcom/tencent/luggage/wxa/hv/i;
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 89
    //   22: invokevirtual 92	com/tencent/luggage/wxa/hv/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_1
    //   27: ldc 94
    //   29: invokevirtual 92	com/tencent/luggage/wxa/hv/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_1
    //   33: ldc 37
    //   35: ldc 96
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_2
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_1
    //   48: aastore
    //   49: invokestatic 98	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: goto +32 -> 84
    //   55: astore_3
    //   56: goto +16 -> 72
    //   59: astore_3
    //   60: ldc 83
    //   62: astore_1
    //   63: goto +9 -> 72
    //   66: astore_3
    //   67: ldc 83
    //   69: astore_1
    //   70: aload_1
    //   71: astore_2
    //   72: ldc 37
    //   74: aload_3
    //   75: ldc 100
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 59	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: ifnonnull +9 -> 94
    //   88: aload 4
    //   90: astore_2
    //   91: goto +3 -> 94
    //   94: aload_0
    //   95: aload_2
    //   96: putfield 85	com/tencent/mm/plugin/appbrand/appcache/a:a	Ljava/lang/String;
    //   99: aload_0
    //   100: aload_1
    //   101: putfield 102	com/tencent/mm/plugin/appbrand/appcache/a:b	Ljava/lang/String;
    //   104: aload_0
    //   105: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   108: ldc 110
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_0
    //   117: getfield 85	com/tencent/mm/plugin/appbrand/appcache/a:a	Ljava/lang/String;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_0
    //   124: getfield 102	com/tencent/mm/plugin/appbrand/appcache/a:b	Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 114	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: putfield 116	com/tencent/mm/plugin/appbrand/appcache/a:c	Ljava/lang/String;
    //   134: aload_0
    //   135: getfield 85	com/tencent/mm/plugin/appbrand/appcache/a:a	Ljava/lang/String;
    //   138: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	a
    //   18	83	1	localObject1	Object
    //   25	71	2	localObject2	Object
    //   55	1	3	localException1	java.lang.Exception
    //   59	1	3	localException2	java.lang.Exception
    //   66	9	3	localException3	java.lang.Exception
    //   2	87	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	52	55	java/lang/Exception
    //   26	33	59	java/lang/Exception
    //   14	26	66	java/lang/Exception
  }
  
  public final String a(String paramString)
  {
    InputStream localInputStream = c(paramString);
    if (localInputStream == null) {
      return null;
    }
    long l = af.b();
    String str = c.a(localInputStream);
    af.a(localInputStream);
    o.f("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", new Object[] { paramString, Long.valueOf(af.b() - l) });
    return str;
  }
  
  @NonNull
  public final String b()
  {
    a();
    return af.b(this.c);
  }
  
  @Nullable
  public final String b(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    i locali = e().i("features");
    if (locali == null) {
      return null;
    }
    return locali.optString(paramString, null);
  }
  
  public final int c()
  {
    return f().pkgVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a
 * JD-Core Version:    0.7.0.1
 */