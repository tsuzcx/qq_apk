package com.tencent.mobileqq.activity.aio;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

class IntimateInfoView$1
  implements Runnable
{
  IntimateInfoView$1(IntimateInfoView paramIntimateInfoView, FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.getQZonePluginClassLoader(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      QZoneApiProxy.initServlet(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QZoneApiProxy.initEnv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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