package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import java.lang.ref.WeakReference;

final class QQStoryNetReqUtils$1
  implements Step.FinishCallBack
{
  public void a(String paramString)
  {
    paramString = (QQStoryNetReqUtils.RequestCallBack)this.a.get();
    if (paramString != null) {
      paramString.a(Integer.valueOf(((Integer)((StoryConfigManager)SuperManager.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.1
 * JD-Core Version:    0.7.0.1
 */