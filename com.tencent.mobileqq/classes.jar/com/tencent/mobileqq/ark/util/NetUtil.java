package com.tencent.mobileqq.ark.util;

import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class NetUtil
{
  static HttpNetReq a(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    int i;
    if (paramArrayOfByte != null) {
      i = 1;
    } else {
      i = 0;
    }
    localHttpNetReq.mHttpMethod = i;
    localHttpNetReq.mReqUrl = paramString1;
    if (paramString2 != null) {
      localHttpNetReq.mOutPath = paramString2;
    } else {
      localHttpNetReq.mOutStream = new ByteArrayOutputStream();
    }
    localHttpNetReq.mPrioty = 0;
    if (paramMap != null) {
      localHttpNetReq.mReqProperties.putAll(paramMap);
    }
    return localHttpNetReq;
  }
  
  static void a(AppRuntime paramAppRuntime, IHTTPDownloadCallback paramIHTTPDownloadCallback, HttpNetReq paramHttpNetReq)
  {
    try
    {
      ((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(paramHttpNetReq);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      paramHttpNetReq = new StringBuilder();
      paramHttpNetReq.append("failed to get http engine service, ");
      paramHttpNetReq.append(paramAppRuntime);
      QLog.i("ArkApp.NetUtil", 1, paramHttpNetReq.toString());
      if (paramIHTTPDownloadCallback != null) {
        paramIHTTPDownloadCallback.a(1, null);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, Map<String, String> paramMap, IHTTPDownloadCallback paramIHTTPDownloadCallback)
  {
    a(paramAppRuntime, paramString, null, paramMap, null, paramIHTTPDownloadCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, Map<String, String> paramMap, String paramString2, IHTTPDownloadCallback paramIHTTPDownloadCallback)
  {
    a(paramAppRuntime, paramString1, null, paramMap, paramString2, paramIHTTPDownloadCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, IHTTPDownloadCallback paramIHTTPDownloadCallback)
  {
    a(paramAppRuntime, paramString, paramArrayOfByte, paramMap, null, paramIHTTPDownloadCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, IHTTPDownloadCallback paramIHTTPDownloadCallback)
  {
    paramString1 = a(paramString1, paramArrayOfByte, paramMap, paramString2);
    paramString1.mCallback = new NetUtil.1(paramIHTTPDownloadCallback, paramString1);
    a(paramAppRuntime, paramIHTTPDownloadCallback, paramString1);
  }
  
  static byte[] a(NetResp paramNetResp, HttpNetReq paramHttpNetReq)
  {
    int i = paramNetResp.mErrCode;
    Object localObject = null;
    byte[] arrayOfByte = null;
    if (i == 0)
    {
      if (paramHttpNetReq.mOutStream != null) {
        arrayOfByte = ((ByteArrayOutputStream)paramHttpNetReq.mOutStream).toByteArray();
      } else if (paramHttpNetReq.mOutPath != null) {
        arrayOfByte = FileUtils.readFile(paramHttpNetReq.mOutPath);
      }
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("read file fail, path is ");
        ((StringBuilder)localObject).append(paramHttpNetReq.mOutPath);
        QLog.i("ArkApp.NetUtil", 1, ((StringBuilder)localObject).toString());
        paramNetResp.mErrCode = 1;
        localObject = arrayOfByte;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.NetUtil
 * JD-Core Version:    0.7.0.1
 */