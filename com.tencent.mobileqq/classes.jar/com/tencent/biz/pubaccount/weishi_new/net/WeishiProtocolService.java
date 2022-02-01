package com.tencent.biz.pubaccount.weishi_new.net;

import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

@Deprecated
public class WeishiProtocolService
{
  private static Object a = new Object();
  private static WeishiProtocolService b;
  
  public static WeishiProtocolService a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new WeishiProtocolService();
        }
      }
    }
    return b;
  }
  
  public int a(WeishiRequest paramWeishiRequest, IWeishiProtocolListener paramIWeishiProtocolListener)
  {
    if (paramWeishiRequest == null) {
      return 1000004;
    }
    paramWeishiRequest.a(paramIWeishiProtocolListener);
    paramWeishiRequest.g = System.currentTimeMillis();
    try
    {
      Object localObject = new WeishiIntent(BaseApplication.getContext(), WeishiServlet.class);
      ((WeishiIntent)localObject).setWithouLogin(true);
      ((WeishiIntent)localObject).a = ((WeishiTask)paramIWeishiProtocolListener);
      ((WeishiIntent)localObject).putExtra("timeout", paramWeishiRequest.p);
      if (((WeishiIntent)localObject).a != null)
      {
        if (((WeishiIntent)localObject).a.g == null) {
          return 1000004;
        }
        paramIWeishiProtocolListener = BaseApplicationImpl.getApplication().getRuntime();
        if (paramIWeishiProtocolListener != null)
        {
          paramIWeishiProtocolListener.startServlet((NewIntent)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd=");
          ((StringBuilder)localObject).append(paramWeishiRequest.uniKey());
          ((StringBuilder)localObject).append(", pkgId=");
          ((StringBuilder)localObject).append(paramWeishiRequest.h());
          ((StringBuilder)localObject).append(" submit to MSF, isLogin: ");
          ((StringBuilder)localObject).append(paramIWeishiProtocolListener.isLogin());
          Log.i("weishi", ((StringBuilder)localObject).toString());
        }
        else
        {
          Log.e("weishi", "app is null");
        }
      }
      else
      {
        return 1000004;
      }
    }
    catch (Exception paramWeishiRequest)
    {
      paramIWeishiProtocolListener = new StringBuilder();
      paramIWeishiProtocolListener.append("WeishiProtocolService occur exception. stack=");
      paramIWeishiProtocolListener.append(paramWeishiRequest.getLocalizedMessage());
      Log.e("weishi", paramIWeishiProtocolListener.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiProtocolService
 * JD-Core Version:    0.7.0.1
 */