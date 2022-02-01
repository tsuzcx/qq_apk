package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class SimpleDataProvider$StoryVideoDeleteReceiver
  extends Subscriber.SingleEventSubscriberNoRefect<DeleteStoryVideoEvent>
{
  SimpleDataProvider a;
  
  public SimpleDataProvider$StoryVideoDeleteReceiver(@NonNull SimpleDataProvider paramSimpleDataProvider)
  {
    this.a = paramSimpleDataProvider;
  }
  
  protected void a(@NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.StoryVideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */