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
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fTargetFile = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.e("ViewPluginLoader", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = new Bundle();
    localObject3 = new DownloadTask((String)localObject1, (File)localObject3);
    ((DownloadTask)localObject3).b = 3;
    this.this$0.a().startDownload((DownloadTask)localObject3, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start Download url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ViewPluginLoader", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */