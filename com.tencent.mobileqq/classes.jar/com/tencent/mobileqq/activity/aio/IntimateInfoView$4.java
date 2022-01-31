package com.tencent.mobileqq.activity.aio;

import aenv;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aojg;
import aojh;
import asdz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoView$4
  implements Runnable
{
  public IntimateInfoView$4(aenv paramaenv) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      asdz localasdz = (asdz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      IntimateInfo localIntimateInfo = localasdz.a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        aenv.a(this.this$0, localIntimateInfo);
        Message localMessage = aenv.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        aenv.a(this.this$0).sendMessage(localMessage);
      }
      localasdz.a(aojh.a().H, aojh.a().I);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.jdField_a_of_type_JavaLangString, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.4
 * JD-Core Version:    0.7.0.1
 */