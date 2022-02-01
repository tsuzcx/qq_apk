package com.tencent.mobileqq.app.avgameshare;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameShareUtil$1
  implements AVGameShareUtil.AVGameShareProxy
{
  AVGameShareUtil$1(AVGameShareUtil paramAVGameShareUtil, QBaseActivity paramQBaseActivity, long paramLong1, long paramLong2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareLinkCallback isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" shareUrl: ");
    localStringBuilder.append(paramString);
    QLog.d("AVGameShareUtil", 1, localStringBuilder.toString());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      new AVGameShareEntry(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(this.jdField_a_of_type_Long), paramString, this.b, this.jdField_a_of_type_JavaLangString, 0).b();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131690527, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.1
 * JD-Core Version:    0.7.0.1
 */