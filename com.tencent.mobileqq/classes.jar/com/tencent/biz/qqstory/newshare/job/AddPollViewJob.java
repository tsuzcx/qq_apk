package com.tencent.biz.qqstory.newshare.job;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Map;
import nga;

public class AddPollViewJob
  extends Job
{
  public StoryVideoItem a;
  public UrlBitmapDownloader a;
  
  public AddPollViewJob(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      SLog.c(this.b, "Error: ", new IllegalStateException("这里VideoItem为空, 临时保护, 可能存在逻辑异常"));
      b(false);
      return;
    }
    StoryVideoItem.PollLayout localPollLayout = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout();
    if (localPollLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader = new ShareGroupIconManager.UrlBitmapDownloaderImp();
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new nga(this, localPollLayout));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  protected void a(Map paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.AddPollViewJob
 * JD-Core Version:    0.7.0.1
 */