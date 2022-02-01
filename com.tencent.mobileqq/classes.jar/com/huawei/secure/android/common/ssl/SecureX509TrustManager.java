package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SecureX509TrustManager
  implements X509TrustManager
{
  private static final String J = "AndroidCAStore";
  private static final String TAG = SecureX509TrustManager.class.getSimpleName();
  private static final String a = "X509";
  private static final String b = "bks";
  public static final String k = "hmsrootcas.bks";
  private static final String l = "";
  private X509Certificate[] K;
  protected List<X509TrustManager> c = new ArrayList();
  
  public SecureX509TrustManager(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public SecureX509TrustManager(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null");
    }
    c.setContext(paramContext);
    if (paramBoolean) {
      a();
    }
    a(paramContext);
    if (this.c.isEmpty()) {
      throw new CertificateException("X509TrustManager is empty");
    }
  }
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString)
  {
    a(paramInputStream, paramString);
  }
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    a(paramInputStream, paramString);
    if (paramBoolean) {
      a();
    }
  }
  
  public SecureX509TrustManager(String paramString)
  {
    this(paramString, false);
  }
  
  /* Error */
  public SecureX509TrustManager(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 48	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 49	java/util/ArrayList:<init>	()V
    //   12: putfield 51	com/huawei/secure/android/common/ssl/SecureX509TrustManager:c	Ljava/util/List;
    //   15: new 87	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: ldc 23
    //   28: invokespecial 81	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   31: aload_3
    //   32: invokestatic 93	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   35: iload_2
    //   36: ifeq +7 -> 43
    //   39: aload_0
    //   40: invokespecial 65	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	()V
    //   43: return
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_3
    //   47: aload_3
    //   48: invokestatic 93	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: goto -7 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	SecureX509TrustManager
    //   0	57	1	paramString	String
    //   0	57	2	paramBoolean	boolean
    //   23	25	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   15	24	44	finally
    //   24	31	53	finally
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: getstatic 38	com/huawei/secure/android/common/ssl/SecureX509TrustManager:TAG	Ljava/lang/String;
    //   3: ldc 101
    //   5: invokestatic 106	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: ldc 10
    //   10: invokestatic 112	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   13: astore_2
    //   14: aload_2
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 116	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   20: ldc 14
    //   22: invokestatic 121	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   25: astore_3
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 125	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   31: aload_3
    //   32: invokevirtual 129	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   35: astore_2
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: aload_2
    //   40: arraylength
    //   41: if_icmpge +64 -> 105
    //   44: aload_2
    //   45: iload_1
    //   46: aaload
    //   47: instanceof 6
    //   50: ifeq +19 -> 69
    //   53: aload_0
    //   54: getfield 51	com/huawei/secure/android/common/ssl/SecureX509TrustManager:c	Ljava/util/List;
    //   57: aload_2
    //   58: iload_1
    //   59: aaload
    //   60: checkcast 6	javax/net/ssl/X509TrustManager
    //   63: invokeinterface 133 2 0
    //   68: pop
    //   69: iload_1
    //   70: iconst_1
    //   71: iadd
    //   72: istore_1
    //   73: goto -35 -> 38
    //   76: astore_2
    //   77: getstatic 38	com/huawei/secure/android/common/ssl/SecureX509TrustManager:TAG	Ljava/lang/String;
    //   80: new 135	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   87: ldc 138
    //   89: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 153	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: return
    //   106: astore_2
    //   107: goto -30 -> 77
    //   110: astore_2
    //   111: goto -34 -> 77
    //   114: astore_2
    //   115: goto -38 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SecureX509TrustManager
    //   37	36	1	i	int
    //   13	45	2	localObject	Object
    //   76	17	2	localKeyStoreException	KeyStoreException
    //   106	1	2	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   110	1	2	localCertificateException	CertificateException
    //   114	1	2	localIOException	IOException
    //   25	7	3	localTrustManagerFactory	TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   8	36	76	java/security/KeyStoreException
    //   38	69	76	java/security/KeyStoreException
    //   8	36	106	java/security/NoSuchAlgorithmException
    //   38	69	106	java/security/NoSuchAlgorithmException
    //   8	36	110	java/security/cert/CertificateException
    //   38	69	110	java/security/cert/CertificateException
    //   8	36	114	java/io/IOException
    //   38	69	114	java/io/IOException
  }
  
  private void a(Context paramContext)
  {
    g.c(TAG, "loadBksCA");
    InputStream localInputStream = BksUtil.getFilesBksIS(paramContext);
    int j = 1;
    i = j;
    if (localInputStream != null) {}
    try
    {
      g.c(TAG, " get bks not from assets");
      a(localInputStream);
      i = j;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      for (;;)
      {
        g.e(TAG, "loadBksCA: exception : " + localKeyStoreException.getMessage());
        i = 0;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label72;
    }
    catch (CertificateException localCertificateException)
    {
      break label72;
    }
    catch (IOException localIOException)
    {
      break label72;
    }
    if ((i == 0) || (localInputStream == null))
    {
      g.c(TAG, " get bks from assets ");
      a(paramContext.getAssets().open("hmsrootcas.bks"));
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = TrustManagerFactory.getInstance("X509");
      KeyStore localKeyStore = KeyStore.getInstance("bks");
      localKeyStore.load(paramInputStream, "".toCharArray());
      ((TrustManagerFactory)localObject1).init(localKeyStore);
      localObject1 = ((TrustManagerFactory)localObject1).getTrustManagers();
      int i = 0;
      while (i < localObject1.length)
      {
        if ((localObject1[i] instanceof X509TrustManager)) {
          this.c.add((X509TrustManager)localObject1[i]);
        }
        i += 1;
      }
      return;
    }
    finally
    {
      f.c(paramInputStream);
    }
  }
  
  /* Error */
  private void a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +13 -> 18
    //   8: new 53	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 189
    //   14: invokespecial 58	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: ldc 14
    //   20: invokestatic 121	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   23: astore 4
    //   25: ldc 17
    //   27: invokestatic 112	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   30: astore 5
    //   32: aload 5
    //   34: aload_1
    //   35: aload_2
    //   36: invokevirtual 187	java/lang/String:toCharArray	()[C
    //   39: invokevirtual 116	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   42: aload 4
    //   44: aload 5
    //   46: invokevirtual 125	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   49: aload 4
    //   51: invokevirtual 129	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   54: astore_2
    //   55: iconst_0
    //   56: istore_3
    //   57: iload_3
    //   58: aload_2
    //   59: arraylength
    //   60: if_icmpge +35 -> 95
    //   63: aload_2
    //   64: iload_3
    //   65: aaload
    //   66: instanceof 6
    //   69: ifeq +19 -> 88
    //   72: aload_0
    //   73: getfield 51	com/huawei/secure/android/common/ssl/SecureX509TrustManager:c	Ljava/util/List;
    //   76: aload_2
    //   77: iload_3
    //   78: aaload
    //   79: checkcast 6	javax/net/ssl/X509TrustManager
    //   82: invokeinterface 133 2 0
    //   87: pop
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: goto -35 -> 57
    //   95: aload_1
    //   96: invokestatic 93	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   99: return
    //   100: astore_2
    //   101: getstatic 38	com/huawei/secure/android/common/ssl/SecureX509TrustManager:TAG	Ljava/lang/String;
    //   104: new 135	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   111: ldc 191
    //   113: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_2
    //   117: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 153	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokestatic 93	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   133: return
    //   134: astore_2
    //   135: aload_1
    //   136: invokestatic 93	com/huawei/secure/android/common/ssl/util/f:c	(Ljava/io/InputStream;)V
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: goto -41 -> 101
    //   145: astore_2
    //   146: goto -45 -> 101
    //   149: astore_2
    //   150: goto -49 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	SecureX509TrustManager
    //   0	153	1	paramInputStream	InputStream
    //   0	153	2	paramString	String
    //   56	36	3	i	int
    //   23	27	4	localTrustManagerFactory	TrustManagerFactory
    //   30	15	5	localKeyStore	KeyStore
    // Exception table:
    //   from	to	target	type
    //   18	55	100	java/security/KeyStoreException
    //   57	88	100	java/security/KeyStoreException
    //   18	55	134	finally
    //   57	88	134	finally
    //   101	129	134	finally
    //   18	55	141	java/security/NoSuchAlgorithmException
    //   57	88	141	java/security/NoSuchAlgorithmException
    //   18	55	145	java/security/cert/CertificateException
    //   57	88	145	java/security/cert/CertificateException
    //   18	55	149	java/io/IOException
    //   57	88	149	java/io/IOException
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    g.c(TAG, "checkClientTrusted: ");
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      X509TrustManager localX509TrustManager = (X509TrustManager)localIterator.next();
      try
      {
        localX509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException localCertificateException)
      {
        g.e(TAG, "checkServerTrusted CertificateException" + localCertificateException.getMessage());
      }
    }
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    setChain(paramArrayOfX509Certificate);
    g.c(TAG, "checkServerTrusted begin ,server ca chain size is : " + paramArrayOfX509Certificate.length);
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = paramArrayOfX509Certificate[i];
      g.b(TAG, "server ca chain: getSubjectDN is :" + ((X509Certificate)localObject).getSubjectDN() + " , getIssuerDN :" + ((X509Certificate)localObject).getIssuerDN());
      i += 1;
    }
    int m = this.c.size();
    i = 0;
    for (;;)
    {
      if (i < m) {}
      try
      {
        g.c(TAG, "check server i : " + i);
        localObject = (X509TrustManager)this.c.get(i);
        X509Certificate[] arrayOfX509Certificate = ((X509TrustManager)localObject).getAcceptedIssuers();
        if (arrayOfX509Certificate != null)
        {
          g.c(TAG, "client root ca size is : " + arrayOfX509Certificate.length);
          j = 0;
          while (j < arrayOfX509Certificate.length)
          {
            g.b(TAG, "client root ca getIssuerDN :" + arrayOfX509Certificate[j].getIssuerDN());
            j += 1;
          }
        }
        ((X509TrustManager)localObject).checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException localCertificateException)
      {
        g.e(TAG, "checkServerTrusted error :" + localCertificateException.getMessage() + " , time : " + i);
        if (i == m - 1)
        {
          if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length > 0)) {
            g.e(TAG, "root ca issuer : " + paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1)].getIssuerDN());
          }
          throw localCertificateException;
        }
        i += 1;
      }
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
      }
      arrayOfX509Certificate = (X509Certificate[])localException.toArray(new X509Certificate[localException.size()]);
    }
    catch (Exception localException)
    {
      g.e(TAG, "getAcceptedIssuers exception : " + localException.getMessage());
      return new X509Certificate[0];
    }
    X509Certificate[] arrayOfX509Certificate;
    return arrayOfX509Certificate;
  }
  
  public X509Certificate[] getChain()
  {
    return this.K;
  }
  
  public void setChain(X509Certificate[] paramArrayOfX509Certificate)
  {
    this.K = paramArrayOfX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SecureX509TrustManager
 * JD-Core Version:    0.7.0.1
 */