package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ApolloPluginRscLoader$5
  implements CmShowRscUpdateHandlerImpl.OnCheckContentListener
{
  ApolloPluginRscLoader$5(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, String paramString, AppInterface paramAppInterface, File paramFile) {}
  
  public void a(boolean paramBoolean, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    paramContentUpdateCheckResult = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.jdField_a_of_type_Int);
    Object localObject = new StringBuilder().append("downloadApolloRes onCheckFinish success:").append(paramBoolean).append(" downloadItem:");
    if (paramContentUpdateCheckResult == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("ApolloPluginRscLoader", 1, paramBoolean);
      localObject = ApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramContentUpdateCheckResult == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a((String)localObject, 2, this.jdField_a_of_type_Int + " json里无此id");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContentUpdateCheckResult);
    CmShowRscDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ApolloPluginRscLoader.5.1(this, (String)localObject), localArrayList, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.5
 * JD-Core Version:    0.7.0.1
 */