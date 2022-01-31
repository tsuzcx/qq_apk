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

class azrj
  implements CrashHandleListener
{
  azrj(azri paramazri) {}
  
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
    //   59: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   62: new 60	java/util/Date
    //   65: dup
    //   66: lload 6
    //   68: invokespecial 63	java/util/Date:<init>	(J)V
    //   71: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 82	azri:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: pop
    //   88: aload 4
    //   90: invokestatic 85	azri:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: iconst_1
    //   95: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   98: if_icmpne +41 -> 139
    //   101: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   104: getstatic 100	azri:jdField_b_of_type_Long	J
    //   107: lsub
    //   108: ldc2_w 101
    //   111: lcmp
    //   112: ifgt +27 -> 139
    //   115: invokestatic 105	azri:a	()Landroid/content/Context;
    //   118: new 28	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   125: aload_2
    //   126: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 111	zhx:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   139: iconst_1
    //   140: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   143: if_icmpne +45 -> 188
    //   146: aload 4
    //   148: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne +37 -> 188
    //   154: iload_1
    //   155: ifeq +13 -> 168
    //   158: aload 4
    //   160: ldc 119
    //   162: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifne +17 -> 182
    //   168: iload_1
    //   169: ifne +19 -> 188
    //   172: aload 4
    //   174: ldc 126
    //   176: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +9 -> 188
    //   182: invokestatic 131	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:a	()Lcom/tencent/mobileqq/statistics/thread/SuspendThreadManager;
    //   185: invokevirtual 133	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:b	()V
    //   188: getstatic 136	azri:jdField_a_of_type_Azrp	Lazrp;
    //   191: ifnull +41 -> 232
    //   194: iload_1
    //   195: ifne +37 -> 232
    //   198: ldc 138
    //   200: aload_2
    //   201: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +28 -> 232
    //   207: aload_3
    //   208: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +21 -> 232
    //   214: aload_3
    //   215: ldc 144
    //   217: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +12 -> 232
    //   223: getstatic 136	azri:jdField_a_of_type_Azrp	Lazrp;
    //   226: aload_2
    //   227: invokeinterface 148 2 0
    //   232: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   235: ldc 154
    //   237: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   240: ifeq +30 -> 270
    //   243: new 28	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   250: ldc 160
    //   252: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_2
    //   256: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 4
    //   261: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 163	ajer:a	(Ljava/lang/String;)V
    //   270: aload 4
    //   272: ifnull +16 -> 288
    //   275: aload 4
    //   277: ldc 165
    //   279: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   282: ifeq +6 -> 288
    //   285: invokestatic 168	aztj:b	()V
    //   288: aload 4
    //   290: ifnull +111 -> 401
    //   293: aload 4
    //   295: ldc 170
    //   297: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   300: ifne +23 -> 323
    //   303: aload 4
    //   305: ldc 172
    //   307: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   310: ifne +13 -> 323
    //   313: aload 4
    //   315: ldc 174
    //   317: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +81 -> 401
    //   323: iconst_0
    //   324: iconst_0
    //   325: invokestatic 179	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   328: new 181	java/util/HashMap
    //   331: dup
    //   332: invokespecial 182	java/util/HashMap:<init>	()V
    //   335: astore 11
    //   337: iload_1
    //   338: ifeq +2076 -> 2414
    //   341: ldc 184
    //   343: astore 10
    //   345: aload 11
    //   347: ldc 186
    //   349: aload 10
    //   351: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: aload 11
    //   357: ldc 192
    //   359: aload_2
    //   360: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload 11
    //   366: ldc 194
    //   368: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   371: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: invokestatic 105	azri:a	()Landroid/content/Context;
    //   378: invokestatic 197	azri:a	(Landroid/content/Context;)Lazri;
    //   381: aload_0
    //   382: getfield 12	azrj:a	Lazri;
    //   385: getfield 199	azri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   388: ldc 201
    //   390: iconst_1
    //   391: lconst_0
    //   392: lconst_0
    //   393: aload 11
    //   395: ldc 203
    //   397: iconst_0
    //   398: invokevirtual 206	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   401: iload_1
    //   402: aload_2
    //   403: aload 4
    //   405: invokestatic 211	aliv:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +96 -> 506
    //   413: aload 4
    //   415: ldc 213
    //   417: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   420: ifne +13 -> 433
    //   423: aload 4
    //   425: ldc 215
    //   427: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   430: ifeq +76 -> 506
    //   433: new 181	java/util/HashMap
    //   436: dup
    //   437: invokespecial 182	java/util/HashMap:<init>	()V
    //   440: astore 11
    //   442: iload_1
    //   443: ifeq +1979 -> 2422
    //   446: ldc 184
    //   448: astore 10
    //   450: aload 11
    //   452: ldc 186
    //   454: aload 10
    //   456: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload 11
    //   462: ldc 192
    //   464: aload_2
    //   465: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: aload 11
    //   471: ldc 194
    //   473: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   476: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   479: pop
    //   480: invokestatic 105	azri:a	()Landroid/content/Context;
    //   483: invokestatic 197	azri:a	(Landroid/content/Context;)Lazri;
    //   486: aload_0
    //   487: getfield 12	azrj:a	Lazri;
    //   490: getfield 199	azri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   493: ldc 217
    //   495: iconst_1
    //   496: lconst_0
    //   497: lconst_0
    //   498: aload 11
    //   500: ldc 203
    //   502: iconst_0
    //   503: invokevirtual 206	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   506: iload_1
    //   507: aload_2
    //   508: aload_3
    //   509: aload 4
    //   511: iload 5
    //   513: lload 6
    //   515: invokestatic 222	azmy:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   518: getstatic 228	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   521: ldc 230
    //   523: invokevirtual 234	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   526: ifeq +55 -> 581
    //   529: new 236	android/content/Intent
    //   532: dup
    //   533: invokespecial 237	android/content/Intent:<init>	()V
    //   536: astore 10
    //   538: aload 10
    //   540: ldc 239
    //   542: invokevirtual 243	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   545: pop
    //   546: aload 10
    //   548: invokestatic 249	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   551: invokevirtual 252	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   554: invokevirtual 255	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   557: pop
    //   558: invokestatic 105	azri:a	()Landroid/content/Context;
    //   561: aload 10
    //   563: invokevirtual 261	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   566: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +12 -> 581
    //   572: ldc 26
    //   574: iconst_2
    //   575: ldc_w 267
    //   578: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   584: ldc_w 269
    //   587: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   590: ifeq +30 -> 620
    //   593: new 28	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   600: ldc 160
    //   602: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_2
    //   606: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 4
    //   611: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 274	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   620: aload 4
    //   622: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   625: ifne +136 -> 761
    //   628: aload 4
    //   630: ldc_w 276
    //   633: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   636: ifeq +125 -> 761
    //   639: new 278	org/json/JSONObject
    //   642: dup
    //   643: invokespecial 279	org/json/JSONObject:<init>	()V
    //   646: astore 10
    //   648: aload 10
    //   650: ldc_w 281
    //   653: iload_1
    //   654: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   657: pop
    //   658: aload 10
    //   660: ldc_w 286
    //   663: aload_2
    //   664: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   667: pop
    //   668: aload 10
    //   670: ldc_w 291
    //   673: aload_3
    //   674: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   677: pop
    //   678: aload 10
    //   680: ldc_w 293
    //   683: aload 4
    //   685: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   688: pop
    //   689: aload 10
    //   691: ldc_w 295
    //   694: iload 5
    //   696: invokevirtual 298	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload 10
    //   702: ldc_w 300
    //   705: lload 6
    //   707: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   710: pop
    //   711: getstatic 307	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   714: invokevirtual 311	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   717: astore_3
    //   718: aload_3
    //   719: ifnull +42 -> 761
    //   722: aload_3
    //   723: ldc_w 313
    //   726: invokevirtual 319	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   729: ldc_w 320
    //   732: iconst_1
    //   733: anewarray 322	java/lang/Class
    //   736: dup
    //   737: iconst_0
    //   738: ldc 121
    //   740: aastore
    //   741: invokevirtual 326	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   744: aconst_null
    //   745: iconst_1
    //   746: anewarray 4	java/lang/Object
    //   749: dup
    //   750: iconst_0
    //   751: aload 10
    //   753: invokevirtual 327	org/json/JSONObject:toString	()Ljava/lang/String;
    //   756: aastore
    //   757: invokevirtual 333	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   760: pop
    //   761: aconst_null
    //   762: astore 10
    //   764: new 335	java/io/File
    //   767: dup
    //   768: ldc_w 337
    //   771: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   774: astore_3
    //   775: aload_3
    //   776: ifnull +15 -> 791
    //   779: aload_3
    //   780: invokevirtual 341	java/io/File:exists	()Z
    //   783: ifne +8 -> 791
    //   786: aload_3
    //   787: invokevirtual 344	java/io/File:mkdirs	()Z
    //   790: pop
    //   791: new 346	java/io/FileWriter
    //   794: dup
    //   795: new 28	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 337
    //   805: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: lload 6
    //   810: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   813: ldc_w 351
    //   816: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokespecial 352	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   825: astore_3
    //   826: new 28	java/lang/StringBuilder
    //   829: dup
    //   830: sipush 128
    //   833: invokespecial 355	java/lang/StringBuilder:<init>	(I)V
    //   836: astore 10
    //   838: aload 10
    //   840: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   843: new 60	java/util/Date
    //   846: dup
    //   847: lload 6
    //   849: invokespecial 63	java/util/Date:<init>	(J)V
    //   852: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   855: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: ldc_w 357
    //   861: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_2
    //   865: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: ldc_w 357
    //   871: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload 4
    //   876: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload_3
    //   881: aload 10
    //   883: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokevirtual 360	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   889: aload_3
    //   890: invokevirtual 363	java/io/FileWriter:flush	()V
    //   893: aload_3
    //   894: ifnull +7 -> 901
    //   897: aload_3
    //   898: invokevirtual 366	java/io/FileWriter:close	()V
    //   901: aload_2
    //   902: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   905: ifne +47 -> 952
    //   908: aload_2
    //   909: ldc_w 368
    //   912: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   915: ifeq +37 -> 952
    //   918: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   921: invokevirtual 375	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   924: aload 4
    //   926: ldc_w 377
    //   929: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   932: ifne +20 -> 952
    //   935: aload 4
    //   937: ldc_w 379
    //   940: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   943: ifne +9 -> 952
    //   946: invokestatic 384	zie:a	()Lzie;
    //   949: invokevirtual 385	zie:b	()V
    //   952: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   955: astore 12
    //   957: iload_1
    //   958: ifeq +39 -> 997
    //   961: aload 12
    //   963: ldc_w 387
    //   966: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   969: ifne +14 -> 983
    //   972: aload 12
    //   974: ldc_w 389
    //   977: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   980: ifeq +17 -> 997
    //   983: ldc_w 391
    //   986: iconst_1
    //   987: aload 4
    //   989: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   992: aload 4
    //   994: invokestatic 399	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   997: invokestatic 105	azri:a	()Landroid/content/Context;
    //   1000: invokestatic 404	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1003: new 28	java/lang/StringBuilder
    //   1006: dup
    //   1007: sipush 128
    //   1010: invokespecial 355	java/lang/StringBuilder:<init>	(I)V
    //   1013: astore 11
    //   1015: invokestatic 105	azri:a	()Landroid/content/Context;
    //   1018: ldc_w 406
    //   1021: invokestatic 411	aawf:a	(Landroid/content/Context;Ljava/lang/String;)Laawe;
    //   1024: astore_3
    //   1025: aload 11
    //   1027: ldc_w 413
    //   1030: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload 11
    //   1036: ldc_w 415
    //   1039: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 11
    //   1045: ldc_w 417
    //   1048: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: getstatic 420	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1054: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 11
    //   1060: ldc_w 422
    //   1063: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: getstatic 425	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1069: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload 11
    //   1075: ldc_w 427
    //   1078: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: getstatic 430	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1084: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 11
    //   1090: ldc_w 432
    //   1093: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: getstatic 435	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1099: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload 11
    //   1105: ldc_w 437
    //   1108: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: getstatic 441	aznp:b	I
    //   1114: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1117: pop
    //   1118: aload 11
    //   1120: ldc_w 443
    //   1123: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: astore 10
    //   1128: aload_3
    //   1129: ifnull +1351 -> 2480
    //   1132: aload_3
    //   1133: invokevirtual 447	aawe:a	()Z
    //   1136: ifeq +1344 -> 2480
    //   1139: iconst_1
    //   1140: istore 9
    //   1142: aload 10
    //   1144: iload 9
    //   1146: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1149: ldc_w 449
    //   1152: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: getstatic 453	aavv:jdField_a_of_type_Int	I
    //   1158: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: ldc_w 455
    //   1164: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: getstatic 458	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1170: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1173: ldc_w 460
    //   1176: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: getstatic 461	aavv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1182: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 11
    //   1188: ldc_w 463
    //   1191: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1197: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1200: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: ldc_w 474
    //   1206: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1212: invokevirtual 477	java/lang/Runtime:totalMemory	()J
    //   1215: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1218: invokevirtual 480	java/lang/Runtime:freeMemory	()J
    //   1221: lsub
    //   1222: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: aload 11
    //   1228: ldc_w 482
    //   1231: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1237: invokevirtual 485	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   1240: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: ldc_w 487
    //   1246: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1252: invokevirtual 489	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   1255: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: ldc_w 491
    //   1261: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1267: invokevirtual 494	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   1270: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: aload 11
    //   1276: ldc_w 496
    //   1279: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: invokestatic 501	azrd:a	()Lazrd;
    //   1285: invokevirtual 503	azrd:a	()Ljava/lang/String;
    //   1288: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: getstatic 507	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1295: ifnull +21 -> 1316
    //   1298: aload 11
    //   1300: ldc_w 509
    //   1303: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: getstatic 507	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1309: invokevirtual 514	android/support/v4/util/MQLruCache:size	()I
    //   1312: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1319: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1322: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1325: invokevirtual 477	java/lang/Runtime:totalMemory	()J
    //   1328: lsub
    //   1329: l2f
    //   1330: fconst_1
    //   1331: fmul
    //   1332: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1335: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1338: l2f
    //   1339: fdiv
    //   1340: f2d
    //   1341: ldc2_w 515
    //   1344: dcmpl
    //   1345: iflt +29 -> 1374
    //   1348: aload_2
    //   1349: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1352: ifne +22 -> 1374
    //   1355: aload_2
    //   1356: ldc_w 368
    //   1359: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1362: ifeq +12 -> 1374
    //   1365: aload_0
    //   1366: getfield 12	azrj:a	Lazri;
    //   1369: aload 11
    //   1371: invokevirtual 519	azri:a	(Ljava/lang/StringBuilder;)V
    //   1374: aload 11
    //   1376: ldc_w 521
    //   1379: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: getstatic 526	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1385: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: getstatic 531	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1392: astore_3
    //   1393: aload_3
    //   1394: ifnull +52 -> 1446
    //   1397: aload_3
    //   1398: arraylength
    //   1399: iconst_3
    //   1400: if_icmplt +46 -> 1446
    //   1403: aload 11
    //   1405: ldc_w 533
    //   1408: iconst_3
    //   1409: anewarray 4	java/lang/Object
    //   1412: dup
    //   1413: iconst_0
    //   1414: aload_3
    //   1415: iconst_0
    //   1416: iaload
    //   1417: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1420: aastore
    //   1421: dup
    //   1422: iconst_1
    //   1423: aload_3
    //   1424: iconst_1
    //   1425: iaload
    //   1426: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1429: aastore
    //   1430: dup
    //   1431: iconst_2
    //   1432: aload_3
    //   1433: iconst_2
    //   1434: iaload
    //   1435: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1438: aastore
    //   1439: invokestatic 542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1442: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: pop
    //   1446: aload 11
    //   1448: ldc_w 357
    //   1451: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: pop
    //   1455: invokestatic 544	azri:c	()Ljava/lang/String;
    //   1458: astore 10
    //   1460: invokestatic 549	bdgk:a	()[J
    //   1463: astore 13
    //   1465: aload 11
    //   1467: invokestatic 552	bdgk:l	()Ljava/lang/String;
    //   1470: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: ldc_w 357
    //   1476: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload 10
    //   1482: astore_3
    //   1483: aload 10
    //   1485: ifnonnull +7 -> 1492
    //   1488: ldc_w 554
    //   1491: astore_3
    //   1492: aload 11
    //   1494: aload_3
    //   1495: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: ldc_w 357
    //   1501: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 11
    //   1507: ldc_w 556
    //   1510: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: aload 13
    //   1515: iconst_0
    //   1516: laload
    //   1517: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1520: ldc_w 558
    //   1523: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload 13
    //   1528: iconst_1
    //   1529: laload
    //   1530: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1533: ldc_w 560
    //   1536: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: pop
    //   1540: aload_0
    //   1541: getfield 12	azrj:a	Lazri;
    //   1544: invokestatic 563	azri:a	(Lazri;)Ljava/lang/String;
    //   1547: ifnonnull +939 -> 2486
    //   1550: ldc_w 554
    //   1553: astore_3
    //   1554: aload 11
    //   1556: aload_3
    //   1557: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: ldc_w 357
    //   1563: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: pop
    //   1567: aload 11
    //   1569: ldc_w 565
    //   1572: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: getstatic 568	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1578: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1581: ldc_w 357
    //   1584: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: pop
    //   1588: getstatic 572	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1591: astore_3
    //   1592: aload_3
    //   1593: instanceof 567
    //   1596: ifeq +30 -> 1626
    //   1599: aload_3
    //   1600: checkcast 567	com/tencent/mobileqq/activity/SplashActivity
    //   1603: astore_3
    //   1604: aload 11
    //   1606: ldc_w 574
    //   1609: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload_3
    //   1613: invokevirtual 575	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1616: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1619: ldc_w 357
    //   1622: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: getstatic 578	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1629: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1632: ifne +24 -> 1656
    //   1635: aload 11
    //   1637: ldc_w 580
    //   1640: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: getstatic 578	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1646: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: ldc_w 357
    //   1652: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: pop
    //   1656: getstatic 583	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1659: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1662: ifne +24 -> 1686
    //   1665: aload 11
    //   1667: ldc_w 585
    //   1670: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: getstatic 583	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1676: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: ldc_w 357
    //   1682: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: pop
    //   1686: getstatic 588	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1689: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1692: ifne +24 -> 1716
    //   1695: aload 11
    //   1697: ldc_w 590
    //   1700: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: getstatic 588	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1706: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: ldc_w 357
    //   1712: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: invokestatic 591	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1719: invokestatic 597	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   1722: invokevirtual 600	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   1725: astore_3
    //   1726: aload_3
    //   1727: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1730: ifne +10 -> 1740
    //   1733: aload 11
    //   1735: aload_3
    //   1736: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 11
    //   1742: aload_0
    //   1743: getfield 12	azrj:a	Lazri;
    //   1746: invokestatic 603	azri:b	(Lazri;)Ljava/lang/StringBuilder;
    //   1749: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1752: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: pop
    //   1756: aload 11
    //   1758: aload_0
    //   1759: getfield 12	azrj:a	Lazri;
    //   1762: invokestatic 605	azri:a	(Lazri;)Ljava/lang/StringBuilder;
    //   1765: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: getstatic 608	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1775: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1778: ifne +52 -> 1830
    //   1781: getstatic 613	android/os/Build$VERSION:SDK_INT	I
    //   1784: bipush 8
    //   1786: if_icmplt +44 -> 1830
    //   1789: aload 11
    //   1791: new 28	java/lang/StringBuilder
    //   1794: dup
    //   1795: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1798: ldc_w 615
    //   1801: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: getstatic 608	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1807: invokevirtual 619	java/lang/String:getBytes	()[B
    //   1810: iconst_0
    //   1811: invokestatic 625	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1814: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: ldc_w 357
    //   1820: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1826: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload 11
    //   1832: invokestatic 630	bjgs:a	()Lbjgs;
    //   1835: invokevirtual 631	bjgs:a	()Ljava/lang/String;
    //   1838: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload 11
    //   1844: ldc_w 357
    //   1847: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: pop
    //   1851: aload_0
    //   1852: getfield 12	azrj:a	Lazri;
    //   1855: invokestatic 634	azri:a	(Lazri;)Ljava/util/LinkedList;
    //   1858: invokevirtual 637	java/util/LinkedList:size	()I
    //   1861: ifle +29 -> 1890
    //   1864: aload 11
    //   1866: aload_0
    //   1867: getfield 12	azrj:a	Lazri;
    //   1870: invokestatic 634	azri:a	(Lazri;)Ljava/util/LinkedList;
    //   1873: invokevirtual 641	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1876: checkcast 643	azrk
    //   1879: invokevirtual 644	azrk:toString	()Ljava/lang/String;
    //   1882: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: pop
    //   1886: goto -35 -> 1851
    //   1889: astore_3
    //   1890: invokestatic 105	azri:a	()Landroid/content/Context;
    //   1893: invokestatic 650	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1896: istore 5
    //   1898: invokestatic 105	azri:a	()Landroid/content/Context;
    //   1901: invokestatic 655	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1904: istore 8
    //   1906: aload 11
    //   1908: bipush 10
    //   1910: invokevirtual 658	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1913: ldc_w 660
    //   1916: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: astore 10
    //   1921: iload 8
    //   1923: ifne +574 -> 2497
    //   1926: ldc_w 662
    //   1929: astore_3
    //   1930: aload 10
    //   1932: aload_3
    //   1933: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: ldc_w 664
    //   1939: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: iload 5
    //   1944: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1947: ldc_w 666
    //   1950: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: iload 8
    //   1955: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1958: pop
    //   1959: aload 11
    //   1961: ldc_w 668
    //   1964: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: invokestatic 105	azri:a	()Landroid/content/Context;
    //   1970: invokestatic 671	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1973: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: pop
    //   1977: aload 11
    //   1979: ldc_w 673
    //   1982: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   1988: new 60	java/util/Date
    //   1991: dup
    //   1992: getstatic 675	zhx:jdField_a_of_type_Long	J
    //   1995: invokespecial 63	java/util/Date:<init>	(J)V
    //   1998: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2001: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: pop
    //   2005: aload 11
    //   2007: ldc_w 677
    //   2010: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   2016: new 60	java/util/Date
    //   2019: dup
    //   2020: getstatic 678	zhx:jdField_b_of_type_Long	J
    //   2023: invokespecial 63	java/util/Date:<init>	(J)V
    //   2026: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2029: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: ldc_w 357
    //   2035: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: pop
    //   2039: iload_1
    //   2040: ifeq +99 -> 2139
    //   2043: aload 12
    //   2045: ldc_w 387
    //   2048: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2051: ifne +24 -> 2075
    //   2054: aload 12
    //   2056: ldc_w 389
    //   2059: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2062: ifne +13 -> 2075
    //   2065: aload 12
    //   2067: ldc 154
    //   2069: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2072: ifeq +67 -> 2139
    //   2075: invokestatic 105	azri:a	()Landroid/content/Context;
    //   2078: ldc 26
    //   2080: iconst_4
    //   2081: invokevirtual 682	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2084: ldc_w 684
    //   2087: aconst_null
    //   2088: invokeinterface 690 3 0
    //   2093: astore_3
    //   2094: aload 11
    //   2096: ldc_w 692
    //   2099: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: aload_3
    //   2103: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: pop
    //   2107: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2110: ifeq +29 -> 2139
    //   2113: ldc 26
    //   2115: iconst_2
    //   2116: new 28	java/lang/StringBuilder
    //   2119: dup
    //   2120: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2123: ldc_w 694
    //   2126: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: aload_3
    //   2130: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2136: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2139: aload 12
    //   2141: ldc_w 696
    //   2144: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2147: ifne +80 -> 2227
    //   2150: aload 12
    //   2152: ldc_w 698
    //   2155: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2158: ifne +69 -> 2227
    //   2161: aload 12
    //   2163: ldc_w 700
    //   2166: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2169: ifne +58 -> 2227
    //   2172: aload 12
    //   2174: ldc_w 702
    //   2177: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2180: ifne +47 -> 2227
    //   2183: aload 12
    //   2185: ldc_w 704
    //   2188: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2191: ifne +36 -> 2227
    //   2194: aload 12
    //   2196: ldc_w 706
    //   2199: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2202: ifne +25 -> 2227
    //   2205: aload 12
    //   2207: ldc_w 708
    //   2210: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2213: ifne +14 -> 2227
    //   2216: aload 12
    //   2218: ldc_w 710
    //   2221: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2224: ifeq +56 -> 2280
    //   2227: invokestatic 713	bjkc:a	()Ljava/lang/String;
    //   2230: astore_3
    //   2231: aload_3
    //   2232: ifnull +48 -> 2280
    //   2235: aload 11
    //   2237: ldc_w 715
    //   2240: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: aload_3
    //   2244: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: pop
    //   2248: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2251: ifeq +29 -> 2280
    //   2254: ldc 26
    //   2256: iconst_2
    //   2257: new 28	java/lang/StringBuilder
    //   2260: dup
    //   2261: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2264: ldc_w 717
    //   2267: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: aload_3
    //   2271: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2277: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2280: aload 11
    //   2282: ldc_w 719
    //   2285: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2291: getfield 726	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2294: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: pop
    //   2298: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2301: getfield 730	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2304: ifnull +220 -> 2524
    //   2307: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2310: getfield 730	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2313: invokeinterface 734 1 0
    //   2318: ifne +206 -> 2524
    //   2321: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2324: getfield 730	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2327: invokeinterface 738 1 0
    //   2332: astore_3
    //   2333: aload_3
    //   2334: invokeinterface 743 1 0
    //   2339: ifeq +185 -> 2524
    //   2342: aload_3
    //   2343: invokeinterface 746 1 0
    //   2348: checkcast 748	android/util/Pair
    //   2351: astore 10
    //   2353: aload 10
    //   2355: ifnull -22 -> 2333
    //   2358: aload 11
    //   2360: ldc_w 750
    //   2363: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   2369: new 60	java/util/Date
    //   2372: dup
    //   2373: aload 10
    //   2375: getfield 754	android/util/Pair:first	Ljava/lang/Object;
    //   2378: checkcast 756	java/lang/Long
    //   2381: invokevirtual 759	java/lang/Long:longValue	()J
    //   2384: invokespecial 63	java/util/Date:<init>	(J)V
    //   2387: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2390: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: ldc_w 761
    //   2396: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: aload 10
    //   2401: getfield 764	android/util/Pair:second	Ljava/lang/Object;
    //   2404: checkcast 121	java/lang/String
    //   2407: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: pop
    //   2411: goto -78 -> 2333
    //   2414: ldc_w 766
    //   2417: astore 10
    //   2419: goto -2074 -> 345
    //   2422: ldc_w 766
    //   2425: astore 10
    //   2427: goto -1977 -> 450
    //   2430: astore_3
    //   2431: aload_3
    //   2432: invokevirtual 769	java/lang/Throwable:printStackTrace	()V
    //   2435: goto -1674 -> 761
    //   2438: astore 11
    //   2440: aload 10
    //   2442: astore_3
    //   2443: aload 11
    //   2445: astore 10
    //   2447: aload 10
    //   2449: invokevirtual 770	java/lang/Exception:printStackTrace	()V
    //   2452: aload_3
    //   2453: ifnull -1552 -> 901
    //   2456: aload_3
    //   2457: invokevirtual 366	java/io/FileWriter:close	()V
    //   2460: goto -1559 -> 901
    //   2463: astore_3
    //   2464: goto -1563 -> 901
    //   2467: astore_2
    //   2468: aconst_null
    //   2469: astore_3
    //   2470: aload_3
    //   2471: ifnull +7 -> 2478
    //   2474: aload_3
    //   2475: invokevirtual 366	java/io/FileWriter:close	()V
    //   2478: aload_2
    //   2479: athrow
    //   2480: iconst_0
    //   2481: istore 9
    //   2483: goto -1341 -> 1142
    //   2486: aload_0
    //   2487: getfield 12	azrj:a	Lazri;
    //   2490: invokestatic 563	azri:a	(Lazri;)Ljava/lang/String;
    //   2493: astore_3
    //   2494: goto -940 -> 1554
    //   2497: ldc_w 772
    //   2500: astore_3
    //   2501: goto -571 -> 1930
    //   2504: astore_3
    //   2505: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2508: ifeq -228 -> 2280
    //   2511: ldc 26
    //   2513: iconst_2
    //   2514: ldc_w 774
    //   2517: aload_3
    //   2518: invokestatic 777	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2521: goto -241 -> 2280
    //   2524: getstatic 780	bfwb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2527: astore_3
    //   2528: aload_3
    //   2529: ifnull +23 -> 2552
    //   2532: aload_3
    //   2533: invokevirtual 783	java/lang/String:length	()I
    //   2536: ifle +16 -> 2552
    //   2539: aload 11
    //   2541: ldc_w 785
    //   2544: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2547: aload_3
    //   2548: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload_2
    //   2553: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2556: ifne +49 -> 2605
    //   2559: aload_2
    //   2560: ldc_w 787
    //   2563: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2566: ifeq +39 -> 2605
    //   2569: aload 4
    //   2571: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2574: ifne +31 -> 2605
    //   2577: aload 4
    //   2579: ldc_w 789
    //   2582: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2585: ifeq +20 -> 2605
    //   2588: aload 11
    //   2590: ldc_w 791
    //   2593: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: pop
    //   2597: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2600: aload 11
    //   2602: invokestatic 794	azri:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2605: ldc_w 796
    //   2608: aload_2
    //   2609: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2612: ifeq +22 -> 2634
    //   2615: aload 4
    //   2617: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2620: ifne +14 -> 2634
    //   2623: aload 4
    //   2625: ldc_w 798
    //   2628: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2631: ifne +32 -> 2663
    //   2634: ldc_w 800
    //   2637: aload_2
    //   2638: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2641: ifeq +40 -> 2681
    //   2644: aload 4
    //   2646: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2649: ifne +32 -> 2681
    //   2652: aload 4
    //   2654: ldc_w 802
    //   2657: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2660: ifeq +21 -> 2681
    //   2663: aload 11
    //   2665: ldc_w 804
    //   2668: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: ldc_w 806
    //   2674: invokestatic 809	bdep:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2677: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: pop
    //   2681: ldc_w 811
    //   2684: aload_2
    //   2685: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2688: ifne +64 -> 2752
    //   2691: ldc 138
    //   2693: aload_2
    //   2694: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2697: ifeq +14 -> 2711
    //   2700: aload 4
    //   2702: ldc_w 813
    //   2705: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2708: ifne +44 -> 2752
    //   2711: ldc_w 815
    //   2714: aload_2
    //   2715: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2718: ifeq +14 -> 2732
    //   2721: aload 4
    //   2723: ldc_w 817
    //   2726: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2729: ifne +23 -> 2752
    //   2732: ldc 138
    //   2734: aload_2
    //   2735: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2738: ifeq +92 -> 2830
    //   2741: aload 4
    //   2743: ldc_w 819
    //   2746: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2749: ifeq +81 -> 2830
    //   2752: invokestatic 58	azri:a	()Ljava/text/SimpleDateFormat;
    //   2755: new 60	java/util/Date
    //   2758: dup
    //   2759: getstatic 820	azri:jdField_a_of_type_Long	J
    //   2762: invokespecial 63	java/util/Date:<init>	(J)V
    //   2765: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2768: astore_2
    //   2769: aload 11
    //   2771: ldc_w 822
    //   2774: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: getstatic 823	azri:jdField_a_of_type_Int	I
    //   2780: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2783: ldc_w 825
    //   2786: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2789: aload_2
    //   2790: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2793: pop
    //   2794: aload 11
    //   2796: ldc_w 827
    //   2799: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2802: pop
    //   2803: aload 11
    //   2805: invokestatic 829	azri:d	()Ljava/lang/String;
    //   2808: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2811: pop
    //   2812: aload 11
    //   2814: ldc_w 831
    //   2817: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: pop
    //   2821: aload 11
    //   2823: invokestatic 836	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   2826: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2829: pop
    //   2830: ldc 26
    //   2832: iconst_1
    //   2833: new 28	java/lang/StringBuilder
    //   2836: dup
    //   2837: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2840: ldc_w 838
    //   2843: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: aload 11
    //   2848: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2851: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2857: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2860: aload 11
    //   2862: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2865: areturn
    //   2866: astore_3
    //   2867: goto -1966 -> 901
    //   2870: astore_3
    //   2871: goto -393 -> 2478
    //   2874: astore_3
    //   2875: goto -194 -> 2681
    //   2878: astore_3
    //   2879: goto -327 -> 2552
    //   2882: astore_3
    //   2883: goto -844 -> 2039
    //   2886: astore_3
    //   2887: goto -910 -> 1977
    //   2890: astore_3
    //   2891: goto -1040 -> 1851
    //   2894: astore_2
    //   2895: goto -425 -> 2470
    //   2898: astore_2
    //   2899: goto -429 -> 2470
    //   2902: astore 10
    //   2904: goto -457 -> 2447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2907	0	this	azrj
    //   0	2907	1	paramBoolean	boolean
    //   0	2907	2	paramString1	String
    //   0	2907	3	paramString2	String
    //   0	2907	4	paramString3	String
    //   0	2907	5	paramInt	int
    //   0	2907	6	paramLong	long
    //   1904	50	8	i	int
    //   1140	1342	9	bool	boolean
    //   343	2105	10	localObject1	Object
    //   2902	1	10	localException1	java.lang.Exception
    //   335	2024	11	localObject2	Object
    //   2438	423	11	localException2	java.lang.Exception
    //   955	1262	12	str	String
    //   1463	64	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1851	1886	1889	java/lang/Throwable
    //   639	718	2430	java/lang/Throwable
    //   722	761	2430	java/lang/Throwable
    //   764	775	2438	java/lang/Exception
    //   779	791	2438	java/lang/Exception
    //   791	826	2438	java/lang/Exception
    //   2456	2460	2463	java/lang/Exception
    //   764	775	2467	finally
    //   779	791	2467	finally
    //   791	826	2467	finally
    //   2139	2227	2504	java/lang/Throwable
    //   2227	2231	2504	java/lang/Throwable
    //   2235	2280	2504	java/lang/Throwable
    //   897	901	2866	java/lang/Exception
    //   2474	2478	2870	java/lang/Exception
    //   2552	2605	2874	java/lang/Throwable
    //   2605	2634	2874	java/lang/Throwable
    //   2634	2663	2874	java/lang/Throwable
    //   2663	2681	2874	java/lang/Throwable
    //   2524	2528	2878	java/lang/Throwable
    //   2532	2552	2878	java/lang/Throwable
    //   1977	2039	2882	java/lang/Throwable
    //   1890	1921	2886	java/lang/Throwable
    //   1930	1977	2886	java/lang/Throwable
    //   1015	1128	2890	java/lang/Throwable
    //   1132	1139	2890	java/lang/Throwable
    //   1142	1316	2890	java/lang/Throwable
    //   1316	1374	2890	java/lang/Throwable
    //   1374	1393	2890	java/lang/Throwable
    //   1397	1446	2890	java/lang/Throwable
    //   1446	1480	2890	java/lang/Throwable
    //   1492	1550	2890	java/lang/Throwable
    //   1554	1626	2890	java/lang/Throwable
    //   1626	1656	2890	java/lang/Throwable
    //   1656	1686	2890	java/lang/Throwable
    //   1686	1716	2890	java/lang/Throwable
    //   1716	1740	2890	java/lang/Throwable
    //   1740	1830	2890	java/lang/Throwable
    //   1830	1851	2890	java/lang/Throwable
    //   2486	2494	2890	java/lang/Throwable
    //   826	893	2894	finally
    //   2447	2452	2898	finally
    //   826	893	2902	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 842
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 844
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 846	azri:b	()Z
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 846	azri:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 848	azri:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 105	azri:a	()Landroid/content/Context;
    //   55: ldc 26
    //   57: iconst_4
    //   58: invokevirtual 682	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 852 1 0
    //   66: ldc_w 854
    //   69: iconst_1
    //   70: invokeinterface 860 3 0
    //   75: invokeinterface 863 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 864	azri:a	()Ljava/lang/String;
    //   88: invokestatic 866	azri:b	()Ljava/lang/String;
    //   91: invokestatic 869	azri:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 872	azri:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	azrj:a	Lazri;
    //   111: invokestatic 874	azri:a	(Lazri;)V
    //   114: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 877	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	azrj:a	Lazri;
    //   124: invokestatic 105	azri:a	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 880	azri:a	(Lazri;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 882
    //   135: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +17 -> 155
    //   141: aload_0
    //   142: getfield 12	azrj:a	Lazri;
    //   145: invokevirtual 883	azri:a	()V
    //   148: aload_0
    //   149: getfield 12	azrj:a	Lazri;
    //   152: invokevirtual 884	azri:b	()V
    //   155: aload_3
    //   156: ldc_w 387
    //   159: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   162: ifne +22 -> 184
    //   165: aload_3
    //   166: ldc 154
    //   168: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifne +13 -> 184
    //   174: aload_3
    //   175: ldc_w 886
    //   178: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   181: ifeq +18 -> 199
    //   184: aload_0
    //   185: getfield 12	azrj:a	Lazri;
    //   188: invokevirtual 883	azri:a	()V
    //   191: aload_0
    //   192: getfield 12	azrj:a	Lazri;
    //   195: aload_3
    //   196: invokevirtual 888	azri:b	(Ljava/lang/String;)V
    //   199: aload_3
    //   200: ldc_w 387
    //   203: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   206: ifne +42 -> 248
    //   209: aload_3
    //   210: ldc 154
    //   212: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   215: ifne +33 -> 248
    //   218: aload_3
    //   219: ldc_w 886
    //   222: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   225: ifne +23 -> 248
    //   228: aload_3
    //   229: ldc_w 890
    //   232: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   235: ifne +13 -> 248
    //   238: aload_3
    //   239: ldc_w 389
    //   242: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   245: ifeq +88 -> 333
    //   248: ldc_w 892
    //   251: iconst_0
    //   252: invokestatic 898	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   255: ifeq +78 -> 333
    //   258: ldc 26
    //   260: iconst_1
    //   261: new 28	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 900
    //   271: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   277: ldc2_w 901
    //   280: ldiv
    //   281: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: new 28	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 904
    //   300: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 12	azrj:a	Lazri;
    //   307: getfield 199	azri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   319: ldc2_w 901
    //   322: ldiv
    //   323: invokestatic 908	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   326: ldc_w 892
    //   329: iconst_0
    //   330: invokestatic 912	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   333: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   336: invokevirtual 915	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   339: aload_3
    //   340: ldc_w 882
    //   343: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifeq +362 -> 708
    //   349: new 236	android/content/Intent
    //   352: dup
    //   353: ldc_w 917
    //   356: invokespecial 918	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   359: astore 4
    //   361: invokestatic 105	azri:a	()Landroid/content/Context;
    //   364: ldc_w 920
    //   367: invokevirtual 924	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   370: checkcast 926	android/app/ActivityManager
    //   373: invokevirtual 930	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   376: astore 6
    //   378: new 232	java/util/ArrayList
    //   381: dup
    //   382: invokespecial 931	java/util/ArrayList:<init>	()V
    //   385: astore 5
    //   387: aload 6
    //   389: ifnull +282 -> 671
    //   392: aload 6
    //   394: invokeinterface 934 1 0
    //   399: ifle +272 -> 671
    //   402: aload 6
    //   404: invokeinterface 935 1 0
    //   409: astore 6
    //   411: aload 6
    //   413: invokeinterface 743 1 0
    //   418: ifeq +253 -> 671
    //   421: aload 6
    //   423: invokeinterface 746 1 0
    //   428: checkcast 937	android/app/ActivityManager$RunningAppProcessInfo
    //   431: getfield 938	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   434: astore 7
    //   436: aload 7
    //   438: ifnull -27 -> 411
    //   441: aload 7
    //   443: ldc_w 940
    //   446: invokevirtual 943	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   449: ifeq -38 -> 411
    //   452: aload 7
    //   454: ldc_w 945
    //   457: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   460: ifne -49 -> 411
    //   463: aload 5
    //   465: aload 7
    //   467: invokevirtual 948	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   470: pop
    //   471: goto -60 -> 411
    //   474: astore 4
    //   476: aload 4
    //   478: invokevirtual 769	java/lang/Throwable:printStackTrace	()V
    //   481: aload_3
    //   482: ldc_w 882
    //   485: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifeq +395 -> 883
    //   491: aload_0
    //   492: getfield 12	azrj:a	Lazri;
    //   495: getfield 950	azri:jdField_a_of_type_Boolean	Z
    //   498: ifeq +376 -> 874
    //   501: ldc 26
    //   503: iconst_1
    //   504: new 28	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 952
    //   514: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_0
    //   518: getfield 12	azrj:a	Lazri;
    //   521: getfield 950	azri:jdField_a_of_type_Boolean	Z
    //   524: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 954
    //   530: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: invokestatic 105	azri:a	()Landroid/content/Context;
    //   542: ldc_w 920
    //   545: invokevirtual 924	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   548: checkcast 926	android/app/ActivityManager
    //   551: invokevirtual 930	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   554: astore_3
    //   555: aload_3
    //   556: ifnull +260 -> 816
    //   559: aload_3
    //   560: invokeinterface 934 1 0
    //   565: ifle +251 -> 816
    //   568: aload_3
    //   569: invokeinterface 935 1 0
    //   574: astore_3
    //   575: aload_3
    //   576: invokeinterface 743 1 0
    //   581: ifeq +235 -> 816
    //   584: aload_3
    //   585: invokeinterface 746 1 0
    //   590: checkcast 937	android/app/ActivityManager$RunningAppProcessInfo
    //   593: astore 4
    //   595: aload 4
    //   597: getfield 938	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   600: astore 5
    //   602: aload 5
    //   604: ifnull -29 -> 575
    //   607: aload 5
    //   609: ldc_w 940
    //   612: invokevirtual 943	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   615: ifeq -40 -> 575
    //   618: aload 5
    //   620: ldc_w 945
    //   623: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   626: ifne -51 -> 575
    //   629: aload 4
    //   631: getfield 957	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   634: invokestatic 962	android/os/Process:killProcess	(I)V
    //   637: goto -62 -> 575
    //   640: astore_3
    //   641: aload_3
    //   642: invokevirtual 769	java/lang/Throwable:printStackTrace	()V
    //   645: iconst_1
    //   646: ireturn
    //   647: astore 4
    //   649: aload 4
    //   651: invokevirtual 769	java/lang/Throwable:printStackTrace	()V
    //   654: goto -523 -> 131
    //   657: astore 4
    //   659: ldc 26
    //   661: iconst_1
    //   662: ldc_w 964
    //   665: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: goto -335 -> 333
    //   671: aload 4
    //   673: ldc_w 966
    //   676: aload 5
    //   678: invokevirtual 970	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   681: pop
    //   682: aload 4
    //   684: ldc_w 972
    //   687: aload 5
    //   689: iconst_0
    //   690: invokestatic 976	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   693: invokevirtual 980	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   696: pop
    //   697: invokestatic 105	azri:a	()Landroid/content/Context;
    //   700: aload 4
    //   702: invokevirtual 261	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   705: goto -224 -> 481
    //   708: aload_3
    //   709: ldc_w 387
    //   712: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   715: ifeq +72 -> 787
    //   718: invokestatic 105	azri:a	()Landroid/content/Context;
    //   721: ldc_w 920
    //   724: invokevirtual 924	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   727: checkcast 926	android/app/ActivityManager
    //   730: invokevirtual 930	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   733: invokeinterface 935 1 0
    //   738: astore 4
    //   740: aload 4
    //   742: invokeinterface 743 1 0
    //   747: ifeq -266 -> 481
    //   750: aload 4
    //   752: invokeinterface 746 1 0
    //   757: checkcast 937	android/app/ActivityManager$RunningAppProcessInfo
    //   760: astore 5
    //   762: aload 5
    //   764: getfield 938	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   767: ldc_w 982
    //   770: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifeq -33 -> 740
    //   776: aload 5
    //   778: getfield 957	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   781: invokestatic 962	android/os/Process:killProcess	(I)V
    //   784: goto -44 -> 740
    //   787: aload_3
    //   788: ldc_w 984
    //   791: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   794: ifne -313 -> 481
    //   797: aload_3
    //   798: ldc_w 986
    //   801: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   804: ifeq -323 -> 481
    //   807: invokestatic 105	azri:a	()Landroid/content/Context;
    //   810: invokestatic 991	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   813: goto -332 -> 481
    //   816: invokestatic 105	azri:a	()Landroid/content/Context;
    //   819: ldc_w 993
    //   822: iconst_0
    //   823: invokevirtual 682	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   826: astore_3
    //   827: aload_3
    //   828: ldc_w 995
    //   831: iconst_0
    //   832: invokeinterface 999 3 0
    //   837: istore_2
    //   838: aload_3
    //   839: invokeinterface 852 1 0
    //   844: ldc_w 995
    //   847: iload_2
    //   848: iconst_1
    //   849: iadd
    //   850: invokeinterface 1003 3 0
    //   855: invokeinterface 863 1 0
    //   860: pop
    //   861: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   864: iconst_1
    //   865: invokevirtual 1007	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   868: invokestatic 1010	android/os/Process:myPid	()I
    //   871: invokestatic 962	android/os/Process:killProcess	(I)V
    //   874: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   877: iconst_1
    //   878: invokevirtual 1013	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   881: iconst_1
    //   882: ireturn
    //   883: aload_3
    //   884: ldc_w 387
    //   887: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   890: ifne +45 -> 935
    //   893: aload_3
    //   894: ldc_w 1015
    //   897: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   900: ifne +35 -> 935
    //   903: aload_3
    //   904: ldc_w 984
    //   907: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   910: ifne +25 -> 935
    //   913: aload_3
    //   914: ldc_w 696
    //   917: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   920: ifeq +6 -> 926
    //   923: goto +12 -> 935
    //   926: invokestatic 723	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   929: iconst_0
    //   930: invokevirtual 1018	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   933: iconst_1
    //   934: ireturn
    //   935: iload_1
    //   936: ifeq -890 -> 46
    //   939: goto -13 -> 926
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	942	0	this	azrj
    //   0	942	1	paramBoolean	boolean
    //   837	13	2	i	int
    //   106	479	3	localObject1	Object
    //   640	158	3	localThrowable1	Throwable
    //   826	88	3	localSharedPreferences	android.content.SharedPreferences
    //   359	1	4	localIntent	android.content.Intent
    //   474	3	4	localThrowable2	Throwable
    //   593	37	4	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   647	3	4	localThrowable3	Throwable
    //   657	44	4	localThrowable4	Throwable
    //   738	13	4	localIterator	java.util.Iterator
    //   385	392	5	localObject2	Object
    //   376	46	6	localObject3	Object
    //   434	32	7	str	String
    // Exception table:
    //   from	to	target	type
    //   333	387	474	java/lang/Throwable
    //   392	411	474	java/lang/Throwable
    //   411	436	474	java/lang/Throwable
    //   441	471	474	java/lang/Throwable
    //   671	705	474	java/lang/Throwable
    //   708	740	474	java/lang/Throwable
    //   740	784	474	java/lang/Throwable
    //   787	813	474	java/lang/Throwable
    //   481	555	640	java/lang/Throwable
    //   559	575	640	java/lang/Throwable
    //   575	602	640	java/lang/Throwable
    //   607	637	640	java/lang/Throwable
    //   816	874	640	java/lang/Throwable
    //   874	881	640	java/lang/Throwable
    //   883	923	640	java/lang/Throwable
    //   926	933	640	java/lang/Throwable
    //   107	131	647	java/lang/Throwable
    //   131	155	657	java/lang/Throwable
    //   155	184	657	java/lang/Throwable
    //   184	199	657	java/lang/Throwable
    //   199	248	657	java/lang/Throwable
    //   248	333	657	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + azri.c() + ", sIsFinalizeTimeoutException=" + azri.b());
    if ((azri.c()) && (!azri.b()) && (!azri.a(azri.a(), azri.b()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + alzk.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = azri.a(this.a).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)azri.a(this.a).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            azri.b(true);
            break;
          }
        }
        azri.a(this.a).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(azri.a(this.a).toString());
        azri.a(this.a, localStringBuilder1.toString());
        azri.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
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
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + azri.a().format(new Date(paramLong)) + ", curTime=" + azri.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      azri.a(paramBoolean);
      if (!azri.b()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    bdcd.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azrj
 * JD-Core Version:    0.7.0.1
 */