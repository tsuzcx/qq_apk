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
import pay;

public final class BridgeModuleHelper$11
  implements Runnable
{
  public BridgeModuleHelper$11(String paramString1, File paramFile, BridgeModule paramBridgeModule, String paramString2) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData((QQAppInterface)pay.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "saveImage imageUrl code=" + i + ",url= " + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = new JSONObject();
    if (i == 0) {}
    try
    {
      ((JSONObject)localObject).put("retCode", 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localObject);
      localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject).setData(Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getPath()));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label212;
      }
      QLog.e("BridgeModuleHelper", 2, "saveImage imageUrl error=" + localException.getMessage() + ",url= " + this.jdField_a_of_type_JavaLangString);
      label212:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.b, "saveImage error");
    }
    ((JSONObject)localObject).put("retCode", -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localObject);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.11
 * JD-Core Version:    0.7.0.1
 */