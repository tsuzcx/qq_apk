package com.tencent.mobileqq.activity.shortvideo;

import abvw;
import android.content.Intent;
import bbnr;
import bcwe;
import bcwu;
import bcxn;
import bcyf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
      localObject2 = bcwu.a(0, i);
      localObject1 = bcwu.a(this.this$0.jdField_a_of_type_AndroidContentIntent, (bcxn)localObject2);
      ((bcxn)localObject2).a((bcyf)localObject1);
      if (j != 9501) {
        break label214;
      }
      localObject2 = new abvw(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((abvw)localObject2).a(((abvw)localObject2).a((bcyf)localObject1));
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
      localObject2 = new bcwe(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      localObject1 = ((bcwe)localObject2).a((bcyf)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
        ((bbnr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(326)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((bcwe)localObject2).a((MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendTask.1
 * JD-Core Version:    0.7.0.1
 */