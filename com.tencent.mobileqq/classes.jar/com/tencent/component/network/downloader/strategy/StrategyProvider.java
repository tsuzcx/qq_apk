package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.ClientOptions;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.HttpClient;

public class StrategyProvider
{
  private static final String TAG = "StrategyProvider";
  public static IPConfigStrategy backupIPConfigStrategy;
  public static IPConfigStrategy directIPConfigStrategy;
  public static PortConfigStrategy portConfigStrategy;
  private static HttpClient sHttpClient = null;
  private static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions = new StrategyProvider.1();
  private static HttpUtil.ClientOptions soptions = new HttpUtil.ClientOptions(true);
  
  /* Error */
  public static StrategyProvider.ExecuteResult exeHttpRequest(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, StrategyProvider.RequestProcessor paramRequestProcessor, org.apache.http.HttpRequest paramHttpRequest, com.tencent.component.network.downloader.DownloadResult paramDownloadResult, com.tencent.component.network.downloader.DownloadReport paramDownloadReport, java.net.Proxy paramProxy, HttpUtil.ClientOptions paramClientOptions)
  {
    // Byte code:
    //   0: new 46	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult
    //   3: dup
    //   4: invokespecial 47	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: aload_1
    //   11: iload_2
    //   12: invokestatic 51	com/tencent/component/network/downloader/strategy/StrategyProvider:generateStrategyInfo	(Ljava/lang/String;Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyLib;I)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +23 -> 40
    //   20: aload 10
    //   22: aconst_null
    //   23: putfield 55	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   26: aload 10
    //   28: aconst_null
    //   29: putfield 59	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   32: aload 10
    //   34: aload_1
    //   35: putfield 63	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   38: aconst_null
    //   39: areturn
    //   40: getstatic 38	com/tencent/component/network/downloader/strategy/StrategyProvider:sRequestOptions	Ljava/lang/ThreadLocal;
    //   43: invokevirtual 69	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   46: checkcast 71	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   49: astore 11
    //   51: aload 11
    //   53: aload_1
    //   54: getfield 77	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:allowProxy	Z
    //   57: putfield 78	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   60: aload 11
    //   62: aload_1
    //   63: getfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:useConfigApn	Z
    //   66: putfield 84	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   69: aload 11
    //   71: aload 7
    //   73: putfield 88	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   76: aload_1
    //   77: ifnull +483 -> 560
    //   80: aload_1
    //   81: invokevirtual 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   84: ifnull +476 -> 560
    //   87: aload_1
    //   88: invokevirtual 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   91: getfield 97	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   94: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +463 -> 560
    //   100: aload_1
    //   101: invokevirtual 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   104: getfield 97	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   107: astore 4
    //   109: aload 4
    //   111: bipush 58
    //   113: invokestatic 109	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   116: iconst_2
    //   117: if_icmpge +437 -> 554
    //   120: aload_0
    //   121: invokestatic 113	com/tencent/component/network/downloader/common/Utils:getPort	(Ljava/lang/String;)I
    //   124: istore_2
    //   125: iload_2
    //   126: ifle +14 -> 140
    //   129: aload_1
    //   130: invokevirtual 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   133: iload_2
    //   134: putfield 117	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   137: goto +11 -> 148
    //   140: aload_1
    //   141: invokevirtual 92	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   144: getfield 117	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   147: istore_2
    //   148: iload_2
    //   149: istore 9
    //   151: iload_2
    //   152: invokestatic 121	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   155: ifne +7 -> 162
    //   158: bipush 80
    //   160: istore 9
    //   162: new 123	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   169: astore 7
    //   171: aload 7
    //   173: aload 4
    //   175: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 7
    //   181: ldc 130
    //   183: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 7
    //   189: iload 9
    //   191: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 7
    //   197: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 12
    //   202: aload_0
    //   203: aload_0
    //   204: invokestatic 141	com/tencent/component/network/downloader/common/Utils:getDominWithPort	(Ljava/lang/String;)Ljava/lang/String;
    //   207: aload 12
    //   209: invokevirtual 147	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 7
    //   214: aload 7
    //   216: astore 4
    //   218: invokestatic 153	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   221: ifeq +98 -> 319
    //   224: new 123	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   231: astore 4
    //   233: aload 4
    //   235: ldc 155
    //   237: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 4
    //   243: aload_1
    //   244: invokevirtual 156	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   247: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: ldc 158
    //   255: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 4
    //   261: aload 12
    //   263: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 4
    //   269: ldc 160
    //   271: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 4
    //   277: aload_0
    //   278: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: ldc 162
    //   286: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 4
    //   292: invokestatic 168	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   295: invokevirtual 172	java/lang/Thread:getId	()J
    //   298: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: ldc 8
    //   304: aload 4
    //   306: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 179	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 7
    //   314: astore 4
    //   316: goto +3 -> 319
    //   319: aload 4
    //   321: astore 7
    //   323: aload 6
    //   325: ifnull +19 -> 344
    //   328: aload 6
    //   330: aload_1
    //   331: invokevirtual 156	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   334: putfield 183	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   337: aload 4
    //   339: astore 7
    //   341: goto +3 -> 344
    //   344: invokestatic 189	com/tencent/component/network/Global:getContext	()Landroid/content/Context;
    //   347: aload_0
    //   348: aload_0
    //   349: invokestatic 192	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   352: aload 7
    //   354: aload 11
    //   356: invokestatic 198	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   359: astore 7
    //   361: aload_3
    //   362: ifnull +19 -> 381
    //   365: aload_1
    //   366: astore 4
    //   368: aload 7
    //   370: astore 6
    //   372: aload_3
    //   373: aload_0
    //   374: aload 7
    //   376: invokeinterface 204 3 0
    //   381: aload_1
    //   382: astore 4
    //   384: aload 7
    //   386: astore 6
    //   388: invokestatic 208	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   391: astore_0
    //   392: aload_1
    //   393: astore 4
    //   395: aload 7
    //   397: astore 6
    //   399: aload 10
    //   401: aload_0
    //   402: putfield 212	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:context	Lorg/apache/http/protocol/HttpContext;
    //   405: aload_1
    //   406: astore 4
    //   408: aload 7
    //   410: astore 6
    //   412: aload 8
    //   414: invokestatic 216	com/tencent/component/network/downloader/strategy/StrategyProvider:obtainHttpClient	(Lcom/tencent/component/network/utils/http/HttpUtil$ClientOptions;)Lorg/apache/http/client/HttpClient;
    //   417: aload 7
    //   419: aload_0
    //   420: invokeinterface 222 3 0
    //   425: astore_0
    //   426: aload 10
    //   428: aload 7
    //   430: putfield 55	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   433: aload 10
    //   435: aload_0
    //   436: putfield 59	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   439: goto +81 -> 520
    //   442: astore_3
    //   443: aload 7
    //   445: astore_0
    //   446: goto +30 -> 476
    //   449: astore_0
    //   450: aconst_null
    //   451: astore 6
    //   453: goto +80 -> 533
    //   456: astore_3
    //   457: aconst_null
    //   458: astore_0
    //   459: goto +17 -> 476
    //   462: astore_0
    //   463: aconst_null
    //   464: astore_1
    //   465: aload_1
    //   466: astore 6
    //   468: goto +65 -> 533
    //   471: astore_3
    //   472: aconst_null
    //   473: astore_1
    //   474: aload_1
    //   475: astore_0
    //   476: aload 5
    //   478: ifnull +18 -> 496
    //   481: aload_1
    //   482: astore 4
    //   484: aload_0
    //   485: astore 6
    //   487: aload 5
    //   489: invokevirtual 228	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   492: aload_3
    //   493: invokevirtual 234	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   496: aload_1
    //   497: astore 4
    //   499: aload_0
    //   500: astore 6
    //   502: aload 10
    //   504: aload_3
    //   505: putfield 238	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:exception	Ljava/lang/Throwable;
    //   508: aload 10
    //   510: aload_0
    //   511: putfield 55	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   514: aload 10
    //   516: aconst_null
    //   517: putfield 59	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   520: aload 10
    //   522: aload_1
    //   523: putfield 63	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   526: aload 10
    //   528: areturn
    //   529: astore_0
    //   530: aload 4
    //   532: astore_1
    //   533: aload 10
    //   535: aload 6
    //   537: putfield 55	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:request	Lorg/apache/http/client/methods/HttpGet;
    //   540: aload 10
    //   542: aconst_null
    //   543: putfield 59	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:response	Lorg/apache/http/HttpResponse;
    //   546: aload 10
    //   548: aload_1
    //   549: putfield 63	com/tencent/component/network/downloader/strategy/StrategyProvider$ExecuteResult:strategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   552: aload_0
    //   553: athrow
    //   554: aload_0
    //   555: astore 4
    //   557: goto -238 -> 319
    //   560: aload_0
    //   561: astore 7
    //   563: goto -219 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	paramString	String
    //   0	566	1	paramStrategyLib	DownloadGlobalStrategy.StrategyLib
    //   0	566	2	paramInt	int
    //   0	566	3	paramRequestProcessor	StrategyProvider.RequestProcessor
    //   0	566	4	paramHttpRequest	org.apache.http.HttpRequest
    //   0	566	5	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   0	566	6	paramDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   0	566	7	paramProxy	java.net.Proxy
    //   0	566	8	paramClientOptions	HttpUtil.ClientOptions
    //   149	41	9	i	int
    //   7	540	10	localExecuteResult	StrategyProvider.ExecuteResult
    //   49	306	11	localRequestOptions	HttpUtil.RequestOptions
    //   200	62	12	str	String
    // Exception table:
    //   from	to	target	type
    //   372	381	442	java/lang/Throwable
    //   388	392	442	java/lang/Throwable
    //   399	405	442	java/lang/Throwable
    //   412	426	442	java/lang/Throwable
    //   40	76	449	finally
    //   80	125	449	finally
    //   129	137	449	finally
    //   140	148	449	finally
    //   151	158	449	finally
    //   162	214	449	finally
    //   218	312	449	finally
    //   328	337	449	finally
    //   344	361	449	finally
    //   40	76	456	java/lang/Throwable
    //   80	125	456	java/lang/Throwable
    //   129	137	456	java/lang/Throwable
    //   140	148	456	java/lang/Throwable
    //   151	158	456	java/lang/Throwable
    //   162	214	456	java/lang/Throwable
    //   218	312	456	java/lang/Throwable
    //   328	337	456	java/lang/Throwable
    //   344	361	456	java/lang/Throwable
    //   9	16	462	finally
    //   9	16	471	java/lang/Throwable
    //   372	381	529	finally
    //   388	392	529	finally
    //   399	405	529	finally
    //   412	426	529	finally
    //   487	496	529	finally
    //   502	508	529	finally
  }
  
