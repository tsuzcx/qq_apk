package com.huawei.secure.android.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@Deprecated
public class SecureX509TrustManager
  implements X509TrustManager
{
  private static final String TAG = "SecureX509TrustManager";
  private static final String a = "X509";
  private static final String b = "bks";
  private static final String k = "hmsrootcas.bks";
  private static final String l = "";
  protected ArrayList<X509TrustManager> m = new ArrayList();
  
  @Deprecated
  public SecureX509TrustManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalAccessException("context is null");
    }
    TrustManager[] arrayOfTrustManager = null;
    localObject = arrayOfTrustManager;
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
      localObject = arrayOfTrustManager;
      KeyStore localKeyStore = KeyStore.getInstance("bks");
      localObject = arrayOfTrustManager;
      paramContext = paramContext.getAssets().open("hmsrootcas.bks");
      localObject = paramContext;
      paramContext.reset();
      localObject = paramContext;
      localKeyStore.load(paramContext, "".toCharArray());
      localObject = paramContext;
      localTrustManagerFactory.init(localKeyStore);
      localObject = paramContext;
      arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        if (localObject != null) {}
        try
        {
          ((InputStream)localObject).close();
          throw paramContext;
          if (paramContext != null) {}
          try
          {
            paramContext.close();
            return;
          }
          catch (IOException paramContext)
          {
            Log.e("SecureX509TrustManager", "close bks exception");
            return;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("SecureX509TrustManager", "close bks exception");
          }
        }
        i += 1;
      }
    }
    localObject = paramContext;
    if (i < arrayOfTrustManager.length)
    {
      localObject = paramContext;
      if ((arrayOfTrustManager[i] instanceof X509TrustManager))
      {
        localObject = paramContext;
        this.m.add((X509TrustManager)arrayOfTrustManager[i]);
      }
    }
    else
    {
      localObject = paramContext;
      if (this.m.isEmpty())
      {
        localObject = paramContext;
        throw new CertificateException("X509TrustManager is empty");
      }
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.m.isEmpty())
    {
      ((X509TrustManager)this.m.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.m.isEmpty())
    {
      ((X509TrustManager)this.m.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
    }
    return (X509Certificate[])localArrayList.toArray(new X509Certificate[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.SecureX509TrustManager
 * JD-Core Version:    0.7.0.1
 */