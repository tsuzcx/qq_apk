package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$10
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$10(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 0, HardCodeUtil.a(2131700564));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, HardCodeUtil.a(2131700593));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, HardCodeUtil.a(2131700575));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.10
 * JD-Core Version:    0.7.0.1
 */