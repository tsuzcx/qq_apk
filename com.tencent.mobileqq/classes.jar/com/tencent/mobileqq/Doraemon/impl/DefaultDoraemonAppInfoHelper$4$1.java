package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppInfoCallback;
import com.tribe.async.async.JobSegment;

class DefaultDoraemonAppInfoHelper$4$1
  extends MiniAppInfoCallback<JobSegment>
{
  DefaultDoraemonAppInfoHelper$4$1(DefaultDoraemonAppInfoHelper.4 param4, JobSegment paramJobSegment)
  {
    super(paramJobSegment);
  }
  
  public void a(JobSegment paramJobSegment, boolean paramBoolean, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBoolean)
    {
      DefaultDoraemonAppInfoHelper.4.a(this.a, paramMiniAppInfo);
      return;
    }
    DefaultDoraemonAppInfoHelper.4.a(this.a, new AppInfoError(5, "appInfo error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.4.1
 * JD-Core Version:    0.7.0.1
 */