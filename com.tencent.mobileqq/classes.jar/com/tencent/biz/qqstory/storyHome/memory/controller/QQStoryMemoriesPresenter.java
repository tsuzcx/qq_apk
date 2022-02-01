package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQStoryMemoriesPresenter
  implements IEventReceiver
{
  public int a;
  protected QQStoryObserver a;
  public QQUserUIItem a;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  private QQStoryMemoriesPresenter.DeleteShareGroupMemberEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver;
  private QQStoryMemoriesPresenter.UpdateUserInfoEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$UpdateUserInfoEventReceiver;
  public String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public QQStoryMemoriesPresenter(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new QQStoryMemoriesPresenter.1(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = paramStoryMemoriesFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.jdField_a_of_type_JavaLangString);
    PlayModeUtils.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver = new QQStoryMemoriesPresenter.DeleteShareGroupMemberEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$UpdateUserInfoEventReceiver = new QQStoryMemoriesPresenter.UpdateUserInfoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$UpdateUserInfoEventReceiver);
  }
  
  public void b()
  {
    PlayModeUtils.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter$UpdateUserInfoEventReceiver);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter
 * JD-Core Version:    0.7.0.1
 */