package com.tencent.mobileqq.activity.aio.intimate;

import aglx;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import auzd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class StrangerIntimateView$1
  implements Runnable
{
  public StrangerIntimateView$1(aglx paramaglx) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      IntimateInfo localIntimateInfo = ((auzd)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        aglx.a(this.this$0, localIntimateInfo);
        Message localMessage = aglx.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        aglx.a(this.this$0).sendMessage(localMessage);
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.1
 * JD-Core Version:    0.7.0.1
 */