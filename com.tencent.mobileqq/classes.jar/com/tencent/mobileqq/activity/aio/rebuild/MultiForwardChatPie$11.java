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
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (MultiForwardChatPie.a(this.a) != null) {
      MultiForwardChatPie.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramThumbnailInfo.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      } while ((paramThumbnailInfo.b == null) || (paramThumbnailInfo.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
      this.a.a.getFileManagerDataCenter().c(localFileManagerEntity);
    } while (MultiForwardChatPie.a(this.a) == null);
    MultiForwardChatPie.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (MultiForwardChatPie.a(this.a) != null) {
      MultiForwardChatPie.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (MultiForwardChatPie.a(this.a) != null) {
      MultiForwardChatPie.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.11
 * JD-Core Version:    0.7.0.1
 */