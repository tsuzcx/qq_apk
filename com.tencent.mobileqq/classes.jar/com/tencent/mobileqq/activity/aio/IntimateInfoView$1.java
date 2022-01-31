package com.tencent.mobileqq.activity.aio;

import acwl;
import android.support.v4.app.FragmentActivity;
import bhby;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class IntimateInfoView$1
  implements Runnable
{
  public IntimateInfoView$1(acwl paramacwl, FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      bhby.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bhby.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.1
 * JD-Core Version:    0.7.0.1
 */