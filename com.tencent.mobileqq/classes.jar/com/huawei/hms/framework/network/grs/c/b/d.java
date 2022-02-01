package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
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

public class d
  implements X509TrustManager
{
  protected List<X509TrustManager> a = new ArrayList();
  
  public d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("context or trust file is null");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      int i;
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        localObject1 = localObject2;
        KeyStore localKeyStore = KeyStore.getInstance("bks");
        localObject1 = localObject2;
        paramContext = paramContext.getAssets().open(paramString);
        localObject1 = paramContext;
        paramContext.reset();
        localObject1 = paramContext;
        localKeyStore.load(paramContext, "".toCharArray());
        localObject1 = paramContext;
        localTrustManagerFactory.init(localKeyStore);
        localObject1 = paramContext;
        paramString = localTrustManagerFactory.getTrustManagers();
        i = 0;
        localObject1 = paramContext;
        if (i < paramString.length)
        {
          localObject1 = paramContext;
          if (!(paramString[i] instanceof X509TrustManager)) {
            break label197;
          }
          localObject1 = paramContext;
          this.a.add((X509TrustManager)paramString[i]);
          break label197;
        }
        localObject1 = paramContext;
        if (this.a.isEmpty())
        {
          localObject1 = paramContext;
          throw new CertificateException("X509TrustManager is empty");
        }
      }
      finally
      {
        IoUtils.closeSecure((InputStream)localObject1);
      }
      IoUtils.closeSecure(paramContext);
      return;
      label197:
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
      Logger.w("SecureX509TrustManager", "getAcceptedIssuers exception");
      return new X509Certificate[0];
    }
    X509Certificate[] arrayOfX509Certificate;
    return arrayOfX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.d
 * JD-Core Version:    0.7.0.1
 */