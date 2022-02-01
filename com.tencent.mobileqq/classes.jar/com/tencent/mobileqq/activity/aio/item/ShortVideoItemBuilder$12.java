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
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, "onDownloadComplete, id = " + paramLong);
    }
    if (ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder) == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "onDownloadComplete , mListView is null.");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = AIOUtils.a(paramLong, ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder).getAdapter());
      } while (!(localObject instanceof MessageForShortVideo));
      localObject = (MessageForShortVideo)localObject;
    } while (((((MessageForShortVideo)localObject).fileType != 6) && (((MessageForShortVideo)localObject).fileType != 17) && (((MessageForShortVideo)localObject).fileType != 9)) || (((MessageForShortVideo)localObject).videoFileStatus == 2003));
    ((MessageForShortVideo)localObject).videoFileStatus = 2003;
    ((MessageForShortVideo)localObject).transferedSize = 0;
    ((MessageForShortVideo)localObject).videoFileProgress = 100;
    ((MessageForShortVideo)localObject).serial();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageForShortVideo)localObject).frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onLoopBack, id = " + paramLong1 + " ,position = " + paramLong2);
    }
    MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().a(Long.valueOf(paramLong1));
    ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder, localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder, paramLong, paramInt1, paramInt2, paramInt3, paramString, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong + " , getAIOState() = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.a());
    }
    ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */