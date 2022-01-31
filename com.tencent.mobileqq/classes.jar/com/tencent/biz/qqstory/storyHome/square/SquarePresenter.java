package com.tencent.biz.qqstory.storyHome.square;

import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.OnFeedItemPageLoadListener;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeedData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import ogp;

public class SquarePresenter
  implements FeedListPageLoaderBase.OnFeedItemPageLoadListener, IEventReceiver
{
  private SquarePresenter.ISquareView jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter$ISquareView;
  private List jdField_a_of_type_JavaUtilList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private List b;
  
  public void a(SquareFeedData paramSquareFeedData)
  {
    SLog.a("Q.qqstory.discover.SquarePresenter", "data return %s", paramSquareFeedData);
    ThreadManager.getUIHandler().post(new ogp(this, paramSquareFeedData));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.SquarePresenter
 * JD-Core Version:    0.7.0.1
 */