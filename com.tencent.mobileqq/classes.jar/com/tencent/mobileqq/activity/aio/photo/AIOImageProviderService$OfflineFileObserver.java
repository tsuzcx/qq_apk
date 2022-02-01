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
  private QQAppInterface b;
  
  public AIOImageProviderService$OfflineFileObserver(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    long l = paramThumbnailInfo.e;
    FileManagerEntity localFileManagerEntity = this.b.getFileManagerDataCenter().a(l);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((localFileManagerEntity != null) && (localIAIOImageProviderCallBack != null))
    {
      int i = 18;
      if (paramThumbnailInfo.f == 5) {
        i = 16;
      }
      if (FileUtil.d(paramThumbnailInfo.d))
      {
        localIAIOImageProviderCallBack.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramThumbnailInfo.d, false);
        this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramThumbnailInfo.d);
        return;
      }
      try
      {
        paramThumbnailInfo = new JSONObject();
        paramThumbnailInfo.put("errorType", "thumb_download");
        paramThumbnailInfo.put("errorCode", localFileManagerEntity.thumbInvalidCode);
        paramThumbnailInfo = paramThumbnailInfo.toString();
      }
      catch (JSONException paramThumbnailInfo)
      {
        paramThumbnailInfo.printStackTrace();
        paramThumbnailInfo = "";
      }
      localIAIOImageProviderCallBack.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramThumbnailInfo, false);
      this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
      return;
    }
    paramThumbnailInfo = new StringBuilder();
    paramThumbnailInfo.append("OnFileTransferProgress: error, entity[");
    paramThumbnailInfo.append(localFileManagerEntity);
    paramThumbnailInfo.append("] callback[");
    paramThumbnailInfo.append(localIAIOImageProviderCallBack);
    paramThumbnailInfo.append("]");
    QLog.i("AIOImageProviderService", 2, paramThumbnailInfo.toString());
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo, int paramInt)
  {
    long l = paramThumbnailInfo.e;
    paramThumbnailInfo = this.b.getFileManagerDataCenter().a(l);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((paramThumbnailInfo != null) && (localIAIOImageProviderCallBack != null))
    {
      localIAIOImageProviderCallBack.a(paramThumbnailInfo.uniseq, paramThumbnailInfo.status, 18, paramInt, paramThumbnailInfo.fileSize, false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFileTransferProgress: error, entity[");
    localStringBuilder.append(paramThumbnailInfo);
    localStringBuilder.append("] callback[");
    localStringBuilder.append(localIAIOImageProviderCallBack);
    localStringBuilder.append("]");
    QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.b.getFileManagerDataCenter().a(paramLong2);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((paramString != null) && (localIAIOImageProviderCallBack != null))
    {
      if (paramString.nFileType == 0) {
        localIAIOImageProviderCallBack.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFileTransferProgress: error, entity[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] callback[");
    localStringBuilder.append(localIAIOImageProviderCallBack);
    localStringBuilder.append("]");
    QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.b.getFileManagerDataCenter().a(paramLong2);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((paramString1 != null) && (localIAIOImageProviderCallBack != null))
    {
      if (paramBoolean)
      {
        if (paramString1.nFileType == 0)
        {
          localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.a.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
        if (paramString1.nFileType == 2)
        {
          if (this.a.x.contains(Long.valueOf(paramLong1)))
          {
            paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
            if (paramString2 != null) {
              FileManagerUtil.a(paramString2, paramString1.getFilePath());
            } else {
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
            }
            this.a.x.remove(Long.valueOf(paramLong1));
          }
          localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        }
      }
      else
      {
        if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
          paramString1.status = 16;
        }
        if (paramString1.nFileType == 0)
        {
          localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
          this.a.a(paramLong1, paramString1.status, 20, "I:E");
          return;
        }
        if (paramString1.nFileType == 2) {
          localIAIOImageProviderCallBack.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
        }
      }
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("OnFileTransferProgress: error, entity[");
    paramString2.append(paramString1);
    paramString2.append("] callback[");
    paramString2.append(localIAIOImageProviderCallBack);
    paramString2.append("]");
    QLog.i("AIOImageProviderService", 2, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.OfflineFileObserver
 * JD-Core Version:    0.7.0.1
 */