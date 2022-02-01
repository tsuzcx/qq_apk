package com.tencent.mobileqq.app.face;

import android.util.Pair;
import antl;
import aoep;
import aqeq;
import bheg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FaceDecodeTaskImpl
  extends FaceDecodeTask
{
  private static final String TAG = "Q.qqhead.FaceDecodeTaskImpl";
  QQAppInterface app;
  
  public FaceDecodeTaskImpl(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramQQAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.app = paramQQAppInterface;
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
      localPair = this.app.getQQHeadSetting(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label331;
      }
      this.faceInfo.jdField_b_of_type_Byte = 1;
      FaceDecoder.requestDownloadFace(this.app, this.faceInfo);
    }
    for (;;)
    {
      for (;;)
      {
        this.bitmap = this.app.getFaceBitmap(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, (byte)this.faceInfo.c, this.faceInfo.d, false, this.faceInfo.a(), this.faceInfo.jdField_b_of_type_Int);
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
      label331:
      if ((this.faceInfo.jdField_a_of_type_Boolean) && (localException2 != null) && ((this.faceInfo.jdField_a_of_type_Int == 1) || (this.faceInfo.jdField_a_of_type_Int == 32)))
      {
        aqeq localaqeq = (aqeq)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
        if (localaqeq.a(localaqeq.b(this.faceInfo.jdField_b_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString), (Setting)localException2.second, this.faceInfo.jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
          }
          this.faceInfo.jdField_b_of_type_Byte = 1;
          FaceDecoder.requestDownloadFace(this.app, this.faceInfo);
        }
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
    return (this.app == null) || (this.app.isReleased);
  }
  
  public boolean isFaceNotNeedDecode()
  {
    Object localObject;
    if ((this.faceInfo.jdField_a_of_type_Int == 101) || (this.faceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (antl)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if (this.faceInfo.jdField_a_of_type_Int == 1001)
      {
        this.bitmap = ((antl)localObject).a(GroupIconHelper.a(this.faceInfo.jdField_a_of_type_JavaLangString), false);
        this.needDownload = false;
      }
    }
    label254:
    do
    {
      do
      {
        return true;
        this.bitmap = ((antl)localObject).a(this.faceInfo.jdField_a_of_type_JavaLangString, false);
        break;
        if ((this.faceInfo.jdField_a_of_type_Int != 4) && (this.faceInfo.jdField_a_of_type_Int != 113)) {
          break label302;
        }
        if (!((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.faceInfo.jdField_a_of_type_JavaLangString)) {
          break label254;
        }
        localObject = this.app.getFaceBitmapCacheKey(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, (byte)this.faceInfo.c, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d, false);
        this.bitmap = this.app.getBitmapFromCache((String)localObject);
      } while (this.bitmap != null);
      int i = HotChatManager.a(this.faceInfo.jdField_a_of_type_JavaLangString, this.app);
      this.bitmap = bheg.a(BaseApplicationImpl.sApplication.getResources(), i);
      this.app.putBitmapToCache((String)localObject, this.bitmap, (byte)1);
      return true;
      if (!TroopUtils.hasSetTroopHead(this.faceInfo.jdField_a_of_type_JavaLangString))
      {
        this.bitmap = ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.faceInfo.jdField_a_of_type_JavaLangString, false);
        this.needDownload = false;
        return true;
      }
      if ((Setting)this.app.getQQHeadSetting(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int).second != null) {
        break label383;
      }
      this.needDownload = true;
    } while (!QLog.isColorLevel());
    label302:
    QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.faceInfo.toString());
    return true;
    label383:
    if (!this.app.isFaceFileExist(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d)) {}
    for (boolean bool = true;; bool = false)
    {
      this.needDownload = bool;
      if (!this.needDownload) {
        break label480;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.faceInfo.toString());
      return true;
    }
    label480:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTaskImpl
 * JD-Core Version:    0.7.0.1
 */