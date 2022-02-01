package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppInfoCallback;
import com.tribe.async.async.JobSegment;

class DefaultDoraemonAppInfoHelper$6$1
  extends MiniAppInfoCallback<JobSegment>
{
  DefaultDoraemonAppInfoHelper$6$1(DefaultDoraemonAppInfoHelper.6 param6, JobSegment paramJobSegment)
  {
    super(paramJobSegment);
  }
  
  public void a(JobSegment paramJobSegment, boolean paramBoolean, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBoolean)
    {
      DefaultDoraemonAppInfoHelper.6.a(this.a, paramMiniAppInfo);
      return;
    }
    DefaultDoraemonAppInfoHelper.6.a(this.a, new AppInfoError(5, "appInfo error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.6.1
 * JD-Core Version:    0.7.0.1
 */