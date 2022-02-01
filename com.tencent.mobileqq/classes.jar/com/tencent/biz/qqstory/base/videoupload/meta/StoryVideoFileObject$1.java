package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class StoryVideoFileObject$1
  implements UpCallBack
{
  StoryVideoFileObject$1(StoryVideoFileObject paramStoryVideoFileObject) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.b == 0)
    {
      this.a.c.d = paramSendResult.d;
      this.a.c.b = paramSendResult.f;
      this.a.b();
      StoryVideoFileObject.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramSendResult.b == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.g.getAndIncrement() < 2))
    {
      StoryVideoFileObject.a(this.a);
      SLog.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramSendResult = new ErrorMessage(paramSendResult.b, paramSendResult.c);
    paramSendResult.extraMsg = "upload";
    StoryVideoFileObject.a(this.a, paramSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject.1
 * JD-Core Version:    0.7.0.1
 */