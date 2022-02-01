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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class FileAssistantChatHelper$MyFMObserver
  extends FMObserver
{
  private FileAssistantChatHelper$MyFMObserver(FileAssistantChatHelper paramFileAssistantChatHelper) {}
  
  protected void a()
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt);
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.l(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      FileManagerUtil.l(paramString);
    }
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      return;
    }
    if ((paramThumbnailInfo.c instanceof FileManagerEntity))
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.c;
      if ((paramThumbnailInfo.d != null) && (paramThumbnailInfo.d.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.d;
        FileAssistantChatHelper.b(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        FileAssistantChatHelper.a(this.a).bt();
        return;
      }
      if (localFileManagerEntity.thumbInvalidCode == 1)
      {
        FileAssistantChatHelper.b(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        FileAssistantChatHelper.a(this.a).bt();
      }
    }
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileAssistantChatHelper.a(this.a).bt();
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnFileTransferEnd : isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]");
      QLog.d("FileAssistantChatHelper<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramString1 = FileAssistantChatHelper.b(this.a).getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6))
    {
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt2)) {
        if (paramBoolean)
        {
          ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(FileAssistantChatHelper.b(this.a), FileAssistantChatHelper.a(this.a).aX(), AIOUtils.a(FileAssistantChatHelper.a(this.a).e));
        }
        else if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips())
        {
          ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(FileAssistantChatHelper.b(this.a));
        }
        else
        {
          if (!TextUtils.isEmpty(paramString2)) {
            QQToast.makeText(FileAssistantChatHelper.b(this.a).getApp(), paramString2, 1).show(AIOUtils.a(FileAssistantChatHelper.a(this.a).e));
          } else {
            QQToast.makeText(FileAssistantChatHelper.b(this.a).getApp(), 2131889760, 1).show(AIOUtils.a(FileAssistantChatHelper.a(this.a).e));
          }
          ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt2);
        }
      }
    }
    else if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(FileAssistantChatHelper.a(this.a).ah.b)))
    {
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt2);
    }
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void b()
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void c()
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
  
  protected void d()
  {
    FileAssistantChatHelper.a(this.a).bt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileAssistantChatHelper.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */