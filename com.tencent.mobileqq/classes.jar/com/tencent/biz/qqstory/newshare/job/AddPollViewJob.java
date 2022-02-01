package com.tencent.biz.qqstory.newshare.job;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Map;

public class AddPollViewJob
  extends Job
{
  StoryVideoItem a;
  public UrlBitmapDownloader b;
  
  public AddPollViewJob(StoryVideoItem paramStoryVideoItem)
  {
    this.a = paramStoryVideoItem;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      SLog.c(this.e, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    localObject = ((StoryVideoItem)localObject).getPollLayout();
    if (localObject != null)
    {
      this.b = new ShareGroupIconManager.UrlBitmapDownloaderImp();
      this.b.a(this.a.mVideoThumbnailUrl, 0, 0, new AddPollViewJob.1(this, (StoryVideoItem.PollLayout)localObject));
      return;
    }
    a("result", this.a.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.AddPollViewJob
 * JD-Core Version:    0.7.0.1
 */