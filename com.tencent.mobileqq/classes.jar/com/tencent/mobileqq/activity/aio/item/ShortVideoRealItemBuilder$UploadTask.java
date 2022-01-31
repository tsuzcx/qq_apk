package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  long jdField_b_of_type_Long = 0L;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  WeakReference c;
  
  public ShortVideoRealItemBuilder$UploadTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoRealItemBuilder paramShortVideoRealItemBuilder)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramShortVideoRealItemBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {}
    Object localObject1;
    Object localObject2;
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder;
    Object localObject3;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
              localObject2 = ((MessageForShortVideo)localObject1).videoFileName;
              localShortVideoRealItemBuilder = (ShortVideoRealItemBuilder)this.c.get();
              if (!FileUtils.b((String)localObject2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
              }
            } while (localShortVideoRealItemBuilder == null);
            ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder);
            return;
            if (FileUtils.b(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file is null!");
            }
          } while (localShortVideoRealItemBuilder == null);
          ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder);
          return;
          localObject2 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localObject2 != null) {
            ((QQAppInterface)localObject2).getHwEngine().preConnect();
          }
          l = new File(this.jdField_a_of_type_JavaLangString).length();
          if (l != 0L) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file mVideoSize = 0");
          }
        } while (localShortVideoRealItemBuilder == null);
        ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder);
        return;
        if (!TextUtils.isEmpty(((MessageForShortVideo)localObject1).md5)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "process videoMd5 is empty, videoMd5: " + ((MessageForShortVideo)localObject1).md5);
        }
      } while (localShortVideoRealItemBuilder == null);
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder);
      return;
      ((MessageForShortVideo)localObject1).videoFileSize = ((int)l);
      if (!FileUtils.b(((MessageForShortVideo)localObject1).mThumbFilePath)) {
        break;
      }
      localObject3 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      if (((String)localObject3).equals(((MessageForShortVideo)localObject1).mThumbFilePath)) {
        break;
      }
    } while (!FileUtils.c((String)localObject3, ((MessageForShortVideo)localObject1).mThumbFilePath));
    ((MessageForShortVideo)localObject1).mThumbFilePath = ((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      if (!this.jdField_a_of_type_JavaLangString.equals(localObject3))
      {
        FileUtils.c(this.jdField_a_of_type_JavaLangString, (String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject3);
        }
      }
      ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject3);
      ((MessageForShortVideo)localObject1).serial();
      if (!(localObject1 instanceof MessageForDevLittleVideo)) {
        break label581;
      }
    }
    label581:
    for (int i = 4;; i = 2)
    {
      ((QQAppInterface)localObject2).a().a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
      localObject3 = ShortVideoBusiManager.a(0, i);
      ShortVideoUploadInfo localShortVideoUploadInfo = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject3);
      localShortVideoUploadInfo.a = false;
      ((ShortVideoReq)localObject3).a(localShortVideoUploadInfo);
      ShortVideoBusiManager.a((ShortVideoReq)localObject3, (QQAppInterface)localObject2);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "[" + ((MessageForShortVideo)localObject1).uniseq + "]mMessageForShortVideo = " + localObject1 + "\n |- upload cost:" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000.0D);
      }
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      StatisticCollector.a(BaseApplicationImpl.getContext()).a((String)localObject1, "actShortVideoGenerateDuration", true, 0L, 0L, ShortVideoRealItemBuilder.a(), "");
      if (localShortVideoRealItemBuilder == null) {
        break;
      }
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask
 * JD-Core Version:    0.7.0.1
 */