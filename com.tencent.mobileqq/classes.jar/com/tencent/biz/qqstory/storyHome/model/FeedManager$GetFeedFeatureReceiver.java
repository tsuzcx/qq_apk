package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.GetFeedFeatureEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class FeedManager$GetFeedFeatureReceiver
  extends QQUIEventReceiver<FeedManager, GetFeedFeatureHandler.GetFeedFeatureEvent>
{
  public FeedManager$GetFeedFeatureReceiver(@NonNull FeedManager paramFeedManager)
  {
    super(paramFeedManager);
  }
  
  public void a(@NonNull FeedManager paramFeedManager, @NonNull GetFeedFeatureHandler.GetFeedFeatureEvent paramGetFeedFeatureEvent)
  {
    SLog.a(this.TAG, "receive feature event. %s.", paramGetFeedFeatureEvent.toString());
    if ((paramGetFeedFeatureEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList != null))
    {
      paramGetFeedFeatureEvent = paramGetFeedFeatureEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (paramGetFeedFeatureEvent.hasNext())
      {
        FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)paramGetFeedFeatureEvent.next();
        FeedManager.a(paramFeedManager).put(localFeedFeatureItem.a, localFeedFeatureItem);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetFeedFeatureHandler.GetFeedFeatureEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.GetFeedFeatureReceiver
 * JD-Core Version:    0.7.0.1
 */