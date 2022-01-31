package com.tencent.biz.qqstory.storyHome.discover.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.GetFeedFeatureEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class DiscoverPresenter$GetFeedFeatureReceiver
  extends QQUIEventReceiver
{
  public DiscoverPresenter$GetFeedFeatureReceiver(@NonNull DiscoverPresenter paramDiscoverPresenter)
  {
    super(paramDiscoverPresenter);
  }
  
  public void a(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull GetFeedFeatureHandler.GetFeedFeatureEvent paramGetFeedFeatureEvent)
  {
    if ((paramGetFeedFeatureEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList != null))
    {
      paramGetFeedFeatureEvent = paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (paramGetFeedFeatureEvent.hasNext())
      {
        FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)paramGetFeedFeatureEvent.next();
        DiscoverPresenter.a(paramDiscoverPresenter, localFeedFeatureItem.jdField_a_of_type_JavaLangString, localFeedFeatureItem.c, localFeedFeatureItem.jdField_a_of_type_Int);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetFeedFeatureHandler.GetFeedFeatureEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter.GetFeedFeatureReceiver
 * JD-Core Version:    0.7.0.1
 */