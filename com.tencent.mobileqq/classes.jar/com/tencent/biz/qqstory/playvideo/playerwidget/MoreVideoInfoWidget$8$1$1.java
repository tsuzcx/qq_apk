package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class MoreVideoInfoWidget$8$1$1
  extends Job<Object, Object, Object>
{
  MoreVideoInfoWidget$8$1$1(MoreVideoInfoWidget.8.1 param1, String paramString, DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    StoryDispatcher.a().dispatch(this.jdField_a_of_type_ComTencentBizQqstoryModelDeleteStoryVideoEvent);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.8.1.1
 * JD-Core Version:    0.7.0.1
 */