package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HiCloudX509TrustManager
  implements X509TrustManager
{
  private static final String TAG = HiCloudX509TrustManager.class.getSimpleName();
  private static final String a = "X509";
  private static final String b = "bks";
  protected List<X509TrustManager> c = new ArrayList();
  
  public HiCloudX509TrustManager(InputStream paramInputStream, String paramString)
  {
    if ((paramInputStream == null) || (paramString == null)) {
      throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
    for (;;)
    {
      int i;
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        KeyStore localKeyStore = KeyStore.getInstance("bks");
        localKeyStore.load(paramInputStream, paramString.toCharArray());
        localTrustManagerFactory.init(localKeyStore);
        paramString = localTrustManagerFactory.getTrustManagers();
        i = 0;
        if (i < paramString.length)
        {
          if (!(paramString[i] instanceof X509TrustManager)) {
            break label140;
          }
          this.c.add((X509TrustManager)paramString[i]);
          break label140;
        }
        if (this.c.isEmpty()) {
          throw new CertificateException("X509TrustManager is empty");
        }
      }
      finally
      {
        f.c(paramInputStream);
      }
      f.c(paramInputStream);
      return;
      label140:
      i += 1;
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.c.isEmpty())
    {
      ((X509TrustManager)this.c.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    int j = 0;
    g.c(TAG, "checkServerTrusted begin ,server ca chain size is : " + paramArrayOfX509Certificate.length);
    int k = paramArrayOfX509Certificate.length;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = paramArrayOfX509Certificate[i];
      g.b(TAG, "server ca chain: getSubjectDN is :" + ((X509Certificate)localObject).getSubjectDN() + " , getIssuerDN :" + ((X509Certificate)localObject).getIssuerDN());
      i += 1;
    }
    if (!this.c.isEmpty())
    {
      localObject = (X509TrustManager)this.c.get(0);
      X509Certificate[] arrayOfX509Certificate = ((X509TrustManager)localObject).getAcceptedIssuers();
      if (arrayOfX509Certificate != null)
      {
        g.c(TAG, "client root ca size is : " + arrayOfX509Certificate.length);
        i = j;
        while (i < arrayOfX509Certificate.length)
        {
          g.b(TAG, "client root ca getIssuerDN :" + arrayOfX509Certificate[i].getIssuerDN());
          i += 1;
        }
      }
      ((X509TrustManager)localObject).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkServerTrusted CertificateException");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.HiCloudX509TrustManager
 * JD-Core Version:    0.7.0.1
 */