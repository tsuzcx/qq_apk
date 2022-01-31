package com.tencent.mobileqq.activity.aio;

import acwl;
import amsi;
import amsj;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aqkj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoView$2
  implements Runnable
{
  public IntimateInfoView$2(acwl paramacwl) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      aqkj localaqkj = (aqkj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      IntimateInfo localIntimateInfo = localaqkj.a(this.this$0.jdField_a_of_type_JavaLangString);
      if (localIntimateInfo != null)
      {
        acwl.a(this.this$0, localIntimateInfo);
        Message localMessage = acwl.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        acwl.a(this.this$0).sendMessage(localMessage);
      }
      localaqkj.a(amsj.a().H, amsj.a().I);
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