package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.CmShowRscDownloader.OnRscDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ApolloPluginRscLoader$6
  implements CmShowRscDownloader.OnRscDownLoadListener
{
  ApolloPluginRscLoader$6(ApolloPluginRscLoader paramApolloPluginRscLoader, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<CmShowRscCacheManagerImpl.IdolRscItem> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = ApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(paramString1, 0, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700574));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(paramString1, 2, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700573));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(paramString1, 2, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700568));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.6
 * JD-Core Version:    0.7.0.1
 */