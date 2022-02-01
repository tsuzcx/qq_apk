import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aobt
  extends FaceDecodeTask
{
  QQAppInterface a;
  
  public aobt(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, aobr paramaobr)
  {
    super(paramQQAppInterface, paramFaceInfo, paramaobr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.p);
    for (;;)
    {
      try
      {
        boolean bool = b();
        if (!bool) {
          continue;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Pair localPair;
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localOutOfMemoryError);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            continue;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException3);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            continue;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException4)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException4);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
      }
      try
      {
        if (jdField_a_of_type_MqqOsMqqHandler != null) {
          jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException1);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int != 101)
    {
      localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label326;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte = 1;
      aobu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c, 100, false, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(), this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int);
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a(FaceInfo.q);
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler == null) {
            break;
          }
          jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException2);
          return;
        }
      }
      label326:
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Boolean) && (localException2 != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 32)))
      {
        apul localapul = (apul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
        if (localapul.a(localapul.b(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString), (Setting)localException2.second, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte = 1;
          aobu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
        }
      }
    }
    try
    {
      if (jdField_a_of_type_MqqOsMqqHandler != null) {
        jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
      }
      throw localObject;
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, localException5);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l);
  }
  
  public boolean b()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (anks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((anks)localObject).a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString), false);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    label244:
    do
    {
      do
      {
        return true;
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((anks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, false);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int != 113)) {
          break label291;
        }
        if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString)) {
          break label244;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
      } while (this.jdField_a_of_type_AndroidGraphicsBitmap != null);
      int i = HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a(BaseApplicationImpl.sApplication.getResources(), i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
      return true;
      if (!bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, false);
        this.jdField_a_of_type_Boolean = false;
        return true;
      }
      if ((Setting)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int).second != null) {
        break label372;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    label291:
    QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.toString());
    return true;
    label372:
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label461;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.toString());
      return true;
    }
    label461:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobt
 * JD-Core Version:    0.7.0.1
 */