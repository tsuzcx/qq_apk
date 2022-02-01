package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$8
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$8(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700570));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700569));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + HardCodeUtil.a(2131700591));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.8
 * JD-Core Version:    0.7.0.1
 */