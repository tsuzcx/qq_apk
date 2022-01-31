package com.tencent.mobileqq.activity.aio;

import aclw;
import amcj;
import amck;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import apqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoView$2
  implements Runnable
{
  public IntimateInfoView$2(aclw paramaclw) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      apqs localapqs = (apqs)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      IntimateInfo localIntimateInfo = localapqs.a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        aclw.a(this.this$0, localIntimateInfo);
        Message localMessage = aclw.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        aclw.a(this.this$0).sendMessage(localMessage);
      }
      localapqs.a(amck.a().H, amck.a().I);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.2
 * JD-Core Version:    0.7.0.1
 */