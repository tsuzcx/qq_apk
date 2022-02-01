package com.tencent.mobileqq.app.utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class SmsContent
  extends ContentObserver
{
  private static final String[] c = { "_id", "address", "body", "date" };
  private static long d;
  Context a;
  SMSBodyObserver b;
  
  public SmsContent(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public SmsContent(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
    d = paramLong;
  }
  
  private void b(Context paramContext, SMSBodyObserver paramSMSBodyObserver)
  {
    this.a = paramContext;
    this.b = paramSMSBodyObserver;
    try
    {
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    Context localContext = this.a;
    if (localContext != null)
    {
      localContext.getContentResolver().unregisterContentObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "unregister...");
      }
      this.a = null;
    }
    this.b = null;
  }
  
  public void a(Context paramContext, SMSBodyObserver paramSMSBodyObserver)
  {
    if (paramContext == null) {
      return;
    }
    if (((paramContext instanceof AppActivity)) && (a((AppActivity)paramContext, paramSMSBodyObserver)))
    {
      b(paramContext, paramSMSBodyObserver);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "register...");
      }
    }
  }
  
  @TargetApi(23)
  public boolean a(AppActivity paramAppActivity, SMSBodyObserver paramSMSBodyObserver)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramAppActivity.checkSelfPermission("android.permission.READ_SMS") != 0))
    {
      paramAppActivity.requestPermissions(new SmsContent.1(this, paramAppActivity, paramSMSBodyObserver), 1, new String[] { "android.permission.READ_SMS" });
      return false;
    }
    return true;
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 120	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 42	com/tencent/mobileqq/app/utils/SmsContent:a	Landroid/content/Context;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +18 -> 31
    //   16: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +11 -> 30
    //   22: ldc 79
    //   24: iconst_2
    //   25: ldc 122
    //   27: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: return
    //   31: aconst_null
    //   32: astore 4
    //   34: aconst_null
    //   35: astore 5
    //   37: aload 6
    //   39: invokevirtual 50	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: ldc 124
    //   44: invokestatic 58	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   47: getstatic 26	com/tencent/mobileqq/app/utils/SmsContent:c	[Ljava/lang/String;
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc 126
    //   54: invokevirtual 130	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnull +360 -> 421
    //   64: aload 6
    //   66: astore 5
    //   68: aload 6
    //   70: astore 4
    //   72: aload 6
    //   74: invokeinterface 135 1 0
    //   79: ifne +342 -> 421
    //   82: aload 6
    //   84: astore 5
    //   86: aload 6
    //   88: astore 4
    //   90: aload 6
    //   92: invokeinterface 138 1 0
    //   97: ifeq +324 -> 421
    //   100: aload 6
    //   102: astore 5
    //   104: aload 6
    //   106: astore 4
    //   108: aload 6
    //   110: aload 6
    //   112: ldc 20
    //   114: invokeinterface 141 2 0
    //   119: invokeinterface 145 2 0
    //   124: astore 7
    //   126: aload 6
    //   128: astore 5
    //   130: aload 6
    //   132: astore 4
    //   134: aload 6
    //   136: aload 6
    //   138: ldc 22
    //   140: invokeinterface 141 2 0
    //   145: invokeinterface 145 2 0
    //   150: astore 8
    //   152: aload 6
    //   154: astore 5
    //   156: aload 6
    //   158: astore 4
    //   160: aload 6
    //   162: aload 6
    //   164: ldc 24
    //   166: invokeinterface 141 2 0
    //   171: invokeinterface 149 2 0
    //   176: lstore_2
    //   177: aload 6
    //   179: astore 5
    //   181: aload 6
    //   183: astore 4
    //   185: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +167 -> 355
    //   191: aload 6
    //   193: astore 5
    //   195: aload 6
    //   197: astore 4
    //   199: new 151	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   206: astore 9
    //   208: aload 6
    //   210: astore 5
    //   212: aload 6
    //   214: astore 4
    //   216: aload 9
    //   218: ldc 155
    //   220: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: astore 5
    //   228: aload 6
    //   230: astore 4
    //   232: aload 9
    //   234: aload 7
    //   236: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: astore 5
    //   244: aload 6
    //   246: astore 4
    //   248: aload 9
    //   250: ldc 161
    //   252: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 6
    //   258: astore 5
    //   260: aload 6
    //   262: astore 4
    //   264: aload 9
    //   266: aload 8
    //   268: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: astore 5
    //   276: aload 6
    //   278: astore 4
    //   280: aload 9
    //   282: ldc 163
    //   284: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 6
    //   290: astore 5
    //   292: aload 6
    //   294: astore 4
    //   296: aload 9
    //   298: lload_2
    //   299: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 6
    //   305: astore 5
    //   307: aload 6
    //   309: astore 4
    //   311: aload 9
    //   313: ldc 168
    //   315: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: astore 5
    //   323: aload 6
    //   325: astore 4
    //   327: aload 9
    //   329: getstatic 34	com/tencent/mobileqq/app/utils/SmsContent:d	J
    //   332: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 6
    //   338: astore 5
    //   340: aload 6
    //   342: astore 4
    //   344: ldc 79
    //   346: iconst_2
    //   347: aload 9
    //   349: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload 6
    //   357: astore 5
    //   359: aload 6
    //   361: astore 4
    //   363: lload_2
    //   364: getstatic 34	com/tencent/mobileqq/app/utils/SmsContent:d	J
    //   367: lcmp
    //   368: iflt +53 -> 421
    //   371: aload 6
    //   373: astore 5
    //   375: aload 6
    //   377: astore 4
    //   379: aload_0
    //   380: getfield 44	com/tencent/mobileqq/app/utils/SmsContent:b	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   383: ifnull +38 -> 421
    //   386: aload 6
    //   388: astore 5
    //   390: aload 6
    //   392: astore 4
    //   394: aload_0
    //   395: getfield 44	com/tencent/mobileqq/app/utils/SmsContent:b	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   398: aload 7
    //   400: aload 8
    //   402: invokeinterface 178 3 0
    //   407: aload 6
    //   409: astore 5
    //   411: aload 6
    //   413: astore 4
    //   415: lload_2
    //   416: lconst_1
    //   417: ladd
    //   418: putstatic 34	com/tencent/mobileqq/app/utils/SmsContent:d	J
    //   421: aload 6
    //   423: ifnull +53 -> 476
    //   426: aload 6
    //   428: astore 4
    //   430: goto +39 -> 469
    //   433: astore 4
    //   435: goto +42 -> 477
    //   438: astore 6
    //   440: aload 4
    //   442: astore 5
    //   444: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +17 -> 464
    //   450: aload 4
    //   452: astore 5
    //   454: ldc 79
    //   456: iconst_2
    //   457: ldc 179
    //   459: aload 6
    //   461: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aload 4
    //   466: ifnull +10 -> 476
    //   469: aload 4
    //   471: invokeinterface 185 1 0
    //   476: return
    //   477: aload 5
    //   479: ifnull +10 -> 489
    //   482: aload 5
    //   484: invokeinterface 185 1 0
    //   489: aload 4
    //   491: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	this	SmsContent
    //   0	492	1	paramBoolean	boolean
    //   176	240	2	l	long
    //   32	397	4	localObject1	java.lang.Object
    //   433	57	4	localObject2	java.lang.Object
    //   35	448	5	localObject3	java.lang.Object
    //   9	418	6	localObject4	java.lang.Object
    //   438	22	6	localException	Exception
    //   124	275	7	str1	String
    //   150	251	8	str2	String
    //   206	142	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	59	433	finally
    //   72	82	433	finally
    //   90	100	433	finally
    //   108	126	433	finally
    //   134	152	433	finally
    //   160	177	433	finally
    //   185	191	433	finally
    //   199	208	433	finally
    //   216	224	433	finally
    //   232	240	433	finally
    //   248	256	433	finally
    //   264	272	433	finally
    //   280	288	433	finally
    //   296	303	433	finally
    //   311	319	433	finally
    //   327	336	433	finally
    //   344	355	433	finally
    //   363	371	433	finally
    //   379	386	433	finally
    //   394	407	433	finally
    //   415	421	433	finally
    //   444	450	433	finally
    //   454	464	433	finally
    //   37	59	438	java/lang/Exception
    //   72	82	438	java/lang/Exception
    //   90	100	438	java/lang/Exception
    //   108	126	438	java/lang/Exception
    //   134	152	438	java/lang/Exception
    //   160	177	438	java/lang/Exception
    //   185	191	438	java/lang/Exception
    //   199	208	438	java/lang/Exception
    //   216	224	438	java/lang/Exception
    //   232	240	438	java/lang/Exception
    //   248	256	438	java/lang/Exception
    //   264	272	438	java/lang/Exception
    //   280	288	438	java/lang/Exception
    //   296	303	438	java/lang/Exception
    //   311	319	438	java/lang/Exception
    //   327	336	438	java/lang/Exception
    //   344	355	438	java/lang/Exception
    //   363	371	438	java/lang/Exception
    //   379	386	438	java/lang/Exception
    //   394	407	438	java/lang/Exception
    //   415	421	438	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.SmsContent
 * JD-Core Version:    0.7.0.1
 */