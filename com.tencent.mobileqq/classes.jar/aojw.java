import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class aojw
  implements aojv, baky
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private aoju jdField_a_of_type_Aoju;
  private bakw jdField_a_of_type_Bakw;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private aojw(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static aojw a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new aojw(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bakw != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bakw);
      this.jdField_a_of_type_Bakw = null;
    }
  }
  
  public void a(aoju paramaoju)
  {
    this.jdField_a_of_type_Aoju = paramaoju;
  }
  
  public void a(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambakw1 == this.jdField_a_of_type_Bakw) {
        break;
      }
      if ((parambakw1 != null) && (this.jdField_a_of_type_Bakw != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambakw1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bakw.a()) + "]");
        return;
      }
      if (parambakw1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambakw1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bakw == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bakw.a()) + "]");
    return;
    if (parambakw2.c() == 200) {
      if (parambakw2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambakw2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Aoju.a(parambakw2.f, parambakw2.d(), parambakw2.d);
        return;
      }
      parambakw1 = parambakw2.a("Range");
      if (parambakw1 == null)
      {
        this.jdField_a_of_type_Aoju.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambakw1);
      this.jdField_a_of_type_Aoju.a(l, parambakw2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambakw2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aoju.a(paramString);
  }
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bakw = new bakw(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bakw.b(false);
    this.jdField_a_of_type_Bakw.a("cache-control", "no-cache");
    paramString = "gprs";
    if (badq.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bakw.a("Net-type", paramString);
    this.jdField_a_of_type_Bakw.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bakw.b("POST");
    this.jdField_a_of_type_Bakw.b(1);
    this.jdField_a_of_type_Bakw.b = this.b;
    this.jdField_a_of_type_Bakw.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bakw.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bakw);
    return true;
  }
  
  public void b(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aoju.a(parambakw2.f, parambakw2.d(), parambakw2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aojw
 * JD-Core Version:    0.7.0.1
 */