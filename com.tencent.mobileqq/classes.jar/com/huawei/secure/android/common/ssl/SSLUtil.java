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
  private static final String C = "TLSv1.3";
  private static final String D = "TLSv1.2";
  private static final String E = "TLSv1";
  private static final String[] F = { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  private static final String[] G = { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  private static final String TAG = "SSLUtil";
  private static final String TLS = "TLS";
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
    int j = 0;
    String[] arrayOfString = paramSSLSocket.getEnabledProtocols();
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      g.c("SSLUtil", "new enable protocols is : " + str);
      i += 1;
    }
    paramSSLSocket = paramSSLSocket.getEnabledCipherSuites();
    k = paramSSLSocket.length;
    i = j;
    while (i < k)
    {
      arrayOfString = paramSSLSocket[i];
      g.c("SSLUtil", "new cipher suites is : " + arrayOfString);
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
    int k = arrayOfString.length;
    int i = 0;
    label28:
    String str1;
    if (i < k)
    {
      str1 = arrayOfString[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      int m = paramArrayOfString.length;
      j = 0;
      label56:
      if (j >= m) {
        break label145;
      }
      if (!str2.contains(paramArrayOfString[j].toUpperCase(Locale.ENGLISH))) {}
    }
    label145:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
      break label28;
      j += 1;
      break label56;
      if (localArrayList.isEmpty()) {
        break;
      }
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return true;
    }
  }
  
  public static void setEnableSafeCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    while (setWhiteListCipherSuites(paramSSLSocket)) {
      return;
    }
    setBlackListCipherSuites(paramSSLSocket);
  }
  
  public static void setEnabledProtocols(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 29) {
        paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.3", "TLSv1.2" });
      }
      if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 29))
      {
        paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
        return;
      }
    } while (Build.VERSION.SDK_INT >= 16);
    paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1" });
  }
  
  public static boolean setEnabledProtocols(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if ((paramSSLSocket == null) || (paramArrayOfString == null)) {
      return false;
    }
    try
    {
      paramSSLSocket.setEnabledProtocols(paramArrayOfString);
      return true;
    }
    catch (Exception paramSSLSocket)
    {
      g.e("SSLUtil", "setEnabledProtocols: exception : " + paramSSLSocket.getMessage());
    }
    return false;
  }
  
  public static SSLContext setSSLContext()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return SSLContext.getInstance("TLSv1.3");
    }
    if (Build.VERSION.SDK_INT >= 16) {
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
      return setWhiteListCipherSuites(paramSSLSocket, G);
    }
    return setWhiteListCipherSuites(paramSSLSocket, F);
  }
  
  public static boolean setWhiteListCipherSuites(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if (paramSSLSocket == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
      localArrayList = new ArrayList();
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
    } while (localArrayList.isEmpty());
    paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SSLUtil
 * JD-Core Version:    0.7.0.1
 */