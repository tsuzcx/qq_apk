package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddPollViewJob;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;

class ShareModeBase$15
  extends AddPollViewJob
{
  ShareModeBase$15(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem, ShareSinaData paramShareSinaData)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean c()
  {
    String str = (String)b("result");
    AssertUtils.checkNotEmpty(str);
    AssertUtils.checkNotEmpty(this.c.g);
    if (this.c.g == null)
    {
      this.c.g = "";
      SLog.c(this.e, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.c.g);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.c.i));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.15
 * JD-Core Version:    0.7.0.1
 */