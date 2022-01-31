import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class aqyb
  implements aqya, bdpz
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private aqxz jdField_a_of_type_Aqxz;
  private bdpx jdField_a_of_type_Bdpx;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private aqyb(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static aqyb a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new aqyb(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdpx != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdpx);
      this.jdField_a_of_type_Bdpx = null;
    }
  }
  
  public void a(aqxz paramaqxz)
  {
    this.jdField_a_of_type_Aqxz = paramaqxz;
  }
  
  public void a(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambdpx1 == this.jdField_a_of_type_Bdpx) {
        break;
      }
      if ((parambdpx1 != null) && (this.jdField_a_of_type_Bdpx != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
        return;
      }
      if (parambdpx1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bdpx == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
    return;
    if (parambdpx2.c() == 200) {
      if (parambdpx2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambdpx2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Aqxz.a(parambdpx2.f, parambdpx2.d(), parambdpx2.d);
        return;
      }
      parambdpx1 = parambdpx2.a("Range");
      if (parambdpx1 == null)
      {
        this.jdField_a_of_type_Aqxz.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambdpx1);
      this.jdField_a_of_type_Aqxz.a(l, parambdpx2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambdpx2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aqxz.a(paramString);
  }
  
  public boolean a(bdpx parambdpx1, bdpx parambdpx2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bdpx = new bdpx(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bdpx.b(false);
    this.jdField_a_of_type_Bdpx.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bdin.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bdpx.a("Net-type", paramString);
    this.jdField_a_of_type_Bdpx.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bdpx.b("POST");
    this.jdField_a_of_type_Bdpx.b(1);
    this.jdField_a_of_type_Bdpx.b = this.b;
    this.jdField_a_of_type_Bdpx.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bdpx.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdpx);
    return true;
  }
  
  public void b(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aqxz.a(parambdpx2.f, parambdpx2.d(), parambdpx2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyb
 * JD-Core Version:    0.7.0.1
 */