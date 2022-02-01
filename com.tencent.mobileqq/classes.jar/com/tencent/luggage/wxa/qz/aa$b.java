package com.tencent.luggage.wxa.qz;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.lang.ref.WeakReference;

final class aa$b
  extends ContentObserver
{
  private long a;
  private String b;
  private Context c;
  
  public aa$b(Context paramContext, Handler paramHandler)
  {
    super(paramHandler);
    this.c = paramContext;
  }
  
  /* Error */
  private void a(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_1
    //   7: invokevirtual 28	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: aload_2
    //   11: invokestatic 34	com/tencent/luggage/wxa/qz/aa:f	()[Ljava/lang/String;
    //   14: aconst_null
    //   15: aconst_null
    //   16: ldc 36
    //   18: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +217 -> 240
    //   26: aload_2
    //   27: astore 8
    //   29: aload_2
    //   30: astore 7
    //   32: aload_2
    //   33: invokeinterface 48 1 0
    //   38: ifeq +202 -> 240
    //   41: aload_2
    //   42: astore 8
    //   44: aload_2
    //   45: astore 7
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 50
    //   51: invokeinterface 54 2 0
    //   56: invokeinterface 58 2 0
    //   61: astore 9
    //   63: aload_2
    //   64: astore 8
    //   66: aload_2
    //   67: astore 7
    //   69: aload_2
    //   70: aload_2
    //   71: ldc 60
    //   73: invokeinterface 54 2 0
    //   78: invokeinterface 64 2 0
    //   83: lstore_3
    //   84: aload_2
    //   85: astore 8
    //   87: aload_2
    //   88: astore 7
    //   90: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   93: ldc2_w 71
    //   96: ldiv
    //   97: lstore 5
    //   99: aload_2
    //   100: astore 8
    //   102: aload_2
    //   103: astore 7
    //   105: new 74	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   112: astore 10
    //   114: aload_2
    //   115: astore 8
    //   117: aload_2
    //   118: astore 7
    //   120: aload 10
    //   122: ldc 79
    //   124: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_2
    //   129: astore 8
    //   131: aload_2
    //   132: astore 7
    //   134: aload 10
    //   136: aload 9
    //   138: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: astore 8
    //   145: aload_2
    //   146: astore 7
    //   148: aload 10
    //   150: ldc 85
    //   152: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: astore 8
    //   159: aload_2
    //   160: astore 7
    //   162: aload 10
    //   164: lload_3
    //   165: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: astore 8
    //   172: aload_2
    //   173: astore 7
    //   175: aload 10
    //   177: ldc 90
    //   179: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: astore 8
    //   186: aload_2
    //   187: astore 7
    //   189: aload 10
    //   191: lload 5
    //   193: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_2
    //   198: astore 8
    //   200: aload_2
    //   201: astore 7
    //   203: ldc 92
    //   205: aload 10
    //   207: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 102	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_2
    //   214: astore 8
    //   216: aload_2
    //   217: astore 7
    //   219: invokestatic 105	com/tencent/luggage/wxa/qz/aa:c	()Landroid/os/Handler;
    //   222: new 107	com/tencent/luggage/wxa/qz/aa$b$2
    //   225: dup
    //   226: aload_0
    //   227: aload_1
    //   228: aload 9
    //   230: lload_3
    //   231: lload 5
    //   233: invokespecial 110	com/tencent/luggage/wxa/qz/aa$b$2:<init>	(Lcom/tencent/luggage/wxa/qz/aa$b;Landroid/content/Context;Ljava/lang/String;JJ)V
    //   236: invokevirtual 116	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   239: pop
    //   240: aload_2
    //   241: ifnull +75 -> 316
    //   244: aload_2
    //   245: invokeinterface 119 1 0
    //   250: return
    //   251: astore_1
    //   252: goto +65 -> 317
    //   255: astore_1
    //   256: aload 7
    //   258: astore 8
    //   260: new 74	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   267: astore_2
    //   268: aload 7
    //   270: astore 8
    //   272: aload_2
    //   273: ldc 121
    //   275: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 7
    //   281: astore 8
    //   283: aload_2
    //   284: aload_1
    //   285: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 7
    //   294: astore 8
    //   296: ldc 92
    //   298: aload_2
    //   299: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 126	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 7
    //   307: ifnull +9 -> 316
    //   310: aload 7
    //   312: astore_2
    //   313: goto -69 -> 244
    //   316: return
    //   317: aload 8
    //   319: ifnull +10 -> 329
    //   322: aload 8
    //   324: invokeinterface 119 1 0
    //   329: goto +5 -> 334
    //   332: aload_1
    //   333: athrow
    //   334: goto -2 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	b
    //   0	337	1	paramContext	Context
    //   0	337	2	paramUri	Uri
    //   83	148	3	l1	long
    //   97	135	5	l2	long
    //   1	310	7	localUri1	Uri
    //   4	319	8	localUri2	Uri
    //   61	168	9	str	String
    //   112	94	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	22	251	finally
    //   32	41	251	finally
    //   47	63	251	finally
    //   69	84	251	finally
    //   90	99	251	finally
    //   105	114	251	finally
    //   120	128	251	finally
    //   134	142	251	finally
    //   148	156	251	finally
    //   162	169	251	finally
    //   175	183	251	finally
    //   189	197	251	finally
    //   203	213	251	finally
    //   219	240	251	finally
    //   260	268	251	finally
    //   272	279	251	finally
    //   283	292	251	finally
    //   296	305	251	finally
    //   6	22	255	java/lang/Exception
    //   32	41	255	java/lang/Exception
    //   47	63	255	java/lang/Exception
    //   69	84	255	java/lang/Exception
    //   90	99	255	java/lang/Exception
    //   105	114	255	java/lang/Exception
    //   120	128	255	java/lang/Exception
    //   134	142	255	java/lang/Exception
    //   148	156	255	java/lang/Exception
    //   162	169	255	java/lang/Exception
    //   175	183	255	java/lang/Exception
    //   189	197	255	java/lang/Exception
    //   203	213	255	java/lang/Exception
    //   219	240	255	java/lang/Exception
  }
  
  private void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        if ((Math.abs(paramLong2 - paramLong1) > 10L) || (paramLong2 - this.a <= 1L) || (af.c(paramString)) || ((!paramString.toLowerCase().contains("screenshot")) && (!paramString.contains("截屏")) && (!paramString.contains("截图"))) || (paramString.equals(this.b))) {
          break label257;
        }
        this.a = paramLong2;
        this.b = paramString;
        if (!af.c(paramString))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("summerscreenshot added path: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", time: ");
          localStringBuilder.append(paramLong1);
          o.d("MicroMsg.ScreenShotUtil", localStringBuilder.toString());
          if ((aa.b() != null) && (aa.b().get() != null))
          {
            ((aa.a)aa.b().get()).a(paramString, paramLong1);
            return;
          }
          if (aa.a() != null)
          {
            paramContext.getContentResolver().unregisterContentObserver(aa.a());
            aa.a(null);
          }
          if (aa.b() != null)
          {
            aa.b().clear();
            aa.a(null);
          }
          o.d("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("summerscreenshot fail e:");
        paramString.append(paramContext.getMessage());
        o.c("MicroMsg.ScreenShotUtil", paramString.toString());
      }
      return;
      label257:
      paramLong1 = 0L;
      paramString = null;
    }
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    aa.e().a(new aa.b.1(this, paramBoolean, paramUri));
    super.onChange(paramBoolean, paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.aa.b
 * JD-Core Version:    0.7.0.1
 */