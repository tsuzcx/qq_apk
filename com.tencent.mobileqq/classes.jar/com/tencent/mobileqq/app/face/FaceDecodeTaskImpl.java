package com.tencent.mobileqq.app.face;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FaceDecodeTaskImpl
  extends FaceDecodeTask
{
  private static final String TAG = "Q.qqhead.FaceDecodeTaskImpl";
  AppInterface app;
  
  public FaceDecodeTaskImpl(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.app = paramAppInterface;
  }
  
  protected void doDecodeBitmap()
  {
    this.faceInfo.a(FaceInfo.p);
    for (;;)
    {
      try
      {
        boolean bool = isFaceNotNeedDecode();
        if (!bool) {
          continue;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Pair localPair;
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localOutOfMemoryError);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          if (handler == null) {
            continue;
          }
          handler.sendMessage(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException3);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          if (handler == null) {
            continue;
          }
          handler.sendMessage(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException4)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException4);
          return;
        }
      }
      finally
      {
        this.faceInfo.a(FaceInfo.q);
      }
      try
      {
        if (handler != null) {
          handler.sendMessage(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException1);
        return;
      }
    }
    if (this.faceInfo.jdField_a_of_type_Int != 101)
    {
      localPair = ((IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label355;
      }
      this.faceInfo.jdField_b_of_type_Byte = 1;
      FaceDecoder.requestDownloadFace(this.app, this.faceInfo);
    }
    for (;;)
    {
      for (;;)
      {
        this.bitmap = ((IQQAvatarCompatibleService)this.app.getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, (byte)this.faceInfo.c, this.faceInfo.d, false, this.faceInfo.a(), this.faceInfo.jdField_b_of_type_Int);
        if ((QLog.isColorLevel()) && (this.bitmap == null)) {
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString);
        }
        this.faceInfo.a(FaceInfo.q);
        try
        {
          if (handler == null) {
            break;
          }
          handler.sendMessage(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException2);
          return;
        }
      }
      label355:
      if ((this.faceInfo.jdField_a_of_type_Boolean) && (localException2 != null) && ((this.faceInfo.jdField_a_of_type_Int == 1) || (this.faceInfo.jdField_a_of_type_Int == 32)) && (((IQQDynamicAvatarService)this.app.getRuntimeService(IQQDynamicAvatarService.class, "")).isNeed2UpdateSettingInfo(this.faceInfo, (Setting)localException2.second, this.faceInfo.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDecodeTaskImpl", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
        }
        this.faceInfo.jdField_b_of_type_Byte = 1;
        FaceDecoder.requestDownloadFace(this.app, this.faceInfo);
      }
    }
    try
    {
      if (handler != null) {
        handler.sendMessage(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
      }
      throw localObject;
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localException5);
      }
    }
  }
  
  protected boolean isExpired()
  {
    return this.app == null;
  }
  
  public boolean isFaceNotNeedDecode()
  {
    Object localObject;
    if ((this.faceInfo.jdField_a_of_type_Int == 101) || (this.faceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (IDiscussionHandlerService)this.app.getRuntimeService(IDiscussionHandlerService.class, "");
      if (this.faceInfo.jdField_a_of_type_Int == 1001)
      {
        this.bitmap = ((IDiscussionHandlerService)localObject).getDiscussionFaceIcon(AvatarUtil.c(this.faceInfo.jdField_a_of_type_JavaLangString), false);
        this.needDownload = false;
      }
    }
    label286:
    label347:
    do
    {
      IQQAvatarDataService localIQQAvatarDataService;
      String str;
      do
      {
        return true;
        this.bitmap = ((IDiscussionHandlerService)localObject).getDiscussionFaceIcon(this.faceInfo.jdField_a_of_type_JavaLangString, false);
        break;
        if ((this.faceInfo.jdField_a_of_type_Int != 4) && (this.faceInfo.jdField_a_of_type_Int != 113)) {
          break label347;
        }
        localObject = (IHotChatService)this.app.getRuntimeService(IHotChatService.class, "");
        if (!((IHotChatService)localObject).isHotChat(this.faceInfo.jdField_a_of_type_JavaLangString)) {
          break label286;
        }
        localIQQAvatarDataService = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
        str = localIQQAvatarDataService.getFaceBitmapCacheKey(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, (byte)this.faceInfo.c, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d, false);
        this.bitmap = localIQQAvatarDataService.getBitmapFromCache(str);
      } while (this.bitmap != null);
      int i = ((IHotChatService)localObject).getHotChatDrawableID(this.faceInfo.jdField_a_of_type_JavaLangString, this.app);
      this.bitmap = BaseImageUtil.a(BaseApplication.getContext().getResources(), i);
      localIQQAvatarDataService.putBitmapToCache(str, this.bitmap, (byte)1);
      return true;
      if (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.faceInfo.jdField_a_of_type_JavaLangString))
      {
        this.bitmap = ((ITroopHandlerService)this.app.getRuntimeService(ITroopHandlerService.class, "")).getGroupFaceIcon(this.faceInfo.jdField_a_of_type_JavaLangString, false);
        this.needDownload = false;
        return true;
      }
      localObject = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
      if ((Setting)((IQQAvatarDataService)localObject).getQQHeadSetting(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int).second != null) {
        break label442;
      }
      this.needDownload = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.faceInfo.toString());
    return true;
    label442:
    if (!((IQQAvatarDataService)localObject).isFaceFileExist(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d)) {}
    for (boolean bool = true;; bool = false)
    {
      this.needDownload = bool;
      if (!this.needDownload) {
        break label537;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.faceInfo.toString());
      return true;
    }
    label537:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTaskImpl
 * JD-Core Version:    0.7.0.1
 */