import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bnpp
  implements bdvw
{
  private bnpf jdField_a_of_type_Bnpf;
  private bnpq jdField_a_of_type_Bnpq;
  private String jdField_a_of_type_JavaLangString;
  
  public bnpp(bnpf parambnpf, String paramString, bnpq parambnpq)
  {
    this.jdField_a_of_type_Bnpf = parambnpf;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bnpq = parambnpq;
  }
  
  public void onResp(bdwt parambdwt)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.i(bnpo.a(), 2, "onResp url: " + this.jdField_a_of_type_Bnpf.d + " resultcode: " + parambdwt.c);
    }
    if ((this.jdField_a_of_type_Bnpf instanceof bnpl)) {
      bnjj.a((bnpl)this.jdField_a_of_type_Bnpf);
    }
    for (this.jdField_a_of_type_Bnpf.jdField_e_of_type_Boolean = true;; this.jdField_a_of_type_Bnpf.jdField_e_of_type_Boolean = bnpc.a(this.jdField_a_of_type_Bnpf))
    {
      this.jdField_a_of_type_Bnpf.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bnpq != null) {
        this.jdField_a_of_type_Bnpq.a(this.jdField_a_of_type_Bnpf, this.jdField_a_of_type_Bnpf.jdField_e_of_type_Boolean);
      }
      if (parambdwt.b == 0) {
        break;
      }
      bnyh.a().a(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambdwt.b, parambdwt.g, 0L, this.jdField_a_of_type_Bnpf.jdField_e_of_type_JavaLangString);
      return;
    }
    if ((parambdwt.b == 0) && (!this.jdField_a_of_type_Bnpf.jdField_e_of_type_Boolean))
    {
      bnyh.a().a(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, 1111, parambdwt.g, 0L, this.jdField_a_of_type_Bnpf.jdField_e_of_type_JavaLangString);
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bnpf.jdField_f_of_type_JavaLangString);
    long l1 = l2;
    if (localFile.exists())
    {
      l1 = l2;
      if (localFile.isFile()) {
        l1 = localFile.length();
      }
    }
    bnyh.a().a(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambdwt.b, parambdwt.g, l1, this.jdField_a_of_type_Bnpf.jdField_e_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bnpf.b = paramLong2;
    this.jdField_a_of_type_Bnpf.jdField_e_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    if (this.jdField_a_of_type_Bnpq != null) {
      this.jdField_a_of_type_Bnpq.a(this.jdField_a_of_type_Bnpf, this.jdField_a_of_type_Bnpf.jdField_e_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpp
 * JD-Core Version:    0.7.0.1
 */