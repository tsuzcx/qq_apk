package com.tencent.mobileqq.apollo.store.webview;

import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.CmShowRscDownloader;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.OnCheckContentListener;
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
    ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramContentUpdateCheckResult = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramContentUpdateCheckResult != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramContentUpdateCheckResult);
        }
        i += 1;
      }
      CmShowRscDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ApolloPluginRscLoader.3.1(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramContentUpdateCheckResult = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramContentUpdateCheckResult != null)
      {
        ApolloPluginRscLoader localApolloPluginRscLoader = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        int k = paramContentUpdateCheckResult.b;
        if (paramContentUpdateCheckResult.a())
        {
          j = 0;
          label177:
          paramContentUpdateCheckResult = ApolloPluginRscLoader.a(localApolloPluginRscLoader, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramContentUpdateCheckResult);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label177;
        paramContentUpdateCheckResult = ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramContentUpdateCheckResult);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700578), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.3
 * JD-Core Version:    0.7.0.1
 */