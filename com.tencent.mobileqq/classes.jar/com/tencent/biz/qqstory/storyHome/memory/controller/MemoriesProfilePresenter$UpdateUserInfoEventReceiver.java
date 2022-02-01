package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesProfilePresenter$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver<MemoriesProfilePresenter, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public MemoriesProfilePresenter$UpdateUserInfoEventReceiver(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (TextUtils.equals(paramUpdateUserInfoEvent.jdField_a_of_type_JavaLangString, String.valueOf(paramMemoriesProfilePresenter.hashCode())))
    {
      if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramUpdateUserInfoEvent);
        paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramMemoriesProfilePresenter.jdField_a_of_type_JavaLangString = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (MemoriesProfilePresenter.a(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = MemoriesProfilePresenter.a(paramMemoriesProfilePresenter);
        }
        if (MemoriesProfilePresenter.b(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        }
        ((FriendListHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramMemoriesProfilePresenter), 5, null, false);
      }
      for (;;)
      {
        MemoriesProfilePresenter.a(paramMemoriesProfilePresenter).a(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131706541) + paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        SLog.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramUpdateUserInfoEvent });
      }
    }
    SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramUpdateUserInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */