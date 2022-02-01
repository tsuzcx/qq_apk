package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesProfilePresenter$GetCollectListEventReceiver
  extends QQUIEventReceiver<MemoriesProfilePresenter, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public MemoriesProfilePresenter$GetCollectListEventReceiver(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramGetCollectionListEvent.jdField_a_of_type_Int));
      if ((!TextUtils.isEmpty(paramGetCollectionListEvent.b)) && (!paramGetCollectionListEvent.b.equals(paramMemoriesProfilePresenter.jdField_a_of_type_JavaLangString))) {
        return;
      }
      if (paramGetCollectionListEvent.jdField_a_of_type_Int != -1) {
        MemoriesProfilePresenter.a(paramMemoriesProfilePresenter, paramGetCollectionListEvent.jdField_a_of_type_Int);
      }
      if (paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
      {
        paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = MemoriesProfilePresenter.a(paramMemoriesProfilePresenter);
        ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramMemoriesProfilePresenter), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */