import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public abstract class bfih
{
  int jdField_a_of_type_Int;
  bfie jdField_a_of_type_Bfie;
  protected ITransactionCallback a;
  protected Transaction a;
  public String a;
  protected boolean a;
  protected String b;
  
  public bfih(bfie parambfie, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback = new bfii(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_Bfie = parambfie;
  }
  
  protected QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public abstract void a();
  
  protected boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadPic path= " + paramString);
    }
    ITransactionCallback localITransactionCallback = this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback;
    QQAppInterface localQQAppInterface = a();
    String str;
    byte[] arrayOfByte;
    if (localQQAppInterface != null)
    {
      str = localQQAppInterface.getCurrentUin();
      arrayOfByte = aofs.a(paramString);
      if (arrayOfByte != null) {
        break label83;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadPic md5 null ");
      }
    }
    label83:
    int i;
    do
    {
      return false;
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramString = new Transaction(str, 75, paramString, 0, arrayOfByte, localITransactionCallback, localCommFileExtReq.toByteArray(), false);
      i = localQQAppInterface.getHwEngine().submitTransactionTask(paramString);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = paramString;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadPic submitTransactionTask  retCode= " + i);
    return false;
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onFailed ");
    }
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfih
 * JD-Core Version:    0.7.0.1
 */