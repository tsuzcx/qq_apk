package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import aunt;
import auob;
import bhvv;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import yak;

class SendPhotoTask$1
  implements Runnable
{
  SendPhotoTask$1(SendPhotoTask paramSendPhotoTask, yak paramyak, aunt paramaunt, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Yak.a(Long.parseLong(this.jdField_a_of_type_Aunt.a.c), "", "", "", 0, null);
      DeviceInfo localDeviceInfo = this.jdField_a_of_type_Yak.a(Long.parseLong(this.jdField_a_of_type_Aunt.a.c));
      Object localObject = new FileInfo(this.jdField_a_of_type_Aunt.a.g);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", localArrayList);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", "pic");
      bhvv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask.1
 * JD-Core Version:    0.7.0.1
 */