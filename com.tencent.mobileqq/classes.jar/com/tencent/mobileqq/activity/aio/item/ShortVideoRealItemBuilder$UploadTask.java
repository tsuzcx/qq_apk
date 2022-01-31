package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import aweg;
import awey;
import awfo;
import awrn;
import bace;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {}
    MessageForShortVideo localMessageForShortVideo;
    Object localObject1;
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder;
    Object localObject2;
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
              localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
              localObject1 = localMessageForShortVideo.videoFileName;
              localShortVideoRealItemBuilder = (ShortVideoRealItemBuilder)this.c.get();
              if (!bace.b((String)localObject1)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
              }
            } while (localShortVideoRealItemBuilder == null);
            ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, localMessageForShortVideo.uniseq);
            return;
            if (bace.b(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file is null!");
            }
          } while (localShortVideoRealItemBuilder == null);
          ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, localMessageForShortVideo.uniseq);
          return;
          localObject1 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localObject1 != null) {
            ((QQAppInterface)localObject1).getHwEngine().preConnect();
          }
          l = new File(this.jdField_a_of_type_JavaLangString).length();
          if (l != 0L) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "uploadTask file mVideoSize = 0");
          }
        } while (localShortVideoRealItemBuilder == null);
        ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, localMessageForShortVideo.uniseq);
        return;
        if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoRealItemBuilder", 2, "process videoMd5 is empty, videoMd5: " + localMessageForShortVideo.md5);
        }
      } while (localShortVideoRealItemBuilder == null);
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, localMessageForShortVideo.uniseq);
      return;
      localMessageForShortVideo.videoFileSize = ((int)l);
      if (!bace.b(localMessageForShortVideo.mThumbFilePath)) {
        break;
      }
      localObject2 = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (((String)localObject2).equals(localMessageForShortVideo.mThumbFilePath)) {
        break;
      }
    } while (!bace.c((String)localObject2, localMessageForShortVideo.mThumbFilePath));
    localMessageForShortVideo.mThumbFilePath = ((String)localObject2);
    if (localObject1 != null)
    {
      localObject2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (!this.jdField_a_of_type_JavaLangString.equals(localObject2))
      {
        bace.c(this.jdField_a_of_type_JavaLangString, (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject2);
        }
      }
      localMessageForShortVideo.videoFileName = ((String)localObject2);
      localMessageForShortVideo.serial();
      if (!(localMessageForShortVideo instanceof MessageForDevLittleVideo)) {
        break label606;
      }
    }
    label606:
    for (int i = 4;; i = 2)
    {
      ((QQAppInterface)localObject1).a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      localObject2 = aweg.a(0, i);
      awfo localawfo = aweg.a(localMessageForShortVideo, (awey)localObject2);
      localawfo.a = false;
      ((awey)localObject2).a(localawfo);
      aweg.a((awey)localObject2, (QQAppInterface)localObject1);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "[" + localMessageForShortVideo.uniseq + "]mMessageForShortVideo = " + localMessageForShortVideo + "\n |- upload cost:" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000.0D);
      }
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      awrn.a(BaseApplicationImpl.getContext()).a((String)localObject1, "actShortVideoGenerateDuration", true, 0L, 0L, ShortVideoRealItemBuilder.a(), "");
      if (localShortVideoRealItemBuilder == null) {
        break;
      }
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, localMessageForShortVideo.uniseq);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask
 * JD-Core Version:    0.7.0.1
 */