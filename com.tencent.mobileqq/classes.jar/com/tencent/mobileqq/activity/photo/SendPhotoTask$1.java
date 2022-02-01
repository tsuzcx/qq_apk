package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;

class SendPhotoTask$1
  implements Runnable
{
  SendPhotoTask$1(SendPhotoTask paramSendPhotoTask, SmartDeviceProxyMgr paramSmartDeviceProxyMgr, PicReq paramPicReq, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a.c), "", "", "", 0, null);
      DeviceInfo localDeviceInfo = this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a.c));
      Object localObject = new FileInfo(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.a.g);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", localArrayList);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", "pic");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask.1
 * JD-Core Version:    0.7.0.1
 */