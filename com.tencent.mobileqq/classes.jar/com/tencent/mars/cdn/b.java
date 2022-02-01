package com.tencent.mars.cdn;

import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public class b
{
  private static CertificateFactory b;
  private static b.c c;
  private static b.a d;
  private static b.c e;
  private static KeyStore f;
  private static KeyStore g;
  private static i h;
  private static Set<Pair<X500Principal, PublicKey>> i;
  private static boolean j;
  private static final Object k = new Object();
  private static final char[] l = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static a a(byte[][] paramArrayOfByte, String paramString1, String paramString2, int paramInt, X509TrustManager paramX509TrustManager)
  {
    o.d("X509Util", "verifyServerCertificates %s type %s", new Object[] { paramString2, paramString1 });
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramArrayOfByte[0] != null))
    {
      for (;;)
      {
        try
        {
          b();
          ??? = new ArrayList();
        }
        catch (CertificateException paramArrayOfByte)
        {
          boolean bool1;
          Object localObject3;
          continue;
        }
        try
        {
          ((List)???).add(a(paramArrayOfByte[0]));
          try
          {
            Object localObject2 = c((X509Certificate)((List)???).get(0));
            o.d("X509Util", "check host %s in altnames %s", new Object[] { paramString2, localObject2.toString() });
            if (!a((List)localObject2, paramString2))
            {
              o.b("X509Util", "hostname mismatch");
              if (paramInt != 1)
              {
                localObject2 = new a(-1);
                return localObject2;
              }
            }
            else
            {
              bool1 = true;
            }
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("hostname verify failed ");
            localStringBuilder.append(localException.getLocalizedMessage());
            o.b("X509Util", localStringBuilder.toString());
            if (paramInt != 1) {
              return new a(-1);
            }
            bool1 = false;
          }
          paramInt = 1;
          if (paramInt >= paramArrayOfByte.length) {
            break;
          }
        }
        catch (CertificateException paramArrayOfByte)
        {
          continue;
        }
        try
        {
          ((List)???).add(a(paramArrayOfByte[paramInt]));
        }
        catch (CertificateException localCertificateException)
        {
          continue;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("intermediate ");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append(" failed parsing");
        o.c("X509Util", ((StringBuilder)localObject3).toString());
        paramInt += 1;
      }
      localObject3 = (X509Certificate[])((List)???).toArray(new X509Certificate[((List)???).size()]);
    }
    try
    {
      localObject3[0].checkValidity();
      if (!a(localObject3[0]))
      {
        paramArrayOfByte = new a(-6);
        return paramArrayOfByte;
      }
      synchronized (k)
      {
        if ((c == null) && (paramX509TrustManager == null))
        {
          paramArrayOfByte = new a(-1);
          return paramArrayOfByte;
        }
        if (paramX509TrustManager != null) {
          try
          {
            paramX509TrustManager.checkServerTrusted((X509Certificate[])localObject3, paramString1);
            paramArrayOfByte = new a(0, true, new ArrayList(), bool1);
            return paramArrayOfByte;
          }
          catch (CertificateException paramArrayOfByte)
          {
            paramString1 = new StringBuilder();
            paramString1.append("Failed to validate the certificate chain use self trustmanager, error: ");
            paramString1.append(paramArrayOfByte.getMessage());
            o.d("X509Util", paramString1.toString());
            paramArrayOfByte = new a(-2);
            return paramArrayOfByte;
          }
        }
        try
        {
          paramArrayOfByte = c.a((X509Certificate[])localObject3, paramString1, paramString2);
        }
        catch (CertificateException paramX509TrustManager) {}
        try
        {
          paramArrayOfByte = e.a((X509Certificate[])localObject3, paramString1, paramString2);
          if (paramArrayOfByte.size() <= 0) {
            break label702;
          }
          bool2 = b((X509Certificate)paramArrayOfByte.get(paramArrayOfByte.size() - 1));
        }
        catch (CertificateException paramArrayOfByte)
        {
          for (;;)
          {
            continue;
            boolean bool2 = false;
          }
        }
        paramArrayOfByte = new a(0, bool2, paramArrayOfByte, bool1);
        return paramArrayOfByte;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Failed to validate the certificate chain, error: ");
        paramArrayOfByte.append(paramX509TrustManager.getMessage());
        o.d("X509Util", paramArrayOfByte.toString());
        paramArrayOfByte = new a(-2);
        return paramArrayOfByte;
      }
    }
    catch (CertificateExpiredException paramArrayOfByte)
    {
      break label600;
    }
    catch (CertificateNotYetValidException paramArrayOfByte)
    {
      break label590;
    }
    catch (CertificateException paramArrayOfByte)
    {
      label581:
      label590:
      label600:
      break label581;
    }
    return new a(-1);
    return new a(-4);
    return new a(-3);
    return new a(-5);
    return new a(-1);
    paramString1 = new StringBuilder();
    paramString1.append("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=");
    paramString1.append(Arrays.deepToString(paramArrayOfByte));
    paramArrayOfByte = new IllegalArgumentException(paramString1.toString());
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private static b.c a(KeyStore paramKeyStore)
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(paramKeyStore);
    paramKeyStore = ((TrustManagerFactory)localObject).getTrustManagers();
    int n = paramKeyStore.length;
    int m = 0;
    while (m < n)
    {
      String str = paramKeyStore[m];
      if ((str instanceof X509TrustManager)) {
        try
        {
          if (Build.VERSION.SDK_INT >= 17) {
            return new b.d((X509TrustManager)str);
          }
          localObject = new b.b((X509TrustManager)str);
          return localObject;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          str = str.getClass().getName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error creating trust manager (");
          localStringBuilder.append(str);
          localStringBuilder.append("): ");
          localStringBuilder.append(localIllegalArgumentException);
          o.b("X509Util", localStringBuilder.toString());
        }
      }
      m += 1;
    }
    o.b("X509Util", "Could not find suitable trust manager");
    return null;
  }
  
  private static String a(X500Principal paramX500Principal)
  {
    paramX500Principal = MessageDigest.getInstance("MD5").digest(paramX500Principal.getEncoded());
    char[] arrayOfChar1 = new char[8];
    int m = 0;
    while (m < 4)
    {
      int n = m * 2;
      char[] arrayOfChar2 = l;
      int i1 = 3 - m;
      arrayOfChar1[n] = arrayOfChar2[(paramX500Principal[i1] >> 4 & 0xF)];
      arrayOfChar1[(n + 1)] = arrayOfChar2[(paramX500Principal[i1] & 0xF)];
      m += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static X509Certificate a(byte[] paramArrayOfByte)
  {
    b();
    return (X509Certificate)b.generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  static boolean a(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = paramX509Certificate.getExtendedKeyUsage();
      if (paramX509Certificate == null) {
        return true;
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        String str = (String)paramX509Certificate.next();
        if ((str.equals("1.3.6.1.5.5.7.3.1")) || (str.equals("2.5.29.37.0")) || (str.equals("2.16.840.1.113730.4.1")) || (str.equals("1.3.6.1.4.1.311.10.3.3"))) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException paramX509Certificate) {}
    return false;
  }
  
  private static boolean a(List<String> paramList, String paramString)
  {
    if (paramList.contains(paramString)) {
      return true;
    }
    int m = paramString.indexOf(".");
    int n = paramString.lastIndexOf(".");
    while ((m > 0) && (m < n))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(paramString.substring(m));
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("try match nhost ");
      localStringBuilder.append((String)localObject);
      o.d("X509Util", localStringBuilder.toString());
      if (paramList.contains(localObject)) {
        return true;
      }
      m = paramString.indexOf(".", m + 1);
    }
    return false;
  }
  
  private static void b()
  {
    synchronized (k)
    {
      c();
      return;
    }
  }
  
  private static boolean b(X509Certificate paramX509Certificate)
  {
    if ((!a) && (!Thread.holdsLock(k))) {
      throw new AssertionError();
    }
    if (g == null) {
      return false;
    }
    Pair localPair = new Pair(paramX509Certificate.getSubjectX500Principal(), paramX509Certificate.getPublicKey());
    if (i.contains(localPair)) {
      return true;
    }
    String str = a(paramX509Certificate.getSubjectX500Principal());
    int m = 0;
    for (;;)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append('.');
      ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!new i(h, (String)localObject1).j()) {
        return false;
      }
      Object localObject2 = g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("system:");
      localStringBuilder.append((String)localObject1);
      localObject2 = ((KeyStore)localObject2).getCertificate(localStringBuilder.toString());
      if (localObject2 != null) {
        if (!(localObject2 instanceof X509Certificate))
        {
          localObject2 = localObject2.getClass().getName();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Anchor ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" not an X509Certificate: ");
          localStringBuilder.append((String)localObject2);
          o.b("X509Util", localStringBuilder.toString());
        }
        else
        {
          localObject1 = (X509Certificate)localObject2;
          if ((paramX509Certificate.getSubjectX500Principal().equals(((X509Certificate)localObject1).getSubjectX500Principal())) && (paramX509Certificate.getPublicKey().equals(((X509Certificate)localObject1).getPublicKey())))
          {
            i.add(localPair);
            return true;
          }
        }
      }
      m += 1;
    }
  }
  
  private static List<String> c(X509Certificate paramX509Certificate)
  {
    Object localObject1 = paramX509Certificate.getSubjectAlternativeNames();
    if (localObject1 == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((List)((Iterator)localObject1).next()).get(1);
      if ((localObject2 instanceof String)) {
        localArrayList.add(((String)localObject2).toLowerCase());
      }
    }
    Object localObject2 = paramX509Certificate.getSubjectDN().getName().trim();
    int m = ((String)localObject2).indexOf("CN=");
    if (m >= 0)
    {
      localObject1 = ((String)localObject2).substring(m + 3);
      m = ((String)localObject1).indexOf(",");
      paramX509Certificate = (X509Certificate)localObject1;
      if (m > 0) {
        paramX509Certificate = ((String)localObject1).substring(0, m);
      }
    }
    else
    {
      paramX509Certificate = "";
    }
    o.d("X509Util", "certificate dn %s cn %s", new Object[] { localObject2, paramX509Certificate });
    if (paramX509Certificate.length() > 0) {
      localArrayList.add(paramX509Certificate);
    }
    return localArrayList;
  }
  
  /* Error */
  private static void c()
  {
    // Byte code:
    //   0: getstatic 36	com/tencent/mars/cdn/b:a	Z
    //   3: ifne +23 -> 26
    //   6: getstatic 41	com/tencent/mars/cdn/b:k	Ljava/lang/Object;
    //   9: invokestatic 348	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifeq +6 -> 18
    //   15: goto +11 -> 26
    //   18: new 350	java/lang/AssertionError
    //   21: dup
    //   22: invokespecial 351	java/lang/AssertionError:<init>	()V
    //   25: athrow
    //   26: getstatic 273	com/tencent/mars/cdn/b:b	Ljava/security/cert/CertificateFactory;
    //   29: ifnonnull +12 -> 41
    //   32: ldc_w 441
    //   35: invokestatic 444	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   38: putstatic 273	com/tencent/mars/cdn/b:b	Ljava/security/cert/CertificateFactory;
    //   41: getstatic 160	com/tencent/mars/cdn/b:c	Lcom/tencent/mars/cdn/b$c;
    //   44: ifnonnull +10 -> 54
    //   47: aconst_null
    //   48: invokestatic 446	com/tencent/mars/cdn/b:a	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/b$c;
    //   51: putstatic 160	com/tencent/mars/cdn/b:c	Lcom/tencent/mars/cdn/b$c;
    //   54: getstatic 448	com/tencent/mars/cdn/b:j	Z
    //   57: ifne +64 -> 121
    //   60: ldc_w 450
    //   63: invokestatic 453	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   66: putstatic 353	com/tencent/mars/cdn/b:g	Ljava/security/KeyStore;
    //   69: getstatic 353	com/tencent/mars/cdn/b:g	Ljava/security/KeyStore;
    //   72: aconst_null
    //   73: invokevirtual 457	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   76: new 122	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   83: astore_0
    //   84: aload_0
    //   85: ldc_w 459
    //   88: invokestatic 465	java/lang/System:getenv	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_0
    //   96: ldc_w 467
    //   99: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 378	com/tencent/luggage/wxa/rt/i
    //   106: dup
    //   107: aload_0
    //   108: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 468	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   114: putstatic 380	com/tencent/mars/cdn/b:h	Lcom/tencent/luggage/wxa/rt/i;
    //   117: iconst_1
    //   118: putstatic 448	com/tencent/mars/cdn/b:j	Z
    //   121: getstatic 368	com/tencent/mars/cdn/b:i	Ljava/util/Set;
    //   124: ifnonnull +13 -> 137
    //   127: new 470	java/util/HashSet
    //   130: dup
    //   131: invokespecial 471	java/util/HashSet:<init>	()V
    //   134: putstatic 368	com/tencent/mars/cdn/b:i	Ljava/util/Set;
    //   137: getstatic 473	com/tencent/mars/cdn/b:f	Ljava/security/KeyStore;
    //   140: ifnonnull +22 -> 162
    //   143: invokestatic 476	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   146: invokestatic 453	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   149: putstatic 473	com/tencent/mars/cdn/b:f	Ljava/security/KeyStore;
    //   152: getstatic 473	com/tencent/mars/cdn/b:f	Ljava/security/KeyStore;
    //   155: aconst_null
    //   156: invokevirtual 457	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   159: goto +3 -> 162
    //   162: getstatic 183	com/tencent/mars/cdn/b:e	Lcom/tencent/mars/cdn/b$c;
    //   165: ifnonnull +12 -> 177
    //   168: getstatic 473	com/tencent/mars/cdn/b:f	Ljava/security/KeyStore;
    //   171: invokestatic 446	com/tencent/mars/cdn/b:a	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/b$c;
    //   174: putstatic 183	com/tencent/mars/cdn/b:e	Lcom/tencent/mars/cdn/b$c;
    //   177: getstatic 478	com/tencent/mars/cdn/b:d	Lcom/tencent/mars/cdn/b$a;
    //   180: ifnonnull +72 -> 252
    //   183: new 480	com/tencent/mars/cdn/b$a
    //   186: dup
    //   187: aconst_null
    //   188: invokespecial 483	com/tencent/mars/cdn/b$a:<init>	(Lcom/tencent/mars/cdn/b$1;)V
    //   191: putstatic 478	com/tencent/mars/cdn/b:d	Lcom/tencent/mars/cdn/b$a;
    //   194: new 485	android/content/IntentFilter
    //   197: dup
    //   198: invokespecial 486	android/content/IntentFilter:<init>	()V
    //   201: astore_0
    //   202: getstatic 224	android/os/Build$VERSION:SDK_INT	I
    //   205: bipush 26
    //   207: if_icmplt +27 -> 234
    //   210: aload_0
    //   211: ldc_w 488
    //   214: invokevirtual 491	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: ldc_w 493
    //   221: invokevirtual 491	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: ldc_w 495
    //   228: invokevirtual 491	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   231: goto +10 -> 241
    //   234: aload_0
    //   235: ldc_w 497
    //   238: invokevirtual 491	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: invokestatic 502	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   244: getstatic 478	com/tencent/mars/cdn/b:d	Lcom/tencent/mars/cdn/b$a;
    //   247: aload_0
    //   248: invokevirtual 508	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   251: pop
    //   252: return
    //   253: astore_0
    //   254: goto -137 -> 117
    //   257: astore_0
    //   258: goto -182 -> 76
    //   261: astore_0
    //   262: goto -100 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   83	165	0	localObject	Object
    //   253	1	0	localKeyStoreException	java.security.KeyStoreException
    //   257	1	0	localIOException1	java.io.IOException
    //   261	1	0	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   60	69	253	java/security/KeyStoreException
    //   69	76	253	java/security/KeyStoreException
    //   76	117	253	java/security/KeyStoreException
    //   69	76	257	java/io/IOException
    //   152	159	261	java/io/IOException
  }
  
  private static void d()
  {
    synchronized (k)
    {
      c = null;
      i = null;
      c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.b
 * JD-Core Version:    0.7.0.1
 */