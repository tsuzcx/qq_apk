package com.tencent.mobileqq.Doraemon.impl;

import com.tencent.mobileqq.miniapp.MiniAppInfo;

class DefaultDoraemonAppInfoHelper$2
  implements Runnable
{
  DefaultDoraemonAppInfoHelper$2(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    DefaultDoraemonAppInfoHelper.OnGetAppInfo localOnGetAppInfo = this.a;
    MiniAppInfo localMiniAppInfo = this.b;
    int i;
    if (localMiniAppInfo.h == 1) {
      i = 2;
    } else {
      i = 3;
    }
    localOnGetAppInfo.a(localMiniAppInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.2
 * JD-Core Version:    0.7.0.1
 */