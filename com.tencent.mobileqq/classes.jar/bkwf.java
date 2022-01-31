import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bkwf
  implements bapx
{
  private bkvu jdField_a_of_type_Bkvu;
  private bkwg jdField_a_of_type_Bkwg;
  private String jdField_a_of_type_JavaLangString;
  
  public bkwf(bkvu parambkvu, String paramString, bkwg parambkwg)
  {
    this.jdField_a_of_type_Bkvu = parambkvu;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bkwg = parambkwg;
  }
  
  public void onResp(baqw parambaqw)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(bkwe.a(), 2, "onResp url: " + this.jdField_a_of_type_Bkvu.jdField_d_of_type_JavaLangString + " resultcode: " + parambaqw.c);
    }
    if ((this.jdField_a_of_type_Bkvu instanceof bkwa)) {
      bkpy.a((bkwa)this.jdField_a_of_type_Bkvu);
    }
    for (this.jdField_a_of_type_Bkvu.jdField_d_of_type_Boolean = true;; this.jdField_a_of_type_Bkvu.jdField_d_of_type_Boolean = bkvr.a(this.jdField_a_of_type_Bkvu))
    {
      this.jdField_a_of_type_Bkvu.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bkwg != null) {
        this.jdField_a_of_type_Bkwg.a(this.jdField_a_of_type_Bkvu, this.jdField_a_of_type_Bkvu.jdField_d_of_type_Boolean);
      }
      if (parambaqw.b == 0) {
        break;
      }
      blen.a().a(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, parambaqw.b, parambaqw.h, 0L, this.jdField_a_of_type_Bkvu.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((parambaqw.b == 0) && (!this.jdField_a_of_type_Bkvu.jdField_d_of_type_Boolean))
    {
      blen.a().a(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, 1111, parambaqw.h, 0L, this.jdField_a_of_type_Bkvu.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bkvu.f);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    blen.a().a(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, parambaqw.b, parambaqw.h, l1, this.jdField_a_of_type_Bkvu.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bkvu.b = paramLong2;
    this.jdField_a_of_type_Bkvu.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Bkwg != null) {
      this.jdField_a_of_type_Bkwg.a(this.jdField_a_of_type_Bkvu, this.jdField_a_of_type_Bkvu.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwf
 * JD-Core Version:    0.7.0.1
 */