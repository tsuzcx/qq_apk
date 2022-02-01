package com.tencent.mobileqq.activity.qwallet.preload;

import akxq;
import akxt;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

public class QWalletIPCModule$2
  implements Runnable
{
  public QWalletIPCModule$2(akxq paramakxq, Bundle paramBundle, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("config_str");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("id");
    akxt localakxt = new akxt(this, (ResultReceiver)this.jdField_a_of_type_AndroidOsBundle.getParcelable("receiver"));
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getManager(QQManagerFactory.PRELOAD_MANAGER);
    if ("downloadModule".equals(this.jdField_a_of_type_JavaLangString)) {
      localPreloadManager.b(str2, str1, localakxt);
    }
    while (!"downloadRes".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    localPreloadManager.a(str2, str1, localakxt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2
 * JD-Core Version:    0.7.0.1
 */