  public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStrategyLib != null))
    {
      if (paramInt < 0) {
        return null;
      }
      Object localObject1 = paramStrategyLib.getOldStrategyInfo();
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = paramStrategyLib.getStrategyInfo(paramInt);
      paramStrategyLib.setOldStrategyInfo(localStrategyInfo);
      if (QDLog.isInfoEnable())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloader strategy: ");
        ((StringBuilder)localObject2).append(localStrategyInfo.toString());
        ((StringBuilder)localObject2).append(" currAttempCount:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" best:");
        ((StringBuilder)localObject2).append(paramStrategyLib.getBestId());
        ((StringBuilder)localObject2).append(" url:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" Apn:");
        ((StringBuilder)localObject2).append(NetworkManager.getApnValue());
        ((StringBuilder)localObject2).append(" ISP:");
        ((StringBuilder)localObject2).append(NetworkManager.getIspType());
        ((StringBuilder)localObject2).append(" threadid:");
        ((StringBuilder)localObject2).append(Thread.currentThread().getId());
        QDLog.i("StrategyProvider", ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = Utils.getDomin(paramString);
      int i = paramStrategyLib.getPort();
      paramInt = i;
      if (!Utils.isPortValid(i))
      {
        paramStrategyLib.setPort(80);
        paramInt = 80;
      }
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject1 != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == ((DownloadGlobalStrategy.StrategyInfo)localObject1).id)
          {
            paramString = portConfigStrategy;
            if ((paramString != null) && (paramString.supportExtraPort((String)localObject2)))
            {
              i = portConfigStrategy.changePort((String)localObject2, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break label413;
              }
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! port:");
                paramString.append(paramInt);
                paramString.append(" newport:");
                paramString.append(i);
                paramString.append(" threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! Not support !80. threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
          }
        }
        label413:
        localObject1 = paramStrategyLib.getBackupIP();
        localIPConfigStrategy = backupIPConfigStrategy;
        paramString = (String)localObject1;
        if (localIPConfigStrategy != null)
        {
          paramString = (String)localObject1;
          if (!localIPConfigStrategy.isIPValid((String)localObject1, (String)localObject2))
          {
            paramStrategyLib.setBackupIP(null);
            paramString = backupIPConfigStrategy.resolveIP((String)localObject2);
            if (!TextUtils.isEmpty(paramString))
            {
              paramStrategyLib.setBackupIP(paramString);
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: backup ip is null. Pass! threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
          }
        }
        if ((paramString != null) && (!paramString.equals(paramStrategyLib.getDirectIP())) && (!paramString.equals(paramStrategyLib.getDnsIP())))
        {
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (QDLog.isInfoEnable())
        {
          paramString = new StringBuilder();
          paramString.append("downloader strategy: Pass! Domain IP 重复. threadId:");
          paramString.append(Thread.currentThread().getId());
          QDLog.i("StrategyProvider", paramString.toString());
        }
        return null;
      }
      if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject1 != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == ((DownloadGlobalStrategy.StrategyInfo)localObject1).id)
          {
            paramString = portConfigStrategy;
            if ((paramString != null) && (paramString.supportExtraPort((String)localObject2)))
            {
              i = portConfigStrategy.changePort((String)localObject2, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break label811;
              }
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! port:");
                paramString.append(paramInt);
                paramString.append(" newport:");
                paramString.append(i);
                paramString.append(" threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! Not support !80. threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
          }
        }
        label811:
        paramString = DnsService.getInstance().getDomainIP((String)localObject2);
        if ((paramString != null) && (!paramString.equals(paramStrategyLib.getBackupIP())) && (!paramString.equals(paramStrategyLib.getDirectIP())))
        {
          paramStrategyLib.setDnsIP(paramString);
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (QDLog.isInfoEnable())
        {
          paramString = new StringBuilder();
          paramString.append("downloader strategy: Pass! Domain IP 重复. threadId:");
          paramString.append(Thread.currentThread().getId());
          QDLog.i("StrategyProvider", paramString.toString());
        }
        return null;
      }
      if (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject1 != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DomainDirect.id == ((DownloadGlobalStrategy.StrategyInfo)localObject1).id)
          {
            paramString = portConfigStrategy;
            if ((paramString != null) && (paramString.supportExtraPort((String)localObject2)))
            {
              i = portConfigStrategy.changePort((String)localObject2, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break label1149;
              }
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! port:");
                paramString.append(paramInt);
                paramString.append(" newport:");
                paramString.append(i);
                paramString.append(" threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
            else
            {
              if (QDLog.isInfoEnable())
              {
                paramString = new StringBuilder();
                paramString.append("downloader strategy: Pass! Not support !80. threadId:");
                paramString.append(Thread.currentThread().getId());
                QDLog.i("StrategyProvider", paramString.toString());
              }
              return null;
            }
          }
        }
      }
      else
      {
        if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == localStrategyInfo.id) {
          break label1385;
        }
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {
          break label1385;
        }
      }
      label1149:
      localObject1 = paramStrategyLib.getDirectIP();
      IPConfigStrategy localIPConfigStrategy = directIPConfigStrategy;
      paramString = (String)localObject1;
      if (localIPConfigStrategy != null)
      {
        paramString = (String)localObject1;
        if (!localIPConfigStrategy.isIPValid((String)localObject1, (String)localObject2))
        {
          localObject1 = directIPConfigStrategy.resolveIP((String)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramStrategyLib.setDirectIP((String)localObject1);
            paramString = (String)localObject1;
          }
          else
          {
            if (QDLog.isInfoEnable())
            {
              paramString = new StringBuilder();
              paramString.append("downloader strategy: resolve ip failed! threadId:");
              paramString.append(Thread.currentThread().getId());
              QDLog.i("StrategyProvider", paramString.toString());
            }
            paramString = (String)localObject1;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id != localStrategyInfo.id)
            {
              paramString = (String)localObject1;
              if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != localStrategyInfo.id) {
                return null;
              }
            }
          }
        }
      }
      if ((paramString != null) && (!paramString.equals(paramStrategyLib.getBackupIP())) && (!paramString.equals(paramStrategyLib.getDnsIP())))
      {
        paramStrategyLib = localStrategyInfo.clone();
        paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
        return paramStrategyLib;
      }
      if (QDLog.isInfoEnable())
      {
        paramString = new StringBuilder();
        paramString.append("downloader strategy: Pass! Domain IP 重复. threadId:");
        paramString.append(Thread.currentThread().getId());
        QDLog.i("StrategyProvider", paramString.toString());
      }
      return null;
      label1385:
      paramString = Global.getContext();
      boolean bool;
      if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {
        bool = true;
      } else {
        bool = false;
      }
      if (NetworkUtils.getProxy(paramString, bool) == null)
      {
        if (QDLog.isInfoEnable())
        {
          paramString = new StringBuilder();
          paramString.append("downloader strategy: proxy is null. Pass! threadId:");
          paramString.append(Thread.currentThread().getId());
          QDLog.i("StrategyProvider", paramString.toString());
        }
        return null;
      }
      return localStrategyInfo;
    }
    return null;
  }
  
  private static void initHttpClient(QZoneHttpClient paramQZoneHttpClient) {}
  
  private static HttpClient obtainHttpClient(HttpUtil.ClientOptions paramClientOptions)
  {
    HttpClient localHttpClient = sHttpClient;
    if (localHttpClient != null) {
      return localHttpClient;
    }
    if (paramClientOptions == null) {}
    try
    {
      paramClientOptions = soptions;
      sHttpClient = HttpUtil.createHttpClient(paramClientOptions);
      return sHttpClient;
    }
    finally {}
  }
  
  public static void onIPDownloadResult(String paramString, IPInfo paramIPInfo, boolean paramBoolean)
  {
    String str = Utils.getDomin(paramString);
    if (!TextUtils.isEmpty(str))
    {
      if (paramIPInfo == null) {
        return;
      }
      if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null) {
        DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
      }
      if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null) {
        DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
      }
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = new DownloadGlobalStrategy.StrategyInfo(false, false, false);
      localStrategyInfo.id = 0;
      localStrategyInfo.setIPInfo(paramIPInfo);
      DownloadGlobalStrategy.getInstance(Global.getContext()).report(Global.getContext(), paramString, str, localStrategyInfo, paramBoolean);
    }
  }
  
  public static List<IPInfo> provideIPList(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str1 = null;
    if (bool) {
      return null;
    }
    String str2 = Utils.getDomin(paramString);
    if (TextUtils.isEmpty(str2)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = DownloadGlobalStrategy.getInstance(Global.getContext()).getBestStrategyInfo(paramString, str2);
    paramString = str1;
    int i;
    if (localStrategyInfo != null)
    {
      paramString = str1;
      if (localStrategyInfo.getIPInfo() != null)
      {
        paramString = str1;
        if (localStrategyInfo.isIPValid())
        {
          paramString = localStrategyInfo.getIPInfo().ip;
          ((List)localObject).add(paramString);
          if (localStrategyInfo.getIPInfo().port != 0) {
            i = localStrategyInfo.getIPInfo().port;
          } else {
            i = 80;
          }
          localArrayList2.add(Integer.valueOf(i));
        }
      }
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getPortStrategy() != null) {
      if (localArrayList2.size() > 0)
      {
        i = DownloaderFactory.getInstance(Global.getContext()).getPortStrategy().changePort(str2, ((Integer)localArrayList2.get(0)).intValue());
        if (i != ((Integer)localArrayList2.get(0)).intValue()) {
          localArrayList2.add(Integer.valueOf(i));
        }
      }
      else
      {
        localArrayList2.add(Integer.valueOf(80));
      }
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null)
    {
      str1 = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveIP(str2);
      if ((!TextUtils.isEmpty(str1)) && (!str1.equalsIgnoreCase(paramString))) {
        ((List)localObject).add(str1);
      }
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null)
    {
      str1 = DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().resolveIP(str2);
      if ((!TextUtils.isEmpty(str1)) && (!str1.equalsIgnoreCase(paramString))) {
        ((List)localObject).add(str1);
      }
    }
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      str1 = (String)paramString.next();
      localObject = localArrayList2.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList1.add(new IPInfo(str1, ((Integer)((Iterator)localObject).next()).intValue()));
      }
    }
    return localArrayList1;
  }
  
  public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = Utils.getDomin(paramString);
    return DownloadGlobalStrategy.getInstance(Global.getContext()).getStrategyLib(paramString, str, false);
  }
  
  public static List<IPInfo> provideVideoIPList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Utils.getDomin(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    paramString = new ArrayList();
    try
    {
      if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null)
      {
        localObject = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveVideoIP((String)localObject);
        if (localObject != null)
        {
          int i = ((List)localObject).size();
          if (i > 0) {
            return localObject;
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QDLog.isInfoEnable())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("provide video ip list error = ");
        localStringBuilder.append(localException.toString());
        QDLog.i("StrategyProvider", localStringBuilder.toString());
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */