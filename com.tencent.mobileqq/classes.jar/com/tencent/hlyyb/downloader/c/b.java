package com.tencent.hlyyb.downloader.c;

import com.tencent.hlyyb.common.a.a;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.e.a.c;
import com.tencent.hlyyb.downloader.e.a.d;
import com.tencent.hlyyb.downloader.e.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class b
  implements com.tencent.hlyyb.common.a.b, DownloaderTaskListener, d
{
  private static b a;
  private Vector<i> b = new Vector();
  private c c = new c(this);
  
  private b()
  {
    a.a("downloader", this);
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  /* Error */
  private static void a(i parami, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 51	java/util/HashMap
    //   8: dup
    //   9: invokespecial 52	java/util/HashMap:<init>	()V
    //   12: astore 11
    //   14: aload_0
    //   15: invokevirtual 58	com/tencent/hlyyb/downloader/e/i:getFailCode	()I
    //   18: istore_2
    //   19: iconst_0
    //   20: istore 4
    //   22: iload_1
    //   23: ifne +5 -> 28
    //   26: iconst_0
    //   27: istore_2
    //   28: aload_0
    //   29: invokevirtual 62	com/tencent/hlyyb/downloader/e/i:isEaseTask	()Z
    //   32: ifeq +1913 -> 1945
    //   35: ldc 64
    //   37: astore 8
    //   39: goto +3 -> 42
    //   42: aload 8
    //   44: iload_2
    //   45: iconst_0
    //   46: invokestatic 69	com/tencent/hlyyb/common/a/f:a	(Ljava/lang/String;IZ)I
    //   49: invokestatic 72	com/tencent/hlyyb/common/a/f:a	(I)Z
    //   52: ifne +4 -> 56
    //   55: return
    //   56: new 74	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   63: astore 9
    //   65: aload 9
    //   67: invokestatic 79	com/tencent/hlyyb/common/a:b	()I
    //   70: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 11
    //   76: ldc 85
    //   78: aload 9
    //   80: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: new 74	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   94: astore 9
    //   96: aload 9
    //   98: aload_0
    //   99: getfield 97	com/tencent/hlyyb/downloader/e/i:n	Ljava/lang/String;
    //   102: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 11
    //   108: ldc 102
    //   110: aload 9
    //   112: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: new 74	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   126: astore 9
    //   128: aload 9
    //   130: invokestatic 107	com/tencent/hlyyb/common/b/b:d	()Ljava/lang/String;
    //   133: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 11
    //   139: ldc 109
    //   141: aload 9
    //   143: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: new 74	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   157: astore 9
    //   159: aload 9
    //   161: invokestatic 112	com/tencent/hlyyb/common/b/b:e	()Ljava/lang/String;
    //   164: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 11
    //   170: ldc 114
    //   172: aload 9
    //   174: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: new 74	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   188: astore 9
    //   190: aload 9
    //   192: invokestatic 117	com/tencent/hlyyb/common/b/b:f	()I
    //   195: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 11
    //   201: ldc 119
    //   203: aload 9
    //   205: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: getstatic 123	com/tencent/hlyyb/downloader/a/a:a	Ljava/lang/String;
    //   215: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne +34 -> 252
    //   221: new 74	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   228: astore 9
    //   230: aload 9
    //   232: getstatic 123	com/tencent/hlyyb/downloader/a/a:a	Ljava/lang/String;
    //   235: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 11
    //   241: ldc 131
    //   243: aload 9
    //   245: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload 11
    //   254: ldc 133
    //   256: invokestatic 134	com/tencent/hlyyb/common/a:e	()Ljava/lang/String;
    //   259: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: pop
    //   263: aload_0
    //   264: getfield 136	com/tencent/hlyyb/downloader/e/i:c	Ljava/lang/String;
    //   267: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   270: ifne +35 -> 305
    //   273: new 74	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   280: astore 9
    //   282: aload 9
    //   284: aload_0
    //   285: getfield 136	com/tencent/hlyyb/downloader/e/i:c	Ljava/lang/String;
    //   288: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 11
    //   294: ldc 138
    //   296: aload 9
    //   298: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: aload_0
    //   306: getfield 140	com/tencent/hlyyb/downloader/e/i:d	Ljava/lang/String;
    //   309: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: ifne +35 -> 347
    //   315: new 74	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   322: astore 9
    //   324: aload 9
    //   326: aload_0
    //   327: getfield 140	com/tencent/hlyyb/downloader/e/i:d	Ljava/lang/String;
    //   330: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 11
    //   336: ldc 142
    //   338: aload 9
    //   340: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: getstatic 144	com/tencent/hlyyb/downloader/a/a:b	Ljava/lang/String;
    //   350: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   353: ifne +34 -> 387
    //   356: new 74	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   363: astore 9
    //   365: aload 9
    //   367: getstatic 144	com/tencent/hlyyb/downloader/a/a:b	Ljava/lang/String;
    //   370: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 11
    //   376: ldc 146
    //   378: aload 9
    //   380: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: getstatic 147	com/tencent/hlyyb/downloader/a/a:c	Ljava/lang/String;
    //   390: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifne +34 -> 427
    //   396: new 74	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   403: astore 9
    //   405: aload 9
    //   407: getstatic 147	com/tencent/hlyyb/downloader/a/a:c	Ljava/lang/String;
    //   410: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 11
    //   416: ldc 149
    //   418: aload 9
    //   420: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   426: pop
    //   427: aload 11
    //   429: ldc 151
    //   431: aload_0
    //   432: invokevirtual 154	com/tencent/hlyyb/downloader/e/i:getSavePath	()Ljava/lang/String;
    //   435: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: pop
    //   439: new 74	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   446: astore 9
    //   448: aload 9
    //   450: aload_0
    //   451: getfield 158	com/tencent/hlyyb/downloader/e/i:g	J
    //   454: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 11
    //   460: ldc 163
    //   462: aload 9
    //   464: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   470: pop
    //   471: new 74	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   478: astore 9
    //   480: aload 9
    //   482: aload_0
    //   483: getfield 166	com/tencent/hlyyb/downloader/e/i:j	J
    //   486: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 11
    //   492: ldc 168
    //   494: aload 9
    //   496: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: aload_0
    //   504: getfield 171	com/tencent/hlyyb/downloader/e/i:a	I
    //   507: iconst_m1
    //   508: if_icmpeq +35 -> 543
    //   511: new 74	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   518: astore 9
    //   520: aload 9
    //   522: aload_0
    //   523: getfield 171	com/tencent/hlyyb/downloader/e/i:a	I
    //   526: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 11
    //   532: ldc 173
    //   534: aload 9
    //   536: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: pop
    //   543: aload_0
    //   544: getfield 174	com/tencent/hlyyb/downloader/e/i:b	Ljava/lang/String;
    //   547: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   550: ifne +35 -> 585
    //   553: new 74	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   560: astore 9
    //   562: aload 9
    //   564: aload_0
    //   565: getfield 174	com/tencent/hlyyb/downloader/e/i:b	Ljava/lang/String;
    //   568: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 11
    //   574: ldc 176
    //   576: aload 9
    //   578: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   584: pop
    //   585: new 74	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   592: astore 9
    //   594: aload 9
    //   596: iload_2
    //   597: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 11
    //   603: ldc 178
    //   605: aload 9
    //   607: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   613: pop
    //   614: new 74	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   621: astore 9
    //   623: aload 9
    //   625: iload_1
    //   626: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 11
    //   632: ldc 180
    //   634: aload 9
    //   636: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   642: pop
    //   643: aload 11
    //   645: ldc 182
    //   647: aload_0
    //   648: invokevirtual 185	com/tencent/hlyyb/downloader/e/i:o	()Ljava/lang/String;
    //   651: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: aload_0
    //   656: getfield 188	com/tencent/hlyyb/downloader/e/i:y	Ljava/lang/String;
    //   659: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   662: ifne +35 -> 697
    //   665: new 74	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   672: astore 9
    //   674: aload 9
    //   676: aload_0
    //   677: getfield 188	com/tencent/hlyyb/downloader/e/i:y	Ljava/lang/String;
    //   680: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 11
    //   686: ldc 190
    //   688: aload 9
    //   690: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   696: pop
    //   697: new 74	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   704: astore 9
    //   706: aload 9
    //   708: invokestatic 192	com/tencent/hlyyb/common/a/a:g	()I
    //   711: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 11
    //   717: ldc 194
    //   719: aload 9
    //   721: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: pop
    //   728: new 74	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   735: astore 9
    //   737: aload_0
    //   738: invokevirtual 197	com/tencent/hlyyb/downloader/e/i:isSupportRange	()Z
    //   741: ifeq +1212 -> 1953
    //   744: iconst_1
    //   745: istore_3
    //   746: goto +3 -> 749
    //   749: aload 9
    //   751: iload_3
    //   752: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 11
    //   758: ldc 199
    //   760: aload 9
    //   762: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   768: pop
    //   769: new 74	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   776: astore 9
    //   778: aload 9
    //   780: aload_0
    //   781: invokevirtual 203	com/tencent/hlyyb/downloader/e/i:getCategory	()Lcom/tencent/hlyyb/downloader/DownloaderTaskCategory;
    //   784: invokevirtual 208	com/tencent/hlyyb/downloader/DownloaderTaskCategory:ordinal	()I
    //   787: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 11
    //   793: ldc 210
    //   795: aload 9
    //   797: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   803: pop
    //   804: new 74	java/lang/StringBuilder
    //   807: dup
    //   808: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   811: astore 9
    //   813: aload 9
    //   815: aload_0
    //   816: invokevirtual 213	com/tencent/hlyyb/downloader/e/i:j	()J
    //   819: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 11
    //   825: ldc 215
    //   827: aload 9
    //   829: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   835: pop
    //   836: aload_0
    //   837: invokevirtual 218	com/tencent/hlyyb/downloader/e/i:getKnownSize	()J
    //   840: lconst_0
    //   841: lcmp
    //   842: ifle +35 -> 877
    //   845: new 74	java/lang/StringBuilder
    //   848: dup
    //   849: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   852: astore 9
    //   854: aload 9
    //   856: aload_0
    //   857: invokevirtual 218	com/tencent/hlyyb/downloader/e/i:getKnownSize	()J
    //   860: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload 11
    //   866: ldc 220
    //   868: aload 9
    //   870: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   876: pop
    //   877: iload_1
    //   878: ifeq +10 -> 888
    //   881: aload_0
    //   882: invokestatic 225	android/os/SystemClock:elapsedRealtime	()J
    //   885: putfield 228	com/tencent/hlyyb/downloader/e/i:v	J
    //   888: aload_0
    //   889: getfield 231	com/tencent/hlyyb/downloader/e/i:u	J
    //   892: lconst_0
    //   893: lcmp
    //   894: ifle +1064 -> 1958
    //   897: aload_0
    //   898: getfield 228	com/tencent/hlyyb/downloader/e/i:v	J
    //   901: aload_0
    //   902: getfield 231	com/tencent/hlyyb/downloader/e/i:u	J
    //   905: lcmp
    //   906: ifle +1052 -> 1958
    //   909: aload_0
    //   910: getfield 228	com/tencent/hlyyb/downloader/e/i:v	J
    //   913: aload_0
    //   914: getfield 231	com/tencent/hlyyb/downloader/e/i:u	J
    //   917: lsub
    //   918: lstore 6
    //   920: goto +3 -> 923
    //   923: new 74	java/lang/StringBuilder
    //   926: dup
    //   927: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   930: astore 9
    //   932: aload 9
    //   934: lload 6
    //   936: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 11
    //   942: ldc 233
    //   944: aload 9
    //   946: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   952: pop
    //   953: new 74	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   960: astore 9
    //   962: aload 9
    //   964: aload_0
    //   965: invokevirtual 236	com/tencent/hlyyb/downloader/e/i:getReceivedLength	()J
    //   968: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 11
    //   974: ldc 238
    //   976: aload 9
    //   978: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   984: pop
    //   985: new 74	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   992: astore 9
    //   994: aload 9
    //   996: aload_0
    //   997: getfield 241	com/tencent/hlyyb/downloader/e/i:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   1000: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload 11
    //   1006: ldc 246
    //   1008: aload 9
    //   1010: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1016: pop
    //   1017: new 74	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1024: astore 9
    //   1026: aload 9
    //   1028: aload_0
    //   1029: getfield 249	com/tencent/hlyyb/downloader/e/i:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   1032: lconst_0
    //   1033: invokevirtual 255	java/util/concurrent/atomic/AtomicLong:getAndSet	(J)J
    //   1036: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 11
    //   1042: ldc_w 257
    //   1045: aload 9
    //   1047: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1053: pop
    //   1054: aload_0
    //   1055: getfield 261	com/tencent/hlyyb/downloader/e/i:w	Z
    //   1058: istore 5
    //   1060: iload 5
    //   1062: ifeq +15 -> 1077
    //   1065: aload 11
    //   1067: ldc_w 263
    //   1070: ldc_w 265
    //   1073: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: pop
    //   1077: new 74	java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1084: astore 9
    //   1086: aload 9
    //   1088: aload_0
    //   1089: invokevirtual 266	com/tencent/hlyyb/downloader/e/i:f	()I
    //   1092: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 11
    //   1098: ldc_w 268
    //   1101: aload 9
    //   1103: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: pop
    //   1110: iload_1
    //   1111: ifne +855 -> 1966
    //   1114: aload_0
    //   1115: getfield 271	com/tencent/hlyyb/downloader/e/i:A	J
    //   1118: lconst_0
    //   1119: lcmp
    //   1120: ifle +846 -> 1966
    //   1123: new 74	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1130: astore 9
    //   1132: aload 9
    //   1134: aload_0
    //   1135: getfield 271	com/tencent/hlyyb/downloader/e/i:A	J
    //   1138: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: aload 11
    //   1144: ldc_w 273
    //   1147: aload 9
    //   1149: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1155: pop
    //   1156: goto +810 -> 1966
    //   1159: new 74	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1166: astore 9
    //   1168: aload 9
    //   1170: invokestatic 275	com/tencent/hlyyb/common/a/f:b	()J
    //   1173: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload 11
    //   1179: ldc_w 277
    //   1182: aload 9
    //   1184: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1190: pop
    //   1191: new 74	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1198: astore 9
    //   1200: aload 9
    //   1202: invokestatic 279	com/tencent/hlyyb/common/a/f:a	()J
    //   1205: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload 11
    //   1211: ldc_w 281
    //   1214: aload 9
    //   1216: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1219: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1222: pop
    //   1223: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   1226: lstore 6
    //   1228: new 74	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1235: astore 9
    //   1237: aload 9
    //   1239: aload_0
    //   1240: getfield 289	com/tencent/hlyyb/downloader/e/i:t	J
    //   1243: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload 11
    //   1249: ldc_w 291
    //   1252: aload 9
    //   1254: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1260: pop
    //   1261: new 74	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1268: astore 9
    //   1270: aload 9
    //   1272: lload 6
    //   1274: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 11
    //   1280: ldc_w 293
    //   1283: aload 9
    //   1285: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1291: pop
    //   1292: aload 11
    //   1294: ldc_w 295
    //   1297: aload_0
    //   1298: invokevirtual 298	com/tencent/hlyyb/downloader/e/i:getFailInfo	()Ljava/lang/String;
    //   1301: invokestatic 301	com/tencent/hlyyb/common/b/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1304: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: pop
    //   1308: aload_0
    //   1309: invokevirtual 304	com/tencent/hlyyb/downloader/e/i:l	()Ljava/lang/String;
    //   1312: astore 10
    //   1314: aload 10
    //   1316: invokevirtual 309	java/lang/String:length	()I
    //   1319: istore_3
    //   1320: aload 10
    //   1322: astore 9
    //   1324: iload_3
    //   1325: sipush 600
    //   1328: if_icmple +50 -> 1378
    //   1331: new 74	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1338: astore 9
    //   1340: aload 9
    //   1342: aload 10
    //   1344: iconst_0
    //   1345: sipush 600
    //   1348: invokevirtual 313	java/lang/String:substring	(II)Ljava/lang/String;
    //   1351: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: aload 9
    //   1357: ldc_w 315
    //   1360: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: aload 9
    //   1366: iload_3
    //   1367: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 9
    //   1373: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1376: astore 9
    //   1378: new 74	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1385: astore 10
    //   1387: aload 10
    //   1389: aload 9
    //   1391: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload 11
    //   1397: ldc_w 317
    //   1400: aload 10
    //   1402: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1408: pop
    //   1409: new 74	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1416: astore 9
    //   1418: aload 9
    //   1420: aload_0
    //   1421: getfield 320	com/tencent/hlyyb/downloader/e/i:z	I
    //   1424: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload 11
    //   1430: ldc_w 322
    //   1433: aload 9
    //   1435: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1438: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1441: pop
    //   1442: aload_0
    //   1443: invokevirtual 325	com/tencent/hlyyb/downloader/e/i:m	()Ljava/lang/String;
    //   1446: astore 10
    //   1448: aload 10
    //   1450: invokevirtual 309	java/lang/String:length	()I
    //   1453: istore_3
    //   1454: aload 10
    //   1456: astore 9
    //   1458: iload_3
    //   1459: sipush 2000
    //   1462: if_icmple +50 -> 1512
    //   1465: new 74	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1472: astore 9
    //   1474: aload 9
    //   1476: aload 10
    //   1478: iconst_0
    //   1479: sipush 2000
    //   1482: invokevirtual 313	java/lang/String:substring	(II)Ljava/lang/String;
    //   1485: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: aload 9
    //   1491: ldc_w 315
    //   1494: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 9
    //   1500: iload_3
    //   1501: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 9
    //   1507: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1510: astore 9
    //   1512: aload 11
    //   1514: ldc_w 327
    //   1517: aload 9
    //   1519: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1522: pop
    //   1523: iload_1
    //   1524: ifne +46 -> 1570
    //   1527: aload_0
    //   1528: invokevirtual 329	com/tencent/hlyyb/downloader/e/i:d	()I
    //   1531: sipush 1000
    //   1534: if_icmple +36 -> 1570
    //   1537: new 74	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1544: astore 9
    //   1546: aload 9
    //   1548: aload_0
    //   1549: invokevirtual 329	com/tencent/hlyyb/downloader/e/i:d	()I
    //   1552: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 11
    //   1558: ldc_w 331
    //   1561: aload 9
    //   1563: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1569: pop
    //   1570: aload_0
    //   1571: invokevirtual 334	com/tencent/hlyyb/downloader/e/i:h	()J
    //   1574: ldc2_w 335
    //   1577: lcmp
    //   1578: ifle +36 -> 1614
    //   1581: new 74	java/lang/StringBuilder
    //   1584: dup
    //   1585: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1588: astore 9
    //   1590: aload 9
    //   1592: aload_0
    //   1593: invokevirtual 334	com/tencent/hlyyb/downloader/e/i:h	()J
    //   1596: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1599: pop
    //   1600: aload 11
    //   1602: ldc_w 338
    //   1605: aload 9
    //   1607: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1613: pop
    //   1614: aload_0
    //   1615: invokevirtual 340	com/tencent/hlyyb/downloader/e/i:g	()Z
    //   1618: ifeq +15 -> 1633
    //   1621: aload 11
    //   1623: ldc_w 342
    //   1626: ldc_w 265
    //   1629: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1632: pop
    //   1633: new 74	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1640: astore 9
    //   1642: aload 9
    //   1644: aload_0
    //   1645: invokevirtual 344	com/tencent/hlyyb/downloader/e/i:n	()Ljava/lang/String;
    //   1648: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: pop
    //   1652: aload 11
    //   1654: ldc_w 346
    //   1657: aload 9
    //   1659: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1665: pop
    //   1666: new 74	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1673: astore 9
    //   1675: aload 9
    //   1677: aload_0
    //   1678: invokevirtual 349	com/tencent/hlyyb/downloader/e/i:k	()Ljava/lang/String;
    //   1681: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: pop
    //   1685: aload 11
    //   1687: ldc_w 351
    //   1690: aload 9
    //   1692: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1695: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1698: pop
    //   1699: aload_0
    //   1700: getfield 354	com/tencent/hlyyb/downloader/e/i:x	Ljava/lang/String;
    //   1703: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1706: ifne +36 -> 1742
    //   1709: new 74	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1716: astore 9
    //   1718: aload 9
    //   1720: aload_0
    //   1721: getfield 354	com/tencent/hlyyb/downloader/e/i:x	Ljava/lang/String;
    //   1724: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: pop
    //   1728: aload 11
    //   1730: ldc_w 356
    //   1733: aload 9
    //   1735: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1741: pop
    //   1742: aload 11
    //   1744: ldc_w 358
    //   1747: aload_0
    //   1748: invokevirtual 360	com/tencent/hlyyb/downloader/e/i:p	()Ljava/lang/String;
    //   1751: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: pop
    //   1755: aload 11
    //   1757: ldc_w 362
    //   1760: aload_0
    //   1761: invokevirtual 365	com/tencent/hlyyb/downloader/e/i:q	()Ljava/lang/String;
    //   1764: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1767: pop
    //   1768: aload_0
    //   1769: invokevirtual 368	com/tencent/hlyyb/downloader/e/i:r	()Ljava/lang/String;
    //   1772: astore 9
    //   1774: aload 9
    //   1776: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1779: ifne +14 -> 1793
    //   1782: aload 11
    //   1784: ldc_w 370
    //   1787: aload 9
    //   1789: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1792: pop
    //   1793: aload_0
    //   1794: invokevirtual 373	com/tencent/hlyyb/downloader/e/i:s	()Ljava/lang/String;
    //   1797: astore 9
    //   1799: aload 9
    //   1801: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1804: ifne +14 -> 1818
    //   1807: aload 11
    //   1809: ldc_w 375
    //   1812: aload 9
    //   1814: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1817: pop
    //   1818: new 74	java/lang/StringBuilder
    //   1821: dup
    //   1822: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1825: astore 9
    //   1827: aload 9
    //   1829: aload_0
    //   1830: invokevirtual 377	com/tencent/hlyyb/downloader/e/i:u	()I
    //   1833: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1836: pop
    //   1837: aload 11
    //   1839: ldc_w 379
    //   1842: aload 9
    //   1844: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1850: pop
    //   1851: iload_1
    //   1852: iconst_2
    //   1853: if_icmpne +22 -> 1875
    //   1856: aload_0
    //   1857: invokevirtual 382	com/tencent/hlyyb/downloader/e/i:isPausedOnMobile	()Z
    //   1860: ifeq +15 -> 1875
    //   1863: aload 11
    //   1865: ldc_w 384
    //   1868: ldc_w 265
    //   1871: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1874: pop
    //   1875: aload 11
    //   1877: ldc 85
    //   1879: invokestatic 386	com/tencent/hlyyb/common/a:c	()Ljava/lang/String;
    //   1882: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1885: pop
    //   1886: new 74	java/lang/StringBuilder
    //   1889: dup
    //   1890: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   1893: astore_0
    //   1894: aload_0
    //   1895: invokestatic 387	com/tencent/hlyyb/common/a:d	()I
    //   1898: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1901: pop
    //   1902: aload 11
    //   1904: ldc_w 389
    //   1907: aload_0
    //   1908: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1914: pop
    //   1915: iload_2
    //   1916: ifne +6 -> 1922
    //   1919: iconst_1
    //   1920: istore 4
    //   1922: aload 8
    //   1924: iload 4
    //   1926: aload 11
    //   1928: invokestatic 392	com/tencent/hlyyb/common/a/f:a	(Ljava/lang/String;ZLjava/util/Map;)Z
    //   1931: pop
    //   1932: return
    //   1933: astore_0
    //   1934: goto +9 -> 1943
    //   1937: astore_0
    //   1938: aload_0
    //   1939: invokevirtual 395	java/lang/Throwable:printStackTrace	()V
    //   1942: return
    //   1943: aload_0
    //   1944: athrow
    //   1945: ldc_w 397
    //   1948: astore 8
    //   1950: goto -1908 -> 42
    //   1953: iconst_0
    //   1954: istore_3
    //   1955: goto -1206 -> 749
    //   1958: ldc2_w 398
    //   1961: lstore 6
    //   1963: goto -1040 -> 923
    //   1966: iload_2
    //   1967: bipush 216
    //   1969: if_icmpeq -810 -> 1159
    //   1972: iload_2
    //   1973: bipush 244
    //   1975: if_icmpeq -816 -> 1159
    //   1978: iload_2
    //   1979: bipush 211
    //   1981: if_icmpne -758 -> 1223
    //   1984: goto -825 -> 1159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1987	0	parami	i
    //   0	1987	1	paramInt	int
    //   18	1964	2	i	int
    //   745	1210	3	j	int
    //   20	1905	4	bool1	boolean
    //   1058	3	5	bool2	boolean
    //   918	1044	6	l	long
    //   37	1912	8	str	String
    //   63	1780	9	localObject1	Object
    //   1312	165	10	localObject2	Object
    //   12	1915	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   5	19	1933	finally
    //   28	35	1933	finally
    //   42	55	1933	finally
    //   56	252	1933	finally
    //   252	305	1933	finally
    //   305	347	1933	finally
    //   347	387	1933	finally
    //   387	427	1933	finally
    //   427	543	1933	finally
    //   543	585	1933	finally
    //   585	697	1933	finally
    //   697	744	1933	finally
    //   749	877	1933	finally
    //   881	888	1933	finally
    //   888	920	1933	finally
    //   923	1060	1933	finally
    //   1065	1077	1933	finally
    //   1077	1110	1933	finally
    //   1114	1156	1933	finally
    //   1159	1223	1933	finally
    //   1223	1320	1933	finally
    //   1331	1378	1933	finally
    //   1378	1454	1933	finally
    //   1465	1512	1933	finally
    //   1512	1523	1933	finally
    //   1527	1570	1933	finally
    //   1570	1614	1933	finally
    //   1614	1633	1933	finally
    //   1633	1742	1933	finally
    //   1742	1793	1933	finally
    //   1793	1818	1933	finally
    //   1818	1851	1933	finally
    //   1856	1875	1933	finally
    //   1875	1915	1933	finally
    //   1922	1932	1933	finally
    //   1938	1942	1933	finally
    //   5	19	1937	java/lang/Throwable
    //   28	35	1937	java/lang/Throwable
    //   42	55	1937	java/lang/Throwable
    //   56	252	1937	java/lang/Throwable
    //   252	305	1937	java/lang/Throwable
    //   305	347	1937	java/lang/Throwable
    //   347	387	1937	java/lang/Throwable
    //   387	427	1937	java/lang/Throwable
    //   427	543	1937	java/lang/Throwable
    //   543	585	1937	java/lang/Throwable
    //   585	697	1937	java/lang/Throwable
    //   697	744	1937	java/lang/Throwable
    //   749	877	1937	java/lang/Throwable
    //   881	888	1937	java/lang/Throwable
    //   888	920	1937	java/lang/Throwable
    //   923	1060	1937	java/lang/Throwable
    //   1065	1077	1937	java/lang/Throwable
    //   1077	1110	1937	java/lang/Throwable
    //   1114	1156	1937	java/lang/Throwable
    //   1159	1223	1937	java/lang/Throwable
    //   1223	1320	1937	java/lang/Throwable
    //   1331	1378	1937	java/lang/Throwable
    //   1378	1454	1937	java/lang/Throwable
    //   1465	1512	1937	java/lang/Throwable
    //   1512	1523	1937	java/lang/Throwable
    //   1527	1570	1937	java/lang/Throwable
    //   1570	1614	1937	java/lang/Throwable
    //   1614	1633	1937	java/lang/Throwable
    //   1633	1742	1937	java/lang/Throwable
    //   1742	1793	1937	java/lang/Throwable
    //   1793	1818	1937	java/lang/Throwable
    //   1818	1851	1937	java/lang/Throwable
    //   1856	1875	1937	java/lang/Throwable
    //   1875	1915	1937	java/lang/Throwable
    //   1922	1932	1937	java/lang/Throwable
  }
  
  private boolean g()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if ((locali.isRunning()) || (locali.isWaiting())) {
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final List<DownloaderTask> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    LinkedList localLinkedList = new LinkedList();
    label173:
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (!locali.isEaseTask()) {
          break label173;
        }
        if (paramBoolean2) {
          if (locali.isRunning() ? paramBoolean3 : locali.isWaiting() ? paramBoolean4 : locali.isPaused() ? paramBoolean5 : locali.isFailed() ? paramBoolean6 : (locali.isCompleted()) && (paramBoolean7)) {
            localLinkedList.add(locali);
          }
        }
      }
      return localLinkedList;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = d();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  /* Error */
  public final void a(DownloaderTask arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +330 -> 331
    //   4: aload_1
    //   5: instanceof 54
    //   8: ifne +6 -> 14
    //   11: goto +320 -> 331
    //   14: aload_1
    //   15: checkcast 54	com/tencent/hlyyb/downloader/e/i
    //   18: astore 5
    //   20: aload_0
    //   21: monitorenter
    //   22: aload 5
    //   24: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   27: invokestatic 460	com/tencent/hlyyb/common/b/b:a	(Ljava/lang/String;)Z
    //   30: ifeq +11 -> 41
    //   33: aload 5
    //   35: ldc_w 462
    //   38: putfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   41: aload 5
    //   43: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   46: ldc_w 464
    //   49: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +22 -> 74
    //   55: aload 5
    //   57: aload 5
    //   59: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   62: ldc_w 464
    //   65: ldc_w 462
    //   68: invokevirtual 471	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   71: putfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   74: aload 5
    //   76: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   79: invokestatic 473	com/tencent/hlyyb/downloader/a/a:g	(Ljava/lang/String;)Z
    //   82: istore_2
    //   83: ldc_w 462
    //   86: astore 4
    //   88: aload 4
    //   90: astore_3
    //   91: iload_2
    //   92: ifeq +159 -> 251
    //   95: aload_0
    //   96: invokevirtual 475	com/tencent/hlyyb/downloader/c/b:c	()Ljava/util/List;
    //   99: invokeinterface 447 1 0
    //   104: astore_3
    //   105: aload 4
    //   107: astore_1
    //   108: aload_3
    //   109: invokeinterface 408 1 0
    //   114: ifeq +120 -> 234
    //   117: aload_3
    //   118: invokeinterface 412 1 0
    //   123: checkcast 449	com/tencent/hlyyb/downloader/DownloaderTask
    //   126: astore_1
    //   127: aload 5
    //   129: getfield 477	com/tencent/hlyyb/downloader/e/i:h	Ljava/lang/String;
    //   132: aload_1
    //   133: invokeinterface 480 1 0
    //   138: invokevirtual 483	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   141: ifeq -36 -> 105
    //   144: aload 5
    //   146: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   149: astore 6
    //   151: aload_1
    //   152: checkcast 54	com/tencent/hlyyb/downloader/e/i
    //   155: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   158: invokestatic 473	com/tencent/hlyyb/downloader/a/a:g	(Ljava/lang/String;)Z
    //   161: ifeq +13 -> 174
    //   164: aload_1
    //   165: invokeinterface 486 1 0
    //   170: astore_1
    //   171: goto +10 -> 181
    //   174: aload_1
    //   175: invokeinterface 489 1 0
    //   180: astore_1
    //   181: aload 6
    //   183: aload_1
    //   184: invokevirtual 483	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   187: ifeq -82 -> 105
    //   190: new 74	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 491
    //   197: invokespecial 494	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: astore_1
    //   201: aload_1
    //   202: aload 5
    //   204: getfield 477	com/tencent/hlyyb/downloader/e/i:h	Ljava/lang/String;
    //   207: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: ldc_w 496
    //   215: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_1
    //   220: aload 5
    //   222: getfield 457	com/tencent/hlyyb/downloader/e/i:i	Ljava/lang/String;
    //   225: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_1
    //   234: aload_1
    //   235: astore_3
    //   236: ldc_w 462
    //   239: aload_1
    //   240: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifne +8 -> 251
    //   246: aload_0
    //   247: monitorexit
    //   248: goto +87 -> 335
    //   251: aload_0
    //   252: getfield 28	com/tencent/hlyyb/downloader/c/b:b	Ljava/util/Vector;
    //   255: astore_1
    //   256: aload_1
    //   257: monitorenter
    //   258: aload_0
    //   259: getfield 28	com/tencent/hlyyb/downloader/c/b:b	Ljava/util/Vector;
    //   262: aload 5
    //   264: invokevirtual 500	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   267: pop
    //   268: aload_1
    //   269: monitorexit
    //   270: aload 5
    //   272: invokevirtual 502	com/tencent/hlyyb/downloader/e/i:c	()V
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_3
    //   278: astore_1
    //   279: goto +56 -> 335
    //   282: astore_1
    //   283: goto +36 -> 319
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 505	com/tencent/hlyyb/common/HalleyException:getLocalizedMessage	()Ljava/lang/String;
    //   291: astore_3
    //   292: aload_0
    //   293: getfield 28	com/tencent/hlyyb/downloader/c/b:b	Ljava/util/Vector;
    //   296: astore_1
    //   297: aload_1
    //   298: monitorenter
    //   299: aload_0
    //   300: getfield 28	com/tencent/hlyyb/downloader/c/b:b	Ljava/util/Vector;
    //   303: aload 5
    //   305: invokevirtual 508	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   308: pop
    //   309: aload_1
    //   310: monitorexit
    //   311: goto -36 -> 275
    //   314: astore_3
    //   315: aload_1
    //   316: monitorexit
    //   317: aload_3
    //   318: athrow
    //   319: aload_1
    //   320: athrow
    //   321: astore_3
    //   322: aload_1
    //   323: monitorexit
    //   324: aload_3
    //   325: athrow
    //   326: astore_1
    //   327: aload_0
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    //   331: ldc_w 510
    //   334: astore_1
    //   335: ldc_w 462
    //   338: aload_1
    //   339: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq +4 -> 346
    //   345: return
    //   346: new 454	com/tencent/hlyyb/common/HalleyException
    //   349: dup
    //   350: aload_1
    //   351: invokespecial 511	com/tencent/hlyyb/common/HalleyException:<init>	(Ljava/lang/String;)V
    //   354: astore_1
    //   355: goto +5 -> 360
    //   358: aload_1
    //   359: athrow
    //   360: goto -2 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	b
    //   82	10	2	bool	boolean
    //   90	202	3	localObject1	Object
    //   314	4	3	localObject2	Object
    //   321	4	3	localObject3	Object
    //   86	20	4	str1	String
    //   18	286	5	locali	i
    //   149	33	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   270	275	282	finally
    //   287	299	282	finally
    //   317	319	282	finally
    //   270	275	286	com/tencent/hlyyb/common/HalleyException
    //   299	311	314	finally
    //   315	317	314	finally
    //   258	270	321	finally
    //   322	324	321	finally
    //   22	41	326	finally
    //   41	74	326	finally
    //   74	83	326	finally
    //   95	105	326	finally
    //   108	171	326	finally
    //   174	181	326	finally
    //   181	234	326	finally
    //   236	248	326	finally
    //   251	258	326	finally
    //   275	277	326	finally
    //   319	321	326	finally
    //   324	326	326	finally
    //   327	329	326	finally
  }
  
  public final void a(DownloaderTask paramDownloaderTask, boolean paramBoolean)
  {
    if (paramDownloaderTask == null) {
      return;
    }
    i locali = (i)paramDownloaderTask;
    locali.a(paramBoolean);
    synchronized (this.b)
    {
      this.b.remove(paramDownloaderTask);
      if (paramDownloaderTask.getStatus() != DownloaderTaskStatus.COMPLETE) {
        a(locali, 3);
      }
      if (g())
      {
        this.c.a();
        return;
      }
      this.c.b();
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      i locali;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locali = (i)localIterator.next();
      } while (!locali.getUniqueKey().equals(paramString));
      paramString = locali;
      if (paramString != null) {
        a(paramString, paramBoolean);
      }
      return;
    }
  }
  
  public final void b()
  {
    c localc = this.c;
    if (localc != null) {
      localc.c();
    }
  }
  
  public final List<DownloaderTask> c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      localLinkedList.addAll(this.b);
      return localLinkedList;
    }
  }
  
  public final List<DownloaderTask> d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali.isRunning()) {
          localLinkedList.add(locali);
        }
      }
      return localLinkedList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final boolean e()
  {
    Object localObject = d();
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    boolean bool1 = false;
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.a(i);
      boolean bool2;
      if (locali.isRunning()) {
        bool2 = locali.b();
      } else {
        bool2 = false;
      }
      if (bool2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final long f()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      long l = 0L;
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali.isRunning()) {
          l += locali.i();
        }
      }
      return l;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 0);
  }
  
  public final void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskFailedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 1);
  }
  
  public final void onTaskPausedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskPausedSubloop(DownloaderTask paramDownloaderTask)
  {
    a((i)paramDownloaderTask, 2);
  }
  
  public final void onTaskPendingMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public final void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (g())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final void onTaskStartedSubloop(DownloaderTask paramDownloaderTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.c.b
 * JD-Core Version:    0.7.0.1
 */