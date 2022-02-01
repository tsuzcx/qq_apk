package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader.MemoriesFeedGroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MemoriesVideoListSegment$PlayVideoChangeReceiver
  extends QQUIEventReceiver<MemoriesVideoListSegment, PlayVideoChangeEvent>
{
  public MemoriesVideoListSegment$PlayVideoChangeReceiver(@NonNull MemoriesVideoListSegment paramMemoriesVideoListSegment)
  {
    super(paramMemoriesVideoListSegment);
  }
  
  public void a(@NonNull MemoriesVideoListSegment paramMemoriesVideoListSegment, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramPlayVideoChangeEvent.b, paramPlayVideoChangeEvent.c);
    if ((MemoriesVideoListSegment.b(paramMemoriesVideoListSegment).equals(paramPlayVideoChangeEvent.a)) && ((paramPlayVideoChangeEvent.b instanceof MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)))
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = ((MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)paramPlayVideoChangeEvent.b).a;
      if (localFeedIdListSeqInfo != null) {
        paramMemoriesVideoListSegment.a(localFeedIdListSeqInfo.a, paramPlayVideoChangeEvent.c, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */