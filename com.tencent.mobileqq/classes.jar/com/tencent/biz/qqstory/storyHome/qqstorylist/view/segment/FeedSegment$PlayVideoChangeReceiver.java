package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader.FeedBaseGroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedSegment$PlayVideoChangeReceiver
  extends QQUIEventReceiver<FeedSegment, PlayVideoChangeEvent>
{
  public FeedSegment$PlayVideoChangeReceiver(@NonNull FeedSegment paramFeedSegment)
  {
    super(paramFeedSegment);
  }
  
  public void a(@NonNull FeedSegment paramFeedSegment, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    SLog.a(this.TAG, "play video groupId=%s, %s", paramPlayVideoChangeEvent.b, paramPlayVideoChangeEvent.c);
    if ((FeedSegment.r(paramFeedSegment).equals(paramPlayVideoChangeEvent.a)) && ((paramPlayVideoChangeEvent.b instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId)))
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)paramPlayVideoChangeEvent.b).a;
      if (localFeedIdListSeqInfo != null) {
        paramFeedSegment.a(localFeedIdListSeqInfo.a, paramPlayVideoChangeEvent.c, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */