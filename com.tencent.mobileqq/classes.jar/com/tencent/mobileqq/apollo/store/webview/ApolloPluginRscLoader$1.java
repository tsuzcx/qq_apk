package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$1(ApolloPluginRscLoader paramApolloPluginRscLoader, JSONArray paramJSONArray, File paramFile, AppInterface paramAppInterface, String paramString1, int[] paramArrayOfInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination onDownLoadFinish sucess:", Boolean.valueOf(paramBoolean) });
    label75:
    int i;
    if (paramInt1 > 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      if (ApolloUtilImpl.checkRoleRes(paramInt1))
      {
        paramInt2 = 0;
        paramString = ApolloPluginRscLoader.a(paramString, 1, String.valueOf(paramInt1), paramInt2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
      }
    }
    else
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
        break label147;
      }
      paramInt1 = 0;
      if (paramInt1 >= paramArrayOfInt.length) {
        break label147;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      i = paramArrayOfInt[paramInt1];
      if (!ApolloUtilImpl.checkDressRes(paramArrayOfInt[paramInt1])) {
        break label141;
      }
    }
    label141:
    for (paramInt2 = 0;; paramInt2 = 2)
    {
      paramString = ApolloPluginRscLoader.a(paramString, 2, String.valueOf(i), paramInt2);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
      paramInt1 += 1;
      break label75;
      paramInt2 = 2;
      break;
    }
    label147:
    if ((this.jdField_a_of_type_JavaIoFile != null) && (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, new ApolloPluginRscLoader.1.1(this));
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, 6, this.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length <= 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.b, HardCodeUtil.a(2131700566), this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, this.jdField_a_of_type_ArrayOfInt, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.1
 * JD-Core Version:    0.7.0.1
 */