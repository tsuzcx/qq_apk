import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class atwk
  implements atvx, bhvc
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private atvw jdField_a_of_type_Atvw;
  private bhva jdField_a_of_type_Bhva;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private atwk(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static atwk a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new atwk(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bhva != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(this.jdField_a_of_type_Bhva);
      this.jdField_a_of_type_Bhva = null;
    }
  }
  
  public void a(atvw paramatvw)
  {
    this.jdField_a_of_type_Atvw = paramatvw;
  }
  
  public void a(bhva parambhva1, bhva parambhva2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambhva1 == this.jdField_a_of_type_Bhva) {
        break;
      }
      if ((parambhva1 != null) && (this.jdField_a_of_type_Bhva != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambhva1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bhva.a()) + "]");
        return;
      }
      if (parambhva1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambhva1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bhva == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bhva.a()) + "]");
    return;
    if (parambhva2.c() == 200) {
      if (parambhva2.a("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(parambhva2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Atvw.a(parambhva2.f, parambhva2.d(), parambhva2.d);
        return;
      }
      parambhva1 = parambhva2.a("Range");
      if (parambhva1 == null)
      {
        this.jdField_a_of_type_Atvw.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(parambhva1);
      this.jdField_a_of_type_Atvw.a(l, parambhva2.d);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambhva2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atvw.a(paramString);
  }
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bhva = new bhva(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_Bhva.b(false);
    this.jdField_a_of_type_Bhva.a("cache-control", "no-cache");
    paramString = "gprs";
    if (bhnv.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_Bhva.a("Net-type", paramString);
    this.jdField_a_of_type_Bhva.a("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_Bhva.b("POST");
    this.jdField_a_of_type_Bhva.b(1);
    this.jdField_a_of_type_Bhva.b = this.b;
    this.jdField_a_of_type_Bhva.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bhva.a = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bhva);
    return true;
  }
  
  public void b(bhva parambhva1, bhva parambhva2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atvw.a(parambhva2.f, parambhva2.d(), parambhva2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwk
 * JD-Core Version:    0.7.0.1
 */