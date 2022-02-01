package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesProfilePresenter$GetShareGroupListReceiver
  extends QQUIEventReceiver<MemoriesProfilePresenter, ShareGroupPageLoader.GetShareGroupListEvent>
{
  public MemoriesProfilePresenter$GetShareGroupListReceiver(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull ShareGroupPageLoader.GetShareGroupListEvent paramGetShareGroupListEvent)
  {
    if (paramGetShareGroupListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramGetShareGroupListEvent.jdField_a_of_type_Int));
      MemoriesProfilePresenter.b(paramMemoriesProfilePresenter, paramGetShareGroupListEvent.jdField_a_of_type_Int);
      if (paramMemoriesProfilePresenter.a != null)
      {
        paramMemoriesProfilePresenter.a.shareGroupCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramMemoriesProfilePresenter), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupPageLoader.GetShareGroupListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver
 * JD-Core Version:    0.7.0.1
 */