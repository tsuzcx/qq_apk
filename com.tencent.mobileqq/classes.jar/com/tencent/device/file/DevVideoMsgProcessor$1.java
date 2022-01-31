package com.tencent.device.file;

import android.content.Intent;
import axdo;
import axeg;
import axew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class DevVideoMsgProcessor$1
  implements Runnable
{
  public DevVideoMsgProcessor$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    axeg localaxeg = axdo.a(0, 1);
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", 9501);
    ((Intent)localObject).putExtra("file_send_business_type", 1);
    ((Intent)localObject).putExtra("file_send_path", this.b);
    long l = System.currentTimeMillis();
    localObject = axdo.a(1, localObject, localaxeg);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceShortVideo", 2, "createShortVideoUploadInfo cost:" + (System.currentTimeMillis() - l));
    }
    localaxeg.a((axew)localObject);
    axdo.a(localaxeg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevVideoMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */