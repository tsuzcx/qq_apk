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
    Object localObject1 = this.a.optString("url");
    if (TextUtils.isEmpty(this.b))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fTargetFile = ");
      ((StringBuilder)localObject1).append(this.b);
      QLog.e("ViewPluginLoader", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject3 = new File(this.b);
    Object localObject2 = new Bundle();
    localObject3 = new DownloadTask((String)localObject1, (File)localObject3);
    ((DownloadTask)localObject3).e = 3;
    this.this$0.c().startDownload((DownloadTask)localObject3, this.c, (Bundle)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start Download url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ViewPluginLoader", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */