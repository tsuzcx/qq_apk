package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      paramInt = 0;
    } else {
      paramInt = 2;
    }
    localObject = ApolloPluginRscLoader.a((ApolloPluginRscLoader)localObject, 6, str, paramInt);
    this.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
    localObject = this.jdField_a_of_type_ArrayOfInt;
    if ((localObject != null) && (localObject.length > 0))
    {
      ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, (int[])localObject, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.b, HardCodeUtil.a(2131700723), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.2
 * JD-Core Version:    0.7.0.1
 */