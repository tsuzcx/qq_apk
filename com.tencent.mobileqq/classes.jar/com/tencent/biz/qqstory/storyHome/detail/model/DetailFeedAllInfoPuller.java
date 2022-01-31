package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import mqq.os.MqqHandler;
import nuq;
import nur;

public class DetailFeedAllInfoPuller
{
  private DetailFeedAllInfoPuller.OnFeedItemPullListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$OnFeedItemPullListener;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = new DetailFeedItem();
  private Stream jdField_a_of_type_ComTribeAsyncReactiveStream;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private boolean b = true;
  
  public DetailFeedAllInfoPuller(@NonNull String paramString, @NonNull DetailFeedAllInfoPuller.OnFeedItemPullListener paramOnFeedItemPullListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$OnFeedItemPullListener = paramOnFeedItemPullListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new nur(this, paramDetailFeedItem, paramBoolean, paramErrorMessage));
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new nuq(this), 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction(2)).map(new DetailFeedAllInfoPuller.FeedItemPullSegment(this, this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new DetailFeedAllInfoPullSegment());
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new DetailFeedAllInfoPuller.RequestFeedObserver(this));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller
 * JD-Core Version:    0.7.0.1
 */