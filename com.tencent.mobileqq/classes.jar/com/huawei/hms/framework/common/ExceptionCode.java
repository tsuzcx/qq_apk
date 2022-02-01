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
  public static final int NETWORK_CHANGED = 110216;
  public static final int NETWORK_IO_EXCEPTION = 1102;
  public static final int NETWORK_UNREACHABLE = 110208;
  public static final int PROTOCOL_ERROR = 110217;
  private static final String READ = "read";
  public static final int READ_ERROR = 110203;
  public static final int ROUTE_FAILED = 110207;
  public static final int SHUTDOWN_EXCEPTION = 110218;
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
      return str;
    }
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    paramException = str;
    while (i < j)
    {
      paramException = checkStrContainsKey(StringUtils.toLowerCase(arrayOfStackTraceElement[i].toString()), paramVarArgs);
      if (!TextUtils.isEmpty(paramException)) {
        return paramException;
      }
      i += 1;
    }
    return paramException;
  }
  
  private static String checkStrContainsKey(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString.contains(str)) {
        return str;
      }
      i += 1;
    }
    return "";
  }
  
  public static int getErrorCodeFromException(Exception paramException)
  {
    if (paramException == null) {
      return 1102;
    }
    if (!(paramException instanceof IOException)) {
      return 1103;
    }
    String str = paramException.getMessage();
    if (str == null) {
      return 1102;
    }
    str = StringUtils.toLowerCase(str);
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
    int j = paramException.hashCode();
    if (j != 3496342)
    {
      if (j != 113399775)
      {
        if ((j == 951351530) && (paramException.equals("connect"))) {
          break label94;
        }
      }
      else if (paramException.equals("write"))
      {
        i = 2;
        break label94;
      }
    }
    else if (paramException.equals("read"))
    {
      i = 1;
      break label94;
    }
    i = -1;
    label94:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return 110200;
        }
        return 110225;
      }
      return 110223;
    }
    return 110221;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExceptionCode
 * JD-Core Version:    0.7.0.1
 */