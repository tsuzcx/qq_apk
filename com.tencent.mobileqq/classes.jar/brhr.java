import com.tencent.qphone.base.util.QLog;

final class brhr
  implements beuq
{
  brhr(String paramString1, String paramString2, brhs parambrhs) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i(brhq.b(), 2, "onResp resultcode: " + parambevm.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((parambevm.c == 200) && (brhq.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Brhs != null) {
        this.jdField_a_of_type_Brhs.a();
      }
    }
    while (this.jdField_a_of_type_Brhs == null) {
      return;
    }
    this.jdField_a_of_type_Brhs.b();
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Brhs != null) {
      this.jdField_a_of_type_Brhs.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhr
 * JD-Core Version:    0.7.0.1
 */