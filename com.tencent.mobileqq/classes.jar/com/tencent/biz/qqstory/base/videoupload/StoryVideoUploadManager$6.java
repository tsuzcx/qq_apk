package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class StoryVideoUploadManager$6
  extends Job<Object, Object, Object>
{
  StoryVideoUploadManager$6(StoryVideoUploadManager paramStoryVideoUploadManager, String paramString1, String paramString2, StoryVideoItem paramStoryVideoItem)
  {
    super(paramString1);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    paramJobContext = new DeleteStoryVideoEvent(new ErrorMessage(), this.a, true);
    paramVarArgs = this.b;
    if (paramVarArgs != null)
    {
      paramJobContext.b = paramVarArgs.mOwnerUid;
      paramJobContext.c = this.b.shareGroupId;
      paramJobContext.e = this.b.mVideoIndex;
      if (paramJobContext.e == 0L) {
        paramJobContext.e = this.b.mCreateTime;
      }
    }
    StoryDispatcher.a().dispatch(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.6
 * JD-Core Version:    0.7.0.1
 */