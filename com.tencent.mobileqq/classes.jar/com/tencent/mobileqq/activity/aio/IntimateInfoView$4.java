package com.tencent.mobileqq.activity.aio;

import agiq;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import areb;
import arec;
import avgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoView$4
  implements Runnable
{
  public IntimateInfoView$4(agiq paramagiq) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      avgx localavgx = (avgx)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      IntimateInfo localIntimateInfo = localavgx.a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        agiq.a(this.this$0, localIntimateInfo);
        Message localMessage = agiq.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        agiq.a(this.this$0).sendMessage(localMessage);
      }
      localavgx.a(arec.a().H, arec.a().I);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.4
 * JD-Core Version:    0.7.0.1
 */