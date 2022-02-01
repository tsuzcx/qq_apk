package com.tencent.avgame.util;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

final class AVGameUtils$1
  implements Runnable
{
  AVGameUtils$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690357);
    QLog.d("AVGameUtils", 2, "showDialogTip content:" + this.jdField_a_of_type_JavaLangString);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_JavaLangString, str, str, new AVGameUtils.1.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameUtils.1
 * JD-Core Version:    0.7.0.1
 */