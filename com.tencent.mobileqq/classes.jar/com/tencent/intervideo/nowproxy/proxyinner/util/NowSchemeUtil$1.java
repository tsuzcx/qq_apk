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
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.val$gdt_url).openConnection();
      localHttpURLConnection.connect();
      if (localHttpURLConnection.getResponseCode() == 200) {
        localHttpURLConnection.getInputStream();
      }
      XLog.i(NowSchemeUtil.access$000(), "ping gdt time = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (IOException localIOException)
    {
      DefaultLog.e(NowSchemeUtil.access$000(), "ping gdt e = " + localIOException.getMessage());
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil.1
 * JD-Core Version:    0.7.0.1
 */