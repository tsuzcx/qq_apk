package com.tencent.mobileqq.app.avgameshare;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameShareUtil$2
  implements AVGameShareUtil.AVGameShareProxy
{
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("AVGameShareUtil", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      new AVGameShareH5Entry(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(this.jdField_a_of_type_Long), paramString, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "", "", "", "").c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131690599, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.2
 * JD-Core Version:    0.7.0.1
 */