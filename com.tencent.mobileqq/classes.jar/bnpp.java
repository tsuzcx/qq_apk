import com.tencent.qphone.base.util.QLog;

final class bnpp
  implements baug
{
  bnpp(String paramString1, String paramString2, bnpq parambnpq) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bnpo.b(), 2, "onResp resultcode: " + parambavf.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((parambavf.c == 200) && (bnpo.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bnpq != null) {
        this.jdField_a_of_type_Bnpq.a();
      }
    }
    while (this.jdField_a_of_type_Bnpq == null) {
      return;
    }
    this.jdField_a_of_type_Bnpq.b();
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnpq != null) {
      this.jdField_a_of_type_Bnpq.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpp
 * JD-Core Version:    0.7.0.1
 */