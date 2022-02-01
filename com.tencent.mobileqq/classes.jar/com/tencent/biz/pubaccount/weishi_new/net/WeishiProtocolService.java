package com.tencent.biz.pubaccount.weishi_new.net;

import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

@Deprecated
public class WeishiProtocolService
{
  private static WeishiProtocolService jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static WeishiProtocolService a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService == null) {
        jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService = new WeishiProtocolService();
      }
      return jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService;
    }
  }
  
  public int a(WeishiRequest paramWeishiRequest, IWeishiProtocolListener paramIWeishiProtocolListener)
  {
    if (paramWeishiRequest == null) {}
    for (;;)
    {
      return 1000004;
      paramWeishiRequest.a(paramIWeishiProtocolListener);
      paramWeishiRequest.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), WeishiServlet.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((WeishiTask)paramIWeishiProtocolListener);
        localWeishiIntent.putExtra("timeout", paramWeishiRequest.f);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramIWeishiProtocolListener = BaseApplicationImpl.getApplication().getRuntime();
          if (paramIWeishiProtocolListener != null)
          {
            paramIWeishiProtocolListener.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramWeishiRequest.uniKey() + ", pkgId=" + paramWeishiRequest.a() + " submit to MSF, isLogin: " + paramIWeishiProtocolListener.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramWeishiRequest)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramWeishiRequest.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiProtocolService
 * JD-Core Version:    0.7.0.1
 */