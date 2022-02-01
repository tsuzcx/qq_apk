package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibHolder;", "", "()V", "READER", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "TAG", "", "_reader", "syncObj", "", "ensureReader", "", "ipcGetReader", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class r
{
  public static final r a = new r();
  private static n b;
  private static final byte[] c = new byte[0];
  
  @JvmStatic
  @JvmName(name="READER")
  @NotNull
  public static final n b()
  {
    synchronized (c)
    {
      n localn = b;
      if (localn == null) {
        Intrinsics.throwUninitializedPropertyAccessException("_reader");
      }
      return localn;
    }
  }
  
  /* Error */
  private final n c()
  {
    // Byte code:
    //   0: invokestatic 66	com/tencent/luggage/wxa/qz/af:b	()J
    //   3: lstore_1
    //   4: invokestatic 72	com/tencent/luggage/wxa/qz/r:i	()Ljava/lang/String;
    //   7: getstatic 77	com/tencent/luggage/wxa/hu/d:a	Lcom/tencent/luggage/wxa/hu/d;
    //   10: checkcast 79	android/os/Parcelable
    //   13: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/r$a:a	Lcom/tencent/mm/plugin/appbrand/appcache/r$a;
    //   16: invokevirtual 88	java/lang/Object:getClass	()Ljava/lang/Class;
    //   19: invokestatic 93	com/tencent/luggage/wxa/hj/h:a	(Ljava/lang/String;Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;
    //   22: checkcast 95	com/tencent/mm/plugin/appbrand/appstorage/n
    //   25: astore_3
    //   26: new 97	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 100
    //   39: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: invokestatic 66	com/tencent/luggage/wxa/qz/af:b	()J
    //   48: lload_1
    //   49: lsub
    //   50: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 4
    //   56: ldc 109
    //   58: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 111
    //   64: aload 4
    //   66: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 120	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: goto +61 -> 133
    //   75: astore_3
    //   76: goto +93 -> 169
    //   79: astore_3
    //   80: new 97	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload 4
    //   91: ldc 122
    //   93: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: aload_3
    //   100: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 111
    //   106: aload 4
    //   108: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 127	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: getstatic 132	com/tencent/mm/plugin/appbrand/appcache/c:a	Lcom/tencent/mm/plugin/appbrand/appcache/c;
    //   117: checkcast 95	com/tencent/mm/plugin/appbrand/appstorage/n
    //   120: astore_3
    //   121: new 97	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   128: astore 4
    //   130: goto -95 -> 35
    //   133: new 97	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   140: astore 4
    //   142: aload 4
    //   144: ldc 134
    //   146: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 4
    //   152: aload_3
    //   153: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 111
    //   159: aload 4
    //   161: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 120	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_3
    //   168: areturn
    //   169: new 97	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   176: astore 4
    //   178: aload 4
    //   180: ldc 100
    //   182: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: invokestatic 66	com/tencent/luggage/wxa/qz/af:b	()J
    //   191: lload_1
    //   192: lsub
    //   193: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 4
    //   199: ldc 109
    //   201: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 111
    //   207: aload 4
    //   209: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 120	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto +5 -> 220
    //   218: aload_3
    //   219: athrow
    //   220: goto -2 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	r
    //   3	189	1	l	long
    //   25	1	3	localn1	n
    //   75	1	3	localObject	Object
    //   79	21	3	localException	java.lang.Exception
    //   120	99	3	localn2	n
    //   33	175	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	26	75	finally
    //   80	121	75	finally
    //   4	26	79	java/lang/Exception
  }
  
  public final void a()
  {
    if (b == null) {
      synchronized (c)
      {
        if (b == null)
        {
          localObject1 = a.c();
          if (localObject1 == null)
          {
            localObject1 = c.a;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "AssetReader.INSTANCE");
            localObject1 = (n)localObject1;
          }
          b = (n)localObject1;
          localObject1 = b;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_reader");
          }
          ((n)localObject1).d();
        }
        Object localObject1 = Unit.INSTANCE;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.r
 * JD-Core Version:    0.7.0.1
 */