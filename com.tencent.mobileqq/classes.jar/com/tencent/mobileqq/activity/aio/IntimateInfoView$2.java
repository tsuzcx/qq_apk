package com.tencent.mobileqq.activity.aio;

import afsv;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import arau;
import arav;
import auzd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoView$2
  implements Runnable
{
  public IntimateInfoView$2(afsv paramafsv) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      auzd localauzd = (auzd)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
      IntimateInfo localIntimateInfo = localauzd.a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        afsv.a(this.this$0, localIntimateInfo);
        Message localMessage = afsv.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        afsv.a(this.this$0).sendMessage(localMessage);
      }
      localauzd.a(arav.a().Q, arav.a().R);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.2
 * JD-Core Version:    0.7.0.1
 */