package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;

class ShareModeBase$9
  extends EncryptUrlJob
{
  ShareModeBase$9(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareQZoneData paramShareQZoneData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareQZoneData.e = ((String)a("EncryptUrlJob_encryptedUrl"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.9
 * JD-Core Version:    0.7.0.1
 */