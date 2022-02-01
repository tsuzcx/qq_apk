package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class MemoriesProfilePresenter
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  public QQUserUIItem a;
  private MemoriesProfilePresenter.GetCollectListEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetCollectListEventReceiver;
  private MemoriesProfilePresenter.GetShareGroupListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetShareGroupListReceiver;
  private MemoriesProfilePresenter.GetYearNodeListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetYearNodeListReceiver;
  private MemoriesProfilePresenter.ProfilePresenterListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$ProfilePresenterListener;
  private MemoriesProfilePresenter.UpdateUserInfoEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$UpdateUserInfoEventReceiver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MemoriesProfilePresenter.1(this);
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int b = -1;
  
  public MemoriesProfilePresenter(String paramString, @NonNull MemoriesProfilePresenter.ProfilePresenterListener paramProfilePresenterListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = null;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$ProfilePresenterListener = paramProfilePresenterListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$UpdateUserInfoEventReceiver = new MemoriesProfilePresenter.UpdateUserInfoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$UpdateUserInfoEventReceiver);
    PlayModeUtils.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetCollectListEventReceiver = new MemoriesProfilePresenter.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetCollectListEventReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetShareGroupListReceiver = new MemoriesProfilePresenter.GetShareGroupListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetShareGroupListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetYearNodeListReceiver = new MemoriesProfilePresenter.GetYearNodeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetYearNodeListReceiver);
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.jdField_a_of_type_JavaLangString);
      SLog.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      return;
    }
    SLog.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.jdField_a_of_type_JavaLangString);
    new GetUserInfoHandler().a(1, new QQUserUIItem.UserID("", this.jdField_a_of_type_JavaLangString), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$UpdateUserInfoEventReceiver);
    PlayModeUtils.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetCollectListEventReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetShareGroupListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter$GetYearNodeListReceiver);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter
 * JD-Core Version:    0.7.0.1
 */