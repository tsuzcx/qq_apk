package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$1$1
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$1$1(ApolloPluginRscLoader.1 param1) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject, 6, str, paramInt);
      this.a.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.a.b, HardCodeUtil.a(2131700567), this.a.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    ApolloPluginRscLoader.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, this.a.jdField_a_of_type_ArrayOfInt, this.a.b, this.a.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.1.1
 * JD-Core Version:    0.7.0.1
 */