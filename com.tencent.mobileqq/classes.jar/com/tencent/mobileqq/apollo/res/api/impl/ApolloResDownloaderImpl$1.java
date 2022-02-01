package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class ApolloResDownloaderImpl$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResDownloaderImpl$1(ApolloResDownloaderImpl paramApolloResDownloaderImpl, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt, int[] paramArrayOfInt, ApolloManagerServiceImpl paramApolloManagerServiceImpl, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean)
    {
      paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener;
      if (paramArrayOfInt != null) {
        paramArrayOfInt.a(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("downloadApolloResOrder down load role fail id: ");
      paramArrayOfInt.append(this.jdField_a_of_type_Int);
      paramArrayOfInt.append(", uin:");
      paramArrayOfInt.append(paramString);
      QLog.e("[cmshow][ApolloResDownloader]", 1, paramArrayOfInt.toString());
      return;
    }
    if (ProcessUtil.a())
    {
      paramArrayOfInt = new File(CMGetResPathUtil.a(1, paramInt1), "dress.zip");
      Object localObject = CMGetResPathUtil.a(1, paramInt1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("dress.zip");
      localObject = new File((String)localObject, localStringBuilder.toString());
      FileUtils.copyFile(paramArrayOfInt, (File)localObject);
      if (((File)localObject).exists())
      {
        if (paramInt1 != 0) {
          paramArrayOfInt = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/";
        }
        try
        {
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append(ApolloConstant.a);
          paramArrayOfInt.append("/def/dress/");
          paramArrayOfInt = paramArrayOfInt.toString();
          localStringBuilder = new StringBuilder();
          try
          {
            new File(paramArrayOfInt).mkdirs();
            int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResDownloaderImpl.readRoleDefaultDressIds(paramInt1);
            int j = ZipUtils.unZipFiles((File)localObject, paramArrayOfInt, new ApolloResDownloaderImpl.1.1(this, localStringBuilder, paramArrayOfInt));
            if ((arrayOfInt != null) && (arrayOfInt.length > 0))
            {
              int k = arrayOfInt.length;
              int i = 0;
              while (i < k)
              {
                int m = arrayOfInt[i];
                ApolloResDownloaderImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl, 2, m);
                i += 1;
              }
            }
            FileUtils.deleteFile((File)localObject);
            localStringBuilder.append(", unzipRet: ");
            localStringBuilder.append(j);
            paramArrayOfInt = new StringBuilder();
            paramArrayOfInt.append("downloadApolloResOrder succ roleId: ");
            paramArrayOfInt.append(this.jdField_a_of_type_Int);
            paramArrayOfInt.append(", unzipRoleDress: ");
            paramArrayOfInt.append(localStringBuilder.toString());
            paramArrayOfInt.append(", uin: ");
            paramArrayOfInt.append(paramString);
            QLog.d("[cmshow][ApolloResDownloader]", 1, paramArrayOfInt.toString());
          }
          finally {}
          paramArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          FileUtils.deleteFile((File)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadApolloResOrder unZipFile file error resType->");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" error->");
          ((StringBuilder)localObject).append(paramArrayOfInt.getMessage());
          QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject).toString());
        }
        catch (Exception paramArrayOfInt)
        {
          FileUtils.deleteFile((File)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadApolloResOrder unZipFile file error resType->");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" error->");
          ((StringBuilder)localObject).append(paramArrayOfInt.getMessage());
          QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject).toString(), paramArrayOfInt);
        }
      }
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResDownloaderImpl.downloadApolloRes(this.jdField_a_of_type_MqqAppAppRuntime, paramString, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener, -1, paramArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
      return;
    }
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */