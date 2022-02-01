package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.ICallBack;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryPlayerImpl$1
  implements IDataProvider.ICallBack
{
  StoryPlayerImpl$1(StoryPlayerImpl paramStoryPlayerImpl) {}
  
  public void a()
  {
    StoryPlayerImpl.a(this.a);
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean)
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onGroupDataDelete, groupId=%s, vid=%s", new Object[] { paramGroupId.b, paramString });
    StoryPlayerImpl.b(this.a).a(paramGroupId, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */