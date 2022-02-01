package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameShareUtil$3
  implements AVGameShareUtil.AVGameShareProxy
{
  AVGameShareUtil$3(AVGameShareUtil paramAVGameShareUtil, Activity paramActivity, long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2) {}
  
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
      new AVGameShareResultLink(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(this.jdField_a_of_type_Long), paramString, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString).b();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131690527, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.3
 * JD-Core Version:    0.7.0.1
 */