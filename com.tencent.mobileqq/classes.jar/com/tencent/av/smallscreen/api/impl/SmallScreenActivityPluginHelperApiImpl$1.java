package com.tencent.av.smallscreen.api.impl;

import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenActivityPluginHelperApiImpl$1
  implements Runnable
{
  SmallScreenActivityPluginHelperApiImpl$1(SmallScreenActivityPluginHelperApiImpl paramSmallScreenActivityPluginHelperApiImpl, long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void run()
  {
    long l = this.a;
    BaseApplication localBaseApplication = this.b.getApp();
    boolean bool;
    if ((this.c) && (this.d) && (!this.e)) {
      bool = true;
    } else {
      bool = false;
    }
    SmallScreenUtils.a(l, 2, localBaseApplication, bool, this.b.getCurrentAccountUin(), this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.impl.SmallScreenActivityPluginHelperApiImpl.1
 * JD-Core Version:    0.7.0.1
 */