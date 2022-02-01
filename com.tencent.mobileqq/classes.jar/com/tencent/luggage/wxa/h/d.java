package com.tencent.luggage.wxa.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.luggage.wxa.ad.j;
import com.tencent.luggage.wxa.ad.j.a;
import com.tencent.luggage.wxa.ap.g;
import com.tencent.luggage.wxa.v.f;
import com.tencent.luggage.wxa.v.f.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class d
  implements v
{
  private final Context a;
  private final com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> b;
  private final int c;
  private final long d;
  
  public d(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public d(Context paramContext, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc)
  {
    this(paramContext, paramc, 0);
  }
  
  public d(Context paramContext, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc, int paramInt)
  {
    this(paramContext, paramc, paramInt, 5000L);
  }
  
  public d(Context paramContext, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc, int paramInt, long paramLong)
  {
    this.a = paramContext;
    this.b = paramc;
    this.c = paramInt;
    this.d = paramLong;
  }
  
  protected void a(Context paramContext, Handler paramHandler, int paramInt, ArrayList<s> paramArrayList) {}
  
  protected void a(Context paramContext, j.a parama, Looper paramLooper, int paramInt, ArrayList<s> paramArrayList)
  {
    paramArrayList.add(new j(parama, paramLooper));
  }
  
  protected void a(Context paramContext, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc, long paramLong, Handler paramHandler, g paramg, int paramInt, ArrayList<s> paramArrayList)
  {
    paramArrayList.add(new com.tencent.luggage.wxa.ap.e(paramContext, com.tencent.luggage.wxa.u.c.a, paramLong, paramc, false, paramHandler, paramg, 50));
    if (paramInt == 0) {
      return;
    }
    int j = paramArrayList.size();
    int i = j;
    if (paramInt == 2) {
      i = j - 1;
    }
    try
    {
      paramArrayList.add(i, (s)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[] { Boolean.TYPE, Long.TYPE, Handler.class, g.class, Integer.TYPE }).newInstance(new Object[] { Boolean.valueOf(true), Long.valueOf(paramLong), paramHandler, paramg, Integer.valueOf(50) }));
      Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
      return;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (ClassNotFoundException paramContext) {}
  }
  
  /* Error */
  protected void a(Context paramContext, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc, com.tencent.luggage.wxa.i.d[] paramArrayOfd, Handler paramHandler, com.tencent.luggage.wxa.i.e parame, int paramInt, ArrayList<s> paramArrayList)
  {
    // Byte code:
    //   0: aload 7
    //   2: new 146	com/tencent/luggage/wxa/i/i
    //   5: dup
    //   6: getstatic 71	com/tencent/luggage/wxa/u/c:a	Lcom/tencent/luggage/wxa/u/c;
    //   9: aload_2
    //   10: iconst_1
    //   11: aload 4
    //   13: aload 5
    //   15: aload_1
    //   16: invokestatic 151	com/tencent/luggage/wxa/i/c:a	(Landroid/content/Context;)Lcom/tencent/luggage/wxa/i/c;
    //   19: aload_3
    //   20: invokespecial 154	com/tencent/luggage/wxa/i/i:<init>	(Lcom/tencent/luggage/wxa/u/c;Lcom/tencent/luggage/wxa/k/c;ZLandroid/os/Handler;Lcom/tencent/luggage/wxa/i/e;Lcom/tencent/luggage/wxa/i/c;[Lcom/tencent/luggage/wxa/i/d;)V
    //   23: invokevirtual 58	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: iload 6
    //   29: ifne +4 -> 33
    //   32: return
    //   33: aload 7
    //   35: invokevirtual 78	java/util/ArrayList:size	()I
    //   38: istore 9
    //   40: iload 9
    //   42: istore 8
    //   44: iload 6
    //   46: iconst_2
    //   47: if_icmpne +9 -> 56
    //   50: iload 9
    //   52: iconst_1
    //   53: isub
    //   54: istore 8
    //   56: ldc 156
    //   58: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   61: iconst_3
    //   62: anewarray 82	java/lang/Class
    //   65: dup
    //   66: iconst_0
    //   67: ldc 97
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc 158
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc 160
    //   79: aastore
    //   80: invokevirtual 106	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   83: iconst_3
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload 4
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload 5
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload_3
    //   100: aastore
    //   101: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 124	com/tencent/luggage/wxa/h/s
    //   107: astore_1
    //   108: iload 8
    //   110: iconst_1
    //   111: iadd
    //   112: istore 6
    //   114: aload 7
    //   116: iload 8
    //   118: aload_1
    //   119: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   122: ldc 129
    //   124: ldc 162
    //   126: invokestatic 137	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: goto +17 -> 147
    //   133: astore_1
    //   134: new 139	java/lang/RuntimeException
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 142	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   142: athrow
    //   143: iload 8
    //   145: istore 6
    //   147: ldc 164
    //   149: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   152: iconst_3
    //   153: anewarray 82	java/lang/Class
    //   156: dup
    //   157: iconst_0
    //   158: ldc 97
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: ldc 158
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: ldc 160
    //   170: aastore
    //   171: invokevirtual 106	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   174: iconst_3
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload 4
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 5
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload_3
    //   191: aastore
    //   192: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   195: checkcast 124	com/tencent/luggage/wxa/h/s
    //   198: astore_1
    //   199: iload 6
    //   201: iconst_1
    //   202: iadd
    //   203: istore 8
    //   205: aload 7
    //   207: iload 6
    //   209: aload_1
    //   210: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   213: ldc 129
    //   215: ldc 166
    //   217: invokestatic 137	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: iload 8
    //   223: istore 6
    //   225: goto +13 -> 238
    //   228: astore_1
    //   229: new 139	java/lang/RuntimeException
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 142	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   237: athrow
    //   238: aload 7
    //   240: iload 6
    //   242: ldc 168
    //   244: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   247: iconst_3
    //   248: anewarray 82	java/lang/Class
    //   251: dup
    //   252: iconst_0
    //   253: ldc 97
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: ldc 158
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: ldc 160
    //   265: aastore
    //   266: invokevirtual 106	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   269: iconst_3
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 4
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 5
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: aload_3
    //   286: aastore
    //   287: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   290: checkcast 124	com/tencent/luggage/wxa/h/s
    //   293: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   296: ldc 129
    //   298: ldc 170
    //   300: invokestatic 137	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   303: pop
    //   304: return
    //   305: astore_1
    //   306: new 139	java/lang/RuntimeException
    //   309: dup
    //   310: aload_1
    //   311: invokespecial 142	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   314: athrow
    //   315: astore_1
    //   316: goto -173 -> 143
    //   319: astore_1
    //   320: goto -173 -> 147
    //   323: astore_1
    //   324: goto -86 -> 238
    //   327: astore_1
    //   328: iload 8
    //   330: istore 6
    //   332: goto -94 -> 238
    //   335: astore_1
    //   336: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	d
    //   0	337	1	paramContext	Context
    //   0	337	2	paramc	com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e>
    //   0	337	3	paramArrayOfd	com.tencent.luggage.wxa.i.d[]
    //   0	337	4	paramHandler	Handler
    //   0	337	5	parame	com.tencent.luggage.wxa.i.e
    //   0	337	6	paramInt	int
    //   0	337	7	paramArrayList	ArrayList<s>
    //   42	287	8	i	int
    //   38	16	9	j	int
    // Exception table:
    //   from	to	target	type
    //   56	108	133	java/lang/Exception
    //   114	130	133	java/lang/Exception
    //   147	199	228	java/lang/Exception
    //   205	221	228	java/lang/Exception
    //   238	304	305	java/lang/Exception
    //   56	108	315	java/lang/ClassNotFoundException
    //   114	130	319	java/lang/ClassNotFoundException
    //   147	199	323	java/lang/ClassNotFoundException
    //   205	221	327	java/lang/ClassNotFoundException
    //   238	304	335	java/lang/ClassNotFoundException
  }
  
  protected void a(Context paramContext, f.a parama, Looper paramLooper, int paramInt, ArrayList<s> paramArrayList)
  {
    paramArrayList.add(new f(parama, paramLooper));
  }
  
  public s[] a(Handler paramHandler, g paramg, com.tencent.luggage.wxa.i.e parame, j.a parama, f.a parama1)
  {
    ArrayList localArrayList = new ArrayList();
    a(this.a, this.b, this.d, paramHandler, paramg, this.c, localArrayList);
    a(this.a, this.b, a(), paramHandler, parame, this.c, localArrayList);
    a(this.a, parama, paramHandler.getLooper(), this.c, localArrayList);
    a(this.a, parama1, paramHandler.getLooper(), this.c, localArrayList);
    a(this.a, paramHandler, this.c, localArrayList);
    return (s[])localArrayList.toArray(new s[localArrayList.size()]);
  }
  
  protected com.tencent.luggage.wxa.i.d[] a()
  {
    return new com.tencent.luggage.wxa.i.d[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.d
 * JD-Core Version:    0.7.0.1
 */