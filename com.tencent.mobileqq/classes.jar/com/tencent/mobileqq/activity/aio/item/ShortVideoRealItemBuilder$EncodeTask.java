package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import vgp;

public class ShortVideoRealItemBuilder$EncodeTask
  extends AsyncTask
{
  long jdField_a_of_type_Long = 0L;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public ShortVideoRealItemBuilder$EncodeTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoRealItemBuilder", 2, "[" + paramMessageForShortVideo.uniseq + "]:content EncodeTask constructor, mMessageForShortVideo = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoRealItemBuilder", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + "]:content EncodeTask doInBackground");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.p("AutoMonitor", "ShortVideoUpload_tag, compress_start_time = " + this.jdField_a_of_type_Long);
    long l1 = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return Integer.valueOf(7);
    }
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return Integer.valueOf(7);
    }
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (FileUtils.b(localMessageForShortVideo.videoFileName))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
      }
      return Integer.valueOf(5);
    }
    Object localObject2 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject2 != null) {
      ((QQAppInterface)localObject2).getHwEngine().preConnect();
    }
    LogTag.a();
    localObject1 = new EncodeThread((Context)localObject1, new vgp(Looper.getMainLooper()), localMessageForShortVideo.mVideoFileSourceDir, null, null);
    ((EncodeThread)localObject1).a(false);
    ((EncodeThread)localObject1).run();
    localObject2 = ((EncodeThread)localObject1).jdField_a_of_type_JavaLangString;
    LogTag.a("ShortVideoRealItemBuilder", "EncodeThread");
    if (!FileUtils.b((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "EncodeTask videoPath not exist,videoPath " + (String)localObject2);
      }
      return Integer.valueOf(8);
    }
    localObject1 = new File((String)localObject2);
    long l2 = ((File)localObject1).length();
    if (l2 == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "mVideoSize = 0");
      }
      return Integer.valueOf(8);
    }
    try
    {
      localObject1 = new FileInputStream((File)localObject1);
      if (localObject1 != null)
      {
        localObject1 = HexUtil.bytes2HexStr(MD5.toMD5Byte((InputStream)localObject1, l2));
        paramVarArgs = (Void[])localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject1);
          }
          return Integer.valueOf(5);
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      if (0 != 0)
      {
        str = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l2));
        paramVarArgs = str;
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str);
          }
          return Integer.valueOf(5);
        }
      }
    }
    finally
    {
      String str;
      if (0 != 0)
      {
        str = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l2));
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoRealItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str);
          }
          return Integer.valueOf(5);
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    this.jdField_b_of_type_JavaLangString = ((String)localObject2);
    localMessageForShortVideo.videoFileSize = ((int)l2);
    if (FileUtils.b(localMessageForShortVideo.mThumbFilePath))
    {
      paramVarArgs = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (!paramVarArgs.equals(localMessageForShortVideo.mThumbFilePath))
      {
        if (!FileUtils.c(paramVarArgs, localMessageForShortVideo.mThumbFilePath)) {
          return Integer.valueOf(5);
        }
        localMessageForShortVideo.mThumbFilePath = paramVarArgs;
      }
    }
    l1 = SystemClock.uptimeMillis() - l1;
    if (ShortVideoUploadABTest.a()) {
      ShortVideoUploadABTest.jdField_a_of_type_Long = l1;
    }
    com.tencent.mobileqq.transfile.ShortVideoPresendStats.jdField_a_of_type_Long = l1;
    return Integer.valueOf(1);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject1;
    Object localObject2;
    if (paramInteger.intValue() == 1) {
      if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        paramInteger = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (paramInteger == null) {
          break label226;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        ((MessageForShortVideo)localObject1).md5 = this.jdField_a_of_type_JavaLangString;
        localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
        if (!this.jdField_b_of_type_JavaLangString.equals(localObject2))
        {
          FileUtils.c(this.jdField_b_of_type_JavaLangString, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoRealItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject2);
          }
        }
        ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject2);
        ((MessageForShortVideo)localObject1).serial();
        if (!(localObject1 instanceof MessageForDevLittleVideo)) {
          break label275;
        }
      }
    }
    label275:
    for (int i = 4;; i = 2)
    {
      paramInteger.a().a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
      localObject2 = ShortVideoBusiManager.a(0, i);
      localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
      ((ShortVideoUploadInfo)localObject1).a = false;
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramInteger);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      QLog.p("AutoMonitor", "ShortVideoUpload_tag, [3]stepCompress_cost=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      label226:
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.i("ShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoRealItemBuilder", 2, "Error code " + paramInteger);
      return;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.EncodeTask
 * JD-Core Version:    0.7.0.1
 */