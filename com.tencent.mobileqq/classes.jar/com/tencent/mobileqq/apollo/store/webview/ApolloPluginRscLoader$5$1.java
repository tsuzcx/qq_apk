package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ApolloPluginRscLoader$5$1
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$5$1(ApolloPluginRscLoader.5 param5, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_Int + HardCodeUtil.a(2131700577));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_Int + HardCodeUtil.a(2131700588));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader$5.jdField_a_of_type_Int + HardCodeUtil.a(2131700585));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.5.1
 * JD-Core Version:    0.7.0.1
 */