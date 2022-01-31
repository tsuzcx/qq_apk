package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
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
  
  public static aj a(int paramInt)
  {
    if (paramInt == 1) {
      return new ai();
    }
    if (paramInt == 3) {
      return new ah();
    }
    return null;
  }
  
  /* Error */
  public static ap a(android.content.Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 49	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   3: astore 5
    //   5: invokestatic 54	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   8: invokevirtual 57	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   11: astore 6
    //   13: aload 5
    //   15: ifnull +8 -> 23
    //   18: aload 6
    //   20: ifnonnull +15 -> 35
    //   23: ldc 59
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 65	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   32: pop
    //   33: aconst_null
    //   34: areturn
    //   35: new 67	com/tencent/bugly/proguard/ap
    //   38: dup
    //   39: invokespecial 68	com/tencent/bugly/proguard/ap:<init>	()V
    //   42: astore 4
    //   44: aload 5
    //   46: monitorenter
    //   47: aload 4
    //   49: iconst_1
    //   50: putfield 71	com/tencent/bugly/proguard/ap:a	I
    //   53: aload 4
    //   55: aload 5
    //   57: invokevirtual 74	com/tencent/bugly/crashreport/common/info/a:e	()Ljava/lang/String;
    //   60: putfield 75	com/tencent/bugly/proguard/ap:b	Ljava/lang/String;
    //   63: aload 4
    //   65: aload 5
    //   67: getfield 77	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   70: putfield 78	com/tencent/bugly/proguard/ap:c	Ljava/lang/String;
    //   73: aload 4
    //   75: aload 5
    //   77: getfield 81	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   80: putfield 83	com/tencent/bugly/proguard/ap:d	Ljava/lang/String;
    //   83: aload 4
    //   85: aload 5
    //   87: getfield 86	com/tencent/bugly/crashreport/common/info/a:o	Ljava/lang/String;
    //   90: putfield 88	com/tencent/bugly/proguard/ap:e	Ljava/lang/String;
    //   93: aload 4
    //   95: aload 5
    //   97: getfield 91	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   100: putfield 94	com/tencent/bugly/proguard/ap:f	Ljava/lang/String;
    //   103: aload 4
    //   105: iload_1
    //   106: putfield 96	com/tencent/bugly/proguard/ap:g	I
    //   109: aload_2
    //   110: ifnonnull +810 -> 920
    //   113: ldc 98
    //   115: invokevirtual 104	java/lang/String:getBytes	()[B
    //   118: astore_3
    //   119: aload 4
    //   121: aload_3
    //   122: putfield 108	com/tencent/bugly/proguard/ap:h	[B
    //   125: aload 4
    //   127: aload 5
    //   129: getfield 111	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   132: putfield 112	com/tencent/bugly/proguard/ap:i	Ljava/lang/String;
    //   135: aload 4
    //   137: aload 5
    //   139: getfield 115	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   142: putfield 116	com/tencent/bugly/proguard/ap:j	Ljava/lang/String;
    //   145: aload 4
    //   147: new 19	java/util/HashMap
    //   150: dup
    //   151: invokespecial 20	java/util/HashMap:<init>	()V
    //   154: putfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   157: aload 4
    //   159: aload 5
    //   161: invokevirtual 122	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   164: putfield 125	com/tencent/bugly/proguard/ap:l	Ljava/lang/String;
    //   167: aload 4
    //   169: aload 6
    //   171: getfield 131	com/tencent/bugly/crashreport/common/strategy/StrategyBean:p	J
    //   174: putfield 133	com/tencent/bugly/proguard/ap:m	J
    //   177: aload 4
    //   179: aload 5
    //   181: invokevirtual 135	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   184: putfield 136	com/tencent/bugly/proguard/ap:o	Ljava/lang/String;
    //   187: aload 4
    //   189: aload_0
    //   190: invokestatic 141	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   193: putfield 143	com/tencent/bugly/proguard/ap:p	Ljava/lang/String;
    //   196: aload 4
    //   198: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   201: putfield 152	com/tencent/bugly/proguard/ap:q	J
    //   204: aload 4
    //   206: new 154	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   213: aload 5
    //   215: invokevirtual 157	com/tencent/bugly/crashreport/common/info/a:j	()Ljava/lang/String;
    //   218: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: putfield 167	com/tencent/bugly/proguard/ap:r	Ljava/lang/String;
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 169	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   234: putfield 172	com/tencent/bugly/proguard/ap:s	Ljava/lang/String;
    //   237: aload 4
    //   239: new 154	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   246: aload 5
    //   248: invokevirtual 174	com/tencent/bugly/crashreport/common/info/a:l	()Ljava/lang/String;
    //   251: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: putfield 177	com/tencent/bugly/proguard/ap:t	Ljava/lang/String;
    //   260: aload 4
    //   262: aload 5
    //   264: invokevirtual 179	com/tencent/bugly/crashreport/common/info/a:k	()Ljava/lang/String;
    //   267: putfield 182	com/tencent/bugly/proguard/ap:u	Ljava/lang/String;
    //   270: aload 4
    //   272: new 154	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   279: aload 5
    //   281: invokevirtual 184	com/tencent/bugly/crashreport/common/info/a:m	()Ljava/lang/String;
    //   284: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: putfield 187	com/tencent/bugly/proguard/ap:v	Ljava/lang/String;
    //   293: aload 4
    //   295: aload 4
    //   297: getfield 143	com/tencent/bugly/proguard/ap:p	Ljava/lang/String;
    //   300: putfield 190	com/tencent/bugly/proguard/ap:w	Ljava/lang/String;
    //   303: aload 5
    //   305: invokevirtual 194	java/lang/Object:getClass	()Ljava/lang/Class;
    //   308: pop
    //   309: aload 4
    //   311: ldc 196
    //   313: putfield 199	com/tencent/bugly/proguard/ap:n	Ljava/lang/String;
    //   316: aload 4
    //   318: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   321: ldc 201
    //   323: new 154	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   330: aload 5
    //   332: invokevirtual 204	com/tencent/bugly/crashreport/common/info/a:x	()Ljava/lang/String;
    //   335: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokeinterface 210 3 0
    //   346: pop
    //   347: aload 4
    //   349: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   352: ldc 212
    //   354: new 154	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   361: aload 5
    //   363: invokevirtual 215	com/tencent/bugly/crashreport/common/info/a:y	()Ljava/lang/String;
    //   366: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokeinterface 210 3 0
    //   377: pop
    //   378: aload 4
    //   380: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   383: ldc 217
    //   385: new 154	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   392: aload 5
    //   394: invokevirtual 220	com/tencent/bugly/crashreport/common/info/a:z	()Ljava/lang/String;
    //   397: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokeinterface 210 3 0
    //   408: pop
    //   409: aload 4
    //   411: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   414: ldc 222
    //   416: new 154	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   423: aload 5
    //   425: invokevirtual 226	com/tencent/bugly/crashreport/common/info/a:Q	()Z
    //   428: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   431: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokeinterface 210 3 0
    //   439: pop
    //   440: aload 4
    //   442: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   445: ldc 231
    //   447: new 154	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   454: aload 5
    //   456: invokevirtual 234	com/tencent/bugly/crashreport/common/info/a:R	()Z
    //   459: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   462: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokeinterface 210 3 0
    //   470: pop
    //   471: aload 4
    //   473: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   476: ldc 236
    //   478: new 154	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   485: aload 5
    //   487: getfield 240	com/tencent/bugly/crashreport/common/info/a:C	Z
    //   490: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   493: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokeinterface 210 3 0
    //   501: pop
    //   502: aload 4
    //   504: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   507: ldc 242
    //   509: new 154	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   516: aload 5
    //   518: getfield 245	com/tencent/bugly/crashreport/common/info/a:B	Z
    //   521: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokeinterface 210 3 0
    //   532: pop
    //   533: aload 4
    //   535: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   538: ldc 247
    //   540: new 154	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   547: aload 5
    //   549: invokevirtual 249	com/tencent/bugly/crashreport/common/info/a:t	()Ljava/lang/String;
    //   552: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokeinterface 210 3 0
    //   563: pop
    //   564: aload 4
    //   566: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   569: ldc 251
    //   571: new 154	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   578: aload 5
    //   580: invokevirtual 254	com/tencent/bugly/crashreport/common/info/a:S	()Ljava/lang/String;
    //   583: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokeinterface 210 3 0
    //   594: pop
    //   595: aload 5
    //   597: getfield 257	com/tencent/bugly/crashreport/common/info/a:D	Z
    //   600: ifeq +198 -> 798
    //   603: aload 4
    //   605: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   608: ldc_w 259
    //   611: new 154	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   618: aload 5
    //   620: invokevirtual 262	com/tencent/bugly/crashreport/common/info/a:K	()Ljava/lang/String;
    //   623: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokeinterface 210 3 0
    //   634: pop
    //   635: aload 4
    //   637: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   640: ldc_w 264
    //   643: new 154	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   650: aload 5
    //   652: invokevirtual 267	com/tencent/bugly/crashreport/common/info/a:L	()Ljava/lang/String;
    //   655: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokeinterface 210 3 0
    //   666: pop
    //   667: aload 4
    //   669: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   672: ldc_w 269
    //   675: new 154	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   682: aload 5
    //   684: invokevirtual 272	com/tencent/bugly/crashreport/common/info/a:M	()Ljava/lang/String;
    //   687: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokeinterface 210 3 0
    //   698: pop
    //   699: aload 4
    //   701: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   704: ldc_w 274
    //   707: new 154	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   714: aload 5
    //   716: invokevirtual 277	com/tencent/bugly/crashreport/common/info/a:N	()Ljava/lang/String;
    //   719: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokeinterface 210 3 0
    //   730: pop
    //   731: aload 4
    //   733: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   736: ldc_w 279
    //   739: new 154	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   746: aload 5
    //   748: invokevirtual 282	com/tencent/bugly/crashreport/common/info/a:O	()Ljava/lang/String;
    //   751: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokeinterface 210 3 0
    //   762: pop
    //   763: aload 4
    //   765: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   768: ldc_w 284
    //   771: new 154	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   778: aload 5
    //   780: invokevirtual 287	com/tencent/bugly/crashreport/common/info/a:P	()J
    //   783: invokestatic 292	java/lang/Long:toString	(J)Ljava/lang/String;
    //   786: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokeinterface 210 3 0
    //   797: pop
    //   798: aload 4
    //   800: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   803: ldc_w 294
    //   806: new 154	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   813: aload 5
    //   815: getfield 295	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   818: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokeinterface 210 3 0
    //   829: pop
    //   830: getstatic 300	com/tencent/bugly/b:b	Ljava/util/List;
    //   833: ifnull +92 -> 925
    //   836: getstatic 300	com/tencent/bugly/b:b	Ljava/util/List;
    //   839: invokeinterface 306 1 0
    //   844: astore_0
    //   845: aload_0
    //   846: invokeinterface 311 1 0
    //   851: ifeq +74 -> 925
    //   854: aload_0
    //   855: invokeinterface 315 1 0
    //   860: checkcast 317	com/tencent/bugly/a
    //   863: astore_3
    //   864: aload_3
    //   865: getfield 320	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   868: ifnull -23 -> 845
    //   871: aload_3
    //   872: getfield 323	com/tencent/bugly/a:version	Ljava/lang/String;
    //   875: ifnull -30 -> 845
    //   878: aload 4
    //   880: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   883: aload_3
    //   884: getfield 320	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   887: aload_3
    //   888: getfield 323	com/tencent/bugly/a:version	Ljava/lang/String;
    //   891: invokeinterface 210 3 0
    //   896: pop
    //   897: goto -52 -> 845
    //   900: astore_0
    //   901: aload 5
    //   903: monitorexit
    //   904: aload_0
    //   905: athrow
    //   906: astore_0
    //   907: aload_0
    //   908: invokestatic 326	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   911: ifne +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 329	java/lang/Throwable:printStackTrace	()V
    //   918: aconst_null
    //   919: areturn
    //   920: aload_2
    //   921: astore_3
    //   922: goto -803 -> 119
    //   925: aload 4
    //   927: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   930: ldc_w 331
    //   933: ldc_w 331
    //   936: ldc 98
    //   938: invokestatic 336	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   941: invokeinterface 210 3 0
    //   946: pop
    //   947: aload 4
    //   949: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   952: ldc_w 338
    //   955: ldc_w 338
    //   958: ldc_w 340
    //   961: invokestatic 336	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   964: invokeinterface 210 3 0
    //   969: pop
    //   970: aload 5
    //   972: monitorexit
    //   973: invokestatic 345	com/tencent/bugly/proguard/u:a	()Lcom/tencent/bugly/proguard/u;
    //   976: astore_0
    //   977: aload_0
    //   978: ifnull +55 -> 1033
    //   981: aload_0
    //   982: getfield 347	com/tencent/bugly/proguard/u:b	Z
    //   985: ifne +48 -> 1033
    //   988: aload_2
    //   989: ifnull +44 -> 1033
    //   992: aload 4
    //   994: aload 4
    //   996: getfield 108	com/tencent/bugly/proguard/ap:h	[B
    //   999: iconst_2
    //   1000: iconst_1
    //   1001: aload 6
    //   1003: getfield 348	com/tencent/bugly/crashreport/common/strategy/StrategyBean:u	Ljava/lang/String;
    //   1006: invokestatic 351	com/tencent/bugly/proguard/z:a	([BIILjava/lang/String;)[B
    //   1009: putfield 108	com/tencent/bugly/proguard/ap:h	[B
    //   1012: aload 4
    //   1014: getfield 108	com/tencent/bugly/proguard/ap:h	[B
    //   1017: ifnonnull +16 -> 1033
    //   1020: ldc_w 353
    //   1023: iconst_0
    //   1024: anewarray 4	java/lang/Object
    //   1027: invokestatic 65	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1030: pop
    //   1031: aconst_null
    //   1032: areturn
    //   1033: aload 5
    //   1035: invokevirtual 357	com/tencent/bugly/crashreport/common/info/a:E	()Ljava/util/Map;
    //   1038: astore_0
    //   1039: aload_0
    //   1040: ifnull +60 -> 1100
    //   1043: aload_0
    //   1044: invokeinterface 361 1 0
    //   1049: invokeinterface 364 1 0
    //   1054: astore_0
    //   1055: aload_0
    //   1056: invokeinterface 311 1 0
    //   1061: ifeq +39 -> 1100
    //   1064: aload_0
    //   1065: invokeinterface 315 1 0
    //   1070: checkcast 366	java/util/Map$Entry
    //   1073: astore_2
    //   1074: aload 4
    //   1076: getfield 120	com/tencent/bugly/proguard/ap:k	Ljava/util/Map;
    //   1079: aload_2
    //   1080: invokeinterface 369 1 0
    //   1085: aload_2
    //   1086: invokeinterface 372 1 0
    //   1091: invokeinterface 210 3 0
    //   1096: pop
    //   1097: goto -42 -> 1055
    //   1100: aload 4
    //   1102: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1103	0	paramContext	android.content.Context
    //   0	1103	1	paramInt	int
    //   0	1103	2	paramArrayOfByte	byte[]
    //   118	804	3	localObject	Object
    //   42	1059	4	localap	ap
    //   3	1031	5	locala	com.tencent.bugly.crashreport.common.info.a
    //   11	991	6	localStrategyBean	StrategyBean
    // Exception table:
    //   from	to	target	type
    //   47	109	900	finally
    //   113	119	900	finally
    //   119	798	900	finally
    //   798	845	900	finally
    //   845	897	900	finally
    //   925	973	900	finally
    //   35	47	906	java/lang/Throwable
    //   901	906	906	java/lang/Throwable
    //   973	977	906	java/lang/Throwable
    //   981	988	906	java/lang/Throwable
    //   992	1031	906	java/lang/Throwable
    //   1033	1039	906	java/lang/Throwable
    //   1043	1055	906	java/lang/Throwable
    //   1055	1097	906	java/lang/Throwable
  }
  
  public static aq a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = new d();
        ((d)localObject).d();
        ((d)localObject).a("utf-8");
        ((d)localObject).a(paramArrayOfByte);
        paramArrayOfByte = ((d)localObject).b("detail", new aq());
        if (!aq.class.isInstance(paramArrayOfByte)) {
          break label171;
        }
        paramArrayOfByte = (aq)aq.class.cast(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (!paramBoolean)
        {
          localObject = paramArrayOfByte;
          if (paramArrayOfByte != null)
          {
            localObject = paramArrayOfByte;
            if (paramArrayOfByte.c != null)
            {
              localObject = paramArrayOfByte;
              if (paramArrayOfByte.c.length > 0)
              {
                x.c("resp buf %d", new Object[] { Integer.valueOf(paramArrayOfByte.c.length) });
                paramArrayOfByte.c = z.b(paramArrayOfByte.c, 2, 1, StrategyBean.d);
                localObject = paramArrayOfByte;
                if (paramArrayOfByte.c == null)
                {
                  x.e("resp sbuffer error!", new Object[0]);
                  localObject = null;
                }
              }
            }
          }
        }
        return localObject;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.b(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
      return null;
      label171:
      paramArrayOfByte = null;
    }
  }
  
  public static at a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    at localat = new at();
    localat.a = paramUserInfoBean.e;
    localat.e = paramUserInfoBean.j;
    localat.d = paramUserInfoBean.c;
    localat.c = paramUserInfoBean.d;
    localat.g = com.tencent.bugly.crashreport.common.info.a.b().h();
    if (paramUserInfoBean.o == 1)
    {
      bool = true;
      localat.h = bool;
      switch (paramUserInfoBean.b)
      {
      default: 
        if ((paramUserInfoBean.b < 10) || (paramUserInfoBean.b >= 20)) {
          break;
        }
        localat.b = ((byte)paramUserInfoBean.b);
      }
    }
    else
    {
      for (;;)
      {
        localat.f = new HashMap();
        if (paramUserInfoBean.p >= 0) {
          localat.f.put("C01", paramUserInfoBean.p);
        }
        if (paramUserInfoBean.q >= 0) {
          localat.f.put("C02", paramUserInfoBean.q);
        }
        if ((paramUserInfoBean.r == null) || (paramUserInfoBean.r.size() <= 0)) {
          break label376;
        }
        localObject1 = paramUserInfoBean.r.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localat.f.put("C03_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
        bool = false;
        break;
        localat.b = 1;
        continue;
        localat.b = 2;
        continue;
        localat.b = 4;
        continue;
        localat.b = 3;
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
        localat.f.put("C04_" + (String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = localat.f;
    Object localObject2 = new StringBuilder();
    if (!paramUserInfoBean.l) {}
    for (boolean bool = true;; bool = false)
    {
      ((Map)localObject1).put("A36", bool);
      localat.f.put("F02", paramUserInfoBean.g);
      localat.f.put("F03", paramUserInfoBean.h);
      localat.f.put("F04", paramUserInfoBean.j);
      localat.f.put("F05", paramUserInfoBean.i);
      localat.f.put("F06", paramUserInfoBean.m);
      localat.f.put("F10", paramUserInfoBean.k);
      x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localat.b), Integer.valueOf(localat.f.size()) });
      return localat;
    }
  }
  
  public static au a(List<UserInfoBean> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
    if (localObject == null) {
      return null;
    }
    ((com.tencent.bugly.crashreport.common.info.a)localObject).s();
    au localau = new au();
    localau.b = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localau.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).g();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      at localat = a((UserInfoBean)paramList.next());
      if (localat != null) {
        localArrayList.add(localat);
      }
    }
    localau.d = localArrayList;
    localau.e = new HashMap();
    localau.e.put("A7", ((com.tencent.bugly.crashreport.common.info.a)localObject).h);
    localau.e.put("A6", ((com.tencent.bugly.crashreport.common.info.a)localObject).r());
    localau.e.put("A5", ((com.tencent.bugly.crashreport.common.info.a)localObject).q());
    localau.e.put("A2", ((com.tencent.bugly.crashreport.common.info.a)localObject).o());
    localau.e.put("A1", ((com.tencent.bugly.crashreport.common.info.a)localObject).o());
    localau.e.put("A24", ((com.tencent.bugly.crashreport.common.info.a)localObject).j);
    localau.e.put("A17", ((com.tencent.bugly.crashreport.common.info.a)localObject).p());
    localau.e.put("A15", ((com.tencent.bugly.crashreport.common.info.a)localObject).v());
    localau.e.put("A13", ((com.tencent.bugly.crashreport.common.info.a)localObject).w());
    localau.e.put("F08", ((com.tencent.bugly.crashreport.common.info.a)localObject).x);
    localau.e.put("F09", ((com.tencent.bugly.crashreport.common.info.a)localObject).y);
    paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject).F();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        localau.e.put("C04_" + (String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
    }
    switch (paramInt)
    {
    default: 
      x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    for (localau.a = 1;; localau.a = 2) {
      return localau;
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
      locald.b(1);
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