package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ApolloPluginRscLoader$10
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$10(ApolloPluginRscLoader paramApolloPluginRscLoader, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("downloadApolloRes onDownLoadFinish success:");
    paramString1.append(paramBoolean);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, paramString1.toString());
    paramString1 = ApolloPluginRscLoader.b(this.a);
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("getApolloRsc error callbackId is null resourceUrl:");
      paramString1.append(this.a);
      QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramString1.toString());
      return;
    }
    if (paramBoolean)
    {
      if (this.b.exists())
      {
        paramList = this.d;
        paramString2 = new StringBuilder();
        paramString2.append(this.c);
        paramString2.append(HardCodeUtil.a(2131898741));
        ApolloPluginRscLoader.a(paramList, paramString1, 0, paramString2.toString());
        return;
      }
      paramList = this.d;
      paramString2 = new StringBuilder();
      paramString2.append(this.c);
      paramString2.append(HardCodeUtil.a(2131898740));
      ApolloPluginRscLoader.a(paramList, paramString1, 2, paramString2.toString());
      return;
    }
    paramList = this.d;
    paramString2 = new StringBuilder();
    paramString2.append(this.c);
    paramString2.append(HardCodeUtil.a(2131898735));
    ApolloPluginRscLoader.a(paramList, paramString1, 2, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.10
 * JD-Core Version:    0.7.0.1
 */