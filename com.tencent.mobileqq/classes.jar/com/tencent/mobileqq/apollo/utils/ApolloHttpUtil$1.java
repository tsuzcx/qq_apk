package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

final class ApolloHttpUtil$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloHttpUtil$1(String paramString, String[] paramArrayOfString, ApolloHttpResponseCallback paramApolloHttpResponseCallback) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, "fakeResource3DUrlRequest onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramArrayOfInt = new File(this.jdField_a_of_type_JavaLangString);
      if (paramArrayOfInt.exists()) {
        try
        {
          paramString = ApolloHttpUtil.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          if (ApolloHttpUtil.a(this.jdField_a_of_type_JavaLangString))
          {
            paramArrayOfInt = ApolloHttpUtil.a(paramArrayOfInt, paramString);
            this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback.a(0, paramString, paramArrayOfInt);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest onDownLoadFinish retHeader:", paramString });
            return;
            this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback.a(0, paramString, ApolloRender.readStream(new FileInputStream(paramArrayOfInt)));
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback.a(-1, null, null);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloHttpUtil", 1, paramString, new Object[0]);
          return;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback.a(-1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil.1
 * JD-Core Version:    0.7.0.1
 */