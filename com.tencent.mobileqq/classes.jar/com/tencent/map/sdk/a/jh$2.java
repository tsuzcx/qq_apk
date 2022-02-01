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
    Object localObject = new StringBuilder("statistic data:");
    ((StringBuilder)localObject).append(this.a);
    or.a(((StringBuilder)localObject).toString());
    try
    {
      localObject = this.a.getBytes("UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label39:
      int j;
      int i;
      break label39;
    }
    localObject = this.a.getBytes();
    j = 0;
    try
    {
      localObject = ((StatisticRequest)((nk)MapServiceManager.getService(nk.class)).c()).report(pz.a, jh.b(this.b), fz.g(), jh.c(this.b), fz.c(), fz.a(), fz.d(), fz.e(), "4.2.8.2", fz.f(), "androidsdk", fz.b(), (byte[])localObject);
      i = j;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("Post statistic data with response:");
        localStringBuilder.append(new String(((NetResponse)localObject).data, ((NetResponse)localObject).charset));
        or.a(localStringBuilder.toString());
        i = 1;
      }
    }
    catch (Exception localException)
    {
      or.b(localException.getMessage());
      i = j;
    }
    if (i == 0) {
      jh.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jh.2
 * JD-Core Version:    0.7.0.1
 */