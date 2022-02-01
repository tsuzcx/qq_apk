package com.huawei.updatesdk.a.a.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class c
{
  private static final String[] a = { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  private static final String[] b = { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  private static final String[] c = { "TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  
  public static SSLContext a()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return SSLContext.getInstance("TLSv1.3");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return SSLContext.getInstance("TLSv1.2");
    }
    return SSLContext.getInstance("TLS");
  }
  
  public static void a(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    d(paramSSLSocket);
    b(paramSSLSocket);
  }
  
  private static boolean a(SSLSocket paramSSLSocket, String[] paramArrayOfString)
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
  
  private static void b(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    while (c(paramSSLSocket)) {
      return;
    }
    b(paramSSLSocket, c);
  }
  
  private static void b(SSLSocket paramSSLSocket, String[] paramArrayOfString)
  {
    if ((paramSSLSocket == null) || (paramArrayOfString == null)) {
      return;
    }
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString.length;
    int i = 0;
    label31:
    String str1;
    if (i < k)
    {
      str1 = arrayOfString[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      int m = paramArrayOfString.length;
      j = 0;
      label59:
      if (j >= m) {
        break label147;
      }
      if (!str2.contains(paramArrayOfString[j].toUpperCase(Locale.ENGLISH))) {}
    }
    label147:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
      break label31;
      j += 1;
      break label59;
      if (localArrayList.isEmpty()) {
        break;
      }
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return;
    }
  }
  
  private static boolean c(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT > 19) {
      return a(paramSSLSocket, b);
    }
    return a(paramSSLSocket, a);
  }
  
  private static void d(SSLSocket paramSSLSocket)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */