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
import com.tencent.qphone.base.util.BaseApplication;
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
    if (TextUtils.equals(paramUpdateUserInfoEvent.c, String.valueOf(paramMemoriesProfilePresenter.hashCode())))
    {
      if ((paramUpdateUserInfoEvent.g.isSuccess()) && (paramUpdateUserInfoEvent.a != null))
      {
        SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramUpdateUserInfoEvent);
        paramMemoriesProfilePresenter.b = paramUpdateUserInfoEvent.a;
        paramMemoriesProfilePresenter.a = paramUpdateUserInfoEvent.a.uid;
        if (MemoriesProfilePresenter.b(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.b.videoCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        }
        if (MemoriesProfilePresenter.c(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.b.shareGroupCount = MemoriesProfilePresenter.c(paramMemoriesProfilePresenter);
        }
        ((FriendListHandler)PlayModeUtils.b().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(paramUpdateUserInfoEvent.a.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramMemoriesProfilePresenter), 5, null, false);
      }
      else
      {
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131904421));
        localStringBuilder.append(paramUpdateUserInfoEvent.g.getErrorMessage());
        QQToast.makeText(localBaseApplication, 1, localStringBuilder.toString(), 0);
        SLog.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramUpdateUserInfoEvent });
      }
      MemoriesProfilePresenter.a(paramMemoriesProfilePresenter).a(paramUpdateUserInfoEvent.g.isSuccess());
      return;
    }
    SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramUpdateUserInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */