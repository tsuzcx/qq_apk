package com.tencent.mobileqq.activity.aio.intimate;

import afco;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import asdz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class StrangerIntimateView$1
  implements Runnable
{
  public StrangerIntimateView$1(afco paramafco) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      IntimateInfo localIntimateInfo = ((asdz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323)).a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        afco.a(this.this$0, localIntimateInfo);
        Message localMessage = afco.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        afco.a(this.this$0).sendMessage(localMessage);
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.1
 * JD-Core Version:    0.7.0.1
 */