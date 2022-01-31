import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bcwr
  extends FaceDecodeTask
{
  QQAppInterface a;
  
  public bcwr(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, bcwp parambcwp)
  {
    super(paramQQAppInterface, paramFaceInfo, parambcwp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 101) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001)) {
        break label291;
      }
      localalmt = (almt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001) {
        break label119;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = localalmt.a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), false);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        for (;;)
        {
          almt localalmt;
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 113))
          {
            if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString))
            {
              str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
              this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
              {
                i = HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a(BaseApplicationImpl.sApplication.getResources(), i);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, this.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
              }
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
              try
              {
                if (jdField_a_of_type_MqqOsMqqHandler == null) {
                  continue;
                }
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
              catch (Exception localException3) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException3);
              return;
            }
            if (!bclo.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString))
            {
              this.jdField_a_of_type_AndroidGraphicsBitmap = ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, false);
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
              try
              {
                if (jdField_a_of_type_MqqOsMqqHandler == null) {
                  continue;
                }
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
              catch (Exception localException4) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException4);
              return;
            }
          }
          if ((Setting)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int).second != null) {
            break label783;
          }
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler != null)
            {
              jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
          }
          catch (Exception localException5) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException5);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int)) {
        break label939;
      }
      for (bool = true;; bool = false)
      {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_Boolean) {
            break label944;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException6) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException6);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) {
        break label1021;
      }
      localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label1189;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
      bcws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
      for (;;)
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, 100, false, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
          if ((QLog.isColorLevel()) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException7) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException7);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Boolean) && (localException7 != null) && ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32)))
        {
          localanpx = (anpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
          if (localanpx.a(localanpx.b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), (Setting)localException7.second, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
            bcws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler != null)
            {
              jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
          }
          catch (Exception localException8) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException8);
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
    try
    {
      label119:
      String str;
      label291:
      int i;
      label783:
      boolean bool;
      label939:
      label944:
      Pair localPair;
      label1021:
      anpx localanpx;
      label1189:
      if (jdField_a_of_type_MqqOsMqqHandler != null) {
        jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
      }
      throw localObject;
    }
    catch (Exception localException9)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException9);
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwr
 * JD-Core Version:    0.7.0.1
 */