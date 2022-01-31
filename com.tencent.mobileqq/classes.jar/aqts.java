import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class aqts
  implements aqtr, bdlq
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private aqtq jdField_a_of_type_Aqtq;
  private bdlo jdField_a_of_type_Bdlo;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private aqts(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static aqts a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new aqts(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdlo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdlo);
      this.jdField_a_of_type_Bdlo = null;
    }
  }
  
  public void a(aqtq paramaqtq)
  {
    this.jdField_a_of_type_Aqtq = paramaqtq;
  }
  
  public void a(bdlo parambdlo1, bdlo parambdlo2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambdlo1 == this.jdField_a_of_type_Bdlo) {
        break;
      }
      if ((parambdlo1 != null) && (this.jdField_a_of_type_Bdlo != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdlo1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdlo.a()) + "]");
        return;
      }
      if (parambdlo1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdlo1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bdlo == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdlo.a()) + "]");
    return;
    if (parambdlo2.c() == 200) {
      if (parambdlo2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambdlo2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Aqtq.a(parambdlo2.f, parambdlo2.d(), parambdlo2.d);
        return;
      }
      parambdlo1 = parambdlo2.a("Range");
      if (parambdlo1 == null)
      {
        this.jdField_a_of_type_Aqtq.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambdlo1);
      this.jdField_a_of_type_Aqtq.a(l, parambdlo2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambdlo2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aqtq.a(paramString);
  }
  
  public boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bdlo = new bdlo(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bdlo.b(false);
    this.jdField_a_of_type_Bdlo.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bdee.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bdlo.a("Net-type", paramString);
    this.jdField_a_of_type_Bdlo.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bdlo.b("POST");
    this.jdField_a_of_type_Bdlo.b(1);
    this.jdField_a_of_type_Bdlo.b = this.b;
    this.jdField_a_of_type_Bdlo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bdlo.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdlo);
    return true;
  }
  
  public void b(bdlo parambdlo1, bdlo parambdlo2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aqtq.a(parambdlo2.f, parambdlo2.d(), parambdlo2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */