package com.tencent.luggage.wxa.qp;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qg.e;
import com.tencent.luggage.wxa.qg.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a
  implements IMediaHTTPConnection
{
  private com.tencent.luggage.wxa.qg.a a;
  private long b = -1L;
  private URL c = null;
  private URL d = null;
  private Map<String, String> e = null;
  private HttpURLConnection f = null;
  private long g = -1L;
  private String h = "";
  private InputStream i = null;
  private boolean j = true;
  private boolean k = true;
  private byte[] l = new byte[1];
  @NonNull
  private final Map<String, String> m;
  
  public a(@NonNull Map<String, String> paramMap)
  {
    this.m = paramMap;
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 74	com/tencent/luggage/wxa/qp/a:b	()V
    //   4: aload_0
    //   5: getfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   8: astore 9
    //   10: aload 9
    //   12: invokestatic 77	com/tencent/luggage/wxa/qp/a:a	(Ljava/net/URL;)Z
    //   15: istore 7
    //   17: iconst_0
    //   18: istore 5
    //   20: iconst_0
    //   21: istore_3
    //   22: iload 7
    //   24: ifeq +21 -> 45
    //   27: aload_0
    //   28: aload 9
    //   30: getstatic 83	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   33: invokevirtual 89	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   36: checkcast 91	java/net/HttpURLConnection
    //   39: putfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   42: goto +15 -> 57
    //   45: aload_0
    //   46: aload 9
    //   48: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   51: checkcast 91	java/net/HttpURLConnection
    //   54: putfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   57: aload_0
    //   58: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   61: sipush 30000
    //   64: invokevirtual 98	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload_0
    //   68: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   71: aload_0
    //   72: getfield 57	com/tencent/luggage/wxa/qp/a:j	Z
    //   75: invokevirtual 102	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   78: new 104	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   85: astore 9
    //   87: aload 9
    //   89: ldc 107
    //   91: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 9
    //   97: aload_0
    //   98: getfield 45	com/tencent/luggage/wxa/qp/a:e	Ljava/util/Map;
    //   101: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 116
    //   107: aload 9
    //   109: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 125	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 45	com/tencent/luggage/wxa/qp/a:e	Ljava/util/Map;
    //   119: ifnull +814 -> 933
    //   122: aload_0
    //   123: getfield 45	com/tencent/luggage/wxa/qp/a:e	Ljava/util/Map;
    //   126: invokeinterface 131 1 0
    //   131: invokeinterface 137 1 0
    //   136: astore 9
    //   138: iconst_0
    //   139: istore 4
    //   141: iload 4
    //   143: istore 6
    //   145: aload 9
    //   147: invokeinterface 143 1 0
    //   152: ifeq +68 -> 220
    //   155: aload 9
    //   157: invokeinterface 147 1 0
    //   162: checkcast 149	java/util/Map$Entry
    //   165: astore 10
    //   167: aload_0
    //   168: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   171: aload 10
    //   173: invokeinterface 152 1 0
    //   178: checkcast 154	java/lang/String
    //   181: aload 10
    //   183: invokeinterface 157 1 0
    //   188: checkcast 154	java/lang/String
    //   191: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: iload 4
    //   196: ifne -55 -> 141
    //   199: ldc 162
    //   201: aload 10
    //   203: invokeinterface 152 1 0
    //   208: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq -70 -> 141
    //   214: iconst_1
    //   215: istore 4
    //   217: goto -76 -> 141
    //   220: lload_1
    //   221: lconst_0
    //   222: lcmp
    //   223: ifle +53 -> 276
    //   226: aload_0
    //   227: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   230: astore 9
    //   232: new 104	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   239: astore 10
    //   241: aload 10
    //   243: ldc 168
    //   245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 10
    //   251: lload_1
    //   252: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 10
    //   258: ldc 173
    //   260: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 9
    //   266: ldc 175
    //   268: aload 10
    //   270: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iload 6
    //   278: ifne +14 -> 292
    //   281: aload_0
    //   282: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   285: ldc 162
    //   287: ldc 51
    //   289: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_0
    //   293: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   296: invokevirtual 179	java/net/HttpURLConnection:getResponseCode	()I
    //   299: istore 4
    //   301: aload_0
    //   302: getfield 43	com/tencent/luggage/wxa/qp/a:d	Ljava/net/URL;
    //   305: invokevirtual 180	java/net/URL:toString	()Ljava/lang/String;
    //   308: iload 4
    //   310: invokestatic 185	com/tencent/luggage/wxa/qg/g:a	(Ljava/lang/String;I)V
    //   313: iload 4
    //   315: sipush 300
    //   318: if_icmpeq +226 -> 544
    //   321: iload 4
    //   323: sipush 301
    //   326: if_icmpeq +218 -> 544
    //   329: iload 4
    //   331: sipush 302
    //   334: if_icmpeq +210 -> 544
    //   337: iload 4
    //   339: sipush 303
    //   342: if_icmpeq +202 -> 544
    //   345: iload 4
    //   347: sipush 307
    //   350: if_icmpeq +194 -> 544
    //   353: aload_0
    //   354: getfield 57	com/tencent/luggage/wxa/qp/a:j	Z
    //   357: ifeq +14 -> 371
    //   360: aload_0
    //   361: aload_0
    //   362: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   365: invokevirtual 189	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   368: putfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   371: iload 4
    //   373: sipush 206
    //   376: if_icmpne +66 -> 442
    //   379: aload_0
    //   380: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   383: ldc 191
    //   385: invokevirtual 195	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 9
    //   390: aload_0
    //   391: ldc2_w 36
    //   394: putfield 49	com/tencent/luggage/wxa/qp/a:g	J
    //   397: aload 9
    //   399: ifnull +63 -> 462
    //   402: aload 9
    //   404: bipush 47
    //   406: invokevirtual 199	java/lang/String:lastIndexOf	(I)I
    //   409: istore_3
    //   410: iload_3
    //   411: iflt +51 -> 462
    //   414: aload 9
    //   416: iload_3
    //   417: iconst_1
    //   418: iadd
    //   419: invokevirtual 203	java/lang/String:substring	(I)Ljava/lang/String;
    //   422: astore 9
    //   424: aload_0
    //   425: aload 9
    //   427: lconst_0
    //   428: invokestatic 208	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;J)J
    //   431: putfield 49	com/tencent/luggage/wxa/qp/a:g	J
    //   434: goto +28 -> 462
    //   437: astore 9
    //   439: goto +407 -> 846
    //   442: iload 4
    //   444: sipush 200
    //   447: if_icmpne +89 -> 536
    //   450: aload_0
    //   451: aload_0
    //   452: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   455: invokevirtual 211	java/net/HttpURLConnection:getContentLength	()I
    //   458: i2l
    //   459: putfield 49	com/tencent/luggage/wxa/qp/a:g	J
    //   462: aload_0
    //   463: getfield 53	com/tencent/luggage/wxa/qp/a:h	Ljava/lang/String;
    //   466: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifeq +470 -> 939
    //   472: aload_0
    //   473: aload_0
    //   474: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   477: invokevirtual 220	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   480: putfield 53	com/tencent/luggage/wxa/qp/a:h	Ljava/lang/String;
    //   483: ldc 116
    //   485: ldc 222
    //   487: iconst_1
    //   488: anewarray 4	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload_0
    //   494: getfield 53	com/tencent/luggage/wxa/qp/a:h	Ljava/lang/String;
    //   497: aastore
    //   498: invokestatic 227	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: goto +438 -> 939
    //   504: new 229	java/net/ProtocolException
    //   507: dup
    //   508: invokespecial 230	java/net/ProtocolException:<init>	()V
    //   511: athrow
    //   512: aload_0
    //   513: new 232	java/io/BufferedInputStream
    //   516: dup
    //   517: aload_0
    //   518: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   521: invokevirtual 236	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   524: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   527: putfield 55	com/tencent/luggage/wxa/qp/a:i	Ljava/io/InputStream;
    //   530: aload_0
    //   531: lload_1
    //   532: putfield 39	com/tencent/luggage/wxa/qp/a:b	J
    //   535: return
    //   536: new 70	java/io/IOException
    //   539: dup
    //   540: invokespecial 240	java/io/IOException:<init>	()V
    //   543: athrow
    //   544: iload 5
    //   546: iconst_1
    //   547: iadd
    //   548: istore 5
    //   550: iload 5
    //   552: bipush 20
    //   554: if_icmpgt +240 -> 794
    //   557: aload_0
    //   558: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   561: invokevirtual 243	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   564: astore 9
    //   566: iload 4
    //   568: sipush 307
    //   571: if_icmpne +36 -> 607
    //   574: aload 9
    //   576: ldc 245
    //   578: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   581: ifne +26 -> 607
    //   584: aload 9
    //   586: ldc 247
    //   588: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   591: ifeq +6 -> 597
    //   594: goto +13 -> 607
    //   597: new 249	java/net/NoRouteToHostException
    //   600: dup
    //   601: ldc 251
    //   603: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   606: athrow
    //   607: aload_0
    //   608: getfield 47	com/tencent/luggage/wxa/qp/a:f	Ljava/net/HttpURLConnection;
    //   611: ldc_w 256
    //   614: invokevirtual 195	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore 9
    //   619: aload 9
    //   621: ifnull +163 -> 784
    //   624: new 85	java/net/URL
    //   627: dup
    //   628: aload_0
    //   629: getfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   632: aload 9
    //   634: invokespecial 259	java/net/URL:<init>	(Ljava/net/URL;Ljava/lang/String;)V
    //   637: astore 9
    //   639: aload 9
    //   641: invokevirtual 262	java/net/URL:getProtocol	()Ljava/lang/String;
    //   644: ldc_w 264
    //   647: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   650: ifne +31 -> 681
    //   653: aload 9
    //   655: invokevirtual 262	java/net/URL:getProtocol	()Ljava/lang/String;
    //   658: ldc_w 266
    //   661: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +6 -> 670
    //   667: goto +14 -> 681
    //   670: new 249	java/net/NoRouteToHostException
    //   673: dup
    //   674: ldc_w 268
    //   677: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   680: athrow
    //   681: aload_0
    //   682: getfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   685: invokevirtual 262	java/net/URL:getProtocol	()Ljava/lang/String;
    //   688: aload 9
    //   690: invokevirtual 262	java/net/URL:getProtocol	()Ljava/lang/String;
    //   693: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: istore 8
    //   698: aload_0
    //   699: getfield 59	com/tencent/luggage/wxa/qp/a:k	Z
    //   702: ifne +22 -> 724
    //   705: iload 8
    //   707: ifeq +6 -> 713
    //   710: goto +14 -> 724
    //   713: new 249	java/net/NoRouteToHostException
    //   716: dup
    //   717: ldc_w 270
    //   720: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   723: athrow
    //   724: aload_0
    //   725: getfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   728: invokevirtual 273	java/net/URL:getHost	()Ljava/lang/String;
    //   731: aload 9
    //   733: invokevirtual 273	java/net/URL:getHost	()Ljava/lang/String;
    //   736: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   739: istore 8
    //   741: aload_0
    //   742: getfield 57	com/tencent/luggage/wxa/qp/a:j	Z
    //   745: ifne +22 -> 767
    //   748: iload 8
    //   750: ifeq +6 -> 756
    //   753: goto +14 -> 767
    //   756: new 249	java/net/NoRouteToHostException
    //   759: dup
    //   760: ldc_w 275
    //   763: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   766: athrow
    //   767: iload 4
    //   769: sipush 307
    //   772: if_icmpeq +184 -> 956
    //   775: aload_0
    //   776: aload 9
    //   778: putfield 41	com/tencent/luggage/wxa/qp/a:c	Ljava/net/URL;
    //   781: goto +175 -> 956
    //   784: new 249	java/net/NoRouteToHostException
    //   787: dup
    //   788: ldc 251
    //   790: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   793: athrow
    //   794: new 104	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   801: astore 9
    //   803: aload 9
    //   805: ldc_w 277
    //   808: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 9
    //   814: iload 5
    //   816: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: new 249	java/net/NoRouteToHostException
    //   823: dup
    //   824: aload 9
    //   826: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokespecial 254	java/net/NoRouteToHostException:<init>	(Ljava/lang/String;)V
    //   832: athrow
    //   833: astore 9
    //   835: iload_3
    //   836: istore 4
    //   838: goto +8 -> 846
    //   841: astore 9
    //   843: iconst_0
    //   844: istore 4
    //   846: aload_0
    //   847: ldc2_w 36
    //   850: putfield 49	com/tencent/luggage/wxa/qp/a:g	J
    //   853: aload_0
    //   854: invokespecial 282	com/tencent/luggage/wxa/qp/a:c	()V
    //   857: new 104	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   864: astore 10
    //   866: aload 10
    //   868: ldc 51
    //   870: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 10
    //   876: aload 9
    //   878: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 10
    //   884: ldc_w 284
    //   887: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 10
    //   893: iload 4
    //   895: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: ldc 116
    //   901: ldc_w 286
    //   904: iconst_1
    //   905: anewarray 4	java/lang/Object
    //   908: dup
    //   909: iconst_0
    //   910: aload 10
    //   912: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: aastore
    //   916: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: goto +6 -> 925
    //   922: aload 9
    //   924: athrow
    //   925: goto -3 -> 922
    //   928: astore 9
    //   930: goto -468 -> 462
    //   933: iconst_0
    //   934: istore 6
    //   936: goto -716 -> 220
    //   939: lload_1
    //   940: lconst_0
    //   941: lcmp
    //   942: ifle -430 -> 512
    //   945: iload 4
    //   947: sipush 206
    //   950: if_icmpne -446 -> 504
    //   953: goto -441 -> 512
    //   956: iload 4
    //   958: istore_3
    //   959: goto -937 -> 22
    //   962: astore 9
    //   964: goto -126 -> 838
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	this	a
    //   0	967	1	paramLong	long
    //   21	938	3	n	int
    //   139	818	4	i1	int
    //   18	797	5	i2	int
    //   143	792	6	i3	int
    //   15	8	7	bool1	boolean
    //   696	53	8	bool2	boolean
    //   8	418	9	localObject1	Object
    //   437	1	9	localIOException1	IOException
    //   564	261	9	localObject2	Object
    //   833	1	9	localIOException2	IOException
    //   841	82	9	localIOException3	IOException
    //   928	1	9	localNumberFormatException	java.lang.NumberFormatException
    //   962	1	9	localIOException4	IOException
    //   165	746	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   390	397	437	java/io/IOException
    //   27	42	833	java/io/IOException
    //   45	57	833	java/io/IOException
    //   57	138	833	java/io/IOException
    //   145	194	833	java/io/IOException
    //   199	214	833	java/io/IOException
    //   226	276	833	java/io/IOException
    //   281	292	833	java/io/IOException
    //   292	313	833	java/io/IOException
    //   4	17	841	java/io/IOException
    //   424	434	928	java/lang/NumberFormatException
    //   353	371	962	java/io/IOException
    //   379	390	962	java/io/IOException
    //   402	410	962	java/io/IOException
    //   414	424	962	java/io/IOException
    //   424	434	962	java/io/IOException
    //   450	462	962	java/io/IOException
    //   462	501	962	java/io/IOException
    //   504	512	962	java/io/IOException
    //   512	535	962	java/io/IOException
    //   536	544	962	java/io/IOException
    //   557	566	962	java/io/IOException
    //   574	594	962	java/io/IOException
    //   597	607	962	java/io/IOException
    //   607	619	962	java/io/IOException
    //   624	667	962	java/io/IOException
    //   670	681	962	java/io/IOException
    //   681	705	962	java/io/IOException
    //   713	724	962	java/io/IOException
    //   724	748	962	java/io/IOException
    //   756	767	962	java/io/IOException
    //   775	781	962	java/io/IOException
    //   784	794	962	java/io/IOException
    //   794	833	962	java/io/IOException
  }
  
  private static final boolean a(URL paramURL)
  {
    if (paramURL == null) {
      return false;
    }
    paramURL = paramURL.getHost();
    if (paramURL == null) {
      return false;
    }
    try
    {
      boolean bool = paramURL.equalsIgnoreCase("localhost");
      if (bool) {
        return true;
      }
    }
    catch (IllegalArgumentException paramURL)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramURL);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", new Object[] { localStringBuilder.toString() });
    }
    return false;
  }
  
  private void b()
  {
    InputStream localInputStream = this.i;
    if (localInputStream != null)
    {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException)
      {
        o.a("MicroMsg.Music.MMMediaHTTPConnection", localIOException, "teardownConnection", new Object[0]);
      }
      this.i = null;
    }
    HttpURLConnection localHttpURLConnection = this.f;
    if (localHttpURLConnection != null)
    {
      try
      {
        localHttpURLConnection.getInputStream().close();
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.Music.MMMediaHTTPConnection", localException.getMessage());
      }
      this.f.disconnect();
      this.f = null;
      this.b = -1L;
    }
  }
  
  private void c()
  {
    b();
  }
  
  public String a()
  {
    return this.d.toString();
  }
  
  public boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("connect: uri=");
    ((StringBuilder)localObject).append(paramURL);
    ((StringBuilder)localObject).append(", headers=");
    ((StringBuilder)localObject).append(paramMap);
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
    disconnect();
    this.j = true;
    this.c = paramURL;
    this.d = paramURL;
    this.e = paramMap;
    this.g = -1L;
    this.h = "";
    if (r.h())
    {
      paramURL = e.e(this.c.toString());
      if ((!TextUtils.isEmpty(paramURL)) && (!paramURL.equalsIgnoreCase(this.c.toString())))
      {
        o.d("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramURL });
        try
        {
          this.c = new URL(paramURL);
        }
        catch (MalformedURLException paramURL)
        {
          o.a("MicroMsg.Music.MMMediaHTTPConnection", paramURL, "playUrl", new Object[0]);
        }
      }
    }
    paramURL = this.c;
    if (paramURL != null)
    {
      g.a(paramURL.toString(), paramMap);
      paramURL = this.d.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("connect, originUrlStr: ");
      ((StringBuilder)localObject).append(paramURL);
      Logger.d("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      localObject = (String)this.m.get(paramURL);
      paramURL = paramMap;
      if (!"invalidReferrer".equals(localObject))
      {
        if (paramMap != null) {
          paramMap.remove("referer");
        }
        paramURL = paramMap;
        if (!af.c((String)localObject))
        {
          paramURL = new StringBuilder();
          paramURL.append("connect, add referrer: ");
          paramURL.append((String)localObject);
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", paramURL.toString());
          paramURL = paramMap;
          if (paramMap == null)
          {
            paramURL = new HashMap();
            this.e = paramURL;
          }
          try
          {
            paramURL.put("Referer", localObject);
          }
          catch (Exception paramMap)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("connect, put referrer fail since ");
            localStringBuilder.append(paramMap.toString());
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", localStringBuilder.toString());
            paramURL = new HashMap(paramURL);
            paramURL.put("Referer", localObject);
          }
        }
      }
      paramMap = new StringBuilder();
      paramMap.append("headers=");
      paramMap.append(paramURL);
      Logger.i("MicroMsg.Music.MMMediaHTTPConnection", paramMap.toString());
    }
    this.a = new com.tencent.luggage.wxa.qg.a(this);
    this.a.a();
    return true;
  }
  
  public void disconnect()
  {
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "disconnect");
    b();
    this.e = null;
    this.c = null;
    com.tencent.luggage.wxa.qg.a locala = this.a;
    if (locala != null)
    {
      locala.b();
      this.a = null;
    }
  }
  
  public String getMIMEType()
  {
    if (!TextUtils.isEmpty(this.h))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getMIMEType mimeType:");
      ((StringBuilder)localObject1).append(this.h);
      Logger.i("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject1).toString());
      return this.h;
    }
    Object localObject1 = g.e(a());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.h = ((String)localObject1);
      return localObject1;
    }
    Object localObject2 = this.f;
    localObject1 = "";
    long l1;
    if (localObject2 == null)
    {
      try
      {
        l1 = System.currentTimeMillis();
        a(0L);
        localObject2 = this.f.getContentType();
        o.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(localIOException);
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType exception:%s", new Object[] { localStringBuilder2.toString() });
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      localObject1 = this.f.getContentType();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getMIMEType mimeType:");
      localStringBuilder1.append((String)localObject1);
      Logger.i("MicroMsg.Music.MMMediaHTTPConnection", localStringBuilder1.toString());
      o.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    }
    this.h = ((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    localObject1 = g.d(a());
    this.h = ((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    return "application/octet-stream";
  }
  
  public long getSize()
  {
    long l1 = this.g;
    if (l1 > 0L) {
      return l1;
    }
    if (g.f(a()) > 0L)
    {
      this.g = g.f(a());
      return this.g;
    }
    if (this.f == null) {
      try
      {
        l1 = System.currentTimeMillis();
        a(0L);
        o.e("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localIOException);
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getSize exception:%s", new Object[] { localStringBuilder.toString() });
        this.g = -1L;
      }
    }
    l1 = this.g;
    if (l1 > 0L) {
      return l1;
    }
    if (g.g(a()) > 0L)
    {
      this.g = g.g(a());
      return this.g;
    }
    return -1L;
  }
  
  public String getUri()
  {
    return this.c.toString();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.l.length) {
      this.l = new byte[paramInt2];
    }
    Object localObject = this.l;
    int i1 = localObject.length;
    int n = 0;
    Arrays.fill((byte[])localObject, 0, i1, (byte)0);
    try
    {
      if (this.a != null)
      {
        i1 = this.a.a(this.l, (int)paramLong, paramInt2);
        if (i1 > 0)
        {
          if (i1 != paramInt2)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("read from cache, n%d, size %d ");
            ((StringBuilder)localObject).append(i1);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramInt2);
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
          }
          System.arraycopy(this.l, 0, paramArrayOfByte, paramInt1, i1);
          return i1;
        }
      }
      if ((this.g > 0L) && (paramLong >= this.g) && (paramInt2 > 0))
      {
        o.b("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.g), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        return 0;
      }
      Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
      if (paramLong != this.b) {
        a(paramLong);
      }
      i1 = this.i.read(this.l, 0, paramInt2);
      if (i1 == -1)
      {
        paramInt1 = n;
      }
      else
      {
        System.arraycopy(this.l, 0, paramArrayOfByte, paramInt1, i1);
        paramInt1 = i1;
      }
      this.b += paramInt1;
      if (this.a != null) {
        this.a.b(this.l, (int)paramLong, paramInt1);
      }
      return paramInt1;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown exception ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("readAt ");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(" / ");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(" => -1");
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", paramArrayOfByte.toString());
      g.b(this.d.toString(), 754);
      c();
      return -1;
    }
    catch (IOException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readAt ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" => -1 ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      g.b(this.d.toString(), 753);
      c();
      return -1;
    }
    catch (UnknownServiceException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readAt ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" => ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      g.b(this.d.toString(), 752);
      c();
      return -1010;
    }
    catch (NoRouteToHostException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readAt ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" => ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      g.b(this.d.toString(), 751);
      c();
      return -1010;
    }
    catch (ProtocolException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readAt ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" => ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", ((StringBuilder)localObject).toString());
      g.b(this.d.toString(), 750);
      c();
    }
    return -1010;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qp.a
 * JD-Core Version:    0.7.0.1
 */