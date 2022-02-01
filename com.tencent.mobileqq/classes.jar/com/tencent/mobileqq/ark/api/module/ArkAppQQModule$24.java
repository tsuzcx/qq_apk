package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ArkAppQQModule$24
  implements Runnable
{
  ArkAppQQModule$24(ArkAppQQModule paramArkAppQQModule) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null) {
      return;
    }
    QQToast.a(localBaseApplication, localBaseApplication.getString(2131690170), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.24
 * JD-Core Version:    0.7.0.1
 */