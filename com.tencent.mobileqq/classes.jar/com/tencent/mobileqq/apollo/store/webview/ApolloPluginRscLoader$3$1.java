package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ApolloPluginRscLoader$3$1
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$3$1(ApolloPluginRscLoader.3 param3) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("checkRoomRsc downloadApolloRes onDownLoadFinish success:");
    paramString1.append(paramBoolean);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, paramString1.toString());
    int i = 0;
    while (i < this.a.b.length)
    {
      paramString1 = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.a.b[i]);
      int j = 2;
      if (paramString1 != null)
      {
        paramList = this.a.g;
        int k = paramString1.c;
        if (paramString1.c()) {
          j = 0;
        }
        paramString1 = ApolloPluginRscLoader.a(paramList, 8, String.valueOf(k), j);
        this.a.e.put(paramString1);
      }
      else
      {
        paramString1 = ApolloPluginRscLoader.a(this.a.g, 8, String.valueOf(this.a.b[i]), 2);
        this.a.e.put(paramString1);
      }
      i += 1;
    }
    this.a.g.a(this.a.f, HardCodeUtil.a(2131898746), this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.3.1
 * JD-Core Version:    0.7.0.1
 */