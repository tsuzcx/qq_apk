import com.tencent.qphone.base.util.QLog;
import java.io.File;

class biqx
  implements aysa
{
  private biqn jdField_a_of_type_Biqn;
  private biqy jdField_a_of_type_Biqy;
  private String jdField_a_of_type_JavaLangString;
  
  public biqx(biqn parambiqn, String paramString, biqy parambiqy)
  {
    this.jdField_a_of_type_Biqn = parambiqn;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Biqy = parambiqy;
  }
  
  public void onResp(aysx paramaysx)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(biqw.a(), 2, "onResp url: " + this.jdField_a_of_type_Biqn.jdField_d_of_type_JavaLangString + " resultcode: " + paramaysx.c);
    }
    if ((this.jdField_a_of_type_Biqn instanceof biqt)) {
      biks.a((biqt)this.jdField_a_of_type_Biqn);
    }
    for (this.jdField_a_of_type_Biqn.jdField_d_of_type_Boolean = true;; this.jdField_a_of_type_Biqn.jdField_d_of_type_Boolean = biqk.a(this.jdField_a_of_type_Biqn))
    {
      this.jdField_a_of_type_Biqn.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Biqy != null) {
        this.jdField_a_of_type_Biqy.a(this.jdField_a_of_type_Biqn, this.jdField_a_of_type_Biqn.jdField_d_of_type_Boolean);
      }
      if (paramaysx.b == 0) {
        break;
      }
      bizc.a().a(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, paramaysx.b, paramaysx.h, 0L, this.jdField_a_of_type_Biqn.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((paramaysx.b == 0) && (!this.jdField_a_of_type_Biqn.jdField_d_of_type_Boolean))
    {
      bizc.a().a(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, 1111, paramaysx.h, 0L, this.jdField_a_of_type_Biqn.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Biqn.f);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bizc.a().a(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, paramaysx.b, paramaysx.h, l1, this.jdField_a_of_type_Biqn.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Biqn.b = paramLong2;
    this.jdField_a_of_type_Biqn.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Biqy != null) {
      this.jdField_a_of_type_Biqy.a(this.jdField_a_of_type_Biqn, this.jdField_a_of_type_Biqn.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqx
 * JD-Core Version:    0.7.0.1
 */