package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$1$1
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$1$1(ApolloPluginRscLoader.1 param1) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.g;
    String str = this.a.d;
    if (this.a.b.exists()) {
      paramInt = 0;
    } else {
      paramInt = 2;
    }
    localObject = ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject, 6, str, paramInt);
    this.a.a.put(localObject);
    if ((this.a.e != null) && (this.a.e.length > 0))
    {
      ApolloPluginRscLoader.a(this.a.g, this.a.e, this.a.f, this.a.a);
      return;
    }
    this.a.g.a(this.a.f, HardCodeUtil.a(2131898734), this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.1.1
 * JD-Core Version:    0.7.0.1
 */