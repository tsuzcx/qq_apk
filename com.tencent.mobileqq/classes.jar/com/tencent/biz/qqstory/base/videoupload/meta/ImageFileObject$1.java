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
    if (paramSendResult.b == 0)
    {
      this.a.b = paramSendResult.d;
      this.a.b();
      ImageFileObject.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramSendResult.b == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.g.getAndIncrement() < 2))
    {
      ImageFileObject.a(this.a);
      SLog.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramSendResult = new ErrorMessage(paramSendResult.b, paramSendResult.c);
    paramSendResult.extraMsg = "upload";
    ImageFileObject.a(this.a, paramSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject.1
 * JD-Core Version:    0.7.0.1
 */