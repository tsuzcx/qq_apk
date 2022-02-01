package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;

public class SecureX509SingleInstance
{
  private static final String a = "SecureX509SingleInstance";
  private static volatile SecureX509TrustManager b;
  
  @SuppressLint({"NewApi"})
  public static SecureX509TrustManager getInstance(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (paramContext != null)
    {
      c.a(paramContext);
      if (b == null) {
        try
        {
          if (b == null)
          {
            localObject = BksUtil.getFilesBksIS(paramContext);
            if (localObject == null)
            {
              g.c(a, "get assets bks");
              localObject = paramContext.getAssets().open("hmsrootcas.bks");
            }
            else
            {
              g.c(a, "get files bks");
            }
            b = new SecureX509TrustManager((InputStream)localObject, "");
            new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[] { paramContext });
          }
        }
        finally {}
      }
      paramContext = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SecureX509TrustManager getInstance: cost : ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(" ms");
      g.a(paramContext, ((StringBuilder)localObject).toString());
      return b;
    }
    throw new NullPointerException("context is null");
  }
  
  public static void updateBks(InputStream paramInputStream)
  {
    g.c(a, "update bks");
    long l = System.currentTimeMillis();
    if ((paramInputStream != null) && (b != null))
    {
      b = new SecureX509TrustManager(paramInputStream, "");
      SecureSSLSocketFactory.a(b);
      SecureApacheSSLSocketFactory.a(b);
    }
    paramInputStream = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SecureX509TrustManager update bks cost : ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms");
    g.c(paramInputStream, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SecureX509SingleInstance
 * JD-Core Version:    0.7.0.1
 */