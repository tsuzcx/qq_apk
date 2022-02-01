package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

final class StoryVideoUploadManager$3
  extends SimpleJob<Void>
{
  StoryVideoUploadManager$3(String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = StoryVideoUploadManager.a();
    paramJobContext = new StringBuilder();
    paramJobContext.append(this.a);
    paramJobContext.append(" : fireCreateStoryVideo count = %d");
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramJobContext.toString(), new Object[] { Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.3
 * JD-Core Version:    0.7.0.1
 */