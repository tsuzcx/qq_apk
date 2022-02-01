import AvatarInfo.QQHeadInfo;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceDecodeTask.DecodeCompletionListener;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class anhw
  extends FaceDecodeTask
{
  NearbyAppInterface a;
  
  public anhw(NearbyAppInterface paramNearbyAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramNearbyAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.a = paramNearbyAppInterface;
  }
  
  private void a(anho paramanho, bfpy parambfpy)
  {
    if (parambfpy.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      switch (this.faceInfo.c)
      {
      }
    }
    for (parambfpy.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.c(parambfpy.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);; parambfpy.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a(parambfpy.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50))
    {
      this.bitmap = parambfpy.jdField_a_of_type_AndroidGraphicsBitmap;
      paramanho.a(this.faceInfo.a(), parambfpy.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
      if (this.bitmap == null) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private boolean a(anho paramanho)
  {
    if (this.needDownload)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.faceInfo);
      }
      if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
        paramanho.a(this.faceInfo);
      }
      return true;
    }
    Object localObject = "stranger_" + Integer.toString(this.faceInfo.jdField_b_of_type_Int) + "_" + this.faceInfo.jdField_a_of_type_JavaLangString;
    Setting localSetting = paramanho.a((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + (String)localObject + ",faceinfo=" + this.faceInfo + ",setting=" + localSetting);
    }
    if (localSetting != null)
    {
      if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null)
      {
        if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dwTimestamp > localSetting.headImgTimestamp)
        {
          this.needDownload = true;
          paramanho.a(this.faceInfo);
          return true;
        }
        if (this.faceInfo.jdField_a_of_type_Boolean)
        {
          localObject = (apbm)this.a.getManager(180);
          if (((apbm)localObject).a(((apbm)localObject).a(this.faceInfo.jdField_b_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString), localSetting, this.faceInfo.jdField_a_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
            }
            this.needDownload = true;
            paramanho.a(this.faceInfo);
            return true;
          }
        }
      }
      else if (Math.abs(System.currentTimeMillis() - localSetting.updateTimestamp) > 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.faceInfo);
        }
        this.faceInfo.jdField_b_of_type_Byte = 1;
        ((anhm)this.a.a(4)).a(this.faceInfo);
      }
      return false;
    }
    this.needDownload = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.faceInfo);
    }
    if (this.faceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
      paramanho.a(this.faceInfo);
    }
    return true;
  }
  
  public void doDecodeBitmap()
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
        anho localanho = (anho)this.a.getManager(216);
        if (!localanho.a(this.faceInfo))
        {
          bool = true;
          this.needDownload = bool;
          bool = a(localanho);
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        bfpy localbfpy;
        BitmapFactory.Options localOptions;
        NearbyAppInterface localNearbyAppInterface;
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.faceInfo.jdField_a_of_type_JavaLangString, localOutOfMemoryError);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          sPendingResultList.add(this);
          if (handler == null) {
            continue;
          }
          handler.sendMessageAtFrontOfQueue(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
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
          sPendingResultList.add(this);
          if (handler == null) {
            continue;
          }
          handler.sendMessageAtFrontOfQueue(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
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
        sPendingResultList.add(this);
        if (handler != null) {
          handler.sendMessageAtFrontOfQueue(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
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
      localbfpy = new bfpy();
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = FaceConstant.FACE_BITMAP_CONFIG;
      bfpx.a(localException1.a(this.faceInfo), localOptions, localbfpy);
      if (localbfpy.jdField_a_of_type_Int == 1)
      {
        localNearbyAppInterface = this.a;
        NearbyAppInterface.b();
      }
      i += 1;
      if ((i >= 2) || (localbfpy.jdField_a_of_type_Int != 1))
      {
        if ((QLog.isColorLevel()) || (localbfpy.jdField_a_of_type_Int != 0)) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.faceInfo + ",result=" + localbfpy.jdField_a_of_type_Int + ", bmp=" + localbfpy.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        a(localException1, localbfpy);
        this.faceInfo.a(FaceInfo.q);
        try
        {
          sPendingResultList.add(this);
          if (handler == null) {
            continue;
          }
          handler.sendMessageAtFrontOfQueue(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
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
      sPendingResultList.add(this);
      if (handler != null) {
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(EVENT_TASK_COMPLETED, this));
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
  
  public boolean isExpired()
  {
    return this.a == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhw
 * JD-Core Version:    0.7.0.1
 */