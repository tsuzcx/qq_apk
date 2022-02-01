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

class bdmd
  implements CrashHandleListener
{
  bdmd(bdmc parambdmc) {}
  
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
    Collections.sort((List)localObject, new bdme(this));
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
    //   65: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
    //   68: new 291	java/util/Date
    //   71: dup
    //   72: lload 6
    //   74: invokespecial 294	java/util/Date:<init>	(J)V
    //   77: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   80: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_2
    //   90: invokestatic 303	bdmc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 305	bdmc:b	(Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: iconst_1
    //   101: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   104: if_icmpne +41 -> 145
    //   107: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 319	bdmc:jdField_b_of_type_Long	J
    //   113: lsub
    //   114: ldc2_w 320
    //   117: lcmp
    //   118: ifgt +27 -> 145
    //   121: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   124: new 19	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 329	abiz:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   196: getstatic 352	bdmc:jdField_a_of_type_Bdmk	Lbdmk;
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
    //   233: getstatic 352	bdmc:jdField_a_of_type_Bdmk	Lbdmk;
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
    //   279: invokestatic 378	alii:a	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +17 -> 301
    //   287: aload 4
    //   289: ldc_w 380
    //   292: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +6 -> 301
    //   298: invokestatic 383	bdnj:b	()V
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
    //   354: ifeq +1258 -> 1612
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
    //   395: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   398: invokestatic 405	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   401: aload_0
    //   402: getfield 12	bdmd:a	Lbdmc;
    //   405: getfield 407	bdmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   408: ldc_w 409
    //   411: iconst_1
    //   412: lconst_0
    //   413: lconst_0
    //   414: aload 11
    //   416: ldc_w 411
    //   419: iconst_0
    //   420: invokevirtual 414	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   423: iload_1
    //   424: aload_2
    //   425: aload 4
    //   427: invokestatic 419	annw:a	(ZLjava/lang/String;Ljava/lang/String;)V
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
    //   467: ifeq +1153 -> 1620
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
    //   508: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   511: invokestatic 405	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   514: aload_0
    //   515: getfield 12	bdmd:a	Lbdmc;
    //   518: getfield 407	bdmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 425
    //   524: iconst_1
    //   525: lconst_0
    //   526: lconst_0
    //   527: aload 11
    //   529: ldc_w 411
    //   532: iconst_0
    //   533: invokevirtual 414	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   536: iload_1
    //   537: aload_2
    //   538: aload_3
    //   539: aload 4
    //   541: iload 5
    //   543: lload 6
    //   545: invokestatic 430	bdgx:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
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
    //   590: invokestatic 324	bdmc:a	()Landroid/content/Context;
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
    //   881: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
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
    //   989: invokestatic 573	abjg:a	()Labjg;
    //   992: invokevirtual 574	abjg:b	()V
    //   995: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   998: astore 14
    //   1000: iload_1
    //   1001: ifeq +39 -> 1040
    //   1004: aload 14
    //   1006: ldc_w 576
    //   1009: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1012: ifne +14 -> 1026
    //   1015: aload 14
    //   1017: ldc_w 578
    //   1020: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1023: ifeq +17 -> 1040
    //   1026: ldc_w 580
    //   1029: iconst_1
    //   1030: aload 4
    //   1032: invokestatic 582	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload 4
    //   1037: invokestatic 587	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1040: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   1043: invokestatic 592	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1046: new 19	java/lang/StringBuilder
    //   1049: dup
    //   1050: sipush 128
    //   1053: invokespecial 22	java/lang/StringBuilder:<init>	(I)V
    //   1056: astore 13
    //   1058: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   1061: ldc_w 594
    //   1064: invokestatic 599	aczi:a	(Landroid/content/Context;Ljava/lang/String;)Laczh;
    //   1067: astore 10
    //   1069: aload 13
    //   1071: ldc_w 601
    //   1074: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload 13
    //   1080: ldc_w 603
    //   1083: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 13
    //   1089: ldc_w 605
    //   1092: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: getstatic 608	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1098: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 13
    //   1104: ldc_w 610
    //   1107: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: getstatic 613	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1113: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 13
    //   1119: ldc_w 615
    //   1122: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1128: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 13
    //   1134: ldc_w 620
    //   1137: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: getstatic 623	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1143: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 13
    //   1149: ldc_w 625
    //   1152: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: getstatic 629	bdho:b	I
    //   1158: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 13
    //   1164: ldc_w 631
    //   1167: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: astore 11
    //   1172: aload 10
    //   1174: ifnull +510 -> 1684
    //   1177: aload 10
    //   1179: invokevirtual 635	aczh:a	()Z
    //   1182: ifeq +502 -> 1684
    //   1185: iconst_1
    //   1186: istore 9
    //   1188: aload 11
    //   1190: iload 9
    //   1192: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: ldc_w 637
    //   1198: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: getstatic 641	acyx:jdField_a_of_type_Int	I
    //   1204: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 643
    //   1210: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: getstatic 646	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1216: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 648
    //   1222: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: getstatic 649	acyx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1228: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 13
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
    //   1272: aload 13
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
    //   1320: aload 13
    //   1322: ldc_w 683
    //   1325: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokestatic 688	bdlx:a	()Lbdlx;
    //   1331: invokevirtual 690	bdlx:a	()Ljava/lang/String;
    //   1334: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: getstatic 694	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1341: ifnull +21 -> 1362
    //   1344: aload 13
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
    //   1412: getfield 12	bdmd:a	Lbdmc;
    //   1415: aload 13
    //   1417: invokevirtual 705	bdmc:a	(Ljava/lang/StringBuilder;)V
    //   1420: aload 13
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
    //   1452: aload 13
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
    //   1498: aload 13
    //   1500: ldc 228
    //   1502: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aconst_null
    //   1507: astore 11
    //   1509: new 724	java/io/BufferedReader
    //   1512: dup
    //   1513: new 726	java/io/FileReader
    //   1516: dup
    //   1517: ldc_w 728
    //   1520: invokespecial 729	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   1523: invokespecial 732	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1526: astore 10
    //   1528: aload 10
    //   1530: invokevirtual 735	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1533: astore 11
    //   1535: aload 13
    //   1537: ldc 228
    //   1539: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 11
    //   1545: ifnull +145 -> 1690
    //   1548: aload 11
    //   1550: ldc_w 737
    //   1553: invokevirtual 740	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1556: ifne +14 -> 1570
    //   1559: aload 11
    //   1561: ldc_w 742
    //   1564: invokevirtual 740	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1567: ifeq +35 -> 1602
    //   1570: aload 11
    //   1572: ldc_w 744
    //   1575: ldc_w 411
    //   1578: invokevirtual 748	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1581: pop
    //   1582: aload 13
    //   1584: aload 11
    //   1586: invokevirtual 751	java/lang/String:trim	()Ljava/lang/String;
    //   1589: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 13
    //   1595: ldc_w 753
    //   1598: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: pop
    //   1602: aload 10
    //   1604: invokevirtual 735	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1607: astore 11
    //   1609: goto -66 -> 1543
    //   1612: ldc_w 755
    //   1615: astore 10
    //   1617: goto -1255 -> 362
    //   1620: ldc_w 755
    //   1623: astore 10
    //   1625: goto -1150 -> 475
    //   1628: astore 10
    //   1630: aload 10
    //   1632: invokevirtual 758	java/lang/Throwable:printStackTrace	()V
    //   1635: goto -838 -> 797
    //   1638: astore 12
    //   1640: aload 11
    //   1642: astore 10
    //   1644: aload 12
    //   1646: astore 11
    //   1648: aload 11
    //   1650: invokevirtual 759	java/lang/Exception:printStackTrace	()V
    //   1653: aload 10
    //   1655: ifnull -711 -> 944
    //   1658: aload 10
    //   1660: invokevirtual 555	java/io/FileWriter:close	()V
    //   1663: goto -719 -> 944
    //   1666: astore 10
    //   1668: goto -724 -> 944
    //   1671: astore_2
    //   1672: aconst_null
    //   1673: astore_3
    //   1674: aload_3
    //   1675: ifnull +7 -> 1682
    //   1678: aload_3
    //   1679: invokevirtual 555	java/io/FileWriter:close	()V
    //   1682: aload_2
    //   1683: athrow
    //   1684: iconst_0
    //   1685: istore 9
    //   1687: goto -499 -> 1188
    //   1690: aload 13
    //   1692: ldc 228
    //   1694: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload 10
    //   1700: ifnull +8 -> 1708
    //   1703: aload 10
    //   1705: invokevirtual 760	java/io/BufferedReader:close	()V
    //   1708: invokestatic 765	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   1711: invokevirtual 768	com/tencent/mfsdk/MagnifierSDK:a	()Ladkw;
    //   1714: invokeinterface 772 1 0
    //   1719: astore 11
    //   1721: invokestatic 777	bhlo:a	()[J
    //   1724: astore 12
    //   1726: aload 13
    //   1728: invokestatic 780	bhlo:l	()Ljava/lang/String;
    //   1731: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: ldc 228
    //   1736: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 11
    //   1742: astore 10
    //   1744: aload 11
    //   1746: ifnonnull +8 -> 1754
    //   1749: ldc_w 782
    //   1752: astore 10
    //   1754: aload 13
    //   1756: aload 10
    //   1758: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: ldc 228
    //   1763: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: pop
    //   1767: aload 13
    //   1769: ldc_w 784
    //   1772: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: aload 12
    //   1777: iconst_0
    //   1778: laload
    //   1779: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1782: ldc_w 786
    //   1785: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload 12
    //   1790: iconst_1
    //   1791: laload
    //   1792: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1795: ldc_w 788
    //   1798: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: pop
    //   1802: aload_0
    //   1803: getfield 12	bdmd:a	Lbdmc;
    //   1806: invokestatic 791	bdmc:a	(Lbdmc;)Ljava/lang/String;
    //   1809: ifnonnull +1066 -> 2875
    //   1812: ldc_w 782
    //   1815: astore 10
    //   1817: aload 13
    //   1819: aload 10
    //   1821: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc 228
    //   1826: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload 13
    //   1832: new 19	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   1839: ldc_w 793
    //   1842: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: getstatic 798	mqq/app/Foreground:sCountResume	I
    //   1848: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1851: ldc 228
    //   1853: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1859: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: pop
    //   1863: aload 13
    //   1865: ldc_w 800
    //   1868: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: getstatic 803	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1874: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1877: ldc 228
    //   1879: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: pop
    //   1883: getstatic 807	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1886: astore 10
    //   1888: aload 10
    //   1890: instanceof 802
    //   1893: ifeq +32 -> 1925
    //   1896: aload 10
    //   1898: checkcast 802	com/tencent/mobileqq/activity/SplashActivity
    //   1901: astore 10
    //   1903: aload 13
    //   1905: ldc_w 809
    //   1908: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: aload 10
    //   1913: invokevirtual 810	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1916: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1919: ldc 228
    //   1921: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: pop
    //   1925: getstatic 813	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1928: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1931: ifne +23 -> 1954
    //   1934: aload 13
    //   1936: ldc_w 815
    //   1939: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: getstatic 813	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1945: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc 228
    //   1950: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: getstatic 818	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1957: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1960: ifne +23 -> 1983
    //   1963: aload 13
    //   1965: ldc_w 820
    //   1968: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: getstatic 818	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1974: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: ldc 228
    //   1979: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: pop
    //   1983: getstatic 823	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1986: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1989: ifne +23 -> 2012
    //   1992: aload 13
    //   1994: ldc_w 825
    //   1997: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: getstatic 823	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2003: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: ldc 228
    //   2008: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: aload 13
    //   2014: new 19	java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2021: ldc_w 827
    //   2024: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: invokestatic 833	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2030: ldc_w 835
    //   2033: ldc_w 837
    //   2036: iconst_1
    //   2037: invokevirtual 841	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   2040: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2043: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2046: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: new 19	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2056: ldc_w 843
    //   2059: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: invokestatic 833	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2065: ldc_w 835
    //   2068: ldc_w 845
    //   2071: iconst_0
    //   2072: invokevirtual 848	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2075: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2078: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2081: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: new 19	java/lang/StringBuilder
    //   2087: dup
    //   2088: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2091: ldc_w 850
    //   2094: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: invokestatic 833	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2100: ldc_w 835
    //   2103: ldc_w 852
    //   2106: iconst_0
    //   2107: invokevirtual 848	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2110: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2113: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2116: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: ldc 228
    //   2121: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: pop
    //   2125: invokestatic 853	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2128: invokestatic 858	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   2131: invokevirtual 861	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   2134: astore 10
    //   2136: aload 10
    //   2138: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2141: ifne +11 -> 2152
    //   2144: aload 13
    //   2146: aload 10
    //   2148: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: pop
    //   2152: aload 13
    //   2154: aload_0
    //   2155: getfield 12	bdmd:a	Lbdmc;
    //   2158: invokestatic 864	bdmc:b	(Lbdmc;)Ljava/lang/StringBuilder;
    //   2161: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2164: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: pop
    //   2168: aload 13
    //   2170: aload_0
    //   2171: getfield 12	bdmd:a	Lbdmc;
    //   2174: invokestatic 866	bdmc:a	(Lbdmc;)Ljava/lang/StringBuilder;
    //   2177: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2180: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: pop
    //   2184: getstatic 869	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2187: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2190: ifne +51 -> 2241
    //   2193: getstatic 874	android/os/Build$VERSION:SDK_INT	I
    //   2196: bipush 8
    //   2198: if_icmplt +43 -> 2241
    //   2201: aload 13
    //   2203: new 19	java/lang/StringBuilder
    //   2206: dup
    //   2207: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2210: ldc_w 876
    //   2213: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: getstatic 869	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2219: invokevirtual 880	java/lang/String:getBytes	()[B
    //   2222: iconst_0
    //   2223: invokestatic 886	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2226: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: ldc 228
    //   2231: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2237: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: pop
    //   2241: aload 13
    //   2243: invokestatic 891	bmwa:a	()Lbmwa;
    //   2246: invokevirtual 892	bmwa:a	()Ljava/lang/String;
    //   2249: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: pop
    //   2253: aload 13
    //   2255: ldc 228
    //   2257: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: pop
    //   2261: aload_0
    //   2262: getfield 12	bdmd:a	Lbdmc;
    //   2265: invokestatic 895	bdmc:a	(Lbdmc;)Ljava/util/LinkedList;
    //   2268: invokevirtual 896	java/util/LinkedList:size	()I
    //   2271: ifle +30 -> 2301
    //   2274: aload 13
    //   2276: aload_0
    //   2277: getfield 12	bdmd:a	Lbdmc;
    //   2280: invokestatic 895	bdmc:a	(Lbdmc;)Ljava/util/LinkedList;
    //   2283: invokevirtual 899	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   2286: checkcast 901	bdmf
    //   2289: invokevirtual 902	bdmf:toString	()Ljava/lang/String;
    //   2292: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: pop
    //   2296: goto -35 -> 2261
    //   2299: astore 10
    //   2301: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   2304: invokestatic 908	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2307: istore 5
    //   2309: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   2312: invokestatic 913	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2315: istore 8
    //   2317: aload 13
    //   2319: bipush 10
    //   2321: invokevirtual 916	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2324: ldc_w 918
    //   2327: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: astore 11
    //   2332: iload 8
    //   2334: ifne +553 -> 2887
    //   2337: ldc_w 920
    //   2340: astore 10
    //   2342: aload 11
    //   2344: aload 10
    //   2346: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2349: ldc_w 922
    //   2352: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: iload 5
    //   2357: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: ldc_w 924
    //   2363: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: iload 8
    //   2368: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2371: pop
    //   2372: aload 13
    //   2374: ldc_w 926
    //   2377: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   2383: invokestatic 929	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2386: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2389: pop
    //   2390: aload 13
    //   2392: ldc_w 931
    //   2395: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
    //   2401: new 291	java/util/Date
    //   2404: dup
    //   2405: getstatic 933	abiz:jdField_a_of_type_Long	J
    //   2408: invokespecial 294	java/util/Date:<init>	(J)V
    //   2411: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2414: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: aload 13
    //   2420: ldc_w 935
    //   2423: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
    //   2429: new 291	java/util/Date
    //   2432: dup
    //   2433: getstatic 936	abiz:jdField_b_of_type_Long	J
    //   2436: invokespecial 294	java/util/Date:<init>	(J)V
    //   2439: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2442: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: ldc 228
    //   2447: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2450: pop
    //   2451: iload_1
    //   2452: ifeq +103 -> 2555
    //   2455: aload 14
    //   2457: ldc_w 576
    //   2460: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2463: ifne +25 -> 2488
    //   2466: aload 14
    //   2468: ldc_w 578
    //   2471: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2474: ifne +14 -> 2488
    //   2477: aload 14
    //   2479: ldc_w 369
    //   2482: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2485: ifeq +70 -> 2555
    //   2488: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   2491: ldc 198
    //   2493: iconst_4
    //   2494: invokevirtual 940	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2497: ldc_w 942
    //   2500: aconst_null
    //   2501: invokeinterface 947 3 0
    //   2506: astore 10
    //   2508: aload 13
    //   2510: ldc_w 949
    //   2513: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: aload 10
    //   2518: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: pop
    //   2522: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2525: ifeq +30 -> 2555
    //   2528: ldc 198
    //   2530: iconst_2
    //   2531: new 19	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 951
    //   2541: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload 10
    //   2546: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2552: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2555: aload 14
    //   2557: ldc_w 953
    //   2560: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2563: ifne +80 -> 2643
    //   2566: aload 14
    //   2568: ldc_w 955
    //   2571: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2574: ifne +69 -> 2643
    //   2577: aload 14
    //   2579: ldc_w 957
    //   2582: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2585: ifne +58 -> 2643
    //   2588: aload 14
    //   2590: ldc_w 959
    //   2593: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2596: ifne +47 -> 2643
    //   2599: aload 14
    //   2601: ldc_w 961
    //   2604: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2607: ifne +36 -> 2643
    //   2610: aload 14
    //   2612: ldc_w 963
    //   2615: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2618: ifne +25 -> 2643
    //   2621: aload 14
    //   2623: ldc_w 965
    //   2626: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2629: ifne +14 -> 2643
    //   2632: aload 14
    //   2634: ldc_w 967
    //   2637: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2640: ifeq +60 -> 2700
    //   2643: invokestatic 970	bmzm:a	()Ljava/lang/String;
    //   2646: astore 10
    //   2648: aload 10
    //   2650: ifnull +50 -> 2700
    //   2653: aload 13
    //   2655: ldc_w 972
    //   2658: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: aload 10
    //   2663: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2666: pop
    //   2667: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2670: ifeq +30 -> 2700
    //   2673: ldc 198
    //   2675: iconst_2
    //   2676: new 19	java/lang/StringBuilder
    //   2679: dup
    //   2680: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   2683: ldc_w 974
    //   2686: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: aload 10
    //   2691: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2697: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2700: aload 13
    //   2702: ldc_w 976
    //   2705: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2708: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2711: getfield 983	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2714: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: pop
    //   2718: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2721: getfield 987	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2724: ifnull +193 -> 2917
    //   2727: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2730: getfield 987	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2733: invokeinterface 991 1 0
    //   2738: ifne +179 -> 2917
    //   2741: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2744: getfield 987	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2747: invokeinterface 992 1 0
    //   2752: astore 10
    //   2754: aload 10
    //   2756: invokeinterface 121 1 0
    //   2761: ifeq +156 -> 2917
    //   2764: aload 10
    //   2766: invokeinterface 125 1 0
    //   2771: checkcast 994	android/util/Pair
    //   2774: astore 11
    //   2776: aload 11
    //   2778: ifnull -24 -> 2754
    //   2781: aload 13
    //   2783: ldc_w 996
    //   2786: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2789: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
    //   2792: new 291	java/util/Date
    //   2795: dup
    //   2796: aload 11
    //   2798: getfield 999	android/util/Pair:first	Ljava/lang/Object;
    //   2801: checkcast 1001	java/lang/Long
    //   2804: invokevirtual 1004	java/lang/Long:longValue	()J
    //   2807: invokespecial 294	java/util/Date:<init>	(J)V
    //   2810: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2813: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: ldc_w 1006
    //   2819: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2822: aload 11
    //   2824: getfield 1009	android/util/Pair:second	Ljava/lang/Object;
    //   2827: checkcast 224	java/lang/String
    //   2830: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: pop
    //   2834: goto -80 -> 2754
    //   2837: astore 10
    //   2839: aconst_null
    //   2840: astore 10
    //   2842: aload 10
    //   2844: ifnull -1136 -> 1708
    //   2847: aload 10
    //   2849: invokevirtual 760	java/io/BufferedReader:close	()V
    //   2852: goto -1144 -> 1708
    //   2855: astore 10
    //   2857: goto -1149 -> 1708
    //   2860: astore 10
    //   2862: aload 11
    //   2864: ifnull +8 -> 2872
    //   2867: aload 11
    //   2869: invokevirtual 760	java/io/BufferedReader:close	()V
    //   2872: aload 10
    //   2874: athrow
    //   2875: aload_0
    //   2876: getfield 12	bdmd:a	Lbdmc;
    //   2879: invokestatic 791	bdmc:a	(Lbdmc;)Ljava/lang/String;
    //   2882: astore 10
    //   2884: goto -1067 -> 1817
    //   2887: ldc_w 1011
    //   2890: astore 10
    //   2892: goto -550 -> 2342
    //   2895: astore 10
    //   2897: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2900: ifeq -200 -> 2700
    //   2903: ldc 198
    //   2905: iconst_2
    //   2906: ldc_w 1013
    //   2909: aload 10
    //   2911: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2914: goto -214 -> 2700
    //   2917: getstatic 1016	bkeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2920: astore 10
    //   2922: aload 10
    //   2924: ifnull +25 -> 2949
    //   2927: aload 10
    //   2929: invokevirtual 1019	java/lang/String:length	()I
    //   2932: ifle +17 -> 2949
    //   2935: aload 13
    //   2937: ldc_w 1021
    //   2940: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: aload 10
    //   2945: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2948: pop
    //   2949: aload_2
    //   2950: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2953: ifne +49 -> 3002
    //   2956: aload_2
    //   2957: ldc_w 1023
    //   2960: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2963: ifeq +39 -> 3002
    //   2966: aload 4
    //   2968: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2971: ifne +31 -> 3002
    //   2974: aload 4
    //   2976: ldc_w 1025
    //   2979: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2982: ifeq +20 -> 3002
    //   2985: aload 13
    //   2987: ldc_w 1027
    //   2990: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2993: pop
    //   2994: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2997: aload 13
    //   2999: invokestatic 1030	bdmc:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   3002: ldc_w 1032
    //   3005: aload_2
    //   3006: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3009: ifeq +22 -> 3031
    //   3012: aload 4
    //   3014: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3017: ifne +14 -> 3031
    //   3020: aload 4
    //   3022: ldc_w 1034
    //   3025: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3028: ifne +32 -> 3060
    //   3031: ldc_w 1036
    //   3034: aload_2
    //   3035: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3038: ifeq +40 -> 3078
    //   3041: aload 4
    //   3043: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3046: ifne +32 -> 3078
    //   3049: aload 4
    //   3051: ldc_w 1038
    //   3054: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3057: ifeq +21 -> 3078
    //   3060: aload 13
    //   3062: ldc_w 1040
    //   3065: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3068: ldc_w 1042
    //   3071: invokestatic 1045	bhjr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3074: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3077: pop
    //   3078: ldc_w 1047
    //   3081: aload_2
    //   3082: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3085: ifne +66 -> 3151
    //   3088: ldc_w 354
    //   3091: aload_2
    //   3092: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3095: ifeq +14 -> 3109
    //   3098: aload 4
    //   3100: ldc_w 1049
    //   3103: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3106: ifne +45 -> 3151
    //   3109: ldc_w 1051
    //   3112: aload_2
    //   3113: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3116: ifeq +14 -> 3130
    //   3119: aload 4
    //   3121: ldc_w 1053
    //   3124: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3127: ifne +24 -> 3151
    //   3130: ldc_w 354
    //   3133: aload_2
    //   3134: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3137: ifeq +94 -> 3231
    //   3140: aload 4
    //   3142: ldc_w 1055
    //   3145: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3148: ifeq +83 -> 3231
    //   3151: invokestatic 289	bdmc:a	()Ljava/text/SimpleDateFormat;
    //   3154: new 291	java/util/Date
    //   3157: dup
    //   3158: getstatic 1056	bdmc:jdField_a_of_type_Long	J
    //   3161: invokespecial 294	java/util/Date:<init>	(J)V
    //   3164: invokevirtual 300	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3167: astore 4
    //   3169: aload 13
    //   3171: ldc_w 1058
    //   3174: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: getstatic 1059	bdmc:jdField_a_of_type_Int	I
    //   3180: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3183: ldc_w 1061
    //   3186: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3189: aload 4
    //   3191: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3194: pop
    //   3195: aload 13
    //   3197: ldc_w 1063
    //   3200: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: pop
    //   3204: aload 13
    //   3206: invokestatic 1065	bdmc:c	()Ljava/lang/String;
    //   3209: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3212: pop
    //   3213: aload 13
    //   3215: ldc_w 1067
    //   3218: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3221: pop
    //   3222: aload 13
    //   3224: invokestatic 1072	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3227: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3230: pop
    //   3231: iconst_1
    //   3232: getstatic 310	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3235: if_icmpne +49 -> 3284
    //   3238: aload_3
    //   3239: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3242: ifne +42 -> 3284
    //   3245: aload_2
    //   3246: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3249: ifne +35 -> 3284
    //   3252: aload_2
    //   3253: ldc_w 1074
    //   3256: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3259: ifeq +25 -> 3284
    //   3262: aload_3
    //   3263: ldc_w 1076
    //   3266: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3269: ifeq +15 -> 3284
    //   3272: aload_0
    //   3273: aload 13
    //   3275: invokespecial 1078	bdmd:b	(Ljava/lang/StringBuilder;)V
    //   3278: aload_0
    //   3279: aload 13
    //   3281: invokespecial 1079	bdmd:a	(Ljava/lang/StringBuilder;)V
    //   3284: aload 13
    //   3286: new 19	java/lang/StringBuilder
    //   3289: dup
    //   3290: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   3293: ldc_w 1081
    //   3296: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3299: invokestatic 853	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3302: ldc_w 1083
    //   3305: invokestatic 1088	bhny:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3308: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: pop
    //   3318: ldc 198
    //   3320: iconst_1
    //   3321: new 19	java/lang/StringBuilder
    //   3324: dup
    //   3325: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   3328: ldc_w 1090
    //   3331: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: aload 13
    //   3336: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3339: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3348: aload 13
    //   3350: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3353: areturn
    //   3354: astore_2
    //   3355: aload 13
    //   3357: ldc_w 1092
    //   3360: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3363: pop
    //   3364: goto -46 -> 3318
    //   3367: astore 10
    //   3369: goto -2425 -> 944
    //   3372: astore_3
    //   3373: goto -1691 -> 1682
    //   3376: astore 10
    //   3378: goto -1670 -> 1708
    //   3381: astore 11
    //   3383: goto -511 -> 2872
    //   3386: astore 10
    //   3388: goto -310 -> 3078
    //   3391: astore 10
    //   3393: goto -444 -> 2949
    //   3396: astore 10
    //   3398: goto -947 -> 2451
    //   3401: astore 10
    //   3403: goto -1013 -> 2390
    //   3406: astore 12
    //   3408: aload 10
    //   3410: astore 11
    //   3412: aload 12
    //   3414: astore 10
    //   3416: goto -554 -> 2862
    //   3419: astore 11
    //   3421: goto -579 -> 2842
    //   3424: astore_2
    //   3425: aload 10
    //   3427: astore_3
    //   3428: goto -1754 -> 1674
    //   3431: astore_2
    //   3432: aload 10
    //   3434: astore_3
    //   3435: goto -1761 -> 1674
    //   3438: astore 11
    //   3440: goto -1792 -> 1648
    //   3443: astore 10
    //   3445: goto -1184 -> 2261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3448	0	this	bdmd
    //   0	3448	1	paramBoolean	boolean
    //   0	3448	2	paramString1	String
    //   0	3448	3	paramString2	String
    //   0	3448	4	paramString3	String
    //   0	3448	5	paramInt	int
    //   0	3448	6	paramLong	long
    //   2315	52	8	i	int
    //   1186	500	9	bool	boolean
    //   360	1264	10	localObject1	Object
    //   1628	3	10	localThrowable1	Throwable
    //   1642	17	10	localObject2	Object
    //   1666	38	10	localException1	java.lang.Exception
    //   1742	405	10	localObject3	Object
    //   2299	1	10	localThrowable2	Throwable
    //   2340	425	10	localObject4	Object
    //   2837	1	10	localThrowable3	Throwable
    //   2840	8	10	localObject5	Object
    //   2855	1	10	localThrowable4	Throwable
    //   2860	13	10	localObject6	Object
    //   2882	9	10	str1	String
    //   2895	15	10	localThrowable5	Throwable
    //   2920	24	10	str2	String
    //   3367	1	10	localException2	java.lang.Exception
    //   3376	1	10	localThrowable6	Throwable
    //   3386	1	10	localThrowable7	Throwable
    //   3391	1	10	localThrowable8	Throwable
    //   3396	1	10	localThrowable9	Throwable
    //   3401	8	10	localThrowable10	Throwable
    //   3414	19	10	localObject7	Object
    //   3443	1	10	localThrowable11	Throwable
    //   351	2517	11	localObject8	Object
    //   3381	1	11	localThrowable12	Throwable
    //   3410	1	11	localObject9	Object
    //   3419	1	11	localThrowable13	Throwable
    //   3438	1	11	localException3	java.lang.Exception
    //   1638	7	12	localException4	java.lang.Exception
    //   1724	65	12	arrayOfLong	long[]
    //   3406	7	12	localObject10	Object
    //   1056	2300	13	localStringBuilder	StringBuilder
    //   998	1635	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   672	752	1628	java/lang/Throwable
    //   757	797	1628	java/lang/Throwable
    //   800	812	1638	java/lang/Exception
    //   817	831	1638	java/lang/Exception
    //   831	867	1638	java/lang/Exception
    //   1658	1663	1666	java/lang/Exception
    //   800	812	1671	finally
    //   817	831	1671	finally
    //   831	867	1671	finally
    //   2261	2296	2299	java/lang/Throwable
    //   1509	1528	2837	java/lang/Throwable
    //   2847	2852	2855	java/lang/Throwable
    //   1509	1528	2860	finally
    //   2555	2643	2895	java/lang/Throwable
    //   2643	2648	2895	java/lang/Throwable
    //   2653	2700	2895	java/lang/Throwable
    //   3284	3318	3354	java/lang/Throwable
    //   939	944	3367	java/lang/Exception
    //   1678	1682	3372	java/lang/Exception
    //   1703	1708	3376	java/lang/Throwable
    //   2867	2872	3381	java/lang/Throwable
    //   2949	3002	3386	java/lang/Throwable
    //   3002	3031	3386	java/lang/Throwable
    //   3031	3060	3386	java/lang/Throwable
    //   3060	3078	3386	java/lang/Throwable
    //   2917	2922	3391	java/lang/Throwable
    //   2927	2949	3391	java/lang/Throwable
    //   2390	2451	3396	java/lang/Throwable
    //   2301	2332	3401	java/lang/Throwable
    //   2342	2390	3401	java/lang/Throwable
    //   1528	1543	3406	finally
    //   1548	1570	3406	finally
    //   1570	1602	3406	finally
    //   1602	1609	3406	finally
    //   1690	1698	3406	finally
    //   1528	1543	3419	java/lang/Throwable
    //   1548	1570	3419	java/lang/Throwable
    //   1570	1602	3419	java/lang/Throwable
    //   1602	1609	3419	java/lang/Throwable
    //   1690	1698	3419	java/lang/Throwable
    //   867	934	3424	finally
    //   1648	1653	3431	finally
    //   867	934	3438	java/lang/Exception
    //   1058	1172	3443	java/lang/Throwable
    //   1177	1185	3443	java/lang/Throwable
    //   1188	1362	3443	java/lang/Throwable
    //   1362	1420	3443	java/lang/Throwable
    //   1420	1440	3443	java/lang/Throwable
    //   1445	1498	3443	java/lang/Throwable
    //   1498	1506	3443	java/lang/Throwable
    //   1708	1740	3443	java/lang/Throwable
    //   1754	1812	3443	java/lang/Throwable
    //   1817	1925	3443	java/lang/Throwable
    //   1925	1954	3443	java/lang/Throwable
    //   1954	1983	3443	java/lang/Throwable
    //   1983	2012	3443	java/lang/Throwable
    //   2012	2152	3443	java/lang/Throwable
    //   2152	2241	3443	java/lang/Throwable
    //   2241	2261	3443	java/lang/Throwable
    //   2872	2875	3443	java/lang/Throwable
    //   2875	2884	3443	java/lang/Throwable
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 198
    //   2: iconst_1
    //   3: new 19	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 1096
    //   10: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 1098
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 1100	bdmc:b	()Z
    //   26: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 1100	bdmc:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 1102	bdmc:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   55: ldc 198
    //   57: iconst_4
    //   58: invokevirtual 940	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 1106 1 0
    //   66: ldc_w 1108
    //   69: iconst_1
    //   70: invokeinterface 1114 3 0
    //   75: invokeinterface 1117 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 1118	bdmc:a	()Ljava/lang/String;
    //   88: invokestatic 1119	bdmc:b	()Ljava/lang/String;
    //   91: invokestatic 1122	bdmc:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 1125	bdmc:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 367	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	bdmd:a	Lbdmc;
    //   111: invokestatic 1127	bdmc:a	(Lbdmc;)V
    //   114: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 1130	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	bdmd:a	Lbdmc;
    //   124: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 1133	bdmc:a	(Lbdmc;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 1135
    //   135: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +30 -> 168
    //   141: aload_0
    //   142: getfield 12	bdmd:a	Lbdmc;
    //   145: invokevirtual 1136	bdmc:a	()V
    //   148: aload_0
    //   149: getfield 12	bdmd:a	Lbdmc;
    //   152: invokevirtual 1137	bdmc:b	()V
    //   155: aload_0
    //   156: getfield 12	bdmd:a	Lbdmc;
    //   159: invokestatic 1118	bdmc:a	()Ljava/lang/String;
    //   162: invokestatic 1119	bdmc:b	()Ljava/lang/String;
    //   165: invokevirtual 1140	bdmc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: ldc_w 576
    //   172: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   175: ifne +23 -> 198
    //   178: aload_3
    //   179: ldc_w 369
    //   182: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +13 -> 198
    //   188: aload_3
    //   189: ldc_w 1142
    //   192: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   195: ifeq +18 -> 213
    //   198: aload_0
    //   199: getfield 12	bdmd:a	Lbdmc;
    //   202: invokevirtual 1136	bdmc:a	()V
    //   205: aload_0
    //   206: getfield 12	bdmd:a	Lbdmc;
    //   209: aload_3
    //   210: invokevirtual 1144	bdmc:b	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: ldc_w 576
    //   217: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   220: ifne +43 -> 263
    //   223: aload_3
    //   224: ldc_w 369
    //   227: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   230: ifne +33 -> 263
    //   233: aload_3
    //   234: ldc_w 1142
    //   237: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   240: ifne +23 -> 263
    //   243: aload_3
    //   244: ldc_w 1146
    //   247: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   250: ifne +13 -> 263
    //   253: aload_3
    //   254: ldc_w 578
    //   257: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   260: ifeq +88 -> 348
    //   263: ldc_w 1148
    //   266: iconst_0
    //   267: invokestatic 1154	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   270: ifeq +78 -> 348
    //   273: ldc 198
    //   275: iconst_1
    //   276: new 19	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 1156
    //   286: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   292: ldc2_w 1157
    //   295: ldiv
    //   296: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: new 19	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 1160
    //   315: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 12	bdmd:a	Lbdmc;
    //   322: getfield 407	bdmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   334: ldc2_w 1157
    //   337: ldiv
    //   338: invokestatic 1164	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   341: ldc_w 1148
    //   344: iconst_0
    //   345: invokestatic 1168	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   348: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   351: invokevirtual 1171	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   354: aload_3
    //   355: ldc_w 1135
    //   358: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +362 -> 723
    //   364: new 444	android/content/Intent
    //   367: dup
    //   368: ldc_w 1173
    //   371: invokespecial 1174	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   374: astore 4
    //   376: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   379: ldc_w 1176
    //   382: invokevirtual 1180	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: checkcast 1182	android/app/ActivityManager
    //   388: invokevirtual 1186	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   391: astore 6
    //   393: new 440	java/util/ArrayList
    //   396: dup
    //   397: invokespecial 1187	java/util/ArrayList:<init>	()V
    //   400: astore 5
    //   402: aload 6
    //   404: ifnull +282 -> 686
    //   407: aload 6
    //   409: invokeinterface 1188 1 0
    //   414: ifle +272 -> 686
    //   417: aload 6
    //   419: invokeinterface 115 1 0
    //   424: astore 6
    //   426: aload 6
    //   428: invokeinterface 121 1 0
    //   433: ifeq +253 -> 686
    //   436: aload 6
    //   438: invokeinterface 125 1 0
    //   443: checkcast 1190	android/app/ActivityManager$RunningAppProcessInfo
    //   446: getfield 1191	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   449: astore 7
    //   451: aload 7
    //   453: ifnull -27 -> 426
    //   456: aload 7
    //   458: ldc_w 1193
    //   461: invokevirtual 740	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   464: ifeq -38 -> 426
    //   467: aload 7
    //   469: ldc_w 1195
    //   472: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   475: ifne -49 -> 426
    //   478: aload 5
    //   480: aload 7
    //   482: invokevirtual 1198	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   485: pop
    //   486: goto -60 -> 426
    //   489: astore 4
    //   491: aload 4
    //   493: invokevirtual 758	java/lang/Throwable:printStackTrace	()V
    //   496: aload_3
    //   497: ldc_w 1135
    //   500: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +395 -> 898
    //   506: aload_0
    //   507: getfield 12	bdmd:a	Lbdmc;
    //   510: getfield 1200	bdmc:jdField_a_of_type_Boolean	Z
    //   513: ifeq +376 -> 889
    //   516: ldc 198
    //   518: iconst_1
    //   519: new 19	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1202
    //   529: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: getfield 12	bdmd:a	Lbdmc;
    //   536: getfield 1200	bdmc:jdField_a_of_type_Boolean	Z
    //   539: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: ldc_w 1204
    //   545: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   557: ldc_w 1176
    //   560: invokevirtual 1180	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   563: checkcast 1182	android/app/ActivityManager
    //   566: invokevirtual 1186	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   569: astore_3
    //   570: aload_3
    //   571: ifnull +260 -> 831
    //   574: aload_3
    //   575: invokeinterface 1188 1 0
    //   580: ifle +251 -> 831
    //   583: aload_3
    //   584: invokeinterface 115 1 0
    //   589: astore_3
    //   590: aload_3
    //   591: invokeinterface 121 1 0
    //   596: ifeq +235 -> 831
    //   599: aload_3
    //   600: invokeinterface 125 1 0
    //   605: checkcast 1190	android/app/ActivityManager$RunningAppProcessInfo
    //   608: astore 4
    //   610: aload 4
    //   612: getfield 1191	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   615: astore 5
    //   617: aload 5
    //   619: ifnull -29 -> 590
    //   622: aload 5
    //   624: ldc_w 1193
    //   627: invokevirtual 740	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   630: ifeq -40 -> 590
    //   633: aload 5
    //   635: ldc_w 1195
    //   638: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   641: ifne -51 -> 590
    //   644: aload 4
    //   646: getfield 1207	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   649: invokestatic 1212	android/os/Process:killProcess	(I)V
    //   652: goto -62 -> 590
    //   655: astore_3
    //   656: aload_3
    //   657: invokevirtual 758	java/lang/Throwable:printStackTrace	()V
    //   660: iconst_1
    //   661: ireturn
    //   662: astore 4
    //   664: aload 4
    //   666: invokevirtual 758	java/lang/Throwable:printStackTrace	()V
    //   669: goto -538 -> 131
    //   672: astore 4
    //   674: ldc 198
    //   676: iconst_1
    //   677: ldc_w 1214
    //   680: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: goto -335 -> 348
    //   686: aload 4
    //   688: ldc_w 1216
    //   691: aload 5
    //   693: invokevirtual 1220	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   696: pop
    //   697: aload 4
    //   699: ldc_w 1222
    //   702: aload 5
    //   704: iconst_0
    //   705: invokestatic 1226	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   708: invokevirtual 1230	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   711: pop
    //   712: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   715: aload 4
    //   717: invokevirtual 469	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   720: goto -224 -> 496
    //   723: aload_3
    //   724: ldc_w 576
    //   727: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   730: ifeq +72 -> 802
    //   733: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   736: ldc_w 1176
    //   739: invokevirtual 1180	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   742: checkcast 1182	android/app/ActivityManager
    //   745: invokevirtual 1186	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   748: invokeinterface 115 1 0
    //   753: astore 4
    //   755: aload 4
    //   757: invokeinterface 121 1 0
    //   762: ifeq -266 -> 496
    //   765: aload 4
    //   767: invokeinterface 125 1 0
    //   772: checkcast 1190	android/app/ActivityManager$RunningAppProcessInfo
    //   775: astore 5
    //   777: aload 5
    //   779: getfield 1191	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   782: ldc_w 1232
    //   785: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq -33 -> 755
    //   791: aload 5
    //   793: getfield 1207	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   796: invokestatic 1212	android/os/Process:killProcess	(I)V
    //   799: goto -44 -> 755
    //   802: aload_3
    //   803: ldc_w 1234
    //   806: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   809: ifne -313 -> 496
    //   812: aload_3
    //   813: ldc_w 1236
    //   816: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   819: ifeq -323 -> 496
    //   822: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   825: invokestatic 1241	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   828: goto -332 -> 496
    //   831: invokestatic 324	bdmc:a	()Landroid/content/Context;
    //   834: ldc_w 1243
    //   837: iconst_0
    //   838: invokevirtual 940	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   841: astore_3
    //   842: aload_3
    //   843: ldc_w 1245
    //   846: iconst_0
    //   847: invokeinterface 1249 3 0
    //   852: istore_2
    //   853: aload_3
    //   854: invokeinterface 1106 1 0
    //   859: ldc_w 1245
    //   862: iload_2
    //   863: iconst_1
    //   864: iadd
    //   865: invokeinterface 1253 3 0
    //   870: invokeinterface 1117 1 0
    //   875: pop
    //   876: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   879: iconst_1
    //   880: invokevirtual 1256	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   883: invokestatic 1259	android/os/Process:myPid	()I
    //   886: invokestatic 1212	android/os/Process:killProcess	(I)V
    //   889: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   892: iconst_1
    //   893: invokevirtual 1262	com/tencent/common/app/BaseApplicationImpl:qqProcessExit	(Z)V
    //   896: iconst_1
    //   897: ireturn
    //   898: aload_3
    //   899: ldc_w 576
    //   902: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   905: ifne +45 -> 950
    //   908: aload_3
    //   909: ldc_w 1264
    //   912: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   915: ifne +35 -> 950
    //   918: aload_3
    //   919: ldc_w 1234
    //   922: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   925: ifne +25 -> 950
    //   928: aload_3
    //   929: ldc_w 953
    //   932: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   935: ifeq +6 -> 941
    //   938: goto +12 -> 950
    //   941: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   944: iconst_0
    //   945: invokevirtual 1267	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   948: iconst_1
    //   949: ireturn
    //   950: iload_1
    //   951: ifeq -905 -> 46
    //   954: goto -13 -> 941
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	bdmd
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
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + bdmc.c() + ", sIsFinalizeTimeoutException=" + bdmc.b());
    if ((bdmc.c()) && (!bdmc.b()) && (!bdmc.a(bdmc.a(), bdmc.b()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + aodx.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = bdmc.a(this.a).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)bdmc.a(this.a).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            bdmc.b(true);
            break;
          }
        }
        bdmc.a(this.a).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(bdmc.a(this.a).toString());
        bdmc.a(this.a, localStringBuilder1.toString());
        bdmc.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
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
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + bdmc.a().format(new Date(paramLong)) + ", curTime=" + bdmc.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      bdmc.a(paramBoolean);
      if (!bdmc.b()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    bhhb.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdmd
 * JD-Core Version:    0.7.0.1
 */