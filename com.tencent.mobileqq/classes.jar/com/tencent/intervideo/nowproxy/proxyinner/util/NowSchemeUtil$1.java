package com.tencent.intervideo.nowproxy.proxyinner.util;

import com.tencent.intervideo.nowproxy.baseability.log.DefaultLog;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class NowSchemeUtil$1
  implements Runnable
{
  NowSchemeUtil$1(String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = (HttpURLConnection)new URL(this.val$gdt_url).openConnection();
      ((HttpURLConnection)localObject1).connect();
      if (((HttpURLConnection)localObject1).getResponseCode() == 200) {
        ((HttpURLConnection)localObject1).getInputStream();
      }
      localObject1 = NowSchemeUtil.access$000();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ping gdt time = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      XLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (IOException localIOException)
    {
      Object localObject2 = NowSchemeUtil.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ping gdt e = ");
      localStringBuilder.append(localIOException.getMessage());
      DefaultLog.e((String)localObject2, localStringBuilder.toString());
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil.1
 * JD-Core Version:    0.7.0.1
 */