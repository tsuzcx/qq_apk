package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class ShortVideoRealItemBuilder$UploadTask
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  long jdField_b_of_type_Long = 0L;
  WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  WeakReference<ShortVideoRealItemBuilder> c;
  
  public ShortVideoRealItemBuilder$UploadTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoRealItemBuilder paramShortVideoRealItemBuilder)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramShortVideoRealItemBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(long paramLong)
  {
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder = (ShortVideoRealItemBuilder)this.c.get();
    if (localShortVideoRealItemBuilder != null) {
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, paramLong);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    Object localObject1 = localMessageForShortVideo.videoFileName;
    Object localObject2 = (ShortVideoRealItemBuilder)this.c.get();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file is null!");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    localObject1 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).getHwEngine().preConnect();
    }
    long l = new File(this.jdField_a_of_type_JavaLangString).length();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file mVideoSize = 0");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (TextUtils.isEmpty(localMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("process videoMd5 is empty, videoMd5: ");
        ((StringBuilder)localObject1).append(localMessageForShortVideo.md5);
        QLog.e("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    localMessageForShortVideo.videoFileSize = ((int)l);
    if (FileUtils.fileExistsAndNotEmpty(localMessageForShortVideo.mThumbFilePath))
    {
      localObject2 = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (!((String)localObject2).equals(localMessageForShortVideo.mThumbFilePath))
      {
        if (!FileUtils.rename(localMessageForShortVideo.mThumbFilePath, (String)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "process mThumbFilePath error!");
          }
          a(localMessageForShortVideo.uniseq);
          return;
        }
        localMessageForShortVideo.mThumbFilePath = ((String)localObject2);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = SVUtils.a(localMessageForShortVideo, "mp4");
      if (!this.jdField_a_of_type_JavaLangString.equals(localObject2))
      {
        FileUtils.rename(this.jdField_a_of_type_JavaLangString, (String)localObject2);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onPostExecute destVideoPath ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.i("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject3).toString());
        }
      }
      localMessageForShortVideo.videoFileName = ((String)localObject2);
      localMessageForShortVideo.serial();
      int i;
      if ((localMessageForShortVideo instanceof MessageForDevLittleVideo)) {
        i = 4;
      } else {
        i = 2;
      }
      ((QQAppInterface)localObject1).getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      localObject2 = SVBusiUtil.a(0, i);
      Object localObject3 = ShortVideoBusiManager.a(localMessageForShortVideo, (ShortVideoReq)localObject2);
      ((ShortVideoUploadInfo)localObject3).b = false;
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject3);
      ShortVideoBusiManager.a((ShortVideoReq)localObject2, (QQAppInterface)localObject1);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(localMessageForShortVideo.uniseq);
        ((StringBuilder)localObject2).append("]mMessageForShortVideo = ");
        ((StringBuilder)localObject2).append(localMessageForShortVideo);
        ((StringBuilder)localObject2).append("\n |- upload cost:");
        double d = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        Double.isNaN(d);
        ((StringBuilder)localObject2).append(d / 1000.0D);
        QLog.i("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject1, "actShortVideoGenerateDuration", true, 0L, 0L, ShortVideoRealItemBuilder.a(), "");
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask
 * JD-Core Version:    0.7.0.1
 */