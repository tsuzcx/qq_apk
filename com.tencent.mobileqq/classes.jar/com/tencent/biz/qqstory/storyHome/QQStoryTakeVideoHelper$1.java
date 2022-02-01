package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.RequestCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;

class QQStoryTakeVideoHelper$1
  implements QQStoryNetReqUtils.RequestCallBack<Integer>
{
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("QQStoryTakeVideoHelper", "get vip error.");
  }
  
  public void a(Integer paramInteger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get vip competed, vip:");
    localStringBuilder.append(paramInteger);
    SLog.b("QQStoryTakeVideoHelper", localStringBuilder.toString());
    this.a.d("qqstory_i_am_vip", paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */