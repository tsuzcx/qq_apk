package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;

class ShareModeBase$2
  extends EncryptUrlJob
{
  ShareModeBase$2(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareQQData paramShareQQData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean c()
  {
    this.a.m = ((String)b("EncryptUrlJob_encryptedUrl"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.2
 * JD-Core Version:    0.7.0.1
 */