package com.tencent.mobileqq.apollo.store.webview;

import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ApolloPluginRscLoader$3
  implements CmShowRscUpdateHandlerImpl.OnCheckContentListener
{
  ApolloPluginRscLoader$3(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    ApolloPluginRscLoader.b(this.g).remove(this.a);
    paramContentUpdateCheckResult = new StringBuilder();
    paramContentUpdateCheckResult.append("checkRoomRsc onCheckFinish success:");
    paramContentUpdateCheckResult.append(paramBoolean);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, paramContentUpdateCheckResult.toString());
    int i = 0;
    if (paramBoolean)
    {
      while (i < this.b.length)
      {
        paramContentUpdateCheckResult = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.b[i]);
        if (paramContentUpdateCheckResult != null) {
          this.c.add(paramContentUpdateCheckResult);
        }
        i += 1;
      }
      CmShowRscDownloader.a(this.d, "", new ApolloPluginRscLoader.3.1(this), this.c, false, null);
      return;
    }
    i = 0;
    while (i < this.b.length)
    {
      paramContentUpdateCheckResult = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.b[i]);
      int j = 2;
      if (paramContentUpdateCheckResult != null)
      {
        ApolloPluginRscLoader localApolloPluginRscLoader = this.g;
        int k = paramContentUpdateCheckResult.c;
        if (paramContentUpdateCheckResult.c()) {
          j = 0;
        }
        paramContentUpdateCheckResult = ApolloPluginRscLoader.a(localApolloPluginRscLoader, 8, String.valueOf(k), j);
        this.e.put(paramContentUpdateCheckResult);
      }
      else
      {
        paramContentUpdateCheckResult = ApolloPluginRscLoader.a(this.g, 8, String.valueOf(this.b[i]), 2);
        this.e.put(paramContentUpdateCheckResult);
      }
      i += 1;
    }
    this.g.a(this.f, HardCodeUtil.a(2131898745), this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.3
 * JD-Core Version:    0.7.0.1
 */