package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.biz.UserInfoBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected String b;
  i c;
  private HashMap<String, Object> d;
  
  a()
  {
    new HashMap();
    this.d = new HashMap();
    this.b = "GBK";
    this.c = new i();
  }
  
  /* Error */
  public static am a(android.content.Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   3: astore 5
    //   5: invokestatic 47	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   8: invokevirtual 50	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   11: astore 6
    //   13: aload 5
    //   15: ifnull +8 -> 23
    //   18: aload 6
    //   20: ifnonnull +15 -> 35
    //   23: ldc 52
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 58	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   32: pop
    //   33: aconst_null
    //   34: areturn
    //   35: new 60	com/tencent/bugly/proguard/am
    //   38: dup
    //   39: invokespecial 61	com/tencent/bugly/proguard/am:<init>	()V
    //   42: astore 4
    //   44: aload 5
    //   46: monitorenter
    //   47: aload 4
    //   49: iconst_1
    //   50: putfield 64	com/tencent/bugly/proguard/am:a	I
    //   53: aload 4
    //   55: aload 5
    //   57: invokevirtual 67	com/tencent/bugly/crashreport/common/info/a:e	()Ljava/lang/String;
    //   60: putfield 68	com/tencent/bugly/proguard/am:b	Ljava/lang/String;
    //   63: aload 4
    //   65: aload 5
    //   67: getfield 70	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   70: putfield 71	com/tencent/bugly/proguard/am:c	Ljava/lang/String;
    //   73: aload 4
    //   75: aload 5
    //   77: getfield 74	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   80: putfield 76	com/tencent/bugly/proguard/am:d	Ljava/lang/String;
    //   83: aload 4
    //   85: aload 5
    //   87: getfield 79	com/tencent/bugly/crashreport/common/info/a:o	Ljava/lang/String;
    //   90: putfield 81	com/tencent/bugly/proguard/am:e	Ljava/lang/String;
    //   93: aload 4
    //   95: aload 5
    //   97: getfield 84	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   100: putfield 87	com/tencent/bugly/proguard/am:f	Ljava/lang/String;
    //   103: aload 4
    //   105: iload_1
    //   106: putfield 89	com/tencent/bugly/proguard/am:g	I
    //   109: aload_2
    //   110: astore_3
    //   111: aload_2
    //   112: ifnonnull +9 -> 121
    //   115: ldc 91
    //   117: invokevirtual 97	java/lang/String:getBytes	()[B
    //   120: astore_3
    //   121: aload 4
    //   123: aload_3
    //   124: putfield 101	com/tencent/bugly/proguard/am:h	[B
    //   127: aload 4
    //   129: aload 5
    //   131: getfield 104	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   134: putfield 105	com/tencent/bugly/proguard/am:i	Ljava/lang/String;
    //   137: aload 4
    //   139: aload 5
    //   141: getfield 108	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   144: putfield 109	com/tencent/bugly/proguard/am:j	Ljava/lang/String;
    //   147: aload 4
    //   149: new 19	java/util/HashMap
    //   152: dup
    //   153: invokespecial 20	java/util/HashMap:<init>	()V
    //   156: putfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   159: aload 4
    //   161: aload 5
    //   163: invokevirtual 115	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   166: putfield 118	com/tencent/bugly/proguard/am:l	Ljava/lang/String;
    //   169: aload 4
    //   171: aload 6
    //   173: getfield 123	com/tencent/bugly/crashreport/common/strategy/StrategyBean:o	J
    //   176: putfield 125	com/tencent/bugly/proguard/am:m	J
    //   179: aload 4
    //   181: aload 5
    //   183: invokevirtual 127	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   186: putfield 128	com/tencent/bugly/proguard/am:o	Ljava/lang/String;
    //   189: aload 4
    //   191: aload_0
    //   192: invokestatic 133	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   195: putfield 136	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   198: aload 4
    //   200: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   203: putfield 145	com/tencent/bugly/proguard/am:q	J
    //   206: aload 4
    //   208: new 147	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   215: aload 5
    //   217: invokevirtual 150	com/tencent/bugly/crashreport/common/info/a:j	()Ljava/lang/String;
    //   220: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: putfield 160	com/tencent/bugly/proguard/am:r	Ljava/lang/String;
    //   229: aload 4
    //   231: aload 5
    //   233: invokevirtual 162	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   236: putfield 165	com/tencent/bugly/proguard/am:s	Ljava/lang/String;
    //   239: aload 4
    //   241: new 147	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   248: aload 5
    //   250: invokevirtual 167	com/tencent/bugly/crashreport/common/info/a:l	()Ljava/lang/String;
    //   253: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: putfield 170	com/tencent/bugly/proguard/am:t	Ljava/lang/String;
    //   262: aload 4
    //   264: aload 5
    //   266: invokevirtual 172	com/tencent/bugly/crashreport/common/info/a:k	()Ljava/lang/String;
    //   269: putfield 175	com/tencent/bugly/proguard/am:u	Ljava/lang/String;
    //   272: aload 4
    //   274: new 147	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   281: aload 5
    //   283: invokevirtual 127	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   286: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: putfield 178	com/tencent/bugly/proguard/am:v	Ljava/lang/String;
    //   295: aload 4
    //   297: aload 4
    //   299: getfield 136	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   302: putfield 181	com/tencent/bugly/proguard/am:w	Ljava/lang/String;
    //   305: aload 5
    //   307: invokevirtual 185	java/lang/Object:getClass	()Ljava/lang/Class;
    //   310: pop
    //   311: aload 4
    //   313: ldc 187
    //   315: putfield 190	com/tencent/bugly/proguard/am:n	Ljava/lang/String;
    //   318: aload 4
    //   320: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   323: ldc 192
    //   325: new 147	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   332: aload 5
    //   334: invokevirtual 194	com/tencent/bugly/crashreport/common/info/a:w	()Ljava/lang/String;
    //   337: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokeinterface 200 3 0
    //   348: pop
    //   349: aload 4
    //   351: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   354: ldc 202
    //   356: new 147	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   363: aload 5
    //   365: invokevirtual 205	com/tencent/bugly/crashreport/common/info/a:x	()Ljava/lang/String;
    //   368: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokeinterface 200 3 0
    //   379: pop
    //   380: aload 4
    //   382: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   385: ldc 207
    //   387: new 147	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   394: aload 5
    //   396: invokevirtual 210	com/tencent/bugly/crashreport/common/info/a:y	()Ljava/lang/String;
    //   399: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokeinterface 200 3 0
    //   410: pop
    //   411: aload 4
    //   413: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   416: ldc 212
    //   418: new 147	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   425: aload 5
    //   427: invokevirtual 216	com/tencent/bugly/crashreport/common/info/a:P	()Z
    //   430: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   433: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokeinterface 200 3 0
    //   441: pop
    //   442: aload 4
    //   444: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   447: ldc 221
    //   449: new 147	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   456: aload 5
    //   458: invokevirtual 224	com/tencent/bugly/crashreport/common/info/a:Q	()Z
    //   461: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokeinterface 200 3 0
    //   472: pop
    //   473: aload 4
    //   475: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   478: ldc 226
    //   480: new 147	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   487: aload 5
    //   489: getfield 230	com/tencent/bugly/crashreport/common/info/a:B	Z
    //   492: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   495: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokeinterface 200 3 0
    //   503: pop
    //   504: aload 4
    //   506: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   509: ldc 232
    //   511: new 147	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   518: aload 5
    //   520: getfield 235	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   523: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokeinterface 200 3 0
    //   534: pop
    //   535: aload 4
    //   537: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   540: ldc 237
    //   542: new 147	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   549: aload 5
    //   551: invokevirtual 239	com/tencent/bugly/crashreport/common/info/a:s	()Ljava/lang/String;
    //   554: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokeinterface 200 3 0
    //   565: pop
    //   566: aload 4
    //   568: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   571: ldc 241
    //   573: new 147	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   580: aload 5
    //   582: invokevirtual 244	com/tencent/bugly/crashreport/common/info/a:R	()Ljava/lang/String;
    //   585: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokeinterface 200 3 0
    //   596: pop
    //   597: aload 5
    //   599: getfield 247	com/tencent/bugly/crashreport/common/info/a:C	Z
    //   602: ifeq +196 -> 798
    //   605: aload 4
    //   607: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   610: ldc 249
    //   612: new 147	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   619: aload 5
    //   621: invokevirtual 251	com/tencent/bugly/crashreport/common/info/a:J	()Ljava/lang/String;
    //   624: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokeinterface 200 3 0
    //   635: pop
    //   636: aload 4
    //   638: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   641: ldc 253
    //   643: new 147	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   650: aload 5
    //   652: invokevirtual 256	com/tencent/bugly/crashreport/common/info/a:K	()Ljava/lang/String;
    //   655: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokeinterface 200 3 0
    //   666: pop
    //   667: aload 4
    //   669: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   672: ldc_w 258
    //   675: new 147	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   682: aload 5
    //   684: invokevirtual 261	com/tencent/bugly/crashreport/common/info/a:L	()Ljava/lang/String;
    //   687: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokeinterface 200 3 0
    //   698: pop
    //   699: aload 4
    //   701: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   704: ldc_w 263
    //   707: new 147	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   714: aload 5
    //   716: invokevirtual 266	com/tencent/bugly/crashreport/common/info/a:M	()Ljava/lang/String;
    //   719: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokeinterface 200 3 0
    //   730: pop
    //   731: aload 4
    //   733: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   736: ldc_w 268
    //   739: new 147	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   746: aload 5
    //   748: invokevirtual 271	com/tencent/bugly/crashreport/common/info/a:N	()Ljava/lang/String;
    //   751: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokeinterface 200 3 0
    //   762: pop
    //   763: aload 4
    //   765: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   768: ldc_w 273
    //   771: new 147	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   778: aload 5
    //   780: invokevirtual 276	com/tencent/bugly/crashreport/common/info/a:O	()J
    //   783: invokestatic 281	java/lang/Long:toString	(J)Ljava/lang/String;
    //   786: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokeinterface 200 3 0
    //   797: pop
    //   798: aload 4
    //   800: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   803: ldc_w 283
    //   806: new 147	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   813: aload 5
    //   815: getfield 284	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   818: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokeinterface 200 3 0
    //   829: pop
    //   830: getstatic 289	com/tencent/bugly/b:b	Ljava/util/List;
    //   833: ifnull +87 -> 920
    //   836: getstatic 289	com/tencent/bugly/b:b	Ljava/util/List;
    //   839: invokeinterface 295 1 0
    //   844: astore_0
    //   845: aload_0
    //   846: invokeinterface 300 1 0
    //   851: ifeq +69 -> 920
    //   854: aload_0
    //   855: invokeinterface 304 1 0
    //   860: checkcast 306	com/tencent/bugly/a
    //   863: astore_2
    //   864: aload_2
    //   865: getfield 309	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   868: ifnull -23 -> 845
    //   871: aload_2
    //   872: getfield 312	com/tencent/bugly/a:version	Ljava/lang/String;
    //   875: ifnull -30 -> 845
    //   878: aload 4
    //   880: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   883: aload_2
    //   884: getfield 309	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   887: aload_2
    //   888: getfield 312	com/tencent/bugly/a:version	Ljava/lang/String;
    //   891: invokeinterface 200 3 0
    //   896: pop
    //   897: goto -52 -> 845
    //   900: astore_0
    //   901: aload 5
    //   903: monitorexit
    //   904: aload_0
    //   905: athrow
    //   906: astore_0
    //   907: aload_0
    //   908: invokestatic 315	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   911: ifne +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 318	java/lang/Throwable:printStackTrace	()V
    //   918: aconst_null
    //   919: areturn
    //   920: aload 4
    //   922: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   925: ldc_w 320
    //   928: ldc_w 320
    //   931: ldc 91
    //   933: invokestatic 325	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   936: invokeinterface 200 3 0
    //   941: pop
    //   942: aload 4
    //   944: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   947: ldc_w 327
    //   950: ldc_w 327
    //   953: ldc_w 329
    //   956: invokestatic 325	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   959: invokeinterface 200 3 0
    //   964: pop
    //   965: aload 5
    //   967: monitorexit
    //   968: aload 5
    //   970: invokevirtual 333	com/tencent/bugly/crashreport/common/info/a:D	()Ljava/util/Map;
    //   973: astore_0
    //   974: aload_0
    //   975: ifnull +60 -> 1035
    //   978: aload_0
    //   979: invokeinterface 337 1 0
    //   984: invokeinterface 340 1 0
    //   989: astore_0
    //   990: aload_0
    //   991: invokeinterface 300 1 0
    //   996: ifeq +39 -> 1035
    //   999: aload_0
    //   1000: invokeinterface 304 1 0
    //   1005: checkcast 342	java/util/Map$Entry
    //   1008: astore_2
    //   1009: aload 4
    //   1011: getfield 113	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   1014: aload_2
    //   1015: invokeinterface 345 1 0
    //   1020: aload_2
    //   1021: invokeinterface 348 1 0
    //   1026: invokeinterface 200 3 0
    //   1031: pop
    //   1032: goto -42 -> 990
    //   1035: aload 4
    //   1037: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1038	0	paramContext	android.content.Context
    //   0	1038	1	paramInt	int
    //   0	1038	2	paramArrayOfByte	byte[]
    //   110	14	3	arrayOfByte	byte[]
    //   42	994	4	localam	am
    //   3	966	5	locala	com.tencent.bugly.crashreport.common.info.a
    //   11	161	6	localStrategyBean	com.tencent.bugly.crashreport.common.strategy.StrategyBean
    // Exception table:
    //   from	to	target	type
    //   47	109	900	finally
    //   115	121	900	finally
    //   121	798	900	finally
    //   798	845	900	finally
    //   845	897	900	finally
    //   920	968	900	finally
    //   35	47	906	java/lang/Throwable
    //   901	906	906	java/lang/Throwable
    //   968	974	906	java/lang/Throwable
    //   978	990	906	java/lang/Throwable
    //   990	1032	906	java/lang/Throwable
  }
  
  public static aq a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    aq localaq = new aq();
    localaq.a = paramUserInfoBean.e;
    localaq.e = paramUserInfoBean.j;
    localaq.d = paramUserInfoBean.c;
    localaq.c = paramUserInfoBean.d;
    localaq.g = com.tencent.bugly.crashreport.common.info.a.b().h();
    if (paramUserInfoBean.o == 1)
    {
      bool = true;
      localaq.h = bool;
      switch (paramUserInfoBean.b)
      {
      default: 
        if ((paramUserInfoBean.b < 10) || (paramUserInfoBean.b >= 20)) {
          break;
        }
        localaq.b = ((byte)paramUserInfoBean.b);
      }
    }
    else
    {
      for (;;)
      {
        localaq.f = new HashMap();
        if (paramUserInfoBean.p >= 0) {
          localaq.f.put("C01", paramUserInfoBean.p);
        }
        if (paramUserInfoBean.q >= 0) {
          localaq.f.put("C02", paramUserInfoBean.q);
        }
        if ((paramUserInfoBean.r == null) || (paramUserInfoBean.r.size() <= 0)) {
          break label376;
        }
        localObject1 = paramUserInfoBean.r.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localaq.f.put("C03_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
        bool = false;
        break;
        localaq.b = 1;
        continue;
        localaq.b = 2;
        continue;
        localaq.b = 4;
        continue;
        localaq.b = 3;
      }
    }
    x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
    return null;
    label376:
    if ((paramUserInfoBean.s != null) && (paramUserInfoBean.s.size() > 0))
    {
      localObject1 = paramUserInfoBean.s.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localaq.f.put("C04_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = localaq.f;
    Object localObject2 = new StringBuilder();
    if (!paramUserInfoBean.l) {}
    for (boolean bool = true;; bool = false)
    {
      ((Map)localObject1).put("A36", bool);
      localaq.f.put("F02", paramUserInfoBean.g);
      localaq.f.put("F03", paramUserInfoBean.h);
      localaq.f.put("F04", paramUserInfoBean.j);
      localaq.f.put("F05", paramUserInfoBean.i);
      localaq.f.put("F06", paramUserInfoBean.m);
      localaq.f.put("F10", paramUserInfoBean.k);
      x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localaq.b), Integer.valueOf(localaq.f.size()) });
      return localaq;
    }
  }
  
  public static ar a(List<UserInfoBean> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
    if (localObject == null) {
      return null;
    }
    ((com.tencent.bugly.crashreport.common.info.a)localObject).r();
    ar localar = new ar();
    localar.b = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localar.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).g();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aq localaq = a((UserInfoBean)paramList.next());
      if (localaq != null) {
        localArrayList.add(localaq);
      }
    }
    localar.d = localArrayList;
    localar.e = new HashMap();
    localar.e.put("A7", ((com.tencent.bugly.crashreport.common.info.a)localObject).h);
    localar.e.put("A6", ((com.tencent.bugly.crashreport.common.info.a)localObject).q());
    localar.e.put("A5", ((com.tencent.bugly.crashreport.common.info.a)localObject).p());
    localar.e.put("A2", ((com.tencent.bugly.crashreport.common.info.a)localObject).n());
    localar.e.put("A1", ((com.tencent.bugly.crashreport.common.info.a)localObject).n());
    localar.e.put("A24", ((com.tencent.bugly.crashreport.common.info.a)localObject).j);
    localar.e.put("A17", ((com.tencent.bugly.crashreport.common.info.a)localObject).o());
    localar.e.put("A15", ((com.tencent.bugly.crashreport.common.info.a)localObject).u());
    localar.e.put("A13", ((com.tencent.bugly.crashreport.common.info.a)localObject).v());
    localar.e.put("F08", ((com.tencent.bugly.crashreport.common.info.a)localObject).x);
    localar.e.put("F09", ((com.tencent.bugly.crashreport.common.info.a)localObject).y);
    paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject).E();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        localar.e.put("C04_" + (String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
    }
    switch (paramInt)
    {
    default: 
      x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    for (localar.a = 1;; localar.a = 2) {
      return localar;
    }
  }
  
  public static <T extends k> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    try
    {
      paramClass = (k)paramClass.newInstance();
      paramArrayOfByte = new i(paramArrayOfByte);
      paramArrayOfByte.a("utf-8");
      paramClass.a(paramArrayOfByte);
      return paramClass;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.b(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    String str1;
    if (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      if ((str2.equals("java.lang.Integer")) || (str2.equals("int"))) {
        str1 = "int32";
      }
      for (;;)
      {
        paramArrayList.set(i, str1);
        i += 1;
        break;
        if ((str2.equals("java.lang.Boolean")) || (str2.equals("boolean")))
        {
          str1 = "bool";
        }
        else if ((str2.equals("java.lang.Byte")) || (str2.equals("byte")))
        {
          str1 = "char";
        }
        else if ((str2.equals("java.lang.Double")) || (str2.equals("double")))
        {
          str1 = "double";
        }
        else if ((str2.equals("java.lang.Float")) || (str2.equals("float")))
        {
          str1 = "float";
        }
        else if ((str2.equals("java.lang.Long")) || (str2.equals("long")))
        {
          str1 = "int64";
        }
        else if ((str2.equals("java.lang.Short")) || (str2.equals("short")))
        {
          str1 = "short";
        }
        else
        {
          if (str2.equals("java.lang.Character")) {
            throw new IllegalArgumentException("can not support java.lang.Character");
          }
          if (str2.equals("java.lang.String"))
          {
            str1 = "string";
          }
          else if (str2.equals("java.util.List"))
          {
            str1 = "list";
          }
          else
          {
            str1 = str2;
            if (str2.equals("java.util.Map")) {
              str1 = "map";
            }
          }
        }
      }
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      str1 = (String)paramArrayList.get(i);
      if (str1.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str1.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str1.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
        throw new IllegalArgumentException("only byte[] is supported");
      }
      if (Array.getLength(paramObject) > 0)
      {
        paramArrayList.add("java.util.List");
        a(paramArrayList, Array.get(paramObject, 0));
        return;
      }
      paramArrayList.add("Array");
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Array)) {
      throw new IllegalArgumentException("can not support Array, please use List");
    }
    if ((paramObject instanceof List))
    {
      paramArrayList.add("java.util.List");
      paramObject = (List)paramObject;
      if (paramObject.size() > 0)
      {
        a(paramArrayList, paramObject.get(0));
        return;
      }
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramArrayList.add("java.util.Map");
      Object localObject = (Map)paramObject;
      if (((Map)localObject).size() > 0)
      {
        paramObject = ((Map)localObject).keySet().iterator().next();
        localObject = ((Map)localObject).get(paramObject);
        paramArrayList.add(paramObject.getClass().getName());
        a(paramArrayList, localObject);
        return;
      }
      paramArrayList.add("?");
      paramArrayList.add("?");
      return;
    }
    paramArrayList.add(paramObject.getClass().getName());
  }
  
  public static byte[] a(k paramk)
  {
    try
    {
      j localj = new j();
      localj.a("utf-8");
      paramk.a(localj);
      paramk = localj.b();
      return paramk;
    }
    catch (Throwable paramk)
    {
      if (!x.b(paramk)) {
        paramk.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      d locald = new d();
      locald.d();
      locald.a("utf-8");
      locald.a(1);
      locald.b("RqdServer");
      locald.c("sync");
      locald.a("detail", paramObject);
      paramObject = locald.a();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (!x.b(paramObject)) {
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static an b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        d locald = new d();
        locald.d();
        locald.a("utf-8");
        locald.a(paramArrayOfByte);
        paramArrayOfByte = locald.b("detail", new an());
        if (!an.class.isInstance(paramArrayOfByte)) {
          break label80;
        }
        paramArrayOfByte = (an)an.class.cast(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    } else {
      return null;
    }
    label80:
    return null;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new j();
    ((j)localObject).a(this.b);
    ((j)localObject).a(paramT, 0);
    localObject = l.a(((j)localObject).a());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a(localArrayList), localObject);
    this.d.remove(paramString);
    this.a.put(paramString, localHashMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.b);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.c.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    j localj = new j(0);
    localj.a(this.b);
    localj.a(this.a, 0);
    return l.a(localj.a());
  }
  
  public Map<String, String> b()
  {
    return null;
  }
  
  public byte[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.a
 * JD-Core Version:    0.7.0.1
 */