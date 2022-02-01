package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class DefaultDoraemonAppInfoHelper$3
  extends SimpleObserver<MiniAppInfo>
{
  DefaultDoraemonAppInfoHelper$3(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo) {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    DefaultDoraemonAppInfoHelper.OnGetAppInfo localOnGetAppInfo = this.a;
    int i;
    if (paramMiniAppInfo.h == 1) {
      i = 2;
    } else {
      i = 3;
    }
    localOnGetAppInfo.a(paramMiniAppInfo, i);
  }
  
  public void onError(Error paramError)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError: ");
      localStringBuilder.append(paramError.getMessage());
      QLog.i("DoraemonOpenAPI.permissionHelper", 2, localStringBuilder.toString());
    }
    int i;
    if ((paramError instanceof AppInfoError)) {
      i = ((AppInfoError)paramError).type;
    } else {
      i = 0;
    }
    this.a.a(null, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.3
 * JD-Core Version:    0.7.0.1
 */