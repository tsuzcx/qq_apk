package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

class ApolloPluginRscLoader$6
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$6(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(HardCodeUtil.a(2131700728));
        paramString.a(paramArrayOfInt, 0, localStringBuilder.toString());
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(HardCodeUtil.a(2131700704));
      paramString.a(paramArrayOfInt, 2, localStringBuilder.toString());
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(HardCodeUtil.a(2131700725));
    paramString.a(paramArrayOfInt, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.6
 * JD-Core Version:    0.7.0.1
 */