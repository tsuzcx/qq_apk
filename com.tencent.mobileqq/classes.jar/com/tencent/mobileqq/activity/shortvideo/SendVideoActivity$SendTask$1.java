package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import avau;
import awdq;
import aweg;
import awey;
import awfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import xsm;

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
      localObject2 = aweg.a(0, i);
      localObject1 = aweg.a(this.this$0.jdField_a_of_type_AndroidContentIntent, (awey)localObject2);
      ((awey)localObject2).a((awfo)localObject1);
      if (j != 9501) {
        break label214;
      }
      localObject2 = new xsm(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((xsm)localObject2).a(((xsm)localObject2).a((awfo)localObject1));
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
      localObject2 = new awdq(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      localObject1 = ((awdq)localObject2).a((awfo)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
        ((avau)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(326)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((awdq)localObject2).a((MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendTask.1
 * JD-Core Version:    0.7.0.1
 */