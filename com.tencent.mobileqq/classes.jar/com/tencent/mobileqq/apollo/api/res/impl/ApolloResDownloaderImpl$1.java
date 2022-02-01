package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class ApolloResDownloaderImpl$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResDownloaderImpl$1(ApolloResDownloaderImpl paramApolloResDownloaderImpl, int[] paramArrayOfInt, ApolloManagerServiceImpl paramApolloManagerServiceImpl, int paramInt, AppRuntime paramAppRuntime, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    File localFile;
    if (paramBoolean) {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        paramArrayOfInt = new File(ApolloResDownloaderImpl.getRealResDir(1, paramInt1), "dress.zip");
        localFile = new File(ApolloResDownloaderImpl.getRealResDir(1, paramInt1), System.currentTimeMillis() + "dress.zip");
        FileUtils.a(paramArrayOfInt, localFile);
        if (localFile.exists()) {
          if (paramInt1 != 0) {
            paramArrayOfInt = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/";
          }
        }
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          localStringBuilder = new StringBuilder();
        }
        catch (Exception paramArrayOfInt)
        {
          StringBuilder localStringBuilder;
          int[] arrayOfInt;
          int j;
          FileUtils.a(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          continue;
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          FileUtils.a(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener.a(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
          return;
        }
        try
        {
          new File(paramArrayOfInt).mkdirs();
          arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl.readRoleDefaultDressIds(paramInt1);
          j = ZipUtils.unZipFiles(localFile, paramArrayOfInt, new ApolloResDownloaderImpl.1.1(this, localStringBuilder, paramArrayOfInt));
          if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          {
            int k = arrayOfInt.length;
            int i = 0;
            if (i < k)
            {
              int m = arrayOfInt[i];
              ApolloResDownloaderImpl.saveResTimestamp(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl, 2, m);
              i += 1;
              continue;
              paramArrayOfInt = ApolloConstant.a + "/def/dress/";
              continue;
            }
          }
          FileUtils.a(localFile);
          localStringBuilder.append(", unzipRet: ").append(j);
          QLog.d("ApolloResDownloader", 1, "downloadApolloResOrder succ roleId: " + this.jdField_a_of_type_Int + ", unzipRoleDress: " + localStringBuilder.toString() + ", uin: " + paramString);
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl.downloadApolloRes(this.jdField_a_of_type_MqqAppAppRuntime, paramString, this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
            return;
          }
        }
        finally {}
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener.a(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */