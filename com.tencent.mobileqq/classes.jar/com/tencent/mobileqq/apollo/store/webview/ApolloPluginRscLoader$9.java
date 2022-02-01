package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

class ApolloPluginRscLoader$9
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$9(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 0, paramInt2 + HardCodeUtil.a(2131700587));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + HardCodeUtil.a(2131700563));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + HardCodeUtil.a(2131700584));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.9
 * JD-Core Version:    0.7.0.1
 */