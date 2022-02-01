package com.huawei.hms.framework.network.grs.c.b;

import android.os.Build.VERSION;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class b
{
  private static final String[] a = { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  private static final String[] b = { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  private static final String[] c = { "TLS_RSA", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  private static final String[] d = { "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  private static final String[] e = { "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  
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
    if (paramSSLSocket == null) {}
    while (b(paramSSLSocket)) {
      return;
    }
    c(paramSSLSocket);
  }
  
  private static boolean a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    if (paramSSLSocket == null) {
      return false;
    }
    String[] arrayOfString2 = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1;
    int i;
    label45:
    String str1;
    if (paramBoolean) {
      if (Build.VERSION.SDK_INT > 19)
      {
        arrayOfString1 = e;
        int k = arrayOfString2.length;
        i = 0;
        if (i >= k) {
          break label144;
        }
        str1 = arrayOfString2[i];
        String str2 = str1.toUpperCase(Locale.ENGLISH);
        int m = arrayOfString1.length;
        j = 0;
        label74:
        if (j >= m) {
          break label182;
        }
        if (!str2.contains(arrayOfString1[j].toUpperCase(Locale.ENGLISH))) {
          break label137;
        }
      }
    }
    label137:
    label144:
    label182:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
      break label45;
      arrayOfString1 = d;
      break;
      arrayOfString1 = c;
      break;
      j += 1;
      break label74;
      if (!localArrayList.isEmpty())
      {
        paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
        return true;
      }
      return false;
    }
  }
  
  public static boolean b(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
      Logger.v("SSLUtil", "before filter algriom: " + Arrays.asList(arrayOfString));
      localArrayList = new ArrayList();
      List localList1 = Arrays.asList(b);
      List localList2 = Arrays.asList(a);
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str1 = arrayOfString[i];
        String str2 = str1.toUpperCase(Locale.ENGLISH);
        if (Build.VERSION.SDK_INT > 19) {
          if (localList1.contains(str2)) {
            localArrayList.add(str1);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (localList2.contains(str2)) {
            localArrayList.add(str1);
          }
        }
      }
      Logger.v("SSLUtil", "after filter algriom: " + localArrayList);
    } while (localArrayList.isEmpty());
    paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
    return true;
  }
  
  public static boolean c(SSLSocket paramSSLSocket)
  {
    return a(paramSSLSocket, false);
  }
  
  public static void d(SSLSocket paramSSLSocket)
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
  
  public static void e(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    d(paramSSLSocket);
    a(paramSSLSocket);
    Logger.v("SSLUtil", "current platform level is{%d},protocols is{%s} and safeCipherSuites is{%s}", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Arrays.toString(paramSSLSocket.getEnabledProtocols()), Arrays.toString(paramSSLSocket.getEnabledCipherSuites()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.b
 * JD-Core Version:    0.7.0.1
 */