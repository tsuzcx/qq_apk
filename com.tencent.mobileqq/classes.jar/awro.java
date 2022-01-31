import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

class awro
  implements CrashHandleListener
{
  awro(awrn paramawrn) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 30
    //   9: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16: ldc 39
    //   18: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 44
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 46
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 4
    //   41: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 48
    //   46: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 53
    //   56: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   62: new 60	java/util/Date
    //   65: dup
    //   66: lload 6
    //   68: invokespecial 63	java/util/Date:<init>	(J)V
    //   71: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 82	awrn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: pop
    //   88: aload 4
    //   90: invokestatic 85	awrn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: iconst_1
    //   95: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   98: if_icmpne +41 -> 139
    //   101: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   104: getstatic 100	awrn:jdField_b_of_type_Long	J
    //   107: lsub
    //   108: ldc2_w 101
    //   111: lcmp
    //   112: ifgt +27 -> 139
    //   115: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   118: new 28	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   125: aload_2
    //   126: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 111	xfs:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   139: getstatic 114	awrn:jdField_a_of_type_Awru	Lawru;
    //   142: ifnull +41 -> 183
    //   145: iload_1
    //   146: ifne +37 -> 183
    //   149: ldc 116
    //   151: aload_2
    //   152: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +28 -> 183
    //   158: aload_3
    //   159: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +21 -> 183
    //   165: aload_3
    //   166: ldc 130
    //   168: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   171: ifeq +12 -> 183
    //   174: getstatic 114	awrn:jdField_a_of_type_Awru	Lawru;
    //   177: aload_2
    //   178: invokeinterface 137 2 0
    //   183: getstatic 141	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   186: ldc 143
    //   188: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   191: ifeq +30 -> 221
    //   194: new 28	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   201: ldc 149
    //   203: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 4
    //   212: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 152	agwg:a	(Ljava/lang/String;)V
    //   221: aload 4
    //   223: ifnull +16 -> 239
    //   226: aload 4
    //   228: ldc 154
    //   230: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +6 -> 239
    //   236: invokestatic 158	awtl:b	()V
    //   239: iload_1
    //   240: aload_2
    //   241: aload 4
    //   243: invokestatic 163	aiyt:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   246: aload 4
    //   248: ifnull +96 -> 344
    //   251: aload 4
    //   253: ldc 165
    //   255: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   258: ifne +13 -> 271
    //   261: aload 4
    //   263: ldc 167
    //   265: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +76 -> 344
    //   271: new 169	java/util/HashMap
    //   274: dup
    //   275: invokespecial 170	java/util/HashMap:<init>	()V
    //   278: astore 11
    //   280: iload_1
    //   281: ifeq +1968 -> 2249
    //   284: ldc 172
    //   286: astore 10
    //   288: aload 11
    //   290: ldc 174
    //   292: aload 10
    //   294: invokevirtual 178	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: aload 11
    //   300: ldc 180
    //   302: aload_2
    //   303: invokevirtual 178	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: aload 11
    //   309: ldc 182
    //   311: getstatic 141	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   314: invokevirtual 178	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   317: pop
    //   318: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   321: invokestatic 185	awrn:a	(Landroid/content/Context;)Lawrn;
    //   324: aload_0
    //   325: getfield 12	awro:a	Lawrn;
    //   328: getfield 187	awrn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   331: ldc 189
    //   333: iconst_1
    //   334: lconst_0
    //   335: lconst_0
    //   336: aload 11
    //   338: ldc 191
    //   340: iconst_0
    //   341: invokevirtual 194	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   344: iload_1
    //   345: aload_2
    //   346: aload_3
    //   347: aload 4
    //   349: iload 5
    //   351: lload 6
    //   353: invokestatic 199	besi:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   356: getstatic 205	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   359: ldc 207
    //   361: invokevirtual 211	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   364: ifeq +54 -> 418
    //   367: new 213	android/content/Intent
    //   370: dup
    //   371: invokespecial 214	android/content/Intent:<init>	()V
    //   374: astore 10
    //   376: aload 10
    //   378: ldc 216
    //   380: invokevirtual 220	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   383: pop
    //   384: aload 10
    //   386: invokestatic 226	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   389: invokevirtual 229	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   392: invokevirtual 232	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   395: pop
    //   396: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   399: aload 10
    //   401: invokevirtual 238	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   404: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +11 -> 418
    //   410: ldc 26
    //   412: iconst_2
    //   413: ldc 244
    //   415: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: getstatic 141	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   421: ldc 246
    //   423: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   426: ifeq +30 -> 456
    //   429: new 28	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   436: ldc 149
    //   438: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_2
    //   442: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 4
    //   447: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 251	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   456: aload 4
    //   458: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifne +135 -> 596
    //   464: aload 4
    //   466: ldc 253
    //   468: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   471: ifeq +125 -> 596
    //   474: new 255	org/json/JSONObject
    //   477: dup
    //   478: invokespecial 256	org/json/JSONObject:<init>	()V
    //   481: astore 10
    //   483: aload 10
    //   485: ldc_w 258
    //   488: iload_1
    //   489: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   492: pop
    //   493: aload 10
    //   495: ldc_w 263
    //   498: aload_2
    //   499: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   502: pop
    //   503: aload 10
    //   505: ldc_w 268
    //   508: aload_3
    //   509: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   512: pop
    //   513: aload 10
    //   515: ldc_w 270
    //   518: aload 4
    //   520: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   523: pop
    //   524: aload 10
    //   526: ldc_w 272
    //   529: iload 5
    //   531: invokevirtual 275	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload 10
    //   537: ldc_w 277
    //   540: lload 6
    //   542: invokevirtual 280	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   545: pop
    //   546: getstatic 284	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   549: invokevirtual 288	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   552: astore_3
    //   553: aload_3
    //   554: ifnull +42 -> 596
    //   557: aload_3
    //   558: ldc_w 290
    //   561: invokevirtual 296	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   564: ldc_w 297
    //   567: iconst_1
    //   568: anewarray 299	java/lang/Class
    //   571: dup
    //   572: iconst_0
    //   573: ldc 118
    //   575: aastore
    //   576: invokevirtual 303	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   579: aconst_null
    //   580: iconst_1
    //   581: anewarray 4	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload 10
    //   588: invokevirtual 304	org/json/JSONObject:toString	()Ljava/lang/String;
    //   591: aastore
    //   592: invokevirtual 310	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   595: pop
    //   596: aconst_null
    //   597: astore 10
    //   599: new 312	java/io/File
    //   602: dup
    //   603: ldc_w 314
    //   606: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   609: astore_3
    //   610: aload_3
    //   611: ifnull +15 -> 626
    //   614: aload_3
    //   615: invokevirtual 318	java/io/File:exists	()Z
    //   618: ifne +8 -> 626
    //   621: aload_3
    //   622: invokevirtual 321	java/io/File:mkdirs	()Z
    //   625: pop
    //   626: new 323	java/io/FileWriter
    //   629: dup
    //   630: new 28	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   637: ldc_w 314
    //   640: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: lload 6
    //   645: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: ldc_w 328
    //   651: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokespecial 329	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   660: astore_3
    //   661: new 28	java/lang/StringBuilder
    //   664: dup
    //   665: sipush 128
    //   668: invokespecial 332	java/lang/StringBuilder:<init>	(I)V
    //   671: astore 10
    //   673: aload 10
    //   675: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   678: new 60	java/util/Date
    //   681: dup
    //   682: lload 6
    //   684: invokespecial 63	java/util/Date:<init>	(J)V
    //   687: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   690: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 334
    //   696: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_2
    //   700: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: ldc_w 334
    //   706: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 4
    //   711: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_3
    //   716: aload 10
    //   718: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokevirtual 337	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   724: aload_3
    //   725: invokevirtual 340	java/io/FileWriter:flush	()V
    //   728: aload_3
    //   729: ifnull +7 -> 736
    //   732: aload_3
    //   733: invokevirtual 343	java/io/FileWriter:close	()V
    //   736: aload_2
    //   737: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   740: ifne +47 -> 787
    //   743: aload_2
    //   744: ldc_w 345
    //   747: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   750: ifeq +37 -> 787
    //   753: invokestatic 350	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   756: invokevirtual 352	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   759: aload 4
    //   761: ldc_w 354
    //   764: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   767: ifne +20 -> 787
    //   770: aload 4
    //   772: ldc_w 356
    //   775: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   778: ifne +9 -> 787
    //   781: invokestatic 361	xfz:a	()Lxfz;
    //   784: invokevirtual 362	xfz:b	()V
    //   787: getstatic 141	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   790: astore 12
    //   792: iload_1
    //   793: ifeq +39 -> 832
    //   796: aload 12
    //   798: ldc_w 364
    //   801: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   804: ifne +14 -> 818
    //   807: aload 12
    //   809: ldc_w 366
    //   812: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   815: ifeq +17 -> 832
    //   818: ldc_w 368
    //   821: iconst_1
    //   822: aload 4
    //   824: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: aload 4
    //   829: invokestatic 376	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   832: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   835: invokestatic 381	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   838: new 28	java/lang/StringBuilder
    //   841: dup
    //   842: sipush 128
    //   845: invokespecial 332	java/lang/StringBuilder:<init>	(I)V
    //   848: astore 11
    //   850: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   853: ldc_w 383
    //   856: invokestatic 388	ytc:a	(Landroid/content/Context;Ljava/lang/String;)Lytb;
    //   859: astore_3
    //   860: aload 11
    //   862: ldc_w 390
    //   865: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 11
    //   871: ldc_w 392
    //   874: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 11
    //   880: ldc_w 394
    //   883: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: getstatic 397	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   889: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload 11
    //   895: ldc_w 399
    //   898: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: getstatic 402	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   904: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload 11
    //   910: ldc_w 404
    //   913: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: getstatic 407	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   919: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 11
    //   925: ldc_w 409
    //   928: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: getstatic 412	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   934: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload 11
    //   940: ldc_w 414
    //   943: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: getstatic 418	awoa:b	I
    //   949: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload 11
    //   955: ldc_w 420
    //   958: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: astore 10
    //   963: aload_3
    //   964: ifnull +1343 -> 2307
    //   967: aload_3
    //   968: invokevirtual 424	ytb:a	()Z
    //   971: ifeq +1336 -> 2307
    //   974: iconst_1
    //   975: istore 9
    //   977: aload 10
    //   979: iload 9
    //   981: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   984: ldc_w 426
    //   987: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: getstatic 430	yss:jdField_a_of_type_Int	I
    //   993: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   996: ldc_w 432
    //   999: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: getstatic 435	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1005: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1008: ldc_w 437
    //   1011: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: getstatic 438	yss:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1017: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 11
    //   1023: ldc_w 440
    //   1026: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1032: invokevirtual 449	java/lang/Runtime:maxMemory	()J
    //   1035: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1038: ldc_w 451
    //   1041: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1047: invokevirtual 454	java/lang/Runtime:totalMemory	()J
    //   1050: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1053: invokevirtual 457	java/lang/Runtime:freeMemory	()J
    //   1056: lsub
    //   1057: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload 11
    //   1063: ldc_w 459
    //   1066: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokestatic 350	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1072: invokevirtual 462	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   1075: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: ldc_w 464
    //   1081: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokestatic 350	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1087: invokevirtual 466	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   1090: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1093: ldc_w 468
    //   1096: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokestatic 350	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1102: invokevirtual 471	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   1105: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: aload 11
    //   1111: ldc_w 473
    //   1114: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokestatic 478	awri:a	()Lawri;
    //   1120: invokevirtual 480	awri:a	()Ljava/lang/String;
    //   1123: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: getstatic 484	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1130: ifnull +21 -> 1151
    //   1133: aload 11
    //   1135: ldc_w 486
    //   1138: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: getstatic 484	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1144: invokevirtual 491	android/support/v4/util/MQLruCache:size	()I
    //   1147: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1154: invokevirtual 449	java/lang/Runtime:maxMemory	()J
    //   1157: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1160: invokevirtual 454	java/lang/Runtime:totalMemory	()J
    //   1163: lsub
    //   1164: l2f
    //   1165: fconst_1
    //   1166: fmul
    //   1167: invokestatic 446	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1170: invokevirtual 449	java/lang/Runtime:maxMemory	()J
    //   1173: l2f
    //   1174: fdiv
    //   1175: f2d
    //   1176: ldc2_w 492
    //   1179: dcmpl
    //   1180: iflt +29 -> 1209
    //   1183: aload_2
    //   1184: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1187: ifne +22 -> 1209
    //   1190: aload_2
    //   1191: ldc_w 345
    //   1194: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1197: ifeq +12 -> 1209
    //   1200: aload_0
    //   1201: getfield 12	awro:a	Lawrn;
    //   1204: aload 11
    //   1206: invokevirtual 496	awrn:a	(Ljava/lang/StringBuilder;)V
    //   1209: aload 11
    //   1211: ldc_w 498
    //   1214: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: getstatic 503	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1220: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: getstatic 508	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1227: astore_3
    //   1228: aload_3
    //   1229: ifnull +52 -> 1281
    //   1232: aload_3
    //   1233: arraylength
    //   1234: iconst_3
    //   1235: if_icmplt +46 -> 1281
    //   1238: aload 11
    //   1240: ldc_w 510
    //   1243: iconst_3
    //   1244: anewarray 4	java/lang/Object
    //   1247: dup
    //   1248: iconst_0
    //   1249: aload_3
    //   1250: iconst_0
    //   1251: iaload
    //   1252: invokestatic 516	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1255: aastore
    //   1256: dup
    //   1257: iconst_1
    //   1258: aload_3
    //   1259: iconst_1
    //   1260: iaload
    //   1261: invokestatic 516	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1264: aastore
    //   1265: dup
    //   1266: iconst_2
    //   1267: aload_3
    //   1268: iconst_2
    //   1269: iaload
    //   1270: invokestatic 516	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1273: aastore
    //   1274: invokestatic 519	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1277: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 11
    //   1283: ldc_w 334
    //   1286: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: invokestatic 521	awrn:c	()Ljava/lang/String;
    //   1293: astore 10
    //   1295: invokestatic 526	babp:a	()[J
    //   1298: astore 13
    //   1300: aload 11
    //   1302: invokestatic 529	babp:l	()Ljava/lang/String;
    //   1305: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: ldc_w 334
    //   1311: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: aload 10
    //   1317: astore_3
    //   1318: aload 10
    //   1320: ifnonnull +7 -> 1327
    //   1323: ldc_w 531
    //   1326: astore_3
    //   1327: aload 11
    //   1329: aload_3
    //   1330: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 334
    //   1336: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: pop
    //   1340: aload 11
    //   1342: ldc_w 533
    //   1345: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload 13
    //   1350: iconst_0
    //   1351: laload
    //   1352: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1355: ldc_w 535
    //   1358: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload 13
    //   1363: iconst_1
    //   1364: laload
    //   1365: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1368: ldc_w 537
    //   1371: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: pop
    //   1375: aload_0
    //   1376: getfield 12	awro:a	Lawrn;
    //   1379: invokestatic 540	awrn:a	(Lawrn;)Ljava/lang/String;
    //   1382: ifnonnull +931 -> 2313
    //   1385: ldc_w 531
    //   1388: astore_3
    //   1389: aload 11
    //   1391: aload_3
    //   1392: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: ldc_w 334
    //   1398: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: aload 11
    //   1404: ldc_w 542
    //   1407: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: getstatic 545	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1413: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1416: ldc_w 334
    //   1419: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: pop
    //   1423: getstatic 549	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1426: astore_3
    //   1427: aload_3
    //   1428: instanceof 544
    //   1431: ifeq +30 -> 1461
    //   1434: aload_3
    //   1435: checkcast 544	com/tencent/mobileqq/activity/SplashActivity
    //   1438: astore_3
    //   1439: aload 11
    //   1441: ldc_w 551
    //   1444: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload_3
    //   1448: invokevirtual 552	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1451: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1454: ldc_w 334
    //   1457: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: getstatic 555	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1464: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1467: ifne +24 -> 1491
    //   1470: aload 11
    //   1472: ldc_w 557
    //   1475: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: getstatic 555	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1481: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: ldc_w 334
    //   1487: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: getstatic 560	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1494: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1497: ifne +24 -> 1521
    //   1500: aload 11
    //   1502: ldc_w 562
    //   1505: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: getstatic 560	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1511: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: ldc_w 334
    //   1517: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: getstatic 565	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1524: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1527: ifne +24 -> 1551
    //   1530: aload 11
    //   1532: ldc_w 567
    //   1535: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: getstatic 565	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1541: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: ldc_w 334
    //   1547: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: invokestatic 568	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1554: invokestatic 574	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   1557: invokevirtual 577	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   1560: astore_3
    //   1561: aload_3
    //   1562: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1565: ifne +10 -> 1575
    //   1568: aload 11
    //   1570: aload_3
    //   1571: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload 11
    //   1577: aload_0
    //   1578: getfield 12	awro:a	Lawrn;
    //   1581: invokestatic 580	awrn:b	(Lawrn;)Ljava/lang/StringBuilder;
    //   1584: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: pop
    //   1591: aload 11
    //   1593: aload_0
    //   1594: getfield 12	awro:a	Lawrn;
    //   1597: invokestatic 582	awrn:a	(Lawrn;)Ljava/lang/StringBuilder;
    //   1600: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1603: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: pop
    //   1607: getstatic 585	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1610: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1613: ifne +52 -> 1665
    //   1616: getstatic 590	android/os/Build$VERSION:SDK_INT	I
    //   1619: bipush 8
    //   1621: if_icmplt +44 -> 1665
    //   1624: aload 11
    //   1626: new 28	java/lang/StringBuilder
    //   1629: dup
    //   1630: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1633: ldc_w 592
    //   1636: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: getstatic 585	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1642: invokevirtual 596	java/lang/String:getBytes	()[B
    //   1645: iconst_0
    //   1646: invokestatic 602	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1649: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: ldc_w 334
    //   1655: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 11
    //   1667: invokestatic 607	bfsg:a	()Lbfsg;
    //   1670: invokevirtual 608	bfsg:a	()Ljava/lang/String;
    //   1673: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: pop
    //   1677: aload 11
    //   1679: ldc_w 334
    //   1682: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: pop
    //   1686: aload_0
    //   1687: getfield 12	awro:a	Lawrn;
    //   1690: invokestatic 611	awrn:a	(Lawrn;)Ljava/util/LinkedList;
    //   1693: invokevirtual 614	java/util/LinkedList:size	()I
    //   1696: ifle +29 -> 1725
    //   1699: aload 11
    //   1701: aload_0
    //   1702: getfield 12	awro:a	Lawrn;
    //   1705: invokestatic 611	awrn:a	(Lawrn;)Ljava/util/LinkedList;
    //   1708: invokevirtual 618	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1711: checkcast 620	awrp
    //   1714: invokevirtual 621	awrp:toString	()Ljava/lang/String;
    //   1717: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: pop
    //   1721: goto -35 -> 1686
    //   1724: astore_3
    //   1725: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   1728: invokestatic 627	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1731: istore 5
    //   1733: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   1736: invokestatic 632	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1739: istore 8
    //   1741: aload 11
    //   1743: bipush 10
    //   1745: invokevirtual 635	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1748: ldc_w 637
    //   1751: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: astore 10
    //   1756: iload 8
    //   1758: ifne +566 -> 2324
    //   1761: ldc_w 639
    //   1764: astore_3
    //   1765: aload 10
    //   1767: aload_3
    //   1768: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: ldc_w 641
    //   1774: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: iload 5
    //   1779: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1782: ldc_w 643
    //   1785: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: iload 8
    //   1790: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1793: pop
    //   1794: aload 11
    //   1796: ldc_w 645
    //   1799: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   1805: invokestatic 648	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1808: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: pop
    //   1812: aload 11
    //   1814: ldc_w 650
    //   1817: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   1823: new 60	java/util/Date
    //   1826: dup
    //   1827: getstatic 652	xfs:jdField_a_of_type_Long	J
    //   1830: invokespecial 63	java/util/Date:<init>	(J)V
    //   1833: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1836: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: pop
    //   1840: aload 11
    //   1842: ldc_w 654
    //   1845: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   1851: new 60	java/util/Date
    //   1854: dup
    //   1855: getstatic 655	xfs:jdField_b_of_type_Long	J
    //   1858: invokespecial 63	java/util/Date:<init>	(J)V
    //   1861: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1864: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: ldc_w 334
    //   1870: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: pop
    //   1874: iload_1
    //   1875: ifeq +99 -> 1974
    //   1878: aload 12
    //   1880: ldc_w 364
    //   1883: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1886: ifne +24 -> 1910
    //   1889: aload 12
    //   1891: ldc_w 366
    //   1894: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1897: ifne +13 -> 1910
    //   1900: aload 12
    //   1902: ldc 143
    //   1904: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1907: ifeq +67 -> 1974
    //   1910: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   1913: ldc 26
    //   1915: iconst_4
    //   1916: invokevirtual 659	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1919: ldc_w 661
    //   1922: aconst_null
    //   1923: invokeinterface 667 3 0
    //   1928: astore_3
    //   1929: aload 11
    //   1931: ldc_w 669
    //   1934: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: aload_3
    //   1938: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1945: ifeq +29 -> 1974
    //   1948: ldc 26
    //   1950: iconst_2
    //   1951: new 28	java/lang/StringBuilder
    //   1954: dup
    //   1955: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1958: ldc_w 671
    //   1961: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: aload_3
    //   1965: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1971: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1974: aload 12
    //   1976: ldc_w 673
    //   1979: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1982: ifne +80 -> 2062
    //   1985: aload 12
    //   1987: ldc_w 675
    //   1990: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1993: ifne +69 -> 2062
    //   1996: aload 12
    //   1998: ldc_w 677
    //   2001: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2004: ifne +58 -> 2062
    //   2007: aload 12
    //   2009: ldc_w 679
    //   2012: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2015: ifne +47 -> 2062
    //   2018: aload 12
    //   2020: ldc_w 681
    //   2023: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2026: ifne +36 -> 2062
    //   2029: aload 12
    //   2031: ldc_w 683
    //   2034: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2037: ifne +25 -> 2062
    //   2040: aload 12
    //   2042: ldc_w 685
    //   2045: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2048: ifne +14 -> 2062
    //   2051: aload 12
    //   2053: ldc_w 687
    //   2056: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2059: ifeq +56 -> 2115
    //   2062: invokestatic 690	bfvk:a	()Ljava/lang/String;
    //   2065: astore_3
    //   2066: aload_3
    //   2067: ifnull +48 -> 2115
    //   2070: aload 11
    //   2072: ldc_w 692
    //   2075: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: aload_3
    //   2079: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: pop
    //   2083: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2086: ifeq +29 -> 2115
    //   2089: ldc 26
    //   2091: iconst_2
    //   2092: new 28	java/lang/StringBuilder
    //   2095: dup
    //   2096: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2099: ldc_w 694
    //   2102: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: aload_3
    //   2106: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2112: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2115: aload 11
    //   2117: ldc_w 696
    //   2120: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2126: getfield 703	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2129: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: pop
    //   2133: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2136: getfield 707	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2139: ifnull +212 -> 2351
    //   2142: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2145: getfield 707	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2148: invokeinterface 711 1 0
    //   2153: ifne +198 -> 2351
    //   2156: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2159: getfield 707	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2162: invokeinterface 715 1 0
    //   2167: astore_3
    //   2168: aload_3
    //   2169: invokeinterface 720 1 0
    //   2174: ifeq +177 -> 2351
    //   2177: aload_3
    //   2178: invokeinterface 723 1 0
    //   2183: checkcast 725	android/util/Pair
    //   2186: astore 10
    //   2188: aload 10
    //   2190: ifnull -22 -> 2168
    //   2193: aload 11
    //   2195: ldc_w 727
    //   2198: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   2204: new 60	java/util/Date
    //   2207: dup
    //   2208: aload 10
    //   2210: getfield 731	android/util/Pair:first	Ljava/lang/Object;
    //   2213: checkcast 733	java/lang/Long
    //   2216: invokevirtual 736	java/lang/Long:longValue	()J
    //   2219: invokespecial 63	java/util/Date:<init>	(J)V
    //   2222: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2225: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: ldc_w 738
    //   2231: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: aload 10
    //   2236: getfield 741	android/util/Pair:second	Ljava/lang/Object;
    //   2239: checkcast 118	java/lang/String
    //   2242: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: pop
    //   2246: goto -78 -> 2168
    //   2249: ldc_w 743
    //   2252: astore 10
    //   2254: goto -1966 -> 288
    //   2257: astore_3
    //   2258: aload_3
    //   2259: invokevirtual 746	java/lang/Throwable:printStackTrace	()V
    //   2262: goto -1666 -> 596
    //   2265: astore 11
    //   2267: aload 10
    //   2269: astore_3
    //   2270: aload 11
    //   2272: astore 10
    //   2274: aload 10
    //   2276: invokevirtual 747	java/lang/Exception:printStackTrace	()V
    //   2279: aload_3
    //   2280: ifnull -1544 -> 736
    //   2283: aload_3
    //   2284: invokevirtual 343	java/io/FileWriter:close	()V
    //   2287: goto -1551 -> 736
    //   2290: astore_3
    //   2291: goto -1555 -> 736
    //   2294: astore_2
    //   2295: aconst_null
    //   2296: astore_3
    //   2297: aload_3
    //   2298: ifnull +7 -> 2305
    //   2301: aload_3
    //   2302: invokevirtual 343	java/io/FileWriter:close	()V
    //   2305: aload_2
    //   2306: athrow
    //   2307: iconst_0
    //   2308: istore 9
    //   2310: goto -1333 -> 977
    //   2313: aload_0
    //   2314: getfield 12	awro:a	Lawrn;
    //   2317: invokestatic 540	awrn:a	(Lawrn;)Ljava/lang/String;
    //   2320: astore_3
    //   2321: goto -932 -> 1389
    //   2324: ldc_w 749
    //   2327: astore_3
    //   2328: goto -563 -> 1765
    //   2331: astore_3
    //   2332: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2335: ifeq -220 -> 2115
    //   2338: ldc 26
    //   2340: iconst_2
    //   2341: ldc_w 751
    //   2344: aload_3
    //   2345: invokestatic 754	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2348: goto -233 -> 2115
    //   2351: getstatic 757	bcoe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2354: astore_3
    //   2355: aload_3
    //   2356: ifnull +23 -> 2379
    //   2359: aload_3
    //   2360: invokevirtual 760	java/lang/String:length	()I
    //   2363: ifle +16 -> 2379
    //   2366: aload 11
    //   2368: ldc_w 762
    //   2371: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2374: aload_3
    //   2375: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: pop
    //   2379: aload_2
    //   2380: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2383: ifne +49 -> 2432
    //   2386: aload_2
    //   2387: ldc_w 764
    //   2390: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2393: ifeq +39 -> 2432
    //   2396: aload 4
    //   2398: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2401: ifne +31 -> 2432
    //   2404: aload 4
    //   2406: ldc_w 766
    //   2409: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2412: ifeq +20 -> 2432
    //   2415: aload 11
    //   2417: ldc_w 768
    //   2420: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2423: pop
    //   2424: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2427: aload 11
    //   2429: invokestatic 771	awrn:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2432: ldc_w 773
    //   2435: aload_2
    //   2436: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2439: ifeq +22 -> 2461
    //   2442: aload 4
    //   2444: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2447: ifne +14 -> 2461
    //   2450: aload 4
    //   2452: ldc_w 775
    //   2455: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2458: ifne +32 -> 2490
    //   2461: ldc_w 777
    //   2464: aload_2
    //   2465: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2468: ifeq +40 -> 2508
    //   2471: aload 4
    //   2473: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2476: ifne +32 -> 2508
    //   2479: aload 4
    //   2481: ldc_w 779
    //   2484: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2487: ifeq +21 -> 2508
    //   2490: aload 11
    //   2492: ldc_w 781
    //   2495: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: ldc_w 783
    //   2501: invokestatic 786	azzu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2504: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2507: pop
    //   2508: ldc_w 788
    //   2511: aload_2
    //   2512: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2515: ifne +64 -> 2579
    //   2518: ldc 116
    //   2520: aload_2
    //   2521: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2524: ifeq +14 -> 2538
    //   2527: aload 4
    //   2529: ldc_w 790
    //   2532: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2535: ifne +44 -> 2579
    //   2538: ldc_w 792
    //   2541: aload_2
    //   2542: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2545: ifeq +14 -> 2559
    //   2548: aload 4
    //   2550: ldc_w 794
    //   2553: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2556: ifne +23 -> 2579
    //   2559: ldc 116
    //   2561: aload_2
    //   2562: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2565: ifeq +74 -> 2639
    //   2568: aload 4
    //   2570: ldc_w 796
    //   2573: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2576: ifeq +63 -> 2639
    //   2579: invokestatic 58	awrn:a	()Ljava/text/SimpleDateFormat;
    //   2582: new 60	java/util/Date
    //   2585: dup
    //   2586: getstatic 797	awrn:jdField_a_of_type_Long	J
    //   2589: invokespecial 63	java/util/Date:<init>	(J)V
    //   2592: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2595: astore_2
    //   2596: aload 11
    //   2598: ldc_w 799
    //   2601: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2604: getstatic 800	awrn:jdField_a_of_type_Int	I
    //   2607: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2610: ldc_w 802
    //   2613: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: aload_2
    //   2617: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: pop
    //   2621: aload 11
    //   2623: ldc_w 804
    //   2626: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: pop
    //   2630: aload 11
    //   2632: invokestatic 806	awrn:d	()Ljava/lang/String;
    //   2635: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: ldc 26
    //   2641: iconst_1
    //   2642: new 28	java/lang/StringBuilder
    //   2645: dup
    //   2646: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2649: ldc_w 808
    //   2652: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2655: aload 11
    //   2657: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2660: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2666: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2669: aload 11
    //   2671: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2674: areturn
    //   2675: astore_3
    //   2676: goto -1940 -> 736
    //   2679: astore_3
    //   2680: goto -375 -> 2305
    //   2683: astore_3
    //   2684: goto -176 -> 2508
    //   2687: astore_3
    //   2688: goto -309 -> 2379
    //   2691: astore_3
    //   2692: goto -818 -> 1874
    //   2695: astore_3
    //   2696: goto -884 -> 1812
    //   2699: astore_3
    //   2700: goto -1014 -> 1686
    //   2703: astore_2
    //   2704: goto -407 -> 2297
    //   2707: astore_2
    //   2708: goto -411 -> 2297
    //   2711: astore 10
    //   2713: goto -439 -> 2274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2716	0	this	awro
    //   0	2716	1	paramBoolean	boolean
    //   0	2716	2	paramString1	String
    //   0	2716	3	paramString2	String
    //   0	2716	4	paramString3	String
    //   0	2716	5	paramInt	int
    //   0	2716	6	paramLong	long
    //   1739	50	8	i	int
    //   975	1334	9	bool	boolean
    //   286	1989	10	localObject1	Object
    //   2711	1	10	localException1	java.lang.Exception
    //   278	1916	11	localObject2	Object
    //   2265	405	11	localException2	java.lang.Exception
    //   790	1262	12	str	String
    //   1298	64	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1686	1721	1724	java/lang/Throwable
    //   474	553	2257	java/lang/Throwable
    //   557	596	2257	java/lang/Throwable
    //   599	610	2265	java/lang/Exception
    //   614	626	2265	java/lang/Exception
    //   626	661	2265	java/lang/Exception
    //   2283	2287	2290	java/lang/Exception
    //   599	610	2294	finally
    //   614	626	2294	finally
    //   626	661	2294	finally
    //   1974	2062	2331	java/lang/Throwable
    //   2062	2066	2331	java/lang/Throwable
    //   2070	2115	2331	java/lang/Throwable
    //   732	736	2675	java/lang/Exception
    //   2301	2305	2679	java/lang/Exception
    //   2379	2432	2683	java/lang/Throwable
    //   2432	2461	2683	java/lang/Throwable
    //   2461	2490	2683	java/lang/Throwable
    //   2490	2508	2683	java/lang/Throwable
    //   2351	2355	2687	java/lang/Throwable
    //   2359	2379	2687	java/lang/Throwable
    //   1812	1874	2691	java/lang/Throwable
    //   1725	1756	2695	java/lang/Throwable
    //   1765	1812	2695	java/lang/Throwable
    //   850	963	2699	java/lang/Throwable
    //   967	974	2699	java/lang/Throwable
    //   977	1151	2699	java/lang/Throwable
    //   1151	1209	2699	java/lang/Throwable
    //   1209	1228	2699	java/lang/Throwable
    //   1232	1281	2699	java/lang/Throwable
    //   1281	1315	2699	java/lang/Throwable
    //   1327	1385	2699	java/lang/Throwable
    //   1389	1461	2699	java/lang/Throwable
    //   1461	1491	2699	java/lang/Throwable
    //   1491	1521	2699	java/lang/Throwable
    //   1521	1551	2699	java/lang/Throwable
    //   1551	1575	2699	java/lang/Throwable
    //   1575	1665	2699	java/lang/Throwable
    //   1665	1686	2699	java/lang/Throwable
    //   2313	2321	2699	java/lang/Throwable
    //   661	728	2703	finally
    //   2274	2279	2707	finally
    //   661	728	2711	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 812
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 814
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 816	awrn:b	()Z
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 816	awrn:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 818	awrn:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   55: ldc 26
    //   57: iconst_4
    //   58: invokevirtual 659	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 822 1 0
    //   66: ldc_w 824
    //   69: iconst_1
    //   70: invokeinterface 830 3 0
    //   75: invokeinterface 833 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 834	awrn:a	()Ljava/lang/String;
    //   88: invokestatic 836	awrn:b	()Ljava/lang/String;
    //   91: invokestatic 839	awrn:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 842	awrn:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 141	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   110: invokevirtual 845	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   113: aload_0
    //   114: getfield 12	awro:a	Lawrn;
    //   117: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   120: aload_3
    //   121: invokestatic 848	awrn:a	(Lawrn;Landroid/content/Context;Ljava/lang/String;)V
    //   124: aload_3
    //   125: ldc_w 850
    //   128: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifeq +17 -> 148
    //   134: aload_0
    //   135: getfield 12	awro:a	Lawrn;
    //   138: invokevirtual 851	awrn:a	()V
    //   141: aload_0
    //   142: getfield 12	awro:a	Lawrn;
    //   145: invokevirtual 852	awrn:b	()V
    //   148: aload_3
    //   149: ldc_w 364
    //   152: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: ifne +22 -> 177
    //   158: aload_3
    //   159: ldc 143
    //   161: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   164: ifne +13 -> 177
    //   167: aload_3
    //   168: ldc_w 854
    //   171: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   174: ifeq +18 -> 192
    //   177: aload_0
    //   178: getfield 12	awro:a	Lawrn;
    //   181: invokevirtual 851	awrn:a	()V
    //   184: aload_0
    //   185: getfield 12	awro:a	Lawrn;
    //   188: aload_3
    //   189: invokevirtual 856	awrn:b	(Ljava/lang/String;)V
    //   192: aload_3
    //   193: ldc_w 364
    //   196: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   199: ifne +42 -> 241
    //   202: aload_3
    //   203: ldc 143
    //   205: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   208: ifne +33 -> 241
    //   211: aload_3
    //   212: ldc_w 854
    //   215: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   218: ifne +23 -> 241
    //   221: aload_3
    //   222: ldc_w 858
    //   225: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   228: ifne +13 -> 241
    //   231: aload_3
    //   232: ldc_w 366
    //   235: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   238: ifeq +88 -> 326
    //   241: ldc_w 860
    //   244: iconst_0
    //   245: invokestatic 866	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   248: ifeq +78 -> 326
    //   251: ldc 26
    //   253: iconst_1
    //   254: new 28	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 868
    //   264: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   270: ldc2_w 869
    //   273: ldiv
    //   274: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 28	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 872
    //   293: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: getfield 12	awro:a	Lawrn;
    //   300: getfield 187	awrn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   303: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   312: ldc2_w 869
    //   315: ldiv
    //   316: invokestatic 876	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   319: ldc_w 860
    //   322: iconst_0
    //   323: invokestatic 880	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   326: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   329: invokevirtual 883	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   332: aload_3
    //   333: ldc_w 850
    //   336: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifeq +362 -> 701
    //   342: new 213	android/content/Intent
    //   345: dup
    //   346: ldc_w 885
    //   349: invokespecial 886	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   352: astore 4
    //   354: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   357: ldc_w 888
    //   360: invokevirtual 892	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   363: checkcast 894	android/app/ActivityManager
    //   366: invokevirtual 898	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   369: astore 6
    //   371: new 209	java/util/ArrayList
    //   374: dup
    //   375: invokespecial 899	java/util/ArrayList:<init>	()V
    //   378: astore 5
    //   380: aload 6
    //   382: ifnull +282 -> 664
    //   385: aload 6
    //   387: invokeinterface 902 1 0
    //   392: ifle +272 -> 664
    //   395: aload 6
    //   397: invokeinterface 903 1 0
    //   402: astore 6
    //   404: aload 6
    //   406: invokeinterface 720 1 0
    //   411: ifeq +253 -> 664
    //   414: aload 6
    //   416: invokeinterface 723 1 0
    //   421: checkcast 905	android/app/ActivityManager$RunningAppProcessInfo
    //   424: getfield 906	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   427: astore 7
    //   429: aload 7
    //   431: ifnull -27 -> 404
    //   434: aload 7
    //   436: ldc_w 908
    //   439: invokevirtual 911	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   442: ifeq -38 -> 404
    //   445: aload 7
    //   447: ldc_w 913
    //   450: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   453: ifne -49 -> 404
    //   456: aload 5
    //   458: aload 7
    //   460: invokevirtual 916	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   463: pop
    //   464: goto -60 -> 404
    //   467: astore 4
    //   469: aload 4
    //   471: invokevirtual 746	java/lang/Throwable:printStackTrace	()V
    //   474: aload_3
    //   475: ldc_w 850
    //   478: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   481: ifeq +395 -> 876
    //   484: aload_0
    //   485: getfield 12	awro:a	Lawrn;
    //   488: getfield 918	awrn:jdField_a_of_type_Boolean	Z
    //   491: ifeq +376 -> 867
    //   494: ldc 26
    //   496: iconst_1
    //   497: new 28	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 920
    //   507: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: getfield 12	awro:a	Lawrn;
    //   514: getfield 918	awrn:jdField_a_of_type_Boolean	Z
    //   517: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: ldc_w 922
    //   523: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   535: ldc_w 888
    //   538: invokevirtual 892	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   541: checkcast 894	android/app/ActivityManager
    //   544: invokevirtual 898	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   547: astore_3
    //   548: aload_3
    //   549: ifnull +260 -> 809
    //   552: aload_3
    //   553: invokeinterface 902 1 0
    //   558: ifle +251 -> 809
    //   561: aload_3
    //   562: invokeinterface 903 1 0
    //   567: astore_3
    //   568: aload_3
    //   569: invokeinterface 720 1 0
    //   574: ifeq +235 -> 809
    //   577: aload_3
    //   578: invokeinterface 723 1 0
    //   583: checkcast 905	android/app/ActivityManager$RunningAppProcessInfo
    //   586: astore 4
    //   588: aload 4
    //   590: getfield 906	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   593: astore 5
    //   595: aload 5
    //   597: ifnull -29 -> 568
    //   600: aload 5
    //   602: ldc_w 908
    //   605: invokevirtual 911	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   608: ifeq -40 -> 568
    //   611: aload 5
    //   613: ldc_w 913
    //   616: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   619: ifne -51 -> 568
    //   622: aload 4
    //   624: getfield 925	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   627: invokestatic 930	android/os/Process:killProcess	(I)V
    //   630: goto -62 -> 568
    //   633: astore_3
    //   634: aload_3
    //   635: invokevirtual 746	java/lang/Throwable:printStackTrace	()V
    //   638: iconst_1
    //   639: ireturn
    //   640: astore 4
    //   642: aload 4
    //   644: invokevirtual 746	java/lang/Throwable:printStackTrace	()V
    //   647: goto -523 -> 124
    //   650: astore 4
    //   652: ldc 26
    //   654: iconst_1
    //   655: ldc_w 932
    //   658: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: goto -335 -> 326
    //   664: aload 4
    //   666: ldc_w 934
    //   669: aload 5
    //   671: invokevirtual 938	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   674: pop
    //   675: aload 4
    //   677: ldc_w 940
    //   680: aload 5
    //   682: iconst_0
    //   683: invokestatic 944	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   686: invokevirtual 948	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   689: pop
    //   690: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   693: aload 4
    //   695: invokevirtual 238	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   698: goto -224 -> 474
    //   701: aload_3
    //   702: ldc_w 364
    //   705: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   708: ifeq +72 -> 780
    //   711: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   714: ldc_w 888
    //   717: invokevirtual 892	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   720: checkcast 894	android/app/ActivityManager
    //   723: invokevirtual 898	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   726: invokeinterface 903 1 0
    //   731: astore 4
    //   733: aload 4
    //   735: invokeinterface 720 1 0
    //   740: ifeq -266 -> 474
    //   743: aload 4
    //   745: invokeinterface 723 1 0
    //   750: checkcast 905	android/app/ActivityManager$RunningAppProcessInfo
    //   753: astore 5
    //   755: aload 5
    //   757: getfield 906	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   760: ldc_w 950
    //   763: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   766: ifeq -33 -> 733
    //   769: aload 5
    //   771: getfield 925	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   774: invokestatic 930	android/os/Process:killProcess	(I)V
    //   777: goto -44 -> 733
    //   780: aload_3
    //   781: ldc_w 952
    //   784: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   787: ifne -313 -> 474
    //   790: aload_3
    //   791: ldc_w 954
    //   794: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   797: ifeq -323 -> 474
    //   800: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   803: invokestatic 959	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   806: goto -332 -> 474
    //   809: invokestatic 105	awrn:a	()Landroid/content/Context;
    //   812: ldc_w 961
    //   815: iconst_0
    //   816: invokevirtual 659	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   819: astore_3
    //   820: aload_3
    //   821: ldc_w 963
    //   824: iconst_0
    //   825: invokeinterface 967 3 0
    //   830: istore_2
    //   831: aload_3
    //   832: invokeinterface 822 1 0
    //   837: ldc_w 963
    //   840: iload_2
    //   841: iconst_1
    //   842: iadd
    //   843: invokeinterface 971 3 0
    //   848: invokeinterface 833 1 0
    //   853: pop
    //   854: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   857: iconst_1
    //   858: invokevirtual 975	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   861: invokestatic 978	android/os/Process:myPid	()I
    //   864: invokestatic 930	android/os/Process:killProcess	(I)V
    //   867: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   870: iconst_1
    //   871: invokevirtual 981	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   874: iconst_1
    //   875: ireturn
    //   876: aload_3
    //   877: ldc_w 364
    //   880: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   883: ifne +45 -> 928
    //   886: aload_3
    //   887: ldc_w 983
    //   890: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   893: ifne +35 -> 928
    //   896: aload_3
    //   897: ldc_w 952
    //   900: invokevirtual 147	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   903: ifne +25 -> 928
    //   906: aload_3
    //   907: ldc_w 673
    //   910: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   913: ifeq +6 -> 919
    //   916: goto +12 -> 928
    //   919: invokestatic 700	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   922: iconst_0
    //   923: invokevirtual 986	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   926: iconst_1
    //   927: ireturn
    //   928: iload_1
    //   929: ifeq -883 -> 46
    //   932: goto -13 -> 919
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	935	0	this	awro
    //   0	935	1	paramBoolean	boolean
    //   830	13	2	i	int
    //   106	472	3	localObject1	Object
    //   633	158	3	localThrowable1	Throwable
    //   819	88	3	localSharedPreferences	android.content.SharedPreferences
    //   352	1	4	localIntent	android.content.Intent
    //   467	3	4	localThrowable2	Throwable
    //   586	37	4	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   640	3	4	localThrowable3	Throwable
    //   650	44	4	localThrowable4	Throwable
    //   731	13	4	localIterator	java.util.Iterator
    //   378	392	5	localObject2	Object
    //   369	46	6	localObject3	Object
    //   427	32	7	str	String
    // Exception table:
    //   from	to	target	type
    //   326	380	467	java/lang/Throwable
    //   385	404	467	java/lang/Throwable
    //   404	429	467	java/lang/Throwable
    //   434	464	467	java/lang/Throwable
    //   664	698	467	java/lang/Throwable
    //   701	733	467	java/lang/Throwable
    //   733	777	467	java/lang/Throwable
    //   780	806	467	java/lang/Throwable
    //   474	548	633	java/lang/Throwable
    //   552	568	633	java/lang/Throwable
    //   568	595	633	java/lang/Throwable
    //   600	630	633	java/lang/Throwable
    //   809	867	633	java/lang/Throwable
    //   867	874	633	java/lang/Throwable
    //   876	916	633	java/lang/Throwable
    //   919	926	633	java/lang/Throwable
    //   107	124	640	java/lang/Throwable
    //   124	148	650	java/lang/Throwable
    //   148	177	650	java/lang/Throwable
    //   177	192	650	java/lang/Throwable
    //   192	241	650	java/lang/Throwable
    //   241	326	650	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + awrn.c() + ", sIsFinalizeTimeoutException=" + awrn.b());
    if ((awrn.c()) && (!awrn.b()) && (!awrn.a(awrn.a(), awrn.b()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + ajox.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = awrn.a(this.a).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)awrn.a(this.a).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            awrn.b(true);
            break;
          }
        }
        awrn.a(this.a).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(awrn.a(this.a).toString());
        awrn.a(this.a, localStringBuilder1.toString());
        awrn.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
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
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + awrn.a().format(new Date(paramLong)) + ", curTime=" + awrn.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      awrn.a(paramBoolean);
      if (!awrn.b()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    azxi.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awro
 * JD-Core Version:    0.7.0.1
 */