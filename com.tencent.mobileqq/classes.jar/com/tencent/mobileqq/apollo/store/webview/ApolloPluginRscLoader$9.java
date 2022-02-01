package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ApolloPluginRscLoader$9
  implements CmShowRscUpdateHandlerImpl.OnCheckContentListener
{
  ApolloPluginRscLoader$9(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, String paramString, AppInterface paramAppInterface, File paramFile) {}
  
  public void a(boolean paramBoolean, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    Object localObject1 = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.a);
    paramContentUpdateCheckResult = new StringBuilder();
    paramContentUpdateCheckResult.append("downloadApolloRes onCheckFinish success:");
    paramContentUpdateCheckResult.append(paramBoolean);
    paramContentUpdateCheckResult.append(" downloadItem:");
    if (localObject1 == null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    paramContentUpdateCheckResult.append(paramBoolean);
    QLog.i("[cmshow]ApolloPluginRscLoader", 1, paramContentUpdateCheckResult.toString());
    paramContentUpdateCheckResult = ApolloPluginRscLoader.b(this.b);
    if (TextUtils.isEmpty(paramContentUpdateCheckResult))
    {
      paramContentUpdateCheckResult = new StringBuilder();
      paramContentUpdateCheckResult.append("getApolloRsc error callbackId is null resourceUrl:");
      paramContentUpdateCheckResult.append(this.b);
      QLog.e("[cmshow]ApolloPluginRscLoader", 1, paramContentUpdateCheckResult.toString());
      return;
    }
    if (localObject1 == null)
    {
      localObject1 = this.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" json里无此id");
      ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject1, paramContentUpdateCheckResult, 2, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    CmShowRscDownloader.a(this.c, "", new ApolloPluginRscLoader.9.1(this, paramContentUpdateCheckResult), (List)localObject2, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.9
 * JD-Core Version:    0.7.0.1
 */