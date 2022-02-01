package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.ShortenUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import java.util.HashMap;

class ShareModeBase$10
  extends ShortenUrlJob
{
  ShareModeBase$10(ShareModeBase paramShareModeBase, ShareCopyLinkData paramShareCopyLinkData) {}
  
  public boolean b()
  {
    HashMap localHashMap = (HashMap)a("ShortenUrlJob_shortenedUrls");
    ShareCopyLinkData localShareCopyLinkData = this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData;
    localShareCopyLinkData.a = ((String)localHashMap.get(localShareCopyLinkData.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.10
 * JD-Core Version:    0.7.0.1
 */