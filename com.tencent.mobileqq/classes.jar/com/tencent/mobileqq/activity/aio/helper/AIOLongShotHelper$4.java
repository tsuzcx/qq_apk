package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqfav.QfavBuilder;
import mqq.app.AppRuntime;

final class AIOLongShotHelper$4
  implements Runnable
{
  AIOLongShotHelper$4(String paramString, Activity paramActivity) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QfavBuilder.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, localBaseApplicationImpl.getRuntime().getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.4
 * JD-Core Version:    0.7.0.1
 */