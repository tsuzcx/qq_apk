package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

class PublicAccountHandlerImpl$4
  implements QQPermissionCallback
{
  PublicAccountHandlerImpl$4(PublicAccountHandlerImpl paramPublicAccountHandlerImpl, int paramInt, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions denied...");
    ThreadManager.getSubThreadHandler().post(new PublicAccountHandlerImpl.4.1(this));
    DialogUtil.a(this.b, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions grant...");
    PublicAccountHandlerImpl.access$400(this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */