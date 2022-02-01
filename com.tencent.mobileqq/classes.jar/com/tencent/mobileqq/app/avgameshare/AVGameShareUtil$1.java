package com.tencent.mobileqq.app.avgameshare;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameShareUtil$1
  implements AVGameShareUtil.AVGameShareProxy
{
  AVGameShareUtil$1(AVGameShareUtil paramAVGameShareUtil, BaseActivity paramBaseActivity, long paramLong1, long paramLong2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("AVGameShareUtil", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      new AVGameShareEntry(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_a_of_type_Long), paramString, this.b, this.jdField_a_of_type_JavaLangString, 0).c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131690599, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.1
 * JD-Core Version:    0.7.0.1
 */