package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class ShortVideoItemBuilder$12
  implements VideoPlayerCallback
{
  ShortVideoItemBuilder$12(ShortVideoItemBuilder paramShortVideoItemBuilder, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadComplete, id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (ShortVideoItemBuilder.c(this.b) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "onDownloadComplete , mListView is null.");
      }
      return;
    }
    Object localObject = AIOUtils.b(paramLong, ShortVideoItemBuilder.c(this.b).getAdapter());
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      if (((((MessageForShortVideo)localObject).fileType == 6) || (((MessageForShortVideo)localObject).fileType == 17) || (((MessageForShortVideo)localObject).fileType == 9)) && (((MessageForShortVideo)localObject).videoFileStatus != 2003))
      {
        ((MessageForShortVideo)localObject).videoFileStatus = 2003;
        ((MessageForShortVideo)localObject).transferedSize = 0;
        ((MessageForShortVideo)localObject).videoFileProgress = 100;
        ((MessageForShortVideo)localObject).serial();
        this.b.d.getMessageFacade().a(((MessageForShortVideo)localObject).frienduin, this.b.f.a, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
      }
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoopBack, id = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" ,position = ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong1));
    ShortVideoItemBuilder.a(this.b, (MessageForShortVideo)localObject, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ShortVideoItemBuilder.a(this.b, paramLong, paramInt1, paramInt2, paramInt3, paramString, this.a);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange , state = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msgUniseq=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , getAIOState() = ");
      localStringBuilder.append(this.b.g());
      QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    ShortVideoItemBuilder.a(this.b, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */