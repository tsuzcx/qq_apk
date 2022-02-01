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
  private static final String c = "SecureX509TrustManager";
  public static final String d = "hmsrootcas.bks";
  private static final String e = "";
  private static final String f = "X509";
  private static final String g = "bks";
  private static final String h = "AndroidCAStore";
  protected List<X509TrustManager> a = new ArrayList();
  private X509Certificate[] b;
  
  public SecureX509TrustManager(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public SecureX509TrustManager(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      c.a(paramContext);
      if (paramBoolean) {
        a();
      }
      a(paramContext);
      if (!this.a.isEmpty()) {
        return;
      }
      throw new CertificateException("X509TrustManager is empty");
    }
    throw new IllegalArgumentException("context is null");
  }
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString)
  {
    a(paramInputStream, paramString);
  }
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      a();
    }
    a(paramInputStream, paramString);
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
    //   1: invokespecial 40	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 42	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 43	java/util/ArrayList:<init>	()V
    //   12: putfield 45	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	Ljava/util/List;
    //   15: new 79	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: ldc 16
    //   28: invokespecial 73	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   31: aload_1
    //   32: invokestatic 85	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   35: iload_2
    //   36: ifeq +7 -> 43
    //   39: aload_0
    //   40: invokespecial 51	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	()V
    //   43: return
    //   44: astore_3
    //   45: goto +6 -> 51
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 85	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   55: aload_3
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	SecureX509TrustManager
    //   0	57	1	paramString	String
    //   0	57	2	paramBoolean	boolean
    //   44	1	3	localObject1	Object
    //   48	8	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	44	finally
    //   15	24	48	finally
  }
  
  private void a()
  {
    g.c(c, "loadSystemCA");
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = KeyStore.getInstance("AndroidCAStore");
      ((KeyStore)localObject1).load(null, null);
      localObject2 = TrustManagerFactory.getInstance("X509");
      ((TrustManagerFactory)localObject2).init((KeyStore)localObject1);
      localObject1 = ((TrustManagerFactory)localObject2).getTrustManagers();
      int i = 0;
      while (i < localObject1.length)
      {
        if ((localObject1[i] instanceof X509TrustManager)) {
          this.a.add((X509TrustManager)localObject1[i]);
        }
        i += 1;
      }
      localObject2 = c;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (IOException localIOException) {}catch (CertificateException localCertificateException) {}catch (KeyStoreException localKeyStoreException) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSystemCA: exception : ");
    localStringBuilder.append(localKeyStoreException.getMessage());
    g.b((String)localObject2, localStringBuilder.toString());
    String str = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadSystemCA: cost : ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject2).append(" ms");
    g.a(str, ((StringBuilder)localObject2).toString());
  }
  
  private void a(Context paramContext)
  {
    g.c(c, "loadBksCA");
    long l = System.currentTimeMillis();
    InputStream localInputStream = BksUtil.getFilesBksIS(paramContext);
    if (localInputStream != null)
    {
      try
      {
        g.c(c, "get bks not from assets");
        a(localInputStream);
      }
      catch (IOException localIOException) {}catch (CertificateException localCertificateException) {}catch (KeyStoreException localKeyStoreException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
      String str = c;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("loadBksCA: exception : ");
      localStringBuilder2.append(localNoSuchAlgorithmException.getMessage());
      g.b(str, localStringBuilder2.toString());
      i = 0;
      break label107;
    }
    int i = 1;
    label107:
    if ((i == 0) || (localInputStream == null))
    {
      g.c(c, " get bks from assets ");
      a(paramContext.getAssets().open("hmsrootcas.bks"));
    }
    paramContext = c;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("loadBksCA: cost : ");
    localStringBuilder1.append(System.currentTimeMillis() - l);
    localStringBuilder1.append(" ms");
    g.a(paramContext, localStringBuilder1.toString());
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
          this.a.add((X509TrustManager)localObject1[i]);
        }
        i += 1;
      }
      f.a(paramInputStream);
      return;
    }
    finally
    {
      f.a(paramInputStream);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  private void a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +211 -> 212
    //   4: aload_2
    //   5: ifnull +207 -> 212
    //   8: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   11: lstore 4
    //   13: ldc 19
    //   15: invokestatic 121	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   18: astore 6
    //   20: ldc 22
    //   22: invokestatic 112	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   25: astore 7
    //   27: aload 7
    //   29: aload_1
    //   30: aload_2
    //   31: invokevirtual 197	java/lang/String:toCharArray	()[C
    //   34: invokevirtual 116	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   37: aload 6
    //   39: aload 7
    //   41: invokevirtual 125	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   44: aload 6
    //   46: invokevirtual 129	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   49: astore_2
    //   50: iconst_0
    //   51: istore_3
    //   52: iload_3
    //   53: aload_2
    //   54: arraylength
    //   55: if_icmpge +35 -> 90
    //   58: aload_2
    //   59: iload_3
    //   60: aaload
    //   61: instanceof 6
    //   64: ifeq +19 -> 83
    //   67: aload_0
    //   68: getfield 45	com/huawei/secure/android/common/ssl/SecureX509TrustManager:a	Ljava/util/List;
    //   71: aload_2
    //   72: iload_3
    //   73: aaload
    //   74: checkcast 6	javax/net/ssl/X509TrustManager
    //   77: invokeinterface 133 2 0
    //   82: pop
    //   83: iload_3
    //   84: iconst_1
    //   85: iadd
    //   86: istore_3
    //   87: goto -35 -> 52
    //   90: aload_1
    //   91: invokestatic 85	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   94: goto +66 -> 160
    //   97: astore_2
    //   98: goto +108 -> 206
    //   101: astore_2
    //   102: goto +12 -> 114
    //   105: astore_2
    //   106: goto +8 -> 114
    //   109: astore_2
    //   110: goto +4 -> 114
    //   113: astore_2
    //   114: getstatic 93	com/huawei/secure/android/common/ssl/SecureX509TrustManager:c	Ljava/lang/String;
    //   117: astore 6
    //   119: new 135	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: ldc 199
    //   132: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 7
    //   138: aload_2
    //   139: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: aload 7
    //   150: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 153	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_1
    //   157: invokestatic 85	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   160: getstatic 93	com/huawei/secure/android/common/ssl/SecureX509TrustManager:c	Ljava/lang/String;
    //   163: astore_1
    //   164: new 135	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   171: astore_2
    //   172: aload_2
    //   173: ldc 201
    //   175: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   183: lload 4
    //   185: lsub
    //   186: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_2
    //   191: ldc 160
    //   193: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: aload_2
    //   199: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 162	com/huawei/secure/android/common/ssl/util/g:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: return
    //   206: aload_1
    //   207: invokestatic 85	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   210: aload_2
    //   211: athrow
    //   212: new 67	java/lang/IllegalArgumentException
    //   215: dup
    //   216: ldc 203
    //   218: invokespecial 70	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   221: astore_1
    //   222: goto +5 -> 227
    //   225: aload_1
    //   226: athrow
    //   227: goto -2 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	SecureX509TrustManager
    //   0	230	1	paramInputStream	InputStream
    //   0	230	2	paramString	String
    //   51	36	3	i	int
    //   11	173	4	l	long
    //   18	129	6	localObject1	Object
    //   25	124	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	50	97	finally
    //   52	83	97	finally
    //   114	156	97	finally
    //   13	50	101	java/security/NoSuchAlgorithmException
    //   52	83	101	java/security/NoSuchAlgorithmException
    //   13	50	105	java/io/IOException
    //   52	83	105	java/io/IOException
    //   13	50	109	java/security/cert/CertificateException
    //   52	83	109	java/security/cert/CertificateException
    //   13	50	113	java/security/KeyStoreException
    //   52	83	113	java/security/KeyStoreException
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    g.c(c, "checkClientTrusted: ");
    Iterator localIterator = this.a.iterator();
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
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkServerTrusted CertificateException");
        localStringBuilder.append(localCertificateException.getMessage());
        g.b(str, localStringBuilder.toString());
      }
    }
    paramArrayOfX509Certificate = new CertificateException("checkServerTrusted CertificateException");
    for (;;)
    {
      throw paramArrayOfX509Certificate;
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    setChain(paramArrayOfX509Certificate);
    Object localObject1 = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkServerTrusted begin ,server ca chain size is : ");
    ((StringBuilder)localObject2).append(paramArrayOfX509Certificate.length);
    ((StringBuilder)localObject2).append(" ,auth type is : ");
    ((StringBuilder)localObject2).append(paramString);
    g.c((String)localObject1, ((StringBuilder)localObject2).toString());
    long l = System.currentTimeMillis();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject1 = paramArrayOfX509Certificate[i];
      localObject2 = c;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("server ca chain: getSubjectDN is :");
      ((StringBuilder)localObject3).append(((X509Certificate)localObject1).getSubjectDN());
      g.a((String)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = c;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("IssuerDN :");
      ((StringBuilder)localObject3).append(((X509Certificate)localObject1).getIssuerDN());
      g.a((String)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = c;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("SerialNumber : ");
      ((StringBuilder)localObject3).append(((X509Certificate)localObject1).getSerialNumber());
      g.a((String)localObject2, ((StringBuilder)localObject3).toString());
      i += 1;
    }
    int k = this.a.size();
    i = 0;
    while (i < k) {
      try
      {
        localObject1 = c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("check server i : ");
        ((StringBuilder)localObject2).append(i);
        g.c((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = (X509TrustManager)this.a.get(i);
        localObject2 = ((X509TrustManager)localObject1).getAcceptedIssuers();
        if (localObject2 != null)
        {
          localObject3 = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("client root ca size is : ");
          localStringBuilder.append(localObject2.length);
          g.c((String)localObject3, localStringBuilder.toString());
          j = 0;
          while (j < localObject2.length)
          {
            localObject3 = c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("client root ca getIssuerDN :");
            localStringBuilder.append(localObject2[j].getIssuerDN());
            g.a((String)localObject3, localStringBuilder.toString());
            j += 1;
          }
        }
        ((X509TrustManager)localObject1).checkServerTrusted(paramArrayOfX509Certificate, paramString);
        localObject1 = c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkServerTrusted succeed ,root ca issuer is : ");
        ((StringBuilder)localObject2).append(paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1)].getIssuerDN());
        g.c((String)localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (CertificateException localCertificateException)
      {
        localObject2 = c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkServerTrusted error :");
        ((StringBuilder)localObject3).append(localCertificateException.getMessage());
        ((StringBuilder)localObject3).append(" , time : ");
        ((StringBuilder)localObject3).append(i);
        g.b((String)localObject2, ((StringBuilder)localObject3).toString());
        if (i == k - 1)
        {
          if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length > 0))
          {
            paramString = c;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("root ca issuer : ");
            ((StringBuilder)localObject2).append(paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1)].getIssuerDN());
            g.b(paramString, ((StringBuilder)localObject2).toString());
          }
          throw localCertificateException;
        }
        i += 1;
      }
    }
    paramArrayOfX509Certificate = c;
    paramString = new StringBuilder();
    paramString.append("checkServerTrusted: cost : ");
    paramString.append(System.currentTimeMillis() - l);
    paramString.append(" ms");
    g.a(paramArrayOfX509Certificate, paramString.toString());
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    try
    {
      Object localObject1 = new ArrayList();
      localObject2 = this.a.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).addAll(Arrays.asList(((X509TrustManager)((Iterator)localObject2).next()).getAcceptedIssuers()));
      }
      localObject1 = (X509Certificate[])((ArrayList)localObject1).toArray(new X509Certificate[((ArrayList)localObject1).size()]);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAcceptedIssuers exception : ");
      localStringBuilder.append(localException.getMessage());
      g.b((String)localObject2, localStringBuilder.toString());
    }
    return new X509Certificate[0];
  }
  
  public X509Certificate[] getChain()
  {
    return this.b;
  }
  
  public List<X509TrustManager> getX509TrustManagers()
  {
    return this.a;
  }
  
  public void setChain(X509Certificate[] paramArrayOfX509Certificate)
  {
    this.b = paramArrayOfX509Certificate;
  }
  
  public void setX509TrustManagers(List<X509TrustManager> paramList)
  {
    this.a = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SecureX509TrustManager
 * JD-Core Version:    0.7.0.1
 */