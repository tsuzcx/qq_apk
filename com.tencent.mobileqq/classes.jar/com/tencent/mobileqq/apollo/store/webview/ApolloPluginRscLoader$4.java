package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ApolloPluginRscLoader$4
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$4(ApolloPluginRscLoader paramApolloPluginRscLoader, int[] paramArrayOfInt, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramString1 = ((CmShowRscCacheManagerImpl)QRoute.api(ICmShowRscCacheManager.class)).getRscItem(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        int k = paramString1.b;
        if (paramString1.a())
        {
          j = 0;
          label84:
          paramString1 = ApolloPluginRscLoader.a(paramList, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label84;
        paramString1 = ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700590), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.4
 * JD-Core Version:    0.7.0.1
 */