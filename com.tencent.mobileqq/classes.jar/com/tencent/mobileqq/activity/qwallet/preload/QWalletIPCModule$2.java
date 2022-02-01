package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import mqq.app.AppRuntime;

class QWalletIPCModule$2
  implements Runnable
{
  QWalletIPCModule$2(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("config_str");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("id");
    QWalletIPCModule.2.1 local1 = new QWalletIPCModule.2.1(this, (ResultReceiver)this.jdField_a_of_type_AndroidOsBundle.getParcelable("receiver"));
    IPreloadService localIPreloadService = (IPreloadService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IPreloadService.class, "");
    if ("downloadModule".equals(this.jdField_a_of_type_JavaLangString)) {
      localIPreloadService.downloadModule(str2, str1, local1);
    }
    while (!"downloadRes".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    localIPreloadService.downloadRes(str2, str1, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2
 * JD-Core Version:    0.7.0.1
 */