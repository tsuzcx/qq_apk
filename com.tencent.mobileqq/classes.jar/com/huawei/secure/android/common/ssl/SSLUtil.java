package com.huawei.secure.android.common.ssl;

import android.os.Build.VERSION;
import com.huawei.secure.android.common.ssl.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class SSLUtil
{
  private static final String a = "SSLUtil";
  private static final String b = "TLSv1.3";
  private static final String c = "TLSv1.2";
  private static final String d = "TLS";
  private static final String e = "TLSv1";
  private static final String[] f = { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  private static final String[] g = { "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384" };
  private static final String[] h = { "TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  
  public static String[] getEnabledCipherSuites(SSLSocket paramSSLSocket)
  {
    return paramSSLSocket.getEnabledCipherSuites();
  }
  
  public static String[] getEnabledProtocols(SSLSocket paramSSLSocket)
  {
    return paramSSLSocket.getEnabledProtocols();
  }
  
  public static void printTLSAndCipher(SSLSocket paramSSLSocket)
  {
    String[] arrayOfString = paramSSLSocket.getEnabledProtocols();
    int k = arrayOfString.length;
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new enable protocols is : ");
      localStringBuilder.append((String)localObject);
      g.c("SSLUtil", localStringBuilder.toString());
      i += 1;
    }
    paramSSLSocket = paramSSLSocket.getEnabledCipherSuites();
    k = paramSSLSocket.length;
    i = j;
    while (i < k)
    {
      arrayOfString = paramSSLSocket[i];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new cipher suites is : ");
      ((StringBuilder)localObject).append(arrayOfString);
      g.c("SSLUtil", ((StringBuilder)localObject).toString());
      i += 1;
    }
  }
  
  public static boolean setBlackListCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    return setBlackListCipherSuites(paramSSLSocket, h);
  }
  
  public static boolean setBlackListCipherSuites(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int k = 1;
      if (i >= m) {
        break;
      }
      String str1 = arrayOfString[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      int n = paramArrayOfString.length;
      int j = 0;
      while (j < n)
      {
        if (str2.contains(paramArrayOfString[j].toUpperCase(Locale.ENGLISH)))
        {
          j = k;
          break label97;
        }
        j += 1;
      }
      j = 0;
      label97:
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return true;
    }
    return false;
  }
  
  public static void setEnableSafeCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    if (!setWhiteListCipherSuites(paramSSLSocket)) {
      setBlackListCipherSuites(paramSSLSocket);
    }
  }
  
  public static void setEnabledProtocols(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 29) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.3", "TLSv1.2" });
    }
    int i = Build.VERSION.SDK_INT;
    if ((i >= 16) && (i < 29))
    {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
      return;
    }
    if (Build.VERSION.SDK_INT < 16) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1" });
    }
  }
  
  public static boolean setEnabledProtocols(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if (paramSSLSocket != null)
    {
      if (paramArrayOfString == null) {
        return false;
      }
      try
      {
        paramSSLSocket.setEnabledProtocols(paramArrayOfString);
        return true;
      }
      catch (Exception paramSSLSocket)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("setEnabledProtocols: exception : ");
        paramArrayOfString.append(paramSSLSocket.getMessage());
        g.b("SSLUtil", paramArrayOfString.toString());
      }
    }
    return false;
  }
  
  public static SSLContext setSSLContext()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      return SSLContext.getInstance("TLSv1.3");
    }
    if (i >= 16) {
      return SSLContext.getInstance("TLSv1.2");
    }
    return SSLContext.getInstance("TLS");
  }
  
  public static void setSSLSocketOptions(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    setEnabledProtocols(paramSSLSocket);
    setEnableSafeCipherSuites(paramSSLSocket);
  }
  
  public static boolean setWhiteListCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT > 19) {
      return setWhiteListCipherSuites(paramSSLSocket, g);
    }
    return setWhiteListCipherSuites(paramSSLSocket, f);
  }
  
  public static boolean setWhiteListCipherSuites(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (paramArrayOfString.contains(str.toUpperCase(Locale.ENGLISH))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SSLUtil
 * JD-Core Version:    0.7.0.1
 */