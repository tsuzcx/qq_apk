package com.tencent.biz.qqstory.newshare.job;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EncryptUrlJob
  extends Job
{
  private String a;
  private String b;
  private boolean c;
  
  public EncryptUrlJob(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt url:", this.a });
    }
    StoryShareTranslateTokenRequest localStoryShareTranslateTokenRequest = new StoryShareTranslateTokenRequest();
    localStoryShareTranslateTokenRequest.g = 1;
    String[] arrayOfString = this.a.split("\\?");
    if (arrayOfString.length != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EncryptUrlJob", 2, new Object[] { "Illegal url:", this.a });
      }
      a("EncryptUrlJob_encryptedUrl", this.a);
      b(true);
      return;
    }
    localStoryShareTranslateTokenRequest.f = arrayOfString[1];
    localStoryShareTranslateTokenRequest.h = this.b;
    CmdTaskManger.a().a(localStoryShareTranslateTokenRequest, new EncryptUrlJob.1(this, arrayOfString));
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.h != null) && (!this.h.isEmpty()))
    {
      if (paramMap.containsKey("EncryptUrlJob_shareUrl")) {
        this.a = ((String)b("EncryptUrlJob_shareUrl"));
      }
      if (paramMap.containsKey("EncryptUrlJob_feedId")) {
        this.b = ((String)b("EncryptUrlJob_feedId"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.EncryptUrlJob
 * JD-Core Version:    0.7.0.1
 */