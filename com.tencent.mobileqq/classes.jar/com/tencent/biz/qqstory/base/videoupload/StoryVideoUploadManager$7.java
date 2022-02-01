package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StoryVideoUploadManager$7
  extends SimpleJob<Object>
{
  StoryVideoUploadManager$7(StoryVideoUploadManager paramStoryVideoUploadManager, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramVarArgs = ((StoryManager)SuperManager.a(5)).a();
    paramJobContext = new ArrayList(paramVarArgs.size());
    paramVarArgs = paramVarArgs.iterator();
    while (paramVarArgs.hasNext()) {
      paramJobContext.add(new StoryVideoTaskInfo((StoryVideoItem)paramVarArgs.next()));
    }
    this.a.a(paramJobContext);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("had load local task size ");
    paramVarArgs.append(paramJobContext.size());
    SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", paramVarArgs.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.7
 * JD-Core Version:    0.7.0.1
 */