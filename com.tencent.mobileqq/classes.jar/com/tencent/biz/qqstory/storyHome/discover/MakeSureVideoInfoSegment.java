package com.tencent.biz.qqstory.storyHome.discover;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.StreamFunction;
import java.util.ArrayList;
import java.util.List;

public class MakeSureVideoInfoSegment
  extends StreamFunction
{
  private static boolean b(StoryVideoItem paramStoryVideoItem)
  {
    return (!TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) && (!TextUtils.isEmpty(paramStoryVideoItem.getDownloadMaskUrl()));
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem == null) || (paramStoryVideoItem.mVid == null))
    {
      notifyError(new ErrorMessage(-1, "param should not be null"));
      return;
    }
    if (b(paramStoryVideoItem))
    {
      b(paramStoryVideoItem);
      return;
    }
    Object localObject = ((StoryManager)SuperManager.a(5)).a(paramStoryVideoItem.mVid);
    if ((localObject != null) && (b((StoryVideoItem)localObject)))
    {
      b((StoryVideoItem)localObject);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramStoryVideoItem.mVid);
    localObject = BatchHandlerListPuller.a((List)localObject);
    ((BatchHandlerListPuller)localObject).a("story.autoplay.MakeSureVideoInfoSegment");
    ((BatchHandlerListPuller)localObject).a(new MakeSureVideoInfoSegment.IPullResultCallbackImpl(this, paramStoryVideoItem.mVid));
    ((BatchHandlerListPuller)localObject).b();
  }
  
  protected void b(StoryVideoItem paramStoryVideoItem)
  {
    SLog.a("story.autoplay.MakeSureVideoInfoSegment", "notifyResult %s", paramStoryVideoItem);
    super.notifyResult(paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.MakeSureVideoInfoSegment
 * JD-Core Version:    0.7.0.1
 */