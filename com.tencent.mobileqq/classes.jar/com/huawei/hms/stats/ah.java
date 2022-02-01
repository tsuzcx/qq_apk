package com.huawei.hms.stats;

import android.content.Context;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class ah
  extends SSLSocketFactory
{
  private static final String[] a = { "3DES", "DES", "MD5", "RC4", "aNULL", "eNULL", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "DESX", "DES40", "RC2", "ANON", "NULL", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA" };
  private static SocketFactory c;
  private final SSLContext b = SSLContext.getInstance("TLSv1.2");
  
  private ah(Context paramContext)
  {
    paramContext = new ak(paramContext);
    this.b.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  public static SocketFactory a(Context paramContext)
  {
    return b(paramContext);
  }
  
  private void a(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      a((SSLSocket)paramSocket);
      b((SSLSocket)paramSocket);
    }
  }
  
  private void a(SSLSocket paramSSLSocket)
  {
    if ((paramSSLSocket != null) && (Build.VERSION.SDK_INT >= 16)) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.contains(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  private static SocketFactory b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 115	com/huawei/hms/stats/ah:c	Ljavax/net/SocketFactory;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/huawei/hms/stats/ah
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 116	com/huawei/hms/stats/ah:<init>	(Landroid/content/Context;)V
    //   17: putstatic 115	com/huawei/hms/stats/ah:c	Ljavax/net/SocketFactory;
    //   20: getstatic 115	com/huawei/hms/stats/ah:c	Ljavax/net/SocketFactory;
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc 118
    //   32: ldc 120
    //   34: invokestatic 125	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: goto +50 -> 87
    //   40: astore_0
    //   41: ldc 118
    //   43: ldc 127
    //   45: invokestatic 125	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: goto +39 -> 87
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: ldc 118
    //   60: ldc 129
    //   62: invokestatic 125	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: goto +22 -> 87
    //   68: astore_0
    //   69: ldc 118
    //   71: ldc 131
    //   73: invokestatic 125	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: goto +11 -> 87
    //   79: astore_0
    //   80: ldc 118
    //   82: ldc 133
    //   84: invokestatic 125	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aconst_null
    //   88: astore_0
    //   89: goto -65 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	20	29	java/security/KeyManagementException
    //   20	24	29	java/security/KeyManagementException
    //   3	20	40	java/security/NoSuchAlgorithmException
    //   20	24	40	java/security/NoSuchAlgorithmException
    //   3	20	51	finally
    //   20	24	51	finally
    //   30	37	51	finally
    //   41	48	51	finally
    //   58	65	51	finally
    //   69	76	51	finally
    //   80	87	51	finally
    //   3	20	57	java/security/KeyStoreException
    //   20	24	57	java/security/KeyStoreException
    //   3	20	68	java/security/GeneralSecurityException
    //   20	24	68	java/security/GeneralSecurityException
    //   3	20	79	java/io/IOException
    //   20	24	79	java/io/IOException
  }
  
  private static void b(SSLSocket paramSSLSocket)
  {
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str = arrayOfString[i];
      if (a(str)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(str);
      }
    }
    paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    paramString = this.b.getSocketFactory().createSocket(paramString, paramInt);
    a(paramString);
    return paramString;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = this.b.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ah
 * JD-Core Version:    0.7.0.1
 */