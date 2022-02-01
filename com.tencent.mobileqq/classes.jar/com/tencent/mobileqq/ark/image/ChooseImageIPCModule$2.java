package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;

class ChooseImageIPCModule$2
  implements Runnable
{
  ChooseImageIPCModule$2(ChooseImageIPCModule paramChooseImageIPCModule, Bundle paramBundle, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1;
    boolean bool1;
    label37:
    boolean bool2;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label196;
      }
      bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("supportGzip");
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label201;
      }
      bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("supportRedirect");
      label54:
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label206;
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("Cookie");
      label72:
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label212;
      }
    }
    label196:
    label201:
    label206:
    label212:
    for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("Referer");; str = null)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("file");
      }
      QLog.i("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload url=" + (String)localObject1);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
        break label218;
      }
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload for url is null or filepath is null");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("code", -1);
      localObject1 = EIPCResult.createResult(-102, (Bundle)localObject1);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject1);
      return;
      localObject1 = null;
      break;
      bool1 = true;
      break label37;
      bool2 = true;
      break label54;
      localObject2 = null;
      break label72;
    }
    label218:
    Object localObject4 = (DownloaderFactory)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (localObject4 == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload return for factory is null");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("code", -1);
      localObject1 = EIPCResult.createResult(-102, (Bundle)localObject1);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject1);
      return;
    }
    localObject4 = ((DownloaderFactory)localObject4).a(1);
    localObject3 = new DownloadTask((String)localObject1, new File((String)localObject3));
    ((DownloadTask)localObject3).n = bool1;
    ((DownloadTask)localObject3).p = bool2;
    if (localObject2 != null) {
      ((DownloadTask)localObject3).a("Cookie", (String)localObject2);
    }
    if (str != null) {
      ((DownloadTask)localObject3).a("Referer", str);
    }
    Object localObject2 = new Bundle();
    ((DownloaderInterface)localObject4).a((DownloadTask)localObject3, new ChooseImageIPCModule.2.1(this, (String)localObject1), (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2
 * JD-Core Version:    0.7.0.1
 */