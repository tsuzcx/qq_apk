package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddPollViewJob;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

class ShareModeBase$9
  extends AddPollViewJob
{
  ShareModeBase$9(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    Object localObject = (String)a("result");
    try
    {
      localObject = new URI((String)localObject);
      if ("file".equals(((URI)localObject).getScheme()))
      {
        localObject = new File((URI)localObject);
        if (((File)localObject).exists())
        {
          a("UploadImageJob_in_image_file_path", ((File)localObject).getAbsolutePath());
          return true;
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      SLog.c(this.b, "Error: 保存投票失败", localURISyntaxException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.9
 * JD-Core Version:    0.7.0.1
 */