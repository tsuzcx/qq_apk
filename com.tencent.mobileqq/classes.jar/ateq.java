import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class ateq
  implements ated, bguz
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private atec jdField_a_of_type_Atec;
  private bgux jdField_a_of_type_Bgux;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private ateq(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static ateq a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new ateq(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bgux != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(this.jdField_a_of_type_Bgux);
      this.jdField_a_of_type_Bgux = null;
    }
  }
  
  public void a(atec paramatec)
  {
    this.jdField_a_of_type_Atec = paramatec;
  }
  
  public void a(bgux parambgux1, bgux parambgux2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambgux1 == this.jdField_a_of_type_Bgux) {
        break;
      }
      if ((parambgux1 != null) && (this.jdField_a_of_type_Bgux != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambgux1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bgux.a()) + "]");
        return;
      }
      if (parambgux1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambgux1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bgux == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bgux.a()) + "]");
    return;
    if (parambgux2.c() == 200) {
      if (parambgux2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambgux2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Atec.a(parambgux2.f, parambgux2.d(), parambgux2.d);
        return;
      }
      parambgux1 = parambgux2.a("Range");
      if (parambgux1 == null)
      {
        this.jdField_a_of_type_Atec.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambgux1);
      this.jdField_a_of_type_Atec.a(l, parambgux2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambgux2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atec.a(paramString);
  }
  
  public boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bgux = new bgux(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bgux.b(false);
    this.jdField_a_of_type_Bgux.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bgnt.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bgux.a("Net-type", paramString);
    this.jdField_a_of_type_Bgux.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bgux.b("POST");
    this.jdField_a_of_type_Bgux.b(1);
    this.jdField_a_of_type_Bgux.b = this.b;
    this.jdField_a_of_type_Bgux.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bgux.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bgux);
    return true;
  }
  
  public void b(bgux parambgux1, bgux parambgux2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atec.a(parambgux2.f, parambgux2.d(), parambgux2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ateq
 * JD-Core Version:    0.7.0.1
 */