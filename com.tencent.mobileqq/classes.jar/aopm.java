import AvatarInfo.QQHeadInfo;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aopm
  extends FaceDecodeTask
{
  NearbyAppInterface a;
  
  public aopm(NearbyAppInterface paramNearbyAppInterface, FaceInfo paramFaceInfo, aooc paramaooc)
  {
    super(paramNearbyAppInterface, paramFaceInfo, paramaooc);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  private void a(aope paramaope, bhgn parambhgn)
  {
    if (parambhgn.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c)
      {
      }
    }
    for (parambhgn.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.c(parambhgn.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);; parambhgn.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a(parambhgn.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = parambhgn.jdField_a_of_type_AndroidGraphicsBitmap;
      paramaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(), parambhgn.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private boolean a(aope paramaope)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
        paramaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
      }
      return true;
    }
    Object localObject = "stranger_" + Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int) + "_" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString;
    Setting localSetting = paramaope.a((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + (String)localObject + ",faceinfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",setting=" + localSetting);
    }
    if (localSetting != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dwTimestamp > localSetting.headImgTimestamp)
        {
          this.jdField_a_of_type_Boolean = true;
          paramaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Boolean)
        {
          localObject = (aqib)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(180);
          if (((aqib)localObject).a(((aqib)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString), localSetting, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
            }
            this.jdField_a_of_type_Boolean = true;
            paramaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
            return true;
          }
        }
      }
      else if (Math.abs(System.currentTimeMillis() - localSetting.updateTimestamp) > 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte = 1;
        ((aopc)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
      paramaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    return true;
  }
  
  public void a()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap bengin.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.p);
    for (;;)
    {
      try
      {
        aope localaope = (aope)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216);
        if (!localaope.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo))
        {
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
          bool = a(localaope);
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        bhgn localbhgn;
        BitmapFactory.Options localOptions;
        NearbyAppInterface localNearbyAppInterface;
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localOutOfMemoryError);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          b.add(this);
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            continue;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException3) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException3);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          b.add(this);
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            continue;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException4) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException4);
        return;
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
      }
      try
      {
        b.add(this);
        if (jdField_a_of_type_MqqOsMqqHandler != null) {
          jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
        }
        return;
        bool = false;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException1);
        return;
      }
      localbhgn = new bhgn();
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = aooa.a;
      bhgm.a(localException1.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo), localOptions, localbhgn);
      if (localbhgn.jdField_a_of_type_Int == 1)
      {
        localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        NearbyAppInterface.b();
      }
      i += 1;
      if ((i >= 2) || (localbhgn.jdField_a_of_type_Int != 1))
      {
        if ((QLog.isColorLevel()) || (localbhgn.jdField_a_of_type_Int != 0)) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",result=" + localbhgn.jdField_a_of_type_Int + ", bmp=" + localbhgn.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        a(localException1, localbhgn);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          b.add(this);
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            continue;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException2) {}
        if (QLog.isColorLevel())
        {
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException2);
          return;
        }
      }
    }
    try
    {
      b.add(this);
      if (jdField_a_of_type_MqqOsMqqHandler != null) {
        jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
      }
      throw localObject;
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException5);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopm
 * JD-Core Version:    0.7.0.1
 */