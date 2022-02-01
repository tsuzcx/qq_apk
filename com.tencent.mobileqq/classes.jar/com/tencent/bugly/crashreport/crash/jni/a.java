package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public final class a
  implements NativeExceptionHandler
{
  private final Context a;
  private final com.tencent.bugly.crashreport.crash.b b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    x.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  /* Error */
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 45
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload 9
    //   12: invokestatic 50	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 21
    //   17: ldc 52
    //   19: astore 9
    //   21: iload 11
    //   23: ifle +62 -> 85
    //   26: new 54	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   33: astore 9
    //   35: aload 9
    //   37: aload 7
    //   39: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 9
    //   45: ldc 61
    //   47: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 9
    //   53: aload 12
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 9
    //   61: ldc 63
    //   63: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 9
    //   74: ldc 52
    //   76: astore 16
    //   78: ldc 69
    //   80: astore 12
    //   82: goto +85 -> 167
    //   85: iload 13
    //   87: ifle +16 -> 103
    //   90: aload_0
    //   91: getfield 21	com/tencent/bugly/crashreport/crash/jni/a:a	Landroid/content/Context;
    //   94: astore 9
    //   96: iload 13
    //   98: invokestatic 74	com/tencent/bugly/crashreport/common/info/AppInfo:a	(I)Ljava/lang/String;
    //   101: astore 9
    //   103: aload 9
    //   105: iload 13
    //   107: invokestatic 79	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   110: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifne +936 -> 1049
    //   116: new 54	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   123: astore 16
    //   125: aload 16
    //   127: aload 9
    //   129: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 16
    //   135: ldc 61
    //   137: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 16
    //   143: iload 13
    //   145: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 16
    //   151: ldc 63
    //   153: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 16
    //   159: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore 9
    //   164: goto +885 -> 1049
    //   167: new 88	java/util/HashMap
    //   170: dup
    //   171: invokespecial 89	java/util/HashMap:<init>	()V
    //   174: astore 22
    //   176: aload 18
    //   178: ifnull +98 -> 276
    //   181: iconst_0
    //   182: istore_1
    //   183: iload_1
    //   184: aload 18
    //   186: arraylength
    //   187: if_icmpge +99 -> 286
    //   190: aload 18
    //   192: iload_1
    //   193: aaload
    //   194: astore 7
    //   196: aload 7
    //   198: ifnull +862 -> 1060
    //   201: ldc 91
    //   203: iconst_2
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: iload_1
    //   210: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload 7
    //   218: aastore
    //   219: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   222: pop
    //   223: aload 7
    //   225: ldc 98
    //   227: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   230: astore 23
    //   232: aload 23
    //   234: arraylength
    //   235: iconst_2
    //   236: if_icmpne +22 -> 258
    //   239: aload 22
    //   241: aload 23
    //   243: iconst_0
    //   244: aaload
    //   245: aload 23
    //   247: iconst_1
    //   248: aaload
    //   249: invokeinterface 108 3 0
    //   254: pop
    //   255: goto +805 -> 1060
    //   258: ldc 110
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 7
    //   268: aastore
    //   269: invokestatic 112	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   272: pop
    //   273: goto +787 -> 1060
    //   276: ldc 114
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 116	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload 22
    //   288: ldc 118
    //   290: invokeinterface 122 2 0
    //   295: checkcast 76	java/lang/String
    //   298: astore 7
    //   300: aload 7
    //   302: ifnull +765 -> 1067
    //   305: aload 7
    //   307: ldc 124
    //   309: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +755 -> 1067
    //   315: ldc 126
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   324: pop
    //   325: iconst_1
    //   326: istore 19
    //   328: goto +3 -> 331
    //   331: aload 22
    //   333: ldc 128
    //   335: invokeinterface 122 2 0
    //   340: checkcast 76	java/lang/String
    //   343: astore 18
    //   345: aload 18
    //   347: ifnull +32 -> 379
    //   350: aload 18
    //   352: invokevirtual 132	java/lang/String:length	()I
    //   355: ifne +6 -> 361
    //   358: goto +21 -> 379
    //   361: ldc 134
    //   363: iconst_1
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 18
    //   371: aastore
    //   372: invokestatic 116	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   375: pop
    //   376: goto +12 -> 388
    //   379: aload_0
    //   380: getfield 25	com/tencent/bugly/crashreport/crash/jni/a:c	Lcom/tencent/bugly/crashreport/common/info/a;
    //   383: getfield 139	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   386: astore 18
    //   388: aload 22
    //   390: ldc 141
    //   392: invokeinterface 122 2 0
    //   397: checkcast 76	java/lang/String
    //   400: astore 7
    //   402: aload 7
    //   404: ifnull +189 -> 593
    //   407: aload 7
    //   409: invokevirtual 132	java/lang/String:length	()I
    //   412: ifne +6 -> 418
    //   415: goto +178 -> 593
    //   418: ldc 143
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload 7
    //   428: aastore
    //   429: invokestatic 116	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   432: pop
    //   433: invokestatic 149	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   436: invokeinterface 153 1 0
    //   441: invokeinterface 159 1 0
    //   446: astore 24
    //   448: aload 24
    //   450: invokeinterface 165 1 0
    //   455: ifeq +618 -> 1073
    //   458: aload 24
    //   460: invokeinterface 169 1 0
    //   465: checkcast 145	java/lang/Thread
    //   468: astore 23
    //   470: aload 23
    //   472: invokevirtual 172	java/lang/Thread:getName	()Ljava/lang/String;
    //   475: aload 7
    //   477: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   480: ifeq -32 -> 448
    //   483: new 54	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   490: astore 24
    //   492: aload 24
    //   494: aload 7
    //   496: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 24
    //   502: ldc 61
    //   504: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 24
    //   510: aload 23
    //   512: invokevirtual 176	java/lang/Thread:getId	()J
    //   515: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 24
    //   521: ldc 63
    //   523: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 24
    //   529: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: astore 7
    //   534: iconst_1
    //   535: istore_1
    //   536: goto +3 -> 539
    //   539: iload_1
    //   540: ifne +538 -> 1078
    //   543: new 54	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   550: astore 23
    //   552: aload 23
    //   554: aload 7
    //   556: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 23
    //   562: ldc 61
    //   564: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 23
    //   570: iload_2
    //   571: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 23
    //   577: ldc 63
    //   579: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 23
    //   585: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: astore 7
    //   590: goto +491 -> 1081
    //   593: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   596: astore 7
    //   598: new 54	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   605: astore 23
    //   607: aload 23
    //   609: aload 7
    //   611: invokevirtual 172	java/lang/Thread:getName	()Ljava/lang/String;
    //   614: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 23
    //   620: ldc 61
    //   622: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 23
    //   628: aload 7
    //   630: invokevirtual 176	java/lang/Thread:getId	()J
    //   633: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 23
    //   639: ldc 63
    //   641: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload 23
    //   647: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: astore 7
    //   652: goto +429 -> 1081
    //   655: lload 5
    //   657: ldc2_w 184
    //   660: ldiv
    //   661: lstore 5
    //   663: aload 22
    //   665: ldc 187
    //   667: invokeinterface 122 2 0
    //   672: checkcast 76	java/lang/String
    //   675: astore 23
    //   677: aload 22
    //   679: ldc 189
    //   681: invokeinterface 122 2 0
    //   686: checkcast 76	java/lang/String
    //   689: astore 22
    //   691: aload_0
    //   692: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   695: invokevirtual 193	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   698: ifne +13 -> 711
    //   701: ldc 195
    //   703: iconst_0
    //   704: anewarray 4	java/lang/Object
    //   707: invokestatic 112	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   710: pop
    //   711: aload_0
    //   712: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   715: invokevirtual 198	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   718: getfield 204	com/tencent/bugly/crashreport/common/strategy/StrategyBean:f	Z
    //   721: istore 20
    //   723: iload 20
    //   725: ifne +100 -> 825
    //   728: aload_0
    //   729: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   732: invokevirtual 193	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   735: ifeq +90 -> 825
    //   738: ldc 206
    //   740: iconst_0
    //   741: anewarray 4	java/lang/Object
    //   744: invokestatic 209	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   747: pop
    //   748: invokestatic 213	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   751: astore 12
    //   753: new 54	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   760: astore 16
    //   762: aload 16
    //   764: aload 9
    //   766: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 16
    //   772: ldc 215
    //   774: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 16
    //   780: aload 8
    //   782: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 16
    //   788: ldc 215
    //   790: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload 16
    //   796: aload 21
    //   798: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: ldc 217
    //   804: aload 12
    //   806: aload 18
    //   808: aload 7
    //   810: aload 16
    //   812: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: aconst_null
    //   816: invokestatic 222	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   819: aload 10
    //   821: invokestatic 225	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;)V
    //   824: return
    //   825: aload_0
    //   826: aload 18
    //   828: aload 7
    //   830: lload_3
    //   831: ldc2_w 184
    //   834: lmul
    //   835: lload 5
    //   837: ladd
    //   838: aload 9
    //   840: aload 8
    //   842: aload 21
    //   844: aload 12
    //   846: aload 16
    //   848: aload 10
    //   850: aload 23
    //   852: aload 22
    //   854: aload 17
    //   856: aconst_null
    //   857: aconst_null
    //   858: iconst_1
    //   859: iload 19
    //   861: invokevirtual 229	com/tencent/bugly/crashreport/crash/jni/a:packageCrashDatas	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;ZZ)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   864: astore 10
    //   866: aload 10
    //   868: ifnonnull +14 -> 882
    //   871: ldc 231
    //   873: iconst_0
    //   874: anewarray 4	java/lang/Object
    //   877: invokestatic 209	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   880: pop
    //   881: return
    //   882: iconst_0
    //   883: istore_1
    //   884: invokestatic 213	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   887: astore 12
    //   889: new 54	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   896: astore 16
    //   898: aload 16
    //   900: aload 9
    //   902: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 16
    //   908: ldc 215
    //   910: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 16
    //   916: aload 8
    //   918: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 16
    //   924: ldc 215
    //   926: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 16
    //   932: aload 21
    //   934: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: ldc 217
    //   940: aload 12
    //   942: aload 18
    //   944: aload 7
    //   946: aload 16
    //   948: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: aload 10
    //   953: invokestatic 222	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   956: aload_0
    //   957: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   960: aload 10
    //   962: invokevirtual 234	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   965: ifne +5 -> 970
    //   968: iconst_1
    //   969: istore_1
    //   970: aconst_null
    //   971: astore 7
    //   973: invokestatic 240	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getInstance	()Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   976: astore 8
    //   978: aload 8
    //   980: ifnull +10 -> 990
    //   983: aload 8
    //   985: invokevirtual 243	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getDumpFilePath	()Ljava/lang/String;
    //   988: astore 7
    //   990: iconst_1
    //   991: aload 7
    //   993: invokestatic 246	com/tencent/bugly/crashreport/crash/jni/b:a	(ZLjava/lang/String;)V
    //   996: iload_1
    //   997: ifeq +16 -> 1013
    //   1000: aload_0
    //   1001: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   1004: aload 10
    //   1006: ldc2_w 247
    //   1009: iconst_1
    //   1010: invokevirtual 251	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1013: aload_0
    //   1014: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   1017: aload 10
    //   1019: invokevirtual 254	com/tencent/bugly/crashreport/crash/b:c	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1022: return
    //   1023: astore 7
    //   1025: goto +10 -> 1035
    //   1028: astore 7
    //   1030: goto +5 -> 1035
    //   1033: astore 7
    //   1035: aload 7
    //   1037: invokestatic 257	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   1040: ifne +8 -> 1048
    //   1043: aload 7
    //   1045: invokevirtual 260	java/lang/Throwable:printStackTrace	()V
    //   1048: return
    //   1049: aload 9
    //   1051: astore 16
    //   1053: aload 7
    //   1055: astore 9
    //   1057: goto -890 -> 167
    //   1060: iload_1
    //   1061: iconst_1
    //   1062: iadd
    //   1063: istore_1
    //   1064: goto -881 -> 183
    //   1067: iconst_0
    //   1068: istore 19
    //   1070: goto -739 -> 331
    //   1073: iconst_0
    //   1074: istore_1
    //   1075: goto -536 -> 539
    //   1078: goto -423 -> 655
    //   1081: goto -426 -> 655
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1084	0	this	a
    //   0	1084	1	paramInt1	int
    //   0	1084	2	paramInt2	int
    //   0	1084	3	paramLong1	long
    //   0	1084	5	paramLong2	long
    //   0	1084	7	paramString1	String
    //   0	1084	8	paramString2	String
    //   0	1084	9	paramString3	String
    //   0	1084	10	paramString4	String
    //   0	1084	11	paramInt3	int
    //   0	1084	12	paramString5	String
    //   0	1084	13	paramInt4	int
    //   0	1084	14	paramInt5	int
    //   0	1084	15	paramInt6	int
    //   0	1084	16	paramString6	String
    //   0	1084	17	paramString7	String
    //   0	1084	18	paramArrayOfString	String[]
    //   326	743	19	bool1	boolean
    //   721	3	20	bool2	boolean
    //   15	918	21	str	String
    //   174	679	22	localObject1	Object
    //   230	621	23	localObject2	Object
    //   446	82	24	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   956	968	1023	java/lang/Throwable
    //   973	978	1023	java/lang/Throwable
    //   983	990	1023	java/lang/Throwable
    //   990	996	1023	java/lang/Throwable
    //   1000	1013	1023	java/lang/Throwable
    //   1013	1022	1023	java/lang/Throwable
    //   825	866	1028	java/lang/Throwable
    //   871	881	1028	java/lang/Throwable
    //   884	956	1028	java/lang/Throwable
    //   10	17	1033	java/lang/Throwable
    //   26	74	1033	java/lang/Throwable
    //   90	103	1033	java/lang/Throwable
    //   103	164	1033	java/lang/Throwable
    //   167	176	1033	java/lang/Throwable
    //   183	190	1033	java/lang/Throwable
    //   201	255	1033	java/lang/Throwable
    //   258	273	1033	java/lang/Throwable
    //   276	286	1033	java/lang/Throwable
    //   286	300	1033	java/lang/Throwable
    //   305	325	1033	java/lang/Throwable
    //   331	345	1033	java/lang/Throwable
    //   350	358	1033	java/lang/Throwable
    //   361	376	1033	java/lang/Throwable
    //   379	388	1033	java/lang/Throwable
    //   388	402	1033	java/lang/Throwable
    //   407	415	1033	java/lang/Throwable
    //   418	448	1033	java/lang/Throwable
    //   448	534	1033	java/lang/Throwable
    //   543	590	1033	java/lang/Throwable
    //   593	652	1033	java/lang/Throwable
    //   655	711	1033	java/lang/Throwable
    //   711	723	1033	java/lang/Throwable
    //   728	824	1033	java/lang/Throwable
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = c.a().h();
    if (paramBoolean2) {
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.b = 1;
    localCrashDetailBean.e = this.c.g();
    localCrashDetailBean.f = this.c.m;
    localCrashDetailBean.g = this.c.u();
    localCrashDetailBean.m = this.c.f();
    localCrashDetailBean.n = paramString3;
    String str = "";
    if (paramBoolean2) {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      paramString3 = "";
    }
    localCrashDetailBean.o = paramString3;
    localCrashDetailBean.p = paramString4;
    if (paramString5 == null) {
      paramString5 = str;
    }
    localCrashDetailBean.q = paramString5;
    localCrashDetailBean.r = paramLong;
    localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
    localCrashDetailBean.A = paramString1;
    localCrashDetailBean.B = paramString2;
    localCrashDetailBean.I = this.c.w();
    localCrashDetailBean.h = this.c.t();
    localCrashDetailBean.i = this.c.H();
    localCrashDetailBean.v = paramString8;
    paramString2 = NativeCrashHandler.getInstance();
    if (paramString2 != null) {
      paramString2 = paramString2.getDumpFilePath();
    } else {
      paramString2 = null;
    }
    paramString3 = b.a(paramString2, paramString8);
    if (!z.a(paramString3)) {
      localCrashDetailBean.V = paramString3;
    }
    localCrashDetailBean.W = b.b(paramString2);
    localCrashDetailBean.w = b.a(paramString9, c.e, c.h, c.m);
    localCrashDetailBean.x = b.a(paramString10, c.e, null, true);
    localCrashDetailBean.J = paramString7;
    localCrashDetailBean.K = paramString6;
    localCrashDetailBean.L = paramString11;
    localCrashDetailBean.F = this.c.n();
    localCrashDetailBean.G = this.c.m();
    localCrashDetailBean.H = this.c.o();
    if (paramBoolean1)
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
      if (localCrashDetailBean.w == null) {
        localCrashDetailBean.w = z.a(this.a, c.e, c.h);
      }
      localCrashDetailBean.y = y.a();
      localCrashDetailBean.M = this.c.a;
      localCrashDetailBean.N = this.c.a();
      localCrashDetailBean.z = z.a(c.f, false);
      int i = localCrashDetailBean.q.indexOf("java:\n");
      if (i > 0)
      {
        i += 6;
        if (i < localCrashDetailBean.q.length())
        {
          paramString2 = localCrashDetailBean.q.substring(i, localCrashDetailBean.q.length() - 1);
          if ((paramString2.length() > 0) && (localCrashDetailBean.z.containsKey(localCrashDetailBean.B)))
          {
            paramString3 = (String)localCrashDetailBean.z.get(localCrashDetailBean.B);
            int j = paramString3.indexOf(paramString2);
            if (j > 0)
            {
              paramString2 = paramString3.substring(j);
              localCrashDetailBean.z.put(localCrashDetailBean.B, paramString2);
              localCrashDetailBean.q = localCrashDetailBean.q.substring(0, i);
              paramString3 = new StringBuilder();
              paramString3.append(localCrashDetailBean.q);
              paramString3.append(paramString2);
              localCrashDetailBean.q = paramString3.toString();
            }
          }
        }
      }
      if (paramString1 == null) {
        localCrashDetailBean.A = this.c.d;
      }
      this.b.d(localCrashDetailBean);
      localCrashDetailBean.Q = this.c.F();
      localCrashDetailBean.R = this.c.G();
      localCrashDetailBean.S = this.c.z();
      localCrashDetailBean.T = this.c.E();
      return localCrashDetailBean;
    }
    localCrashDetailBean.C = -1L;
    localCrashDetailBean.D = -1L;
    localCrashDetailBean.E = -1L;
    if (localCrashDetailBean.w == null) {
      localCrashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
    }
    localCrashDetailBean.M = -1L;
    localCrashDetailBean.Q = -1;
    localCrashDetailBean.R = -1;
    localCrashDetailBean.S = paramMap;
    localCrashDetailBean.T = this.c.E();
    localCrashDetailBean.z = null;
    if (paramString1 == null) {
      localCrashDetailBean.A = "unknown(record)";
    }
    if (paramArrayOfByte != null) {
      localCrashDetailBean.y = paramArrayOfByte;
    }
    return localCrashDetailBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.a
 * JD-Core Version:    0.7.0.1
 */