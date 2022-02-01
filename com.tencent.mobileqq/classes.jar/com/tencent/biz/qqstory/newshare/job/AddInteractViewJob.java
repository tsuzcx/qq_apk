package com.tencent.biz.qqstory.newshare.job;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Map;

public class AddInteractViewJob
  extends Job
{
  StoryVideoItem a;
  public UrlBitmapDownloader a;
  
  public AddInteractViewJob(StoryVideoItem paramStoryVideoItem)
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout() != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader = new ShareGroupIconManager.UrlBitmapDownloaderImp();
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlBitmapDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, 0, 0, new AddInteractViewJob.1(this));
      return;
    }
    a("result", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
    b(true);
  }
  
  public void a(Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.AddInteractViewJob
 * JD-Core Version:    0.7.0.1
 */