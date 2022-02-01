package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import com.tencent.device.file.DevLittleVideoSendOperator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.qphone.base.util.QLog;

class SendTask$1
  implements Runnable
{
  SendTask$1(SendTask paramSendTask) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentIntent != null)
    {
      int i = this.this$0.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_business_type", 2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("#SendTask# run(), busiType = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",VideoFileDir = ");
        ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_AndroidContentIntent.getStringExtra("file_video_source_dir"));
        QLog.d("SendVideoActivity", 2, ((StringBuilder)localObject1).toString());
      }
      int j = this.this$0.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
      if (j == 9501) {
        i = 4;
      }
      Object localObject2 = SVBusiUtil.a(0, i);
      Object localObject1 = ShortVideoBusiManager.a(this.this$0.jdField_a_of_type_AndroidContentIntent, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (j == 9501)
      {
        localObject2 = new DevLittleVideoSendOperator(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        ((DevLittleVideoSendOperator)localObject2).a(((DevLittleVideoSendOperator)localObject2).a((ShortVideoUploadInfo)localObject1));
      }
      else
      {
        localObject2 = ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        localObject1 = ((IShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
          ((IOrderMediaMsgService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
        }
        ((IShortVideoOperator)localObject2).a((MessageRecord)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
      }
    }
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, this.this$0.jdField_a_of_type_AndroidContentIntent);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendTask.1
 * JD-Core Version:    0.7.0.1
 */