package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.RequestCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;

class QQStoryTakeVideoHelper$3
  implements QQStoryNetReqUtils.RequestCallBack<Integer>
{
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("QQStoryTakeVideoHelper", "get vip error.");
  }
  
  public void a(Integer paramInteger)
  {
    SLog.b("QQStoryTakeVideoHelper", "get vip competed, vip:" + paramInteger);
    this.a.b("qqstory_i_am_vip", paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.3
 * JD-Core Version:    0.7.0.1
 */