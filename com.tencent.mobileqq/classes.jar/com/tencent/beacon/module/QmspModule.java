package com.tencent.beacon.module;

import android.content.Context;
import com.tencent.beacon.qimei.QimeiSDK;

public class QmspModule
  implements BeaconModule
{
  private Context a;
  private boolean b;
  private final Runnable c = new QmspModule.1(this);
  
  /* Error */
  private void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 34
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_1
    //   28: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifeq +6 -> 39
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   42: astore 4
    //   44: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   47: invokevirtual 55	com/tencent/beacon/a/c/c:k	()Ljava/lang/String;
    //   50: astore 5
    //   52: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   55: invokevirtual 58	com/tencent/beacon/a/c/c:f	()Ljava/lang/String;
    //   58: astore 6
    //   60: ldc 60
    //   62: iconst_4
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 5
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload 6
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: aload 4
    //   84: invokevirtual 63	com/tencent/beacon/a/c/c:i	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: getfield 65	com/tencent/beacon/module/QmspModule:a	Landroid/content/Context;
    //   95: aload 5
    //   97: aload_1
    //   98: aload 6
    //   100: aload 4
    //   102: invokevirtual 63	com/tencent/beacon/a/c/c:i	()Ljava/lang/String;
    //   105: invokestatic 68	com/tencent/beacon/base/util/c:a	()Z
    //   108: invokestatic 74	com/tencent/qmsp/sdk/u/U:startQ	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)I
    //   111: istore_2
    //   112: invokestatic 79	com/tencent/beacon/a/b/a:a	()Lcom/tencent/beacon/a/b/a;
    //   115: bipush 114
    //   117: lconst_0
    //   118: ldc2_w 80
    //   121: aload_0
    //   122: getfield 23	com/tencent/beacon/module/QmspModule:c	Ljava/lang/Runnable;
    //   125: invokevirtual 84	com/tencent/beacon/a/b/a:a	(IJJLjava/lang/Runnable;)V
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   133: goto +45 -> 178
    //   136: astore_1
    //   137: goto +6 -> 143
    //   140: astore_1
    //   141: iconst_0
    //   142: istore_2
    //   143: ldc 86
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: iload_2
    //   152: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_1
    //   159: invokevirtual 95	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 97	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_1
    //   167: invokestatic 100	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   170: invokestatic 103	com/tencent/qmsp/sdk/u/U:stopQ	()V
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   178: ldc 105
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: iload_2
    //   187: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_0
    //   195: monitorexit
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	QmspModule
    //   0	202	1	paramString	java.lang.String
    //   111	76	2	i	int
    //   6	27	3	bool	boolean
    //   42	59	4	localc	com.tencent.beacon.a.c.c
    //   50	46	5	str1	java.lang.String
    //   58	41	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   112	133	136	java/lang/Throwable
    //   60	112	140	java/lang/Throwable
    //   2	7	197	finally
    //   14	32	197	finally
    //   39	60	197	finally
    //   60	112	197	finally
    //   112	133	197	finally
    //   143	178	197	finally
    //   178	194	197	finally
  }
  
  public void a(Context paramContext)
  {
    if (!com.tencent.beacon.a.c.c.d().l())
    {
      com.tencent.beacon.base.util.c.a("qmsp disable by user", new Object[0]);
      return;
    }
    this.a = paramContext;
    QimeiSDK.getInstance().getQimei(new QmspModule.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.QmspModule
 * JD-Core Version:    0.7.0.1
 */