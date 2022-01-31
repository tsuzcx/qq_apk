package com.tencent.device.file;

import android.content.Intent;
import ayyu;
import ayzo;
import azae;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class DevVideoMsgProcessor$1
  implements Runnable
{
  public DevVideoMsgProcessor$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ayzo localayzo = ayyu.a(0, 1);
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", 9501);
    ((Intent)localObject).putExtra("file_send_business_type", 1);
    ((Intent)localObject).putExtra("file_send_path", this.b);
    long l = System.currentTimeMillis();
    localObject = ayyu.a(1, localObject, localayzo);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceShortVideo", 2, "createShortVideoUploadInfo cost:" + (System.currentTimeMillis() - l));
    }
    localayzo.a((azae)localObject);
    ayyu.a(localayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.file.DevVideoMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */