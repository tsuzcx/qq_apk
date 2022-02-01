package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$2
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$2(ApolloPluginRscLoader paramApolloPluginRscLoader, String paramString1, File paramFile, JSONArray paramJSONArray, int[] paramArrayOfInt, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    String str = this.a;
    if (this.b.exists()) {
      paramInt = 0;
    } else {
      paramInt = 2;
    }
    localObject = ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject, 6, str, paramInt);
    this.c.put(localObject);
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      ApolloPluginRscLoader.a(this.f, (int[])localObject, this.e, this.c);
      return;
    }
    this.f.a(this.e, HardCodeUtil.a(2131898749), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.2
 * JD-Core Version:    0.7.0.1
 */