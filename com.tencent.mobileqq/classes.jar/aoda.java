import AvatarInfo.QQHeadInfo;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aoda
  extends FaceDecodeTask
{
  NearbyAppInterface a;
  
  public aoda(NearbyAppInterface paramNearbyAppInterface, FaceInfo paramFaceInfo, aobr paramaobr)
  {
    super(paramNearbyAppInterface, paramFaceInfo, paramaobr);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap bengin.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.p);
    do
    {
      for (;;)
      {
        try
        {
          aocs localaocs = (aocs)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216);
          if (!localaocs.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo))
          {
            bool = true;
            this.jdField_a_of_type_Boolean = bool;
            if (!this.jdField_a_of_type_Boolean) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
              localaocs.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          boolean bool;
          Object localObject3;
          Object localObject2;
          int i;
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
          catch (Exception localException6) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException6);
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
          catch (Exception localException7) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException7);
          return;
        }
        finally
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
          try
          {
            b.add(this);
            if (jdField_a_of_type_MqqOsMqqHandler != null) {
              jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            }
            throw localObject1;
          }
          catch (Exception localException8)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException8);
            continue;
          }
          continue;
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
        localObject3 = "stranger_" + Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int) + "_" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString;
        localObject2 = localException1.a((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + (String)localObject3 + ",faceinfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",setting=" + localObject2);
        }
        if (localObject2 == null) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dwTimestamp > ((Setting)localObject2).headImgTimestamp)
        {
          this.jdField_a_of_type_Boolean = true;
          localException1.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
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
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException2);
          }
        }
        else
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Boolean) {
            continue;
          }
          localObject3 = (apul)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(180);
          if (!((apul)localObject3).a(((apul)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString), (Setting)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
          }
          this.jdField_a_of_type_Boolean = true;
          localException2.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
          try
          {
            b.add(this);
            if (jdField_a_of_type_MqqOsMqqHandler != null)
            {
              jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
          }
          catch (Exception localException3) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException3);
    return;
    if (Math.abs(System.currentTimeMillis() - ((Setting)localObject2).updateTimestamp) > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte = 1;
      ((aocq)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    localObject2 = new bggm();
    localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inPreferredConfig = aobp.a;
    i = 0;
    do
    {
      bggl.a(localException3.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo), (BitmapFactory.Options)localObject3, (bggm)localObject2);
      if (((bggm)localObject2).jdField_a_of_type_Int == 1)
      {
        NearbyAppInterface localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        NearbyAppInterface.b();
      }
      i += 1;
    } while ((i < 2) && (((bggm)localObject2).jdField_a_of_type_Int == 1));
    if ((QLog.isColorLevel()) || (((bggm)localObject2).jdField_a_of_type_Int != 0)) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",result=" + ((bggm)localObject2).jdField_a_of_type_Int + ", bmp=" + ((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    switch (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c)
    {
    case 2: 
    case 1: 
    case 3: 
      for (((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = bgmo.c(((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);; ((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a(((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, 50, 50))
      {
        for (;;)
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = ((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
            localException3.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(), ((bggm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
            try
            {
              b.add(this);
              if (jdField_a_of_type_MqqOsMqqHandler == null) {
                break;
              }
              jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException4);
          return;
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo != null) {
            localException4.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
          try
          {
            b.add(this);
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessageAtFrontOfQueue(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException5) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException5);
        return;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoda
 * JD-Core Version:    0.7.0.1
 */