package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.miniapp.MiniAppInfo;

class DefaultDoraemonAppInfoHelper$2
  implements Runnable
{
  DefaultDoraemonAppInfoHelper$2(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    DefaultDoraemonAppInfoHelper.OnGetAppInfo localOnGetAppInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo;
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localOnGetAppInfo.a(localMiniAppInfo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.2
 * JD-Core Version:    0.7.0.1
 */