package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class AIOImageProviderService$OfflineFileObserver
  extends FMObserver
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public AIOImageProviderService$OfflineFileObserver(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ThumbnailInfo paramThumbnailInfo)
  {
    long l = paramThumbnailInfo.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if ((localFileManagerEntity == null) || (localIAIOImageProviderCallBack == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + localFileManagerEntity + "] callback[" + localIAIOImageProviderCallBack + "]");
      return;
    }
    int i = 18;
    if (paramThumbnailInfo.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (FileUtil.a(paramThumbnailInfo.jdField_b_of_type_JavaLangString))
    {
      localIAIOImageProviderCallBack.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramThumbnailInfo.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramThumbnailInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    paramThumbnailInfo = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramThumbnailInfo = (ThumbnailInfo)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localIAIOImageProviderCallBack.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramThumbnailInfo, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  public void a(ThumbnailInfo paramThumbnailInfo, int paramInt)
  {
    long l = paramThumbnailInfo.a;
    paramThumbnailInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if ((paramThumbnailInfo == null) || (localIAIOImageProviderCallBack == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramThumbnailInfo + "] callback[" + localIAIOImageProviderCallBack + "]");
      return;
    }
    localIAIOImageProviderCallBack.a(paramThumbnailInfo.uniseq, paramThumbnailInfo.status, 18, paramInt, paramThumbnailInfo.fileSize, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if ((paramString == null) || (localIAIOImageProviderCallBack == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString + "] callback[" + localIAIOImageProviderCallBack + "]");
    }
    while (paramString.nFileType != 0) {
      return;
    }
    localIAIOImageProviderCallBack.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if ((paramString1 == null) || (localIAIOImageProviderCallBack == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString1 + "] callback[" + localIAIOImageProviderCallBack + "]");
    }
    label217:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
        if (paramString2 == null) {
          break label217;
        }
        FileManagerUtil.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.OfflineFileObserver
 * JD-Core Version:    0.7.0.1
 */