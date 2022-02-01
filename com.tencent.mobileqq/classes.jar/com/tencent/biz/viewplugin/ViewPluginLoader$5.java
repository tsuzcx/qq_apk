package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class ViewPluginLoader$5
  implements Runnable
{
  ViewPluginLoader$5(ViewPluginLoader paramViewPluginLoader, JSONObject paramJSONObject, String paramString, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QLog.e("ViewPluginLoader", 1, "fTargetFile = " + this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localObject = new DownloadTask(str, (File)localObject);
      ((DownloadTask)localObject).b = 3;
      this.this$0.a().a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */