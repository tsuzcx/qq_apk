package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor.Chain;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Request.Builder;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;

public class f
  implements PluginInterceptor
{
  private static final String a = "f";
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    paramChain = (RealInterceptorChain)paramChain;
    Request localRequest = paramChain.request();
    String str = localRequest.getUrl().getUrl();
    if (GrsManager.isGRSSchema(str))
    {
      Logger.v(a, "request url is grs schema.");
      RCEventListener localRCEventListener = paramChain.getRCEventListener();
      localRCEventListener.convertGrsStart(str);
      str = GrsManager.getInstance().parseGrs(str);
      localRequest = localRequest.newBuilder().url(new HttpUrl(str)).build();
      Logger.v(a, "origin url is grs schema and by intercepted,and now request is:%s", new Object[] { localRequest.toString() });
      localRCEventListener.convertGrsEnd(str);
      return paramChain.proceed(localRequest);
    }
    return paramChain.proceed(localRequest);
  }
  
  public String pluginName()
  {
    return f.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.f
 * JD-Core Version:    0.7.0.1
 */