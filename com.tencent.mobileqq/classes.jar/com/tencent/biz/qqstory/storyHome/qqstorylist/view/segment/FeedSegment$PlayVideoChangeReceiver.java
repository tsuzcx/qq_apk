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
    SLog.a(this.TAG, "play video groupId=%s, %s", paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, paramPlayVideoChangeEvent.b);
    if ((FeedSegment.a(paramFeedSegment).equals(paramPlayVideoChangeEvent.jdField_a_of_type_JavaLangString)) && ((paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId)))
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a;
      if (localFeedIdListSeqInfo != null) {
        paramFeedSegment.a(localFeedIdListSeqInfo.jdField_a_of_type_JavaLangString, paramPlayVideoChangeEvent.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */