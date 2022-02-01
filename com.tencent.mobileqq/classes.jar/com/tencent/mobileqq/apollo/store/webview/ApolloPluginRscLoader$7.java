package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$7
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$7(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getApolloRsc onDownLoadFinish:");
      paramString.append(this.jdField_a_of_type_Int);
      paramString.append(" sucess:");
      paramString.append(paramBoolean);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
        paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(HardCodeUtil.a(2131700711));
        paramString.a(paramArrayOfInt, 0, localStringBuilder.toString());
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
      paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(HardCodeUtil.a(2131700710));
      paramString.a(paramArrayOfInt, 2, localStringBuilder.toString());
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloPluginRscLoader;
    paramArrayOfInt = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(HardCodeUtil.a(2131700732));
    paramString.a(paramArrayOfInt, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.7
 * JD-Core Version:    0.7.0.1
 */