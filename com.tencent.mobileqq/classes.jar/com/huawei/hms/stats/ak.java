package com.huawei.hms.stats;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ak
  implements X509TrustManager
{
  protected List<X509TrustManager> a = new ArrayList();
  
  public ak(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null,can not read CA");
    }
    TrustManager[] arrayOfTrustManager = null;
    Object localObject = arrayOfTrustManager;
    for (;;)
    {
      int i;
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        localObject = arrayOfTrustManager;
        KeyStore localKeyStore = KeyStore.getInstance("bks");
        localObject = arrayOfTrustManager;
        paramContext = paramContext.getAssets().open("updatesdkcas.bks");
        localObject = paramContext;
        paramContext.reset();
        localObject = paramContext;
        localKeyStore.load(paramContext, "".toCharArray());
        localObject = paramContext;
        localTrustManagerFactory.init(localKeyStore);
        localObject = paramContext;
        arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
        i = 0;
        localObject = paramContext;
        if (i < arrayOfTrustManager.length)
        {
          localObject = paramContext;
          if (!(arrayOfTrustManager[i] instanceof X509TrustManager)) {
            break label185;
          }
          localObject = paramContext;
          this.a.add((X509TrustManager)arrayOfTrustManager[i]);
          break label185;
        }
        localObject = paramContext;
        if (this.a.isEmpty())
        {
          localObject = paramContext;
          throw new CertificateException("X509TrustManager is empty");
        }
      }
      finally
      {
        ba.a((Closeable)localObject);
      }
      ba.a(paramContext);
      return;
      label185:
      i += 1;
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.a.isEmpty())
    {
      ((X509TrustManager)this.a.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.a.isEmpty())
    {
      ((X509TrustManager)this.a.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
      }
      arrayOfX509Certificate = (X509Certificate[])localException.toArray(new X509Certificate[localException.size()]);
    }
    catch (Exception localException)
    {
      af.d("SecureX509TrustManager", "getAcceptedIssuers exception : " + localException.getMessage());
      return new X509Certificate[0];
    }
    X509Certificate[] arrayOfX509Certificate;
    return arrayOfX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ak
 * JD-Core Version:    0.7.0.1
 */