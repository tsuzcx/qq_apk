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
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_JavaIoFile.exists())
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        paramList = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_Int);
        paramString2.append(HardCodeUtil.a(2131700718));
        paramString1.a(paramList, 0, paramString2.toString());
        return;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      paramList = this.jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_Int);
      paramString2.append(HardCodeUtil.a(2131700729));
      paramString1.a(paramList, 2, paramString2.toString());
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    paramList = this.jdField_a_of_type_JavaLangString;
    paramString2 = new StringBuilder();
    paramString2.append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$9.jdField_a_of_type_Int);
    paramString2.append(HardCodeUtil.a(2131700726));
    paramString1.a(paramList, 2, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.9.1
 * JD-Core Version:    0.7.0.1
 */