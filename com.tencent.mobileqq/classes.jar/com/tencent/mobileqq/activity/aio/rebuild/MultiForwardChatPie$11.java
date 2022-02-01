package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.qphone.base.util.QLog;

class MultiForwardChatPie$11
  extends FMObserver
{
  MultiForwardChatPie$11(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (MultiForwardChatPie.f(this.a) != null) {
      MultiForwardChatPie.f(this.a).notifyDataSetChanged();
    }
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
        this.a.d.getFileManagerDataCenter().c(localFileManagerEntity);
        if (MultiForwardChatPie.f(this.a) != null) {
          MultiForwardChatPie.f(this.a).notifyDataSetChanged();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (MultiForwardChatPie.f(this.a) != null) {
      MultiForwardChatPie.f(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("OnFileTransferEnd : isSuccess[");
      paramString2.append(paramBoolean);
      paramString2.append("], uniseq[");
      paramString2.append(paramLong1);
      paramString2.append("], nSessionId[");
      paramString2.append(paramLong2);
      paramString2.append(paramString1);
      paramString2.append("], peerType[");
      paramString2.append(paramInt1);
      paramString2.append("]");
      QLog.d("MultiForwardActivity", 2, paramString2.toString());
    }
    if (MultiForwardChatPie.f(this.a) != null) {
      MultiForwardChatPie.f(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.11
 * JD-Core Version:    0.7.0.1
 */