package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

class TroopQZoneUploadAlbumHandler$1
  extends Handler
{
  TroopQZoneUploadAlbumHandler$1(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler, Looper paramLooper, QQAppInterface paramQQAppInterface)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 1000)
      {
        if (i != 1001)
        {
          switch (i)
          {
          default: 
            return;
          case 1005: 
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Get Message task removed. clientKey= ");
              ((StringBuilder)localObject).append(paramMessage.arg1);
              ((StringBuilder)localObject).append(" arg2=");
              ((StringBuilder)localObject).append(paramMessage.arg2);
              QLog.d("UploadPhoto", 2, ((StringBuilder)localObject).toString());
            }
            i = paramMessage.arg1;
            this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.remove(i);
            return;
          case 1004: 
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Get Message no task. clientKey= ");
              ((StringBuilder)localObject).append(paramMessage.arg1);
              ((StringBuilder)localObject).append(" arg2=");
              ((StringBuilder)localObject).append(paramMessage.arg2);
              QLog.d("UploadPhoto", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.clear();
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Get Message failed. clientKey= ");
            ((StringBuilder)localObject).append(paramMessage.arg1);
            ((StringBuilder)localObject).append(" arg2=");
            ((StringBuilder)localObject).append(paramMessage.arg2);
            QLog.d("UploadPhoto", 2, ((StringBuilder)localObject).toString());
          }
          i = paramMessage.arg1;
          this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Get Message Progress. clientKey= ");
          ((StringBuilder)localObject).append(paramMessage.arg1);
          ((StringBuilder)localObject).append(" progress=");
          ((StringBuilder)localObject).append(paramMessage.arg2);
          QLog.d("UploadPhoto", 2, ((StringBuilder)localObject).toString());
        }
        i = paramMessage.arg1;
        this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Get Message Finished. clientKey= ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        ((StringBuilder)localObject).append(" arg2=");
        ((StringBuilder)localObject).append(paramMessage.arg2);
        QLog.d("UploadPhoto", 2, ((StringBuilder)localObject).toString());
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    i = ((Integer)paramMessage[0]).intValue();
    Object localObject = (TroopQZoneUploadAlbumHandler.MonitorInfo)paramMessage[1];
    int j = ((Integer)paramMessage[2]).intValue();
    int k = ((Integer)paramMessage[3]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(((TroopQZoneUploadAlbumHandler.MonitorInfo)localObject).jdField_a_of_type_Long, j, k);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, ((TroopQZoneUploadAlbumHandler.MonitorInfo)localObject).jdField_a_of_type_JavaLangString, ((TroopQZoneUploadAlbumHandler.MonitorInfo)localObject).jdField_a_of_type_Long, j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.1
 * JD-Core Version:    0.7.0.1
 */