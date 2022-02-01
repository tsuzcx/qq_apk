package com.tencent.device.file;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.qphone.base.util.QLog;

final class DevVideoMsgProcessor$1
  implements Runnable
{
  DevVideoMsgProcessor$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(0, 1);
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("uin", this.a);
    ((Intent)localObject).putExtra("uintype", 9501);
    ((Intent)localObject).putExtra("file_send_business_type", 1);
    ((Intent)localObject).putExtra("file_send_path", this.b);
    long l = System.currentTimeMillis();
    localObject = ShortVideoBusiManager.a(1, localObject, localShortVideoReq);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createShortVideoUploadInfo cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("DeviceShortVideo", 2, localStringBuilder.toString());
    }
    localShortVideoReq.a((ShortVideoUploadInfo)localObject);
    ShortVideoBusiManager.a(localShortVideoReq, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevVideoMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */