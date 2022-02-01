package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class DefaultDoraemonAppInfoHelper$EnsureInitJobSegment
  extends JobSegment<MiniAppInfo, MiniAppInfo>
{
  protected void a(JobContext paramJobContext, MiniAppInfo paramMiniAppInfo)
  {
    paramJobContext = DefaultDoraemonAppInfoHelper.a();
    if (!paramJobContext.b) {
      paramJobContext.b();
    }
    notifyResult(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.EnsureInitJobSegment
 * JD-Core Version:    0.7.0.1
 */