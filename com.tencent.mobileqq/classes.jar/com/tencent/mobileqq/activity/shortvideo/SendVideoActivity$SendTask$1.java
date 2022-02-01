package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
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
      localObject2 = ShortVideoBusiManager.a(0, i);
      localObject1 = ShortVideoBusiManager.a(this.this$0.jdField_a_of_type_AndroidContentIntent, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (j != 9501) {
        break label214;
      }
      localObject2 = new DevLittleVideoOperator(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((DevLittleVideoOperator)localObject2).a(((DevLittleVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1));
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
      localObject2 = new AioShortVideoOperator(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      localObject1 = ((AioShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
        ((OrderMediaMsgManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((AioShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendTask.1
 * JD-Core Version:    0.7.0.1
 */