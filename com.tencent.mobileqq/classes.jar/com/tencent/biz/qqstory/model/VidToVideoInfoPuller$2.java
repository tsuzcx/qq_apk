package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class VidToVideoInfoPuller$2
  extends SimpleJob<Object>
{
  VidToVideoInfoPuller$2(VidToVideoInfoPuller paramVidToVideoInfoPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((StoryManager)SuperManager.a(5)).g(QQStoryContext.a().i());
    if (paramJobContext != null)
    {
      paramVarArgs = paramJobContext.iterator();
      while (paramVarArgs.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramVarArgs.next();
        if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
          paramVarArgs.remove();
        }
      }
    }
    Collections.sort(paramJobContext, new VidToVideoInfoPuller.2.1(this));
    paramVarArgs = new ArrayList();
    paramJobContext = paramJobContext.iterator();
    while (paramJobContext.hasNext()) {
      paramVarArgs.add(((StoryVideoItem)paramJobContext.next()).mVid);
    }
    this.a.a(paramVarArgs);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.2
 * JD-Core Version:    0.7.0.1
 */