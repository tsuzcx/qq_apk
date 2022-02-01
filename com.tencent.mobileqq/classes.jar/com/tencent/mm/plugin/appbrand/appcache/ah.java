package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getPluginStringVersion", "", "id", "version", "", "hasRecord", "", "record", "insertOrUpdate", "runInDataBaseTransaction", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class ah
  extends com.tencent.luggage.wxa.oz.b<ag>
{
  @Deprecated
  public static final ah.a a = new ah.a(null);
  private final c c;
  
  public ah(@NotNull c paramc)
  {
    super((com.tencent.luggage.wxa.rb.b)paramc, ag.f, "WxaPluginCodeVersionInfo", ag.a);
    this.c = paramc;
  }
  
  private final <R> R a(Function0<? extends R> paramFunction0)
  {
    c localc = this.c;
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    long l = localc.a(localThread.getId());
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      this.c.b(l);
    }
  }
  
  private final boolean a(ag paramag)
  {
    return ((Boolean)a((Function0)new ah.b(this, paramag))).booleanValue();
  }
  
  /* Error */
  private final boolean b(ag paramag)
  {
    // Byte code:
    //   0: new 135	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 139
    //   13: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_0
    //   20: invokevirtual 146	com/tencent/mm/plugin/appbrand/appcache/ah:b	()Ljava/lang/String;
    //   23: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 5
    //   29: ldc 148
    //   31: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 5
    //   37: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 5
    //   42: aload_0
    //   43: getfield 81	com/tencent/mm/plugin/appbrand/appcache/ah:c	Lcom/tencent/luggage/wxa/rb/c;
    //   46: astore 6
    //   48: aload_1
    //   49: getfield 154	com/tencent/mm/plugin/appbrand/appcache/ag:b	Ljava/lang/String;
    //   52: astore 7
    //   54: iconst_0
    //   55: istore 4
    //   57: aload 6
    //   59: aload 5
    //   61: iconst_2
    //   62: anewarray 156	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload 7
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_1
    //   73: getfield 159	com/tencent/mm/plugin/appbrand/appcache/ag:c	I
    //   76: invokestatic 163	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: aastore
    //   80: invokeinterface 166 3 0
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +93 -> 180
    //   90: aload_1
    //   91: checkcast 168	java/io/Closeable
    //   94: astore 6
    //   96: aconst_null
    //   97: checkcast 133	java/lang/Throwable
    //   100: astore 5
    //   102: aload 5
    //   104: astore_1
    //   105: aload 6
    //   107: checkcast 170	android/database/Cursor
    //   110: astore 7
    //   112: iload 4
    //   114: istore_3
    //   115: aload 5
    //   117: astore_1
    //   118: aload 7
    //   120: invokeinterface 173 1 0
    //   125: ifeq +24 -> 149
    //   128: aload 5
    //   130: astore_1
    //   131: aload 7
    //   133: iconst_0
    //   134: invokeinterface 177 2 0
    //   139: istore_2
    //   140: iload 4
    //   142: istore_3
    //   143: iload_2
    //   144: ifle +5 -> 149
    //   147: iconst_1
    //   148: istore_3
    //   149: aload 6
    //   151: aload 5
    //   153: invokestatic 183	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   156: iload_3
    //   157: ireturn
    //   158: astore 5
    //   160: goto +11 -> 171
    //   163: astore 5
    //   165: aload 5
    //   167: astore_1
    //   168: aload 5
    //   170: athrow
    //   171: aload 6
    //   173: aload_1
    //   174: invokestatic 183	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: aload 5
    //   179: athrow
    //   180: iconst_0
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ah
    //   0	182	1	paramag	ag
    //   139	5	2	i	int
    //   114	43	3	bool1	boolean
    //   55	86	4	bool2	boolean
    //   7	145	5	localObject1	Object
    //   158	1	5	localObject2	Object
    //   163	15	5	localThrowable	java.lang.Throwable
    //   46	126	6	localObject3	Object
    //   52	80	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   105	112	158	finally
    //   118	128	158	finally
    //   131	140	158	finally
    //   168	171	158	finally
    //   105	112	163	java/lang/Throwable
    //   118	128	163	java/lang/Throwable
    //   131	140	163	java/lang/Throwable
  }
  
  public final void a(@NotNull String paramString1, int paramInt, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    if (paramString2 != null)
    {
      Object localObject = new ag();
      ((ag)localObject).b = paramString1;
      ((ag)localObject).c = paramInt;
      ((ag)localObject).d = paramString2;
      boolean bool = a((ag)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPluginStringVersion id:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" version:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" stringVersion:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" updated:");
      ((StringBuilder)localObject).append(bool);
      o.d("Luggage.WxaPluginCodeVersionInfoStorage", ((StringBuilder)localObject).toString());
      return;
    }
    paramString2 = (ah)this;
    paramString2 = new StringBuilder();
    paramString2.append("setPluginStringVersion with id:");
    paramString2.append(paramString1);
    paramString2.append(", version:");
    paramString2.append(paramInt);
    paramString2.append(", invalid stringVersion");
    o.b("Luggage.WxaPluginCodeVersionInfoStorage", paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */