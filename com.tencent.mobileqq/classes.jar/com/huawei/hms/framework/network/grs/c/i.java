package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

public class i
  extends b
  implements Callable<f>
{
  private static final String i = "i";
  
  public i(String paramString1, int paramInt, a parama, Context paramContext, String paramString2, GrsBaseInfo paramGrsBaseInfo)
  {
    super(paramString1, paramInt, parama, paramContext, paramString2, paramGrsBaseInfo, null);
  }
  
  public f call()
  {
    Logger.i(i, "Get call execute");
    long l1 = 0L;
    label362:
    for (;;)
    {
      long l4;
      try
      {
        l3 = SystemClock.elapsedRealtime();
        try
        {
          l2 = System.currentTimeMillis();
          l1 = l2;
          HttpsURLConnection localHttpsURLConnection = com.huawei.hms.framework.network.grs.d.a.a.a(c(), b(), e());
          Object localObject1 = null;
          InputStream localInputStream = null;
          if (localHttpsURLConnection == null)
          {
            l1 = l2;
            localObject1 = i;
            l1 = l2;
            Logger.w((String)localObject1, "create HttpsURLConnection instance by url return null.");
            return null;
          }
          l1 = l2;
          localHttpsURLConnection.setRequestMethod("GET");
          l1 = l2;
          localHttpsURLConnection.connect();
          l1 = l2;
          int j = localHttpsURLConnection.getResponseCode();
          if (j == 200)
          {
            localObject1 = localInputStream;
            try
            {
              localInputStream = localHttpsURLConnection.getInputStream();
              localObject1 = localInputStream;
              byte[] arrayOfByte = IoUtils.toByteArray(localInputStream);
              l1 = l2;
              IoUtils.closeSecure(localInputStream);
              localObject1 = arrayOfByte;
            }
            finally
            {
              l1 = l2;
              IoUtils.closeSecure((InputStream)localObject1);
              l1 = l2;
            }
          }
          l1 = l2;
          Map localMap = localHttpsURLConnection.getHeaderFields();
          l1 = l2;
          localHttpsURLConnection.disconnect();
          l1 = l2;
          long l5 = SystemClock.elapsedRealtime();
          l1 = l2;
          l4 = System.currentTimeMillis();
          if (localObject1 != null) {
            break label362;
          }
          l1 = l2;
          localObject1 = new byte[0];
          l1 = l2;
          this.a = new f(j, localMap, (byte[])localObject1, l5 - l3);
          l1 = l2;
          l2 = l4;
        }
        catch (IOException localIOException1)
        {
          l2 = l3;
        }
        l4 = SystemClock.elapsedRealtime();
      }
      catch (IOException localIOException2)
      {
        l2 = 0L;
      }
      long l3 = System.currentTimeMillis();
      Logger.w(i, "RequestCallable run task catch IOException", localIOException2);
      this.a = new f(localIOException2, l4 - l2);
      long l2 = l3;
      this.a.a(c());
      this.a.a(d());
      this.a.b(l1);
      this.a.a(l2);
      if (a() != null) {
        a().a(this.a);
      }
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.i
 * JD-Core Version:    0.7.0.1
 */