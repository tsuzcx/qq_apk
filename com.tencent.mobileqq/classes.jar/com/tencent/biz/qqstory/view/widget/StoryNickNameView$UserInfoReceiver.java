package com.tencent.biz.qqstory.view.widget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

class StoryNickNameView$UserInfoReceiver
  extends QQUIEventReceiver<StoryNickNameView, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public StoryNickNameView$UserInfoReceiver(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.g != null) && (paramUpdateUserInfoEvent.g.isFail())) {
      return;
    }
    if ((paramUpdateUserInfoEvent.b != null) && (paramUpdateUserInfoEvent.b.size() != 0))
    {
      if (TextUtils.equals(paramUpdateUserInfoEvent.d, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramUpdateUserInfoEvent.b.get(0));
      }
      if (!TextUtils.equals(paramUpdateUserInfoEvent.c, paramStoryNickNameView.getUnionId())) {
        return;
      }
      paramStoryNickNameView.a((QQUserUIItem)paramUpdateUserInfoEvent.b.get(0));
      return;
    }
    SLog.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryNickNameView.UserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */