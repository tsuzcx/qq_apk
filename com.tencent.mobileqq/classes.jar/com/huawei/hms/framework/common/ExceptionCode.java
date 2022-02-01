package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

public class ExceptionCode
{
  public static final int CANCEL = 1104;
  private static final String CONNECT = "connect";
  public static final int CONNECTION_ABORT = 110205;
  public static final int CONNECTION_REFUSED = 110209;
  public static final int CONNECTION_RESET = 110204;
  public static final int CONNECT_FAILED = 110206;
  public static final int CRASH_EXCEPTION = 1103;
  public static final int INTERRUPT_CONNECT_CLOSE = 110214;
  public static final int INTERRUPT_EXCEPTION = 110213;
  public static final int NETWORK_IO_EXCEPTION = 1102;
  public static final int NETWORK_UNREACHABLE = 110208;
  private static final String READ = "read";
  public static final int READ_ERROR = 110203;
  public static final int ROUTE_FAILED = 110207;
  public static final int SOCKET_CLOSE = 110215;
  public static final int SOCKET_CONNECT_TIMEOUT = 110221;
  public static final int SOCKET_READ_TIMEOUT = 110223;
  public static final int SOCKET_TIMEOUT = 110200;
  public static final int SOCKET_WRITE_TIMEOUT = 110225;
  public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
  public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
  public static final int SSL_PROTOCOL_EXCEPTION = 110210;
  public static final int UNABLE_TO_RESOLVE_HOST = 110202;
  public static final int UNEXPECTED_EOF = 110201;
  private static final String WRITE = "write";
  
  private static String checkExceptionContainsKey(Exception paramException, String... paramVarArgs)
  {
    String str = checkStrContainsKey(StringUtils.toLowerCase(paramException.getMessage()), paramVarArgs);
    if (!TextUtils.isEmpty(str)) {
      paramException = str;
    }
    label81:
    for (;;)
    {
      return paramException;
      StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      for (paramException = str;; paramException = str)
      {
        if (i >= j) {
          break label81;
        }
        str = checkStrContainsKey(StringUtils.toLowerCase(arrayOfStackTraceElement[i].toString()), paramVarArgs);
        paramException = str;
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private static String checkStrContainsKey(String paramString, String... paramVarArgs)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = "";
      return localObject;
    }
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      String str = paramVarArgs[i];
      localObject = str;
      if (paramString.contains(str)) {
        break;
      }
      i += 1;
    }
    label49:
    return "";
  }
  
  public static int getErrorCodeFromException(Exception paramException)
  {
    if (paramException == null) {}
    do
    {
      return 1102;
      if (!(paramException instanceof IOException)) {
        return 1103;
      }
      str = paramException.getMessage();
    } while (str == null);
    String str = StringUtils.toLowerCase(str);
    int i = getErrorCodeFromMsg(str);
    if (i != 1102) {
      return i;
    }
    if ((paramException instanceof SocketTimeoutException)) {
      return getErrorCodeSocketTimeout(paramException);
    }
    if ((paramException instanceof ConnectException)) {
      return 110206;
    }
    if ((paramException instanceof NoRouteToHostException)) {
      return 110207;
    }
    if ((paramException instanceof SSLProtocolException)) {
      return 110210;
    }
    if ((paramException instanceof SSLHandshakeException)) {
      return 110211;
    }
    if ((paramException instanceof SSLPeerUnverifiedException)) {
      return 110212;
    }
    if ((paramException instanceof UnknownHostException)) {
      return 110202;
    }
    if ((paramException instanceof InterruptedIOException))
    {
      if (str.contains("connection has been shut down")) {
        return 110214;
      }
      return 110213;
    }
    return i;
  }
  
  private static int getErrorCodeFromMsg(String paramString)
  {
    if (paramString.contains("unexpected end of stream")) {
      return 110201;
    }
    if (paramString.contains("unable to resolve host")) {
      return 110202;
    }
    if (paramString.contains("read error")) {
      return 110203;
    }
    if (paramString.contains("connection reset")) {
      return 110204;
    }
    if (paramString.contains("software caused connection abort")) {
      return 110205;
    }
    if (paramString.contains("failed to connect to")) {
      return 110206;
    }
    if (paramString.contains("connection refused")) {
      return 110209;
    }
    if (paramString.contains("connection timed out")) {
      return 110221;
    }
    if (paramString.contains("no route to host")) {
      return 110207;
    }
    if (paramString.contains("network is unreachable")) {
      return 110208;
    }
    if (paramString.contains("socket closed")) {
      return 110215;
    }
    return 1102;
  }
  
  private static int getErrorCodeSocketTimeout(Exception paramException)
  {
    int i = 0;
    paramException = checkExceptionContainsKey(paramException, new String[] { "connect", "read", "write" });
    switch (paramException.hashCode())
    {
    default: 
      label64:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 110200;
        if (!paramException.equals("connect")) {
          break label64;
        }
        continue;
        if (!paramException.equals("read")) {
          break label64;
        }
        i = 1;
        continue;
        if (!paramException.equals("write")) {
          break label64;
        }
        i = 2;
      }
    }
    return 110221;
    return 110223;
    return 110225;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExceptionCode
 * JD-Core Version:    0.7.0.1
 */