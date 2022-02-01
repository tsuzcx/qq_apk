package com.tencent.comic;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

final class VipComicJumpActivity$4
  implements Runnable
{
  VipComicJumpActivity$4(Activity paramActivity, VipComicJumpActivity.LoadingCondition paramLoadingCondition) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      VipComicJumpActivity.LoadingCondition localLoadingCondition = this.jdField_a_of_type_ComTencentComicVipComicJumpActivity$LoadingCondition;
      localLoadingCondition.a = new BoodoPluginLoadingDialog(this.jdField_a_of_type_AndroidAppActivity, localLoadingCondition);
      this.jdField_a_of_type_ComTencentComicVipComicJumpActivity$LoadingCondition.a.show();
      return;
    }
    QLog.e("VipComicJumpActivity", 1, "showHippyLoading activity is finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.4
 * JD-Core Version:    0.7.0.1
 */