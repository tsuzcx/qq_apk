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

class axrm
  implements CrashHandleListener
{
  axrm(axrl paramaxrl) {}
  
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
    //   59: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   62: new 60	java/util/Date
    //   65: dup
    //   66: lload 6
    //   68: invokespecial 63	java/util/Date:<init>	(J)V
    //   71: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 82	axrl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: pop
    //   88: aload 4
    //   90: invokestatic 85	axrl:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: iconst_1
    //   95: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   98: if_icmpne +41 -> 139
    //   101: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   104: getstatic 100	axrl:jdField_b_of_type_Long	J
    //   107: lsub
    //   108: ldc2_w 101
    //   111: lcmp
    //   112: ifgt +27 -> 139
    //   115: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   118: new 28	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   125: aload_2
    //   126: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 111	xos:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   188: getstatic 136	axrl:jdField_a_of_type_Axrs	Laxrs;
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
    //   223: getstatic 136	axrl:jdField_a_of_type_Axrs	Laxrs;
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
    //   267: invokestatic 163	ahiv:a	(Ljava/lang/String;)V
    //   270: aload 4
    //   272: ifnull +16 -> 288
    //   275: aload 4
    //   277: ldc 165
    //   279: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   282: ifeq +6 -> 288
    //   285: invokestatic 168	axtm:b	()V
    //   288: aload 4
    //   290: ifnull +110 -> 400
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
    //   320: ifeq +80 -> 400
    //   323: iconst_0
    //   324: invokestatic 179	com/tencent/mobileqq/statistics/FDNative:a	(Z)V
    //   327: new 181	java/util/HashMap
    //   330: dup
    //   331: invokespecial 182	java/util/HashMap:<init>	()V
    //   334: astore 11
    //   336: iload_1
    //   337: ifeq +2082 -> 2419
    //   340: ldc 184
    //   342: astore 10
    //   344: aload 11
    //   346: ldc 186
    //   348: aload 10
    //   350: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 11
    //   356: ldc 192
    //   358: aload_2
    //   359: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: aload 11
    //   365: ldc 194
    //   367: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   370: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   377: invokestatic 197	axrl:a	(Landroid/content/Context;)Laxrl;
    //   380: aload_0
    //   381: getfield 12	axrm:a	Laxrl;
    //   384: getfield 199	axrl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   387: ldc 201
    //   389: iconst_1
    //   390: lconst_0
    //   391: lconst_0
    //   392: aload 11
    //   394: ldc 203
    //   396: iconst_0
    //   397: invokevirtual 206	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   400: iload_1
    //   401: aload_2
    //   402: aload 4
    //   404: invokestatic 211	ajmv:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   407: aload 4
    //   409: ifnull +96 -> 505
    //   412: aload 4
    //   414: ldc 213
    //   416: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   419: ifne +13 -> 432
    //   422: aload 4
    //   424: ldc 215
    //   426: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   429: ifeq +76 -> 505
    //   432: new 181	java/util/HashMap
    //   435: dup
    //   436: invokespecial 182	java/util/HashMap:<init>	()V
    //   439: astore 11
    //   441: iload_1
    //   442: ifeq +1985 -> 2427
    //   445: ldc 184
    //   447: astore 10
    //   449: aload 11
    //   451: ldc 186
    //   453: aload 10
    //   455: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: aload 11
    //   461: ldc 192
    //   463: aload_2
    //   464: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: pop
    //   468: aload 11
    //   470: ldc 194
    //   472: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   475: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   478: pop
    //   479: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   482: invokestatic 197	axrl:a	(Landroid/content/Context;)Laxrl;
    //   485: aload_0
    //   486: getfield 12	axrm:a	Laxrl;
    //   489: getfield 199	axrl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   492: ldc 217
    //   494: iconst_1
    //   495: lconst_0
    //   496: lconst_0
    //   497: aload 11
    //   499: ldc 203
    //   501: iconst_0
    //   502: invokevirtual 206	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   505: iload_1
    //   506: aload_2
    //   507: aload_3
    //   508: aload 4
    //   510: iload 5
    //   512: lload 6
    //   514: invokestatic 222	axng:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   517: getstatic 228	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   520: ldc 230
    //   522: invokevirtual 234	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   525: ifeq +55 -> 580
    //   528: new 236	android/content/Intent
    //   531: dup
    //   532: invokespecial 237	android/content/Intent:<init>	()V
    //   535: astore 10
    //   537: aload 10
    //   539: ldc 239
    //   541: invokevirtual 243	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   544: pop
    //   545: aload 10
    //   547: invokestatic 249	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   550: invokevirtual 252	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   553: invokevirtual 255	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   556: pop
    //   557: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   560: aload 10
    //   562: invokevirtual 261	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   565: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +12 -> 580
    //   571: ldc 26
    //   573: iconst_2
    //   574: ldc_w 267
    //   577: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   583: ldc_w 269
    //   586: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   589: ifeq +30 -> 619
    //   592: new 28	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   599: ldc 160
    //   601: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload_2
    //   605: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 4
    //   610: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 274	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   619: aload 4
    //   621: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   624: ifne +136 -> 760
    //   627: aload 4
    //   629: ldc_w 276
    //   632: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   635: ifeq +125 -> 760
    //   638: new 278	org/json/JSONObject
    //   641: dup
    //   642: invokespecial 279	org/json/JSONObject:<init>	()V
    //   645: astore 10
    //   647: aload 10
    //   649: ldc_w 281
    //   652: iload_1
    //   653: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   656: pop
    //   657: aload 10
    //   659: ldc_w 286
    //   662: aload_2
    //   663: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   666: pop
    //   667: aload 10
    //   669: ldc_w 291
    //   672: aload_3
    //   673: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   676: pop
    //   677: aload 10
    //   679: ldc_w 293
    //   682: aload 4
    //   684: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   687: pop
    //   688: aload 10
    //   690: ldc_w 295
    //   693: iload 5
    //   695: invokevirtual 298	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   698: pop
    //   699: aload 10
    //   701: ldc_w 300
    //   704: lload 6
    //   706: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   709: pop
    //   710: getstatic 307	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   713: invokevirtual 311	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   716: astore_3
    //   717: aload_3
    //   718: ifnull +42 -> 760
    //   721: aload_3
    //   722: ldc_w 313
    //   725: invokevirtual 319	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   728: ldc_w 320
    //   731: iconst_1
    //   732: anewarray 322	java/lang/Class
    //   735: dup
    //   736: iconst_0
    //   737: ldc 121
    //   739: aastore
    //   740: invokevirtual 326	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   743: aconst_null
    //   744: iconst_1
    //   745: anewarray 4	java/lang/Object
    //   748: dup
    //   749: iconst_0
    //   750: aload 10
    //   752: invokevirtual 327	org/json/JSONObject:toString	()Ljava/lang/String;
    //   755: aastore
    //   756: invokevirtual 333	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   759: pop
    //   760: aconst_null
    //   761: astore 10
    //   763: new 335	java/io/File
    //   766: dup
    //   767: ldc_w 337
    //   770: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   773: astore_3
    //   774: aload_3
    //   775: ifnull +15 -> 790
    //   778: aload_3
    //   779: invokevirtual 341	java/io/File:exists	()Z
    //   782: ifne +8 -> 790
    //   785: aload_3
    //   786: invokevirtual 344	java/io/File:mkdirs	()Z
    //   789: pop
    //   790: new 346	java/io/FileWriter
    //   793: dup
    //   794: new 28	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   801: ldc_w 337
    //   804: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: lload 6
    //   809: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   812: ldc_w 351
    //   815: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokespecial 352	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   824: astore_3
    //   825: new 28	java/lang/StringBuilder
    //   828: dup
    //   829: sipush 128
    //   832: invokespecial 355	java/lang/StringBuilder:<init>	(I)V
    //   835: astore 10
    //   837: aload 10
    //   839: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   842: new 60	java/util/Date
    //   845: dup
    //   846: lload 6
    //   848: invokespecial 63	java/util/Date:<init>	(J)V
    //   851: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   854: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 357
    //   860: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload_2
    //   864: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 357
    //   870: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 4
    //   875: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload_3
    //   880: aload 10
    //   882: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokevirtual 360	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   888: aload_3
    //   889: invokevirtual 363	java/io/FileWriter:flush	()V
    //   892: aload_3
    //   893: ifnull +7 -> 900
    //   896: aload_3
    //   897: invokevirtual 366	java/io/FileWriter:close	()V
    //   900: aload_2
    //   901: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   904: ifne +47 -> 951
    //   907: aload_2
    //   908: ldc_w 368
    //   911: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   914: ifeq +37 -> 951
    //   917: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   920: invokevirtual 375	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   923: aload 4
    //   925: ldc_w 377
    //   928: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   931: ifne +20 -> 951
    //   934: aload 4
    //   936: ldc_w 379
    //   939: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   942: ifne +9 -> 951
    //   945: invokestatic 384	xoz:a	()Lxoz;
    //   948: invokevirtual 385	xoz:b	()V
    //   951: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   954: astore 12
    //   956: iload_1
    //   957: ifeq +39 -> 996
    //   960: aload 12
    //   962: ldc_w 387
    //   965: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   968: ifne +14 -> 982
    //   971: aload 12
    //   973: ldc_w 389
    //   976: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   979: ifeq +17 -> 996
    //   982: ldc_w 391
    //   985: iconst_1
    //   986: aload 4
    //   988: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: aload 4
    //   993: invokestatic 399	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   996: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   999: invokestatic 404	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1002: new 28	java/lang/StringBuilder
    //   1005: dup
    //   1006: sipush 128
    //   1009: invokespecial 355	java/lang/StringBuilder:<init>	(I)V
    //   1012: astore 11
    //   1014: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   1017: ldc_w 406
    //   1020: invokestatic 411	zcu:a	(Landroid/content/Context;Ljava/lang/String;)Lzct;
    //   1023: astore_3
    //   1024: aload 11
    //   1026: ldc_w 413
    //   1029: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 11
    //   1035: ldc_w 415
    //   1038: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: aload 11
    //   1044: ldc_w 417
    //   1047: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: getstatic 420	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1053: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 11
    //   1059: ldc_w 422
    //   1062: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: getstatic 425	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1068: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload 11
    //   1074: ldc_w 427
    //   1077: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: getstatic 430	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1083: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 11
    //   1089: ldc_w 432
    //   1092: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: getstatic 435	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1098: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 11
    //   1104: ldc_w 437
    //   1107: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: getstatic 441	axnv:b	I
    //   1113: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 11
    //   1119: ldc_w 443
    //   1122: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: astore 10
    //   1127: aload_3
    //   1128: ifnull +1357 -> 2485
    //   1131: aload_3
    //   1132: invokevirtual 447	zct:a	()Z
    //   1135: ifeq +1350 -> 2485
    //   1138: iconst_1
    //   1139: istore 9
    //   1141: aload 10
    //   1143: iload 9
    //   1145: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1148: ldc_w 449
    //   1151: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: getstatic 453	zck:jdField_a_of_type_Int	I
    //   1157: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1160: ldc_w 455
    //   1163: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: getstatic 458	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1169: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 460
    //   1175: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: getstatic 461	zck:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1181: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 11
    //   1187: ldc_w 463
    //   1190: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1196: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1199: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1202: ldc_w 474
    //   1205: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1211: invokevirtual 477	java/lang/Runtime:totalMemory	()J
    //   1214: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1217: invokevirtual 480	java/lang/Runtime:freeMemory	()J
    //   1220: lsub
    //   1221: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload 11
    //   1227: ldc_w 482
    //   1230: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1236: invokevirtual 485	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   1239: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1242: ldc_w 487
    //   1245: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1251: invokevirtual 489	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   1254: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1257: ldc_w 491
    //   1260: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: invokestatic 373	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1266: invokevirtual 494	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   1269: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1272: pop
    //   1273: aload 11
    //   1275: ldc_w 496
    //   1278: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: invokestatic 501	axrg:a	()Laxrg;
    //   1284: invokevirtual 503	axrg:a	()Ljava/lang/String;
    //   1287: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: getstatic 507	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1294: ifnull +21 -> 1315
    //   1297: aload 11
    //   1299: ldc_w 509
    //   1302: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: getstatic 507	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1308: invokevirtual 514	android/support/v4/util/MQLruCache:size	()I
    //   1311: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1318: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1321: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1324: invokevirtual 477	java/lang/Runtime:totalMemory	()J
    //   1327: lsub
    //   1328: l2f
    //   1329: fconst_1
    //   1330: fmul
    //   1331: invokestatic 469	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1334: invokevirtual 472	java/lang/Runtime:maxMemory	()J
    //   1337: l2f
    //   1338: fdiv
    //   1339: f2d
    //   1340: ldc2_w 515
    //   1343: dcmpl
    //   1344: iflt +29 -> 1373
    //   1347: aload_2
    //   1348: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1351: ifne +22 -> 1373
    //   1354: aload_2
    //   1355: ldc_w 368
    //   1358: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1361: ifeq +12 -> 1373
    //   1364: aload_0
    //   1365: getfield 12	axrm:a	Laxrl;
    //   1368: aload 11
    //   1370: invokevirtual 519	axrl:a	(Ljava/lang/StringBuilder;)V
    //   1373: aload 11
    //   1375: ldc_w 521
    //   1378: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: getstatic 526	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1384: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: getstatic 531	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1391: astore_3
    //   1392: aload_3
    //   1393: ifnull +52 -> 1445
    //   1396: aload_3
    //   1397: arraylength
    //   1398: iconst_3
    //   1399: if_icmplt +46 -> 1445
    //   1402: aload 11
    //   1404: ldc_w 533
    //   1407: iconst_3
    //   1408: anewarray 4	java/lang/Object
    //   1411: dup
    //   1412: iconst_0
    //   1413: aload_3
    //   1414: iconst_0
    //   1415: iaload
    //   1416: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: dup
    //   1421: iconst_1
    //   1422: aload_3
    //   1423: iconst_1
    //   1424: iaload
    //   1425: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1428: aastore
    //   1429: dup
    //   1430: iconst_2
    //   1431: aload_3
    //   1432: iconst_2
    //   1433: iaload
    //   1434: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1437: aastore
    //   1438: invokestatic 542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1441: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload 11
    //   1447: ldc_w 357
    //   1450: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: pop
    //   1454: invokestatic 544	axrl:c	()Ljava/lang/String;
    //   1457: astore 10
    //   1459: invokestatic 549	bbct:a	()[J
    //   1462: astore 13
    //   1464: aload 11
    //   1466: invokestatic 552	bbct:l	()Ljava/lang/String;
    //   1469: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: ldc_w 357
    //   1475: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: aload 10
    //   1481: astore_3
    //   1482: aload 10
    //   1484: ifnonnull +7 -> 1491
    //   1487: ldc_w 554
    //   1490: astore_3
    //   1491: aload 11
    //   1493: aload_3
    //   1494: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: ldc_w 357
    //   1500: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: pop
    //   1504: aload 11
    //   1506: ldc_w 556
    //   1509: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: aload 13
    //   1514: iconst_0
    //   1515: laload
    //   1516: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1519: ldc_w 558
    //   1522: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: aload 13
    //   1527: iconst_1
    //   1528: laload
    //   1529: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1532: ldc_w 560
    //   1535: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: aload_0
    //   1540: getfield 12	axrm:a	Laxrl;
    //   1543: invokestatic 563	axrl:a	(Laxrl;)Ljava/lang/String;
    //   1546: ifnonnull +945 -> 2491
    //   1549: ldc_w 554
    //   1552: astore_3
    //   1553: aload 11
    //   1555: aload_3
    //   1556: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc_w 357
    //   1562: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1565: pop
    //   1566: aload 11
    //   1568: ldc_w 565
    //   1571: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: getstatic 568	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1577: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1580: ldc_w 357
    //   1583: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: pop
    //   1587: getstatic 572	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1590: astore_3
    //   1591: aload_3
    //   1592: instanceof 567
    //   1595: ifeq +30 -> 1625
    //   1598: aload_3
    //   1599: checkcast 567	com/tencent/mobileqq/activity/SplashActivity
    //   1602: astore_3
    //   1603: aload 11
    //   1605: ldc_w 574
    //   1608: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_3
    //   1612: invokevirtual 575	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1615: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1618: ldc_w 357
    //   1621: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: getstatic 578	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1628: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1631: ifne +24 -> 1655
    //   1634: aload 11
    //   1636: ldc_w 580
    //   1639: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: getstatic 578	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1645: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: ldc_w 357
    //   1651: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: pop
    //   1655: getstatic 583	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1658: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1661: ifne +24 -> 1685
    //   1664: aload 11
    //   1666: ldc_w 585
    //   1669: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: getstatic 583	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1675: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: ldc_w 357
    //   1681: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: pop
    //   1685: getstatic 588	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1688: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1691: ifne +24 -> 1715
    //   1694: aload 11
    //   1696: ldc_w 590
    //   1699: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: getstatic 588	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1705: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: ldc_w 357
    //   1711: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: pop
    //   1715: getstatic 595	com/tencent/common/config/AppSetting:jdField_b_of_type_Boolean	Z
    //   1718: ifne +27 -> 1745
    //   1721: invokestatic 596	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1724: invokestatic 602	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   1727: invokevirtual 605	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   1730: astore_3
    //   1731: aload_3
    //   1732: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1735: ifne +10 -> 1745
    //   1738: aload 11
    //   1740: aload_3
    //   1741: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: pop
    //   1745: aload 11
    //   1747: aload_0
    //   1748: getfield 12	axrm:a	Laxrl;
    //   1751: invokestatic 608	axrl:b	(Laxrl;)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: pop
    //   1761: aload 11
    //   1763: aload_0
    //   1764: getfield 12	axrm:a	Laxrl;
    //   1767: invokestatic 610	axrl:a	(Laxrl;)Ljava/lang/StringBuilder;
    //   1770: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1773: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: pop
    //   1777: getstatic 613	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1780: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1783: ifne +52 -> 1835
    //   1786: getstatic 618	android/os/Build$VERSION:SDK_INT	I
    //   1789: bipush 8
    //   1791: if_icmplt +44 -> 1835
    //   1794: aload 11
    //   1796: new 28	java/lang/StringBuilder
    //   1799: dup
    //   1800: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1803: ldc_w 620
    //   1806: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: getstatic 613	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1812: invokevirtual 624	java/lang/String:getBytes	()[B
    //   1815: iconst_0
    //   1816: invokestatic 630	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1819: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: ldc_w 357
    //   1825: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1831: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: pop
    //   1835: aload 11
    //   1837: invokestatic 635	bhan:a	()Lbhan;
    //   1840: invokevirtual 636	bhan:a	()Ljava/lang/String;
    //   1843: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: pop
    //   1847: aload 11
    //   1849: ldc_w 357
    //   1852: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: pop
    //   1856: aload_0
    //   1857: getfield 12	axrm:a	Laxrl;
    //   1860: invokestatic 639	axrl:a	(Laxrl;)Ljava/util/LinkedList;
    //   1863: invokevirtual 642	java/util/LinkedList:size	()I
    //   1866: ifle +29 -> 1895
    //   1869: aload 11
    //   1871: aload_0
    //   1872: getfield 12	axrm:a	Laxrl;
    //   1875: invokestatic 639	axrl:a	(Laxrl;)Ljava/util/LinkedList;
    //   1878: invokevirtual 646	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1881: checkcast 648	axrn
    //   1884: invokevirtual 649	axrn:toString	()Ljava/lang/String;
    //   1887: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: goto -35 -> 1856
    //   1894: astore_3
    //   1895: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   1898: invokestatic 655	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1901: istore 5
    //   1903: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   1906: invokestatic 660	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1909: istore 8
    //   1911: aload 11
    //   1913: bipush 10
    //   1915: invokevirtual 663	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1918: ldc_w 665
    //   1921: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: astore 10
    //   1926: iload 8
    //   1928: ifne +574 -> 2502
    //   1931: ldc_w 667
    //   1934: astore_3
    //   1935: aload 10
    //   1937: aload_3
    //   1938: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: ldc_w 669
    //   1944: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: iload 5
    //   1949: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1952: ldc_w 671
    //   1955: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: iload 8
    //   1960: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1963: pop
    //   1964: aload 11
    //   1966: ldc_w 673
    //   1969: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   1975: invokestatic 676	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1978: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: pop
    //   1982: aload 11
    //   1984: ldc_w 678
    //   1987: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1990: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   1993: new 60	java/util/Date
    //   1996: dup
    //   1997: getstatic 680	xos:jdField_a_of_type_Long	J
    //   2000: invokespecial 63	java/util/Date:<init>	(J)V
    //   2003: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2006: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: pop
    //   2010: aload 11
    //   2012: ldc_w 682
    //   2015: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   2021: new 60	java/util/Date
    //   2024: dup
    //   2025: getstatic 683	xos:jdField_b_of_type_Long	J
    //   2028: invokespecial 63	java/util/Date:<init>	(J)V
    //   2031: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2034: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2037: ldc_w 357
    //   2040: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: pop
    //   2044: iload_1
    //   2045: ifeq +99 -> 2144
    //   2048: aload 12
    //   2050: ldc_w 387
    //   2053: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2056: ifne +24 -> 2080
    //   2059: aload 12
    //   2061: ldc_w 389
    //   2064: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2067: ifne +13 -> 2080
    //   2070: aload 12
    //   2072: ldc 154
    //   2074: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2077: ifeq +67 -> 2144
    //   2080: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   2083: ldc 26
    //   2085: iconst_4
    //   2086: invokevirtual 687	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2089: ldc_w 689
    //   2092: aconst_null
    //   2093: invokeinterface 695 3 0
    //   2098: astore_3
    //   2099: aload 11
    //   2101: ldc_w 697
    //   2104: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: aload_3
    //   2108: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: pop
    //   2112: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2115: ifeq +29 -> 2144
    //   2118: ldc 26
    //   2120: iconst_2
    //   2121: new 28	java/lang/StringBuilder
    //   2124: dup
    //   2125: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2128: ldc_w 699
    //   2131: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: aload_3
    //   2135: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2141: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2144: aload 12
    //   2146: ldc_w 701
    //   2149: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2152: ifne +80 -> 2232
    //   2155: aload 12
    //   2157: ldc_w 703
    //   2160: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2163: ifne +69 -> 2232
    //   2166: aload 12
    //   2168: ldc_w 705
    //   2171: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2174: ifne +58 -> 2232
    //   2177: aload 12
    //   2179: ldc_w 707
    //   2182: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2185: ifne +47 -> 2232
    //   2188: aload 12
    //   2190: ldc_w 709
    //   2193: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2196: ifne +36 -> 2232
    //   2199: aload 12
    //   2201: ldc_w 711
    //   2204: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2207: ifne +25 -> 2232
    //   2210: aload 12
    //   2212: ldc_w 713
    //   2215: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2218: ifne +14 -> 2232
    //   2221: aload 12
    //   2223: ldc_w 715
    //   2226: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2229: ifeq +56 -> 2285
    //   2232: invokestatic 718	bhdu:a	()Ljava/lang/String;
    //   2235: astore_3
    //   2236: aload_3
    //   2237: ifnull +48 -> 2285
    //   2240: aload 11
    //   2242: ldc_w 720
    //   2245: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: aload_3
    //   2249: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: pop
    //   2253: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2256: ifeq +29 -> 2285
    //   2259: ldc 26
    //   2261: iconst_2
    //   2262: new 28	java/lang/StringBuilder
    //   2265: dup
    //   2266: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2269: ldc_w 722
    //   2272: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: aload_3
    //   2276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2282: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2285: aload 11
    //   2287: ldc_w 724
    //   2290: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2296: getfield 731	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2299: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: pop
    //   2303: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2306: getfield 735	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2309: ifnull +220 -> 2529
    //   2312: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2315: getfield 735	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2318: invokeinterface 739 1 0
    //   2323: ifne +206 -> 2529
    //   2326: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2329: getfield 735	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2332: invokeinterface 743 1 0
    //   2337: astore_3
    //   2338: aload_3
    //   2339: invokeinterface 748 1 0
    //   2344: ifeq +185 -> 2529
    //   2347: aload_3
    //   2348: invokeinterface 751 1 0
    //   2353: checkcast 753	android/util/Pair
    //   2356: astore 10
    //   2358: aload 10
    //   2360: ifnull -22 -> 2338
    //   2363: aload 11
    //   2365: ldc_w 755
    //   2368: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   2374: new 60	java/util/Date
    //   2377: dup
    //   2378: aload 10
    //   2380: getfield 759	android/util/Pair:first	Ljava/lang/Object;
    //   2383: checkcast 761	java/lang/Long
    //   2386: invokevirtual 764	java/lang/Long:longValue	()J
    //   2389: invokespecial 63	java/util/Date:<init>	(J)V
    //   2392: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2395: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: ldc_w 766
    //   2401: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: aload 10
    //   2406: getfield 769	android/util/Pair:second	Ljava/lang/Object;
    //   2409: checkcast 121	java/lang/String
    //   2412: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: pop
    //   2416: goto -78 -> 2338
    //   2419: ldc_w 771
    //   2422: astore 10
    //   2424: goto -2080 -> 344
    //   2427: ldc_w 771
    //   2430: astore 10
    //   2432: goto -1983 -> 449
    //   2435: astore_3
    //   2436: aload_3
    //   2437: invokevirtual 774	java/lang/Throwable:printStackTrace	()V
    //   2440: goto -1680 -> 760
    //   2443: astore 11
    //   2445: aload 10
    //   2447: astore_3
    //   2448: aload 11
    //   2450: astore 10
    //   2452: aload 10
    //   2454: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   2457: aload_3
    //   2458: ifnull -1558 -> 900
    //   2461: aload_3
    //   2462: invokevirtual 366	java/io/FileWriter:close	()V
    //   2465: goto -1565 -> 900
    //   2468: astore_3
    //   2469: goto -1569 -> 900
    //   2472: astore_2
    //   2473: aconst_null
    //   2474: astore_3
    //   2475: aload_3
    //   2476: ifnull +7 -> 2483
    //   2479: aload_3
    //   2480: invokevirtual 366	java/io/FileWriter:close	()V
    //   2483: aload_2
    //   2484: athrow
    //   2485: iconst_0
    //   2486: istore 9
    //   2488: goto -1347 -> 1141
    //   2491: aload_0
    //   2492: getfield 12	axrm:a	Laxrl;
    //   2495: invokestatic 563	axrl:a	(Laxrl;)Ljava/lang/String;
    //   2498: astore_3
    //   2499: goto -946 -> 1553
    //   2502: ldc_w 777
    //   2505: astore_3
    //   2506: goto -571 -> 1935
    //   2509: astore_3
    //   2510: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2513: ifeq -228 -> 2285
    //   2516: ldc 26
    //   2518: iconst_2
    //   2519: ldc_w 779
    //   2522: aload_3
    //   2523: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2526: goto -241 -> 2285
    //   2529: getstatic 785	bdsf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2532: astore_3
    //   2533: aload_3
    //   2534: ifnull +23 -> 2557
    //   2537: aload_3
    //   2538: invokevirtual 788	java/lang/String:length	()I
    //   2541: ifle +16 -> 2557
    //   2544: aload 11
    //   2546: ldc_w 790
    //   2549: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2552: aload_3
    //   2553: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: pop
    //   2557: aload_2
    //   2558: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2561: ifne +49 -> 2610
    //   2564: aload_2
    //   2565: ldc_w 792
    //   2568: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2571: ifeq +39 -> 2610
    //   2574: aload 4
    //   2576: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2579: ifne +31 -> 2610
    //   2582: aload 4
    //   2584: ldc_w 794
    //   2587: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2590: ifeq +20 -> 2610
    //   2593: aload 11
    //   2595: ldc_w 796
    //   2598: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: pop
    //   2602: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2605: aload 11
    //   2607: invokestatic 799	axrl:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2610: ldc_w 801
    //   2613: aload_2
    //   2614: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2617: ifeq +22 -> 2639
    //   2620: aload 4
    //   2622: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2625: ifne +14 -> 2639
    //   2628: aload 4
    //   2630: ldc_w 803
    //   2633: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2636: ifne +32 -> 2668
    //   2639: ldc_w 805
    //   2642: aload_2
    //   2643: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2646: ifeq +40 -> 2686
    //   2649: aload 4
    //   2651: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2654: ifne +32 -> 2686
    //   2657: aload 4
    //   2659: ldc_w 807
    //   2662: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2665: ifeq +21 -> 2686
    //   2668: aload 11
    //   2670: ldc_w 809
    //   2673: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2676: ldc_w 811
    //   2679: invokestatic 814	bbay:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2682: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: pop
    //   2686: ldc_w 816
    //   2689: aload_2
    //   2690: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2693: ifne +64 -> 2757
    //   2696: ldc 138
    //   2698: aload_2
    //   2699: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2702: ifeq +14 -> 2716
    //   2705: aload 4
    //   2707: ldc_w 818
    //   2710: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2713: ifne +44 -> 2757
    //   2716: ldc_w 820
    //   2719: aload_2
    //   2720: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2723: ifeq +14 -> 2737
    //   2726: aload 4
    //   2728: ldc_w 822
    //   2731: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2734: ifne +23 -> 2757
    //   2737: ldc 138
    //   2739: aload_2
    //   2740: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2743: ifeq +92 -> 2835
    //   2746: aload 4
    //   2748: ldc_w 824
    //   2751: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2754: ifeq +81 -> 2835
    //   2757: invokestatic 58	axrl:a	()Ljava/text/SimpleDateFormat;
    //   2760: new 60	java/util/Date
    //   2763: dup
    //   2764: getstatic 825	axrl:jdField_a_of_type_Long	J
    //   2767: invokespecial 63	java/util/Date:<init>	(J)V
    //   2770: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2773: astore_2
    //   2774: aload 11
    //   2776: ldc_w 827
    //   2779: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: getstatic 828	axrl:jdField_a_of_type_Int	I
    //   2785: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2788: ldc_w 830
    //   2791: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: aload_2
    //   2795: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2798: pop
    //   2799: aload 11
    //   2801: ldc_w 832
    //   2804: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 11
    //   2810: invokestatic 834	axrl:d	()Ljava/lang/String;
    //   2813: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: pop
    //   2817: aload 11
    //   2819: ldc_w 836
    //   2822: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2825: pop
    //   2826: aload 11
    //   2828: invokestatic 841	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   2831: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2834: pop
    //   2835: ldc 26
    //   2837: iconst_1
    //   2838: new 28	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 843
    //   2848: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: aload 11
    //   2853: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2856: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2862: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2865: aload 11
    //   2867: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2870: areturn
    //   2871: astore_3
    //   2872: goto -1972 -> 900
    //   2875: astore_3
    //   2876: goto -393 -> 2483
    //   2879: astore_3
    //   2880: goto -194 -> 2686
    //   2883: astore_3
    //   2884: goto -327 -> 2557
    //   2887: astore_3
    //   2888: goto -844 -> 2044
    //   2891: astore_3
    //   2892: goto -910 -> 1982
    //   2895: astore_3
    //   2896: goto -1040 -> 1856
    //   2899: astore_2
    //   2900: goto -425 -> 2475
    //   2903: astore_2
    //   2904: goto -429 -> 2475
    //   2907: astore 10
    //   2909: goto -457 -> 2452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2912	0	this	axrm
    //   0	2912	1	paramBoolean	boolean
    //   0	2912	2	paramString1	String
    //   0	2912	3	paramString2	String
    //   0	2912	4	paramString3	String
    //   0	2912	5	paramInt	int
    //   0	2912	6	paramLong	long
    //   1909	50	8	i	int
    //   1139	1348	9	bool	boolean
    //   342	2111	10	localObject1	Object
    //   2907	1	10	localException1	java.lang.Exception
    //   334	2030	11	localObject2	Object
    //   2443	423	11	localException2	java.lang.Exception
    //   954	1268	12	str	String
    //   1462	64	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1856	1891	1894	java/lang/Throwable
    //   638	717	2435	java/lang/Throwable
    //   721	760	2435	java/lang/Throwable
    //   763	774	2443	java/lang/Exception
    //   778	790	2443	java/lang/Exception
    //   790	825	2443	java/lang/Exception
    //   2461	2465	2468	java/lang/Exception
    //   763	774	2472	finally
    //   778	790	2472	finally
    //   790	825	2472	finally
    //   2144	2232	2509	java/lang/Throwable
    //   2232	2236	2509	java/lang/Throwable
    //   2240	2285	2509	java/lang/Throwable
    //   896	900	2871	java/lang/Exception
    //   2479	2483	2875	java/lang/Exception
    //   2557	2610	2879	java/lang/Throwable
    //   2610	2639	2879	java/lang/Throwable
    //   2639	2668	2879	java/lang/Throwable
    //   2668	2686	2879	java/lang/Throwable
    //   2529	2533	2883	java/lang/Throwable
    //   2537	2557	2883	java/lang/Throwable
    //   1982	2044	2887	java/lang/Throwable
    //   1895	1926	2891	java/lang/Throwable
    //   1935	1982	2891	java/lang/Throwable
    //   1014	1127	2895	java/lang/Throwable
    //   1131	1138	2895	java/lang/Throwable
    //   1141	1315	2895	java/lang/Throwable
    //   1315	1373	2895	java/lang/Throwable
    //   1373	1392	2895	java/lang/Throwable
    //   1396	1445	2895	java/lang/Throwable
    //   1445	1479	2895	java/lang/Throwable
    //   1491	1549	2895	java/lang/Throwable
    //   1553	1625	2895	java/lang/Throwable
    //   1625	1655	2895	java/lang/Throwable
    //   1655	1685	2895	java/lang/Throwable
    //   1685	1715	2895	java/lang/Throwable
    //   1715	1745	2895	java/lang/Throwable
    //   1745	1835	2895	java/lang/Throwable
    //   1835	1856	2895	java/lang/Throwable
    //   2491	2499	2895	java/lang/Throwable
    //   825	892	2899	finally
    //   2452	2457	2903	finally
    //   825	892	2907	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 847
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 849
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 851	axrl:b	()Z
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 851	axrl:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 853	axrl:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   55: ldc 26
    //   57: iconst_4
    //   58: invokevirtual 687	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 857 1 0
    //   66: ldc_w 859
    //   69: iconst_1
    //   70: invokeinterface 865 3 0
    //   75: invokeinterface 868 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 869	axrl:a	()Ljava/lang/String;
    //   88: invokestatic 871	axrl:b	()Ljava/lang/String;
    //   91: invokestatic 874	axrl:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 875	axrl:jdField_b_of_type_Boolean	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 152	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	axrm:a	Laxrl;
    //   111: invokestatic 877	axrl:a	(Laxrl;)V
    //   114: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 880	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	axrm:a	Laxrl;
    //   124: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 883	axrl:a	(Laxrl;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 885
    //   135: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +17 -> 155
    //   141: aload_0
    //   142: getfield 12	axrm:a	Laxrl;
    //   145: invokevirtual 886	axrl:a	()V
    //   148: aload_0
    //   149: getfield 12	axrm:a	Laxrl;
    //   152: invokevirtual 887	axrl:b	()V
    //   155: aload_3
    //   156: ldc_w 387
    //   159: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   162: ifne +22 -> 184
    //   165: aload_3
    //   166: ldc 154
    //   168: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifne +13 -> 184
    //   174: aload_3
    //   175: ldc_w 889
    //   178: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   181: ifeq +18 -> 199
    //   184: aload_0
    //   185: getfield 12	axrm:a	Laxrl;
    //   188: invokevirtual 886	axrl:a	()V
    //   191: aload_0
    //   192: getfield 12	axrm:a	Laxrl;
    //   195: aload_3
    //   196: invokevirtual 891	axrl:b	(Ljava/lang/String;)V
    //   199: aload_3
    //   200: ldc_w 387
    //   203: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   206: ifne +42 -> 248
    //   209: aload_3
    //   210: ldc 154
    //   212: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   215: ifne +33 -> 248
    //   218: aload_3
    //   219: ldc_w 889
    //   222: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   225: ifne +23 -> 248
    //   228: aload_3
    //   229: ldc_w 893
    //   232: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   235: ifne +13 -> 248
    //   238: aload_3
    //   239: ldc_w 389
    //   242: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   245: ifeq +88 -> 333
    //   248: ldc_w 895
    //   251: iconst_0
    //   252: invokestatic 901	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   255: ifeq +78 -> 333
    //   258: ldc 26
    //   260: iconst_1
    //   261: new 28	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 903
    //   271: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   277: ldc2_w 904
    //   280: ldiv
    //   281: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: new 28	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 907
    //   300: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 12	axrm:a	Laxrl;
    //   307: getfield 199	axrl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   319: ldc2_w 904
    //   322: ldiv
    //   323: invokestatic 911	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   326: ldc_w 895
    //   329: iconst_0
    //   330: invokestatic 915	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   333: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   336: invokevirtual 918	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   339: aload_3
    //   340: ldc_w 885
    //   343: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifeq +362 -> 708
    //   349: new 236	android/content/Intent
    //   352: dup
    //   353: ldc_w 920
    //   356: invokespecial 921	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   359: astore 4
    //   361: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   364: ldc_w 923
    //   367: invokevirtual 927	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   370: checkcast 929	android/app/ActivityManager
    //   373: invokevirtual 933	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   376: astore 6
    //   378: new 232	java/util/ArrayList
    //   381: dup
    //   382: invokespecial 934	java/util/ArrayList:<init>	()V
    //   385: astore 5
    //   387: aload 6
    //   389: ifnull +282 -> 671
    //   392: aload 6
    //   394: invokeinterface 937 1 0
    //   399: ifle +272 -> 671
    //   402: aload 6
    //   404: invokeinterface 938 1 0
    //   409: astore 6
    //   411: aload 6
    //   413: invokeinterface 748 1 0
    //   418: ifeq +253 -> 671
    //   421: aload 6
    //   423: invokeinterface 751 1 0
    //   428: checkcast 940	android/app/ActivityManager$RunningAppProcessInfo
    //   431: getfield 941	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   434: astore 7
    //   436: aload 7
    //   438: ifnull -27 -> 411
    //   441: aload 7
    //   443: ldc_w 943
    //   446: invokevirtual 946	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   449: ifeq -38 -> 411
    //   452: aload 7
    //   454: ldc_w 948
    //   457: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   460: ifne -49 -> 411
    //   463: aload 5
    //   465: aload 7
    //   467: invokevirtual 951	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   470: pop
    //   471: goto -60 -> 411
    //   474: astore 4
    //   476: aload 4
    //   478: invokevirtual 774	java/lang/Throwable:printStackTrace	()V
    //   481: aload_3
    //   482: ldc_w 885
    //   485: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifeq +395 -> 883
    //   491: aload_0
    //   492: getfield 12	axrm:a	Laxrl;
    //   495: getfield 953	axrl:jdField_a_of_type_Boolean	Z
    //   498: ifeq +376 -> 874
    //   501: ldc 26
    //   503: iconst_1
    //   504: new 28	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 955
    //   514: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_0
    //   518: getfield 12	axrm:a	Laxrl;
    //   521: getfield 953	axrl:jdField_a_of_type_Boolean	Z
    //   524: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 957
    //   530: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   542: ldc_w 923
    //   545: invokevirtual 927	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   548: checkcast 929	android/app/ActivityManager
    //   551: invokevirtual 933	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   554: astore_3
    //   555: aload_3
    //   556: ifnull +260 -> 816
    //   559: aload_3
    //   560: invokeinterface 937 1 0
    //   565: ifle +251 -> 816
    //   568: aload_3
    //   569: invokeinterface 938 1 0
    //   574: astore_3
    //   575: aload_3
    //   576: invokeinterface 748 1 0
    //   581: ifeq +235 -> 816
    //   584: aload_3
    //   585: invokeinterface 751 1 0
    //   590: checkcast 940	android/app/ActivityManager$RunningAppProcessInfo
    //   593: astore 4
    //   595: aload 4
    //   597: getfield 941	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   600: astore 5
    //   602: aload 5
    //   604: ifnull -29 -> 575
    //   607: aload 5
    //   609: ldc_w 943
    //   612: invokevirtual 946	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   615: ifeq -40 -> 575
    //   618: aload 5
    //   620: ldc_w 948
    //   623: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   626: ifne -51 -> 575
    //   629: aload 4
    //   631: getfield 960	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   634: invokestatic 965	android/os/Process:killProcess	(I)V
    //   637: goto -62 -> 575
    //   640: astore_3
    //   641: aload_3
    //   642: invokevirtual 774	java/lang/Throwable:printStackTrace	()V
    //   645: iconst_1
    //   646: ireturn
    //   647: astore 4
    //   649: aload 4
    //   651: invokevirtual 774	java/lang/Throwable:printStackTrace	()V
    //   654: goto -523 -> 131
    //   657: astore 4
    //   659: ldc 26
    //   661: iconst_1
    //   662: ldc_w 967
    //   665: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: goto -335 -> 333
    //   671: aload 4
    //   673: ldc_w 969
    //   676: aload 5
    //   678: invokevirtual 973	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   681: pop
    //   682: aload 4
    //   684: ldc_w 975
    //   687: aload 5
    //   689: iconst_0
    //   690: invokestatic 979	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   693: invokevirtual 983	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   696: pop
    //   697: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   700: aload 4
    //   702: invokevirtual 261	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   705: goto -224 -> 481
    //   708: aload_3
    //   709: ldc_w 387
    //   712: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   715: ifeq +72 -> 787
    //   718: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   721: ldc_w 923
    //   724: invokevirtual 927	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   727: checkcast 929	android/app/ActivityManager
    //   730: invokevirtual 933	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   733: invokeinterface 938 1 0
    //   738: astore 4
    //   740: aload 4
    //   742: invokeinterface 748 1 0
    //   747: ifeq -266 -> 481
    //   750: aload 4
    //   752: invokeinterface 751 1 0
    //   757: checkcast 940	android/app/ActivityManager$RunningAppProcessInfo
    //   760: astore 5
    //   762: aload 5
    //   764: getfield 941	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   767: ldc_w 985
    //   770: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifeq -33 -> 740
    //   776: aload 5
    //   778: getfield 960	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   781: invokestatic 965	android/os/Process:killProcess	(I)V
    //   784: goto -44 -> 740
    //   787: aload_3
    //   788: ldc_w 987
    //   791: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   794: ifne -313 -> 481
    //   797: aload_3
    //   798: ldc_w 989
    //   801: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   804: ifeq -323 -> 481
    //   807: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   810: invokestatic 994	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   813: goto -332 -> 481
    //   816: invokestatic 105	axrl:a	()Landroid/content/Context;
    //   819: ldc_w 996
    //   822: iconst_0
    //   823: invokevirtual 687	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   826: astore_3
    //   827: aload_3
    //   828: ldc_w 998
    //   831: iconst_0
    //   832: invokeinterface 1002 3 0
    //   837: istore_2
    //   838: aload_3
    //   839: invokeinterface 857 1 0
    //   844: ldc_w 998
    //   847: iload_2
    //   848: iconst_1
    //   849: iadd
    //   850: invokeinterface 1006 3 0
    //   855: invokeinterface 868 1 0
    //   860: pop
    //   861: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   864: iconst_1
    //   865: invokevirtual 1009	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   868: invokestatic 1012	android/os/Process:myPid	()I
    //   871: invokestatic 965	android/os/Process:killProcess	(I)V
    //   874: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   877: iconst_1
    //   878: invokevirtual 1015	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   881: iconst_1
    //   882: ireturn
    //   883: aload_3
    //   884: ldc_w 387
    //   887: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   890: ifne +45 -> 935
    //   893: aload_3
    //   894: ldc_w 1017
    //   897: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   900: ifne +35 -> 935
    //   903: aload_3
    //   904: ldc_w 987
    //   907: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   910: ifne +25 -> 935
    //   913: aload_3
    //   914: ldc_w 701
    //   917: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   920: ifeq +6 -> 926
    //   923: goto +12 -> 935
    //   926: invokestatic 728	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   929: iconst_0
    //   930: invokevirtual 1020	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   933: iconst_1
    //   934: ireturn
    //   935: iload_1
    //   936: ifeq -890 -> 46
    //   939: goto -13 -> 926
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	942	0	this	axrm
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
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + axrl.c() + ", sIsFinalizeTimeoutException=" + axrl.b());
    if ((axrl.c()) && (!axrl.b()) && (!axrl.a(axrl.a(), axrl.b()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + akdh.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = axrl.a(this.a).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)axrl.a(this.a).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            axrl.b(true);
            break;
          }
        }
        axrl.a(this.a).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(axrl.a(this.a).toString());
        axrl.a(this.a, localStringBuilder1.toString());
        axrl.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
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
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + axrl.a().format(new Date(paramLong)) + ", curTime=" + axrl.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      axrl.a(paramBoolean);
      if (!axrl.b()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    baym.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axrm
 * JD-Core Version:    0.7.0.1
 */