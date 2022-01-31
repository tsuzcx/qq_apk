package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import onk;

class BridgeModule$18
  implements Runnable
{
  BridgeModule$18(BridgeModule paramBridgeModule, String paramString, File paramFile) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.a((QQAppInterface)onk.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d(BridgeModule.TAG, 2, "saveImageToLocal imageUrl code=" + i + ",url= " + this.jdField_a_of_type_JavaLangString);
    }
    if (i == 0) {}
    try
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getPath()));
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModule.18.1(this));
      return;
    }
    catch (Exception localException)
    {
      ThreadManagerV2.getUIHandlerV2().post(new BridgeModule.18.3(this));
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e(BridgeModule.TAG, 2, "saveImageToLocal imageUrl error=" + localException.getMessage() + ",url= " + this.jdField_a_of_type_JavaLangString);
    }
    ThreadManagerV2.getUIHandlerV2().post(new BridgeModule.18.2(this));
    if (QLog.isColorLevel())
    {
      QLog.d(BridgeModule.TAG, 2, "download image error: " + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.18
 * JD-Core Version:    0.7.0.1
 */