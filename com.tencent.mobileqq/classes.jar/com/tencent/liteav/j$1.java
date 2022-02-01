package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class j$1
  implements Runnable
{
  j$1(j paramj, int paramInt, String paramString1, String paramString2, j.a parama) {}
  
  public void run()
  {
    j.a(this.e, System.currentTimeMillis());
    Object localObject1 = this.e;
    Object localObject2 = "";
    j.a((j)localObject1, "");
    j.a(this.e, this.a);
    j.b(this.e, this.b);
    j.a(this.e, TXCCommonUtil.getStreamIDByStreamUrl(this.c));
    j.c(this.e, TXCCommonUtil.getAppNameByStreamUrl(this.c));
    if (j.a(this.e) == null) {
      j.c(this.e, "live");
    }
    if (j.b(this.e) < 0) {
      localObject1 = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0", new Object[] { j.c(this.e), j.a(this.e), j.d(this.e) });
    } else {
      localObject1 = String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[] { j.c(this.e), Integer.valueOf(j.b(this.e)), j.d(this.e), j.e(this.e) });
    }
    try
    {
      localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
      ((HttpURLConnection)localObject1).setDoOutput(true);
      ((HttpURLConnection)localObject1).setDoInput(true);
      ((HttpURLConnection)localObject1).setUseCaches(false);
      ((HttpURLConnection)localObject1).setConnectTimeout(5000);
      ((HttpURLConnection)localObject1).setReadTimeout(5000);
      ((HttpURLConnection)localObject1).setRequestMethod("GET");
      ((HttpURLConnection)localObject1).setRequestProperty("Charsert", "UTF-8");
      ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "text/plain;");
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
      StringBuilder localStringBuilder2;
      for (localObject1 = localObject2;; localObject1 = localStringBuilder2.toString())
      {
        localObject2 = localBufferedReader.readLine();
        if (localObject2 == null) {
          break;
        }
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject1);
        localStringBuilder2.append((String)localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("prepareSeekTime: receive response, strResponse = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      TXCLog.i("TXCTimeShiftUtil", ((StringBuilder)localObject2).toString());
      localObject1 = j.d(this.e, (String)localObject1);
      if (localObject1 != null) {
        j.a(this.e, Long.parseLong((String)localObject1) * 1000L);
      }
    }
    catch (Exception localException)
    {
      j.a(this.e, System.currentTimeMillis());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("prepareSeekTime error ");
      ((StringBuilder)localObject2).append(localException.toString());
      TXCLog.e("TXCTimeShiftUtil", ((StringBuilder)localObject2).toString());
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("live start time:");
    localStringBuilder1.append(j.f(this.e));
    localStringBuilder1.append(",currentTime:");
    localStringBuilder1.append(l1);
    localStringBuilder1.append(",diff:");
    localStringBuilder1.append(l1 - j.f(this.e));
    TXCLog.i("TXCTimeShiftUtil", localStringBuilder1.toString());
    long l2 = j.f(this.e);
    if (this.d != null) {
      new Handler(Looper.getMainLooper()).post(new j.1.1(this, l1 - l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.j.1
 * JD-Core Version:    0.7.0.1
 */