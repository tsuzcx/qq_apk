package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;

public class SSFSecureX509SingleInstance
{
  private static final String a = "SSFSecureX509SingleInstance";
  private static volatile SecureX509TrustManager b;
  
  @SuppressLint({"NewApi"})
  public static SecureX509TrustManager getInstance(Context paramContext)
  {
    if (paramContext != null)
    {
      c.a(paramContext);
      if (b == null) {
        try
        {
          if (b == null)
          {
            InputStream localInputStream = BksUtil.getFilesBksIS(paramContext);
            if (localInputStream == null)
            {
              g.c(a, "get assets bks");
              localInputStream = paramContext.getAssets().open("hmsrootcas.bks");
            }
            else
            {
              g.c(a, "get files bks");
            }
            b = new SecureX509TrustManager(localInputStream, "", true);
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[] { paramContext });
          }
        }
        finally {}
      }
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
      b = new SecureX509TrustManager(paramInputStream, "", true);
      paramInputStream = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBks: new SecureX509TrustManager cost : ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      localStringBuilder.append(" ms");
      g.a(paramInputStream, localStringBuilder.toString());
      SSFCompatiableSystemCA.a(b);
      SASFCompatiableSystemCA.a(b);
    }
    paramInputStream = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update bks cost : ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms");
    g.a(paramInputStream, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SSFSecureX509SingleInstance
 * JD-Core Version:    0.7.0.1
 */