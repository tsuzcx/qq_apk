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
    //   15: ifnull +1118 -> 1133
    //   18: aload 6
    //   20: ifnonnull +6 -> 26
    //   23: goto +1110 -> 1133
    //   26: new 52	com/tencent/bugly/proguard/am
    //   29: dup
    //   30: invokespecial 53	com/tencent/bugly/proguard/am:<init>	()V
    //   33: astore 4
    //   35: aload 5
    //   37: monitorenter
    //   38: aload 4
    //   40: iconst_1
    //   41: putfield 56	com/tencent/bugly/proguard/am:a	I
    //   44: aload 4
    //   46: aload 5
    //   48: invokevirtual 60	com/tencent/bugly/crashreport/common/info/a:e	()Ljava/lang/String;
    //   51: putfield 61	com/tencent/bugly/proguard/am:b	Ljava/lang/String;
    //   54: aload 4
    //   56: aload 5
    //   58: getfield 63	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   61: putfield 64	com/tencent/bugly/proguard/am:c	Ljava/lang/String;
    //   64: aload 4
    //   66: aload 5
    //   68: getfield 67	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   71: putfield 69	com/tencent/bugly/proguard/am:d	Ljava/lang/String;
    //   74: aload 4
    //   76: aload 5
    //   78: getfield 72	com/tencent/bugly/crashreport/common/info/a:o	Ljava/lang/String;
    //   81: putfield 74	com/tencent/bugly/proguard/am:e	Ljava/lang/String;
    //   84: aload 4
    //   86: aload 5
    //   88: getfield 77	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   91: putfield 80	com/tencent/bugly/proguard/am:f	Ljava/lang/String;
    //   94: aload 4
    //   96: iload_1
    //   97: putfield 82	com/tencent/bugly/proguard/am:g	I
    //   100: aload_2
    //   101: astore_3
    //   102: aload_2
    //   103: ifnonnull +9 -> 112
    //   106: ldc 84
    //   108: invokevirtual 90	java/lang/String:getBytes	()[B
    //   111: astore_3
    //   112: aload 4
    //   114: aload_3
    //   115: putfield 94	com/tencent/bugly/proguard/am:h	[B
    //   118: aload 4
    //   120: aload 5
    //   122: getfield 97	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   125: putfield 98	com/tencent/bugly/proguard/am:i	Ljava/lang/String;
    //   128: aload 4
    //   130: aload 5
    //   132: getfield 101	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   135: putfield 102	com/tencent/bugly/proguard/am:j	Ljava/lang/String;
    //   138: aload 4
    //   140: new 19	java/util/HashMap
    //   143: dup
    //   144: invokespecial 20	java/util/HashMap:<init>	()V
    //   147: putfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   150: aload 4
    //   152: aload 5
    //   154: invokevirtual 108	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   157: putfield 111	com/tencent/bugly/proguard/am:l	Ljava/lang/String;
    //   160: aload 4
    //   162: aload 6
    //   164: getfield 116	com/tencent/bugly/crashreport/common/strategy/StrategyBean:o	J
    //   167: putfield 118	com/tencent/bugly/proguard/am:m	J
    //   170: aload 4
    //   172: aload 5
    //   174: invokevirtual 120	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   177: putfield 121	com/tencent/bugly/proguard/am:o	Ljava/lang/String;
    //   180: aload 4
    //   182: aload_0
    //   183: invokestatic 126	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   186: putfield 129	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   189: aload 4
    //   191: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   194: putfield 138	com/tencent/bugly/proguard/am:q	J
    //   197: new 140	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   204: astore_0
    //   205: aload_0
    //   206: aload 5
    //   208: invokevirtual 143	com/tencent/bugly/crashreport/common/info/a:j	()Ljava/lang/String;
    //   211: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 4
    //   217: aload_0
    //   218: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: putfield 153	com/tencent/bugly/proguard/am:r	Ljava/lang/String;
    //   224: aload 4
    //   226: aload 5
    //   228: invokevirtual 155	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   231: putfield 158	com/tencent/bugly/proguard/am:s	Ljava/lang/String;
    //   234: new 140	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   241: astore_0
    //   242: aload_0
    //   243: aload 5
    //   245: invokevirtual 160	com/tencent/bugly/crashreport/common/info/a:l	()Ljava/lang/String;
    //   248: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 4
    //   254: aload_0
    //   255: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: putfield 163	com/tencent/bugly/proguard/am:t	Ljava/lang/String;
    //   261: aload 4
    //   263: aload 5
    //   265: invokevirtual 165	com/tencent/bugly/crashreport/common/info/a:k	()Ljava/lang/String;
    //   268: putfield 168	com/tencent/bugly/proguard/am:u	Ljava/lang/String;
    //   271: new 140	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   278: astore_0
    //   279: aload_0
    //   280: aload 5
    //   282: invokevirtual 120	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   285: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 4
    //   291: aload_0
    //   292: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: putfield 171	com/tencent/bugly/proguard/am:v	Ljava/lang/String;
    //   298: aload 4
    //   300: aload 4
    //   302: getfield 129	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   305: putfield 174	com/tencent/bugly/proguard/am:w	Ljava/lang/String;
    //   308: aload 5
    //   310: invokevirtual 178	java/lang/Object:getClass	()Ljava/lang/Class;
    //   313: pop
    //   314: aload 4
    //   316: ldc 180
    //   318: putfield 183	com/tencent/bugly/proguard/am:n	Ljava/lang/String;
    //   321: aload 4
    //   323: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   326: astore_0
    //   327: new 140	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   334: astore_2
    //   335: aload_2
    //   336: aload 5
    //   338: invokevirtual 185	com/tencent/bugly/crashreport/common/info/a:w	()Ljava/lang/String;
    //   341: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: ldc 187
    //   348: aload_2
    //   349: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokeinterface 193 3 0
    //   357: pop
    //   358: aload 4
    //   360: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   363: astore_0
    //   364: new 140	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   371: astore_2
    //   372: aload_2
    //   373: aload 5
    //   375: invokevirtual 196	com/tencent/bugly/crashreport/common/info/a:x	()Ljava/lang/String;
    //   378: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_0
    //   383: ldc 198
    //   385: aload_2
    //   386: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokeinterface 193 3 0
    //   394: pop
    //   395: aload 4
    //   397: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   400: astore_0
    //   401: new 140	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   408: astore_2
    //   409: aload_2
    //   410: aload 5
    //   412: invokevirtual 201	com/tencent/bugly/crashreport/common/info/a:y	()Ljava/lang/String;
    //   415: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_0
    //   420: ldc 203
    //   422: aload_2
    //   423: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokeinterface 193 3 0
    //   431: pop
    //   432: aload 4
    //   434: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   437: astore_0
    //   438: new 140	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   445: astore_2
    //   446: aload_2
    //   447: aload 5
    //   449: invokevirtual 207	com/tencent/bugly/crashreport/common/info/a:P	()Z
    //   452: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_0
    //   457: ldc 212
    //   459: aload_2
    //   460: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokeinterface 193 3 0
    //   468: pop
    //   469: aload 4
    //   471: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   474: astore_0
    //   475: new 140	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   482: astore_2
    //   483: aload_2
    //   484: aload 5
    //   486: invokevirtual 215	com/tencent/bugly/crashreport/common/info/a:Q	()Z
    //   489: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_0
    //   494: ldc 217
    //   496: aload_2
    //   497: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokeinterface 193 3 0
    //   505: pop
    //   506: aload 4
    //   508: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   511: astore_0
    //   512: new 140	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   519: astore_2
    //   520: aload_2
    //   521: aload 5
    //   523: getfield 221	com/tencent/bugly/crashreport/common/info/a:B	Z
    //   526: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_0
    //   531: ldc 223
    //   533: aload_2
    //   534: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokeinterface 193 3 0
    //   542: pop
    //   543: aload 4
    //   545: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   548: astore_0
    //   549: new 140	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   556: astore_2
    //   557: aload_2
    //   558: aload 5
    //   560: getfield 226	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   563: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload_0
    //   568: ldc 228
    //   570: aload_2
    //   571: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokeinterface 193 3 0
    //   579: pop
    //   580: aload 4
    //   582: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   585: astore_0
    //   586: new 140	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   593: astore_2
    //   594: aload_2
    //   595: aload 5
    //   597: invokevirtual 230	com/tencent/bugly/crashreport/common/info/a:s	()Ljava/lang/String;
    //   600: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_0
    //   605: ldc 232
    //   607: aload_2
    //   608: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokeinterface 193 3 0
    //   616: pop
    //   617: aload 4
    //   619: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   622: astore_0
    //   623: new 140	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   630: astore_2
    //   631: aload_2
    //   632: aload 5
    //   634: invokevirtual 235	com/tencent/bugly/crashreport/common/info/a:R	()Ljava/lang/String;
    //   637: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload_0
    //   642: ldc 237
    //   644: aload_2
    //   645: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokeinterface 193 3 0
    //   653: pop
    //   654: aload 5
    //   656: getfield 240	com/tencent/bugly/crashreport/common/info/a:C	Z
    //   659: ifeq +231 -> 890
    //   662: aload 4
    //   664: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   667: astore_0
    //   668: new 140	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   675: astore_2
    //   676: aload_2
    //   677: aload 5
    //   679: invokevirtual 242	com/tencent/bugly/crashreport/common/info/a:J	()Ljava/lang/String;
    //   682: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_0
    //   687: ldc 244
    //   689: aload_2
    //   690: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokeinterface 193 3 0
    //   698: pop
    //   699: aload 4
    //   701: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   704: astore_0
    //   705: new 140	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   712: astore_2
    //   713: aload_2
    //   714: aload 5
    //   716: invokevirtual 247	com/tencent/bugly/crashreport/common/info/a:K	()Ljava/lang/String;
    //   719: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload_0
    //   724: ldc 249
    //   726: aload_2
    //   727: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokeinterface 193 3 0
    //   735: pop
    //   736: aload 4
    //   738: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   741: astore_0
    //   742: new 140	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   749: astore_2
    //   750: aload_2
    //   751: aload 5
    //   753: invokevirtual 252	com/tencent/bugly/crashreport/common/info/a:L	()Ljava/lang/String;
    //   756: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload_0
    //   761: ldc 254
    //   763: aload_2
    //   764: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokeinterface 193 3 0
    //   772: pop
    //   773: aload 4
    //   775: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   778: astore_0
    //   779: new 140	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   786: astore_2
    //   787: aload_2
    //   788: aload 5
    //   790: invokevirtual 257	com/tencent/bugly/crashreport/common/info/a:M	()Ljava/lang/String;
    //   793: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload_0
    //   798: ldc_w 259
    //   801: aload_2
    //   802: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokeinterface 193 3 0
    //   810: pop
    //   811: aload 4
    //   813: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   816: astore_0
    //   817: new 140	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   824: astore_2
    //   825: aload_2
    //   826: aload 5
    //   828: invokevirtual 262	com/tencent/bugly/crashreport/common/info/a:N	()Ljava/lang/String;
    //   831: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload_0
    //   836: ldc_w 264
    //   839: aload_2
    //   840: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokeinterface 193 3 0
    //   848: pop
    //   849: aload 4
    //   851: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   854: astore_0
    //   855: new 140	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   862: astore_2
    //   863: aload_2
    //   864: aload 5
    //   866: invokevirtual 267	com/tencent/bugly/crashreport/common/info/a:O	()J
    //   869: invokestatic 272	java/lang/Long:toString	(J)Ljava/lang/String;
    //   872: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload_0
    //   877: ldc_w 274
    //   880: aload_2
    //   881: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokeinterface 193 3 0
    //   889: pop
    //   890: aload 4
    //   892: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   895: astore_0
    //   896: new 140	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   903: astore_2
    //   904: aload_2
    //   905: aload 5
    //   907: getfield 275	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   910: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload_0
    //   915: ldc_w 277
    //   918: aload_2
    //   919: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokeinterface 193 3 0
    //   927: pop
    //   928: getstatic 282	com/tencent/bugly/b:b	Ljava/util/List;
    //   931: ifnull +67 -> 998
    //   934: getstatic 282	com/tencent/bugly/b:b	Ljava/util/List;
    //   937: invokeinterface 288 1 0
    //   942: astore_0
    //   943: aload_0
    //   944: invokeinterface 293 1 0
    //   949: ifeq +49 -> 998
    //   952: aload_0
    //   953: invokeinterface 297 1 0
    //   958: checkcast 299	com/tencent/bugly/a
    //   961: astore_2
    //   962: aload_2
    //   963: getfield 302	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   966: ifnull -23 -> 943
    //   969: aload_2
    //   970: getfield 305	com/tencent/bugly/a:version	Ljava/lang/String;
    //   973: ifnull -30 -> 943
    //   976: aload 4
    //   978: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   981: aload_2
    //   982: getfield 302	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   985: aload_2
    //   986: getfield 305	com/tencent/bugly/a:version	Ljava/lang/String;
    //   989: invokeinterface 193 3 0
    //   994: pop
    //   995: goto -52 -> 943
    //   998: aload 4
    //   1000: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   1003: ldc_w 307
    //   1006: ldc_w 307
    //   1009: ldc 84
    //   1011: invokestatic 312	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1014: invokeinterface 193 3 0
    //   1019: pop
    //   1020: aload 4
    //   1022: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   1025: ldc_w 314
    //   1028: ldc_w 314
    //   1031: ldc_w 316
    //   1034: invokestatic 312	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1037: invokeinterface 193 3 0
    //   1042: pop
    //   1043: aload 5
    //   1045: monitorexit
    //   1046: aload 5
    //   1048: invokevirtual 320	com/tencent/bugly/crashreport/common/info/a:D	()Ljava/util/Map;
    //   1051: astore_0
    //   1052: aload_0
    //   1053: ifnull +93 -> 1146
    //   1056: aload_0
    //   1057: invokeinterface 324 1 0
    //   1062: invokeinterface 327 1 0
    //   1067: astore_0
    //   1068: aload_0
    //   1069: invokeinterface 293 1 0
    //   1074: ifeq +72 -> 1146
    //   1077: aload_0
    //   1078: invokeinterface 297 1 0
    //   1083: checkcast 329	java/util/Map$Entry
    //   1086: astore_2
    //   1087: aload 4
    //   1089: getfield 106	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   1092: aload_2
    //   1093: invokeinterface 332 1 0
    //   1098: aload_2
    //   1099: invokeinterface 335 1 0
    //   1104: invokeinterface 193 3 0
    //   1109: pop
    //   1110: goto -42 -> 1068
    //   1113: astore_0
    //   1114: aload 5
    //   1116: monitorexit
    //   1117: aload_0
    //   1118: athrow
    //   1119: astore_0
    //   1120: aload_0
    //   1121: invokestatic 340	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   1124: ifne +7 -> 1131
    //   1127: aload_0
    //   1128: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   1131: aconst_null
    //   1132: areturn
    //   1133: ldc_w 345
    //   1136: iconst_0
    //   1137: anewarray 4	java/lang/Object
    //   1140: invokestatic 348	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1143: pop
    //   1144: aconst_null
    //   1145: areturn
    //   1146: aload 4
    //   1148: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1149	0	paramContext	android.content.Context
    //   0	1149	1	paramInt	int
    //   0	1149	2	paramArrayOfByte	byte[]
    //   101	14	3	arrayOfByte	byte[]
    //   33	1114	4	localam	am
    //   3	1112	5	locala	com.tencent.bugly.crashreport.common.info.a
    //   11	152	6	localStrategyBean	com.tencent.bugly.crashreport.common.strategy.StrategyBean
    // Exception table:
    //   from	to	target	type
    //   38	100	1113	finally
    //   106	112	1113	finally
    //   112	890	1113	finally
    //   890	943	1113	finally
    //   943	995	1113	finally
    //   998	1046	1113	finally
    //   26	38	1119	java/lang/Throwable
    //   1046	1052	1119	java/lang/Throwable
    //   1056	1068	1119	java/lang/Throwable
    //   1068	1110	1119	java/lang/Throwable
    //   1114	1119	1119	java/lang/Throwable
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
    boolean bool;
    if (paramUserInfoBean.o == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localaq.h = bool;
    int i = paramUserInfoBean.b;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if ((paramUserInfoBean.b >= 10) && (paramUserInfoBean.b < 20))
            {
              localaq.b = ((byte)paramUserInfoBean.b);
            }
            else
            {
              x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
              return null;
            }
          }
          else {
            localaq.b = 3;
          }
        }
        else {
          localaq.b = 2;
        }
      }
      else {
        localaq.b = 4;
      }
    }
    else {
      localaq.b = 1;
    }
    localaq.f = new HashMap();
    if (paramUserInfoBean.p >= 0)
    {
      localObject1 = localaq.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.p);
      ((Map)localObject1).put("C01", ((StringBuilder)localObject2).toString());
    }
    if (paramUserInfoBean.q >= 0)
    {
      localObject1 = localaq.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUserInfoBean.q);
      ((Map)localObject1).put("C02", ((StringBuilder)localObject2).toString());
    }
    Map localMap;
    StringBuilder localStringBuilder;
    if ((paramUserInfoBean.r != null) && (paramUserInfoBean.r.size() > 0))
    {
      localObject1 = paramUserInfoBean.r.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localaq.f;
        localStringBuilder = new StringBuilder("C03_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    if ((paramUserInfoBean.s != null) && (paramUserInfoBean.s.size() > 0))
    {
      localObject1 = paramUserInfoBean.s.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localMap = localaq.f;
        localStringBuilder = new StringBuilder("C04_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = localaq.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.l ^ true);
    ((Map)localObject1).put("A36", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.g);
    ((Map)localObject1).put("F02", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.h);
    ((Map)localObject1).put("F03", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.j);
    ((Map)localObject1).put("F04", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.i);
    ((Map)localObject1).put("F05", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.m);
    ((Map)localObject1).put("F06", ((StringBuilder)localObject2).toString());
    localObject1 = localaq.f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUserInfoBean.k);
    ((Map)localObject1).put("F10", ((StringBuilder)localObject2).toString());
    x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localaq.b), Integer.valueOf(localaq.f.size()) });
    return localaq;
  }
  
  public static ar a(List<UserInfoBean> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (localObject1 == null) {
        return null;
      }
      ((com.tencent.bugly.crashreport.common.info.a)localObject1).r();
      ar localar = new ar();
      localar.b = ((com.tencent.bugly.crashreport.common.info.a)localObject1).d;
      localar.c = ((com.tencent.bugly.crashreport.common.info.a)localObject1).g();
      Object localObject2 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = a((UserInfoBean)paramList.next());
        if (localObject3 != null) {
          ((ArrayList)localObject2).add(localObject3);
        }
      }
      localar.d = ((ArrayList)localObject2);
      localar.e = new HashMap();
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).h);
      paramList.put("A7", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).q());
      paramList.put("A6", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).p());
      paramList.put("A5", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).n());
      paramList.put("A2", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).n());
      paramList.put("A1", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).j);
      paramList.put("A24", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).o());
      paramList.put("A17", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).u());
      paramList.put("A15", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).v());
      paramList.put("A13", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).x);
      paramList.put("F08", ((StringBuilder)localObject2).toString());
      paramList = localar.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((com.tencent.bugly.crashreport.common.info.a)localObject1).y);
      paramList.put("F09", ((StringBuilder)localObject2).toString());
      paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject1).E();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject1 = (Map.Entry)paramList.next();
          localObject2 = localar.e;
          localObject3 = new StringBuilder("C04_");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject1).getKey());
          ((Map)localObject2).put(((StringBuilder)localObject3).toString(), ((Map.Entry)localObject1).getValue());
        }
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
          return null;
        }
        localar.a = 2;
        return localar;
      }
      localar.a = 1;
      return localar;
    }
    return null;
  }
  
  public static <T extends k> T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
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
    }
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = paramArrayList.size();
      localObject = "map";
      if (i >= j) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      if ((!str.equals("java.lang.Integer")) && (!str.equals("int")))
      {
        if ((!str.equals("java.lang.Boolean")) && (!str.equals("boolean")))
        {
          if ((!str.equals("java.lang.Byte")) && (!str.equals("byte")))
          {
            if ((!str.equals("java.lang.Double")) && (!str.equals("double")))
            {
              if ((!str.equals("java.lang.Float")) && (!str.equals("float")))
              {
                if ((!str.equals("java.lang.Long")) && (!str.equals("long")))
                {
                  if ((!str.equals("java.lang.Short")) && (!str.equals("short")))
                  {
                    if (!str.equals("java.lang.Character"))
                    {
                      if (str.equals("java.lang.String")) {
                        localObject = "string";
                      } else if (str.equals("java.util.List")) {
                        localObject = "list";
                      } else if (!str.equals("java.util.Map")) {
                        localObject = str;
                      }
                    }
                    else {
                      throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                  }
                  else {
                    localObject = "short";
                  }
                }
                else {
                  localObject = "int64";
                }
              }
              else {
                localObject = "float";
              }
            }
            else {
              localObject = "double";
            }
          }
          else {
            localObject = "char";
          }
        }
        else {
          localObject = "bool";
        }
      }
      else {
        localObject = "int32";
      }
      paramArrayList.set(i, localObject);
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("map"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        ((StringBuilder)localObject).append(",");
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("Array"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      i += 1;
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
      if (paramObject.getClass().getComponentType().toString().equals("byte"))
      {
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
      throw new IllegalArgumentException("only byte[] is supported");
    }
    if (!(paramObject instanceof Array))
    {
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
      return;
    }
    throw new IllegalArgumentException("can not support Array, please use List");
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
        if (an.class.isInstance(paramArrayOfByte))
        {
          paramArrayOfByte = (an)an.class.cast(paramArrayOfByte);
          return paramArrayOfByte;
        }
        return null;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
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
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.a
 * JD-Core Version:    0.7.0.1
 */