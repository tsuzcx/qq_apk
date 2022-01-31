package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
import com.squareup.okhttp.Response;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.StringUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = digits[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
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
      if ((paramThrowable instanceof OutOfMemoryError)) {
        return 3;
      }
    }
    return paramInt;
  }
  
  private int getRetCodeFrom(HttpResponse paramHttpResponse, Response paramResponse, int paramInt)
  {
    int i;
    if (paramHttpResponse != null) {
      if (paramHttpResponse == null)
      {
        paramHttpResponse = null;
        i = paramInt;
        if (paramHttpResponse != null) {
          label17:
          do
          {
            i = paramInt;
            if (!paramHttpResponse.hasNext()) {
              break;
            }
            paramResponse = paramHttpResponse.nextHeader();
          } while (paramResponse == null);
        }
      }
    }
    do
    {
      do
      {
        try
        {
          i = Integer.parseInt(paramResponse.getValue());
          return i;
        }
        catch (NumberFormatException paramResponse)
        {
          QDLog.c("ImageDownload", "getRetCodeFrom", paramResponse);
        }
        paramHttpResponse = paramHttpResponse.headerIterator("Retcode");
        break;
        break label17;
        i = paramInt;
      } while (paramResponse == null);
      paramHttpResponse = paramResponse.headers("Retcode");
      i = paramInt;
    } while (paramHttpResponse == null);
    paramHttpResponse = paramHttpResponse.iterator();
    for (;;)
    {
      i = paramInt;
      if (!paramHttpResponse.hasNext()) {
        break;
      }
      paramResponse = (String)paramHttpResponse.next();
      if (paramResponse != null) {
        try
        {
          i = Integer.parseInt(paramResponse);
          return i;
        }
        catch (NumberFormatException paramResponse)
        {
          QDLog.c("ImageDownload", "getRetCodeFrom", paramResponse);
        }
      }
    }
  }
  
  /* Error */
  private static byte[] readFromFile(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aload 10
    //   11: astore 9
    //   13: aload_0
    //   14: ifnull +25 -> 39
    //   17: aload 10
    //   19: astore 9
    //   21: aload_0
    //   22: invokevirtual 168	java/io/File:exists	()Z
    //   25: ifeq +14 -> 39
    //   28: aload_0
    //   29: invokevirtual 171	java/io/File:isFile	()Z
    //   32: ifne +10 -> 42
    //   35: aload 10
    //   37: astore 9
    //   39: aload 9
    //   41: areturn
    //   42: aload_0
    //   43: invokevirtual 175	java/io/File:length	()J
    //   46: lstore 6
    //   48: lload_1
    //   49: lstore 4
    //   51: lload_1
    //   52: lconst_0
    //   53: lcmp
    //   54: ifge +6 -> 60
    //   57: lconst_0
    //   58: lstore 4
    //   60: aload 10
    //   62: astore 9
    //   64: lload 4
    //   66: lload 6
    //   68: lcmp
    //   69: ifge -30 -> 39
    //   72: aload 10
    //   74: astore 9
    //   76: iload_3
    //   77: ifle -38 -> 39
    //   80: iload_3
    //   81: lload 6
    //   83: lload 4
    //   85: lsub
    //   86: l2i
    //   87: invokestatic 181	java/lang/Math:min	(II)I
    //   90: istore_3
    //   91: iload_3
    //   92: newarray byte
    //   94: astore 9
    //   96: new 183	java/io/RandomAccessFile
    //   99: dup
    //   100: aload_0
    //   101: ldc 185
    //   103: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 8
    //   108: aload 8
    //   110: lload 4
    //   112: invokevirtual 192	java/io/RandomAccessFile:seek	(J)V
    //   115: aload 8
    //   117: aload 9
    //   119: invokevirtual 196	java/io/RandomAccessFile:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: ifgt +28 -> 152
    //   127: aload 12
    //   129: astore_0
    //   130: aload_0
    //   131: astore 9
    //   133: aload 8
    //   135: ifnull -96 -> 39
    //   138: aload_0
    //   139: astore 9
    //   141: aload 8
    //   143: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   146: aload_0
    //   147: areturn
    //   148: astore_0
    //   149: aload 9
    //   151: areturn
    //   152: iload_3
    //   153: aload 9
    //   155: arraylength
    //   156: if_icmpge +72 -> 228
    //   159: iload_3
    //   160: newarray byte
    //   162: astore_0
    //   163: aload 9
    //   165: iconst_0
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_3
    //   169: invokestatic 205	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: goto -42 -> 130
    //   175: astore_0
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull +8 -> 189
    //   184: aload 8
    //   186: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_0
    //   194: aload 10
    //   196: astore 9
    //   198: aload_0
    //   199: ifnull -160 -> 39
    //   202: aload 11
    //   204: astore 9
    //   206: aload_0
    //   207: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore 8
    //   214: goto -25 -> 189
    //   217: astore_0
    //   218: goto -39 -> 179
    //   221: astore_0
    //   222: aload 8
    //   224: astore_0
    //   225: goto -31 -> 194
    //   228: aload 9
    //   230: astore_0
    //   231: goto -101 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramFile	File
    //   0	234	1	paramLong	long
    //   0	234	3	paramInt	int
    //   49	62	4	l1	long
    //   46	36	6	l2	long
    //   106	79	8	localRandomAccessFile	java.io.RandomAccessFile
    //   212	11	8	localIOException	IOException
    //   11	218	9	localObject1	Object
    //   7	188	10	localObject2	Object
    //   4	199	11	localObject3	Object
    //   1	127	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   141	146	148	java/io/IOException
    //   206	210	148	java/io/IOException
    //   91	108	175	finally
    //   91	108	191	java/lang/Throwable
    //   184	189	212	java/io/IOException
    //   108	123	217	finally
    //   152	172	217	finally
    //   108	123	221	java/lang/Throwable
    //   152	172	221	java/lang/Throwable
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (StringUtil.a((String)localObject1, "text/html"))
      {
        localObject2 = null;
        localObject1 = null;
        try
        {
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          Object localObject3 = new byte[1024];
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          int i = paramHttpResponse.read((byte[])localObject3);
          if (i > 0)
          {
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            localObject3 = new String((byte[])localObject3, 0, i);
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            paramDownloadResult.getContent().content = localObject3;
          }
          if (paramHttpResponse != null) {
            try
            {
              paramHttpResponse.close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              QDLog.c("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          for (;;)
          {
            localObject2 = localObject1;
            QDLog.c("ImageDownloadReporter", "handleContentType", paramDownloadResult);
            if (localObject1 == null) {
              break;
            }
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult) {}
          }
        }
        finally
        {
          if (localObject2 == null) {}
        }
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramDownloadResult;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        QDLog.c("ImageDownloader", "", paramHttpResponse);
      }
    }
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
    if (paramDownloadResult.getStatus().isSucceed())
    {
      if (paramDownloadResult.getContent().noCache)
      {
        localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.response, paramDownloadReport.okResponse, 0);
        if (localDownloadReportObject.retCode == 0) {
          localDownloadReportObject.retCode = -2;
        }
        return localDownloadReportObject;
      }
      if (paramDownloadResult.getContent().size != paramDownloadResult.getContent().length)
      {
        localDownloadReportObject.retCode = -3;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";actual-size:" + paramDownloadResult.getContent().size);
        paramDownloadReport = new File(paramDownloadResult.getPath());
        paramDownloadResult = bytes2HexStr(readFromFile(paramDownloadReport, 0L, 1024));
        paramDownloadReport = bytes2HexStr(readFromFile(paramDownloadReport, paramDownloadReport.length() - 1024L, 1024));
        localDownloadReportObject.errMsg.append(";head-content:" + paramDownloadResult);
        localDownloadReportObject.errMsg.append(";tail-content:" + paramDownloadReport);
        return localDownloadReportObject;
      }
      if ((paramDownloadResult.getContent().realsize > 0L) && (paramDownloadResult.getContent().realsize != paramDownloadResult.getContent().length))
      {
        localDownloadReportObject.retCode = 50002;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";real-size:" + paramDownloadResult.getContent().realsize);
        return localDownloadReportObject;
      }
      localDownloadReportObject.retCode = 0;
      return localDownloadReportObject;
    }
    localDownloadReportObject.errMsg.append("httpStatus:" + paramDownloadReport.httpStatus + "; ");
    if (paramDownloadReport.exception != null)
    {
      localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.exception, localDownloadReportObject.retCode);
      localDownloadReportObject.errMsg.append(Log.getStackTraceString(paramDownloadReport.exception));
      return localDownloadReportObject;
    }
    if (paramDownloadResult.getStatus().getFailReason() == 5)
    {
      localDownloadReportObject.retCode = -1;
      localDownloadReportObject.errMsg.append("content-type:" + paramDownloadResult.getContent().type + "; data:" + paramDownloadResult.getContent().content + "; ");
      return localDownloadReportObject;
    }
    if (paramDownloadReport.response == null)
    {
      localDownloadReportObject.retCode = -99997;
      return localDownloadReportObject;
    }
    localDownloadReportObject.retCode = paramDownloadReport.httpStatus;
    return localDownloadReportObject;
  }
  
  public void uploadReport(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.a(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */