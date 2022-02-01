package com.huawei.updatesdk.service.otaupdate;

import android.os.AsyncTask;

class c$b
  extends AsyncTask<Void, Void, Boolean>
{
  c.a a;
  
  public c$b(c.a parama)
  {
    this.a = parama;
  }
  
  /* Error */
  protected Boolean a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: invokestatic 23	com/huawei/updatesdk/a/b/a/a:a	()Lcom/huawei/updatesdk/a/b/a/a;
    //   7: invokevirtual 27	com/huawei/updatesdk/a/b/a/a:b	()Landroid/content/Context;
    //   10: astore_1
    //   11: ldc 29
    //   13: invokestatic 35	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   16: astore 6
    //   18: aload_1
    //   19: invokevirtual 41	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: aload 6
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore 6
    //   33: aload 6
    //   35: ifnull +133 -> 168
    //   38: aload 6
    //   40: astore_1
    //   41: aload 6
    //   43: invokeinterface 53 1 0
    //   48: ifeq +120 -> 168
    //   51: aload 6
    //   53: astore_1
    //   54: aload 6
    //   56: aload 6
    //   58: ldc 55
    //   60: invokeinterface 59 2 0
    //   65: invokeinterface 63 2 0
    //   70: invokestatic 69	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   73: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   76: istore_3
    //   77: aload 6
    //   79: astore_1
    //   80: aload 6
    //   82: aload 6
    //   84: ldc 74
    //   86: invokeinterface 59 2 0
    //   91: invokeinterface 63 2 0
    //   96: invokestatic 69	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   99: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   102: istore 4
    //   104: aload 6
    //   106: astore_1
    //   107: aload 6
    //   109: aload 6
    //   111: ldc 76
    //   113: invokeinterface 59 2 0
    //   118: invokeinterface 63 2 0
    //   123: invokestatic 69	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   126: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   129: istore 5
    //   131: iload_3
    //   132: ifeq +172 -> 304
    //   135: iload 4
    //   137: ifne +167 -> 304
    //   140: iload 5
    //   142: ifne +162 -> 304
    //   145: iconst_1
    //   146: istore_2
    //   147: iload_2
    //   148: istore_3
    //   149: aload 6
    //   151: ifnull +12 -> 163
    //   154: aload 6
    //   156: invokeinterface 79 1 0
    //   161: iload_2
    //   162: istore_3
    //   163: iload_3
    //   164: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   167: areturn
    //   168: aload 6
    //   170: astore_1
    //   171: ldc 84
    //   173: ldc 86
    //   175: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: iload_3
    //   180: istore_2
    //   181: goto -34 -> 147
    //   184: astore 7
    //   186: aload 6
    //   188: astore_1
    //   189: ldc 84
    //   191: new 94	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   198: ldc 97
    //   200: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 7
    //   205: invokevirtual 105	java/lang/Exception:toString	()Ljava/lang/String;
    //   208: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: iload_2
    //   219: istore_3
    //   220: aload 6
    //   222: ifnull -59 -> 163
    //   225: aload 6
    //   227: invokeinterface 79 1 0
    //   232: iload_2
    //   233: istore_3
    //   234: goto -71 -> 163
    //   237: astore_1
    //   238: ldc 84
    //   240: ldc 108
    //   242: invokestatic 114	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: iload_2
    //   246: istore_3
    //   247: goto -84 -> 163
    //   250: astore_1
    //   251: ldc 84
    //   253: ldc 108
    //   255: invokestatic 114	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: iload_2
    //   259: istore_3
    //   260: goto -97 -> 163
    //   263: astore 6
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_1
    //   268: ifnull +9 -> 277
    //   271: aload_1
    //   272: invokeinterface 79 1 0
    //   277: aload 6
    //   279: athrow
    //   280: astore_1
    //   281: ldc 84
    //   283: ldc 108
    //   285: invokestatic 114	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -11 -> 277
    //   291: astore 6
    //   293: goto -26 -> 267
    //   296: astore 7
    //   298: aconst_null
    //   299: astore 6
    //   301: goto -115 -> 186
    //   304: iconst_0
    //   305: istore_2
    //   306: goto -159 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	b
    //   0	309	1	paramVarArgs	Void[]
    //   1	305	2	bool1	boolean
    //   3	257	3	bool2	boolean
    //   102	34	4	bool3	boolean
    //   129	12	5	bool4	boolean
    //   16	210	6	localObject1	java.lang.Object
    //   263	15	6	localObject2	java.lang.Object
    //   291	1	6	localObject3	java.lang.Object
    //   299	1	6	localObject4	java.lang.Object
    //   184	20	7	localException1	java.lang.Exception
    //   296	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   41	51	184	java/lang/Exception
    //   54	77	184	java/lang/Exception
    //   80	104	184	java/lang/Exception
    //   107	131	184	java/lang/Exception
    //   171	179	184	java/lang/Exception
    //   225	232	237	java/lang/Exception
    //   154	161	250	java/lang/Exception
    //   4	33	263	finally
    //   271	277	280	java/lang/Exception
    //   41	51	291	finally
    //   54	77	291	finally
    //   80	104	291	finally
    //   107	131	291	finally
    //   171	179	291	finally
    //   189	218	291	finally
    //   4	33	296	java/lang/Exception
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.c.b
 * JD-Core Version:    0.7.0.1
 */