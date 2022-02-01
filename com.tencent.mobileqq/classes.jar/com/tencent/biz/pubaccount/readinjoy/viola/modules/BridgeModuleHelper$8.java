package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.io.File;

final class BridgeModuleHelper$8
  extends DownloadListener
{
  BridgeModuleHelper$8(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString));
      if (paramDownloadTask.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModuleHelper", 2, "shareImageToAIO->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        localActivity.runOnUiThread(new BridgeModuleHelper.8.1(this, paramDownloadTask));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "shareImageToAIO->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    localActivity.runOnUiThread(new BridgeModuleHelper.8.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.8
 * JD-Core Version:    0.7.0.1
 */