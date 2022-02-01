package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader.MemoriesFeedGroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$PlayVideoChangeReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, PlayVideoChangeEvent>
{
  public QQStoryShareGroupProfileActivity$PlayVideoChangeReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramPlayVideoChangeEvent.jdField_a_of_type_JavaLangString)) && ((paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)))
    {
      paramPlayVideoChangeEvent = ((MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a;
      if (paramPlayVideoChangeEvent != null) {
        paramQQStoryShareGroupProfileActivity.a(paramPlayVideoChangeEvent.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */