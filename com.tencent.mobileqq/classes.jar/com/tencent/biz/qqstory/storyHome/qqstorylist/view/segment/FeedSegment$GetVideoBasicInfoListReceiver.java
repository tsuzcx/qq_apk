package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedSegment$GetVideoBasicInfoListReceiver
  extends QQUIEventReceiver<FeedSegment, VidToBasicInfoHandler.GetVideoBasicInfoListEvent>
{
  public FeedSegment$GetVideoBasicInfoListReceiver(@NonNull FeedSegment paramFeedSegment)
  {
    super(paramFeedSegment);
  }
  
  public void a(@NonNull FeedSegment paramFeedSegment, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if (!paramGetVideoBasicInfoListEvent.g.isFail())
    {
      if (paramGetVideoBasicInfoListEvent.a == null) {
        return;
      }
      paramFeedSegment.a(paramGetVideoBasicInfoListEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.GetVideoBasicInfoListReceiver
 * JD-Core Version:    0.7.0.1
 */