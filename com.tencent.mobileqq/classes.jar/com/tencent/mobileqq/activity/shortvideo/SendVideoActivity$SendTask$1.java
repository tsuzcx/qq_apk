package com.tencent.mobileqq.activity.shortvideo;

import abhr;
import android.content.Intent;
import bbob;
import bcwi;
import bcwz;
import bcxr;
import bcyj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class SendVideoActivity$SendTask$1
  implements Runnable
{
  SendVideoActivity$SendTask$1(SendVideoActivity.SendTask paramSendTask) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject1;
    if (this.this$0.jdField_a_of_type_AndroidContentIntent != null)
    {
      int i = this.this$0.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_business_type", 2);
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(), busiType = " + i + ",VideoFileDir = " + this.this$0.jdField_a_of_type_AndroidContentIntent.getStringExtra("file_video_source_dir"));
      }
      int j = this.this$0.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
      if (j == 9501) {
        i = 4;
      }
      localObject2 = bcwz.a(0, i);
      localObject1 = bcwz.a(this.this$0.jdField_a_of_type_AndroidContentIntent, (bcxr)localObject2);
      ((bcxr)localObject2).a((bcyj)localObject1);
      if (j != 9501) {
        break label214;
      }
      localObject2 = new abhr(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((abhr)localObject2).a(((abhr)localObject2).a((bcyj)localObject1));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
      }
      if (!this.this$0.jdField_a_of_type_Boolean)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, this.this$0.jdField_a_of_type_AndroidContentIntent);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      }
      return;
      label214:
      localObject2 = new bcwi(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      localObject1 = ((bcwi)localObject2).a((bcyj)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
        ((bbob)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((bcwi)localObject2).a((MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendTask.1
 * JD-Core Version:    0.7.0.1
 */