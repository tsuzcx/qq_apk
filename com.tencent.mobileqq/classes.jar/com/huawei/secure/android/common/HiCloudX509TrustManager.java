package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.util.f;
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

@Deprecated
public class HiCloudX509TrustManager
  implements X509TrustManager
{
  private static final String a = "X509";
  private static final String b = "bks";
  protected List<X509TrustManager> c = new ArrayList();
  
  @Deprecated
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
    if (!this.c.isEmpty())
    {
      ((X509TrustManager)this.c.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
    }
    return (X509Certificate[])localArrayList.toArray(new X509Certificate[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.HiCloudX509TrustManager
 * JD-Core Version:    0.7.0.1
 */