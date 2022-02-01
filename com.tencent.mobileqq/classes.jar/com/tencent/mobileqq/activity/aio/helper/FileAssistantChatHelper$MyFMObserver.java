package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;

class FileAssistantChatHelper$MyFMObserver
  extends FMObserver
{
  private FileAssistantChatHelper$MyFMObserver(FileAssistantChatHelper paramFileAssistantChatHelper) {}
  
  public void a()
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
    OpenWeiyunVipHelper.a(null, paramInt);
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.c(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      FileManagerUtil.c(paramString);
    }
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramThumbnailInfo.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
        FileAssistantChatHelper.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        FileAssistantChatHelper.a(this.a).bg();
        return;
      }
    } while (localFileManagerEntity.thumbInvalidCode != 1);
    FileAssistantChatHelper.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileAssistantChatHelper.a(this.a).bg();
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    OpenWeiyunVipHelper.a(null, paramInteger.intValue());
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileAssistantChatHelper<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = FileAssistantChatHelper.a(this.a).getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (ResponseHandler.a(paramInt2))
      {
        if (!paramBoolean) {
          break label158;
        }
        WeiyunSaveTipsFactory.a(FileAssistantChatHelper.a(this.a), FileAssistantChatHelper.a(this.a).a(), AIOUtils.a(FileAssistantChatHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
      }
    }
    for (;;)
    {
      FileAssistantChatHelper.a(this.a).bg();
      return;
      label158:
      if (ResponseHandler.b())
      {
        ResponseHandler.a(FileAssistantChatHelper.a(this.a));
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          QQToast.a(FileAssistantChatHelper.a(this.a).getApp(), paramString2, 1).b(AIOUtils.a(FileAssistantChatHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
        }
        for (;;)
        {
          OpenWeiyunVipHelper.a(null, paramInt2);
          break;
          QQToast.a(FileAssistantChatHelper.a(this.a).getApp(), 2131692732, 1).b(AIOUtils.a(FileAssistantChatHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(FileAssistantChatHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
        {
          FileManagerUtil.a(paramLong2, paramInt2, paramString2);
          OpenWeiyunVipHelper.a(null, paramInt2);
        }
      }
    }
  }
  
  public void b()
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void c()
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
  
  public void d()
  {
    FileAssistantChatHelper.a(this.a).bg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileAssistantChatHelper.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */