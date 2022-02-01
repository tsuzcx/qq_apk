package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.StatisticRequest;
import com.tencent.map.tools.net.NetResponse;
import java.io.UnsupportedEncodingException;

public final class jh$2
  implements Runnable
{
  public jh$2(jh paramjh, String paramString) {}
  
  public final void run()
  {
    or.a("statistic data:" + this.a);
    try
    {
      Object localObject = this.a.getBytes("UTF-8");
      try
      {
        localObject = ((StatisticRequest)((nk)MapServiceManager.getService(nk.class)).c()).report(pz.a, jh.b(this.b), fz.g(), jh.c(this.b), fz.c(), fz.a(), fz.d(), fz.e(), "4.2.8.2", fz.f(), "androidsdk", fz.b(), (byte[])localObject);
        if (localObject == null) {
          break label170;
        }
        or.a("Post statistic data with response:" + new String(((NetResponse)localObject).data, ((NetResponse)localObject).charset));
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          or.b(localException.getMessage());
          int i = 0;
        }
      }
      if (i == 0) {
        jh.a(this.b, this.a);
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        arrayOfByte = this.a.getBytes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jh.2
 * JD-Core Version:    0.7.0.1
 */