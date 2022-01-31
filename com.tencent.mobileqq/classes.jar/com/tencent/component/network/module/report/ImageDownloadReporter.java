package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
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
import okhttp3.Response;
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
          QDLog.w("ImageDownload", "getRetCodeFrom", paramResponse);
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
          QDLog.w("ImageDownload", "getRetCodeFrom", paramResponse);
        }
      }
    }
  }
  
  /* Error */
  private static byte[] readFromFile(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aload 10
    //   8: astore 9
    //   10: aload_0
    //   11: ifnull +25 -> 36
    //   14: aload 10
    //   16: astore 9
    //   18: aload_0
    //   19: invokevirtual 168	java/io/File:exists	()Z
    //   22: ifeq +14 -> 36
    //   25: aload_0
    //   26: invokevirtual 171	java/io/File:isFile	()Z
    //   29: ifne +10 -> 39
    //   32: aload 10
    //   34: astore 9
    //   36: aload 9
    //   38: areturn
    //   39: aload_0
    //   40: invokevirtual 175	java/io/File:length	()J
    //   43: lstore 6
    //   45: lload_1
    //   46: lstore 4
    //   48: lload_1
    //   49: lconst_0
    //   50: lcmp
    //   51: ifge +6 -> 57
    //   54: lconst_0
    //   55: lstore 4
    //   57: aload 10
    //   59: astore 9
    //   61: lload 4
    //   63: lload 6
    //   65: lcmp
    //   66: ifge -30 -> 36
    //   69: aload 10
    //   71: astore 9
    //   73: iload_3
    //   74: ifle -38 -> 36
    //   77: iload_3
    //   78: lload 6
    //   80: lload 4
    //   82: lsub
    //   83: l2i
    //   84: invokestatic 181	java/lang/Math:min	(II)I
    //   87: istore_3
    //   88: iload_3
    //   89: newarray byte
    //   91: astore 9
    //   93: new 183	java/io/RandomAccessFile
    //   96: dup
    //   97: aload_0
    //   98: ldc 185
    //   100: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   103: astore 8
    //   105: aload 8
    //   107: lload 4
    //   109: invokevirtual 192	java/io/RandomAccessFile:seek	(J)V
    //   112: aload 8
    //   114: aload 9
    //   116: invokevirtual 196	java/io/RandomAccessFile:read	([B)I
    //   119: istore_3
    //   120: iload_3
    //   121: ifgt +25 -> 146
    //   124: aload 11
    //   126: astore_0
    //   127: aload_0
    //   128: astore 9
    //   130: aload 8
    //   132: ifnull -96 -> 36
    //   135: aload 8
    //   137: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   140: aload_0
    //   141: areturn
    //   142: astore 8
    //   144: aload_0
    //   145: areturn
    //   146: iload_3
    //   147: aload 9
    //   149: arraylength
    //   150: if_icmpge +71 -> 221
    //   153: iload_3
    //   154: newarray byte
    //   156: astore_0
    //   157: aload 9
    //   159: iconst_0
    //   160: aload_0
    //   161: iconst_0
    //   162: iload_3
    //   163: invokestatic 205	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   166: goto -39 -> 127
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_0
    //   172: aload 10
    //   174: astore 9
    //   176: aload_0
    //   177: ifnull -141 -> 36
    //   180: aload_0
    //   181: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore 8
    //   193: aload 8
    //   195: ifnull +8 -> 203
    //   198: aload 8
    //   200: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore 8
    //   207: goto -4 -> 203
    //   210: astore_0
    //   211: goto -18 -> 193
    //   214: astore_0
    //   215: aload 8
    //   217: astore_0
    //   218: goto -46 -> 172
    //   221: aload 9
    //   223: astore_0
    //   224: goto -97 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramFile	File
    //   0	227	1	paramLong	long
    //   0	227	3	paramInt	int
    //   46	62	4	l1	long
    //   43	36	6	l2	long
    //   103	33	8	localRandomAccessFile	java.io.RandomAccessFile
    //   142	1	8	localIOException1	IOException
    //   191	8	8	localObject1	Object
    //   205	11	8	localIOException2	IOException
    //   8	214	9	localObject2	Object
    //   4	169	10	localObject3	Object
    //   1	124	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   135	140	142	java/io/IOException
    //   88	105	169	java/lang/Throwable
    //   180	184	186	java/io/IOException
    //   88	105	189	finally
    //   198	203	205	java/io/IOException
    //   105	120	210	finally
    //   146	166	210	finally
    //   105	120	214	java/lang/Throwable
    //   146	166	214	java/lang/Throwable
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (StringUtil.startsWithIgnoreCase((String)localObject1, "text/html"))
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
              QDLog.w("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          localObject2 = localObject1;
          QDLog.w("ImageDownloadReporter", "handleContentType", paramDownloadResult);
          if (localObject1 != null) {
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              QDLog.w("ImageDownloader", "", paramDownloadResult);
              return false;
            }
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
        QDLog.w("ImageDownloader", "", paramHttpResponse);
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
    BusinessReport.uploadReport(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.module.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */