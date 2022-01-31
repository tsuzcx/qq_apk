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
  
  public static ag a(int paramInt)
  {
    if (paramInt == 1) {
      return new af();
    }
    if (paramInt == 3) {
      return new ae();
    }
    return null;
  }
  
  /* Error */
  public static am a(android.content.Context paramContext, int paramInt, byte[] paramArrayOfByte)
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
    //   35: new 67	com/tencent/bugly/proguard/am
    //   38: dup
    //   39: invokespecial 68	com/tencent/bugly/proguard/am:<init>	()V
    //   42: astore 4
    //   44: aload 5
    //   46: monitorenter
    //   47: aload 4
    //   49: iconst_1
    //   50: putfield 71	com/tencent/bugly/proguard/am:a	I
    //   53: aload 4
    //   55: aload 5
    //   57: invokevirtual 74	com/tencent/bugly/crashreport/common/info/a:e	()Ljava/lang/String;
    //   60: putfield 75	com/tencent/bugly/proguard/am:b	Ljava/lang/String;
    //   63: aload 4
    //   65: aload 5
    //   67: getfield 77	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   70: putfield 78	com/tencent/bugly/proguard/am:c	Ljava/lang/String;
    //   73: aload 4
    //   75: aload 5
    //   77: getfield 81	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   80: putfield 83	com/tencent/bugly/proguard/am:d	Ljava/lang/String;
    //   83: aload 4
    //   85: aload 5
    //   87: getfield 86	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   90: putfield 88	com/tencent/bugly/proguard/am:e	Ljava/lang/String;
    //   93: aload 5
    //   95: invokevirtual 92	java/lang/Object:getClass	()Ljava/lang/Class;
    //   98: pop
    //   99: aload 4
    //   101: ldc 94
    //   103: putfield 97	com/tencent/bugly/proguard/am:f	Ljava/lang/String;
    //   106: aload 4
    //   108: iload_1
    //   109: putfield 100	com/tencent/bugly/proguard/am:g	I
    //   112: aload_2
    //   113: ifnonnull +810 -> 923
    //   116: ldc 102
    //   118: invokevirtual 108	java/lang/String:getBytes	()[B
    //   121: astore_3
    //   122: aload 4
    //   124: aload_3
    //   125: putfield 112	com/tencent/bugly/proguard/am:h	[B
    //   128: aload 4
    //   130: aload 5
    //   132: getfield 114	com/tencent/bugly/crashreport/common/info/a:h	Ljava/lang/String;
    //   135: putfield 117	com/tencent/bugly/proguard/am:i	Ljava/lang/String;
    //   138: aload 4
    //   140: aload 5
    //   142: getfield 118	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   145: putfield 121	com/tencent/bugly/proguard/am:j	Ljava/lang/String;
    //   148: aload 4
    //   150: new 19	java/util/HashMap
    //   153: dup
    //   154: invokespecial 20	java/util/HashMap:<init>	()V
    //   157: putfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   160: aload 4
    //   162: aload 5
    //   164: invokevirtual 127	com/tencent/bugly/crashreport/common/info/a:d	()Ljava/lang/String;
    //   167: putfield 128	com/tencent/bugly/proguard/am:l	Ljava/lang/String;
    //   170: aload 4
    //   172: aload 6
    //   174: getfield 134	com/tencent/bugly/crashreport/common/strategy/StrategyBean:o	J
    //   177: putfield 137	com/tencent/bugly/proguard/am:m	J
    //   180: aload 4
    //   182: aload 5
    //   184: invokevirtual 139	com/tencent/bugly/crashreport/common/info/a:g	()Ljava/lang/String;
    //   187: putfield 141	com/tencent/bugly/proguard/am:o	Ljava/lang/String;
    //   190: aload 4
    //   192: aload_0
    //   193: invokestatic 146	com/tencent/bugly/crashreport/common/info/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   196: putfield 149	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   199: aload 4
    //   201: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   204: putfield 158	com/tencent/bugly/proguard/am:q	J
    //   207: aload 4
    //   209: new 160	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   216: aload 5
    //   218: invokevirtual 163	com/tencent/bugly/crashreport/common/info/a:j	()Ljava/lang/String;
    //   221: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: putfield 173	com/tencent/bugly/proguard/am:r	Ljava/lang/String;
    //   230: aload 4
    //   232: aload 5
    //   234: invokevirtual 175	com/tencent/bugly/crashreport/common/info/a:i	()Ljava/lang/String;
    //   237: putfield 178	com/tencent/bugly/proguard/am:s	Ljava/lang/String;
    //   240: aload 4
    //   242: new 160	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   249: aload 5
    //   251: invokevirtual 180	com/tencent/bugly/crashreport/common/info/a:l	()Ljava/lang/String;
    //   254: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: putfield 183	com/tencent/bugly/proguard/am:t	Ljava/lang/String;
    //   263: aload 4
    //   265: aload 5
    //   267: invokevirtual 185	com/tencent/bugly/crashreport/common/info/a:k	()Ljava/lang/String;
    //   270: putfield 188	com/tencent/bugly/proguard/am:u	Ljava/lang/String;
    //   273: aload 4
    //   275: new 160	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   282: aload 5
    //   284: invokevirtual 190	com/tencent/bugly/crashreport/common/info/a:m	()Ljava/lang/String;
    //   287: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: putfield 193	com/tencent/bugly/proguard/am:v	Ljava/lang/String;
    //   296: aload 4
    //   298: aload 4
    //   300: getfield 149	com/tencent/bugly/proguard/am:p	Ljava/lang/String;
    //   303: putfield 196	com/tencent/bugly/proguard/am:w	Ljava/lang/String;
    //   306: aload 5
    //   308: invokevirtual 92	java/lang/Object:getClass	()Ljava/lang/Class;
    //   311: pop
    //   312: aload 4
    //   314: ldc 198
    //   316: putfield 199	com/tencent/bugly/proguard/am:n	Ljava/lang/String;
    //   319: aload 4
    //   321: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   324: ldc 201
    //   326: new 160	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   333: aload 5
    //   335: invokevirtual 204	com/tencent/bugly/crashreport/common/info/a:x	()Ljava/lang/String;
    //   338: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokeinterface 210 3 0
    //   349: pop
    //   350: aload 4
    //   352: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   355: ldc 212
    //   357: new 160	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   364: aload 5
    //   366: invokevirtual 215	com/tencent/bugly/crashreport/common/info/a:y	()Ljava/lang/String;
    //   369: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokeinterface 210 3 0
    //   380: pop
    //   381: aload 4
    //   383: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   386: ldc 217
    //   388: new 160	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   395: aload 5
    //   397: invokevirtual 220	com/tencent/bugly/crashreport/common/info/a:z	()Ljava/lang/String;
    //   400: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 210 3 0
    //   411: pop
    //   412: aload 4
    //   414: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   417: ldc 222
    //   419: new 160	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   426: aload 5
    //   428: invokevirtual 226	com/tencent/bugly/crashreport/common/info/a:Q	()Z
    //   431: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokeinterface 210 3 0
    //   442: pop
    //   443: aload 4
    //   445: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   448: ldc 231
    //   450: new 160	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   457: aload 5
    //   459: invokevirtual 234	com/tencent/bugly/crashreport/common/info/a:R	()Z
    //   462: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokeinterface 210 3 0
    //   473: pop
    //   474: aload 4
    //   476: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   479: ldc 236
    //   481: new 160	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   488: aload 5
    //   490: getfield 240	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   493: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   496: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokeinterface 210 3 0
    //   504: pop
    //   505: aload 4
    //   507: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   510: ldc 242
    //   512: new 160	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   519: aload 5
    //   521: getfield 244	com/tencent/bugly/crashreport/common/info/a:z	Z
    //   524: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokeinterface 210 3 0
    //   535: pop
    //   536: aload 4
    //   538: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   541: ldc 246
    //   543: new 160	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   550: aload 5
    //   552: invokevirtual 248	com/tencent/bugly/crashreport/common/info/a:t	()Ljava/lang/String;
    //   555: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokeinterface 210 3 0
    //   566: pop
    //   567: aload 4
    //   569: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   572: ldc 250
    //   574: new 160	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   581: aload 5
    //   583: invokevirtual 253	com/tencent/bugly/crashreport/common/info/a:S	()Ljava/lang/String;
    //   586: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokeinterface 210 3 0
    //   597: pop
    //   598: aload 5
    //   600: getfield 256	com/tencent/bugly/crashreport/common/info/a:B	Z
    //   603: ifeq +198 -> 801
    //   606: aload 4
    //   608: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   611: ldc_w 258
    //   614: new 160	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   621: aload 5
    //   623: invokevirtual 261	com/tencent/bugly/crashreport/common/info/a:K	()Ljava/lang/String;
    //   626: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokeinterface 210 3 0
    //   637: pop
    //   638: aload 4
    //   640: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   643: ldc_w 263
    //   646: new 160	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   653: aload 5
    //   655: invokevirtual 266	com/tencent/bugly/crashreport/common/info/a:L	()Ljava/lang/String;
    //   658: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokeinterface 210 3 0
    //   669: pop
    //   670: aload 4
    //   672: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   675: ldc_w 268
    //   678: new 160	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   685: aload 5
    //   687: invokevirtual 271	com/tencent/bugly/crashreport/common/info/a:M	()Ljava/lang/String;
    //   690: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokeinterface 210 3 0
    //   701: pop
    //   702: aload 4
    //   704: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   707: ldc_w 273
    //   710: new 160	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   717: aload 5
    //   719: invokevirtual 276	com/tencent/bugly/crashreport/common/info/a:N	()Ljava/lang/String;
    //   722: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokeinterface 210 3 0
    //   733: pop
    //   734: aload 4
    //   736: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   739: ldc_w 278
    //   742: new 160	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   749: aload 5
    //   751: invokevirtual 281	com/tencent/bugly/crashreport/common/info/a:O	()Ljava/lang/String;
    //   754: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokeinterface 210 3 0
    //   765: pop
    //   766: aload 4
    //   768: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   771: ldc_w 283
    //   774: new 160	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   781: aload 5
    //   783: invokevirtual 286	com/tencent/bugly/crashreport/common/info/a:P	()J
    //   786: invokestatic 291	java/lang/Long:toString	(J)Ljava/lang/String;
    //   789: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokeinterface 210 3 0
    //   800: pop
    //   801: aload 4
    //   803: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   806: ldc_w 293
    //   809: new 160	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   816: aload 5
    //   818: getfield 295	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   821: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokeinterface 210 3 0
    //   832: pop
    //   833: getstatic 300	com/tencent/bugly/b:b	Ljava/util/List;
    //   836: ifnull +92 -> 928
    //   839: getstatic 300	com/tencent/bugly/b:b	Ljava/util/List;
    //   842: invokeinterface 306 1 0
    //   847: astore_0
    //   848: aload_0
    //   849: invokeinterface 311 1 0
    //   854: ifeq +74 -> 928
    //   857: aload_0
    //   858: invokeinterface 315 1 0
    //   863: checkcast 317	com/tencent/bugly/a
    //   866: astore_3
    //   867: aload_3
    //   868: getfield 320	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   871: ifnull -23 -> 848
    //   874: aload_3
    //   875: getfield 323	com/tencent/bugly/a:version	Ljava/lang/String;
    //   878: ifnull -30 -> 848
    //   881: aload 4
    //   883: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   886: aload_3
    //   887: getfield 320	com/tencent/bugly/a:versionKey	Ljava/lang/String;
    //   890: aload_3
    //   891: getfield 323	com/tencent/bugly/a:version	Ljava/lang/String;
    //   894: invokeinterface 210 3 0
    //   899: pop
    //   900: goto -52 -> 848
    //   903: astore_0
    //   904: aload 5
    //   906: monitorexit
    //   907: aload_0
    //   908: athrow
    //   909: astore_0
    //   910: aload_0
    //   911: invokestatic 326	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   914: ifne +7 -> 921
    //   917: aload_0
    //   918: invokevirtual 329	java/lang/Throwable:printStackTrace	()V
    //   921: aconst_null
    //   922: areturn
    //   923: aload_2
    //   924: astore_3
    //   925: goto -803 -> 122
    //   928: aload 4
    //   930: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   933: ldc_w 331
    //   936: ldc_w 331
    //   939: ldc 102
    //   941: invokestatic 336	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   944: invokeinterface 210 3 0
    //   949: pop
    //   950: aload 4
    //   952: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   955: ldc_w 338
    //   958: ldc_w 338
    //   961: ldc_w 340
    //   964: invokestatic 336	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   967: invokeinterface 210 3 0
    //   972: pop
    //   973: aload 5
    //   975: monitorexit
    //   976: invokestatic 345	com/tencent/bugly/proguard/u:a	()Lcom/tencent/bugly/proguard/u;
    //   979: astore_0
    //   980: aload_0
    //   981: ifnull +55 -> 1036
    //   984: aload_0
    //   985: getfield 347	com/tencent/bugly/proguard/u:b	Z
    //   988: ifne +48 -> 1036
    //   991: aload_2
    //   992: ifnull +44 -> 1036
    //   995: aload 4
    //   997: aload 4
    //   999: getfield 112	com/tencent/bugly/proguard/am:h	[B
    //   1002: iconst_2
    //   1003: iconst_1
    //   1004: aload 6
    //   1006: getfield 348	com/tencent/bugly/crashreport/common/strategy/StrategyBean:t	Ljava/lang/String;
    //   1009: invokestatic 351	com/tencent/bugly/proguard/z:a	([BIILjava/lang/String;)[B
    //   1012: putfield 112	com/tencent/bugly/proguard/am:h	[B
    //   1015: aload 4
    //   1017: getfield 112	com/tencent/bugly/proguard/am:h	[B
    //   1020: ifnonnull +16 -> 1036
    //   1023: ldc_w 353
    //   1026: iconst_0
    //   1027: anewarray 4	java/lang/Object
    //   1030: invokestatic 65	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1033: pop
    //   1034: aconst_null
    //   1035: areturn
    //   1036: aload 5
    //   1038: invokevirtual 357	com/tencent/bugly/crashreport/common/info/a:E	()Ljava/util/Map;
    //   1041: astore_0
    //   1042: aload_0
    //   1043: ifnull +60 -> 1103
    //   1046: aload_0
    //   1047: invokeinterface 361 1 0
    //   1052: invokeinterface 364 1 0
    //   1057: astore_0
    //   1058: aload_0
    //   1059: invokeinterface 311 1 0
    //   1064: ifeq +39 -> 1103
    //   1067: aload_0
    //   1068: invokeinterface 315 1 0
    //   1073: checkcast 366	java/util/Map$Entry
    //   1076: astore_2
    //   1077: aload 4
    //   1079: getfield 125	com/tencent/bugly/proguard/am:k	Ljava/util/Map;
    //   1082: aload_2
    //   1083: invokeinterface 369 1 0
    //   1088: aload_2
    //   1089: invokeinterface 372 1 0
    //   1094: invokeinterface 210 3 0
    //   1099: pop
    //   1100: goto -42 -> 1058
    //   1103: aload 4
    //   1105: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1106	0	paramContext	android.content.Context
    //   0	1106	1	paramInt	int
    //   0	1106	2	paramArrayOfByte	byte[]
    //   121	804	3	localObject	Object
    //   42	1062	4	localam	am
    //   3	1034	5	locala	com.tencent.bugly.crashreport.common.info.a
    //   11	994	6	localStrategyBean	StrategyBean
    // Exception table:
    //   from	to	target	type
    //   47	112	903	finally
    //   116	122	903	finally
    //   122	801	903	finally
    //   801	848	903	finally
    //   848	900	903	finally
    //   928	976	903	finally
    //   35	47	909	java/lang/Throwable
    //   904	909	909	java/lang/Throwable
    //   976	980	909	java/lang/Throwable
    //   984	991	909	java/lang/Throwable
    //   995	1034	909	java/lang/Throwable
    //   1036	1042	909	java/lang/Throwable
    //   1046	1058	909	java/lang/Throwable
    //   1058	1100	909	java/lang/Throwable
  }
  
  public static an a(byte[] paramArrayOfByte, boolean paramBoolean)
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
        paramArrayOfByte = ((d)localObject).b("detail", new an());
        if (!an.class.isInstance(paramArrayOfByte)) {
          break label171;
        }
        paramArrayOfByte = (an)an.class.cast(paramArrayOfByte);
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
    ((com.tencent.bugly.crashreport.common.info.a)localObject).s();
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
    localar.e.put("A7", ((com.tencent.bugly.crashreport.common.info.a)localObject).g);
    localar.e.put("A6", ((com.tencent.bugly.crashreport.common.info.a)localObject).r());
    localar.e.put("A5", ((com.tencent.bugly.crashreport.common.info.a)localObject).q());
    localar.e.put("A2", ((com.tencent.bugly.crashreport.common.info.a)localObject).o());
    localar.e.put("A1", ((com.tencent.bugly.crashreport.common.info.a)localObject).o());
    localar.e.put("A24", ((com.tencent.bugly.crashreport.common.info.a)localObject).i);
    localar.e.put("A17", ((com.tencent.bugly.crashreport.common.info.a)localObject).p());
    localar.e.put("A15", ((com.tencent.bugly.crashreport.common.info.a)localObject).v());
    localar.e.put("A13", ((com.tencent.bugly.crashreport.common.info.a)localObject).w());
    localar.e.put("F08", ((com.tencent.bugly.crashreport.common.info.a)localObject).w);
    localar.e.put("F09", ((com.tencent.bugly.crashreport.common.info.a)localObject).x);
    paramList = ((com.tencent.bugly.crashreport.common.info.a)localObject).F();
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