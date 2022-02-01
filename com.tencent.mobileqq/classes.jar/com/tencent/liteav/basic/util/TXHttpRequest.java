package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.log.TXCLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class TXHttpRequest
{
  private static final int CON_TIMEOUT = 5000;
  private static final int READ_TIMEOUT = 5000;
  private static final String TAG = "TXHttpRequest";
  private long mNativeHttps = 0L;
  
  public TXHttpRequest(long paramLong)
  {
    this.mNativeHttps = paramLong;
  }
  
  public static byte[] getHttpPostRsp(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHttpPostRsp->request: ");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHttpPostRsp->data size: ");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
    paramString = (HttpURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramMap = new DataOutputStream(paramString.getOutputStream());
    paramMap.write(paramArrayOfByte);
    paramMap.flush();
    paramMap.close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      localObject = paramString.getInputStream();
      paramMap = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = ((InputStream)localObject).read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramMap.write(paramArrayOfByte, 0, i);
      }
      paramMap.flush();
      ((InputStream)localObject).close();
      paramString.disconnect();
      paramString = new StringBuilder();
      paramString.append("getHttpsPostRsp->rsp size: ");
      paramString.append(paramMap.size());
      TXCLog.i("TXHttpRequest", paramString.toString());
      return paramMap.toByteArray();
    }
    paramMap = new StringBuilder();
    paramMap.append("getHttpPostRsp->response code: ");
    paramMap.append(i);
    TXCLog.i("TXHttpRequest", paramMap.toString());
    paramMap = new StringBuilder();
    paramMap.append("response: ");
    paramMap.append(i);
    paramMap = new Exception(paramMap.toString());
    for (;;)
    {
      throw paramMap;
    }
  }
  
  public static byte[] getHttpsPostRsp(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHttpsPostRsp->request: ");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getHttpsPostRsp->data: ");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
    paramString = (HttpsURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramMap = new DataOutputStream(paramString.getOutputStream());
    paramMap.write(paramArrayOfByte);
    paramMap.flush();
    paramMap.close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      localObject = paramString.getInputStream();
      paramMap = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = ((InputStream)localObject).read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramMap.write(paramArrayOfByte, 0, i);
      }
      paramMap.flush();
      ((InputStream)localObject).close();
      paramString.disconnect();
      paramString = new StringBuilder();
      paramString.append("getHttpsPostRsp->rsp size: ");
      paramString.append(paramMap.size());
      TXCLog.i("TXHttpRequest", paramString.toString());
      return paramMap.toByteArray();
    }
    paramMap = new StringBuilder();
    paramMap.append("getHttpsPostRsp->response code: ");
    paramMap.append(i);
    TXCLog.i("TXHttpRequest", paramMap.toString());
    paramMap = new StringBuilder();
    paramMap.append("response: ");
    paramMap.append(i);
    paramMap = new Exception(paramMap.toString());
    for (;;)
    {
      throw paramMap;
    }
  }
  
  private native void nativeOnRecvMessage(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public void asyncPostRequest(Map<String, String> paramMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    new TXHttpRequest.a(this, paramMap).execute(new byte[][] { paramArrayOfByte1, paramArrayOfByte2 });
  }
  
  public int sendHttpsRequest(String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendHttpsRequest->enter action: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", data size: ");
    localStringBuilder.append(paramArrayOfByte.length);
    TXCLog.i("TXHttpRequest", localStringBuilder.toString());
    asyncPostRequest(null, paramString.getBytes(), paramArrayOfByte);
    return 0;
  }
  
  public int sendHttpsRequest(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendHttpsRequest->enter action: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", data size: ");
    localStringBuilder.append(paramArrayOfByte.length);
    TXCLog.i("TXHttpRequest", localStringBuilder.toString());
    asyncPostRequest(paramMap, paramString.getBytes(), paramArrayOfByte);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest
 * JD-Core Version:    0.7.0.1
 */