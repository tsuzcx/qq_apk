package com.tencent.biz.qqstory.base.videoupload.task;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class BasePublishTask$UploadResult
  extends SimpleObserver<ErrorMessage>
{
  private BasePublishTask$UploadResult(BasePublishTask paramBasePublishTask) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      this.a.a(new ErrorMessage());
      return;
    }
    this.a.a(paramErrorMessage);
  }
  
  public void onCancel() {}
  
  public void onComplete() {}
  
  public void onError(@NonNull Error paramError)
  {
    if ((paramError instanceof ErrorMessage))
    {
      this.a.a((ErrorMessage)paramError);
      return;
    }
    BasePublishTask localBasePublishTask = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload file fail:");
    localStringBuilder.append(paramError);
    localBasePublishTask.a(new ErrorMessage(940005, localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask.UploadResult
 * JD-Core Version:    0.7.0.1
 */