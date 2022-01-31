package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

public class OneFeedNodeInfoPullHandler$RequestFeedObserver
  extends SimpleObserver
{
  public void a(HomeFeedData paramHomeFeedData)
  {
    super.onNext(paramHomeFeedData);
    SLog.b("Q.qqstory.home.data:OneFeedNodeInfoPullHandler", "refresh data finish %s", paramHomeFeedData);
    if (paramHomeFeedData.b.size() == 0)
    {
      SLog.d("Q.qqstory.home.data:OneFeedNodeInfoPullHandler", "error size");
      return;
    }
    OneFeedNodeInfoPullHandler.SingleFeedInfoEvent localSingleFeedInfoEvent = new OneFeedNodeInfoPullHandler.SingleFeedInfoEvent();
    localSingleFeedInfoEvent.a = ((StoryHomeFeed)paramHomeFeedData.b.get(0));
    Dispatchers.get().dispatch(localSingleFeedInfoEvent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.home.data:OneFeedNodeInfoPullHandler", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    paramError = (ErrorMessage)paramError;
    OneFeedNodeInfoPullHandler.SingleFeedInfoEvent localSingleFeedInfoEvent = new OneFeedNodeInfoPullHandler.SingleFeedInfoEvent();
    localSingleFeedInfoEvent.errorInfo = paramError;
    Dispatchers.get().dispatch(localSingleFeedInfoEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.OneFeedNodeInfoPullHandler.RequestFeedObserver
 * JD-Core Version:    0.7.0.1
 */