package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$2
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloPluginRscLoader$2(ApolloPluginRscLoader paramApolloPluginRscLoader, String paramString1, File paramFile, JSONArray paramJSONArray, int[] paramArrayOfInt, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject, 6, str, paramInt);
      this.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.b, HardCodeUtil.a(2131700582), this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, this.jdField_a_of_type_ArrayOfInt, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.2
 * JD-Core Version:    0.7.0.1
 */