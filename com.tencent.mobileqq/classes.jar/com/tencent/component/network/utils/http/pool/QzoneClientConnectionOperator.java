package com.tencent.component.network.utils.http.pool;

import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class QzoneClientConnectionOperator
  extends DefaultClientConnectionOperator
{
  private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
  private final CustomDnsResolve customDnsResolve;
  
  public QzoneClientConnectionOperator(SchemeRegistry paramSchemeRegistry, CustomDnsResolve paramCustomDnsResolve)
  {
    super(paramSchemeRegistry);
    this.customDnsResolve = paramCustomDnsResolve;
  }
  
  /* Error */
  public void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, java.net.InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 34	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 36
    //   10: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: new 34	java/lang/IllegalArgumentException
    //   21: dup
    //   22: ldc 41
    //   24: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: aload 5
    //   30: ifnonnull +13 -> 43
    //   33: new 34	java/lang/IllegalArgumentException
    //   36: dup
    //   37: ldc 43
    //   39: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: aload_1
    //   44: invokeinterface 49 1 0
    //   49: ifeq +13 -> 62
    //   52: new 34	java/lang/IllegalArgumentException
    //   55: dup
    //   56: ldc 51
    //   58: invokespecial 39	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: aload_0
    //   63: getfield 55	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:schemeRegistry	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   66: aload_2
    //   67: invokevirtual 61	org/apache/http/HttpHost:getSchemeName	()Ljava/lang/String;
    //   70: invokevirtual 67	org/apache/http/conn/scheme/SchemeRegistry:getScheme	(Ljava/lang/String;)Lorg/apache/http/conn/scheme/Scheme;
    //   73: astore 14
    //   75: ldc 69
    //   77: aload_2
    //   78: invokevirtual 61	org/apache/http/HttpHost:getSchemeName	()Ljava/lang/String;
    //   81: invokevirtual 75	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   84: ifne +15 -> 99
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: aload_3
    //   91: aload 4
    //   93: aload 5
    //   95: invokespecial 77	org/apache/http/impl/conn/DefaultClientConnectionOperator:openConnection	(Lorg/apache/http/conn/OperatedClientConnection;Lorg/apache/http/HttpHost;Ljava/net/InetAddress;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   98: return
    //   99: aload 14
    //   101: invokevirtual 83	org/apache/http/conn/scheme/Scheme:getSocketFactory	()Lorg/apache/http/conn/scheme/SocketFactory;
    //   104: astore 11
    //   106: aload 11
    //   108: instanceof 85
    //   111: ifeq +97 -> 208
    //   114: getstatic 17	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:staticPlainSocketFactory	Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   117: astore 8
    //   119: aload 11
    //   121: checkcast 85	org/apache/http/conn/scheme/LayeredSocketFactory
    //   124: astore 9
    //   126: aload_0
    //   127: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   130: ifnull +88 -> 218
    //   133: aload_0
    //   134: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   137: aload_2
    //   138: invokevirtual 88	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   141: invokevirtual 94	com/tencent/component/network/utils/http/pool/CustomDnsResolve:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   144: astore 7
    //   146: ldc 96
    //   148: astore 10
    //   150: aload 7
    //   152: ifnull +97 -> 249
    //   155: iconst_0
    //   156: istore 6
    //   158: iload 6
    //   160: aload 7
    //   162: arraylength
    //   163: if_icmpge +61 -> 224
    //   166: new 98	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   173: aload 10
    //   175: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 7
    //   180: iload 6
    //   182: aaload
    //   183: invokevirtual 108	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   186: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 110
    //   191: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 10
    //   199: iload 6
    //   201: iconst_1
    //   202: iadd
    //   203: istore 6
    //   205: goto -47 -> 158
    //   208: aconst_null
    //   209: astore 9
    //   211: aload 11
    //   213: astore 8
    //   215: goto -89 -> 126
    //   218: aconst_null
    //   219: astore 7
    //   221: goto -75 -> 146
    //   224: ldc 115
    //   226: new 98	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   233: ldc 117
    //   235: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 10
    //   240: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 123	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 7
    //   251: ifnull +9 -> 260
    //   254: aload 7
    //   256: arraylength
    //   257: ifgt +330 -> 587
    //   260: aload_2
    //   261: invokevirtual 88	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   264: invokestatic 124	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   267: astore 7
    //   269: iconst_0
    //   270: istore 6
    //   272: iload 6
    //   274: aload 7
    //   276: arraylength
    //   277: if_icmpge -179 -> 98
    //   280: aload 8
    //   282: invokeinterface 130 1 0
    //   287: astore 12
    //   289: aload_1
    //   290: aload 12
    //   292: aload_2
    //   293: invokeinterface 134 3 0
    //   298: aload 8
    //   300: aload 12
    //   302: aload 7
    //   304: iload 6
    //   306: aaload
    //   307: invokevirtual 108	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   310: aload 14
    //   312: aload_2
    //   313: invokevirtual 138	org/apache/http/HttpHost:getPort	()I
    //   316: invokevirtual 142	org/apache/http/conn/scheme/Scheme:resolvePort	(I)I
    //   319: aload_3
    //   320: iconst_0
    //   321: aload 5
    //   323: invokeinterface 146 7 0
    //   328: astore 13
    //   330: aload 12
    //   332: astore 10
    //   334: aload 12
    //   336: aload 13
    //   338: if_acmpeq +16 -> 354
    //   341: aload_1
    //   342: aload 13
    //   344: aload_2
    //   345: invokeinterface 134 3 0
    //   350: aload 13
    //   352: astore 10
    //   354: aload 4
    //   356: ldc 148
    //   358: aload 7
    //   360: iload 6
    //   362: aaload
    //   363: invokevirtual 108	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   366: invokeinterface 154 3 0
    //   371: aload 9
    //   373: ifnull +162 -> 535
    //   376: aload 9
    //   378: aload 10
    //   380: aload_2
    //   381: invokevirtual 88	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   384: aload 14
    //   386: aload_2
    //   387: invokevirtual 138	org/apache/http/HttpHost:getPort	()I
    //   390: invokevirtual 142	org/apache/http/conn/scheme/Scheme:resolvePort	(I)I
    //   393: iconst_1
    //   394: invokeinterface 157 5 0
    //   399: astore 12
    //   401: aload 12
    //   403: aload 10
    //   405: if_acmpeq +12 -> 417
    //   408: aload_1
    //   409: aload 12
    //   411: aload_2
    //   412: invokeinterface 134 3 0
    //   417: aload_0
    //   418: aload 12
    //   420: aload 4
    //   422: aload 5
    //   424: invokevirtual 161	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:prepareSocket	(Ljava/net/Socket;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   427: aload_1
    //   428: aload 11
    //   430: aload 12
    //   432: invokeinterface 165 2 0
    //   437: aload 5
    //   439: invokeinterface 169 3 0
    //   444: return
    //   445: astore 10
    //   447: iload 6
    //   449: aload 7
    //   451: arraylength
    //   452: iconst_1
    //   453: isub
    //   454: if_icmpne +124 -> 578
    //   457: new 171	org/apache/http/conn/HttpHostConnectException
    //   460: dup
    //   461: aload_2
    //   462: aload 10
    //   464: invokespecial 174	org/apache/http/conn/HttpHostConnectException:<init>	(Lorg/apache/http/HttpHost;Ljava/net/ConnectException;)V
    //   467: athrow
    //   468: astore 10
    //   470: aload_0
    //   471: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   474: ifnull +58 -> 532
    //   477: ldc 115
    //   479: ldc 176
    //   481: aload 10
    //   483: invokestatic 180	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   486: aload_0
    //   487: getfield 24	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:customDnsResolve	Lcom/tencent/component/network/utils/http/pool/CustomDnsResolve;
    //   490: aload_2
    //   491: invokevirtual 88	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   494: invokevirtual 183	com/tencent/component/network/utils/http/pool/CustomDnsResolve:resolveByDns	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   497: astore 7
    //   499: aload 7
    //   501: ifnull +9 -> 510
    //   504: aload 7
    //   506: arraylength
    //   507: ifgt +15 -> 522
    //   510: ldc 115
    //   512: ldc 176
    //   514: aload 10
    //   516: invokestatic 180	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload 10
    //   521: athrow
    //   522: ldc 115
    //   524: ldc 185
    //   526: invokestatic 187	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: goto -260 -> 269
    //   532: aload 10
    //   534: athrow
    //   535: aload_0
    //   536: aload 10
    //   538: aload 4
    //   540: aload 5
    //   542: invokevirtual 161	com/tencent/component/network/utils/http/pool/QzoneClientConnectionOperator:prepareSocket	(Ljava/net/Socket;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/params/HttpParams;)V
    //   545: aload_1
    //   546: aload 11
    //   548: aload 10
    //   550: invokeinterface 165 2 0
    //   555: aload 5
    //   557: invokeinterface 169 3 0
    //   562: return
    //   563: astore 10
    //   565: iload 6
    //   567: aload 7
    //   569: arraylength
    //   570: iconst_1
    //   571: isub
    //   572: if_icmpne +6 -> 578
    //   575: aload 10
    //   577: athrow
    //   578: iload 6
    //   580: iconst_1
    //   581: iadd
    //   582: istore 6
    //   584: goto -312 -> 272
    //   587: goto -318 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	QzoneClientConnectionOperator
    //   0	590	1	paramOperatedClientConnection	OperatedClientConnection
    //   0	590	2	paramHttpHost	HttpHost
    //   0	590	3	paramInetAddress	java.net.InetAddress
    //   0	590	4	paramHttpContext	HttpContext
    //   0	590	5	paramHttpParams	HttpParams
    //   156	427	6	i	int
    //   144	424	7	arrayOfInetAddress	java.net.InetAddress[]
    //   117	182	8	localObject1	java.lang.Object
    //   124	253	9	localLayeredSocketFactory	org.apache.http.conn.scheme.LayeredSocketFactory
    //   148	256	10	localObject2	java.lang.Object
    //   445	18	10	localConnectException	java.net.ConnectException
    //   468	81	10	localThrowable	java.lang.Throwable
    //   563	13	10	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   104	443	11	localSocketFactory	org.apache.http.conn.scheme.SocketFactory
    //   287	144	12	localSocket1	Socket
    //   328	23	13	localSocket2	Socket
    //   73	312	14	localScheme	org.apache.http.conn.scheme.Scheme
    // Exception table:
    //   from	to	target	type
    //   298	330	445	java/net/ConnectException
    //   341	350	445	java/net/ConnectException
    //   354	371	445	java/net/ConnectException
    //   376	401	445	java/net/ConnectException
    //   408	417	445	java/net/ConnectException
    //   417	444	445	java/net/ConnectException
    //   535	562	445	java/net/ConnectException
    //   260	269	468	java/lang/Throwable
    //   298	330	563	org/apache/http/conn/ConnectTimeoutException
    //   341	350	563	org/apache/http/conn/ConnectTimeoutException
    //   354	371	563	org/apache/http/conn/ConnectTimeoutException
    //   376	401	563	org/apache/http/conn/ConnectTimeoutException
    //   408	417	563	org/apache/http/conn/ConnectTimeoutException
    //   417	444	563	org/apache/http/conn/ConnectTimeoutException
    //   535	562	563	org/apache/http/conn/ConnectTimeoutException
  }
  
  protected void prepareSocket(Socket paramSocket, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    super.prepareSocket(paramSocket, paramHttpContext, paramHttpParams);
  }
  
  public void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    super.updateSecureConnection(paramOperatedClientConnection, paramHttpHost, paramHttpContext, paramHttpParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.QzoneClientConnectionOperator
 * JD-Core Version:    0.7.0.1
 */