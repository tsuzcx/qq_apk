import com.tencent.qphone.base.util.QLog;
import java.io.File;

class biro
  implements aysc
{
  private bire jdField_a_of_type_Bire;
  private birp jdField_a_of_type_Birp;
  private String jdField_a_of_type_JavaLangString;
  
  public biro(bire parambire, String paramString, birp parambirp)
  {
    this.jdField_a_of_type_Bire = parambire;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Birp = parambirp;
  }
  
  public void onResp(aysz paramaysz)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(birn.a(), 2, "onResp url: " + this.jdField_a_of_type_Bire.jdField_d_of_type_JavaLangString + " resultcode: " + paramaysz.c);
    }
    if ((this.jdField_a_of_type_Bire instanceof birk)) {
      bilj.a((birk)this.jdField_a_of_type_Bire);
    }
    for (this.jdField_a_of_type_Bire.jdField_d_of_type_Boolean = true;; this.jdField_a_of_type_Bire.jdField_d_of_type_Boolean = birb.a(this.jdField_a_of_type_Bire))
    {
      this.jdField_a_of_type_Bire.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Birp != null) {
        this.jdField_a_of_type_Birp.a(this.jdField_a_of_type_Bire, this.jdField_a_of_type_Bire.jdField_d_of_type_Boolean);
      }
      if (paramaysz.b == 0) {
        break;
      }
      bizt.a().a(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, paramaysz.b, paramaysz.h, 0L, this.jdField_a_of_type_Bire.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((paramaysz.b == 0) && (!this.jdField_a_of_type_Bire.jdField_d_of_type_Boolean))
    {
      bizt.a().a(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, 1111, paramaysz.h, 0L, this.jdField_a_of_type_Bire.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bire.f);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bizt.a().a(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, paramaysz.b, paramaysz.h, l1, this.jdField_a_of_type_Bire.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bire.b = paramLong2;
    this.jdField_a_of_type_Bire.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Birp != null) {
      this.jdField_a_of_type_Birp.a(this.jdField_a_of_type_Bire, this.jdField_a_of_type_Bire.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biro
 * JD-Core Version:    0.7.0.1
 */