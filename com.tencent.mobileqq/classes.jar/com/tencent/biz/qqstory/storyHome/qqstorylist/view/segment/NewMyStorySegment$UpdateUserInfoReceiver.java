package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewMyStorySegment$UpdateUserInfoReceiver
  extends QQUIEventReceiver<NewMyStorySegment, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public NewMyStorySegment$UpdateUserInfoReceiver(@NonNull NewMyStorySegment paramNewMyStorySegment)
  {
    super(paramNewMyStorySegment);
  }
  
  public void a(@NonNull NewMyStorySegment paramNewMyStorySegment, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent != null) && (paramUpdateUserInfoEvent.a != null) && (!TextUtils.isEmpty(paramUpdateUserInfoEvent.a.headUrl)))
    {
      if (paramUpdateUserInfoEvent.a.isMe()) {
        NewMyStorySegment.h(paramNewMyStorySegment);
      }
      return;
    }
    SLog.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.UpdateUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */