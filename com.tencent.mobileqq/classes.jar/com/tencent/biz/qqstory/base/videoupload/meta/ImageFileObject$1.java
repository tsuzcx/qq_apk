package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class ImageFileObject$1
  implements UpCallBack
{
  ImageFileObject$1(ImageFileObject paramImageFileObject) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramSendResult.jdField_b_of_type_JavaLangString;
      this.a.b();
      ImageFileObject.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramSendResult.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      ImageFileObject.a(this.a);
      SLog.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramSendResult = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.a);
    paramSendResult.extraMsg = "upload";
    ImageFileObject.a(this.a, paramSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject.1
 * JD-Core Version:    0.7.0.1
 */