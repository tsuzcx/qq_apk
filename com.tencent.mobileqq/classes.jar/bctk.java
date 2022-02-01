import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import mqq.os.MqqMessage;
import mqq.os.MqqMessageQueue;

class bctk
  implements CrashHandleListener
{
  bctk(bctj parambctj) {}
  
  private String a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (paramMessage.getTarget() != null) {
      if (paramMessage.getCallback() != null)
      {
        localStringBuilder.append(" callback=");
        localStringBuilder.append(paramMessage.getCallback().getClass().getName());
        if (paramMessage.arg1 != 0)
        {
          localStringBuilder.append(" arg1=");
          localStringBuilder.append(paramMessage.arg1);
        }
        if (paramMessage.arg2 != 0)
        {
          localStringBuilder.append(" arg2=");
          localStringBuilder.append(paramMessage.arg2);
        }
        if (paramMessage.obj != null)
        {
          localStringBuilder.append(" obj=");
          localStringBuilder.append(paramMessage.obj);
        }
        localStringBuilder.append(" target=");
        localStringBuilder.append(paramMessage.getTarget().getClass().getName());
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(" what=");
      localStringBuilder.append(paramMessage.what);
      break;
      localStringBuilder.append(" barrier=");
      localStringBuilder.append(paramMessage.arg1);
    }
  }
  
  private HashMap<String, Integer> a(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new bctl(this));
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new HashMap();
      localObject1 = MqqMessageQueue.getSubMainThreadQueue();
      Object localObject4 = Class.forName("mqq.os.MqqMessageQueue").getDeclaredField("mMessages");
      ((Field)localObject4).setAccessible(true);
      Object localObject3 = Class.forName("mqq.os.MqqMessage");
      Field localField = ((Class)localObject3).getDeclaredField("wrappedMsg");
      localField.setAccessible(true);
      localObject3 = ((Class)localObject3).getDeclaredField("next");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (MqqMessage)((Field)localObject4).get(localObject1);
      i = 0;
      if ((localObject1 != null) && (i <= 100000))
      {
        localObject4 = a((Message)localField.get(localObject1));
        if (((HashMap)localObject2).containsKey(localObject4)) {
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject4)).intValue() + 1));
        }
        for (;;)
        {
          localObject1 = (MqqMessage)((Field)localObject3).get(localObject1);
          i += 1;
          break;
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(1));
        }
        return;
      }
    }
    catch (Throwable paramStringBuilder)
    {
      QLog.e("StatisticCollector", 1, "Fetch MqqMessageQueue's Messages faild", paramStringBuilder);
    }
    label353:
    for (;;)
    {
      localObject1 = a((HashMap)localObject2);
      paramStringBuilder.append("MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:");
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label353;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new HashMap();
        localObject1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
        ((Field)localObject1).setAccessible(true);
        Object localObject3 = Class.forName("android.os.Looper").getMethod("getQueue", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        localObject1 = (Message)((Field)localObject1).get((MessageQueue)((Method)localObject3).invoke(Looper.getMainLooper(), new Object[0]));
        if (localObject1 == null) {
          break label454;
        }
        localObject3 = a((Message)localObject1);
        String str;
        if (((HashMap)localObject2).containsKey(localObject3))
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject3)).intValue() + 1));
          i = 1;
          localObject3 = Class.forName("android.os.Message").getDeclaredField("next");
          ((Field)localObject3).setAccessible(true);
          localObject1 = (Message)((Field)localObject3).get(localObject1);
          if ((localObject1 == null) || (i > 100000)) {
            break label276;
          }
          str = a((Message)localObject1);
          if (((HashMap)localObject2).containsKey(str))
          {
            ((HashMap)localObject2).put(str, Integer.valueOf(((Integer)((HashMap)localObject2).get(str)).intValue() + 1));
            localObject1 = (Message)((Field)localObject3).get(localObject1);
            i += 1;
            continue;
          }
        }
        else
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
          i = 1;
          continue;
        }
        ((HashMap)localObject2).put(str, Integer.valueOf(1));
        continue;
        localObject1 = a((HashMap)localObject2);
      }
      catch (Throwable paramStringBuilder)
      {
        QLog.e("StatisticCollector", 1, "Fetch Main Thread's Messages faild", paramStringBuilder);
        return;
      }
      label276:
      paramStringBuilder.append("Main Thread has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "Main Thread has " + i + " Messages, and it's Top 50 Messages:");
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label452;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
      label452:
      continue;
      label454:
      i = 0;
    }
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 198
    //   2: iconst_1
    //   3: new 19	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 268
    //   10: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 276
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 278
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 280
    //   40: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 282
    //   51: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload 5
    //   56: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc_w 284
    //   62: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   68: new 291	java/util/Date
    //   71: dup
    //   72: lload 6
    //   74: invokespecial 294	java/util/Date:<init>	(J)V
    //   77: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   80: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_2
    //   90: invokestatic 303	bctj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 305	bctj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: iconst_1
    //   101: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   104: if_icmpne +41 -> 145
    //   107: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 319	bctj:jdField_b_of_type_Long	J
    //   113: lsub
    //   114: ldc2_w 320
    //   117: lcmp
    //   118: ifgt +27 -> 145
    //   121: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   124: new 19	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 329	abev:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   149: if_icmpne +47 -> 196
    //   152: aload 4
    //   154: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +39 -> 196
    //   160: iload_1
    //   161: ifeq +14 -> 175
    //   164: aload 4
    //   166: ldc_w 337
    //   169: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: ifne +18 -> 190
    //   175: iload_1
    //   176: ifne +20 -> 196
    //   179: aload 4
    //   181: ldc_w 342
    //   184: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +9 -> 196
    //   190: invokestatic 347	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:a	()Lcom/tencent/mobileqq/statistics/thread/SuspendThreadManager;
    //   193: invokevirtual 349	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:b	()V
    //   196: getstatic 352	bctj:jdField_a_of_type_Bctr	Lbctr;
    //   199: ifnull +43 -> 242
    //   202: iload_1
    //   203: ifne +39 -> 242
    //   206: ldc_w 354
    //   209: aload_2
    //   210: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +29 -> 242
    //   216: aload_3
    //   217: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +22 -> 242
    //   223: aload_3
    //   224: ldc_w 359
    //   227: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +12 -> 242
    //   233: getstatic 352	bctj:jdField_a_of_type_Bctr	Lbctr;
    //   236: aload_2
    //   237: invokeinterface 363 2 0
    //   242: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   245: ldc_w 369
    //   248: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   251: ifeq +31 -> 282
    //   254: new 19	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 375
    //   264: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 4
    //   273: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 378	akwt:a	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +17 -> 301
    //   287: aload 4
    //   289: ldc_w 380
    //   292: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +6 -> 301
    //   298: invokestatic 383	bcuq:b	()V
    //   301: aload 4
    //   303: ifnull +120 -> 423
    //   306: aload 4
    //   308: ldc_w 385
    //   311: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: ifne +25 -> 339
    //   317: aload 4
    //   319: ldc_w 387
    //   322: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   325: ifne +14 -> 339
    //   328: aload 4
    //   330: ldc_w 389
    //   333: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   336: ifeq +87 -> 423
    //   339: iconst_0
    //   340: iconst_0
    //   341: invokestatic 394	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   344: new 88	java/util/HashMap
    //   347: dup
    //   348: invokespecial 143	java/util/HashMap:<init>	()V
    //   351: astore 11
    //   353: iload_1
    //   354: ifeq +2281 -> 2635
    //   357: ldc_w 396
    //   360: astore 10
    //   362: aload 11
    //   364: ldc_w 398
    //   367: aload 10
    //   369: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload 11
    //   375: ldc_w 400
    //   378: aload_2
    //   379: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload 11
    //   385: ldc_w 402
    //   388: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   391: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   398: invokestatic 405	bctj:a	(Landroid/content/Context;)Lbctj;
    //   401: aload_0
    //   402: getfield 12	bctk:a	Lbctj;
    //   405: getfield 407	bctj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   408: ldc_w 409
    //   411: iconst_1
    //   412: lconst_0
    //   413: lconst_0
    //   414: aload 11
    //   416: ldc_w 411
    //   419: iconst_0
    //   420: invokevirtual 414	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   423: iload_1
    //   424: aload_2
    //   425: aload 4
    //   427: invokestatic 419	ancc:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   430: aload 4
    //   432: ifnull +104 -> 536
    //   435: aload 4
    //   437: ldc_w 421
    //   440: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   443: ifne +14 -> 457
    //   446: aload 4
    //   448: ldc_w 423
    //   451: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   454: ifeq +82 -> 536
    //   457: new 88	java/util/HashMap
    //   460: dup
    //   461: invokespecial 143	java/util/HashMap:<init>	()V
    //   464: astore 11
    //   466: iload_1
    //   467: ifeq +2176 -> 2643
    //   470: ldc_w 396
    //   473: astore 10
    //   475: aload 11
    //   477: ldc_w 398
    //   480: aload 10
    //   482: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 11
    //   488: ldc_w 400
    //   491: aload_2
    //   492: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: aload 11
    //   498: ldc_w 402
    //   501: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   504: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   511: invokestatic 405	bctj:a	(Landroid/content/Context;)Lbctj;
    //   514: aload_0
    //   515: getfield 12	bctk:a	Lbctj;
    //   518: getfield 407	bctj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 425
    //   524: iconst_1
    //   525: lconst_0
    //   526: lconst_0
    //   527: aload 11
    //   529: ldc_w 411
    //   532: iconst_0
    //   533: invokevirtual 414	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   536: iload_1
    //   537: aload_2
    //   538: aload_3
    //   539: aload 4
    //   541: iload 5
    //   543: lload 6
    //   545: invokestatic 430	bcof:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   548: getstatic 436	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   551: ldc_w 438
    //   554: invokevirtual 442	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   557: ifeq +56 -> 613
    //   560: new 444	android/content/Intent
    //   563: dup
    //   564: invokespecial 445	android/content/Intent:<init>	()V
    //   567: astore 10
    //   569: aload 10
    //   571: ldc_w 447
    //   574: invokevirtual 451	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   577: pop
    //   578: aload 10
    //   580: invokestatic 457	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   583: invokevirtual 460	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   586: invokevirtual 463	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   589: pop
    //   590: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   593: aload 10
    //   595: invokevirtual 469	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   598: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +12 -> 613
    //   604: ldc 198
    //   606: iconst_2
    //   607: ldc_w 474
    //   610: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   616: ldc_w 476
    //   619: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   622: ifeq +31 -> 653
    //   625: new 19	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 375
    //   635: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_2
    //   639: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 4
    //   644: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 481	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   653: aload 4
    //   655: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifne +139 -> 797
    //   661: aload 4
    //   663: ldc_w 483
    //   666: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   669: ifeq +128 -> 797
    //   672: new 485	org/json/JSONObject
    //   675: dup
    //   676: invokespecial 486	org/json/JSONObject:<init>	()V
    //   679: astore 10
    //   681: aload 10
    //   683: ldc_w 488
    //   686: iload_1
    //   687: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 10
    //   693: ldc_w 493
    //   696: aload_2
    //   697: invokevirtual 496	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload 10
    //   703: ldc_w 498
    //   706: aload_3
    //   707: invokevirtual 496	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload 10
    //   713: ldc_w 500
    //   716: aload 4
    //   718: invokevirtual 496	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   721: pop
    //   722: aload 10
    //   724: ldc_w 502
    //   727: iload 5
    //   729: invokevirtual 505	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   732: pop
    //   733: aload 10
    //   735: ldc_w 507
    //   738: lload 6
    //   740: invokevirtual 510	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   743: pop
    //   744: getstatic 514	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   747: invokevirtual 518	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   750: astore 11
    //   752: aload 11
    //   754: ifnull +43 -> 797
    //   757: aload 11
    //   759: ldc_w 520
    //   762: invokevirtual 525	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   765: ldc_w 526
    //   768: iconst_1
    //   769: anewarray 44	java/lang/Class
    //   772: dup
    //   773: iconst_0
    //   774: ldc 224
    //   776: aastore
    //   777: invokevirtual 239	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   780: aconst_null
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload 10
    //   789: invokevirtual 527	org/json/JSONObject:toString	()Ljava/lang/String;
    //   792: aastore
    //   793: invokevirtual 252	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   796: pop
    //   797: aconst_null
    //   798: astore 11
    //   800: new 529	java/io/File
    //   803: dup
    //   804: ldc_w 531
    //   807: invokespecial 532	java/io/File:<init>	(Ljava/lang/String;)V
    //   810: astore 10
    //   812: aload 10
    //   814: ifnull +17 -> 831
    //   817: aload 10
    //   819: invokevirtual 535	java/io/File:exists	()Z
    //   822: ifne +9 -> 831
    //   825: aload 10
    //   827: invokevirtual 538	java/io/File:mkdirs	()Z
    //   830: pop
    //   831: new 540	java/io/FileWriter
    //   834: dup
    //   835: new 19	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 531
    //   845: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: lload 6
    //   850: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   853: ldc_w 545
    //   856: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokespecial 546	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   865: astore 10
    //   867: new 19	java/lang/StringBuilder
    //   870: dup
    //   871: sipush 128
    //   874: invokespecial 22	java/lang/StringBuilder:<init>	(I)V
    //   877: astore 11
    //   879: aload 11
    //   881: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   884: new 291	java/util/Date
    //   887: dup
    //   888: lload 6
    //   890: invokespecial 294	java/util/Date:<init>	(J)V
    //   893: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   896: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: ldc 228
    //   901: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_2
    //   905: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc 228
    //   910: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload 4
    //   915: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload 10
    //   921: aload 11
    //   923: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 549	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   929: aload 10
    //   931: invokevirtual 552	java/io/FileWriter:flush	()V
    //   934: aload 10
    //   936: ifnull +8 -> 944
    //   939: aload 10
    //   941: invokevirtual 555	java/io/FileWriter:close	()V
    //   944: aload_2
    //   945: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   948: ifne +47 -> 995
    //   951: aload_2
    //   952: ldc_w 557
    //   955: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   958: ifeq +37 -> 995
    //   961: invokestatic 562	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   964: invokevirtual 564	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   967: aload 4
    //   969: ldc_w 566
    //   972: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   975: ifne +20 -> 995
    //   978: aload 4
    //   980: ldc_w 568
    //   983: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   986: ifne +9 -> 995
    //   989: invokestatic 573	abfc:a	()Labfc;
    //   992: invokevirtual 574	abfc:b	()V
    //   995: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   998: astore 13
    //   1000: iload_1
    //   1001: ifeq +39 -> 1040
    //   1004: aload 13
    //   1006: ldc_w 576
    //   1009: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1012: ifne +14 -> 1026
    //   1015: aload 13
    //   1017: ldc_w 578
    //   1020: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1023: ifeq +17 -> 1040
    //   1026: ldc_w 580
    //   1029: iconst_1
    //   1030: aload 4
    //   1032: invokestatic 582	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload 4
    //   1037: invokestatic 587	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1040: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   1043: invokestatic 592	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1046: new 19	java/lang/StringBuilder
    //   1049: dup
    //   1050: sipush 128
    //   1053: invokespecial 22	java/lang/StringBuilder:<init>	(I)V
    //   1056: astore 12
    //   1058: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   1061: ldc_w 594
    //   1064: invokestatic 599	acve:a	(Landroid/content/Context;Ljava/lang/String;)Lacvd;
    //   1067: astore 10
    //   1069: aload 12
    //   1071: ldc_w 601
    //   1074: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload 12
    //   1080: ldc_w 603
    //   1083: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 12
    //   1089: ldc_w 605
    //   1092: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: getstatic 608	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1098: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 12
    //   1104: ldc_w 610
    //   1107: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: getstatic 613	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1113: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 12
    //   1119: ldc_w 615
    //   1122: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1128: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 12
    //   1134: ldc_w 620
    //   1137: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: getstatic 623	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1143: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 12
    //   1149: ldc_w 625
    //   1152: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: getstatic 629	bcow:b	I
    //   1158: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 12
    //   1164: ldc_w 631
    //   1167: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: astore 11
    //   1172: aload 10
    //   1174: ifnull +1533 -> 2707
    //   1177: aload 10
    //   1179: invokevirtual 635	acvd:a	()Z
    //   1182: ifeq +1525 -> 2707
    //   1185: iconst_1
    //   1186: istore 9
    //   1188: aload 11
    //   1190: iload 9
    //   1192: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: ldc_w 637
    //   1198: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: getstatic 641	acut:jdField_a_of_type_Int	I
    //   1204: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 643
    //   1210: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: getstatic 646	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1216: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 648
    //   1222: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: getstatic 649	acut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1228: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 12
    //   1234: ldc_w 651
    //   1237: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1243: invokevirtual 660	java/lang/Runtime:maxMemory	()J
    //   1246: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1249: ldc_w 662
    //   1252: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1258: invokevirtual 665	java/lang/Runtime:totalMemory	()J
    //   1261: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1264: invokevirtual 668	java/lang/Runtime:freeMemory	()J
    //   1267: lsub
    //   1268: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 12
    //   1274: ldc_w 670
    //   1277: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokestatic 562	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1283: invokevirtual 672	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   1286: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1289: ldc_w 674
    //   1292: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: invokestatic 562	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1298: invokevirtual 676	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   1301: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1304: ldc_w 678
    //   1307: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokestatic 562	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1313: invokevirtual 681	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   1316: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 12
    //   1322: ldc_w 683
    //   1325: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokestatic 688	bcte:a	()Lbcte;
    //   1331: invokevirtual 690	bcte:a	()Ljava/lang/String;
    //   1334: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: getstatic 694	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1341: ifnull +21 -> 1362
    //   1344: aload 12
    //   1346: ldc_w 696
    //   1349: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: getstatic 694	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1355: invokevirtual 701	android/support/v4/util/MQLruCache:size	()I
    //   1358: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1365: invokevirtual 660	java/lang/Runtime:maxMemory	()J
    //   1368: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1371: invokevirtual 665	java/lang/Runtime:totalMemory	()J
    //   1374: lsub
    //   1375: l2f
    //   1376: fconst_1
    //   1377: fmul
    //   1378: invokestatic 657	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1381: invokevirtual 660	java/lang/Runtime:maxMemory	()J
    //   1384: l2f
    //   1385: fdiv
    //   1386: f2d
    //   1387: ldc2_w 702
    //   1390: dcmpl
    //   1391: iflt +29 -> 1420
    //   1394: aload_2
    //   1395: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1398: ifne +22 -> 1420
    //   1401: aload_2
    //   1402: ldc_w 557
    //   1405: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1408: ifeq +12 -> 1420
    //   1411: aload_0
    //   1412: getfield 12	bctk:a	Lbctj;
    //   1415: aload 12
    //   1417: invokevirtual 705	bctj:a	(Ljava/lang/StringBuilder;)V
    //   1420: aload 12
    //   1422: ldc_w 707
    //   1425: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: getstatic 712	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1431: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: getstatic 717	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1438: astore 10
    //   1440: aload 10
    //   1442: ifnull +56 -> 1498
    //   1445: aload 10
    //   1447: arraylength
    //   1448: iconst_3
    //   1449: if_icmplt +49 -> 1498
    //   1452: aload 12
    //   1454: ldc_w 719
    //   1457: iconst_3
    //   1458: anewarray 4	java/lang/Object
    //   1461: dup
    //   1462: iconst_0
    //   1463: aload 10
    //   1465: iconst_0
    //   1466: iaload
    //   1467: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1470: aastore
    //   1471: dup
    //   1472: iconst_1
    //   1473: aload 10
    //   1475: iconst_1
    //   1476: iaload
    //   1477: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: aastore
    //   1481: dup
    //   1482: iconst_2
    //   1483: aload 10
    //   1485: iconst_2
    //   1486: iaload
    //   1487: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1490: aastore
    //   1491: invokestatic 722	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1494: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 12
    //   1500: ldc 228
    //   1502: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: invokestatic 727	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   1509: invokevirtual 730	com/tencent/mfsdk/MagnifierSDK:a	()Ladby;
    //   1512: invokeinterface 734 1 0
    //   1517: astore 11
    //   1519: invokestatic 739	bgln:a	()[J
    //   1522: astore 14
    //   1524: aload 12
    //   1526: invokestatic 742	bgln:l	()Ljava/lang/String;
    //   1529: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc 228
    //   1534: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: pop
    //   1538: aload 11
    //   1540: astore 10
    //   1542: aload 11
    //   1544: ifnonnull +8 -> 1552
    //   1547: ldc_w 744
    //   1550: astore 10
    //   1552: aload 12
    //   1554: aload 10
    //   1556: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc 228
    //   1561: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: pop
    //   1565: aload 12
    //   1567: ldc_w 746
    //   1570: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: aload 14
    //   1575: iconst_0
    //   1576: laload
    //   1577: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1580: ldc_w 748
    //   1583: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: aload 14
    //   1588: iconst_1
    //   1589: laload
    //   1590: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1593: ldc_w 750
    //   1596: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: pop
    //   1600: aload_0
    //   1601: getfield 12	bctk:a	Lbctj;
    //   1604: invokestatic 753	bctj:a	(Lbctj;)Ljava/lang/String;
    //   1607: ifnonnull +1106 -> 2713
    //   1610: ldc_w 744
    //   1613: astore 10
    //   1615: aload 12
    //   1617: aload 10
    //   1619: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: ldc 228
    //   1624: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: pop
    //   1628: aload 12
    //   1630: new 19	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1637: ldc_w 755
    //   1640: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: getstatic 760	mqq/app/Foreground:sCountResume	I
    //   1646: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1649: ldc 228
    //   1651: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: pop
    //   1661: aload 12
    //   1663: ldc_w 762
    //   1666: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: getstatic 765	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1672: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1675: ldc 228
    //   1677: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: getstatic 769	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1684: astore 10
    //   1686: aload 10
    //   1688: instanceof 764
    //   1691: ifeq +32 -> 1723
    //   1694: aload 10
    //   1696: checkcast 764	com/tencent/mobileqq/activity/SplashActivity
    //   1699: astore 10
    //   1701: aload 12
    //   1703: ldc_w 771
    //   1706: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: aload 10
    //   1711: invokevirtual 772	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1714: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1717: ldc 228
    //   1719: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: pop
    //   1723: getstatic 775	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1726: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1729: ifne +23 -> 1752
    //   1732: aload 12
    //   1734: ldc_w 777
    //   1737: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: getstatic 775	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1743: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc 228
    //   1748: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: getstatic 780	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1755: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1758: ifne +23 -> 1781
    //   1761: aload 12
    //   1763: ldc_w 782
    //   1766: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: getstatic 780	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1772: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: ldc 228
    //   1777: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: pop
    //   1781: getstatic 785	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1784: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1787: ifne +23 -> 1810
    //   1790: aload 12
    //   1792: ldc_w 787
    //   1795: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: getstatic 785	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1801: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: ldc 228
    //   1806: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: pop
    //   1810: aload 12
    //   1812: new 19	java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1819: ldc_w 789
    //   1822: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: invokestatic 795	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1828: ldc_w 797
    //   1831: ldc_w 799
    //   1834: iconst_1
    //   1835: invokevirtual 803	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1838: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1841: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1844: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: new 19	java/lang/StringBuilder
    //   1850: dup
    //   1851: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1854: ldc_w 805
    //   1857: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: invokestatic 795	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1863: ldc_w 797
    //   1866: ldc_w 807
    //   1869: iconst_0
    //   1870: invokevirtual 810	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1873: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1876: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1879: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: new 19	java/lang/StringBuilder
    //   1885: dup
    //   1886: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1889: ldc_w 812
    //   1892: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: invokestatic 795	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1898: ldc_w 797
    //   1901: ldc_w 814
    //   1904: iconst_0
    //   1905: invokevirtual 810	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1908: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1911: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1914: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc 228
    //   1919: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: pop
    //   1923: invokestatic 815	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1926: invokestatic 820	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   1929: invokevirtual 823	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   1932: astore 10
    //   1934: aload 10
    //   1936: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1939: ifne +11 -> 1950
    //   1942: aload 12
    //   1944: aload 10
    //   1946: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: pop
    //   1950: aload 12
    //   1952: aload_0
    //   1953: getfield 12	bctk:a	Lbctj;
    //   1956: invokestatic 826	bctj:b	(Lbctj;)Ljava/lang/StringBuilder;
    //   1959: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1962: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: pop
    //   1966: aload 12
    //   1968: aload_0
    //   1969: getfield 12	bctk:a	Lbctj;
    //   1972: invokestatic 828	bctj:a	(Lbctj;)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: pop
    //   1982: getstatic 831	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1985: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifne +51 -> 2039
    //   1991: getstatic 836	android/os/Build$VERSION:SDK_INT	I
    //   1994: bipush 8
    //   1996: if_icmplt +43 -> 2039
    //   1999: aload 12
    //   2001: new 19	java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2008: ldc_w 838
    //   2011: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: getstatic 831	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2017: invokevirtual 842	java/lang/String:getBytes	()[B
    //   2020: iconst_0
    //   2021: invokestatic 848	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2024: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: ldc 228
    //   2029: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2035: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: pop
    //   2039: aload 12
    //   2041: invokestatic 853	bluy:a	()Lbluy;
    //   2044: invokevirtual 854	bluy:a	()Ljava/lang/String;
    //   2047: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: pop
    //   2051: aload 12
    //   2053: ldc 228
    //   2055: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2058: pop
    //   2059: aload_0
    //   2060: getfield 12	bctk:a	Lbctj;
    //   2063: invokestatic 857	bctj:a	(Lbctj;)Ljava/util/LinkedList;
    //   2066: invokevirtual 858	java/util/LinkedList:size	()I
    //   2069: ifle +30 -> 2099
    //   2072: aload 12
    //   2074: aload_0
    //   2075: getfield 12	bctk:a	Lbctj;
    //   2078: invokestatic 857	bctj:a	(Lbctj;)Ljava/util/LinkedList;
    //   2081: invokevirtual 861	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   2084: checkcast 863	bctm
    //   2087: invokevirtual 864	bctm:toString	()Ljava/lang/String;
    //   2090: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: pop
    //   2094: goto -35 -> 2059
    //   2097: astore 10
    //   2099: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   2102: invokestatic 870	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2105: istore 5
    //   2107: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   2110: invokestatic 875	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2113: istore 8
    //   2115: aload 12
    //   2117: bipush 10
    //   2119: invokevirtual 878	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2122: ldc_w 880
    //   2125: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: astore 11
    //   2130: iload 8
    //   2132: ifne +593 -> 2725
    //   2135: ldc_w 882
    //   2138: astore 10
    //   2140: aload 11
    //   2142: aload 10
    //   2144: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2147: ldc_w 884
    //   2150: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: iload 5
    //   2155: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2158: ldc_w 886
    //   2161: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: iload 8
    //   2166: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2169: pop
    //   2170: aload 12
    //   2172: ldc_w 888
    //   2175: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   2181: invokestatic 891	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2184: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: pop
    //   2188: aload 12
    //   2190: ldc_w 893
    //   2193: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   2199: new 291	java/util/Date
    //   2202: dup
    //   2203: getstatic 895	abev:jdField_a_of_type_Long	J
    //   2206: invokespecial 294	java/util/Date:<init>	(J)V
    //   2209: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2212: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: pop
    //   2216: aload 12
    //   2218: ldc_w 897
    //   2221: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   2227: new 291	java/util/Date
    //   2230: dup
    //   2231: getstatic 898	abev:jdField_b_of_type_Long	J
    //   2234: invokespecial 294	java/util/Date:<init>	(J)V
    //   2237: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2240: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: ldc 228
    //   2245: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: pop
    //   2249: iload_1
    //   2250: ifeq +103 -> 2353
    //   2253: aload 13
    //   2255: ldc_w 576
    //   2258: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2261: ifne +25 -> 2286
    //   2264: aload 13
    //   2266: ldc_w 578
    //   2269: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2272: ifne +14 -> 2286
    //   2275: aload 13
    //   2277: ldc_w 369
    //   2280: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2283: ifeq +70 -> 2353
    //   2286: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   2289: ldc 198
    //   2291: iconst_4
    //   2292: invokevirtual 902	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2295: ldc_w 904
    //   2298: aconst_null
    //   2299: invokeinterface 910 3 0
    //   2304: astore 10
    //   2306: aload 12
    //   2308: ldc_w 912
    //   2311: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: aload 10
    //   2316: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: pop
    //   2320: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2323: ifeq +30 -> 2353
    //   2326: ldc 198
    //   2328: iconst_2
    //   2329: new 19	java/lang/StringBuilder
    //   2332: dup
    //   2333: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2336: ldc_w 914
    //   2339: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2342: aload 10
    //   2344: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2347: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2350: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2353: aload 13
    //   2355: ldc_w 916
    //   2358: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2361: ifne +80 -> 2441
    //   2364: aload 13
    //   2366: ldc_w 918
    //   2369: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2372: ifne +69 -> 2441
    //   2375: aload 13
    //   2377: ldc_w 920
    //   2380: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2383: ifne +58 -> 2441
    //   2386: aload 13
    //   2388: ldc_w 922
    //   2391: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2394: ifne +47 -> 2441
    //   2397: aload 13
    //   2399: ldc_w 924
    //   2402: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2405: ifne +36 -> 2441
    //   2408: aload 13
    //   2410: ldc_w 926
    //   2413: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2416: ifne +25 -> 2441
    //   2419: aload 13
    //   2421: ldc_w 928
    //   2424: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2427: ifne +14 -> 2441
    //   2430: aload 13
    //   2432: ldc_w 930
    //   2435: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2438: ifeq +60 -> 2498
    //   2441: invokestatic 933	blyk:a	()Ljava/lang/String;
    //   2444: astore 10
    //   2446: aload 10
    //   2448: ifnull +50 -> 2498
    //   2451: aload 12
    //   2453: ldc_w 935
    //   2456: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: aload 10
    //   2461: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2464: pop
    //   2465: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2468: ifeq +30 -> 2498
    //   2471: ldc 198
    //   2473: iconst_2
    //   2474: new 19	java/lang/StringBuilder
    //   2477: dup
    //   2478: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2481: ldc_w 937
    //   2484: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: aload 10
    //   2489: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2495: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2498: aload 12
    //   2500: ldc_w 939
    //   2503: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2509: getfield 946	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2512: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: pop
    //   2516: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2519: getfield 950	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2522: ifnull +233 -> 2755
    //   2525: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2528: getfield 950	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2531: invokeinterface 954 1 0
    //   2536: ifne +219 -> 2755
    //   2539: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2542: getfield 950	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2545: invokeinterface 955 1 0
    //   2550: astore 10
    //   2552: aload 10
    //   2554: invokeinterface 121 1 0
    //   2559: ifeq +196 -> 2755
    //   2562: aload 10
    //   2564: invokeinterface 125 1 0
    //   2569: checkcast 957	android/util/Pair
    //   2572: astore 11
    //   2574: aload 11
    //   2576: ifnull -24 -> 2552
    //   2579: aload 12
    //   2581: ldc_w 959
    //   2584: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   2590: new 291	java/util/Date
    //   2593: dup
    //   2594: aload 11
    //   2596: getfield 962	android/util/Pair:first	Ljava/lang/Object;
    //   2599: checkcast 964	java/lang/Long
    //   2602: invokevirtual 967	java/lang/Long:longValue	()J
    //   2605: invokespecial 294	java/util/Date:<init>	(J)V
    //   2608: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2611: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2614: ldc_w 969
    //   2617: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: aload 11
    //   2622: getfield 972	android/util/Pair:second	Ljava/lang/Object;
    //   2625: checkcast 224	java/lang/String
    //   2628: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2631: pop
    //   2632: goto -80 -> 2552
    //   2635: ldc_w 974
    //   2638: astore 10
    //   2640: goto -2278 -> 362
    //   2643: ldc_w 974
    //   2646: astore 10
    //   2648: goto -2173 -> 475
    //   2651: astore 10
    //   2653: aload 10
    //   2655: invokevirtual 977	java/lang/Throwable:printStackTrace	()V
    //   2658: goto -1861 -> 797
    //   2661: astore 12
    //   2663: aload 11
    //   2665: astore 10
    //   2667: aload 12
    //   2669: astore 11
    //   2671: aload 11
    //   2673: invokevirtual 978	java/lang/Exception:printStackTrace	()V
    //   2676: aload 10
    //   2678: ifnull -1734 -> 944
    //   2681: aload 10
    //   2683: invokevirtual 555	java/io/FileWriter:close	()V
    //   2686: goto -1742 -> 944
    //   2689: astore 10
    //   2691: goto -1747 -> 944
    //   2694: astore_2
    //   2695: aconst_null
    //   2696: astore_3
    //   2697: aload_3
    //   2698: ifnull +7 -> 2705
    //   2701: aload_3
    //   2702: invokevirtual 555	java/io/FileWriter:close	()V
    //   2705: aload_2
    //   2706: athrow
    //   2707: iconst_0
    //   2708: istore 9
    //   2710: goto -1522 -> 1188
    //   2713: aload_0
    //   2714: getfield 12	bctk:a	Lbctj;
    //   2717: invokestatic 753	bctj:a	(Lbctj;)Ljava/lang/String;
    //   2720: astore 10
    //   2722: goto -1107 -> 1615
    //   2725: ldc_w 980
    //   2728: astore 10
    //   2730: goto -590 -> 2140
    //   2733: astore 10
    //   2735: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2738: ifeq -240 -> 2498
    //   2741: ldc 198
    //   2743: iconst_2
    //   2744: ldc_w 982
    //   2747: aload 10
    //   2749: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2752: goto -254 -> 2498
    //   2755: getstatic 985	bjdc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2758: astore 10
    //   2760: aload 10
    //   2762: ifnull +25 -> 2787
    //   2765: aload 10
    //   2767: invokevirtual 988	java/lang/String:length	()I
    //   2770: ifle +17 -> 2787
    //   2773: aload 12
    //   2775: ldc_w 990
    //   2778: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2781: aload 10
    //   2783: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: pop
    //   2787: aload_2
    //   2788: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2791: ifne +49 -> 2840
    //   2794: aload_2
    //   2795: ldc_w 992
    //   2798: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2801: ifeq +39 -> 2840
    //   2804: aload 4
    //   2806: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2809: ifne +31 -> 2840
    //   2812: aload 4
    //   2814: ldc_w 994
    //   2817: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2820: ifeq +20 -> 2840
    //   2823: aload 12
    //   2825: ldc_w 996
    //   2828: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: pop
    //   2832: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2835: aload 12
    //   2837: invokestatic 999	bctj:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2840: ldc_w 1001
    //   2843: aload_2
    //   2844: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2847: ifeq +22 -> 2869
    //   2850: aload 4
    //   2852: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2855: ifne +14 -> 2869
    //   2858: aload 4
    //   2860: ldc_w 1003
    //   2863: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2866: ifne +32 -> 2898
    //   2869: ldc_w 1005
    //   2872: aload_2
    //   2873: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2876: ifeq +40 -> 2916
    //   2879: aload 4
    //   2881: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2884: ifne +32 -> 2916
    //   2887: aload 4
    //   2889: ldc_w 1007
    //   2892: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2895: ifeq +21 -> 2916
    //   2898: aload 12
    //   2900: ldc_w 1009
    //   2903: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2906: ldc_w 1011
    //   2909: invokestatic 1014	bgjq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2912: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2915: pop
    //   2916: ldc_w 1016
    //   2919: aload_2
    //   2920: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2923: ifne +66 -> 2989
    //   2926: ldc_w 354
    //   2929: aload_2
    //   2930: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2933: ifeq +14 -> 2947
    //   2936: aload 4
    //   2938: ldc_w 1018
    //   2941: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2944: ifne +45 -> 2989
    //   2947: ldc_w 1020
    //   2950: aload_2
    //   2951: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2954: ifeq +14 -> 2968
    //   2957: aload 4
    //   2959: ldc_w 1022
    //   2962: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2965: ifne +24 -> 2989
    //   2968: ldc_w 354
    //   2971: aload_2
    //   2972: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2975: ifeq +94 -> 3069
    //   2978: aload 4
    //   2980: ldc_w 1024
    //   2983: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2986: ifeq +83 -> 3069
    //   2989: invokestatic 289	bctj:a	()Ljava/text/SimpleDateFormat;
    //   2992: new 291	java/util/Date
    //   2995: dup
    //   2996: getstatic 1025	bctj:jdField_a_of_type_Long	J
    //   2999: invokespecial 294	java/util/Date:<init>	(J)V
    //   3002: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3005: astore 10
    //   3007: aload 12
    //   3009: ldc_w 1027
    //   3012: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: getstatic 1028	bctj:jdField_a_of_type_Int	I
    //   3018: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3021: ldc_w 1030
    //   3024: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3027: aload 10
    //   3029: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3032: pop
    //   3033: aload 12
    //   3035: ldc_w 1032
    //   3038: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3041: pop
    //   3042: aload 12
    //   3044: invokestatic 1034	bctj:c	()Ljava/lang/String;
    //   3047: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3050: pop
    //   3051: aload 12
    //   3053: ldc_w 1036
    //   3056: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: pop
    //   3060: aload 12
    //   3062: invokestatic 1041	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3065: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3068: pop
    //   3069: iconst_1
    //   3070: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3073: if_icmpne +49 -> 3122
    //   3076: aload_3
    //   3077: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3080: ifne +42 -> 3122
    //   3083: aload_2
    //   3084: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3087: ifne +35 -> 3122
    //   3090: aload_2
    //   3091: ldc_w 1043
    //   3094: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3097: ifeq +25 -> 3122
    //   3100: aload_3
    //   3101: ldc_w 1045
    //   3104: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3107: ifeq +15 -> 3122
    //   3110: aload_0
    //   3111: aload 12
    //   3113: invokespecial 1047	bctk:b	(Ljava/lang/StringBuilder;)V
    //   3116: aload_0
    //   3117: aload 12
    //   3119: invokespecial 1048	bctk:a	(Ljava/lang/StringBuilder;)V
    //   3122: iconst_1
    //   3123: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3126: if_icmpne +142 -> 3268
    //   3129: invokestatic 1050	bctj:d	()Z
    //   3132: ifeq +136 -> 3268
    //   3135: aload 4
    //   3137: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3140: ifne +128 -> 3268
    //   3143: aload_2
    //   3144: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3147: ifne +121 -> 3268
    //   3150: aload_2
    //   3151: ldc_w 1052
    //   3154: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3157: ifeq +111 -> 3268
    //   3160: aload 4
    //   3162: ldc_w 1054
    //   3165: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3168: ifeq +100 -> 3268
    //   3171: ldc 198
    //   3173: iconst_1
    //   3174: ldc_w 1056
    //   3177: invokestatic 582	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3180: new 529	java/io/File
    //   3183: dup
    //   3184: invokestatic 815	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3187: invokevirtual 1059	com/tencent/qphone/base/util/BaseApplication:getPackageResourcePath	()Ljava/lang/String;
    //   3190: invokespecial 532	java/io/File:<init>	(Ljava/lang/String;)V
    //   3193: astore_2
    //   3194: aload_2
    //   3195: invokevirtual 535	java/io/File:exists	()Z
    //   3198: ifeq +70 -> 3268
    //   3201: aload_2
    //   3202: invokestatic 1064	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   3205: astore_2
    //   3206: ldc 198
    //   3208: iconst_1
    //   3209: new 19	java/lang/StringBuilder
    //   3212: dup
    //   3213: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   3216: ldc_w 1066
    //   3219: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3222: aload_2
    //   3223: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: ldc 228
    //   3228: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3234: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3237: aload 12
    //   3239: new 19	java/lang/StringBuilder
    //   3242: dup
    //   3243: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   3246: ldc_w 1066
    //   3249: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: aload_2
    //   3253: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3256: ldc 228
    //   3258: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3264: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3267: pop
    //   3268: ldc 198
    //   3270: iconst_1
    //   3271: new 19	java/lang/StringBuilder
    //   3274: dup
    //   3275: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   3278: ldc_w 1068
    //   3281: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: aload 12
    //   3286: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3289: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3295: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3298: aload 12
    //   3300: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3303: areturn
    //   3304: astore_2
    //   3305: ldc 198
    //   3307: iconst_1
    //   3308: ldc_w 1070
    //   3311: aload_2
    //   3312: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3315: goto -47 -> 3268
    //   3318: astore 10
    //   3320: goto -2376 -> 944
    //   3323: astore_3
    //   3324: goto -619 -> 2705
    //   3327: astore 10
    //   3329: goto -413 -> 2916
    //   3332: astore 10
    //   3334: goto -547 -> 2787
    //   3337: astore 10
    //   3339: goto -1090 -> 2249
    //   3342: astore 10
    //   3344: goto -1156 -> 2188
    //   3347: astore 10
    //   3349: goto -1290 -> 2059
    //   3352: astore_2
    //   3353: aload 10
    //   3355: astore_3
    //   3356: goto -659 -> 2697
    //   3359: astore_2
    //   3360: aload 10
    //   3362: astore_3
    //   3363: goto -666 -> 2697
    //   3366: astore 11
    //   3368: goto -697 -> 2671
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3371	0	this	bctk
    //   0	3371	1	paramBoolean	boolean
    //   0	3371	2	paramString1	String
    //   0	3371	3	paramString2	String
    //   0	3371	4	paramString3	String
    //   0	3371	5	paramInt	int
    //   0	3371	6	paramLong	long
    //   2113	52	8	i	int
    //   1186	1523	9	bool	boolean
    //   360	1585	10	localObject1	Object
    //   2097	1	10	localThrowable1	Throwable
    //   2138	509	10	localObject2	Object
    //   2651	3	10	localThrowable2	Throwable
    //   2665	17	10	localObject3	Object
    //   2689	1	10	localException1	java.lang.Exception
    //   2720	9	10	str1	String
    //   2733	15	10	localThrowable3	Throwable
    //   2758	270	10	str2	String
    //   3318	1	10	localException2	java.lang.Exception
    //   3327	1	10	localThrowable4	Throwable
    //   3332	1	10	localThrowable5	Throwable
    //   3337	1	10	localThrowable6	Throwable
    //   3342	1	10	localThrowable7	Throwable
    //   3347	14	10	localThrowable8	Throwable
    //   351	2321	11	localObject4	Object
    //   3366	1	11	localException3	java.lang.Exception
    //   1056	1524	12	localStringBuilder	StringBuilder
    //   2661	638	12	localException4	java.lang.Exception
    //   998	1433	13	str3	String
    //   1522	65	14	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   2059	2094	2097	java/lang/Throwable
    //   672	752	2651	java/lang/Throwable
    //   757	797	2651	java/lang/Throwable
    //   800	812	2661	java/lang/Exception
    //   817	831	2661	java/lang/Exception
    //   831	867	2661	java/lang/Exception
    //   2681	2686	2689	java/lang/Exception
    //   800	812	2694	finally
    //   817	831	2694	finally
    //   831	867	2694	finally
    //   2353	2441	2733	java/lang/Throwable
    //   2441	2446	2733	java/lang/Throwable
    //   2451	2498	2733	java/lang/Throwable
    //   3180	3268	3304	java/lang/Throwable
    //   939	944	3318	java/lang/Exception
    //   2701	2705	3323	java/lang/Exception
    //   2787	2840	3327	java/lang/Throwable
    //   2840	2869	3327	java/lang/Throwable
    //   2869	2898	3327	java/lang/Throwable
    //   2898	2916	3327	java/lang/Throwable
    //   2755	2760	3332	java/lang/Throwable
    //   2765	2787	3332	java/lang/Throwable
    //   2188	2249	3337	java/lang/Throwable
    //   2099	2130	3342	java/lang/Throwable
    //   2140	2188	3342	java/lang/Throwable
    //   1058	1172	3347	java/lang/Throwable
    //   1177	1185	3347	java/lang/Throwable
    //   1188	1362	3347	java/lang/Throwable
    //   1362	1420	3347	java/lang/Throwable
    //   1420	1440	3347	java/lang/Throwable
    //   1445	1498	3347	java/lang/Throwable
    //   1498	1538	3347	java/lang/Throwable
    //   1552	1610	3347	java/lang/Throwable
    //   1615	1723	3347	java/lang/Throwable
    //   1723	1752	3347	java/lang/Throwable
    //   1752	1781	3347	java/lang/Throwable
    //   1781	1810	3347	java/lang/Throwable
    //   1810	1950	3347	java/lang/Throwable
    //   1950	2039	3347	java/lang/Throwable
    //   2039	2059	3347	java/lang/Throwable
    //   2713	2722	3347	java/lang/Throwable
    //   867	934	3352	finally
    //   2671	2676	3359	finally
    //   867	934	3366	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 198
    //   2: iconst_1
    //   3: new 19	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 1074
    //   10: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 1076
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 1078	bctj:b	()Z
    //   26: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 1078	bctj:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 1080	bctj:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   55: ldc 198
    //   57: iconst_4
    //   58: invokevirtual 902	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 1084 1 0
    //   66: ldc_w 1086
    //   69: iconst_1
    //   70: invokeinterface 1092 3 0
    //   75: invokeinterface 1095 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 1096	bctj:a	()Ljava/lang/String;
    //   88: invokestatic 1097	bctj:b	()Ljava/lang/String;
    //   91: invokestatic 1100	bctj:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 1103	bctj:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	bctk:a	Lbctj;
    //   111: invokestatic 1105	bctj:a	(Lbctj;)V
    //   114: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 1108	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	bctk:a	Lbctj;
    //   124: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 1111	bctj:a	(Lbctj;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 1113
    //   135: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +30 -> 168
    //   141: aload_0
    //   142: getfield 12	bctk:a	Lbctj;
    //   145: invokevirtual 1114	bctj:a	()V
    //   148: aload_0
    //   149: getfield 12	bctk:a	Lbctj;
    //   152: invokevirtual 1115	bctj:b	()V
    //   155: aload_0
    //   156: getfield 12	bctk:a	Lbctj;
    //   159: invokestatic 1096	bctj:a	()Ljava/lang/String;
    //   162: invokestatic 1097	bctj:b	()Ljava/lang/String;
    //   165: invokevirtual 1118	bctj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: ldc_w 576
    //   172: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   175: ifne +23 -> 198
    //   178: aload_3
    //   179: ldc_w 369
    //   182: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +13 -> 198
    //   188: aload_3
    //   189: ldc_w 1120
    //   192: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   195: ifeq +18 -> 213
    //   198: aload_0
    //   199: getfield 12	bctk:a	Lbctj;
    //   202: invokevirtual 1114	bctj:a	()V
    //   205: aload_0
    //   206: getfield 12	bctk:a	Lbctj;
    //   209: aload_3
    //   210: invokevirtual 1122	bctj:b	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: ldc_w 576
    //   217: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   220: ifne +43 -> 263
    //   223: aload_3
    //   224: ldc_w 369
    //   227: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   230: ifne +33 -> 263
    //   233: aload_3
    //   234: ldc_w 1120
    //   237: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   240: ifne +23 -> 263
    //   243: aload_3
    //   244: ldc_w 1124
    //   247: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   250: ifne +13 -> 263
    //   253: aload_3
    //   254: ldc_w 578
    //   257: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   260: ifeq +88 -> 348
    //   263: ldc_w 1126
    //   266: iconst_0
    //   267: invokestatic 1132	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   270: ifeq +78 -> 348
    //   273: ldc 198
    //   275: iconst_1
    //   276: new 19	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 1134
    //   286: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   292: ldc2_w 1135
    //   295: ldiv
    //   296: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: new 19	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 1138
    //   315: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 12	bctk:a	Lbctj;
    //   322: getfield 407	bctj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   334: ldc2_w 1135
    //   337: ldiv
    //   338: invokestatic 1142	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   341: ldc_w 1126
    //   344: iconst_0
    //   345: invokestatic 1146	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   348: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   351: invokevirtual 1149	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   354: aload_3
    //   355: ldc_w 1113
    //   358: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +362 -> 723
    //   364: new 444	android/content/Intent
    //   367: dup
    //   368: ldc_w 1151
    //   371: invokespecial 1152	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   374: astore 4
    //   376: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   379: ldc_w 1154
    //   382: invokevirtual 1158	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: checkcast 1160	android/app/ActivityManager
    //   388: invokevirtual 1164	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   391: astore 6
    //   393: new 440	java/util/ArrayList
    //   396: dup
    //   397: invokespecial 1165	java/util/ArrayList:<init>	()V
    //   400: astore 5
    //   402: aload 6
    //   404: ifnull +282 -> 686
    //   407: aload 6
    //   409: invokeinterface 1166 1 0
    //   414: ifle +272 -> 686
    //   417: aload 6
    //   419: invokeinterface 115 1 0
    //   424: astore 6
    //   426: aload 6
    //   428: invokeinterface 121 1 0
    //   433: ifeq +253 -> 686
    //   436: aload 6
    //   438: invokeinterface 125 1 0
    //   443: checkcast 1168	android/app/ActivityManager$RunningAppProcessInfo
    //   446: getfield 1169	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   449: astore 7
    //   451: aload 7
    //   453: ifnull -27 -> 426
    //   456: aload 7
    //   458: ldc_w 1171
    //   461: invokevirtual 1174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   464: ifeq -38 -> 426
    //   467: aload 7
    //   469: ldc_w 1176
    //   472: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   475: ifne -49 -> 426
    //   478: aload 5
    //   480: aload 7
    //   482: invokevirtual 1179	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   485: pop
    //   486: goto -60 -> 426
    //   489: astore 4
    //   491: aload 4
    //   493: invokevirtual 977	java/lang/Throwable:printStackTrace	()V
    //   496: aload_3
    //   497: ldc_w 1113
    //   500: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +395 -> 898
    //   506: aload_0
    //   507: getfield 12	bctk:a	Lbctj;
    //   510: getfield 1181	bctj:jdField_a_of_type_Boolean	Z
    //   513: ifeq +376 -> 889
    //   516: ldc 198
    //   518: iconst_1
    //   519: new 19	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1183
    //   529: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: getfield 12	bctk:a	Lbctj;
    //   536: getfield 1181	bctj:jdField_a_of_type_Boolean	Z
    //   539: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: ldc_w 1185
    //   545: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   557: ldc_w 1154
    //   560: invokevirtual 1158	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   563: checkcast 1160	android/app/ActivityManager
    //   566: invokevirtual 1164	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   569: astore_3
    //   570: aload_3
    //   571: ifnull +260 -> 831
    //   574: aload_3
    //   575: invokeinterface 1166 1 0
    //   580: ifle +251 -> 831
    //   583: aload_3
    //   584: invokeinterface 115 1 0
    //   589: astore_3
    //   590: aload_3
    //   591: invokeinterface 121 1 0
    //   596: ifeq +235 -> 831
    //   599: aload_3
    //   600: invokeinterface 125 1 0
    //   605: checkcast 1168	android/app/ActivityManager$RunningAppProcessInfo
    //   608: astore 4
    //   610: aload 4
    //   612: getfield 1169	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   615: astore 5
    //   617: aload 5
    //   619: ifnull -29 -> 590
    //   622: aload 5
    //   624: ldc_w 1171
    //   627: invokevirtual 1174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   630: ifeq -40 -> 590
    //   633: aload 5
    //   635: ldc_w 1176
    //   638: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   641: ifne -51 -> 590
    //   644: aload 4
    //   646: getfield 1188	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   649: invokestatic 1193	android/os/Process:killProcess	(I)V
    //   652: goto -62 -> 590
    //   655: astore_3
    //   656: aload_3
    //   657: invokevirtual 977	java/lang/Throwable:printStackTrace	()V
    //   660: iconst_1
    //   661: ireturn
    //   662: astore 4
    //   664: aload 4
    //   666: invokevirtual 977	java/lang/Throwable:printStackTrace	()V
    //   669: goto -538 -> 131
    //   672: astore 4
    //   674: ldc 198
    //   676: iconst_1
    //   677: ldc_w 1195
    //   680: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: goto -335 -> 348
    //   686: aload 4
    //   688: ldc_w 1197
    //   691: aload 5
    //   693: invokevirtual 1201	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   696: pop
    //   697: aload 4
    //   699: ldc_w 1203
    //   702: aload 5
    //   704: iconst_0
    //   705: invokestatic 1207	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   708: invokevirtual 1211	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   711: pop
    //   712: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   715: aload 4
    //   717: invokevirtual 469	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   720: goto -224 -> 496
    //   723: aload_3
    //   724: ldc_w 576
    //   727: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   730: ifeq +72 -> 802
    //   733: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   736: ldc_w 1154
    //   739: invokevirtual 1158	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   742: checkcast 1160	android/app/ActivityManager
    //   745: invokevirtual 1164	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   748: invokeinterface 115 1 0
    //   753: astore 4
    //   755: aload 4
    //   757: invokeinterface 121 1 0
    //   762: ifeq -266 -> 496
    //   765: aload 4
    //   767: invokeinterface 125 1 0
    //   772: checkcast 1168	android/app/ActivityManager$RunningAppProcessInfo
    //   775: astore 5
    //   777: aload 5
    //   779: getfield 1169	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   782: ldc_w 1213
    //   785: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq -33 -> 755
    //   791: aload 5
    //   793: getfield 1188	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   796: invokestatic 1193	android/os/Process:killProcess	(I)V
    //   799: goto -44 -> 755
    //   802: aload_3
    //   803: ldc_w 1215
    //   806: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   809: ifne -313 -> 496
    //   812: aload_3
    //   813: ldc_w 1217
    //   816: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   819: ifeq -323 -> 496
    //   822: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   825: invokestatic 1222	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   828: goto -332 -> 496
    //   831: invokestatic 324	bctj:a	()Landroid/content/Context;
    //   834: ldc_w 1224
    //   837: iconst_0
    //   838: invokevirtual 902	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   841: astore_3
    //   842: aload_3
    //   843: ldc_w 1226
    //   846: iconst_0
    //   847: invokeinterface 1230 3 0
    //   852: istore_2
    //   853: aload_3
    //   854: invokeinterface 1084 1 0
    //   859: ldc_w 1226
    //   862: iload_2
    //   863: iconst_1
    //   864: iadd
    //   865: invokeinterface 1234 3 0
    //   870: invokeinterface 1095 1 0
    //   875: pop
    //   876: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   879: iconst_1
    //   880: invokevirtual 1237	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   883: invokestatic 1240	android/os/Process:myPid	()I
    //   886: invokestatic 1193	android/os/Process:killProcess	(I)V
    //   889: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   892: iconst_1
    //   893: invokevirtual 1243	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   896: iconst_1
    //   897: ireturn
    //   898: aload_3
    //   899: ldc_w 576
    //   902: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   905: ifne +45 -> 950
    //   908: aload_3
    //   909: ldc_w 1245
    //   912: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   915: ifne +35 -> 950
    //   918: aload_3
    //   919: ldc_w 1215
    //   922: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   925: ifne +25 -> 950
    //   928: aload_3
    //   929: ldc_w 916
    //   932: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   935: ifeq +6 -> 941
    //   938: goto +12 -> 950
    //   941: invokestatic 943	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   944: iconst_0
    //   945: invokevirtual 1248	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   948: iconst_1
    //   949: ireturn
    //   950: iload_1
    //   951: ifeq -905 -> 46
    //   954: goto -13 -> 941
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	bctk
    //   0	957	1	paramBoolean	boolean
    //   852	13	2	i	int
    //   106	494	3	localObject1	Object
    //   655	158	3	localThrowable1	Throwable
    //   841	88	3	localSharedPreferences	android.content.SharedPreferences
    //   374	1	4	localIntent	android.content.Intent
    //   489	3	4	localThrowable2	Throwable
    //   608	37	4	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   662	3	4	localThrowable3	Throwable
    //   672	44	4	localThrowable4	Throwable
    //   753	13	4	localIterator	Iterator
    //   400	392	5	localObject2	Object
    //   391	46	6	localObject3	Object
    //   449	32	7	str	String
    // Exception table:
    //   from	to	target	type
    //   348	402	489	java/lang/Throwable
    //   407	426	489	java/lang/Throwable
    //   426	451	489	java/lang/Throwable
    //   456	486	489	java/lang/Throwable
    //   686	720	489	java/lang/Throwable
    //   723	755	489	java/lang/Throwable
    //   755	799	489	java/lang/Throwable
    //   802	828	489	java/lang/Throwable
    //   496	570	655	java/lang/Throwable
    //   574	590	655	java/lang/Throwable
    //   590	617	655	java/lang/Throwable
    //   622	652	655	java/lang/Throwable
    //   831	889	655	java/lang/Throwable
    //   889	896	655	java/lang/Throwable
    //   898	938	655	java/lang/Throwable
    //   941	948	655	java/lang/Throwable
    //   107	131	662	java/lang/Throwable
    //   131	168	672	java/lang/Throwable
    //   168	198	672	java/lang/Throwable
    //   198	213	672	java/lang/Throwable
    //   213	263	672	java/lang/Throwable
    //   263	348	672	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + bctj.c() + ", sIsFinalizeTimeoutException=" + bctj.b());
    if ((bctj.c()) && (!bctj.b()) && (!bctj.a(bctj.a(), bctj.b()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + anrr.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = bctj.a(this.a).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)bctj.a(this.a).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            bctj.b(true);
            break;
          }
        }
        bctj.a(this.a).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(bctj.a(this.a).toString());
        bctj.a(this.a, localStringBuilder1.toString());
        bctj.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + bctj.a().format(new Date(paramLong)) + ", curTime=" + bctj.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      bctj.a(paramBoolean);
      if (!bctj.b()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    bgha.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bctk
 * JD-Core Version:    0.7.0.1
 */