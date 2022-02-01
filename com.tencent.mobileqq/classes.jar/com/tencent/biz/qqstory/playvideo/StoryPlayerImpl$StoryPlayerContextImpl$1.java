package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.Set;

class StoryPlayerImpl$StoryPlayerContextImpl$1
  extends QQStoryObserver
{
  StoryPlayerImpl$StoryPlayerContextImpl$1(StoryPlayerImpl.StoryPlayerContextImpl paramStoryPlayerContextImpl) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = StoryPlayerImpl.StoryPlayerContextImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((QQStoryObserver)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.StoryPlayerContextImpl.1
 * JD-Core Version:    0.7.0.1
 */