package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class PublicAccountImageCollectionPreloadManagerImpl$4
  implements Runnable
{
  PublicAccountImageCollectionPreloadManagerImpl$4(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveImageCollectionInfoToFile fileName =");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      localObject2 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
        return;
      }
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      i = 1;
      localObject1 = new FileOutputStream((File)localObject1, false);
    }
    catch (Exception localException1)
    {
      Object localObject1;
      int i;
      if (QLog.isColorLevel())
      {
        localObject2 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("write Exception ");
        localStringBuilder.append(localException1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      label144:
      if (QLog.isColorLevel())
      {
        localObject2 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("write file not found ");
        localStringBuilder.append(localFileNotFoundException);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
    }
    try
    {
      ((FileOutputStream)localObject1).write(this.jdField_a_of_type_ArrayOfByte);
    }
    catch (Exception localException2)
    {
      break label144;
    }
    i = 0;
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d(PublicAccountImageCollectionPreloadManagerImpl.access$400(), 2, "save ImageCollectionInfo write succ");
    }
    ((FileOutputStream)localObject1).close();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */