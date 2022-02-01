package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.newshare.job.UploadImageJob;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;

class ShareGroupCardShareMode$1
  extends UploadImageJob
{
  ShareGroupCardShareMode$1(ShareGroupCardShareMode paramShareGroupCardShareMode, String paramString)
  {
    super(paramString);
  }
  
  public boolean c()
  {
    ShareGroupCardShareMode.a(this.a, (String)b("UploadImageJob_out_image_url"));
    ((ShareGroupManager)SuperManager.a(7)).a(this.a.d, ShareGroupCardShareMode.a(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupCardShareMode.1
 * JD-Core Version:    0.7.0.1
 */