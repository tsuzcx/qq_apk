package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class NearByFaceDecodeTask
  extends FaceDecodeTask
{
  AppInterface a;
  
  public NearByFaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.a = paramAppInterface;
  }
  
  private void a(IQQAvatarManagerService paramIQQAvatarManagerService, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    if (paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      switch (this.faceInfo.c)
      {
      }
    }
    for (paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.c(paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);; paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.a(paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50))
    {
      this.bitmap = paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap;
      paramIQQAvatarManagerService.putFaceToCache(this.faceInfo.a(), paramBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
      if (this.bitmap == null) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private boolean a(IQQAvatarManagerService paramIQQAvatarManagerService)
  {
    if (this.needDownload)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.faceInfo);
      }
      if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
        paramIQQAvatarManagerService.downloadFace(this.faceInfo);
      }
      return true;
    }
    String str = "stranger_" + Integer.toString(this.faceInfo.jdField_b_of_type_Int) + "_" + this.faceInfo.jdField_a_of_type_JavaLangString;
    Setting localSetting = paramIQQAvatarManagerService.getFaceSetting(str);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + str + ",faceinfo=" + this.faceInfo + ",setting=" + localSetting);
    }
    if (localSetting != null)
    {
      if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null)
      {
        if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dwTimestamp > localSetting.headImgTimestamp)
        {
          this.needDownload = true;
          paramIQQAvatarManagerService.downloadFace(this.faceInfo);
          return true;
        }
        if ((this.faceInfo.jdField_a_of_type_Boolean) && (((IQQDynamicAvatarService)this.a.getRuntimeService(IQQDynamicAvatarService.class, "nearby")).isNeed2UpdateSettingInfo(this.faceInfo, localSetting, this.faceInfo.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
          }
          this.needDownload = true;
          paramIQQAvatarManagerService.downloadFace(this.faceInfo);
          return true;
        }
      }
      else if (Math.abs(System.currentTimeMillis() - localSetting.updateTimestamp) > 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.faceInfo);
        }
        this.faceInfo.jdField_b_of_type_Byte = 1;
        ((FaceHandler)this.a.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).a(this.faceInfo);
      }
      return false;
    }
    this.needDownload = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.faceInfo);
    }
    if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
      paramIQQAvatarManagerService.downloadFace(this.faceInfo);
    }
    return true;
  }
  
  protected void doDecodeBitmap()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap bengin.faceInfo=" + this.faceInfo);
    }
    this.faceInfo.a(FaceInfo.p);
    for (;;)
    {
      try
      {
        IQQAvatarManagerService localIQQAvatarManagerService = (IQQAvatarManagerService)this.a.getRuntimeService(IQQAvatarManagerService.class, "nearby");
        if (!localIQQAvatarManagerService.isFaceFileExist(this.faceInfo))
        {
          bool = true;
          this.needDownload = bool;
          bool = a(localIQQAvatarManagerService);
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
        BitmapFactory.Options localOptions;
        int j;
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localOutOfMemoryError);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          FaceDecodeTask.sPendingResultList.add(this);
          if (FaceDecodeTask.handler == null) {
            continue;
          }
          FaceDecodeTask.handler.sendMessageAtFrontOfQueue(FaceDecodeTask.handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException3) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException3);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          FaceDecodeTask.sPendingResultList.add(this);
          if (FaceDecodeTask.handler == null) {
            continue;
          }
          FaceDecodeTask.handler.sendMessageAtFrontOfQueue(FaceDecodeTask.handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException4) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException4);
        return;
      }
      finally
      {
        this.faceInfo.a(FaceInfo.q);
      }
      try
      {
        FaceDecodeTask.sPendingResultList.add(this);
        if (FaceDecodeTask.handler != null) {
          FaceDecodeTask.handler.sendMessageAtFrontOfQueue(FaceDecodeTask.handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
        }
        return;
        bool = false;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException1);
        return;
      }
      localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
      BitmapManager.a(localException1.getFacePath(this.faceInfo), localOptions, localBitmapDecodeResult);
      if ((localBitmapDecodeResult.jdField_a_of_type_Int == 1) && (GlobalImageCache.a != null))
      {
        j = GlobalImageCache.a.size() * 3 / 4;
        GlobalImageCache.a.trimToSize(j);
      }
      i += 1;
      if ((i >= 2) || (localBitmapDecodeResult.jdField_a_of_type_Int != 1))
      {
        if ((QLog.isColorLevel()) || (localBitmapDecodeResult.jdField_a_of_type_Int != 0)) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.faceInfo + ",result=" + localBitmapDecodeResult.jdField_a_of_type_Int + ", bmp=" + localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        a(localException1, localBitmapDecodeResult);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          FaceDecodeTask.sPendingResultList.add(this);
          if (FaceDecodeTask.handler == null) {
            continue;
          }
          FaceDecodeTask.handler.sendMessageAtFrontOfQueue(FaceDecodeTask.handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException2) {}
        if (QLog.isColorLevel())
        {
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException2);
          return;
        }
      }
    }
    try
    {
      FaceDecodeTask.sPendingResultList.add(this);
      if (FaceDecodeTask.handler != null) {
        FaceDecodeTask.handler.sendMessageAtFrontOfQueue(FaceDecodeTask.handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
      }
      throw localObject;
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException5);
        }
      }
    }
  }
  
  protected boolean isExpired()
  {
    return this.a == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */