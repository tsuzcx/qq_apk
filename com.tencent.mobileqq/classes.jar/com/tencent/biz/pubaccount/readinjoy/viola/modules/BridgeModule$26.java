package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import pha;

class BridgeModule$26
  implements Runnable
{
  BridgeModule$26(BridgeModule paramBridgeModule, String paramString1, File paramFile, String paramString2) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.a((QQAppInterface)pha.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d(BridgeModule.TAG, 2, "saveImage imageUrl code=" + i + ",url= " + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = new JSONObject();
    if (i == 0) {}
    try
    {
      ((JSONObject)localObject).put("retCode", 0);
      this.this$0.invokeCallJS(this.b, localObject);
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject).setData(Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getPath()));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label214;
      }
      QLog.e(BridgeModule.TAG, 2, "saveImage imageUrl error=" + localException.getMessage() + ",url= " + this.jdField_a_of_type_JavaLangString);
      label214:
      this.this$0.invokeErrorCallJS(this.b, "saveImage error");
    }
    ((JSONObject)localObject).put("retCode", -1);
    this.this$0.invokeCallJS(this.b, localObject);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.26
 * JD-Core Version:    0.7.0.1
 */