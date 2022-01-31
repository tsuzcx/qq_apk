import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class apaq
  implements apap, bbmi
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private apao jdField_a_of_type_Apao;
  private bbmg jdField_a_of_type_Bbmg;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private apaq(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static apaq a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new apaq(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbmg != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmg);
      this.jdField_a_of_type_Bbmg = null;
    }
  }
  
  public void a(apao paramapao)
  {
    this.jdField_a_of_type_Apao = paramapao;
  }
  
  public void a(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambbmg1 == this.jdField_a_of_type_Bbmg) {
        break;
      }
      if ((parambbmg1 != null) && (this.jdField_a_of_type_Bbmg != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
        return;
      }
      if (parambbmg1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bbmg == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
    return;
    if (parambbmg2.c() == 200) {
      if (parambbmg2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambbmg2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Apao.a(parambbmg2.f, parambbmg2.d(), parambbmg2.d);
        return;
      }
      parambbmg1 = parambbmg2.a("Range");
      if (parambbmg1 == null)
      {
        this.jdField_a_of_type_Apao.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambbmg1);
      this.jdField_a_of_type_Apao.a(l, parambbmg2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambbmg2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apao.a(paramString);
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bbmg = new bbmg(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bbmg.b(false);
    this.jdField_a_of_type_Bbmg.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bbev.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bbmg.a("Net-type", paramString);
    this.jdField_a_of_type_Bbmg.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bbmg.b("POST");
    this.jdField_a_of_type_Bbmg.b(1);
    this.jdField_a_of_type_Bbmg.b = this.b;
    this.jdField_a_of_type_Bbmg.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bbmg.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmg);
    return true;
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apao.a(parambbmg2.f, parambbmg2.d(), parambbmg2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apaq
 * JD-Core Version:    0.7.0.1
 */