package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

public enum HuaweiArApkBase$ARInstallStatus
{
  INSTALLED(0),  INSTALL_REQUESTED(1);
  
  final int nativeCode;
  
  private HuaweiArApkBase$ARInstallStatus(int paramInt)
  {
    this.nativeCode = paramInt;
  }
  
  static ARInstallStatus forNumber(int paramInt)
  {
    ARInstallStatus[] arrayOfARInstallStatus = values();
    int j = arrayOfARInstallStatus.length;
    int i = 0;
    while (i < j)
    {
      ARInstallStatus localARInstallStatus = arrayOfARInstallStatus[i];
      if (localARInstallStatus.nativeCode == paramInt) {
        return localARInstallStatus;
      }
      i += 1;
    }
    throw new ARFatalException(60 + "Unexpected value for native InstallStatus, value=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.HuaweiArApkBase.ARInstallStatus
 * JD-Core Version:    0.7.0.1
 */