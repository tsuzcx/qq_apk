package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesVideoCollectionPresenter$GetSimpleInfoListEventReceiver
  extends QQUIEventReceiver<MemoriesVideoCollectionPresenter, VidToSimpleInfoHandler.GetSimpleInfoListEvent>
{
  public MemoriesVideoCollectionPresenter$GetSimpleInfoListEventReceiver(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter)
  {
    super(paramMemoriesVideoCollectionPresenter);
  }
  
  public void a(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramGetSimpleInfoListEvent.toString());
    if (paramGetSimpleInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      MemoriesVideoCollectionPresenter.a(paramMemoriesVideoCollectionPresenter).a(paramGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString, paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.GetSimpleInfoListEventReceiver
 * JD-Core Version:    0.7.0.1
 */