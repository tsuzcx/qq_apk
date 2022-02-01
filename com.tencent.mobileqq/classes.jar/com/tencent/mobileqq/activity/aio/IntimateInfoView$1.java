package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

class IntimateInfoView$1
  implements Runnable
{
  IntimateInfoView$1(IntimateInfoView paramIntimateInfoView, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.getQZonePluginClassLoader(this.a);
      QZoneApiProxy.initServlet(this.a, this.b);
      QZoneApiProxy.initEnv(this.a, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.1
 * JD-Core Version:    0.7.0.1
 */