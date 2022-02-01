package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ARVideoRecordUIControllerImpl$5
  implements QQPermissionCallback
{
  ARVideoRecordUIControllerImpl$5(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(ARVideoRecordUIControllerImpl.a(this.a), paramArrayOfString, paramArrayOfInt);
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION allow restart it");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.5
 * JD-Core Version:    0.7.0.1
 */