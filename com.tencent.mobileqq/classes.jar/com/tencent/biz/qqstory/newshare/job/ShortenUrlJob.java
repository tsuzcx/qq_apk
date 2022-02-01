package com.tencent.biz.qqstory.newshare.job;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;

public class ShortenUrlJob
  extends Job
{
  private HashMap<String, String> a;
  private boolean b;
  
  public ShortenUrlJob()
  {
    this(null, false);
  }
  
  public ShortenUrlJob(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a(false, true);
    this.a = paramHashMap;
    this.b = paramBoolean;
  }
  
  public void a()
  {
    Object localObject2 = PlayModeUtils.b();
    Object localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    Object localObject3 = ((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1);
    localObject2 = new Bundle();
    localObject1 = HttpUtil.batchUrlExchange(BaseApplication.getContext(), (String)localObject1, (String)localObject3, 1, this.a, (Bundle)localObject2);
    if ((!((Bundle)localObject2).getBoolean("isSuccess", false)) && (this.b))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.e;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("shortenUrl failed size:");
        ((StringBuilder)localObject3).append(((HashMap)localObject1).size());
        QLog.w((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      b(false);
      return;
    }
    a("ShortenUrlJob_shortenedUrls", localObject1);
    b(true);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.h != null) && (!this.h.isEmpty()) && (paramMap.containsKey("ShortenUrlJob_shortenedUrls"))) {
      this.a = ((HashMap)ShareUtils.a(this.h, "ShortenUrlJob_shortenedUrls", this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.ShortenUrlJob
 * JD-Core Version:    0.7.0.1
 */