package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
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
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination onDownLoadFinish sucess:", Boolean.valueOf(paramBoolean) });
    if (paramInt1 > 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      if (CMResUtil.b(paramInt1)) {
        paramInt2 = 0;
      } else {
        paramInt2 = 2;
      }
      paramString = ApolloPluginRscLoader.a(paramString, 1, String.valueOf(paramInt1), paramInt2);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        int i = paramArrayOfInt[paramInt1];
        if (CMResUtil.a(paramArrayOfInt[paramInt1])) {
          paramInt2 = 0;
        } else {
          paramInt2 = 2;
        }
        paramString = ApolloPluginRscLoader.a(paramString, 2, String.valueOf(i), paramInt2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
        paramInt1 += 1;
      }
    }
    paramString = this.jdField_a_of_type_JavaIoFile;
    if ((paramString != null) && (!paramString.exists()))
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, new ApolloPluginRscLoader.1.1(this));
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, 6, this.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
    }
    paramString = this.jdField_a_of_type_ArrayOfInt;
    if ((paramString != null) && (paramString.length > 0))
    {
      ApolloPluginRscLoader.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader, paramString, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.b, HardCodeUtil.a(2131700707), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.1
 * JD-Core Version:    0.7.0.1
 */