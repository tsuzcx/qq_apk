package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class DefaultDoraemonAppInfoHelper$6
  extends JobSegment<MiniAppInfo, MiniAppInfo>
{
  DefaultDoraemonAppInfoHelper$6(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.b())
    {
      notifyResult(paramMiniAppInfo);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    MiniAppManager.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new DefaultDoraemonAppInfoHelper.6.1(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.6
 * JD-Core Version:    0.7.0.1
 */