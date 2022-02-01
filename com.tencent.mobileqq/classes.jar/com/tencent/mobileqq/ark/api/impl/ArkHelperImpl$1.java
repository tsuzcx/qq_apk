package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

class ArkHelperImpl$1
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkHelperImpl$1(ArkHelperImpl paramArkHelperImpl) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkHelper", 2, new Object[] { "preDownloadArkApp download complete,retCode: ", Integer.valueOf(paramInt), ";msg: ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */