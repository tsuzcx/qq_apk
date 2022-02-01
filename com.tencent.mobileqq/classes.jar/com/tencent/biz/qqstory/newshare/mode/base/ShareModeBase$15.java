package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import java.util.HashMap;

class ShareModeBase$15
  extends EncryptUrlJob
{
  ShareModeBase$15(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareCopyLinkData paramShareCopyLinkData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData.a = ((String)a("EncryptUrlJob_encryptedUrl"));
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData.a, this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData.a);
    a("ShortenUrlJob_shortenedUrls", localHashMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.15
 * JD-Core Version:    0.7.0.1
 */