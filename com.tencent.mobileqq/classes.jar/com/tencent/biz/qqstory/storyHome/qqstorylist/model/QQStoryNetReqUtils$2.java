package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.ErrorCallBack;
import java.lang.ref.WeakReference;

final class QQStoryNetReqUtils$2
  implements Step.ErrorCallBack
{
  public void a(ErrorMessage paramErrorMessage)
  {
    QQStoryNetReqUtils.RequestCallBack localRequestCallBack = (QQStoryNetReqUtils.RequestCallBack)this.a.get();
    if (localRequestCallBack != null) {
      localRequestCallBack.a(paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.2
 * JD-Core Version:    0.7.0.1
 */