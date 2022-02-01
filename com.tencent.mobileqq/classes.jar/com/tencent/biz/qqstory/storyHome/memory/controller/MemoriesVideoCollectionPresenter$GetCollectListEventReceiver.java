package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesVideoCollectionPresenter$GetCollectListEventReceiver
  extends QQUIEventReceiver<MemoriesVideoCollectionPresenter, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public MemoriesVideoCollectionPresenter$GetCollectListEventReceiver(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter)
  {
    super(paramMemoriesVideoCollectionPresenter);
  }
  
  public void a(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(String.valueOf(paramMemoriesVideoCollectionPresenter.hashCode()), paramGetCollectionListEvent.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramGetCollectionListEvent);
    if (paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramGetCollectionListEvent.jdField_a_of_type_Int != -1) {
        paramMemoriesVideoCollectionPresenter.jdField_a_of_type_Int = paramGetCollectionListEvent.jdField_a_of_type_Int;
      }
      paramMemoriesVideoCollectionPresenter.jdField_a_of_type_Boolean = true;
      paramMemoriesVideoCollectionPresenter.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramGetCollectionListEvent.e)
      {
        paramMemoriesVideoCollectionPresenter.a(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList, paramGetCollectionListEvent.c, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
        paramMemoriesVideoCollectionPresenter.b = paramGetCollectionListEvent.jdField_a_of_type_Boolean;
      }
    }
    else
    {
      paramMemoriesVideoCollectionPresenter.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
    MemoriesVideoCollectionPresenter.a(paramMemoriesVideoCollectionPresenter).a(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */