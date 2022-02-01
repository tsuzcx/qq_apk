package com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

class EditVideoDoodle$DoodleEmojiListEventReceiver
  extends QQUIEventReceiver<EditVideoDoodle, DoodleEmojiManager.DoodleEmojiUpdateEvent>
{
  public EditVideoDoodle$DoodleEmojiListEventReceiver(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent)
  {
    EditVideoDoodle.DoodleFacePanelAdapter localDoodleFacePanelAdapter = paramEditVideoDoodle.a;
    if (localDoodleFacePanelAdapter != null) {
      localDoodleFacePanelAdapter.a(paramEditVideoDoodle.a());
    }
    for (;;)
    {
      StoryReportor.b("edit_video", "face_list_success", 0, paramDoodleEmojiUpdateEvent.a.errorCode, new String[0]);
      return;
      SLog.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleEmojiListEventReceiver
 * JD-Core Version:    0.7.0.1
 */