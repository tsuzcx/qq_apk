import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;

public class aujs
{
  public int a;
  public long a;
  private Cryptor jdField_a_of_type_ComTencentQphoneBaseUtilCryptor;
  public String a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  public long b;
  public String b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  public String c;
  private int d;
  private int e;
  
  public aujs(aujr paramaujr)
  {
    this.jdField_a_of_type_JavaLangString = paramaujr.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramaujr.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramaujr.jdField_a_of_type_Int;
    this.d = paramaujr.jdField_b_of_type_Int;
    this.e = paramaujr.jdField_c_of_type_Int;
    if (paramaujr.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = paramaujr.d;
      this.jdField_a_of_type_ArrayOfByte = a(paramaujr.jdField_c_of_type_Long);
      this.jdField_b_of_type_Long = paramaujr.jdField_b_of_type_Long;
      this.jdField_b_of_type_ArrayOfByte = a(paramaujr.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Long = paramaujr.jdField_b_of_type_Long;
    this.jdField_a_of_type_ArrayOfByte = a(paramaujr.jdField_a_of_type_Long);
  }
  
  private byte[] a(long paramLong)
  {
    for (Object localObject = this.jdField_a_of_type_JavaLangString; ((String)localObject).length() < 16; localObject = (String)localObject + (String)localObject) {}
    byte[] arrayOfByte1 = ((String)localObject).getBytes();
    byte[] arrayOfByte2 = String.valueOf(paramLong).getBytes();
    if (arrayOfByte1.length > arrayOfByte2.length) {}
    for (localObject = arrayOfByte1;; localObject = arrayOfByte2)
    {
      int i = 0;
      while (i < Math.min(arrayOfByte1.length, arrayOfByte2.length))
      {
        localObject[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[i]));
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor == null)
    {
      this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor = new Cryptor();
      this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.enableResultRandom(false);
    }
    return localObject;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = bbea.a(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.encrypt(paramString.getBytes(), this.jdField_a_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("OpenApi.App", 2, "encrypt", localException);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = (this.d & paramInt1);
    this.jdField_c_of_type_Int = (this.e & paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Int & paramInt) > 0;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return ((this.e & paramInt1) > 0) && ((this.d & paramInt2) > 0);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = bbea.a(paramString);
      paramString = new String(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.decrypt(paramString, this.jdField_a_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decrypt", paramString);
      }
    }
    return null;
  }
  
  public boolean b(int paramInt)
  {
    return ((this.jdField_c_of_type_Int & paramInt) > 0) && ((this.jdField_b_of_type_Int & 0x40000000) > 0);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return ((this.jdField_c_of_type_Int & paramInt1) > 0) && ((this.jdField_b_of_type_Int & paramInt2) > 0);
  }
  
  public String c(String paramString)
  {
    try
    {
      paramString = bbea.a(paramString);
      paramString = new String(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.decrypt(paramString, this.jdField_b_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decryptLastData", paramString);
      }
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    return (this.e & paramInt) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujs
 * JD-Core Version:    0.7.0.1
 */