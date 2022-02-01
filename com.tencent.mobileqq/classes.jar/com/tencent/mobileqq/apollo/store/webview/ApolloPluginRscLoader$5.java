package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$5
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$5(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (this.a.exists())
      {
        ApolloPluginRscLoader.a(this.c, this.b, 0, HardCodeUtil.a(2131898731));
        return;
      }
      ApolloPluginRscLoader.a(this.c, this.b, 2, HardCodeUtil.a(2131898760));
      return;
    }
    ApolloPluginRscLoader.a(this.c, this.b, 2, HardCodeUtil.a(2131898742));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.5
 * JD-Core Version:    0.7.0.1
 */