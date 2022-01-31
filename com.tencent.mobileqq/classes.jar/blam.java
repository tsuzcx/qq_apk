import com.tencent.qphone.base.util.QLog;
import java.io.File;

class blam
  implements baug
{
  private blab jdField_a_of_type_Blab;
  private blan jdField_a_of_type_Blan;
  private String jdField_a_of_type_JavaLangString;
  
  public blam(blab paramblab, String paramString, blan paramblan)
  {
    this.jdField_a_of_type_Blab = paramblab;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Blan = paramblan;
  }
  
  public void onResp(bavf parambavf)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(blal.a(), 2, "onResp url: " + this.jdField_a_of_type_Blab.jdField_d_of_type_JavaLangString + " resultcode: " + parambavf.c);
    }
    if ((this.jdField_a_of_type_Blab instanceof blah)) {
      bkuf.a((blah)this.jdField_a_of_type_Blab);
    }
    for (this.jdField_a_of_type_Blab.jdField_d_of_type_Boolean = true;; this.jdField_a_of_type_Blab.jdField_d_of_type_Boolean = bkzy.a(this.jdField_a_of_type_Blab))
    {
      this.jdField_a_of_type_Blab.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Blan != null) {
        this.jdField_a_of_type_Blan.a(this.jdField_a_of_type_Blab, this.jdField_a_of_type_Blab.jdField_d_of_type_Boolean);
      }
      if (parambavf.b == 0) {
        break;
      }
      bliu.a().a(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, parambavf.b, parambavf.h, 0L, this.jdField_a_of_type_Blab.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((parambavf.b == 0) && (!this.jdField_a_of_type_Blab.jdField_d_of_type_Boolean))
    {
      bliu.a().a(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, 1111, parambavf.h, 0L, this.jdField_a_of_type_Blab.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Blab.f);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bliu.a().a(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, parambavf.b, parambavf.h, l1, this.jdField_a_of_type_Blab.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Blab.b = paramLong2;
    this.jdField_a_of_type_Blab.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Blan != null) {
      this.jdField_a_of_type_Blan.a(this.jdField_a_of_type_Blab, this.jdField_a_of_type_Blab.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blam
 * JD-Core Version:    0.7.0.1
 */