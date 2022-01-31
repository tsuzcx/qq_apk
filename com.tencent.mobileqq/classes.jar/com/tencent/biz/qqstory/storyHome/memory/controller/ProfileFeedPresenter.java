package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nvv;
import nvw;

public class ProfileFeedPresenter
  extends HomeFeedPresenter
{
  private static String jdField_a_of_type_JavaLangString = "feed_data_request";
  private static String jdField_b_of_type_JavaLangString = "year_node_data_request";
  private ProfileFeedPresenter.FeedPresenterListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$FeedPresenterListener;
  private ProfileFeedPresenter.GetYearNodeListEvent jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListEvent;
  private ProfileFeedPresenter.GetYearNodeListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListReceiver;
  private ProfileFeedPresenter.UploadStatusReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$UploadStatusReceiver;
  private ProfileFeedPresenter.VideoDeleteReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$VideoDeleteReceiver;
  private HomeFeedData jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData;
  public List a;
  public boolean a;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public ProfileFeedPresenter(int paramInt, @NonNull HomeFeedPresenter.HomeFeedPresenterListener paramHomeFeedPresenterListener, @NonNull ProfileFeedPresenter.FeedPresenterListener paramFeedPresenterListener, boolean paramBoolean)
  {
    super(paramInt, paramHomeFeedPresenterListener, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$FeedPresenterListener = paramFeedPresenterListener;
  }
  
  private void a(List paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void b(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    GetProfileYearNodeListRequest localGetProfileYearNodeListRequest = new GetProfileYearNodeListRequest();
    localGetProfileYearNodeListRequest.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    CmdTaskManger.a().a(localGetProfileYearNodeListRequest, new nvv(this, paramBoolean));
  }
  
  private void d()
  {
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      SLog.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$FeedPresenterListener.a(false);
      return;
    }
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListEvent.jdField_a_of_type_JavaUtilList, true);
    b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$VideoDeleteReceiver = new ProfileFeedPresenter.VideoDeleteReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$VideoDeleteReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$UploadStatusReceiver = new ProfileFeedPresenter.UploadStatusReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$UploadStatusReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListReceiver = new ProfileFeedPresenter.GetYearNodeListReceiver(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListReceiver);
  }
  
  public void a(HomeFeedData paramHomeFeedData)
  {
    if (!paramHomeFeedData.d) {}
    for (boolean bool = true;; bool = false)
    {
      SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new nvw(this, paramHomeFeedData));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((MemoryManager)SuperManager.a(19)).a(), true);
      if ((a().size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListEvent = null;
    super.a(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangString);
    b(false);
    this.jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    super.b();
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$VideoDeleteReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$UploadStatusReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter$GetYearNodeListReceiver);
  }
  
  public void b(HomeFeedData paramHomeFeedData)
  {
    super.a(paramHomeFeedData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter
 * JD-Core Version:    0.7.0.1
 */