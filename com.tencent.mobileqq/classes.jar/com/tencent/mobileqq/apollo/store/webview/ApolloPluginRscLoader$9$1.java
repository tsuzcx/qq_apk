package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ApolloPluginRscLoader$9$1
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$9$1(ApolloPluginRscLoader.9 param9, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("downloadApolloRes onDownLoadFinish success:");
    paramString1.append(paramBoolean);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, paramString1.toString());
    if (paramBoolean)
    {
      if (this.b.d.exists())
      {
        paramString1 = this.b.e;
        paramList = this.a;
        paramString2 = new StringBuilder();
        paramString2.append(this.b.a);
        paramString2.append(HardCodeUtil.a(2131898744));
        ApolloPluginRscLoader.a(paramString1, paramList, 0, paramString2.toString());
        return;
      }
      paramString1 = this.b.e;
      paramList = this.a;
      paramString2 = new StringBuilder();
      paramString2.append(this.b.a);
      paramString2.append(HardCodeUtil.a(2131898755));
      ApolloPluginRscLoader.a(paramString1, paramList, 2, paramString2.toString());
      return;
    }
    paramString1 = this.b.e;
    paramList = this.a;
    paramString2 = new StringBuilder();
    paramString2.append(this.b.a);
    paramString2.append(HardCodeUtil.a(2131898752));
    ApolloPluginRscLoader.a(paramString1, paramList, 2, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.9.1
 * JD-Core Version:    0.7.0.1
 */