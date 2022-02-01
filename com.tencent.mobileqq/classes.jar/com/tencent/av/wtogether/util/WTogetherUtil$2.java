package com.tencent.av.wtogether.util;

import android.app.Activity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.qphone.base.util.QLog;

final class WTogetherUtil$2
  implements Runnable
{
  WTogetherUtil$2(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = NewReportPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, null, null, this.b, this.c, this.d, this.jdField_a_of_type_Int, NewReportPlugin.a(this.jdField_a_of_type_Int), "avreport", "", "", "", "", "", "", "", null);
      if (QLog.isColorLevel()) {
        QLog.d("WTogether", 1, "safetyNewReport postData=" + str);
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WTogetherUtil.2.1(this, str));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WTogetherUtil.2.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTogetherUtil.2
 * JD-Core Version:    0.7.0.1
 */