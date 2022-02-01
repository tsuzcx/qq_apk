package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class a
{
  public static HostnameVerifier a()
  {
    return new StrictHostnameVerifier();
  }
  
  public static SSLSocketFactory a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets();
      paramContext = paramContext.open("grs_sp.bks");
      paramContext = new SecureSSLSocketFactory(new SecureX509TrustManager(paramContext, ""));
      return paramContext;
    }
    catch (KeyManagementException paramContext) {}catch (NoSuchAlgorithmException paramContext) {}catch (IOException paramContext) {}
    throw new AssertionError(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.b.a
 * JD-Core Version:    0.7.0.1
 */