package com.tencent.component.network.module.report;

import android.util.Log;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;

public class ImageDownloadReporter
  implements ReportHandler
{
  private static final String CONTENTTYPE_HTML = "text/html";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        int k = i * 2;
        char[] arrayOfChar2 = digits;
        arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
        arrayOfChar1[k] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return null;
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
    int i = paramInt;
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof ClientProtocolException)) {
        return 8;
      }
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof NoHttpResponseException)) {
        return 11;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof ConnectionPoolTimeoutException)) {
        return 13;
      }
      if ((paramThrowable instanceof SSLHandshakeException)) {
        return 15;
      }
      if ((paramThrowable instanceof ConnectTimeoutException)) {
        return 10;
      }
      if ((paramThrowable instanceof IllegalStateException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("Connection is not open"))) {
          return 50007;
        }
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No space left on device"))) {
          return 50003;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Network is unreachable"))) {
          return 50004;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("No route to host"))) {
          return 50005;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Connection refused"))) {
          return 50006;
        }
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      i = paramInt;
      if ((paramThrowable instanceof OutOfMemoryError)) {
        i = 3;
      }
    }
    return i;
  }
  
  private int getRetCodeFrom(HttpResponse paramHttpResponse, Response paramResponse, int paramInt)
  {
    int i;
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse == null) {
        paramHttpResponse = null;
      } else {
        paramHttpResponse = paramHttpResponse.headerIterator("Retcode");
      }
      if (paramHttpResponse != null) {
        while (paramHttpResponse.hasNext())
        {
          paramResponse = paramHttpResponse.nextHeader();
          if (paramResponse != null) {
            try
            {
              i = Integer.parseInt(paramResponse.getValue());
              return i;
            }
            catch (NumberFormatException paramResponse)
            {
              QDLog.w("ImageDownload", "getRetCodeFrom", paramResponse);
            }
          }
        }
      }
    }
    else if (paramResponse != null)
    {
      paramHttpResponse = paramResponse.headers("Retcode");
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.iterator();
        while (paramHttpResponse.hasNext())
        {
          paramResponse = (String)paramHttpResponse.next();
          if (paramResponse != null) {
            try
            {
              i = Integer.parseInt(paramResponse);
              return i;
            }
            catch (NumberFormatException paramResponse)
            {
              QDLog.w("ImageDownload", "getRetCodeFrom", paramResponse);
            }
          }
        }
      }
    }
    return paramInt;
  }
  
  /* Error */
  private static byte[] readFromFile(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +172 -> 173
    //   4: aload_0
    //   5: invokevirtual 168	java/io/File:exists	()Z
    //   8: ifeq +165 -> 173
    //   11: aload_0
    //   12: invokevirtual 171	java/io/File:isFile	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: invokevirtual 175	java/io/File:length	()J
    //   24: lstore 6
    //   26: lload_1
    //   27: lstore 4
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifge +6 -> 38
    //   35: lconst_0
    //   36: lstore 4
    //   38: lload 4
    //   40: lload 6
    //   42: lcmp
    //   43: ifge +130 -> 173
    //   46: iload_3
    //   47: ifgt +5 -> 52
    //   50: aconst_null
    //   51: areturn
    //   52: iload_3
    //   53: lload 6
    //   55: lload 4
    //   57: lsub
    //   58: l2i
    //   59: invokestatic 181	java/lang/Math:min	(II)I
    //   62: istore_3
    //   63: iload_3
    //   64: newarray byte
    //   66: astore 9
    //   68: new 183	java/io/RandomAccessFile
    //   71: dup
    //   72: aload_0
    //   73: ldc 185
    //   75: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   78: astore 8
    //   80: aload 8
    //   82: lload 4
    //   84: invokevirtual 192	java/io/RandomAccessFile:seek	(J)V
    //   87: aload 8
    //   89: aload 9
    //   91: invokevirtual 196	java/io/RandomAccessFile:read	([B)I
    //   94: istore_3
    //   95: iload_3
    //   96: ifgt +8 -> 104
    //   99: aconst_null
    //   100: astore_0
    //   101: goto +29 -> 130
    //   104: iload_3
    //   105: aload 9
    //   107: arraylength
    //   108: if_icmpge +19 -> 127
    //   111: iload_3
    //   112: newarray byte
    //   114: astore_0
    //   115: aload 9
    //   117: iconst_0
    //   118: aload_0
    //   119: iconst_0
    //   120: iload_3
    //   121: invokestatic 202	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   124: goto +6 -> 130
    //   127: aload 9
    //   129: astore_0
    //   130: aload 8
    //   132: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   135: aload_0
    //   136: areturn
    //   137: astore_0
    //   138: goto +10 -> 148
    //   141: goto +22 -> 163
    //   144: astore_0
    //   145: aconst_null
    //   146: astore 8
    //   148: aload 8
    //   150: ifnull +8 -> 158
    //   153: aload 8
    //   155: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   158: aload_0
    //   159: athrow
    //   160: aconst_null
    //   161: astore 8
    //   163: aload 8
    //   165: ifnull +8 -> 173
    //   168: aload 8
    //   170: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: goto -16 -> 160
    //   179: astore_0
    //   180: goto -39 -> 141
    //   183: astore 8
    //   185: aload_0
    //   186: areturn
    //   187: astore 8
    //   189: goto -31 -> 158
    //   192: astore_0
    //   193: aconst_null
    //   194: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramFile	File
    //   0	195	1	paramLong	long
    //   0	195	3	paramInt	int
    //   27	56	4	l1	long
    //   24	30	6	l2	long
    //   78	91	8	localRandomAccessFile	java.io.RandomAccessFile
    //   183	1	8	localIOException1	IOException
    //   187	1	8	localIOException2	IOException
    //   66	62	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   80	95	137	finally
    //   104	124	137	finally
    //   63	80	144	finally
    //   63	80	175	java/lang/Throwable
    //   80	95	179	java/lang/Throwable
    //   104	124	179	java/lang/Throwable
    //   130	135	183	java/io/IOException
    //   153	158	187	java/io/IOException
    //   168	173	192	java/io/IOException
  }
  
  /* Error */
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4: getfield 218	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload 4
    //   21: ldc 10
    //   23: invokestatic 229	com/tencent/component/network/utils/StringUtil:startsWithIgnoreCase	(Ljava/lang/String;Ljava/lang/String;)Z
    //   26: ifeq +161 -> 187
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 4
    //   35: aload_2
    //   36: invokeinterface 233 1 0
    //   41: invokeinterface 238 1 0
    //   46: astore_2
    //   47: aload_2
    //   48: astore 4
    //   50: aload_2
    //   51: astore 5
    //   53: sipush 1024
    //   56: newarray byte
    //   58: astore 6
    //   60: aload_2
    //   61: astore 4
    //   63: aload_2
    //   64: astore 5
    //   66: aload_2
    //   67: aload 6
    //   69: invokevirtual 241	java/io/InputStream:read	([B)I
    //   72: istore_3
    //   73: iload_3
    //   74: ifle +37 -> 111
    //   77: aload_2
    //   78: astore 4
    //   80: aload_2
    //   81: astore 5
    //   83: new 40	java/lang/String
    //   86: dup
    //   87: aload 6
    //   89: iconst_0
    //   90: iload_3
    //   91: invokespecial 244	java/lang/String:<init>	([BII)V
    //   94: astore 6
    //   96: aload_2
    //   97: astore 4
    //   99: aload_2
    //   100: astore 5
    //   102: aload_1
    //   103: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   106: aload 6
    //   108: putfield 248	com/tencent/component/network/downloader/DownloadResult$Content:content	Ljava/lang/Object;
    //   111: aload_2
    //   112: ifnull +75 -> 187
    //   115: aload_2
    //   116: invokevirtual 249	java/io/InputStream:close	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_1
    //   122: goto +40 -> 162
    //   125: astore_1
    //   126: aload 5
    //   128: astore 4
    //   130: ldc 251
    //   132: ldc 252
    //   134: aload_1
    //   135: invokestatic 140	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload 5
    //   140: ifnull +47 -> 187
    //   143: aload 5
    //   145: invokevirtual 249	java/io/InputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: ldc 254
    //   153: ldc_w 256
    //   156: aload_1
    //   157: invokestatic 140	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload 4
    //   164: ifnull +21 -> 185
    //   167: aload 4
    //   169: invokevirtual 249	java/io/InputStream:close	()V
    //   172: goto +13 -> 185
    //   175: astore_2
    //   176: ldc 254
    //   178: ldc_w 256
    //   181: aload_2
    //   182: invokestatic 140	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_1
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	ImageDownloadReporter
    //   0	189	1	paramDownloadResult	DownloadResult
    //   0	189	2	paramHttpResponse	HttpResponse
    //   72	19	3	i	int
    //   7	161	4	localObject1	Object
    //   30	114	5	localHttpResponse	HttpResponse
    //   58	49	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	47	121	finally
    //   53	60	121	finally
    //   66	73	121	finally
    //   83	96	121	finally
    //   102	111	121	finally
    //   130	138	121	finally
    //   35	47	125	java/io/IOException
    //   53	60	125	java/io/IOException
    //   66	73	125	java/io/IOException
    //   83	96	125	java/io/IOException
    //   102	111	125	java/io/IOException
    //   115	119	150	java/io/IOException
    //   143	148	150	java/io/IOException
    //   167	172	175	java/io/IOException
  }
  
  public void handleReport(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    uploadReport(obtainReportObj(paramDownloadResult, paramDownloadReport));
  }
  
  public ReportHandler.DownloadReportObject obtainReportObj(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    ReportHandler.DownloadReportObject localDownloadReportObject = new ReportHandler.DownloadReportObject();
    localDownloadReportObject.init();
    localDownloadReportObject.setUrl(paramDownloadReport.url);
    localDownloadReportObject.fileSize = paramDownloadReport.fileSize;
    localDownloadReportObject.startTime = paramDownloadReport.startTime;
    localDownloadReportObject.endTime = paramDownloadReport.endTime;
    localDownloadReportObject.elapse = (localDownloadReportObject.endTime - localDownloadReportObject.startTime);
    localDownloadReportObject.flow = paramDownloadReport.id;
    localDownloadReportObject.networkType = NetworkState.g().getNetworkType();
    localDownloadReportObject.serverIp = paramDownloadReport.remoteAddress;
    localDownloadReportObject.dnsIp = paramDownloadReport.dns;
    localDownloadReportObject.retry = paramDownloadReport.currAttempCount;
    localDownloadReportObject.strategyInfo = paramDownloadReport.strategyInfo;
    localDownloadReportObject.clientip = paramDownloadReport.clientip;
    localDownloadReportObject.totaltime = paramDownloadReport.totaltime;
    localDownloadReportObject.downloadTime = paramDownloadReport.downloadTime;
    localDownloadReportObject.t_wait = paramDownloadReport.t_wait;
    localDownloadReportObject.t_prepare = paramDownloadReport.t_prepare;
    localDownloadReportObject.t_conn = paramDownloadReport.t_conn;
    localDownloadReportObject.t_recvrsp = paramDownloadReport.t_recvrsp;
    localDownloadReportObject.t_recvdata = paramDownloadReport.t_recvdata;
    localDownloadReportObject.t_process = paramDownloadReport.t_process;
    localDownloadReportObject.content_type = paramDownloadReport.content_type;
    localDownloadReportObject.concurrent = paramDownloadReport.concurrent;
    localDownloadReportObject.refer = paramDownloadReport.refer;
    localDownloadReportObject.t = paramDownloadReport.exception;
    localDownloadReportObject.logInfo = paramDownloadReport.logInfo;
    localDownloadReportObject.isFromQzoneAlbum = paramDownloadReport.isFromQzoneAlbum;
    localDownloadReportObject.isHttp2 = paramDownloadReport.isHttp2;
    localDownloadReportObject.isSucceed = paramDownloadReport.isSucceed;
    localDownloadReportObject.domain = paramDownloadReport.domain;
    localDownloadReportObject.strategyId = paramDownloadReport.strategyId;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramDownloadResult.getStatus().isSucceed())
    {
      if (paramDownloadResult.getContent().noCache)
      {
        localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.response, paramDownloadReport.okResponse, 0);
        if (localDownloadReportObject.retCode == 0)
        {
          localDownloadReportObject.retCode = -2;
          return localDownloadReportObject;
        }
      }
      else
      {
        if ((paramDownloadResult.getContent().size != paramDownloadResult.getContent().length) && (!paramDownloadResult.getContent().isGzip))
        {
          localDownloadReportObject.retCode = 50008;
          paramDownloadReport = localDownloadReportObject.errMsg;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(";content-length:");
          localStringBuilder1.append(paramDownloadResult.getContent().length);
          localStringBuilder1.append(";actual-size:");
          localStringBuilder1.append(paramDownloadResult.getContent().size);
          paramDownloadReport.append(localStringBuilder1.toString());
          paramDownloadResult = new File(paramDownloadResult.getPath());
          paramDownloadReport = bytes2HexStr(readFromFile(paramDownloadResult, 0L, 1024));
          paramDownloadResult = bytes2HexStr(readFromFile(paramDownloadResult, paramDownloadResult.length() - 1024L, 1024));
          localStringBuilder1 = localDownloadReportObject.errMsg;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(";head-content:");
          localStringBuilder2.append(paramDownloadReport);
          localStringBuilder1.append(localStringBuilder2.toString());
          paramDownloadReport = localDownloadReportObject.errMsg;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(";tail-content:");
          localStringBuilder1.append(paramDownloadResult);
          paramDownloadReport.append(localStringBuilder1.toString());
          return localDownloadReportObject;
        }
        if ((paramDownloadResult.getContent().realsize > 0L) && (paramDownloadResult.getContent().realsize != paramDownloadResult.getContent().length))
        {
          localDownloadReportObject.retCode = 50002;
          paramDownloadReport = localDownloadReportObject.errMsg;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(";content-length:");
          localStringBuilder1.append(paramDownloadResult.getContent().length);
          localStringBuilder1.append(";real-size:");
          localStringBuilder1.append(paramDownloadResult.getContent().realsize);
          paramDownloadReport.append(localStringBuilder1.toString());
          return localDownloadReportObject;
        }
        localDownloadReportObject.retCode = 0;
        return localDownloadReportObject;
      }
    }
    else
    {
      localStringBuilder1 = localDownloadReportObject.errMsg;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("httpStatus:");
      localStringBuilder2.append(paramDownloadReport.httpStatus);
      localStringBuilder2.append("; ");
      localStringBuilder1.append(localStringBuilder2.toString());
      if (paramDownloadReport.exception != null)
      {
        localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.exception, localDownloadReportObject.retCode);
        localDownloadReportObject.errMsg.append(Log.getStackTraceString(paramDownloadReport.exception));
        return localDownloadReportObject;
      }
      if (paramDownloadResult.getStatus().getFailReason() == 5)
      {
        localDownloadReportObject.retCode = -1;
        paramDownloadReport = localDownloadReportObject.errMsg;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("content-type:");
        localStringBuilder1.append(paramDownloadResult.getContent().type);
        localStringBuilder1.append("; data:");
        localStringBuilder1.append(paramDownloadResult.getContent().content);
        localStringBuilder1.append("; ");
        paramDownloadReport.append(localStringBuilder1.toString());
        return localDownloadReportObject;
      }
      if (paramDownloadReport.response == null)
      {
        localDownloadReportObject.retCode = -99997;
        return localDownloadReportObject;
      }
      localDownloadReportObject.retCode = paramDownloadReport.httpStatus;
    }
    return localDownloadReportObject;
  }
  
  public void uploadReport(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.uploadReport(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */