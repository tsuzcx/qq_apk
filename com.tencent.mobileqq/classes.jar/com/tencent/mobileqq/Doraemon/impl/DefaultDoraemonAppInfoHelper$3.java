package com.tencent.mobileqq.Doraemon.impl;

import android.support.annotation.NonNull;
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
    DefaultDoraemonAppInfoHelper.OnGetAppInfo localOnGetAppInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo;
    if (paramMiniAppInfo.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localOnGetAppInfo.a(paramMiniAppInfo, i);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper", 2, "onError: " + paramError.getMessage());
    }
    if ((paramError instanceof AppInfoError)) {}
    for (int i = ((AppInfoError)paramError).type;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.3
 * JD-Core Version:    0.7.0.1
 */