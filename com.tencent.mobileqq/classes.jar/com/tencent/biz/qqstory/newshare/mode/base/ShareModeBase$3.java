package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;

class ShareModeBase$3
  extends EncryptUrlJob
{
  ShareModeBase$3(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareWeChatData paramShareWeChatData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean c()
  {
    this.a.h = ((String)b("EncryptUrlJob_encryptedUrl"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.3
 * JD-Core Version:    0.7.0.1
 */