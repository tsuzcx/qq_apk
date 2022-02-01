package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import java.util.HashMap;

class ShareModeBase$11
  extends EncryptUrlJob
{
  ShareModeBase$11(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareCopyLinkData paramShareCopyLinkData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean c()
  {
    this.a.a = ((String)b("EncryptUrlJob_encryptedUrl"));
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.a.a, this.a.a);
    a("ShortenUrlJob_shortenedUrls", localHashMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.11
 * JD-Core Version:    0.7.0.1
 */