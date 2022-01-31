import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class apau
  implements apat, bbmw
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private apas jdField_a_of_type_Apas;
  private bbmu jdField_a_of_type_Bbmu;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private apau(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static apau a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new apau(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbmu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmu);
      this.jdField_a_of_type_Bbmu = null;
    }
  }
  
  public void a(apas paramapas)
  {
    this.jdField_a_of_type_Apas = paramapas;
  }
  
  public void a(bbmu parambbmu1, bbmu parambbmu2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambbmu1 == this.jdField_a_of_type_Bbmu) {
        break;
      }
      if ((parambbmu1 != null) && (this.jdField_a_of_type_Bbmu != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmu1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmu.a()) + "]");
        return;
      }
      if (parambbmu1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmu1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bbmu == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmu.a()) + "]");
    return;
    if (parambbmu2.c() == 200) {
      if (parambbmu2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambbmu2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Apas.a(parambbmu2.f, parambbmu2.d(), parambbmu2.d);
        return;
      }
      parambbmu1 = parambbmu2.a("Range");
      if (parambbmu1 == null)
      {
        this.jdField_a_of_type_Apas.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambbmu1);
      this.jdField_a_of_type_Apas.a(l, parambbmu2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambbmu2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apas.a(paramString);
  }
  
  public boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bbmu = new bbmu(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bbmu.b(false);
    this.jdField_a_of_type_Bbmu.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bbfj.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bbmu.a("Net-type", paramString);
    this.jdField_a_of_type_Bbmu.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bbmu.b("POST");
    this.jdField_a_of_type_Bbmu.b(1);
    this.jdField_a_of_type_Bbmu.b = this.b;
    this.jdField_a_of_type_Bbmu.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bbmu.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmu);
    return true;
  }
  
  public void b(bbmu parambbmu1, bbmu parambbmu2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apas.a(parambbmu2.f, parambbmu2.d(), parambbmu2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apau
 * JD-Core Version:    0.7.0.1
 */