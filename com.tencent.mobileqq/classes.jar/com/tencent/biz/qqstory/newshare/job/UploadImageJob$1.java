package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class UploadImageJob$1
  implements UpCallBack
{
  UploadImageJob$1(UploadImageJob paramUploadImageJob) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult.b == 0) && (!TextUtils.isEmpty(paramSendResult.d)))
    {
      this.a.a("UploadImageJob_out_image_url", paramSendResult.d);
      UploadImageJob.a(this.a, true);
      return;
    }
    paramSendResult = new ErrorMessage(paramSendResult.b, paramSendResult.c);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.e, 2, paramSendResult, new Object[0]);
    }
    UploadImageJob.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UploadImageJob.1
 * JD-Core Version:    0.7.0.1
 */