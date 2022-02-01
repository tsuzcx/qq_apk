import com.tencent.qphone.base.util.QLog;
import java.io.File;

class borb
  implements beuq
{
  private boqu jdField_a_of_type_Boqu;
  private borc jdField_a_of_type_Borc;
  private String jdField_a_of_type_JavaLangString;
  
  public borb(boqu paramboqu, String paramString, borc paramborc)
  {
    this.jdField_a_of_type_Boqu = paramboqu;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Borc = paramborc;
  }
  
  public void onResp(bevm parambevm)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(bora.a(), 2, "onResp url: " + this.jdField_a_of_type_Boqu.d + " resultcode: " + parambevm.c);
    }
    if ((this.jdField_a_of_type_Boqu instanceof boqx)) {
      bokt.a((boqx)this.jdField_a_of_type_Boqu);
    }
    for (this.jdField_a_of_type_Boqu.jdField_e_of_type_Boolean = true;; this.jdField_a_of_type_Boqu.jdField_e_of_type_Boolean = boqr.a(this.jdField_a_of_type_Boqu))
    {
      this.jdField_a_of_type_Boqu.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Borc != null) {
        this.jdField_a_of_type_Borc.a(this.jdField_a_of_type_Boqu, this.jdField_a_of_type_Boqu.jdField_e_of_type_Boolean);
      }
      if (parambevm.b == 0) {
        break;
      }
      bozr.a().a(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambevm.b, parambevm.g, 0L, this.jdField_a_of_type_Boqu.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((parambevm.b == 0) && (!this.jdField_a_of_type_Boqu.jdField_e_of_type_Boolean))
    {
      bozr.a().a(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, 1111, parambevm.g, 0L, this.jdField_a_of_type_Boqu.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boqu.jdField_f_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bozr.a().a(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambevm.b, parambevm.g, l1, this.jdField_a_of_type_Boqu.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Boqu.b = paramLong2;
    this.jdField_a_of_type_Boqu.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Borc != null) {
      this.jdField_a_of_type_Borc.a(this.jdField_a_of_type_Boqu, this.jdField_a_of_type_Boqu.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borb
 * JD-Core Version:    0.7.0.1
 */