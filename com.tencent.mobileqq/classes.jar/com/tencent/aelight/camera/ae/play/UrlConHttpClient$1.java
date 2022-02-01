package com.tencent.aelight.camera.ae.play;

import android.net.TrafficStats;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class UrlConHttpClient$1
  implements Runnable
{
  UrlConHttpClient$1(UrlConHttpClient paramUrlConHttpClient, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    try
    {
      try
      {
        Object localObject1 = (HttpURLConnection)new URL(this.val$url).openConnection();
        ((HttpURLConnection)localObject1).setConnectTimeout(3000);
        ((HttpURLConnection)localObject1).setReadTimeout(3000);
        TrafficStats.setThreadStatsTag(-255);
        ((HttpURLConnection)localObject1).setRequestProperty("Charset", "UTF-8");
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        ((HttpURLConnection)localObject1).connect();
        int i = ((HttpURLConnection)localObject1).getResponseCode();
        Object localObject3;
        if (i == 200)
        {
          Object localObject4 = ((HttpURLConnection)localObject1).getInputStream();
          localObject3 = new ByteArrayOutputStream();
          Object localObject5 = new byte[1024];
          for (;;)
          {
            i = ((InputStream)localObject4).read((byte[])localObject5);
            if (-1 == i) {
              break;
            }
            ((ByteArrayOutputStream)localObject3).write((byte[])localObject5, 0, i);
            ((ByteArrayOutputStream)localObject3).flush();
          }
          ((InputStream)localObject4).close();
          localObject4 = ((ByteArrayOutputStream)localObject3).toString();
          ((ByteArrayOutputStream)localObject3).close();
          localObject3 = UrlConHttpClient.access$000();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("onResponse: ");
          ((StringBuilder)localObject5).append((String)localObject4);
          LogUtils.i((String)localObject3, ((StringBuilder)localObject5).toString());
          if (UrlConHttpClient.access$100(this.this$0) != null) {
            if (localObject4 != null) {
              UrlConHttpClient.access$100(this.this$0).response(this.val$getCode, 0, (String)localObject4, this.val$targetName);
            } else {
              UrlConHttpClient.access$100(this.this$0).response(this.val$getCode, 1, "回包异常。", this.val$targetName);
            }
          }
          ((HttpURLConnection)localObject1).disconnect();
        }
        else if ((i == 301) && (this.val$url.contains("http:")))
        {
          this.this$0.get(this.val$getCode, this.val$targetName, this.val$url.replace("http:", "https:"));
        }
        else
        {
          localObject1 = UrlConHttpClient.access$000();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("->链接失败：");
          ((StringBuilder)localObject3).append(this.val$url);
          LogUtils.e((String)localObject1, ((StringBuilder)localObject3).toString());
          localObject1 = this.this$0;
          int j = this.val$getCode;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("->链接失败：");
          ((StringBuilder)localObject3).append(this.val$url);
          UrlConHttpClient.access$200((UrlConHttpClient)localObject1, j, ((StringBuilder)localObject3).toString(), this.val$targetName);
        }
      }
      finally
      {
        break label469;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label448;
    }
    catch (IOException localIOException)
    {
      break label428;
    }
    catch (Exception localException)
    {
      label408:
      label428:
      label448:
      label465:
      label469:
      break label408;
    }
    UrlConHttpClient.access$200(this.this$0, this.val$getCode, "Exception:异常。", this.val$targetName);
    break label465;
    UrlConHttpClient.access$200(this.this$0, this.val$getCode, "IOException:读取有异常。", this.val$targetName);
    break label465;
    UrlConHttpClient.access$200(this.this$0, this.val$getCode, "MalformedURLException:URL 有异常。", this.val$targetName);
    TrafficStats.clearThreadStatsTag();
    return;
    TrafficStats.clearThreadStatsTag();
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.UrlConHttpClient.1
 * JD-Core Version:    0.7.0.1
 */