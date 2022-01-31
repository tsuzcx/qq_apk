import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgxv
  implements axrt
{
  private bgxw jdField_a_of_type_Bgxw;
  private bgya jdField_a_of_type_Bgya;
  private String jdField_a_of_type_JavaLangString;
  
  public bgxv(bgya parambgya, String paramString, bgxw parambgxw)
  {
    this.jdField_a_of_type_Bgya = parambgya;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bgxw = parambgxw;
  }
  
  public void onResp(axsq paramaxsq)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(bgxu.a(), 2, "onResp url: " + this.jdField_a_of_type_Bgya.c + " resultcode: " + paramaxsq.c);
    }
    this.jdField_a_of_type_Bgya.jdField_d_of_type_Boolean = bgxx.a(this.jdField_a_of_type_Bgya);
    this.jdField_a_of_type_Bgya.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bgxw != null) {
      this.jdField_a_of_type_Bgxw.a(this.jdField_a_of_type_Bgya, this.jdField_a_of_type_Bgya.jdField_d_of_type_Boolean);
    }
    if (paramaxsq.b != 0)
    {
      bhci.a().a(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramaxsq.b, paramaxsq.h, 0L, this.jdField_a_of_type_Bgya.jdField_d_of_type_JavaLangString);
      return;
    }
    if ((paramaxsq.b == 0) && (!this.jdField_a_of_type_Bgya.jdField_d_of_type_Boolean))
    {
      bhci.a().a(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, 1111, paramaxsq.h, 0L, this.jdField_a_of_type_Bgya.jdField_d_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bgya.jdField_e_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bhci.a().a(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramaxsq.b, paramaxsq.h, l1, this.jdField_a_of_type_Bgya.jdField_d_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bgya.b = paramLong2;
    this.jdField_a_of_type_Bgya.jdField_d_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Bgxw != null) {
      this.jdField_a_of_type_Bgxw.a(this.jdField_a_of_type_Bgya, this.jdField_a_of_type_Bgya.jdField_d_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxv
 * JD-Core Version:    0.7.0.1
 */